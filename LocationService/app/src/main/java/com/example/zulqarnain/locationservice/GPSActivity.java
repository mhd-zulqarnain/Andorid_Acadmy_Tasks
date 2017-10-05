package com.example.zulqarnain.locationservice;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by Zul Qarnain on 9/22/2017.
 */

public class GPSActivity implements LocationListener {

    Context mContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    LocationManager locationManager;
    double latitude;
    double longitude;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
    public GPSActivity(Context context) {
        this.mContext = context;
    }

    public void getLocation() {
        locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        Location location = null;

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Log.d("asd", "getLocation: request denied");
        } else {


        }

        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (isGPSEnabled) {
            location = getLastKnownLocation();
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Toast.makeText(mContext, latitude + " " + longitude, Toast.LENGTH_LONG).show();
            updatedb();
        } else if (isNetworkEnabled) {
            locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    MIN_TIME_BW_UPDATES,
                    MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            Toast.makeText(mContext, latitude + " " + longitude, Toast.LENGTH_LONG).show();
            updatedb();
        }


    }

    public void updatedb() {
            ApiInterface apiInterface = ApiClint.getApiClint().create(ApiInterface.class);
            Call<String> call = apiInterface.addLoc(latitude, longitude);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String val = response.body();
                    Messege.messege(mContext, val);
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Messege.messege(mContext, "error");
                }
            });

    }

    private Location getLastKnownLocation() {
        locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                Log.d("asd", "getLocation: request denied");
            }
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
