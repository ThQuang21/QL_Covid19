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
public class NoiDieuTri implements Serializable{
    private String id;
    private String ten;
    private int sucChua;
    private int soLuongHienTai;
    public void setID(String ID){
        this.id = ID;
    }
    public String getID(){
        return this.id;
    }
    public void setTen(String n){
        ten = n;
    }
    public String getTen(){
        return ten;
    }
    public void setSucChua(int n){
        sucChua = n;
    }
    public int getSucChua(){
        return sucChua;
    }
    public void setSoLuongHienTai(int n){
        soLuongHienTai = n;
    }
    public int getSoLuongHienTai(){
        return soLuongHienTai;
    }
    
    @Override
    public String toString(){
        return (ten + " " + sucChua + " " + soLuongHienTai );
    }
}

