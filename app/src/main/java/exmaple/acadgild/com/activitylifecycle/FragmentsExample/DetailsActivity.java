package exmaple.acadgild.com.activitylifecycle.FragmentsExample;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by divyanshu on 30/04/16.
 */
public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create fragment
        DetailsFragment details = new DetailsFragment();

        // get and set the position input by user (i.e., "index")
        // which is the construction arguments for this fragment
        details.setArguments(getIntent().getExtras());

        getFragmentManager().beginTransaction()
                .add(android.R.id.content, details).commit();

    }
}
