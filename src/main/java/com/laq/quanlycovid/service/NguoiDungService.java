/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;

import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.LichSuQuanLy;
import com.laq.quanlycovid.model.NguoiDung;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Envy
 */
public interface NguoiDungService {
    public NguoiDung getNguoi(String cmnd);
    ArrayList <NguoiDung> getList();
    List <NguoiDung> getRelateList(String cmnd);
    public DiaChi getDiaChi (String cmnd);
    public List<String> getPhuong();
    public List<String> getQuan();
    public List<String> getThanhPho();
    public int createNguoiDung(NguoiDung nd, DiaChi dc);
    public int updateNguoiDung(NguoiDung old, NguoiDung upd, DiaChi dc, int flag);
    public int updateNguoiDungCaNhan(NguoiDung nd, DiaChi dc);
    public String getPass(String cmnd);
    public int updatePass(String cmnd, String pass);
    public int getTypeAccount(String cmnd);
    public List<LichSuQuanLy> getLichSuQL(String cmnd);
}
