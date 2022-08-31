
window.onload = async () => {
    let response = await fetch("http://localhost:9000/api/session");

    let responseBody = await response.json();

    if(responseBody.successful){
        window.location = "./dashboard"
    }
}

let loginFormElem = document.getElementById("login-form");

loginFormElem.addEventListener("submit", (event) => {
    //prevent the original implementation of the on submit event
    event.preventDefault();

    //retrieve values from input?
    let userNameInputElement = document.getElementById("username-input");
    let passwordInputElement = document.getElementById("password-input");

    sendLoginRequest(userNameInputElement.value, passwordInputElement.value);

});

async function sendLoginRequest(username, password){

    let response = await fetch("http://localhost:9000/api/session", {
        method: "POST",
        //JSON.stringfy() converts javascript objects to json strings
        body: JSON.stringify({
            "username": username,
            "password": password
        })
    });

    let responseBody = await response.json();

    if(responseBody.successful){
        //do successful stuff
        window.location = "./dashboard";
    }else{
        //do unsuccessful stuff
        let messageElem = document.getElementById("message");

        messageElem.innerText = responseBody.message;
        messageElem.style.display = 'block';
    }
}