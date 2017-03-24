package com.example.nhungnguyen.firstproject.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class TestAdapterViewpager extends PagerAdapter {
    private final Context context;
    private List<UserItem> mData = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private ImageView mImgFavorite;

    public TestAdapterViewpager(Context context, List<UserItem> items) {
        this.context = context;
        this.mData = items;
        this.layoutInflater = (LayoutInflater) this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = this.layoutInflater.inflate(R.layout.item_list_user_layout, container, false);
        TextView mTvId = (TextView) view.findViewById(R.id.tvIdUser);
        ImageView mImgUser = (ImageView) view.findViewById(R.id.imgPerson);
        TextView mTvUser = (TextView) view.findViewById(R.id.tvPerson1);
        TextView mTvAge = (TextView) view.findViewById(R.id.tvPerson2);
        TextView mTvContent = (TextView) view.findViewById(R.id.tvPerson3);
        mImgFavorite = (ImageView) view.findViewById(R.id.imgFavorite);
        final UserItem item = this.mData.get(position);
        mTvId.setText(item.getId());
        Picasso.with(container.getContext())
                .load(item.getImgPerson())
                .centerCrop()
                .error(R.drawable.img_person1)
                .fit()
                .into(mImgUser);
        mTvUser.setText(item.getTvUser());
        mTvAge.setText(item.getTvAge());
        mTvContent.setText(item.getTvContent());

        mImgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImgFavorite.setSelected(!mImgFavorite.isSelected());
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, item.getTvContent(), Toast.LENGTH_SHORT).show();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
