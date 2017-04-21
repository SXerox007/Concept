package com.example.sumit_thakur.concept;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sumit_thakur.concept.Adapter.RecyclerViewAdapter;
import com.example.sumit_thakur.concept.BaseActivity.BaseActivity;
import com.example.sumit_thakur.concept.Model.BaseModel;

import java.util.ArrayList;

/**
 * Home Activity
 */
public class HomeActivity extends BaseActivity {
    private ArrayList<BaseModel> userInfo;
    private RecyclerView recyclerView;
    private BaseModel user1, user2;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        userInfo.add(user1);
        userInfo.add(user2);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, userInfo, "");
        recyclerView = (RecyclerView) findViewById(R.id.rvHome);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }

    /**
     * initilization
     */
    private void init() {
        userInfo = new ArrayList<>();
        user1 = new BaseModel("Sumit Thakur");
        user2 = new BaseModel("Hello World");
    }
}
