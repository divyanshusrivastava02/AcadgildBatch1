package exmaple.acadgild.com.activitylifecycle.Intents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 02/04/16.
 */

public class ImplicitIntent  extends Activity{
    Button btn_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahil);

        btn_submit = (Button)findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intentVIEW = new Intent(Intent.ACTION_VIEW);
//                intentVIEW.setData(Uri.parse("https://acadgild.com/"));
//                startActivity(intentVIEW);

                call();
            }
        });
    }

    public void call(){
        Intent intentCALL = new Intent(Intent.ACTION_CALL);
        intentCALL.setData(Uri.parse("tel:"+"+9654676533"));
        startActivity(intentCALL);
    }
}
