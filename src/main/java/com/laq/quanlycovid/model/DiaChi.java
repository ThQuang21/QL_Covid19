/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.model;
import java.io.Serializable;
/**
 *
 * @author Envy
 */

public class DiaChi implements Serializable{
    private String diachi;
    private String phuong;
    private String duong;
    private String quan;
    private String thanh_pho;
    
    DiaChi(){}
    DiaChi(String sn,String d,String ph,String q,String tp){
    	diachi = sn;
    	duong = d;
    	phuong = ph;
    	quan = q;
    	thanh_pho =tp;
    };
    void setPhuong(String P) {
        phuong = P;
    }
    String getPhuong(){
        return phuong;
    }

    void setQuan(String n) {
        quan = n;
    }
    String getQuan(){
        return quan;
    }
    
    void setDuong(String d) {
        duong = d;
    }
    String getDuong(){
        return duong;
    }

    void setDiaChi(String d) {
        diachi = d;
    }
    String getDiaChi(){
        return diachi;
    }

    void setThanhPho(String n) {
        thanh_pho = n;
    }
    String getThanhPho(){
        return thanh_pho;
    }
    
    @Override
    public String toString(){
        return (phuong + " " + quan + " " + quan + " "  + thanh_pho);
    }
}

