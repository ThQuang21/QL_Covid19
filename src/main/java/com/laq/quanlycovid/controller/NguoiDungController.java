/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.model.NoiDieuTri;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.service.NoiDieuTriService;
import com.laq.quanlycovid.service.NoiDieuTriServiceImpl;
import java.util.Vector;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Envy
 */
public class NguoiDungController {
    private JButton btnSubmit;
    private JTextField jtfCMND;
    private JTextField jtfHoTen;
    private JTextField jtfYear;
    private JTextField jtfNgLienQuan;
    private JTextField jtfNo;
    private JComboBox jcbTrangThai;
    private JComboBox jcbBenhVien;
    private NguoiDungService nguoiDungService = null;
    private NoiDieuTriService noiDieuTriService = null;

    public NguoiDungController(JButton btnSubmit, JTextField jtfCMND, JTextField jtfHoTen,
            JTextField jtfYear, JTextField jtfNgLienQuan, JTextField jtfNo, JComboBox jcbTrangThai,
            JComboBox jcbBenhVien) {
        this.btnSubmit = btnSubmit;
        this.jtfCMND = jtfCMND;
        this.jtfHoTen = jtfHoTen;
        this.jtfYear = jtfYear;
        this.jtfNgLienQuan = jtfNgLienQuan;
        this.jtfNo = jtfNo;
        this.jcbTrangThai = jcbTrangThai;
        this.jcbBenhVien = jcbBenhVien;
        this.nguoiDungService = new NguoiDungServiceImpl();
        this.noiDieuTriService = new NoiDieuTriServiceImpl();
    }
    
    public void setView(NguoiDung nguoiDung){
        jtfCMND.setText(nguoiDung.getCMND());
        jtfHoTen.setText(nguoiDung.getName());
        jtfYear.setText(Integer.toString(nguoiDung.getYear()));
        jtfNgLienQuan.setText(nguoiDung.getLinkedPID());
        jtfNo.setText(Integer.toString(nguoiDung.getDebt()));
        jcbTrangThai.removeAllItems();
        String[] listTT = {"F0", "F1", "F2", "F3"};
        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel(listTT));
        jcbTrangThai.setSelectedItem("F" + Integer.toString(nguoiDung.getStatus()));
        jcbBenhVien.removeAllItems();
        List<NoiDieuTri> listBV = noiDieuTriService.getList();
//        Vector<String> listNameBV = new Vector<>();
        for(NoiDieuTri tmp : listBV){
            jcbBenhVien.addItem(tmp.getTen());
        }
//        jcbBenhVien.setModel(new javax.swing.DefaultComboBoxModel(listNameBV));
        jcbBenhVien.setMaximumRowCount(6);
//        jcbBenhVien.setSelectedItem(nguoiDung.getHospital());
    }
}
