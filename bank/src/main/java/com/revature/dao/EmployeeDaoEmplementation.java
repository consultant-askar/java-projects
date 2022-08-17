package com.revature.dao;

import com.revature.models.Employee;
import com.revature.models.UserAccount;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoEmplementation implements EmployeeDao{

    
    @Override
    public Employee getEmployeeByUserName(String username) {
        Employee employee = null;

       try(Connection conn = ConnectionUtil.getConnection()) {

        String sql = "select * from employees where username = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
        }
        
       } catch (SQLException e) {
        System.out.printf("Sql Exception Occured", e);
       }

         return employee;
    }
    
/**************************************************** */
    @Override
    public void creatEmployee(Employee employee) {
        try {
        Connection conn = ConnectionUtil.getConnection();
        String sql = "insert into employees (username, password, firstname, lastname) values (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            
            ps.setString(1, employee.getUsername());
            ps.setString(2, employee.getPassword());
            ps.setString(3, employee.getFirstname());
            ps.setString(4, employee.getLastname());

            ps.executeUpdate();

            conn.close();
            
        } catch (SQLException e) {
           // logger.error("Sql Exception Occured", e);
           System.out.printf("Sql Exception Occured", e);
        }
      
    }

@Override
public List<UserAccount> getAllApprovidAccounts() {
    // TODO Auto-generated method stub
    return null;
}


}
