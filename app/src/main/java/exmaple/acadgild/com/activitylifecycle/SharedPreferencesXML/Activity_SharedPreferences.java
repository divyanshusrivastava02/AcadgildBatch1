package exmaple.acadgild.com.activitylifecycle.SharedPreferencesXML;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 10/04/16.
 */
public class Activity_SharedPreferences  extends Activity{

    Button btn_settings , btn_show;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sharedpreferences);


        btn_settings = (Button)findViewById(R.id.btn_settings);
        btn_show = (Button)findViewById(R.id.btn_show);


        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_SharedPreferences.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_SharedPreferences.this, ShowActivity.class);
                startActivity(intent);
            }
        });


        username = (EditText)findViewById(R.id.username);
         password= (EditText)findViewById(R.id.password);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("Acadgild", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();


        //STORING THE VALUES
        editor.putBoolean("key1",true);
        editor.putInt("key2",23432);
        editor.putFloat("key3", 3.1f);
        editor.putLong("key4", 2333325252l);
        editor.putString("key5","SAMPATH");

        editor.commit();



        // GETTING THE VALES
        boolean Key1 = pref.getBoolean("key1",false);
        int key2 = pref.getInt("key2",0);
        float key3 = pref.getFloat("key3",0.0f);
        long key4 = pref.getLong("key4",0l);
        String key5 = pref.getString("key5","DIVYANSHU");


        //DELETING

//        editor.remove("key5");
//        editor.commit();


        //CLEAN
//        editor.clear();
//        editor.commit();
//
        username.setText(key5);
        password.setText(key2+"");

    }
}
