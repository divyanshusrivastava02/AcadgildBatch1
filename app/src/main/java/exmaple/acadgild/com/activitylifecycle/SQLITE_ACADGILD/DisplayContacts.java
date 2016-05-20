package exmaple.acadgild.com.activitylifecycle.SQLITE_ACADGILD;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 09/04/16.
 */
public class DisplayContacts extends ActionBarActivity {

    private  DBHelper mydb;

    EditText name;
    EditText phone;
    EditText email;
    EditText street;
    EditText place;
    int id_To_Update = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_acadgild_sqlite_contacts);

        name = (EditText) findViewById(R.id.editTextName);
        phone = (EditText) findViewById(R.id.editTextPhone);
        email = (EditText) findViewById(R.id.editTextEmail);
        street = (EditText) findViewById(R.id.editTextStreet);
        place = (EditText) findViewById(R.id.editTextCity);

        mydb = new DBHelper(this);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            int Value = extras.getInt("id");

            if(Value>0){
                Cursor rs = mydb.getData(Value);
                id_To_Update = Value;
                rs.moveToFirst();

                String nam = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_NAME));
                String phon = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_PHONE));
                String emai = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_EMAIL));
                String stree = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_STREET));
                String plac = rs.getString(rs.getColumnIndex(DBHelper.CONTACTS_COLUMN_CITY));

                if(!rs.isClosed()){
                    rs.close();
                }

                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.INVISIBLE);


                name.setText((CharSequence) nam);
                name.setFocusable(false);
                name.setClickable(false);



                phone.setText((CharSequence) phon);
                phone.setFocusable(false);
                phone.setClickable(false);



                email.setText((CharSequence) emai);
                email.setFocusable(false);
                email.setClickable(false);


                street.setText((CharSequence) stree);
                street.setFocusable(false);
                street.setClickable(false);


                place.setText((CharSequence) plac);
                place.setFocusable(false);
                place.setClickable(false);
            }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Bundle extras = getIntent().getExtras();

        if(extras!=null){
            int Value = extras.getInt("id");
            if(Value>0){
                getMenuInflater().inflate(R.menu.menu_sqlite_display_contacts,menu);
            }
            else {
                getMenuInflater().inflate(R.menu.menu_sqlite_main,menu);
            }
        }


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.Edit_Contact:

                Button b = (Button)findViewById(R.id.button1);
                b.setVisibility(View.VISIBLE);

                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);



                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);



                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);


                street.setEnabled(true);
                street.setFocusableInTouchMode(true);
                street.setClickable(true);


                place.setEnabled(true);
                place.setFocusableInTouchMode(true);
                place.setClickable(true);
                return  true;

            case R.id.Delete_Contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.deleteContact)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mydb.deleteContact(id_To_Update);
                                Toast.makeText(getApplicationContext(),"DELETE SUCCESSFULL HUREEE",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Activity_Acadgild_Sqlite.class);
                                startActivity(intent);
                            }
                        })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog d = builder.create();
                d.setTitle("ARE YOU SURE TO DELETE THIS RECORD!");
                d.show();

                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }



    public void run(View view){
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            int Value = extras.getInt("id");
            if(Value > 0){
                if(mydb.updateContact(id_To_Update,name.getText().toString(),phone.getText().toString(),email.getText().toString(),street.getText().toString(),place.getText().toString())){
                    Toast.makeText(getApplicationContext(),"UPDATE",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),Activity_Acadgild_Sqlite.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(),"NOT UPDATED",Toast.LENGTH_SHORT).show();

                }
            }
            else{
                if(mydb.insertContact(name.getText().toString(), phone.getText().toString(),email.getText().toString(),street.getText().toString(),place.getText().toString())){
                    Toast.makeText(getApplicationContext(),"DONE",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"NOT DONE",Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getApplicationContext(),Activity_Acadgild_Sqlite.class);
                startActivity(intent);
            }
        }
    }
}
