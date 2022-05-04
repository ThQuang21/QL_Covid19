package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.Ad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class QLocationDAOImpl implements QLocationDAO{

    @Override
    public List<Ad> getList() {
        try{
            Connection cons = DBConnect1.getConnection();
            String sql = "SELECT* FROM ADMIN";
            List<Ad> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ad ad = new Ad();
                ad.setUsername(rs.getString("USERNAME"));
                ad.setPassword(rs.getString("PASSWORD"));
                ad.setConfirmPassword(rs.getString("CONFIRMPASSWORD"));
                
                list.add(ad);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args){
        QLocationDAO qLocationDAO = new QLocationDAOImpl();
        System.out.println(qLocationDAO.getList());
    }
}
