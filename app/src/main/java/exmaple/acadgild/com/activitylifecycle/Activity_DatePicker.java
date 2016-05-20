package exmaple.acadgild.com.activitylifecycle;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
/**
 * Created by divyanshu on 20/03/16.
 */
public class Activity_DatePicker extends Activity {

    DatePicker date;
    Button pick;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker);

        date = (DatePicker) findViewById(R.id.datePicker1);
        pick = (Button) findViewById(R.id.button1);

        pick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getBaseContext(), "Date is : " +
                        date.getDayOfMonth() + "-"+ (date.getMonth()+1) +
                        "-"+ date.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}