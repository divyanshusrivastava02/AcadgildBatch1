package exmaple.acadgild.com.activitylifecycle.BroadcastReceiversExample;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 14/05/16.
 */
public class RegisterUnregister extends Activity {

    UserDefinedBroadcastReceiver broadcastReceiver = new UserDefinedBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unregister);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_enable_disable,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.menu_on_off){
            Intent intent = new Intent();
            intent.setAction("com.acadgild.own");
            sendBroadcast(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void registerBroadcastReceiver(View view){
        this.registerReceiver(broadcastReceiver, new IntentFilter("com.acadgild.own"));
        Toast.makeText(this,"Enabled broadcast receiver",Toast.LENGTH_SHORT).show();
    }

    public void unregisterBroadcastReceiver(View view){
        this.unregisterReceiver(broadcastReceiver);

        Toast.makeText(this,"Disable broadcast receiver",Toast.LENGTH_SHORT).show();
    }
}
