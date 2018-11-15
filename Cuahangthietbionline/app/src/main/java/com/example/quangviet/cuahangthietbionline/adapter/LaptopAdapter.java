package com.example.quangviet.cuahangthietbionline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;


import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LaptopAdapter extends BaseAdapter {

    Context context;
    ArrayList<Sanpham> mangLaptop;

    public LaptopAdapter(Context context, ArrayList<Sanpham> mangLaptop) {
        this.context = context;
        this.mangLaptop = mangLaptop;
    }

    @Override
    public int getCount() {
        return mangLaptop.size();
    }

    @Override
    public Object getItem(int i) {
        return mangLaptop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Sanpham laptop = mangLaptop.get(i);
        ViewHolder viewHolder;
        if (view==null){
            viewHolder =new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.dong_laptop,null);
            viewHolder.imgLaptop = view.findViewById(R.id.imageviewlaptop);
            viewHolder.txtGiaLaptop = view.findViewById(R.id.textviewgialaptop);
            viewHolder.txtMotaLaptop = view.findViewById(R.id.textviewmotalaptop);
            viewHolder.txtTenLaptop = view.findViewById(R.id.textviewtenlaptop);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
//            Picasso.with(context).load(laptop.getHinhanhsp())
////                    .placeholder(R.drawable.noimage)
////                    .error(R.drawable.error)
////                    .into(viewHolder.imgLaptop);
        Glide.with(context).load(laptop.getHinhanhsp())
                .into(viewHolder.imgLaptop);
            viewHolder.txtTenLaptop.setText(laptop.getTensp());
            DecimalFormat decimalFormat=new DecimalFormat("###,###,###");
            viewHolder.txtGiaLaptop.setText("Giá: "+decimalFormat.format(laptop.getGiasp())+" Đ");
            viewHolder.txtMotaLaptop.setText(laptop.getMotasp());
            viewHolder.txtMotaLaptop.setMaxLines(2);
            viewHolder.txtMotaLaptop.setEllipsize(TextUtils.TruncateAt.END);
        return view;
    }
    public class ViewHolder{
        ImageView imgLaptop;
        TextView txtTenLaptop,txtGiaLaptop,txtMotaLaptop;
    }

}
