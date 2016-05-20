package exmaple.acadgild.com.activitylifecycle.SharedPreferencesXML;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 10/04/16.
 */
public class SettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }
}
