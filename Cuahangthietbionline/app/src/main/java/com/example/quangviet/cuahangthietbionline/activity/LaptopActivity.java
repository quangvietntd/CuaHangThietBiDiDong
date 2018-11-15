package com.example.quangviet.cuahangthietbionline.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.adapter.LaptopAdapter;
import com.example.quangviet.cuahangthietbionline.model.Sanpham;
import com.example.quangviet.cuahangthietbionline.ultil.CheckConnection;
import com.example.quangviet.cuahangthietbionline.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LaptopActivity extends AppCompatActivity {

    ListView lvLaptop;
    ArrayList<Sanpham> mangLaptop,results;
    LaptopAdapter laptopAdapter;
    Toolbar toolbarLaptop;

    int page=1;
    int idsanpham;

    View footerView;
    MyHandler myHandler;
    Boolean isLoading =false;
    Boolean limitData = false; //xac nhan da het du lieu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);



        lvLaptop = findViewById(R.id.listviewlaptop);
        toolbarLaptop = findViewById(R.id.toolbarlaptop);
        addActionBar();

        //add footerView
        footerView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.progressbar,null);
        myHandler = new MyHandler();



        //lay id san pham
        Intent intent = getIntent();
        idsanpham = intent.getIntExtra("idloaisanpham",-1);

        //lam sao lay duoc gia tri dua vao mang
        mangLaptop = new ArrayList<>();
        results = new ArrayList<>();
        laptopAdapter = new LaptopAdapter(LaptopActivity.this,mangLaptop);
        lvLaptop.setAdapter(laptopAdapter);

        GetDuLieuSanPham(page);
        LoadMoreData();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menushoppingcart,menu);
        MenuItem itemSearch = menu.findItem(R.id.mnuSearch);
        SearchView searchView = (SearchView) itemSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (limitData==false) {
                    for (int i = 0; i < 10; i++) {
                        GetDuLieuSanPham(++page);
                    }
                    limitData=true;
                }
//                while (limitData==false){
//                    GetDuLieuSanPham(++page);
//                }
                ArrayList<Sanpham> tmp = new ArrayList<>();
                for(Sanpham s: results){
                    if (s.getTensp().toLowerCase().contains(newText.toLowerCase())){
                        tmp.add(s);
                    }
                    if(tmp.size()>0){
                        mangLaptop.clear();
                        mangLaptop.addAll(tmp);
                        laptopAdapter.notifyDataSetChanged();
                    }

                    if (tmp.isEmpty()){
                        mangLaptop.clear();
                        laptopAdapter.notifyDataSetChanged();
                        //Toast.makeText(MainActivity.this,"khong tim thay",Toast.LENGTH_LONG);
                    }
                }

                return false;
            }
        });
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

    public void addActionBar(){
        setSupportActionBar(toolbarLaptop);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarLaptop.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    lvLaptop.addFooterView(footerView);
                    break;
                case 1:
                    GetDuLieuSanPham(++page); //tang bien page len 1 roi moi thuc hien function
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class ThreadData extends Thread{
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = myHandler.obtainMessage(1);
            myHandler.sendMessage(message);
            super.run();
        }
    }

    private void LoadMoreData(){
        lvLaptop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LaptopActivity.this,ChiTietSanPham.class);
                intent.putExtra("thongtinsanpham",mangLaptop.get(i));
                startActivity(intent);
            }
        });
        lvLaptop.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstItem, int visibleItem, int totalItem) {
                if (firstItem+visibleItem==totalItem && totalItem!=0 && isLoading==false && limitData==false){
                    isLoading=true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });

    }

    public void GetDuLieuSanPham(int Page){

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdansanpham+Page;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response!=null && response.length()!=2){
                    lvLaptop.removeFooterView(footerView);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i =0;i<jsonArray.length();i++){
                            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                            int id = jsonObject.getInt("id");
                            String tensp= jsonObject.getString("tensp");
                            Integer giasp = jsonObject.getInt("giasp");
                            String hinhanhsp = jsonObject.getString("hinhanhsp");
                            String motasp = jsonObject.getString("motasp");
                            int idsanpham = jsonObject.getInt("idsanpham");
                            mangLaptop.add(new Sanpham(id,tensp,giasp,hinhanhsp,motasp,idsanpham));
                            results.add(new Sanpham(id,tensp,giasp,hinhanhsp,motasp,idsanpham));
                        }
                        laptopAdapter.notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else {
                    limitData = true;
                    lvLaptop.removeFooterView(footerView);
                  //  CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu!");

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("idsanpham",String.valueOf(idsanpham));
                return hashMap;
            }
        };

        requestQueue.add(stringRequest);


    }
}
