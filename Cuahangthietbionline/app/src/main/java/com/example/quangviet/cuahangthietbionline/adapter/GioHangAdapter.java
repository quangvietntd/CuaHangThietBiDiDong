package com.example.quangviet.cuahangthietbionline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.activity.GioHangActivity;
import com.example.quangviet.cuahangthietbionline.activity.MainActivity;
import com.example.quangviet.cuahangthietbionline.model.GioHang;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {
    Context context;
    ArrayList<GioHang> gioHangArrayList;

    public GioHangAdapter(Context context, ArrayList<GioHang> gioHangArrayList) {
        this.context = context;
        this.gioHangArrayList = gioHangArrayList;
    }

    @Override
    public int getCount() {
        return gioHangArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return gioHangArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public ImageView imgGioHang;
        public TextView txtTenGioHang,txtGiaGioHang;
        public Button btnTangSoLuongGioHang,btnGiamSoLuongGioHang,btnSoLuongGioHang;

    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
       //final ViewHolder viewHolder =null;
        final ViewHolder viewHolder;
        if (view==null){
             viewHolder = new ViewHolder();
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = layoutInflater.inflate(R.layout.dong_giohang,null);
            view = LayoutInflater.from(context).inflate(R.layout.dong_giohang,null);
            viewHolder.txtTenGioHang = view.findViewById(R.id.textviewTenGioHang);
            viewHolder.txtGiaGioHang = view.findViewById(R.id.textviewGiaGioHang);
            viewHolder.imgGioHang = view.findViewById(R.id.imageviewGioHang);
            viewHolder.btnSoLuongGioHang = view.findViewById(R.id.btnSoLuongGioHang);
            viewHolder.btnTangSoLuongGioHang = view.findViewById(R.id.btnTangSoLuongGioHang);
            viewHolder.btnGiamSoLuongGioHang = view.findViewById(R.id.btnGiamSoLuongGioHang);
            view.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GioHang gioHang = (GioHang) getItem(i);
        viewHolder.txtTenGioHang.setText(gioHang.getTenSP());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGiaGioHang.setText(decimalFormat.format(gioHang.getGiaSP())+" Đ");
//        Picasso.with(context).load(gioHang.getHinhSP())
//                                .placeholder(R.drawable.noimage)
//                                .error(R.drawable.error)
//                                .into(viewHolder.imgGioHang);
        Glide.with(context).load(gioHang.getHinhSP())
                .into(viewHolder.imgGioHang);
        viewHolder.btnSoLuongGioHang.setText(gioHang.getSoLuong()+"");
        final int sl = Integer.parseInt(viewHolder.btnSoLuongGioHang.getText().toString());
        if (sl>=10){
            viewHolder.btnGiamSoLuongGioHang.setVisibility(View.VISIBLE);
            viewHolder.btnTangSoLuongGioHang.setVisibility(View.INVISIBLE);
        }else if (sl<=1){
            viewHolder.btnGiamSoLuongGioHang.setVisibility(View.INVISIBLE);
            viewHolder.btnTangSoLuongGioHang.setVisibility(View.VISIBLE);
        }else if (sl>=1){
            viewHolder.btnTangSoLuongGioHang.setVisibility(View.VISIBLE);
            viewHolder.btnGiamSoLuongGioHang.setVisibility(View.VISIBLE);
        }
        viewHolder.btnTangSoLuongGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slMoiNhat = Integer.parseInt(viewHolder.btnSoLuongGioHang.getText().toString()) +1;
                int slHienTai = MainActivity.gioHangArrayList.get(i).getSoLuong();
                long giaHienTai = MainActivity.gioHangArrayList.get(i).getGiaSP();
                MainActivity.gioHangArrayList.get(i).setSoLuong(slMoiNhat);
                long giaMoiNhat = (giaHienTai * slMoiNhat)/slHienTai;
                MainActivity.gioHangArrayList.get(i).setGiaSP(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.txtGiaGioHang.setText(decimalFormat.format(giaMoiNhat) +" Đ");
                GioHangActivity.EventUtil();
                if (slMoiNhat >9){
                    viewHolder.btnTangSoLuongGioHang.setVisibility(View.INVISIBLE);
                    viewHolder.btnGiamSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnSoLuongGioHang.setText(slMoiNhat+"");
                }else {
                    viewHolder.btnTangSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnGiamSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnSoLuongGioHang.setText(slMoiNhat+"");
                }
            }
        });
        viewHolder.btnGiamSoLuongGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slMoiNhat = Integer.parseInt(viewHolder.btnSoLuongGioHang.getText().toString()) -1;
                int slHienTai = MainActivity.gioHangArrayList.get(i).getSoLuong();
                long giaHienTai = MainActivity.gioHangArrayList.get(i).getGiaSP();
                MainActivity.gioHangArrayList.get(i).setSoLuong(slMoiNhat);
                long giaMoiNhat = (giaHienTai * slMoiNhat)/slHienTai;
                MainActivity.gioHangArrayList.get(i).setGiaSP(giaMoiNhat);
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                viewHolder.txtGiaGioHang.setText(decimalFormat.format(giaMoiNhat) +" Đ");
                GioHangActivity.EventUtil();
                if (slMoiNhat <2){
                    viewHolder.btnTangSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnGiamSoLuongGioHang.setVisibility(View.INVISIBLE);
                    viewHolder.btnSoLuongGioHang.setText(slMoiNhat+"");
                }else {
                    viewHolder.btnTangSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnGiamSoLuongGioHang.setVisibility(View.VISIBLE);
                    viewHolder.btnSoLuongGioHang.setText(slMoiNhat+"");
                }
            }
        });

        return view;
    }
}
