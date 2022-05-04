/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.LichSuQuanLy;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Envy
 */
public class LichSuQuanLyController_1 {
    private String cmnd;
    private JTable jtbLichSu;
    private NguoiDungService nguoiDungService;

    public LichSuQuanLyController_1(String cmnd, JTable jtbLichSu) {
        this.jtbLichSu = jtbLichSu;
        this.nguoiDungService = new NguoiDungServiceImpl();
        this.cmnd = cmnd;
    }
    public void setView(){
        List<LichSuQuanLy> listLS = nguoiDungService.getLichSuQL(cmnd);
        DefaultTableModel model = (DefaultTableModel) jtbLichSu.getModel();
        for(LichSuQuanLy a : listLS){
            model.addRow(new Object[]{a.getTtmoi(),a.getTtcu(), a.getBvmoi(), a.getBvcu()});
        }
    }
    
    
    
}
