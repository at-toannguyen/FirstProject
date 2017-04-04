package com.example.nhungnguyen.firstproject.Models;

import com.google.android.gms.maps.model.LatLng;


/**
 * Copy right asiantech
 * Created by asiantech on 3/31/17.
 */

public class MarkerMap {
    private final LatLng position;
    private final String title;
    private final String snipper;

    public MarkerMap(double lat, double lng, String title, String mnipper) {
        this.title = title;
        this.snipper = mnipper;
        position = new LatLng(lat,lng);
    }

}
