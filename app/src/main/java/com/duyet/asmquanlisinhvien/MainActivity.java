package com.duyet.asmquanlisinhvien;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.InterstitialAd;


import com.duyet.asmquanlisinhvien.Adapter.AdapterlistviewSinhVien;
import com.duyet.asmquanlisinhvien.model.SinhVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    Toast toast;
    ArrayList<SinhVien> arsinhvien;
    AdapterlistviewSinhVien adaptersinhvien;
    EditText EditTen, Edittuoi, Editgioitinh, Editnghanh, Editlop;
    Button bntlophoc,bntmonhoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        MobileAds.initialize(this, "ca-app-pub-2963552816189944~6938848683");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2963552816189944/9307955175");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        mInterstitialAd.setAdListener(new AdListener() {
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
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
            }
        });


        EditTen = (EditText) findViewById(R.id.EditTen);
        Edittuoi = (EditText) findViewById(R.id.EditTuoi);
        Editgioitinh = (EditText) findViewById(R.id.EditGioiTinh);
        Editnghanh = (EditText) findViewById(R.id.EditNghanh);
        Editlop = (EditText) findViewById(R.id.EditLop);
        ListView listView = (ListView) findViewById(R.id.listview);
        bntlophoc =(Button)findViewById(R.id.bntlophoc);
        bntlophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent intent = new Intent(MainActivity.this,QuanLiLopHoc.class);
                startActivity(intent);

            }
        });

        bntmonhoc = (Button)findViewById(R.id.bntmonhoc);
        bntmonhoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);

            }
        });

        arsinhvien = new ArrayList<SinhVien>();
        arsinhvien.add(new SinhVien("Đào Tấn Duyệt", "12.3", 20, "Nam", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Phạm Minh Thịnh", "12.3", 20, "Nữ", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Nguyễn Ngọc Lương", "12.3", 20, "Nam", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Trần Trung Hiếu", "12.3", 20, "Nam", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Đào Văn Nam", "12.3", 20, "Nam", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Lương Thị Cam Ly", "12.3", 20, "Nữ", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Nguyễn Văn An", "12.3", 20, "Nam", "Lập Trình Moblie"));
        arsinhvien.add(new SinhVien("Nguyễn Văn Cường", "12.3", 20, "Nữ", "Lập Trình Moblie"));
        adaptersinhvien = new AdapterlistviewSinhVien(this, R.layout.item_sinhvien, arsinhvien);

        listView.setAdapter(adaptersinhvien);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyFun myFun = new MyFun();
                myFun.Ham1(MainActivity.this,arsinhvien,position,Main2Activity.class);
            }
        });


    }

    public void ShowmenuItem(View view, final int vitri) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item_listview, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.RemoveItem) {
                    //xóa sinh viên được lựa chọn

                    arsinhvien.remove(vitri);
                    //gọi hàm thông báo có sự thay đổi
                    adaptersinhvien.notifyDataSetChanged();


                } else if (item.getItemId() == R.id.EditItem) {

                    dialogsua(arsinhvien.get(vitri),vitri);



                } else if (item.getItemId() == R.id.InfoItem) {


                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void dialogsua(final SinhVien sinhviensua, final int vitri) {
        //khởi tạo dialog
        final Dialog dialog = new Dialog(MainActivity.this);
        //xét layout cho dialog
        dialog.setContentView(R.layout.layout_custom_dialog);
        //xét tiêu đề cho dialog
        dialog.setTitle("Đăng Ký");
        //khai báo button trong dialog để bắt sự kiện
        Button bntthoat = (Button) dialog.findViewById(R.id.btnThoat);
        Button bntluu = (Button) dialog.findViewById(R.id.btnLuu);
        final EditText EditTen, Edittuoi, Editgioitinh, Editnghanh, Editlop;
        EditTen = (EditText) dialog.findViewById(R.id.EditTen);
        Edittuoi = (EditText) dialog.findViewById(R.id.EditTuoi);
        Editgioitinh = (EditText) dialog.findViewById(R.id.EditGioiTinh);
        Editnghanh = (EditText) dialog.findViewById(R.id.EditNghanh);
        Editlop = (EditText) dialog.findViewById(R.id.EditLop);



        //set các giá trị hiện thời của sinh viên cần sửa
        Editgioitinh.setText(sinhviensua.getGioitinh());
        Editlop.setText(sinhviensua.getLop());
        Editnghanh.setText(sinhviensua.getNghanh());

        Edittuoi.setText(sinhviensua.getTuoi() + "");
        EditTen.setText(sinhviensua.getTen());
        //bắt sự kiện cho nút đăng k
        bntluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arsinhvien.set(vitri, new SinhVien(EditTen.getText().toString(),Editlop.getText().toString(),Integer.valueOf(Edittuoi.getText().toString()),Editgioitinh.getText().toString(),Editnghanh.getText().toString()));
                adaptersinhvien.notifyDataSetChanged();

                Toast.makeText(MainActivity.this, "Bạn vừa đăng ký thành công" + EditTen.getText(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();


            }
        });
        bntthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sự kiện đóng dialog chỉnh sửa
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void dialogthem(final SinhVien sinhviensua) {
        //khởi tạo dialog
        final Dialog dialog = new Dialog(MainActivity.this);
        //xét layout cho dialog
        dialog.setContentView(R.layout.layout_custom_dialog);
        //xét tiêu đề cho dialog
        dialog.setTitle("Đăng Ký");
        //khai báo button trong dialog để bắt sự kiện
        Button bntthoat = (Button) dialog.findViewById(R.id.btnThoat);
        Button bntluu = (Button) dialog.findViewById(R.id.btnLuu);
        final EditText EditTen, Edittuoi, Editgioitinh, Editnghanh, Editlop;
        EditTen = (EditText) dialog.findViewById(R.id.EditTen);
        Edittuoi = (EditText) dialog.findViewById(R.id.EditTuoi);
        Editgioitinh = (EditText) dialog.findViewById(R.id.EditGioiTinh);
        Editnghanh = (EditText) dialog.findViewById(R.id.EditNghanh);
        Editlop = (EditText) dialog.findViewById(R.id.EditLop);



        //set các giá trị hiện thời của sinh viên cần sửa

        //bắt sự kiện cho nút đăng k
        bntluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTen = EditTen.getText().toString();
                String gettuoi = Edittuoi.getText().toString();
                String getgioitinh = Editgioitinh.getText().toString();
                String getnhanh = Editnghanh.getText().toString();
                String getlop = Editlop.getText().toString();
                if(getTen.equals("")||gettuoi.equals("")||getgioitinh.equals("")||getnhanh.equals("")||getlop.equals("")){
                    Toast.makeText(MainActivity.this, "Bạn Phải Nhập Đầy Đủ Thông Tin", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, " Thêm Thành Công", Toast.LENGTH_SHORT).show();
                    arsinhvien.add( new SinhVien(EditTen.getText().toString(),Editlop.getText().toString(),Integer.valueOf(Edittuoi.getText().toString()),Editgioitinh.getText().toString(),Editnghanh.getText().toString()));
                    adaptersinhvien.notifyDataSetChanged();


                    dialog.dismiss();
                }



            }
        });
        bntthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sự kiện đóng dialog chỉnh sửa
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menuitemthem){
            SinhVien sinhvien = new SinhVien();
            dialogthem(sinhvien);

        }if(item.getItemId()==R.id.menuitemabout){
            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}



