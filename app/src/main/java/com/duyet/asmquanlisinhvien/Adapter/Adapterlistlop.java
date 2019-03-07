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
import com.duyet.asmquanlisinhvien.model.LopHoc;

import java.util.ArrayList;

/**
 * Created by DUYET on 27/08/2017.
 */

public class Adapterlistlop extends ArrayAdapter<LopHoc> {
    int re;
    ArrayList<LopHoc> ar;
    Context c;

    public Adapterlistlop(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<LopHoc> objects) {
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
            viewholo.twmalop = (TextView) view.findViewById(R.id.twmalop);
            viewholo.twtenlop = (TextView) view.findViewById(R.id.twtenlop);
            viewholo.twmanghanh = (TextView) view.findViewById(R.id.twnganh);

            view.setTag(viewholo);
        }else {
            viewholo = (Viewholo)view.getTag();
        }
        final LopHoc sinhvienhientai = ar.get(position);
        viewholo.twmalop.setText(sinhvienhientai.getMalop());
        viewholo.twtenlop.setText(sinhvienhientai.getTenlop());
        viewholo.twmanghanh.setText(sinhvienhientai.getTennghanh());
        return view;
    }
    public class Viewholo{;
        TextView twmalop;
        TextView twtenlop;
        TextView twmanghanh;
    }
}
