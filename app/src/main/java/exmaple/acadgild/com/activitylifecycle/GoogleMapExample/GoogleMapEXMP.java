package exmaple.acadgild.com.activitylifecycle.GoogleMapExample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 28/05/16.
 */
public class GoogleMapEXMP extends FragmentActivity implements GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("ACADGILD"));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            if (mMap != null) {
                setUpMap();
            }
            mMap.setOnMapClickListener(this);
        }
    }


    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(28.535516, 77.391026)).title("Welcome to NOIDA"));

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(28.535516, 77.391026));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(18);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}





//#############################################


//<resources>     <string name="google_maps_key_instructions" templateMergeStrategy="replace"><!--      TODO: Before you run your application, you need a Google Maps API key.      To get one, follow this link, follow the directions and press "Create" at the end:  https://console.developers.google.com/flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID&r=B3:F9:25:57:00:3F:F8:83:FD:E4:BC:D9:BA:BA:BA:34:C4:7B:80:8D%3Bgoogleapp.gsisp.admin.googlemapexample      You can also add your credentials to an existing key, using this line:     B3:F9:25:57:00:3F:F8:83:FD:E4:BC:D9:BA:BA:BA:34:C4:7B:80:8D;googleapp.gsisp.admin.googlemapexample      Once you have your key (it starts with "AIza"), replace the "google_maps_key"     string in this file.     --></string>      <string name="google_maps_key" templateMergeStrategy="preserve">AIzaSyB1jwmQV_rqtxUSmEB_91z3_kZqch3Tiqk</string> </resources>
