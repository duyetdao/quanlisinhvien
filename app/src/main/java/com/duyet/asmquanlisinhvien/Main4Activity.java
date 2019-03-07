package com.duyet.asmquanlisinhvien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.duyet.asmquanlisinhvien.Adapter.Adapterlistmon;
import com.duyet.asmquanlisinhvien.model.MonHoc;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    ListView listviewmon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        listviewmon = (ListView)findViewById(R.id.listviewmon);
        final ArrayList<MonHoc> arrmonhoc = new ArrayList<>();
        arrmonhoc.add(new MonHoc("LTMT","Lập Trình Máy Tính "));
        arrmonhoc.add(new MonHoc("UDPM","Ứng Dụng Phần Mềm"));
        arrmonhoc.add(new MonHoc("MAR","Marketing And Sale"));
        arrmonhoc.add(new MonHoc("KT","Kinh Tế"));
        arrmonhoc.add(new MonHoc("TKW","Thiết Kế Web "));
        Adapterlistmon adapterlistmon = new Adapterlistmon(this,R.layout.item_mon_hoc,arrmonhoc);
        listviewmon.setAdapter(adapterlistmon);
    }
}
