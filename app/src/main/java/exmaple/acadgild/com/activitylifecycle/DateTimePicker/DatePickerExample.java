package exmaple.acadgild.com.activitylifecycle.DateTimePicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 19/04/16.
 */
public class DatePickerExample extends Activity{

    DatePicker date;
    Button pick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepicker_example);


        date = (DatePicker)findViewById(R.id.datePicker1);
        pick = (Button)findViewById(R.id.button1);

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"DATE IS : "
                +date.getDayOfMonth() + " - "+(date.getMonth()+1)+ " - "+ date.getYear(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
