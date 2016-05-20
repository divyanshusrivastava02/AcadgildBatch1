package exmaple.acadgild.com.activitylifecycle.Services.Bound_Bound_Services.BoundService;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 15/05/16.
 */
public class BoundService extends Service {

    private  final IBinder myBinder = new MyLocalBinder();
    private Thread backgroundThread;
    private MediaPlayer player;
    private int NOTIFIACTION_ID = 102;

    private String TAG = "bound";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

       // Toast.makeText(getApplicationContext(),"IBinder service method CALLED",Toast.LENGTH_SHORT).show();
        return myBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
               // Toast.makeText(getApplicationContext(),"Thread is running",Toast.LENGTH_SHORT).show();
                playMusic();
            }
        });
        backgroundThread.start();


//        new Thread()
//        {
//            public void run()
//            {
//                .runOnUiThread(new Runnable()
//                {
//                    public void run()
//                    {
//                        //Do your UI operations like dialog opening or Toast here
//                    }
//                });
//            }
//        }.start();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // Toast.makeText(getApplicationContext(),"onStartCommand is CALLED",Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    private void playMusic(){
        if(player !=null){
            player.release();
        }
        player = MediaPlayer.create(this, R.raw.music_thunder);
        player.setLooping(true);
    }


    public void startPlay(){
        if(!player.isPlaying()){
            player.start();
        }
    }

    public void stopPlay(){
        if(player.isPlaying()){
            player.pause();
        }
    }



    public class MyLocalBinder extends Binder{
        BoundService getService(){
            return  BoundService.this;
        }
    }


    @Override
    public void onDestroy() {
        //Toast.makeText(getApplicationContext(),"onDestroy is CALLED",Toast.LENGTH_SHORT).show();

        player.release();
        player = null;
        Thread dummy = backgroundThread;
        backgroundThread =null;
        dummy.interrupt();
        //backgroundThread.interrupt();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Toast.makeText(getApplicationContext(),"Canceling Notification is CALLED",Toast.LENGTH_SHORT).show();
        notificationManager.cancel(NOTIFIACTION_ID);
    }
}
