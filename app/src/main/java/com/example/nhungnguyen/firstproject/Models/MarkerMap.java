package com.example.nhungnguyen.firstproject.Models;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Copy right asiantech
 * Created by asiantech on 3/31/17.
 */

public class MarkerMap implements ClusterItem {
    private final LatLng position;
    private final String title;
    private final String snipper;

    public MarkerMap(double lat, double lng, String title, String mnipper) {
        this.title = title;
        this.snipper = mnipper;
        position = new LatLng(lat,lng);
    }


    @Override
    public LatLng getPosition() {
        return position;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSnippet() {
        return snipper;
    }
}
