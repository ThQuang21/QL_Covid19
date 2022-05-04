/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.dao.QLocationDAO;
import com.laq.quanlycovid.dao.QLocationDAOImpl;
import com.laq.quanlycovid.model.Ad;
import java.util.List;

public class QLocationServiceImpl implements QLocationService{

    private QLocationDAO qLocationDAO = null;
    
    public QLocationServiceImpl(){
        qLocationDAO = new QLocationDAOImpl();
    }
    @Override
    public List<Ad> getList() {
        return qLocationDAO.getList();
    }
    
}
