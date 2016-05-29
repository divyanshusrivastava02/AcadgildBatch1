package exmaple.acadgild.com.activitylifecycle.GoogleMapExample;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DateFormat;
import java.util.Date;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 28/05/16.
 */
public class GoogleMapEXMP extends FragmentActivity implements GoogleMap.OnMapClickListener,GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private GoogleMap mMap;
    private static final  String TAG = "LocationActivity";
    private static final  long INTERVAL  = 1000*10;
    private static final  long FASTEST_INTERVAL = 1000 * 5;

    // NOIDA LOCATION   28.535516, 77.391026
    double lat= 28.535516 ;
    double lng= 77.391026 ;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    String mLastUpdateTime;


    protected void createLocationRequest(){
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(INTERVAL);
        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title("ACADGILD"));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_googlemap);

        if(!isGooglePlayServicesAvailable()){
            finish();
        }
        createLocationRequest();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();


        setUpMapIfNeeded();


    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
    }

    private boolean isGooglePlayServicesAvailable(){
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(ConnectionResult.SUCCESS == status){
            return  true;
        }else{
            GooglePlayServicesUtil.getErrorDialog(status,this,0).show();
            return false;
        }
    }
    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
    }

    protected void startLocationUpdates(){

        PendingResult<Status> pendingResult = LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,mLocationRequest,this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mCurrentLocation = location;
        mLastUpdateTime  = DateFormat.getTimeInstance().format(new Date());
        updateUI();
    }

    public void updateUI(){
        if(null!= mCurrentLocation){
             lat = mCurrentLocation.getLatitude();
             lng = mCurrentLocation.getLongitude();
//            tvLocation.setText("AT Time: "+mLastUpdateTime +"\n" +
//                    "Longitude: "+lng +"\n"+
//                    "Latitude : "+lat + "\n"+
//                    "Accuracy: "+ mCurrentLocation.getAccuracy() + "\n"+
//                    "Provider: "+ mCurrentLocation.getProvider());
          //  setUpMapIfNeeded();
            setUpMap();
        }else {

        }
    }



    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    protected void stopLocationUpdates(){
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient,this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        if(mGoogleApiClient.isConnected()){
            startLocationUpdates();
        }
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
        mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title("Welcome to NOIDA"));

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(lat, lng));

        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        mMap.moveCamera(center);
        mMap.animateCamera(zoom);
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }
}





//#############################################


//<resources>     <string name="google_maps_key_instructions" templateMergeStrategy="replace"><!--      TODO: Before you run your application, you need a Google Maps API key.      To get one, follow this link, follow the directions and press "Create" at the end:  https://console.developers.google.com/flows/enableapi?apiid=maps_android_backend&keyType=CLIENT_SIDE_ANDROID&r=B3:F9:25:57:00:3F:F8:83:FD:E4:BC:D9:BA:BA:BA:34:C4:7B:80:8D%3Bgoogleapp.gsisp.admin.googlemapexample      You can also add your credentials to an existing key, using this line:     B3:F9:25:57:00:3F:F8:83:FD:E4:BC:D9:BA:BA:BA:34:C4:7B:80:8D;googleapp.gsisp.admin.googlemapexample      Once you have your key (it starts with "AIza"), replace the "google_maps_key"     string in this file.     --></string>      <string name="google_maps_key" templateMergeStrategy="preserve">AIzaSyB1jwmQV_rqtxUSmEB_91z3_kZqch3Tiqk</string> </resources>
