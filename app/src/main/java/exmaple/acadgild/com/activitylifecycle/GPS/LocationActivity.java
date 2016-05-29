package exmaple.acadgild.com.activitylifecycle.GPS;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 29/05/16.
 */
public class LocationActivity extends Activity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener
{

    private static final  String TAG = "LocationActivity";
    private static final  long INTERVAL  = 1000*10;
    private static final  long FASTEST_INTERVAL = 1000 * 5;
    Button btnFusedLocation;
    TextView tvLocation;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isGooglePlayServicesAvailable()){
            finish();
        }
        createLocationRequest();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        setContentView(R.layout.activity_location_gps);
        tvLocation = (TextView)findViewById(R.id.tvLocation);

        btnFusedLocation = (Button)findViewById(R.id.btnShowLocation);
        btnFusedLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });

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
            String lat = String.valueOf(mCurrentLocation.getLatitude());
            String lng = String.valueOf(mCurrentLocation.getLongitude());
            tvLocation.setText("AT Time: "+mLastUpdateTime +"\n" +
            "Longitude: "+lng +"\n"+
            "Latitude : "+lat + "\n"+
            "Accuracy: "+ mCurrentLocation.getAccuracy() + "\n"+
            "Provider: "+ mCurrentLocation.getProvider());
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
        if(mGoogleApiClient.isConnected()){
            startLocationUpdates();
        }
    }
}
