package exmaple.acadgild.com.activitylifecycle.ANR;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 08/05/16.
 */
public class ANR  extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anr);


    }


    public void ButtonClick(View view){

        long endTime = System.currentTimeMillis() + 20*1000;

        while(System.currentTimeMillis()< endTime){
            synchronized (this){
                try{
                    wait(endTime - System.currentTimeMillis());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        TextView mTextView = (TextView)findViewById(R.id.textViewANR);
        mTextView.setText("BUTTON PRESSED");
    }
}
