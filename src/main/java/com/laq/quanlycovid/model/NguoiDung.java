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
public class NguoiDung implements Serializable  {
	private String cmnd;
	private String name;
	private int YOB;
	private int status;
	private int debt;
	private String linkedPID;
	private String bvID;
	NguoiDung(String id, String n, int y, int stat, String pid){
		cmnd = id;
		name = n;
		YOB = y;
		debt = 0;
		linkedPID = pid;
		status = stat;
	}
	NguoiDung(String id, String n, int y, int stat, String pid, int d){
		cmnd = id;
		name = n;
		YOB = y;
		debt = d;
		linkedPID = pid;
		status = stat;
	}
	NguoiDung(String id, String n, int y, int stat, String pid, int d, String bv){
		cmnd = id;
		name = n;
		YOB = y;
		debt = d;
		linkedPID = pid;
		status = stat;
		bvID = bv;
	}
	NguoiDung(){
	}
	void setCMND(String n) {
		cmnd = n;
	}
	String getCMND() {
		return cmnd;
	}
	void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
	void setYear(int y) {
		YOB = y;
	}
	int getYear() {
		return YOB;
	}
	void setStatus(int s) {
		status = s;
	}
	int getStatus() {
		return status;
	}
	void setDebt(int d) {
		debt = d;
	}
	int getDebt() {
		return debt;
	}
	void addDebt(int a) {
		debt = debt + a;
	}
	void minusDebt(int m) {
		debt = debt - m;
	}
	String getLinkedPID() {
		return linkedPID;
	}
	void setLinkedPID(String l) {
		linkedPID = l;
	}
	String getbvID() {
		return bvID;
	}
	void setbvID(String l) {
		bvID = l;
	}
        @Override
	public String toString() {
		return cmnd + " " + name + " " + YOB + " " + status + " " + linkedPID + " " + debt + " " + bvID;
	}
}