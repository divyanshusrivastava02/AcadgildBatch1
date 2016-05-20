package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by divyanshu on 20/03/16.
 */
public class Activty_TimePickerMain extends Activity {

    Button button;
    TimePicker timepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        button = (Button)findViewById(R.id.button1);
        timepicker = (TimePicker)findViewById(R.id.timepickerClass);

        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(Activty_TimePickerMain.this, "Time is:::"+hourOfDay+" :"+ minute,Toast.LENGTH_SHORT).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(), "Time is: "+ timepicker.getCurrentHour()+" : "+timepicker.getCurrentMinute(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
