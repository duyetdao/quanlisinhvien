package com.duyet.asmquanlisinhvien.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.duyet.asmquanlisinhvien.R;
import com.duyet.asmquanlisinhvien.model.MonHoc;

import java.util.ArrayList;

/**
 * Created by DUYET on 27/08/2017.
 */

public class Adapterlistmon extends ArrayAdapter<MonHoc> {
    int re;
    ArrayList<MonHoc> ar;
    Context c;
    public Adapterlistmon(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<MonHoc> objects) {
        super(context, resource, objects);
        this.re = resource;
        this.c = context;
        this.ar = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        Viewholo viewholo;
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(c);
            view = layoutInflater.inflate(re, null);
            viewholo = new Viewholo();
            viewholo.twmamon = (TextView) view.findViewById(R.id.twmamon);
            viewholo.twtenmon = (TextView) view.findViewById(R.id.twtenmon);

            view.setTag(viewholo);
        }else {
            viewholo = (Viewholo)view.getTag();
        }
        final MonHoc sinhvienhientai = ar.get(position);
        viewholo.twmamon.setText(sinhvienhientai.getMalop());
        viewholo.twtenmon.setText(sinhvienhientai.getTenlop());
        return view;
    }
    public class Viewholo{;
        TextView twmamon;
        TextView twtenmon;
    }
}
