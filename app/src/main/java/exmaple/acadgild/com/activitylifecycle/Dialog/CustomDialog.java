package exmaple.acadgild.com.activitylifecycle.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 16/04/16.
 */
public class CustomDialog extends Activity{
    EditText etSearch;
    Button btn, btnsearch, btncancel;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customdialog_main);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }


    public void showCustomDialog(){
        dialog = new Dialog(CustomDialog.this, android.R.style.Theme_Translucent);

        dialog.setContentView(R.layout.layout_customdialog);

        etSearch = (EditText)dialog.findViewById(R.id.etsearch);

        btnsearch= (Button)dialog.findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = etSearch.getText().toString().trim();
                if(TextUtils.isEmpty(userInput)){
                    Toast.makeText(CustomDialog.this,"SEARCH HAS NO VALUE",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CustomDialog.this,"SEARCH FOR     "+ userInput,Toast.LENGTH_SHORT).show();
                }
            }
        });

        btncancel= (Button)dialog.findViewById(R.id.btncancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();
    }


}
