package exmaple.acadgild.com.activitylifecycle.Class5.PendingIntent_1;

/**
 * Created by divyanshu on 02/04/16.
 */
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import exmaple.acadgild.com.activitylifecycle.R;

public class PendingIntentActivity2 extends Activity{

    TextView v1;
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendingintent2);
        v1 = (TextView)findViewById(R.id.text);
        v1.setTextSize(30);
        v1.setText("Welcome to pendinIntent");
    }

}
