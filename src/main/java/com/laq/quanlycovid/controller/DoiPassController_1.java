/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import com.laq.quanlycovid.model.MD5;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Envy
 */
public class DoiPassController_1 {
    private String cmnd;
    private JLabel jlbMsg;
    private JPasswordField jpfNew;
    private JPasswordField jpfNewRepeat;
    private JPasswordField jpfOld;
    private JButton btnSubmit;
    private NguoiDungService nguoiDungService = null;

    public DoiPassController_1(String cmnd,JLabel jlbMsg, JPasswordField jpfNew, JPasswordField jpfNewRepeat,
            JPasswordField jpfOld, JButton btnSubmit) {
        this.jlbMsg = jlbMsg;
        this.cmnd = cmnd;
        this.jpfNew = jpfNew;
        this.jpfNewRepeat = jpfNewRepeat;
        this.jpfOld = jpfOld;
        this.btnSubmit = btnSubmit;
        this.nguoiDungService = new NguoiDungServiceImpl();
    }
    public void setEvent(){
        btnSubmit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                boolean filled = true;
                Border border = BorderFactory.createLineBorder(Color.RED, 1);
                if (String.valueOf(jpfOld.getPassword()).length() == 0){
                    filled = false;
                    jpfOld.setBorder(border);
                }
                if (String.valueOf(jpfNew.getPassword()).length() == 0){
                    filled = false;
                    jpfNew.setBorder(border);
                }
                if (String.valueOf(jpfNewRepeat.getPassword()).length() == 0){
                    filled = false;
                    jpfNewRepeat.setBorder(border);
                }
                if (!filled){
                    jlbMsg.setText("Xin nh???p ?????y ????? c??c tr?????ng");
                }
                else{
                   String pass = MD5.ToMD5(String.valueOf(jpfOld.getPassword()));
                   String oldpass = nguoiDungService.getPass(cmnd);
                   System.out.println("SQL: " + oldpass + "\t" + "Input: " + pass);
                   if(!String.valueOf(jpfNew.getPassword()).equals(String.valueOf(jpfNewRepeat.getPassword()))){
                       jlbMsg.setText("M???t kh???u m???i v?? l???p l???i ph???i gi???ng nhau !");
                   }
                   else if (!pass.equals(oldpass)){
                       jlbMsg.setText("M???t kh???u c?? (hi???n t???i) sai. Vui l??ng nh???p l???i !");
                   }
                   else{
                       if(showDialog()){
                            String newpass = MD5.ToMD5(String.valueOf(jpfNew.getPassword()));
                            int res = nguoiDungService.updatePass(cmnd, newpass);
                            if(res != 0){
                                jlbMsg.setText("?????i m???t kh???u th??nh c??ng!");
                            }
                            else
                                jlbMsg.setText("???? c?? l???i x???y ra, xin h??y th??? l???i!");
                    }
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
                "B???n c?? ch???c ch???n ?????i m???t kh???u ph???i kh??ng?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
        return dialogResult == JOptionPane.YES_OPTION;
    }
}
