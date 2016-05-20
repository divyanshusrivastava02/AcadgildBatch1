package exmaple.acadgild.com.activitylifecycle.Intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 02/04/16.
 */
public class Activity_exm extends Activity {
    TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exm);


//        Bundle bundle = getIntent().getExtras();
//
//        String name = bundle.getString("NAME");

        Intent userNameIntent = getIntent();
        String userName = getIntent().getStringExtra("NAME");
        boolean isRegisteredBool = getIntent().getBooleanExtra("isRegistered", false);

        textName = (TextView) findViewById(R.id.textName);
        if (isRegisteredBool)
            textName.setText("WELCOME " + userName + " HAVE A GOOD DAY" + " You are a authorized person");
        else
            textName.setText("PLEASE GO BACK " + userName + " HAVE A GOOD DAY" + " You are not a authorized person");


    }
}
