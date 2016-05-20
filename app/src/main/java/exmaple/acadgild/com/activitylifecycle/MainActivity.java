package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button button1;
	TextView textPrenaSmaple;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acadgild_relativelayout);

		button1 = (Button)findViewById(R.id.france);
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent xxxx = new Intent(MainActivity.this,Prena.class);
				startActivity(xxxx);
			}
		});

		textPrenaSmaple = (TextView)findViewById(R.id.textPrenaSmaple);
		textPrenaSmaple.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent fff = new Intent(MainActivity.this,Prena.class);
				startActivity(fff);
			}
		});
		Toast.makeText(MainActivity.this,"On Create Called",Toast.LENGTH_SHORT).show();

		SharedPreferences pref = getApplicationContext().getSharedPreferences("Acadgild", MODE_PRIVATE);
		// GETTING THE VALES
		boolean Key1 = pref.getBoolean("key1",false);
		int key2 = pref.getInt("key2",0);
		float key3 = pref.getFloat("key3",0.0f);
		long key4 = pref.getLong("key4",0l);
		String key5 = pref.getString("key5","DIVYANSHU");
		System.out.println("VALUES COMING>>>>>>>"+key5 + key2+"" );

	}

	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(MainActivity.this,"On Start Called",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Toast.makeText(MainActivity.this,"On Resume Called",Toast.LENGTH_SHORT).show();
	}

	//Save important data
	@Override
	protected void onPause() {
		super.onPause();
		Toast.makeText(MainActivity.this,"On Pause Called",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(MainActivity.this,"On Stop Called",Toast.LENGTH_SHORT).show();
		
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(MainActivity.this,"On Restarted Called",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(MainActivity.this,"On Destroyed Called",Toast.LENGTH_SHORT).show();
	}
	
	
}
