package exmaple.acadgild.com.activitylifecycle.MenuAcadgild;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import exmaple.acadgild.com.activitylifecycle.R;

public class OptionMenuExample extends AppCompatActivity {

    ListView listView1;
    String contacts[] = {"Divyanshu", "Sampath", "Hari", "Swati","Ankij","Ravi","Rishi","Sahil"};
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_example);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        listView1 = (ListView)findViewById(R.id.listView1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView1.setAdapter(adapter);
        registerForContextMenu(listView1);


        button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(OptionMenuExample.this,button1);
                popup.getMenuInflater().inflate(R.menu.menu,popup.getMenu());


                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(OptionMenuExample.this, "YOU CLICKED  : "+item.getTitle(),Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });

                popup.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_descriptive,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(OptionMenuExample.this,"Item 1 clicked",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.item2:
                Toast.makeText(OptionMenuExample.this,"Item 2 clicked",Toast.LENGTH_SHORT).show();
                return  true;


            case R.id.item3:
                Toast.makeText(OptionMenuExample.this,"Item 3 clicked",Toast.LENGTH_SHORT).show();
                return  true;


            case R.id.item4:
                Toast.makeText(OptionMenuExample.this,"Item 4 clicked",Toast.LENGTH_SHORT).show();
                return  true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("ACADGILD MENU");
        menu.add(0,v.getId(),0,"ADDITION");
        menu.add(0,v.getId(),0,"SUBTRACTION");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="ADDITION"){
            Toast.makeText(OptionMenuExample.this, "ADDITION CLICKED",Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle()=="SUBTRACTION"){
            Toast.makeText(OptionMenuExample.this, "SUBTRACTION CLICKED",Toast.LENGTH_SHORT).show();
        }
        else {
            return  false;
        }
        return true;
    }
}
