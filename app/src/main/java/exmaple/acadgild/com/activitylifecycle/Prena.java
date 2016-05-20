package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by divyanshu on 13/03/16.
 */
public class Prena extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acadgild_home);
        String userName = getIntent().getStringExtra("NAME");
        Toast.makeText(Prena.this,"On Create Called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Prena.this,"On Start Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Prena.this,"On Resume Called",Toast.LENGTH_SHORT).show();
    }

    //Save important data
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Prena.this,"On Pause Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Prena.this,"On Stop Called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Prena.this,"On Restarted Called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Prena.this,"On Destroyed Called",Toast.LENGTH_SHORT).show();
    }

}
