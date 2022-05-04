/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Envy
 */
public class ChinhSuaNguoiDungController_1 {
    private JButton btnSubmit;
    private JTextField jtfCMND;
    private JTextField jtfHoTen;
    private JTextField jtfYear;
    private JTextField jtfDiaChi;
    private JComboBox jcbPhuong;
    private JComboBox jcbQuan;
    private JComboBox jcbTP;
    private JLabel jlbMsg;
    private NguoiDung nguoiDung;
    private DiaChi dc;
    private NguoiDungService nguoiDungService = null;
    public ChinhSuaNguoiDungController_1(JButton btnSubmit, JTextField jtfCMND, JTextField jtfHoTen,
            JTextField jtfYear, JTextField jtfDiaChi, JComboBox jcbPhuong, JComboBox jcbQuan,
            JComboBox jcbTP, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfCMND = jtfCMND;
        this.jtfHoTen = jtfHoTen;
        this.jtfYear = jtfYear;
        this.jtfDiaChi = jtfDiaChi;
        this.jcbPhuong = jcbPhuong;
        this.jcbQuan = jcbQuan;
        this.jcbTP = jcbTP;
        this.jlbMsg = jlbMsg;
        this.nguoiDungService = new NguoiDungServiceImpl();
    }
    public void setView(NguoiDung nguoiDung){
        this.nguoiDung = nguoiDung;
        if (nguoiDung.getCMND() != null){
            jtfCMND.setEditable(false);
        }
        jtfCMND.setText(nguoiDung.getCMND());
        jtfHoTen.setText(nguoiDung.getName());
        jtfYear.setText(Integer.toString(nguoiDung.getYear()));
        dc = nguoiDungService.getDiaChi(nguoiDung.getCMND());
        jtfDiaChi.setText(dc.getDiaChi());
        jcbPhuong.removeAllItems();
        List<String> listPhuong = nguoiDungService.getPhuong();
        for(String p : listPhuong){
            jcbPhuong.addItem(p);
        }
        jcbPhuong.setMaximumRowCount(5);
        jcbPhuong.setSelectedItem(dc.getPhuong());
        jcbQuan.removeAllItems();
        List<String> listQuan = nguoiDungService.getQuan();
        for(String q : listQuan){
            jcbQuan.addItem(q);
        }
        jcbQuan.setMaximumRowCount(5);
        jcbQuan.setSelectedItem(dc.getQuan());
        jcbTP.removeAllItems();
        List<String> listTP = nguoiDungService.getThanhPho();
        for(String tp : listTP){
            jcbTP.addItem(tp);
        }
        jcbTP.setMaximumRowCount(5);
        jcbTP.setSelectedItem(dc.getThanhPho());
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                if (jtfCMND.getText().length() == 0)
                    filled = false;
                if (jtfHoTen.getText().length() == 0 )
                    filled = false;
                if (jtfYear.getText().length() == 0)
                    filled = false;
                if (jtfDiaChi.getText().length() == 0)
                    filled = false;
                if (jcbPhuong.getSelectedItem() == null)
                    filled = false;
                if (jcbQuan.getSelectedItem() == null)
                    filled = false;   
                if (jcbTP.getSelectedItem() == null)
                    filled = false;
                if (!filled){
                    jlbMsg.setText("Xin nhập đầy đủ các trường");
                }
                else{
                    nguoiDung.setCMND(jtfCMND.getText());
                    nguoiDung.setName(jtfHoTen.getText());
                    nguoiDung.setYear(Integer.parseInt(jtfYear.getText()));
                    dc.setDiaChi(jtfDiaChi.getText());
                    dc.setPhuong(jcbPhuong.getSelectedItem().toString());
                    dc.setQuan(jcbQuan.getSelectedItem().toString());
                    dc.setThanhPho(jcbTP.getSelectedItem().toString());
                   if(showDialog()){
                        int res = nguoiDungService.updateNguoiDungCaNhan(nguoiDung, dc);
                        if(res != 0){
                            jlbMsg.setText("Xử lý cập nhật dữ liệu thành công!");
                        }
                        else
                            jlbMsg.setText("Đã có lỗi xảy ra, xin hãy thử lại!");
                    }
                }
            }
            @Override
            public void mouseEntered (MouseEvent e){
                btnSubmit.setBackground(new Color (185,215,234));
                
            }
            @Override
            public void mouseExited (MouseEvent e){
                btnSubmit.setBackground(new Color (214,230,242));
            }
        });
    }
    
    private boolean showDialog() {
        int dialogResult = JOptionPane.showConfirmDialog(null,
                "Bạn muốn cập nhật dữ liệu hay không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
