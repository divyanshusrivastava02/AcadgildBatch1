package exmaple.acadgild.com.activitylifecycle.DateTimePicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 19/04/16.
 */
public class TimePickerExample extends Activity{

    Button pick;
    TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker_example);

        pick = (Button) findViewById(R.id.button1);

        time = (TimePicker)findViewById(R.id.timePicker1);
        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                Toast.makeText(getBaseContext(),"Time is  :"+hourOfDay + " : "+minute,Toast.LENGTH_SHORT).show();
            }
        });

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Time is  :"+time.getCurrentHour() + " : "+time.getCurrentMinute(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
