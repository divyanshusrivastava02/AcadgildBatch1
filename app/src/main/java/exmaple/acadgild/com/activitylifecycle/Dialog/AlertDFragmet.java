package exmaple.acadgild.com.activitylifecycle.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 16/04/16.
 */
public class AlertDFragmet extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ic_aadhar_card)
                .setTitle("THIS IS A DIALOG TITLE")
                .setMessage("HELLO everyone this is the messaage we goona show in dialog")


                //POSITIVE BUTTON
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getBaseContext(),"OK is pressed",Toast.LENGTH_SHORT).show();
            }
        })

        // NEGATIVE BUTTON
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity().getBaseContext(),"CANCEL is pressed",Toast.LENGTH_SHORT).show();
            }
        }).create();
    }
}
