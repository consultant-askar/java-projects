package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.services.PendingAccountService;
import com.revature.models.PendingAccounts;
import com.revature.util.ConnectionUtil;

public class PendingAccDaoImpl implements PendingAccountDao {

        


    @Override
    public void approveCustomersPengingAccount(PendingAccounts pendingAccount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void denyCustomersPengingAccount(PendingAccounts pendingAccount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<PendingAccounts> getAllPendings() {
        List<PendingAccounts> accounts = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = " select * from pending_accounts";
            PreparedStatement ps = conn.prepareStatement(sql);

           

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                accounts.add(new PendingAccounts(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getBoolean(4), rs.getInt(5)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;

       
    }

    
    @Override
     public void creatRequest(PendingAccounts pendingAccounts) {
        
        
            try (Connection conn = ConnectionUtil.getConnection()) {
               
                String sql = "insert into pending_accounts (account_type, details, user_id_fk) values (?, ?, ?);";
                PreparedStatement ps = conn.prepareStatement(sql);
    
                ps.setString(1, pendingAccounts.getAccountType());
                ps.setString(2, pendingAccounts.getDetails());
                ps.setInt(3, pendingAccounts.getUserIdFk());
    
                ps.executeUpdate();
    
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        
    }
    

