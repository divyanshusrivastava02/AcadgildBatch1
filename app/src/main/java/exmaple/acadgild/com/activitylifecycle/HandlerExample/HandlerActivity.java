package exmaple.acadgild.com.activitylifecycle.HandlerExample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.lang.ref.WeakReference;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 08/05/16.
 */
public class HandlerActivity extends Activity {

    private  final static int SET_PROGRESS_BAR_VISIBILITY = 0;
    private  final static int PROGRESS_UPDATE = 1;
    private  final static int SET_BITMAP = 2;


    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private int mDelay = 500;


    static class UIHandler extends Handler{
        WeakReference<HandlerActivity> mParent;

        public UIHandler(WeakReference<HandlerActivity> parent){
            mParent = parent;
        }

        @Override
        public void handleMessage(Message msg) {
            HandlerActivity parent = mParent.get();

            if(null!=parent){
                switch (msg.what){
                    case SET_PROGRESS_BAR_VISIBILITY:
                        parent.getmProgressBar().setVisibility((Integer) msg.obj);
                        break;

                    case PROGRESS_UPDATE:
                        parent.getmProgressBar().setProgress((Integer)msg.obj);
                        break;
                    case SET_BITMAP:
                        parent.getmImageView().setImageBitmap((Bitmap)msg.obj);
                        break;
                }
            }
        }
    }


    Handler handler = new UIHandler(new WeakReference<HandlerActivity>(this));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_handler);

        mImageView = (ImageView)findViewById(R.id.imageView);
        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);

        final Button button = (Button)findViewById(R.id.loadButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new LoadIconTask(R.drawable.painter,handler)).start();
            }
        });
    }


    private class LoadIconTask implements Runnable{
        private  final int resID;
        private  final Handler handler;

        LoadIconTask(int resID, Handler handler){
            this.resID = resID;
            this.handler = handler;
        }

        @Override
        public void run() {
            Message msg = handler.obtainMessage(SET_PROGRESS_BAR_VISIBILITY,ProgressBar.VISIBLE);
            handler.sendMessage(msg);

            final Bitmap tmp = BitmapFactory.decodeResource(getResources(),resID);

            for(int i=1; i<11 ;i++){
                sleep();
                msg = handler.obtainMessage(PROGRESS_UPDATE, i*10);
                handler.sendMessage(msg);
            }

            msg = handler.obtainMessage(SET_BITMAP,tmp);
            handler.sendMessage(msg);


            msg =handler.obtainMessage(SET_PROGRESS_BAR_VISIBILITY,ProgressBar.INVISIBLE);
            handler.sendMessage(msg);
        }


    }


    private void sleep(){
        try{
            Thread.sleep(mDelay);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    public ImageView getmImageView(){
        return  mImageView;
    }
    public  ProgressBar getmProgressBar(){
        return mProgressBar;
    }
}
