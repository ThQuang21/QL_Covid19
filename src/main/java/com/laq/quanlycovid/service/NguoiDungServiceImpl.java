/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.laq.quanlycovid.service;


import com.laq.quanlycovid.dao.NguoiDungDAO;
import com.laq.quanlycovid.dao.NguoiDungDAOImpl;
import com.laq.quanlycovid.model.DiaChi;
import com.laq.quanlycovid.model.LichSuQuanLy;
import com.laq.quanlycovid.model.NguoiDung;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Envy
 */
public class NguoiDungServiceImpl implements NguoiDungService {
    private NguoiDungDAO nguoiDungDAO = null;
    public NguoiDungServiceImpl(){
        nguoiDungDAO = new NguoiDungDAOImpl();
    }
    @Override
    public NguoiDung getNguoi(String cmnd){
        return nguoiDungDAO.getNguoi(cmnd);
    }
    @Override
    public ArrayList<NguoiDung> getList() {
        return nguoiDungDAO.getList();
    }
     public List<NguoiDung> getRelateList(String cmnd) {
        return nguoiDungDAO.getRelateList(cmnd);
    }
     public DiaChi getDiaChi (String cmnd){
         return nguoiDungDAO.getDiaChi(cmnd);
     }
     public int createNguoiDung(NguoiDung nd, DiaChi dc){
         return nguoiDungDAO.createNguoiDung(nd, dc);
     }
    public int updateNguoiDung(NguoiDung old, NguoiDung upd, DiaChi dc_old, int flag){
        return nguoiDungDAO.updateNguoiDung(old, upd, dc_old, flag);
    }
    public List<String> getPhuong(){
        return nguoiDungDAO.getPhuong();
    }
    public List<String> getQuan(){
        return nguoiDungDAO.getQuan();
    }
    public List<String> getThanhPho(){
        return nguoiDungDAO.getThanhPho();
    }
    public int updateNguoiDungCaNhan(NguoiDung nd, DiaChi dc){
        return nguoiDungDAO.updateNguoiDungCaNhan(nd, dc);
    }
    public String getPass(String cmnd){
        return nguoiDungDAO.getPass(cmnd);
    }
    public int updatePass(String cmnd, String pass){
        return nguoiDungDAO.updatePass(cmnd, pass);
    }
    public int getTypeAccount(String cmnd){
        return nguoiDungDAO.getTypeAccount(cmnd);
    }
    public List<LichSuQuanLy> getLichSuQL(String cmnd){
        return nguoiDungDAO.getLichSuQL(cmnd);
    }
}
