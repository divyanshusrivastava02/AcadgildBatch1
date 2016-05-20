package exmaple.acadgild.com.activitylifecycle.SharedPreferencesXML;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 10/04/16.
 */
public class ShowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show);


        TextView tv_checkbox_preference1 = (TextView)findViewById(R.id.tv_checkbox_preference1);

        TextView tv_checkbox_preference2 = (TextView)findViewById(R.id.tv_checkbox_preference2);
        TextView tv_edittext_preference1 = (TextView)findViewById(R.id.tv_edittext_preference1);
        TextView tv_list_preference = (TextView)findViewById(R.id.tv_list_preference);
        TextView tv_ringtonne_preference = (TextView)findViewById(R.id.tv_ringtonne_preference);
        TextView tv_edittext_preference2 = (TextView)findViewById(R.id.tv_edittext_preference2);


        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());



        boolean cb1 = sp.getBoolean("cbp_checkbox_preference1",false);
        boolean cb2 = sp.getBoolean("cbp_checkbox_preference2",false);

        String edit1 = sp.getString("etp_edittext_preference1","NO TEXT DATA");
        String list = sp.getString("lp_list_preference","NOT SELECTED");
        String ringtone = sp.getString("rtp_ringtone_preference","NOT SELECTED");
        String edit2 = sp.getString("etp_edittext_preference2","NOT SELECTED");



        tv_checkbox_preference1.setText("CHECK BOX Preference1 : "+ Boolean.toString(cb1));
        tv_checkbox_preference2.setText("CHECK BOX Preference2 : "+ Boolean.toString(cb2));
        tv_edittext_preference1.setText("EDIT TEXT Preference1 : "+ edit1);
        tv_list_preference.setText("LIST Preference1 : "+ list);
        tv_ringtonne_preference.setText("Ringtone  Preference : "+ ringtone);
        tv_edittext_preference2.setText("Edit text Preference : "+ edit2);
    }
}
