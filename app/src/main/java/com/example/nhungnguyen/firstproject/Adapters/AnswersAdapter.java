package com.example.nhungnguyen.firstproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Models.Item;
import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Copy right asiantech
 * Created by asiantech on 4/5/17.
 */

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {

    private List<Item> mItems;
    private final Context mContext;
    private final PostItemListener mItemListener;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView titleTv;
        private final ImageView image;
        private final TextView idtext;
        private final TextView rate;
        final PostItemListener mItemListener;

        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            idtext=(TextView) itemView.findViewById(R.id.idname);
            titleTv = (TextView) itemView.findViewById(R.id.name);
            rate=(TextView) itemView.findViewById(R.id.rate);
            image = (ImageView) itemView.findViewById(R.id.img);
            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Item item = getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getAnswerId());

            notifyDataSetChanged();
        }
    }

    public AnswersAdapter(Context context, List<Item> posts, PostItemListener itemListener) {
        mItems = posts;
        mContext = context;
        mItemListener = itemListener;
    }

    @Override
    public AnswersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postView = inflater.inflate(R.layout.item_layout_api, parent, false);

        return new ViewHolder(postView, this.mItemListener);
    }

    @Override
    public void onBindViewHolder(AnswersAdapter.ViewHolder holder, int position) {

        Item item = mItems.get(position);
        holder.idtext.setText(String.valueOf(item.getOwner().getUser_id()));
        holder.titleTv.setText(item.getOwner().getDisplay_name());
        holder.rate.setText(String.valueOf(item.getOwner().getAccept_rate()));
        Picasso.with(mContext).load(item.getOwner().getProfile_image()).into(holder.image);
//        TextView textView = holder.titleTv;
//        ImageView imageView=holder.imageView;
//        textView.setText(item.getOwner().getDisplay_name());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void updateAnswers(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }

    public interface PostItemListener {
        void onPostClick(long id);
    }
}
