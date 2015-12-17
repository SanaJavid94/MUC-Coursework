package com.example.sanajavid1.coursework;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GymLocator extends FragmentActivity {

    List<GymMapData> mapDataList;

    public Marker[] mapDataMarkerList = new Marker[10];
    public GoogleMap mapGymLocations;

    private LatLng latLngGym = new LatLng(55.865432, -4.260145);

    private float markerColour[] = {210.0f, 210.0f, 210.0f, 210.0f, 210.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mapDataList = new ArrayList<GymMapData>();
        GymMapDataDBMgr mapDB = new GymMapDataDBMgr(this, "xercise4LessDB.s3db", null, 1);
        try {
            mapDB.dbCreate();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mapDataList = mapDB.allMapData();
        SetUpMap();
        AddMarkers();
    }

    public void SetUpMap() {
        mapGymLocations = ((MapFragment) getFragmentManager().findFragmentById(R.id.gymMap)).getMap();
        if (mapGymLocations != null) {
            mapGymLocations.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngGym, 12));
            mapGymLocations.setMyLocationEnabled(true);
            mapGymLocations.getUiSettings().setCompassEnabled(true);
            mapGymLocations.getUiSettings().setMyLocationButtonEnabled(true);
            mapGymLocations.getUiSettings().setRotateGesturesEnabled(true);
        }
    }

    public void AddMarkers() {
        MarkerOptions marker;
        GymMapData mapData;
        String mrkTitle;
        String mrkText;

        for (int i = 0; i < mapDataList.size(); i++) {
            mapData = mapDataList.get(i);
            mrkTitle = "Gym Area: " + mapData.getGymArea();
            mrkText = "Address: " + mapData.getGymAddress();
            marker = SetMarker(mrkTitle, mrkText, new LatLng(mapData.getLatitude(), mapData.getLongitude()), markerColour[i], true);
            mapDataMarkerList[i] = mapGymLocations.addMarker(marker);
        }
    }

    public MarkerOptions SetMarker(String title, String snippet, LatLng position, float markerColour, boolean centreAnchor) {
        float anchorX;
        float anchorY;

        if (centreAnchor) {
            anchorX = 0.5f;
            anchorY = 0.5f;
        } else {
            anchorX = 0.5f;
            anchorY = 1f;
        }

        MarkerOptions marker = new MarkerOptions().title(title).snippet(snippet).icon(BitmapDescriptorFactory.defaultMarker(markerColour)).anchor(anchorX, anchorY).position(position);

        return marker;
    }
}