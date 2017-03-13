package com.example.nhungnguyen.firstproject.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.DataItemTestLayout;
import com.example.nhungnguyen.firstproject.OnLoadMoreListener;
import com.example.nhungnguyen.firstproject.R;
import com.example.nhungnguyen.firstproject.TestLayoutActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiantech on 3/10/17.
 */
// TODO: 3/10/17
public class TestLayoutRecyclerAdapter extends RecyclerView.Adapter<TestLayoutRecyclerAdapter.RecyclerViewHolder> {
    private List<DataItemTestLayout> mDataTestLayout = new ArrayList<>();
    private final onItemClickListner mItemClick;
    private final int VIEW_TYPE_ITEM = 1;
    private final int VIEW_TYPE_LOADING = 0;
    private Context context;
    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading;
    private int visibleTheshold = 5;
    private int lastVisibleItem, totalItemCount;

    public TestLayoutRecyclerAdapter(List<DataItemTestLayout> mDataTestLayout,onItemClickListner listner, Context context, RecyclerView recylerview) {
        this.mDataTestLayout = mDataTestLayout;
        this.mItemClick = listner;
        this.context = context;
//        mDataTestLayout=mDataTestLayout;
        if (recylerview.getLayoutManager() instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recylerview.getLayoutManager();
            recylerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleTheshold)) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadmore();
                        }
                        isLoading = true;
                    }
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDataTestLayout.get(position) != null ? VIEW_TYPE_ITEM:VIEW_TYPE_LOADING;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerViewHolder viewHolder;
        if (viewType==VIEW_TYPE_ITEM){
            View layoutView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout,parent,false);
            viewHolder=new RecyclerViewHolder(layoutView,mItemClick);
        }else {
            View layoutView=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_loading_item,parent,false);
            viewHolder=new ProcessViewHolder(layoutView,mItemClick);
        }
        return viewHolder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if(holder instanceof RecyclerViewHolder){
            holder.mTvUser.setText(mDataTestLayout.get(position).getTvUser());
            holder.mTvAge.setText(mDataTestLayout.get(position).getTvAge());
            holder.mTvContent.setText(mDataTestLayout.get(position).getTvContent());
            holder.favorite.setBackgroundResource(mDataTestLayout.get(position).getFavorite());
        }else {
            ((ProcessViewHolder)holder).mProcessBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return mDataTestLayout.size();
    }
    public void setLoaded(){
        isLoading=false;
    }

    public  class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvUser, mTvAge, mTvContent;
        private ImageView mImgPerson,favorite;

        public RecyclerViewHolder(final View itemView, final onItemClickListner o) {
            super(itemView);
            mTvUser = (TextView) itemView.findViewById(R.id.tvPerson1);
            mTvAge = (TextView) itemView.findViewById(R.id.tvPerson2);
            mTvContent = (TextView) itemView.findViewById(R.id.tvPerson3);
            mImgPerson = (ImageView) itemView.findViewById(R.id.imgPerson);
            favorite=(ImageView) itemView.findViewById(R.id.imgFavorite);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    o.onItemClick(getLayoutPosition(),mDataTestLayout.get(getLayoutPosition()));
                }
            });
            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    favorite.setBackgroundResource(R.drawable.ic_star_check);
                }
            });
        }
    }
    public class ProcessViewHolder extends RecyclerViewHolder {
        private ProgressBar mProcessBar;
        public ProcessViewHolder(View itemView,onItemClickListner o) {
            super(itemView,o);
            mProcessBar=(ProgressBar) itemView.findViewById(R.id.progressBarUser);
        }
    }

    public interface onItemClickListner {
        public void onItemClick(int poisision,DataItemTestLayout ob );
    }
}
