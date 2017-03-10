package com.example.nhungnguyen.firstproject.Adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.DataItemTestLayout;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17
public class TestLayoutRecyclerAdapter extends RecyclerView.Adapter<TestLayoutRecyclerAdapter.RecyclerViewHolder> {
    private List<DataItemTestLayout> mDataTestLayout = new ArrayList<>();

    public TestLayoutRecyclerAdapter(List<DataItemTestLayout> mDataTestLayout) {
        this.mDataTestLayout = mDataTestLayout;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.item_list_layout, parent, false);
        return new RecyclerViewHolder(itemview);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mTvUser.setText(mDataTestLayout.get(position).getTvUser());
        holder.mTvAge.setText(mDataTestLayout.get(position).getTvAge());
        holder.mTvContent.setText(mDataTestLayout.get(position).getTvContent());
        holder.mImgPerson.setBackground(mDataTestLayout.get(position).getImgPerson());
    }

    @Override
    public int getItemCount() {
        return mDataTestLayout.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvUser, mTvAge, mTvContent;
        private ImageView mImgPerson;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            mTvUser = (TextView) itemView.findViewById(R.id.tvPerson1);
            mTvAge = (TextView) itemView.findViewById(R.id.tvPerson2);
            mTvContent = (TextView) itemView.findViewById(R.id.tvPerson3);
            mImgPerson = (ImageView) itemView.findViewById(R.id.imgPerson);
        }
    }
}
