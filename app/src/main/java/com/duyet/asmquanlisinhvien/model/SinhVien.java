package com.duyet.asmquanlisinhvien.model;

/**
 * Created by DUYET on 15/08/2017.
 */

public class SinhVien {
    String ten;
    String lop;
    int tuoi;
    String gioitinh;
    String Nghanh;

    public SinhVien(){

    }

    public SinhVien(String ten, String lop, int tuoi, String gioitinh, String nghanh) {
        this.ten = ten;
        this.lop = lop;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        Nghanh = nghanh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNghanh() {
        return Nghanh;
    }

    public void setNghanh(String nghanh) {
        Nghanh = nghanh;
    }
}

