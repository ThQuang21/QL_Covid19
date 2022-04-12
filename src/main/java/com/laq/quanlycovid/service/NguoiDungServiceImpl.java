/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;


import com.laq.quanlycovid.dao.NguoiDungDAO;
import com.laq.quanlycovid.dao.NguoiDungDAOImpl;
import com.laq.quanlycovid.model.NguoiDung;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Envy
 */
public class NguoiDungServiceImpl implements NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = null;
    public NguoiDungServiceImpl(){
        nguoiDungDAO = new NguoiDungDAOImpl();
    }
    @Override
    public List<NguoiDung> getList() {
        return nguoiDungDAO.getList();
    }
    
}
