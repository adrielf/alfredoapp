package edu.fatec.alfredo;

import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.location.Location;
import android.util.Log;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<Marker> markersBD;
    private LocationManager locationManager;
    private static final String TAG = "Provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

            Criteria criteria = new Criteria();

            String provider = locationManager.getBestProvider(criteria, true);

            mMap = googleMap;

            mMap.getUiSettings().setZoomControlsEnabled(true);

            mMap.setMyLocationEnabled(true);

            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null)
            {
                CameraUpdate center=CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
                CameraUpdate zoom=CameraUpdateFactory.zoomTo(11);
                mMap.moveCamera(center);
                mMap.animateCamera(zoom);
            }


        } catch (SecurityException ex) {
            Log.e(TAG, "Error", ex);
        }
    }

    public void onClickButton(Location location) {
        Marker m = new Marker(location.getLatitude(), location.getLongitude(), "");
        mMap.addMarker(new MarkerOptions().position(new LatLng(m.getLat(), m.getLon())).title("I am here, "+this.markersBD.get(0).getName()));

    }
}
