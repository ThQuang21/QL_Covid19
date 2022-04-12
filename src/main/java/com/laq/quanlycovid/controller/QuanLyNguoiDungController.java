/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.controller;

import com.laq.quanlycovid.model.NguoiDung;
import com.laq.quanlycovid.service.NguoiDungService;
import com.laq.quanlycovid.service.NguoiDungServiceImpl;
import com.laq.quanlycovid.utility.ClassTableModel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Envy
 */
public class QuanLyNguoiDungController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private NguoiDungService nguoiDungService = null;
    private String[] listColumn= {"CMND","Họ và Tên","Năm Sinh","Trạng Thái","Địa Chỉ","Bệnh viện","Người liên quan","Nợ"};
    private TableRowSorter<TableModel> rowSorter = null;
    
    public QuanLyNguoiDungController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch){
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.nguoiDungService = new NguoiDungServiceImpl();
    }
    
    public void setDataToTable(){
        List<NguoiDung> listItem;
        listItem = nguoiDungService.getList();
        DefaultTableModel model = new ClassTableModel().setTableNguoiDung(listItem, listColumn);
        JTable table= new JTable(model);
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText(); 
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText(); 
                if(text.trim().length() == 0){
                    rowSorter.setRowFilter(null);
                }else{
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        
    });
        
     table.getTableHeader().setFont(new Font("Arial", Font.BOLD,14));
     table.getTableHeader().setPreferredSize(new Dimension(100,50));
     table.setRowHeight(50);
     table.validate();
     table.repaint();
     
     JScrollPane scrollpane = new JScrollPane();
     scrollpane.getViewport().add(table);
     scrollpane.setPreferredSize(new Dimension(1400, 400));
     
     jpnView.removeAll();
     jpnView.setLayout(new CardLayout());
     jpnView.add(scrollpane);
     jpnView.validate();
     jpnView.repaint();
    }
}
