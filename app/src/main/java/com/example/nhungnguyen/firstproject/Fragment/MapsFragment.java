package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhungnguyen.firstproject.Adapters.TestAdapterViewpager;
import com.example.nhungnguyen.firstproject.Models.MarkerMap;
import com.example.nhungnguyen.firstproject.Models.Markers;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapsFragment extends Fragment implements TestAdapterViewpager.OnClickItemViewpager {
    List<UserItem> mData = new ArrayList<>();
    TestAdapterViewpager mAdapter;
    private GoogleMap mMap;
    private MapView mMapView;
    private ClusterManager<MarkerMap> clusterManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_maps, container, false);
        mMapView = (MapView) view.findViewById(R.id.mapView);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPagerMap);
        mData = loadData();
        mAdapter = new TestAdapterViewpager(view.getContext(), mData, this);
        viewPager.setAdapter(mAdapter);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
                mMap.getUiSettings().setMapToolbarEnabled(true);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(16.0741042,108.233353),16));
                clusterManager=new ClusterManager<>(getActivity(),mMap);
                mMap.setOnCameraIdleListener(clusterManager);
                mMap.setOnMarkerClickListener(clusterManager);
                addItems();
                ArrayList<Markers> markerses = new ArrayList<Markers>();
                for (int i=1;i<=10;i++){
                    markerses.add(new Markers(16.0741042f+ (float) i/2000,108.233353f+(float)i/2000,"aaaa","bbbbbb"));
                }
                for (int i = 0; i < markerses.size(); i++) {
                    createMarker(markerses.get(i).getItude(), markerses.get(i).getLongitude(), markerses.get(i).getTitle(), markerses.get(i).getSnippet());
                }
//                LatLng sydney = new LatLng(16.0741042, 108.233353);
//
//                Marker mMarker = mMap.addMarker(new MarkerOptions()
//                        .position(sydney)
//                        .title("Marker Title")
//                        .snippet("Marker Description"));
//                mMarker.showInfoWindow();
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(16).build();
//                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        return view;
    }
    private Marker createMarker(double latitude, double longitude, String title, String snippet) {
        return mMap.addMarker(new MarkerOptions()
                .position(new LatLng(latitude, longitude))
                .title(title)
                .snippet(snippet));
    }

    private void addItems(){
        double lat=16.0741042;
        double lng=108.233353;
        String title="aaaaa";
        String snippet="bbbbbb";
        for (int i=0;i<10;i++){
            double offset=i/1000;
            lat+=offset;
            lng+=offset;
            MarkerMap info=new MarkerMap(lat,lng,title,snippet);
            clusterManager.addItem(info);
        }
    }

    private List<UserItem> loadData() {
        String id;
        String name;
        String age;
        String content;
        for (int i = 1; i <= 20; i++) {
            id = "" + i;
            name = "person " + i;
            age = "Age: " + i;
            if (i % 2 == 0) {
                content = "Hello";
            } else {
                content = "Hi";
            }
            String URL = "http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-dep.jpg";
            mData.add(new UserItem(id, name, age, content, URL));
        }
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
    public void onClick(int position) {

    }
}
