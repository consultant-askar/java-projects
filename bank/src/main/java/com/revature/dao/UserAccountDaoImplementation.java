package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserAccount;
import com.revature.util.ConnectionUtil;

public class UserAccountDaoImplementation implements UserAccountDao{

    @Override
    public void createUserAccount(UserAccount useraccount) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "insert into useraccounts (account_type, balance, details, user_id_fk) values (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, useraccount.getAccountType());
            ps.setFloat(2, useraccount.getBalance());
            ps.setString(3, useraccount.getDetails());
            ps.setInt(4, useraccount.getUserIdFk());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    ///////////////////////////////////////////
    @Override
    public void deleteUserAccount(UserAccount useraccount) {

        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "delete from useraccounts where account_no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, useraccount);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    //////////////////////////////////////////////////////
    @Override
    public List<UserAccount> getAllAccountsGivenUserId(Integer userId) {

        List<UserAccount> accounts = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "select * from useraccounts where user_id_fk = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);


            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(new UserAccount(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4), rs.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
       
       
    }
    @Override
    public void transferMoney(UserAccount accountNumber, UserAccount accountNumberAccount, UserAccount balance) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void deposite(Integer accountNumber, Float amount) {
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "update useraccounts set balance = ? where account_no = ? ";
           
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setFloat(1, amount);
           
            ps.setInt(2, accountNumber);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }



    @Override
    public void withdraw(Integer accountNumber, Float amount) {
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "update useraccounts set balance = ? where account_no = ? ";
           
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ps.setFloat(1, amount);
           
            ps.setInt(2, accountNumber);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }


    }
   


    
    

