package com.example.quangviet.cuahangthietbionline.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DienthoaiAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> dienthoaiArraylist;

    public DienthoaiAdapter(Context context, ArrayList<Sanpham> dienthoaiArraylist) {
        this.context = context;
        this.dienthoaiArraylist = dienthoaiArraylist;
    }

    @Override
    public int getCount() {
        return dienthoaiArraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return dienthoaiArraylist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder =null;
        if(view==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_dienthoai,null);
            viewHolder.txttendienthoai = view.findViewById(R.id.textviewdienthoai);
            viewHolder.txtgiadienthoai = view.findViewById(R.id.textviewgiadienthoai);
            viewHolder.txtmotadienthoai = view.findViewById(R.id.textviewmotadienthoai);
            viewHolder.imgdienthoai = view.findViewById(R.id.imageviewdienthoai);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttendienthoai.setText(sanpham.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiadienthoai.setText("Giá: "+decimalFormat.format(sanpham.getGiasp())+ " Đ");
        viewHolder.txtmotadienthoai.setMaxLines(2);
        viewHolder.txtmotadienthoai.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotadienthoai.setText(sanpham.getMotasp());
//        Picasso.with(context).load(sanpham.getHinhanhsp())
//                        .placeholder(R.drawable.noimage)
//                        .error(R.drawable.error)
//                        .into(viewHolder.imgdienthoai);
        Glide.with(context).load(sanpham.getHinhanhsp())
                .into(viewHolder.imgdienthoai);

        return view;
    }

    public class ViewHolder{
         TextView txttendienthoai, txtgiadienthoai, txtmotadienthoai;
         ImageView imgdienthoai;

    }
}
