package exmaple.acadgild.com.activitylifecycle.ListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 19/04/16.
 */
public class GridViewExample extends Activity{

    List<String> list;
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview_example);

        list = new ArrayList<String>();

        grid = (GridView)findViewById(R.id.gridview1);

        list.add("IMAGE 1");
        list.add("IMAGE 2");
        list.add("IMAGE 3");
        list.add("IMAGE 4");
        list.add("IMAGE 5");
        list.add("IMAGE 6");
        list.add("IMAGE 7");
        list.add("IMAGE 8");
        list.add("IMAGE 9");list.add("IMAGE 110");

        list.add("IMAGE 1");
        list.add("IMAGE 2");
        list.add("IMAGE 3");
        list.add("IMAGE 4");
        list.add("IMAGE 5");
        list.add("IMAGE 6");
        list.add("IMAGE 7");
        list.add("IMAGE 8");
        list.add("IMAGE 9");list.add("IMAGE 110");


        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,list);

        grid.setAdapter(adp);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getBaseContext(), "YOU CLicked : "+list.get(position),Toast.LENGTH_SHORT).show();
            }
        });


    }
}
