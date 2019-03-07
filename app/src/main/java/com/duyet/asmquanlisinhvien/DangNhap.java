package com.duyet.asmquanlisinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class DangNhap extends AppCompatActivity {
    Button bntdangnhap;
    EditText edittendangnhap;
    EditText editmatkhau;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        MobileAds.initialize(this, "ca-app-pub-2963552816189944~6938848683");
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-2963552816189944/1166860830");

        mAdView =  (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
            }
        });

        edittendangnhap = (EditText)findViewById(R.id.edittendangnhap);
        editmatkhau = (EditText)findViewById(R.id.editmatkhau);
        bntdangnhap= (Button)findViewById(R.id.bntdangnhap);
        bntdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });

    }
    private void checkValidation(){
        String getTendn = edittendangnhap.getText().toString();//"" 0
        String getMatkhau = editmatkhau.getText().toString();
        if(getTendn.equals("admin")||getMatkhau.equals("admin")){
            Intent intent = new Intent(DangNhap.this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Bạn Đã Nhập Sai Tên Đăng Nhập Hoặc Mật Khẩu", Toast.LENGTH_SHORT).show();
        }

    }
}
