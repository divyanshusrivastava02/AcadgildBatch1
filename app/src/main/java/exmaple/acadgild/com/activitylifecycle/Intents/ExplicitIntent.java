package exmaple.acadgild.com.activitylifecycle.Intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 02/04/16.
 */
public class ExplicitIntent extends Activity{
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahil);

        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Bundle bundle = new Bundle();
                Intent explicitIntent = new Intent(ExplicitIntent.this,Activity_exm.class);

               // bundle.putString("NAME","SWATI");
                //explicitIntent.putExtras(bundle);
                explicitIntent.putExtra("NAME", "RAVI");
                explicitIntent.putExtra("isRegistered", false);
                explicitIntent.putExtra("value", 1);

                startActivity(explicitIntent);
            }
        });
    }
}
