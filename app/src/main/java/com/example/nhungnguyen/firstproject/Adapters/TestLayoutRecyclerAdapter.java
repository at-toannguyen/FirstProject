package com.example.nhungnguyen.firstproject.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Models.ItemList;
import com.example.nhungnguyen.firstproject.Models.TitleItem;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import java.util.List;


// TODO: 3/10/17
public class TestLayoutRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ItemList> mData;
    private final onItemClickListener mItemClickListener;


    public TestLayoutRecyclerAdapter(List<ItemList> mData, onItemClickListener listener) {
        this.mData = mData;
        this.mItemClickListener = listener;
    }


    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        final int VIEW_TYPE_USER = 2;
        if (viewType == VIEW_TYPE_USER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user_layout, parent, false);
            viewHolder = new UserViewHolder(layoutView);
        } else {
            final int VIEW_TYPE_TITLE = 1;
            if (viewType == VIEW_TYPE_TITLE) {
                View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_title_layout, parent, false);
                viewHolder = new TitleViewHolder(layoutView);
            }
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ItemList ob = mData.get(position);
        if (holder instanceof UserViewHolder) {
            if (ob instanceof UserItem) {
                ((UserViewHolder) holder).mTvUser.setText(((UserItem) ob).getTvUser());
                ((UserViewHolder) holder).mTvAge.setText(((UserItem) ob).getTvAge());
                ((UserViewHolder) holder).mTvContent.setText(((UserItem) ob).getTvContent());
                ((UserViewHolder) holder).favorite.setSelected(((UserItem) ob).isFavorite());
                ((UserViewHolder) holder).mImgPerson.setBackgroundResource(((UserItem) ob).getImgPerson());

                ((UserViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onItemClick(holder.getAdapterPosition());
                        }
                    }
                });
            }
        }
        if (holder instanceof TitleViewHolder) {
            if (ob instanceof TitleItem) {
                ((TitleViewHolder) holder).mTvTitle.setText(((TitleItem) ob).getTitle());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvUser;
        private final TextView mTvAge;
        private final TextView mTvContent;
        private final ImageView favorite;
        private final ImageView mImgPerson;

        public UserViewHolder(final View itemView) {
            super(itemView);
            mTvUser = (TextView) itemView.findViewById(R.id.tvPerson1);
            mTvAge = (TextView) itemView.findViewById(R.id.tvPerson2);
            mTvContent = (TextView) itemView.findViewById(R.id.tvPerson3);
            mImgPerson = (ImageView) itemView.findViewById(R.id.imgPerson);
            favorite = (ImageView) itemView.findViewById(R.id.imgFavorite);

            favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ItemList ob = mData.get(getAdapterPosition());
                    if (ob instanceof UserItem) {
                        ((UserItem) ob).setFavorite(!((UserItem) ob).isFavorite());
                        notifyDataSetChanged();
                    }
                }
            });

        }
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTvTitle;

        public TitleViewHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tvItemTitle);
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }
}
