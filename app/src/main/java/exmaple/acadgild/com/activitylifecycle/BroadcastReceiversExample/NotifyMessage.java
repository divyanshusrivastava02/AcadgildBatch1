package exmaple.acadgild.com.activitylifecycle.BroadcastReceiversExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by divyanshu on 14/05/16.
 */
public class NotifyMessage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView txt = new TextView(this);
        txt.setText("NOTIFICATION");
        setContentView(txt);
    }
}
