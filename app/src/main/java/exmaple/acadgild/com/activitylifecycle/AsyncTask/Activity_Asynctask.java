package exmaple.acadgild.com.activitylifecycle.AsyncTask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 10/04/16.
 */
public class Activity_Asynctask  extends Activity {

    private  final static  String TAG = "Thread cycle";
    ImageView mImageView;
    ProgressBar mProgressBar;
    int mDelay = 500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        mImageView = (ImageView)findViewById(R.id.imageview2);
        mProgressBar = (ProgressBar)findViewById(R.id.progressbar);


        Button button = (Button)findViewById(R.id.loadbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoadIconTask().execute(R.drawable.ic_electeric_bill);
            }
        });
    }



    class LoadIconTask extends AsyncTask<Integer,Integer,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... params) {
            Bitmap tmp = BitmapFactory.decodeResource(getResources(),params[0]);

            for(int i = 1; i<11 ; i++){
                sleep();
                publishProgress(i*10);

            }
            return tmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
//            super.onProgressUpdate(values);
            mProgressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
//            super.onPostExecute(bitmap);
            mProgressBar.setVisibility(ProgressBar.INVISIBLE);
            mImageView.setImageBitmap(bitmap);
        }

        public void sleep()
        {
            try{
                Thread.sleep(mDelay);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
