package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyanshu on 20/03/16.
 */
public class Activity_Gridview extends Activity {
    List<String> list;
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview);
        list = new ArrayList<String>();
        grid = (GridView) findViewById(R.id.gridview1);


        list.add("Sampath");
        list.add("Ravi");
        list.add("Divyanshu");
        list.add("Swati");
        list.add("Rishi");
        list.add("Ravi");
        list.add("Harish");
        list.add("Swati");

        list.add("Sampath1");
        list.add("Ravi1");
        list.add("Divyanshu 1");
        list.add("Swati 1" );
        list.add("Rishi 1");
        list.add("Ravi 1");
        list.add("Harish 1");
        list.add("Swati 1");


        list.add("Sampath 2");
        list.add("Ravi 2");
        list.add("Divyanshu 2");
        list.add("Swati 2");
        list.add("Rishi 2");
        list.add("Ravi 2");
        list.add("Harish 2");
        list.add("Swati 2");


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,list);
        grid.setAdapter(adp);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Activity_Gridview.this,list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
