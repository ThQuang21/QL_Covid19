/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.model;

/**
 *
 * @author Envy
 */
public class LichSuQuanLy {
    private String ttmoi;
    private String ttcu;
    private String bvmoi;
    private String bvcu;
    public LichSuQuanLy(){}
    public LichSuQuanLy(String ttmoi, String ttcu, String bvmoi, String bvcu) {
        this.ttmoi = ttmoi;
        this.ttcu = ttcu;
        this.bvmoi = bvmoi;
        this.bvcu = bvcu;
    }

    public String getTtmoi() {
        return ttmoi;
    }

    public void setTtmoi(String ttmoi) {
        this.ttmoi = ttmoi;
    }

    public String getTtcu() {
        return ttcu;
    }

    public void setTtcu(String ttcu) {
        this.ttcu = ttcu;
    }

    public String getBvmoi() {
        return bvmoi;
    }

    public void setBvmoi(String bvmoi) {
        this.bvmoi = bvmoi;
    }

    public String getBvcu() {
        return bvcu;
    }

    public void setBvcu(String bvcu) {
        this.bvcu = bvcu;
    }

    @Override
    public String toString() {
        return "ttmoi=" + ttmoi + ", ttcu=" + ttcu + ", bvmoi=" + bvmoi + ", bvcu=" + bvcu;
    }
    
}
