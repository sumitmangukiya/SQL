package com.example.sql.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sql.R;
import com.example.sql.adapter.HomeImageAdapter;
import com.example.sql.model.Home;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;

public class ApICallingActivity extends AppCompatActivity {
    ArrayList<Home> homelist = new ArrayList<>();
    HomeImageAdapter homeImageAdapter;
    RecyclerView homelistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ap_icalling);
        homelistview = findViewById(R.id.homelistview);

        getDataFromAPI();
    }

    private void getDataFromAPI() {
        String url = "https://script.google.com/macros/s/AKfycbxuPHRgdidAjeA497B9HjxnUSiUNnA3mr65NjpOaj1mDdchfBycYo15rcaW4M16kqDt/exec?action=getWall";
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Home[] home = gson.fromJson(String.valueOf(response), Home[].class);
                homelist.addAll(Arrays.asList(home));

                GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 3);
                homelistview.setLayoutManager(manager);
                homelistview.setHasFixedSize(true);
                homeImageAdapter = new HomeImageAdapter(ApICallingActivity.this, homelist);
                homelistview.setAdapter(homeImageAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}