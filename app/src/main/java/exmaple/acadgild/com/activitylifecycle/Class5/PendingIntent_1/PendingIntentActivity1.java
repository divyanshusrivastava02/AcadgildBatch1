package exmaple.acadgild.com.activitylifecycle.Class5.PendingIntent_1;

/**
 * Created by divyanshu on 02/04/16.
 */
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

public class PendingIntentActivity1 extends Activity {
    Button b1;
    PendingIntent pendingIntent;
    Context mContext;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahil);
        mContext = this.getApplicationContext();
        b1 = (Button) findViewById(R.id.btn_submit);
        Intent intent = new Intent();
        intent.setClass(PendingIntentActivity1.this,PendingIntentActivity2.class);
        pendingIntent =  PendingIntent.getActivity(mContext, 0, intent, 0);

        b1.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              //  call();
                Intent intent = new Intent();
                try {
                    pendingIntent.send(mContext, 0, intent);

                } catch (PendingIntent.CanceledException e) {
                    // the stack trace isn't very helpful here.  Just log the exception message.
                    System.out.println( "Sending contentIntent failed: " );
                }
            }
        });

    }



    private void call() {
        try {
            String number = "+9654676533";
            Intent phoneIntent = new Intent(Intent.ACTION_CALL);
            phoneIntent.setData(Uri.parse("tel:"+ number));
            startActivity(phoneIntent);


        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(PendingIntentActivity1.this,
                    "Call failed, please try again later!", Toast.LENGTH_SHORT).show();
        }
    }
}
