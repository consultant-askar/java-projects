package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;



public class ReimbDaoImpl implements ReimbDao {

    Reimbursement reimb = new Reimbursement();

    @Override
    public List<Reimbursement> getAllReimbByStatus(Integer reimbStatusId) {
            List<Reimbursement> allBS = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_author_fk, r.reimb_resolver_fk, r.reimb_status_id, r.reimb_type_id  from reimbursement r inner join reimbursement_status rs2 on r.reimb_status_id = rs2.reimb_status_id where rs2.reimb_status_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimbStatusId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                allBS.add(new Reimbursement(rs.getInt(1),
                        rs.getDouble(2),
                        rs.getDate(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        rs.getInt(9)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allBS;
    }



    @Override
    public List<Reimbursement> getAllReimbursements() {

            List<Reimbursement> allR = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select r.reimb_id, r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_author_fk, r.reimb_resolver_fk, r.reimb_status_id, r.reimb_type_id  from reimbursement r ";
            PreparedStatement ps = conn.prepareStatement(sql);
          
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                    allR.add(new Reimbursement(rs.getInt(1),
                            rs.getDouble(2),
                            rs.getDate(3),
                            rs.getDate(4),
                            rs.getString(5),
                            rs.getInt(6),
                            rs.getInt(7),
                            rs.getInt(8),
                            rs.getInt(9)));
                            
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allR;
    }

    @Override
    public void approveOrDenyRR(Integer statusID, Integer authorId, Integer reimbId) {
        
        try (Connection conn = ConnectionUtil.getConnection()) {

            String sql = "update reimbursement r set reimb_status_id  = ? where r.reimb_author_fk = ? and r.reimb_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, statusID);
            ps.setInt(2, authorId);
            ps.setInt(3, reimbId);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    // create new Reimbursement Request
    @Override
    public void createNewRR(Reimbursement reimbursement) {

        try {

            Connection conn = ConnectionUtil.getConnection();

            String sql = "insert into reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_type_id) values (?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, reimb.getReimbAmount());
            ps.setDate(2, reimb.getReimbSubmitted());
            ps.setString(3, reimb.getReimbDescription());
            ps.setInt(4, reimb.getReimbType());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
