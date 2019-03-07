package com.duyet.asmquanlisinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView editten, edittuoi,editlop, editnghanh, editgioitinh;
    Button btnquaylai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editten = (TextView)findViewById(R.id.editten);
        edittuoi = (TextView)findViewById(R.id.edittuoi);
        editlop =(TextView)findViewById(R.id.editlop);
        editnghanh = (TextView) findViewById(R.id.editnghanh);
        editgioitinh = (TextView) findViewById(R.id.editgioitinh);
        btnquaylai = (Button) findViewById(R.id.btnquaylai);
        btnquaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Intent callerIntent = getIntent();
        //có intent rồi thì lấy Bundle dựa vào key Calculation
        Bundle packageFromCaller = callerIntent.getBundleExtra("RESULT_DATA");
        String ten =  packageFromCaller.getString("TEN");
        String tuoi =  packageFromCaller.getString("TUOI");
        String gioitinh =  packageFromCaller.getString("GIOITINH");
        String nghanh =  packageFromCaller.getString("NGHANH");
        String lop =  packageFromCaller.getString("LOP");
        editten.setText(""+ten);
        edittuoi.setText(""+tuoi);
        editlop.setText(""+lop);
        editgioitinh.setText(""+gioitinh);
        editnghanh.setText(""+nghanh);

    }
}
