package exmaple.acadgild.com.activitylifecycle;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;
/**
 * Created by divyanshu on 20/03/16.
 */
public class Activity_TimePicer extends Activity {

    Button pick;
    TimePicker time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timepicker);

        pick = (Button) findViewById(R.id.button1);
        time = (TimePicker) findViewById(R.id.timePicker1);

        time.setOnTimeChangedListener(new OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(),"Time is "+hourOfDay+ " : "
                        +minute, Toast.LENGTH_SHORT).show();
            }
        });

        pick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(),"Time is "+time.getCurrentHour()+
                        " : " +time.getCurrentMinute(), Toast.LENGTH_LONG).show();
            }
        });
    }


}