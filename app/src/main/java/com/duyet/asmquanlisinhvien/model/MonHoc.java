package com.duyet.asmquanlisinhvien.model;

/**
 * Created by DUYET on 27/08/2017.
 */

public class MonHoc {
    String malop;
    String tenlop;

    public  MonHoc(){

    }
    public MonHoc(String malop, String tenlop) {
        this.malop = malop;
        this.tenlop = tenlop;
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
}
