package exmaple.acadgild.com.activitylifecycle.FragmentsExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 30/04/16.
 */
public class FragmentLayout extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "FragmentLayout: OnCreate()", Toast.LENGTH_SHORT)
                .show();

        setContentView(R.layout.activity_fragment_layout);
    }



}
