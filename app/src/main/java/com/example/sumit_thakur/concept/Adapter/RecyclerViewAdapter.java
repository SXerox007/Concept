package com.example.sumit_thakur.concept.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sumit_thakur.concept.Constants.Constants;
import com.example.sumit_thakur.concept.FinalActivity;
import com.example.sumit_thakur.concept.Model.BaseModel;
import com.example.sumit_thakur.concept.R;

import java.util.ArrayList;

/**
 * Recycler View Adapter
 */
public class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Constants {

    private Context context;
    private ArrayList<BaseModel> userInfo;
    private String mMode;

    /**
     * @param context  context
     * @param userInfo userInfo Arraylist
     * @param mMode    mMode
     */
    public RecyclerViewAdapter(final Context context, final ArrayList<BaseModel> userInfo, final String mMode) {
        this.context = context;
        this.userInfo = userInfo;
        this.mMode = mMode;
    }


    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        context = parent.getContext();
        View convertView;
        convertView = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        BaseModel obj = userInfo.get(position);
        if (mMode.equals(UP_COMING)) {
            holder.tvTitleName.setText("item:-");
            holder.tvUserName.setText(obj.getmName());
        } else if (mMode.equals(PAST)) {
            holder.tvTitleName.setText("item:-");
            holder.tvUserName.setText(obj.getmName());
        } else {
            holder.tvUserName.setText(obj.getmName());
        }
    }

    @Override
    public int getItemCount() {
        return userInfo.size();
    }

    @Override
    public void extra() {

    }

    /**
     * View Holder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvUserName, tvTitleName;

        /**
         * @param itemView item View
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvName);
            tvTitleName = (TextView) itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(final View v) {
            final int pos = getAdapterPosition();
            Intent intent = new Intent(context, FinalActivity.class);
            context.startActivity(intent);
        }
    }
}
