package exmaple.acadgild.com.activitylifecycle.Dialog;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 16/04/16.
 */
public class DialogActivity extends FragmentActivity {

    Button dbutton;
    Button alertfragbutton;
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dialog_main);


        dbutton = (Button)findViewById(R.id.dbutton);
        alertfragbutton = (Button)findViewById(R.id.alertfragbutton);

        dbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(DialogActivity.this)
                        .setIcon(R.drawable.ic_electeric_bill)
                        .setTitle("Cloase APP")
                        .setMessage("Are you sure to want to cole the app ?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogActivity.this,"NO is pressed",Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
//                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.cancel();
//                            }
//                        })


                        .show();
            }
        });



        alertfragbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDFragmet alertDFragmet = new AlertDFragmet();
                alertDFragmet.show(fm,"Alert Dialog Fragment");
            }
        });
    }
}
