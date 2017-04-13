package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.nhungnguyen.firstproject.Adapters.AdapterPagerMap;
import com.example.nhungnguyen.firstproject.Models.Markers;
import com.example.nhungnguyen.firstproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.PageSelected;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.activity_maps)
public class MapsFragment extends Fragment implements AdapterPagerMap.ClickPagerMap {
    List<Markers> mData = new ArrayList<>();
    AdapterPagerMap mAdapter;
    private GoogleMap mMap;
    Marker mFMarker;
    final MarkerOptions markerOptions = new MarkerOptions();
    private final List<Marker> mMarkers = new ArrayList<>();
    @ViewById(R.id.viewPagerMap)
    ViewPager mViewPager;
    @ViewById(R.id.mapView)
    MapView mMapView;
    @AfterViews
    void init(){
        mData = loadData();
        mAdapter = new AdapterPagerMap(getView().getContext(), mData, this);
        mViewPager.setAdapter(mAdapter);
        MapFragment supportMapFragment = MapFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.mapView, supportMapFragment).commit();
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
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
    }
    @PageSelected(R.id.viewPagerMap)
    void setPageSelectViewPager(int position){
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
    public void setOnClick(final int pos) {

    }
}
