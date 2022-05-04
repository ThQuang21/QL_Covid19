package com.laq.quanlycovid.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect1 {
    
    public static Connection getConnection(){
        try {
            Connection cons = null;
            Class.forName("com.mysql.jdbc.Drive");
            cons = DriverManager.getConnection("jbdc:mysql://127.0.0.1:3306/DA_JAVA", "root", "");
            return cons;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
