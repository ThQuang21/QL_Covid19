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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

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
                Border border = BorderFactory.createLineBorder(Color.RED, 1);
                if (jtfCMND.getText().length() == 0){
                    filled = false;
                    jtfCMND.setBorder(border);
                }
                if (jtfHoTen.getText().length() == 0 ){
                    filled = false;
                    jtfHoTen.setBorder(border);
                }
                if (jtfYear.getText().length() == 0){
                    filled = false;
                    jtfYear.setBorder(border);
                }
                if (jtfDiaChi.getText().length() == 0){
                    filled = false;
                    jtfDiaChi.setBorder(border);
                }
                if (jcbPhuong.getSelectedItem() == null){
                    filled = false;
                    jcbPhuong.setBorder(border);
                }
                if (jcbQuan.getSelectedItem() == null){
                    filled = false;
                    jcbQuan.setBorder(border);
                }
                if (jcbTP.getSelectedItem() == null){
                    filled = false;
                    jcbTP.setBorder(border);
                }
                if (!filled){
                    jlbMsg.setText("Xin nh???p ?????y ????? c??c tr?????ng");
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
                            jlbMsg.setText("X??? l?? c???p nh???t d??? li???u th??nh c??ng!");
                        }
                        else
                            jlbMsg.setText("???? c?? l???i x???y ra, xin h??y th??? l???i!");
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
                "B???n mu???n c???p nh???t d??? li???u hay kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
