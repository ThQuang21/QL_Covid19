/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.laq.quanlycovid.model.MD5;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.view.AdminJFrame;
import com.laq.quanlycovid.view.MainJFrame;
import com.laq.quanlycovid.view.MainJFrame_1;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.border.Border;
/**
 *
 * @author Envy
 */
public class DangNhapController {
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfCMND;
    private JPasswordField jpfPass;
    private JLabel jlbMsg;
    private NguoiDungService nguoiDungService = null;
    public DangNhapController(JDialog dialog, JButton btnSubmit, JTextField jtfCMND, 
            JPasswordField jpfPass, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSubmit;
        this.jtfCMND = jtfCMND;
        this.jpfPass = jpfPass;
        this.jlbMsg = jlbMsg;
        this.nguoiDungService = new NguoiDungServiceImpl();
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
                if (String.valueOf(jpfPass.getPassword()).length() == 0){
                    filled = false;
                    jpfPass.setBorder(border);
                }
                if (!filled){
                    jlbMsg.setText("Xin nhập đầy đủ các trường");
                }
                else{
//                    jlbMsg.setText("Done Check filled");
                    String check = MD5.ToMD5(jtfCMND.getText());
                    String defPass = nguoiDungService.getPass(jtfCMND.getText());
                    if(defPass == null){
                        jlbMsg.setText("Wrong ID !");
                        return;
                    }
                    String pass = MD5.ToMD5(String.valueOf(jpfPass.getPassword()));
                    System.out.println("Default pass: " + check + "Default in sql: " + defPass);
                    if (check.equals(defPass)){
                        System.out.println("Update new user ");
                        System.out.println("Update pass: " + pass);
                        nguoiDungService.updatePass(jtfCMND.getText(), pass);
                        int type = nguoiDungService.getTypeAccount(jtfCMND.getText());
                        if(type == 1){
                            dialog.dispose();
                            MainJFrame_1 frame = new MainJFrame_1(jtfCMND.getText());
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else if (type == 2){
                            dialog.dispose();
                            MainJFrame frame = new MainJFrame();
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else if (type == 3){
                            dialog.dispose();
                            AdminJFrame frame = new AdminJFrame();
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else{
                            jlbMsg.setText("Error !");
                        }
                    }
                    if(defPass.equals(pass)){
                        int type = nguoiDungService.getTypeAccount(jtfCMND.getText());
                        if(type == 1){
                            dialog.dispose();
                            MainJFrame_1 frame = new MainJFrame_1(jtfCMND.getText());
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else if (type == 2){
                            dialog.dispose();
                            MainJFrame frame = new MainJFrame();
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else if (type == 3){
                            dialog.dispose();
                            AdminJFrame frame = new AdminJFrame();
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
                        else{
                             jlbMsg.setText("Wrong ID !");
                        }
                    }
                    else{
                        jlbMsg.setText("Wrong Pass !");
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
}
