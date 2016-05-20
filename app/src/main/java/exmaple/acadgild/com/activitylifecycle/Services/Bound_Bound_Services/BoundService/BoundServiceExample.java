package exmaple.acadgild.com.activitylifecycle.Services.Bound_Bound_Services.BoundService;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 15/05/16.
 */
public class BoundServiceExample extends Activity {

    private  int REQUEST_CODE = 101;
    private int NOTIFICATION_ID = 102;
    private boolean isBound;

    private BoundService serviceReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unboundservices);
        Toast.makeText(getApplicationContext(),"ONCRETAE ACTIVITY CALLED",Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,BoundService.class);
        startService(intent);
        sendNotification();


        Button startButton = (Button)findViewById(R.id.startService);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBound){
                    serviceReference.startPlay();
                }
            }
        });


        Button stopService = (Button)findViewById(R.id.stopService);
        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serviceReference.stopPlay();
            }
        });
    }


    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            serviceReference  = ((BoundService.MyLocalBinder)service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            serviceReference = null;
            isBound = false;
        }
    };

    private void doUnbindService(){
        Toast.makeText(getApplicationContext(),"UNBIND SERVICE CALLED",Toast.LENGTH_SHORT).show();
        unbindService(myConnection);
        isBound = false;
    }

    private void doBindToService(){
        Toast.makeText(getApplicationContext(),"BIND SERVICE CALLED",Toast.LENGTH_SHORT).show();
        if(!isBound){
            Intent bindIntent = new Intent(this,BoundService.class);
            isBound = bindService(bindIntent,myConnection,Context.BIND_AUTO_CREATE);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"onStart Activity CALLED",Toast.LENGTH_SHORT).show();
        doBindToService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop Activity CALLED",Toast.LENGTH_SHORT).show();
        doUnbindService();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy Activity CALLED",Toast.LENGTH_SHORT).show();
        if(isFinishing()){
            Intent intentStopService = new Intent(this,BoundService.class);
            stopService(intentStopService);
        }
    }

    private void sendNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_contact)
                .setContentTitle("Service running")
                .setTicker("Music Palying")
                .setWhen(System.currentTimeMillis()).setOngoing(true);

        Intent startIntent = new Intent(this,BoundServiceExample.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,REQUEST_CODE,startIntent,0);
        builder.setContentIntent(contentIntent);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID,notification);

    }
}
