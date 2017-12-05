package edu.fatec.alfredo;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import java.util.List;

public class GPS implements LocationListener {

    private GoogleMap map;
    private List<Marker> markersBD;
    private Calculation calc = new Calculation();

    public GPS(GoogleMap map, List<Marker> markers){

        this.map = map;
        this.markersBD = markers;
    }

    @Override
    public void onLocationChanged(Location location) {

        Marker m = new Marker(location.getLatitude(), location.getLongitude(), "");
        Double distance = calc.CalculationByDistance(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(this.markersBD.get(0).getLat(), this.markersBD.get(0).getLon()));
        Integer dist = distance.intValue(); //dist em metros
    }


    @Override
    public void onProviderDisabled(String provider) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
