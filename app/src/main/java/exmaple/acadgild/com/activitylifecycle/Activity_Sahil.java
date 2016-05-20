package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by divyanshu on 19/03/16.
 */
public class Activity_Sahil extends Activity{

    Spinner sp;
    RadioGroup rg;
    int pos;
    int pos1;
    EditText editUserName;
    EditText password;
    String userName;
    String passwordTXT;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sahil);

        editUserName = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        passwordTXT = password.getText().toString();






        btn_submit = (Button)findViewById(R.id.btn_submit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_Sahil.this, "BUTTON CLICKED",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Activity_Sahil.this,Prena.class);
                intent.putExtra("NAME",editUserName.getText().toString());
                startActivity(intent);
            }
        });
//
//        btn_submit.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                Toast.makeText(Activity_Sahil.this, "BUTTON LONG CLICKED",Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Activity_Sahil.this,MainActivity.class);
//                startActivity(intent);
//                return false;
//            }
//        });

        btn_submit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });






















       // userName =  editUserName.getText().toString();
        sp = (Spinner)findViewById(R.id.spinner1);
        //sp.setVisibility(View.GONE);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(),
                        sp.getSelectedItem().toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        } );

        rg = (RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                // Method 1 For Getting Index of RadioButton
                pos=rg.indexOfChild(findViewById(checkedId));

                Toast.makeText(getBaseContext(), "Method 1 ID = "+String.valueOf(pos),
                        Toast.LENGTH_SHORT).show();

                //Method 2 For Getting Index of RadioButton
                pos1=rg.indexOfChild(findViewById(rg.getCheckedRadioButtonId()));

                Toast.makeText(getBaseContext(), "Method 2 ID = "+String.valueOf(pos1),
                        Toast.LENGTH_SHORT).show();

                switch (pos)
                {
                    case 0 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 1",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 1 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 2",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case 2 :
                        Toast.makeText(getBaseContext(), "You have Clicked RadioButton 3",
                                Toast.LENGTH_SHORT).show();
                        break;
                    default :
                        //The default selection is RadioButton 1
                        Toast.makeText(getBaseContext(),"You have Clicked RadioButton 1" ,
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
