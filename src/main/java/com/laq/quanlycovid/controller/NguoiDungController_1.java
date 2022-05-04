/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;
import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.service.NoiDieuTriService;
import com.laq.quanlycovid.view.DoiPassJFrame;
import com.laq.quanlycovid.view.NguoiDungJFrame;
import com.laq.quanlycovid.view.NguoiDungJFrame_1;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Envy
 */
public class NguoiDungController_1 {
    private NguoiDung nguoiDung;
    private JTable jtbDS;
    private JTextField jtfNo;
    private JTextField jtfCMND;
    private JTextField jtfDiaChi;
    private JTextField jtfNgLQ;
    private JTextField jtfPhuong;
    private JTextField jtfQuan;
    private JTextField jtfTP;
    private JTextField jtfTen;
    private JTextField jtfYear;
    private JTextField jtfTrangThai;
    private JButton btnChangePass;
    private JButton btnUpd;
    private NguoiDungService nguoiDungService = null;

    public NguoiDungController_1(JTextField jtfCMND, JTextField jtfDiaChi,JTextField jtfNgLQ
        ,JTextField jtfPhuong, JTextField jtfQuan, JTextField jtfTP, JTextField jtfTen
        , JTextField jtfYear,JButton btnChangePass, JButton btnUpd, JTable jtbDS, JTextField jtfNo
        , JTextField jtfTrangThai) {
        this.jtbDS = jtbDS;
        this.jtfCMND = jtfCMND;
        this.jtfDiaChi = jtfDiaChi;
        this.jtfNgLQ = jtfNgLQ;
        this.jtfPhuong = jtfPhuong;
        this.jtfQuan = jtfQuan;
        this.jtfTP = jtfTP;
        this.jtfTen = jtfTen;
        this.jtfYear = jtfYear;
        this.jtfNo = jtfNo;
        this.jtfTrangThai = jtfTrangThai;
        this.btnChangePass = btnChangePass;
        this.btnUpd = btnUpd;
        this.nguoiDungService = new NguoiDungServiceImpl();
    }
    public void setView(String cmnd){
        this.nguoiDung = nguoiDungService.getNguoi(cmnd);
        jtfCMND.setText(nguoiDung.getCMND());
        jtfTen.setText(nguoiDung.getName());
        jtfYear.setText(Integer.toString(nguoiDung.getYear()));
        jtfNgLQ.setText(nguoiDung.getLinkedPID());
        jtfNo.setText(Integer.toString(nguoiDung.getDebt()));
        jtfTrangThai.setText(nguoiDung.getStatus());
        DiaChi dc = nguoiDungService.getDiaChi(nguoiDung.getCMND());
        jtfDiaChi.setText(dc.getDiaChi());
        jtfPhuong.setText(dc.getPhuong());
        jtfQuan.setText(dc.getQuan());
        jtfTP.setText(dc.getThanhPho());
        List<NguoiDung> listLQ = nguoiDungService.getRelateList(nguoiDung.getCMND());
        DefaultTableModel model = (DefaultTableModel) jtbDS.getModel();
        for(NguoiDung a : listLQ){
            model.addRow(new Object[]{a.getCMND(), a.getName(), a.getYear()});
        }
        
    }
    public void setEvent(){
        btnUpd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                NguoiDungJFrame_1 frame = new NguoiDungJFrame_1(nguoiDung);
                frame.setTitle("Chỉnh sửa thông tin");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            @Override
            public void mouseEntered (MouseEvent e){
                btnUpd.setBackground(new Color (118,159,205));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                btnUpd.setBackground(new Color (185,215,234));
            }
        });
        btnChangePass.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                DoiPassJFrame frame = new DoiPassJFrame(nguoiDung.getCMND());
                frame.setTitle("Đổi Mật Khẩu");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            @Override
            public void mouseEntered (MouseEvent e){
                btnChangePass.setBackground(new Color (118,159,205));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                btnChangePass.setBackground(new Color (185,215,234));
            }
        });
    }
    

}
