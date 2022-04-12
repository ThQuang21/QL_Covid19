/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.dao;

import com.laq.quanlycovid.model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public class NguoiDungDAOImpl implements NguoiDungDAO {
    @Override
    public List<NguoiDung> getList() {
        try{
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM NGUOI_LIEN_QUAN";
            List<NguoiDung> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                NguoiDung tmp = new NguoiDung();
                tmp.setCMND(rs.getString("CMND"));
                tmp.setName(rs.getString("TEN"));
                tmp.setYear(rs.getInt("NAMSINH"));
                tmp.setStatus(rs.getInt("TRANGTHAI"));
                tmp.setDebt(rs.getInt("DUNO"));
                tmp.setLinkedPID(rs.getString("NGLIENQUAN"));
                tmp.setHospital(rs.getString("BVID"));
                list.add(tmp);
            }
            ps.close();
            rs.close();
            conn.close();
            return list;
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    public static void main(String args[]){
        NguoiDungDAO a = new NguoiDungDAOImpl();
        System.out.println(a.getList());
    }
}
