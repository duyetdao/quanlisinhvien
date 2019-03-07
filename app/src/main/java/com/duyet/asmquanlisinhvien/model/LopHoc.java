package com.duyet.asmquanlisinhvien.model;

/**
 * Created by DUYET on 27/08/2017.
 */

public class LopHoc {
    String malop;
    String tenlop;
    String tennghanh;

    public LopHoc(String malop, String tenlop, String tennghanh) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.tennghanh = tennghanh;
    }
    public  LopHoc(){

    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getTennghanh() {
        return tennghanh;
    }

    public void setTennghanh(String tennghanh) {
        this.tennghanh = tennghanh;
    }
}
