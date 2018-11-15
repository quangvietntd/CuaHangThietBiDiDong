package com.example.quangviet.cuahangthietbionline.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.quangviet.cuahangthietbionline.R;
import com.example.quangviet.cuahangthietbionline.adapter.SanphamAdapter;
import com.example.quangviet.cuahangthietbionline.model.Sanpham;
import com.example.quangviet.cuahangthietbionline.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotProductFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;


    public HotProductFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hot_product, container, false);
        recyclerView = view.findViewById(R.id.recyclerview2);
        mangsanpham = new ArrayList<>();
        sanphamAdapter = new SanphamAdapter(getContext(),mangsanpham);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(sanphamAdapter);
        GetDuLieuSPNoiBat();
        return view;
    }
    private void GetDuLieuSPNoiBat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Duongdansanphamnoibat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if(response!=null){
                    int id = 0;
                    String tensanpham = "";
                    Integer giasanpham =0;
                    String hinhanhsanpham ="";
                    String motasanpham = "";
                    int idsanpham = 0;
                    for(int i=0;i<response.length();i++){
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tensanpham = jsonObject.getString("tensp");
                            giasanpham = jsonObject.getInt("giasp");
                            hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            motasanpham = jsonObject.getString("motasp");
                            idsanpham = jsonObject.getInt("idsanpham");
                            mangsanpham.add(new Sanpham(id,tensanpham,giasanpham,hinhanhsanpham,motasanpham,idsanpham));
                            sanphamAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonArrayRequest);
    }

}
