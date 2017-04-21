package com.example.sumit_thakur.concept.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sumit_thakur.concept.Adapter.RecyclerViewAdapter;
import com.example.sumit_thakur.concept.Constants.Constants;
import com.example.sumit_thakur.concept.Model.BaseModel;
import com.example.sumit_thakur.concept.R;

import java.util.ArrayList;

/**
 * Pending Accept and complete abd cancel items data
 */
public class PendingAcceptandCompleteCancel extends Fragment implements Constants {

    private ArrayList<BaseModel> itemInfo;
    private BaseModel baseModel, baseModel2;
    private RecyclerView recyclerView;
    private String mMode;

    /**
     * @param mMode Mode
     */
    public PendingAcceptandCompleteCancel(final String mMode) {
        this.mMode = mMode;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pending_accept_merge, container, false);
        init();
        if (mMode.equals(UP_COMING)) {
            addData();
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), itemInfo, UP_COMING);
            recyclerView = (RecyclerView) view.findViewById(R.id.rvUpComingAndPast);
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerCodeSame();
        } else {
            addData();
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), itemInfo, PAST);
            recyclerView = (RecyclerView) view.findViewById(R.id.rvUpComingAndPast);
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerCodeSame();
        }
        return view;
    }

    /**
     * initilization
     */
    private void init() {
        itemInfo = new ArrayList<>();
        baseModel = new BaseModel("item1");
        baseModel2 = new BaseModel("item2");
    }

    /**
     * same code recycler view
     */
    private void recyclerCodeSame() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
    }

    /**
     * add data into arraylist
     */
    private void addData() {
        itemInfo.add(baseModel);
        itemInfo.add(baseModel2);
    }

    @Override
    public void extra() {

    }
}
