package com.example.quangviet.cuahangthietbionline.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.model.GioHang;
import com.example.quangviet.cuahangthietbionline.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

public class ChiTietSanPham extends AppCompatActivity {

    Toolbar toolbarChiTietSanPham;
    ImageView imgChiTietSanPham;
    TextView txtTenSP, txtGiaSP, txtMoTaSP;
    Spinner spinner;
    Button btnDatMua;


//Khai bao toan cuc de co the su dung lai
    int id = 0;
    String tenChiTietSP = "";
    int giaChiTietSP = 0;
    String hinhAnhChiTiet = "";
    String moTaChiTiet = "";
    int idSanPham = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);
        addControl();
        actionToolbar();
        getInformation();
        catchEventSpinner();
        catchEventButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menushoppingcart,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuGioHang:
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void catchEventButton() {
        btnDatMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MainActivity.gioHangArrayList.size()>0){
                    int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                    boolean exists = false;
                    for(int i=0;i<MainActivity.gioHangArrayList.size();i++){
                        if (id==MainActivity.gioHangArrayList.get(i).getIdSP()){
                            MainActivity.gioHangArrayList.get(i).setSoLuong(MainActivity.gioHangArrayList.get(i).getSoLuong()+soLuong);
                            if (MainActivity.gioHangArrayList.get(i).getSoLuong()>10){
                                MainActivity.gioHangArrayList.get(i).setSoLuong(10);
                            }
                            MainActivity.gioHangArrayList.get(i).setGiaSP(MainActivity.gioHangArrayList.get(i).getSoLuong()*giaChiTietSP);
                            exists = true;
                        }
                    }
                    if (exists==false){
                        long giaMoi = soLuong * giaChiTietSP;
                        MainActivity.gioHangArrayList.add(new GioHang(id,tenChiTietSP,giaMoi,hinhAnhChiTiet,soLuong));

                    }

                }else {
                    int soLuong = Integer.parseInt(spinner.getSelectedItem().toString());
                    long giaMoi = soLuong * giaChiTietSP;
                    MainActivity.gioHangArrayList.add(new GioHang(id,tenChiTietSP,giaMoi,hinhAnhChiTiet,soLuong));

                }
                Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
                startActivity(intent);
            }
        });
    }

    private void catchEventSpinner() {
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(getApplicationContext(),R.layout.spinner_item,soluong);
        spinner.setAdapter(arrayAdapter);

    }

    private void getInformation() {
        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id = sanpham.getId();
        tenChiTietSP = sanpham.getTensp();
        giaChiTietSP = sanpham.getGiasp();
        hinhAnhChiTiet = sanpham.getHinhanhsp();
        moTaChiTiet = sanpham.getMotasp();
        idSanPham = sanpham.getIdsanpham();
        txtTenSP.setText(tenChiTietSP);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGiaSP.setText("Giá: "+decimalFormat.format(giaChiTietSP)+" Đ");
        txtMoTaSP.setText(moTaChiTiet);
//        Picasso.with(getApplicationContext()).load(hinhAnhChiTiet)
//                            .placeholder(R.drawable.noimage)
//                            .error(R.drawable.error)
//                            .into(imgChiTietSanPham);
        Glide.with(getApplicationContext()).load(hinhAnhChiTiet)
                .into(imgChiTietSanPham);
    }

    private void actionToolbar() {
        setSupportActionBar(toolbarChiTietSanPham);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarChiTietSanPham.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        toolbarChiTietSanPham = findViewById(R.id.toolbarChiTietSanPham);
        imgChiTietSanPham = findViewById(R.id.imgSanPham);
        txtTenSP = findViewById(R.id.txtTenSanPham);
        txtGiaSP = findViewById(R.id.txtGiaSanPham);
        txtMoTaSP = findViewById(R.id.txtMoTaSanPham);
        spinner = findViewById(R.id.spinner);
        btnDatMua = findViewById(R.id.btnDatMua);
    }
}
