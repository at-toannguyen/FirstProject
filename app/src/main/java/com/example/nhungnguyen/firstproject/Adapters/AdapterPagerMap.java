package com.example.nhungnguyen.firstproject.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Models.Markers;
import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Copy right asiantech
 * Created by asiantech on 4/3/17.
 */

public class AdapterPagerMap extends PagerAdapter {
    private final Context mContext;
    private List<Markers> markerList=new ArrayList<>();
    private final LayoutInflater mInflater;
    private final ClickPagerMap mListener;

    public AdapterPagerMap(Context mContext,List<Markers> list,ClickPagerMap listener) {
        this.mContext = mContext;
        this.markerList=list;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService(this.mContext.LAYOUT_INFLATER_SERVICE);
        mListener=listener;
    }

    @Override
    public int getCount() {
        return markerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view=this.mInflater.inflate(R.layout.item_map_pager_layout,container,false);
        ImageView imgInfMakers= (ImageView) view.findViewById(R.id.imgItemMap);
        TextView tvInl=(TextView) view.findViewById(R.id.tvInl);
        TextView tvLnl=(TextView) view.findViewById(R.id.tvLnl);
        Markers item=markerList.get(position);
        tvInl.setText(String.valueOf(item.getItude()));
        tvLnl.setText(String.valueOf(item.getLongitude()));
        Picasso.with(mContext).load(R.drawable.img_person1).into(imgInfMakers);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.setOnClick(position);
            }
        });
        container.addView(view);

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
    public interface ClickPagerMap{
        void setOnClick(int pos);
    }
}
