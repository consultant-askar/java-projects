let itemsContainer = document.getElementById("items-container");
let user;
let items;

window.addEventListener("load", async () => {
    
    let response = await fetch("http://localhost:9000/api/session");
    
    let responseBody = await response.json();
    
    if(!responseBody.successful){
        window.location = "../";
    }

    user = responseBody.data;

    items = await getAllItems();
    displayItems();
});


async function getAllItems(){
    let response = await fetch("http://localhost:9000/api/item");

    let responseBody = await response.json();

    return responseBody.data;
}


let logoutBtn = document.getElementById("logout-btn");
logoutBtn.addEventListener("click", () => {
    fetch("http://localhost:9000/api/session", { method: "DELETE" });
    window.location = "../";
});



function displayItems(){
    

    items.forEach(item => {
        let itemElem = document.createElement("div");
        itemElem.className = "item";
        itemElem.id = `item-${item.id}`;

        let itemNameContElem = document.createElement("div");
        itemNameContElem.className = "item-name-container";

        let itemNameElem = document.createElement("div");
        itemNameElem.className = "item-name";      
        itemNameElem.innerText = `${item.amount} ${item.date} ${item.description}`;  
        console.log(item);

        //mark items in cart
        if(item.inCart){
            itemNameElem.style.textDecoration = "line-through";
        }

        //if name is clicked, send http request for marking item in cart
        itemNameElem.addEventListener("click", async () => {
            await fetch(`http://localhost:9000/api/item/${item.id}`, {
                method: "PATCH"
            });
            
            itemNameElem.style.textDecoration = "line-through";
        })

        let deleteBtnElem = document.createElement("button");
        deleteBtnElem.className = "btn btn-danger";
        deleteBtnElem.innerText = "Delete";

        deleteBtnElem.addEventListener("click", async () => {
            let response = await fetch(`http://localhost:9000/api/item/${item.id}`, {
                method: "DELETE"
            });

            let responseBody = await response.json();

            if(responseBody.successful){
                let itemToDelete = document.getElementById(`item-${item.id}`);
                itemToDelete.remove();

               
            }

        });

        //relating all of these elements together
        itemElem.appendChild(itemNameContElem);
        itemElem.appendChild(deleteBtnElem);
        itemNameContElem.appendChild(itemNameElem);
        itemsContainer.appendChild(itemElem);
    });
}


let addItemFormElem = document.getElementById("add-reimb-form");
    addItemFormElem.addEventListener("submit", async (event) => {
    event.preventDefault();

    let amountToCreateElem = document.getElementById("amount-to-create");
    let dateToCreateElem = document.getElementById("date-to-create");
    let descriptionToCreateElem = document.getElementById("description-to-create");

    let response = await fetch("http://localhost:9000/api/item", {
        method: "POST",
        body: JSON.stringify({
            "amount": amountToCreateElem.value,
            "date": dateToCreateElem.value,
            "description": descriptionToCreateElem.value
        })
    })

    let responseBody = await response.json();
    
    
    itemsContainer.innerHTML = "";
    items = await getAllItems();
    displayItems();

})



