package com.duyet.asmquanlisinhvien.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.duyet.asmquanlisinhvien.Main2Activity;
import com.duyet.asmquanlisinhvien.MyFun;
import com.duyet.asmquanlisinhvien.R;
import com.duyet.asmquanlisinhvien.model.SinhVien;

import java.util.ArrayList;

import static com.duyet.asmquanlisinhvien.R.id.InfoItem;

/**
 * Created by DUYET on 15/08/2017.
 */

public class AdapterlistviewSinhVien extends ArrayAdapter<SinhVien> {
    int re;
    ArrayList<SinhVien> ar;
    Context c;

    public AdapterlistviewSinhVien(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<SinhVien> objects) {
        super(context, resource, objects);
        this.re=resource;
        this.c=context;
        this.ar = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        final Viewholo viewholo;
        if(view==null){
            LayoutInflater layoutInflater = LayoutInflater.from(c);
            view = layoutInflater.inflate(re, null);
            viewholo = new Viewholo();
            //ánh sạ chỉ 1 lần
            viewholo.textviewten=(TextView)view.findViewById(R.id.textviewten);
            viewholo.textviewlop=(TextView)view.findViewById(R.id.textviewlop);
            viewholo.textviewnghanh=(TextView)view.findViewById(R.id.textviewnghanh);
            viewholo.avatar=(ImageView)view.findViewById(R.id.img);
            viewholo.buttonthem=(ImageView) view.findViewById(R.id.imgthem);
            //set tag cho view
            view.setTag(viewholo);
        }else {
            //lấy lại tag bên trên
            viewholo=(Viewholo)view.getTag();
        }
        //lấy tên sinh viên tại vị trí posison
        final SinhVien sinhvienhientai = ar.get(position);
        //gán giá trị lên các text view
        viewholo.textviewten.setText(sinhvienhientai.getTen());
        viewholo.textviewlop.setText(sinhvienhientai.getLop());
        viewholo.textviewnghanh.setText(sinhvienhientai.getNghanh());
        if(sinhvienhientai.getGioitinh().toUpperCase().equals("NAM")){
            viewholo.avatar.setImageResource(R.drawable.boy);
        }else {
            viewholo.avatar.setImageResource(R.drawable.girl);
        }
        viewholo.buttonthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowmenuItem(v,position);

            }
        });
        return view;
    }
    public void ShowmenuItem(View view, final int vitri) {
        PopupMenu popupMenu = new PopupMenu(c, view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_item_listview, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.RemoveItem) {
                    //xóa sinh viên được lựa chọn

                    ar.remove(vitri);
                    //gọi hàm thông báo có sự thay đổi
                    notifyDataSetChanged();


                } else if (item.getItemId() == R.id.EditItem) {

                    dialogsua(ar.get(vitri),vitri);



                } else if (item.getItemId() == InfoItem) {

                    MyFun myFun = new MyFun();
                    myFun.Ham1(c,ar,vitri,Main2Activity.class);

                }
                return false;
            }
        });
        popupMenu.show();
    }
    public void dialogsua(final SinhVien sinhviensua, final int vitri) {
        //khởi tạo dialog
        final Dialog dialog = new Dialog(c);
        //xét layout cho dialog
        dialog.setContentView(R.layout.layout_custom_dialog);
        //xét tiêu đề cho dialog
        dialog.setTitle("Sửa Sinh Viên");
        //khai báo button trong dialog để bắt sự kiện
        Button bntthoat = (Button) dialog.findViewById(R.id.btnThoat);
        Button bntluu = (Button) dialog.findViewById(R.id.btnLuu);
        final EditText EditTen, Edittuoi, Editgioitinh, Editnghanh, Editlop;
        EditTen = (EditText) dialog.findViewById(R.id.EditTen);
        Edittuoi = (EditText) dialog.findViewById(R.id.EditTuoi);
        Editgioitinh = (EditText) dialog.findViewById(R.id.EditGioiTinh);
        Editnghanh = (EditText) dialog.findViewById(R.id.EditNghanh);
        Editlop = (EditText) dialog.findViewById(R.id.EditLop);





//        String chon = sinhviensua.getGioitinh();
//        for (int i = 0;i<=argioitinh.size();i++){
//            if (chon.equals(spinergioitinh.getSelectedItem().toString().toUpperCase())==false){
//                spinergioitinh.setSelection(i);
//            }
//        }
        //cách 1
//        int vitriselected=argioitinh.indexOf(sinhviensua.getGioitinh().toUpperCase());
//        spinergioitinh.setSelection(vitriselected);
        //cách 2


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
                ar.set(vitri, new SinhVien(EditTen.getText().toString(),Editlop.getText().toString(),Integer.valueOf(Edittuoi.getText().toString()),Editgioitinh.getText().toString(),Editnghanh.getText().toString()));
                notifyDataSetChanged();
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

    public  class Viewholo{
        TextView textviewten;
        TextView textviewlop;
        TextView textviewnghanh;
        ImageView avatar;
        ImageView buttonthem;
    }
}
