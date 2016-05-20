package exmaple.acadgild.com.activitylifecycle.ListView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 19/04/16.
 */
public class DynamicListViewExample extends Activity{

    List<String> li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview_example);

        String questionurl = "https://drive.google.com/file/d/0B77hqRzlU1aUc2lSYXI0azFjOWc/view?usp=sharing";

        final RelativeLayout r1= (RelativeLayout) findViewById(R.id.r1);

        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin =10;
        params.topMargin = 150;

        Button clickMe = (Button)findViewById(R.id.button1);

        final ListView list = new ListView(this);

        li = new ArrayList<String>();
        li.add("List 1");
        li.add("List 2");
        li.add("List 3");
        li.add("List 4");
        li.add("List 5");
        li.add("List 6");
        li.add("List 7");


        li.add("List 1a");
        li.add("List 2a");
        li.add("List 3a");
        li.add("List 4a");
        li.add("List 5a");
        li.add("List 6a");
        li.add("List 7a");


        li.add("List 1b");
        li.add("List 2b");
        li.add("List 3b");
        li.add("List 4b");
        li.add("List 5b");
        li.add("List 6b");
        li.add("List 7b");

        clickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayAdapter<String> adp =new  ArrayAdapter<String> (DynamicListViewExample.this,
                android.R.layout.simple_dropdown_item_1line,li);

                adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                list.setAdapter(adp);
                list.setLayoutParams(params);

                r1.addView(list);

//                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        Toast.makeText(getBaseContext(),position,Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });


        try {
            URL yahoo = new URL("http://www.yahoo.com/");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yahoo.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println("RESPONSE::::::::"+inputLine);

            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
