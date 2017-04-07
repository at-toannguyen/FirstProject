package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhungnguyen.firstproject.Adapters.AdapterPagerMap;
import com.example.nhungnguyen.firstproject.Models.Markers;
import com.example.nhungnguyen.firstproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;
import java.util.List;


public class MapsFragment extends Fragment implements AdapterPagerMap.ClickPagerMap {
    List<Markers> mData = new ArrayList<>();
    AdapterPagerMap mAdapter;
    private GoogleMap mMap;
    private MapView mMapView;
    Marker mFMarker;
    final MarkerOptions markerOptions = new MarkerOptions();
    private ViewPager mViewPager;
    private final List<Marker> mMarkers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_maps, container, false);
        mMapView = (MapView) view.findViewById(R.id.mapView);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPagerMap);
        mData = loadData();
        mAdapter = new AdapterPagerMap(view.getContext(), mData, this);
        mViewPager.setAdapter(mAdapter);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.getUiSettings().setMapToolbarEnabled(true);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(16.0741042, 108.233353), 16));
                for (int i = 0; i < mData.size(); i++) {
                    markerOptions.position(new LatLng(mData.get(i).getItude(), mData.get(i).getLongitude()));
                    if (i == 0) {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_select));
                    } else {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location));
                    }
                    Marker marker = mMap.addMarker(markerOptions);
                    mMarkers.add(marker);
//                    mMarker.setPosition(new LatLng(mData.get(i).getItude(),mData.get(i).getLongitude()));
//                    mMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location));
                }
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        for (int i = 0; i < mMarkers.size(); i++) {
                            if (marker.equals(mMarkers.get(i))) {
                                mViewPager.setCurrentItem(i);
                            }
                        }
                        return true;
                    }
                });
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Markers item = mData.get(position);
                mMarkers.get(position).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_select));
                for (int i = 0; i < mMarkers.size(); i++) {
                    if (position == 0) {
                        mMarkers.get(position).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location_select));
                    }
                    if(i!=position) {
                        mMarkers.get(i).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location));
                    }
                }
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(item.getItude(), item.getLongitude()), 16));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
//    private void setSelectedMarker(int pos){
//        if (pos==-1){}else {
//        markerOptions.position(new LatLng(mData.get(pos).getItude(), mData.get(pos).getLongitude()));
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_location));
//        mMarkers.get(pos).remove();
//        Marker marker = mMap.addMarker(markerOptions);
//        mMarkers.add(marker);}
//    }

    private List<Markers> loadData() {
        mData.add(new Markers(16.0741042f, 108.233353f));
        mData.add(new Markers(16.0770811f, 108.2313433f));
        mData.add(new Markers(16.0748031f, 108.2300563f));
        mData.add(new Markers(16.0746541f, 108.2348036f));
        mData.add(new Markers(16.0743189f, 108.2329445f));
        mData.add(new Markers(16.077194f, 108.231859f));
        mData.add(new Markers(16.0769595f, 108.2341549f));
        mData.add(new Markers(16.0770097f, 108.2345814f));
        mData.add(new Markers(16.076211f, 108.235590f));
        return mData;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void setOnClick(final int pos) {

    }
}
