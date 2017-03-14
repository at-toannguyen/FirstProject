package com.example.nhungnguyen.firstproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.DataItemTestLayout;
import com.example.nhungnguyen.firstproject.OnLoadMoreListener;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17
public class TestLayoutRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<DataItemTestLayout> mDataTestLayout;
    private final onItemClickListner mItemClickListener;
    private final int VIEW_TYPE_ITEM = 1;
    private final int VIEW_TYPE_LOADING = 0;
    private Context context;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleTheshold = 5;
    private int lastVisibleItem, totalItemCount;

    public TestLayoutRecyclerAdapter(List<DataItemTestLayout> mDataTestLayout, onItemClickListner listner, Context context) {
        this.mDataTestLayout = mDataTestLayout;
        this.mItemClickListener = listner;
        this.context = context;
//       mDataTestLayout=mDataTestLayout;
        }


    @Override
    public int getItemViewType(int position) {
        return mDataTestLayout.get(position) != null ? VIEW_TYPE_ITEM : VIEW_TYPE_LOADING;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
        return new RecyclerViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerViewHolder) {
            ((RecyclerViewHolder) holder).mTvUser.setText(mDataTestLayout.get(position).getTvUser());
            ((RecyclerViewHolder) holder).mTvAge.setText(mDataTestLayout.get(position).getTvAge());
            ((RecyclerViewHolder) holder).mTvContent.setText(mDataTestLayout.get(position).getTvContent());
            ((RecyclerViewHolder) holder).favorite.setSelected(mDataTestLayout.get(position).isFavorite());

            ((RecyclerViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(holder.getAdapterPosition());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataTestLayout.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvUser, mTvAge, mTvContent;
        private ImageView favorite;

        public RecyclerViewHolder(final View itemView) {
            super(itemView);
            mTvUser = (TextView) itemView.findViewById(R.id.tvPerson1);
            mTvAge = (TextView) itemView.findViewById(R.id.tvPerson2);
            mTvContent = (TextView) itemView.findViewById(R.id.tvPerson3);
            favorite = (ImageView) itemView.findViewById(R.id.imgFavorite);

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDataTestLayout.get(getAdapterPosition()).setFavorite(!mDataTestLayout.get(getAdapterPosition()).isFavorite());
                    notifyDataSetChanged();
                }
            });

        }
    }
    public interface onItemClickListner {
        void onItemClick(int poisision);
    }
}
