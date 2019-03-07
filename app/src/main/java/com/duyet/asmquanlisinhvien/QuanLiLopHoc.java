package com.duyet.asmquanlisinhvien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.duyet.asmquanlisinhvien.Adapter.Adapterlistlop;
import com.duyet.asmquanlisinhvien.model.LopHoc;

import java.util.ArrayList;

public class QuanLiLopHoc extends AppCompatActivity {
    ListView listviewlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_lop_hoc);

        listviewlop = (ListView)findViewById(R.id.listviewlop);
        final ArrayList<LopHoc> arrlophocc = new ArrayList<>();
        arrlophocc.add(new LopHoc("PT12301","Thiết kế web cho thiết bị di động","Lập Trình Máy Tính "));
        arrlophocc.add(new LopHoc("PT12303","Lập Trình Android","Lập Trình Máy Tính"));
        arrlophocc.add(new LopHoc("AV12301","Tiếng Anh 2.1","Lập Trình Máy Tính"));
        arrlophocc.add(new LopHoc("AV12302","Tiếng Anh 2.2","Lập Trình Máy Tính"));
        arrlophocc.add(new LopHoc("PT12302","Lập Trình Java 2","Lập Trình Máy Tính  "));
        Adapterlistlop adapterListLop = new Adapterlistlop(this,R.layout.item_lop_hoc,arrlophocc);
        listviewlop.setAdapter(adapterListLop);



    }
}
