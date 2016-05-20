package exmaple.acadgild.com.activitylifecycle.BroadcastReceiversExample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by divyanshu on 14/05/16.
 */
public class UserDefinedBroadcastReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.acadgild.own")){
            StringBuilder msgStr = new StringBuilder("Current Time : ");
            Format formatter = new SimpleDateFormat("hh:mm:ss a");
            msgStr.append(formatter.format(new Date()));
            Toast.makeText(context,msgStr, Toast.LENGTH_SHORT).show();
        }
    }
}
