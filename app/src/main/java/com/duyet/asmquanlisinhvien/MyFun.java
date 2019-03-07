package com.duyet.asmquanlisinhvien;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.duyet.asmquanlisinhvien.model.SinhVien;

import java.util.ArrayList;

/**
 * Created by DUYET on 10/08/2017.
 */

public class MyFun {
    public MyFun(){

    }
    public void Ham1(Context c, ArrayList<SinhVien> ar, int position, Class trangdich){
        Intent intent = new Intent(c,Main2Activity.class);
        String name = ar.get(position).getTen();
        String tuoi = ar.get(position).getTuoi() + "";
        String gioitinh = ar.get(position).getGioitinh();
        String nghanh = ar.get(position).getNghanh();
        String lop = ar.get(position).getLop();
        Bundle bundle = new Bundle();
        bundle.putString("TEN", name);
        bundle.putString("TUOI", tuoi);
        bundle.putString("GIOITINH", gioitinh);
        bundle.putString("NGHANH", nghanh);
        bundle.putString("LOP", lop);
        intent.putExtra("RESULT_DATA", bundle);
        c.startActivity(intent);
    }
}

