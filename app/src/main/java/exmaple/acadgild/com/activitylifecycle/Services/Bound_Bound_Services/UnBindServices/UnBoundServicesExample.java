package exmaple.acadgild.com.activitylifecycle.Services.Bound_Bound_Services.UnBindServices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import exmaple.acadgild.com.activitylifecycle.R;


/**
 * Created by divyanshu on 15/05/16.
 */
public class UnBoundServicesExample extends Activity implements View.OnClickListener {

    Button startServiceBTN,stopServiceBTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unboundservices);

        startServiceBTN = (Button)findViewById(R.id.startService);
        stopServiceBTN = (Button)findViewById(R.id.stopService);

        startServiceBTN.setOnClickListener(this);
        stopServiceBTN.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.startService:
                Intent startIntent = new Intent(UnBoundServicesExample.this, MyUnBoundService.class);
                startService(startIntent);
                break;

            case R.id.stopService:
                Intent stopIntent = new Intent(UnBoundServicesExample.this, MyUnBoundService.class);
                stopService(stopIntent);
                break;
        }

    }
}
