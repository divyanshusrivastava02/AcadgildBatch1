package exmaple.acadgild.com.activitylifecycle.SQLITE_ACADGILD;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 09/04/16.
 */
public class Activity_Acadgild_Sqlite extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "MESSAGE";
    public ListView obj;
    DBHelper mydb;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acadgild_sqlite);

        mydb = new DBHelper(this);
        ArrayList array_list = mydb.getAllContacts();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,array_list);

        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
        obj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id_To_Search = position + 1;

                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id",id_To_Search);

                Intent intent = new Intent(getApplicationContext(),DisplayContacts.class);
                intent.putExtras(dataBundle);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_sqlite_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.item1:
                Bundle dataBundle = new Bundle();
                dataBundle.putInt("id",0);

                Intent intent = new Intent(getApplicationContext(),DisplayContacts.class);
                intent.putExtras(dataBundle);
                startActivity(intent);

                return  true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){
            moveTaskToBack(true);
        }

        return super.onKeyDown(keyCode, event);
    }
}
