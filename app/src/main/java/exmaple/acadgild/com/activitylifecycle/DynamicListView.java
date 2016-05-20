package exmaple.acadgild.com.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by divyanshu on 20/03/16.
 */
public class DynamicListView extends Activity {

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_dynamiclayout);



        final RelativeLayout r1 = (RelativeLayout)findViewById(R.id.r1);
        final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int) RelativeLayout.LayoutParams.WRAP_CONTENT);

        params.leftMargin = 15;
        params.topMargin = 50;


        Button bt = (Button)findViewById(R.id.button1);
        final ListView listView = new ListView(this);

        list = new ArrayList<String>();
        list.add("Sampath");
        list.add("Ravi");
        list.add("Divyanshu");
        list.add("Swati");


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(DynamicListView.this,
                        android.R.layout.simple_dropdown_item_1line,list);

                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

                listView.setAdapter(adapter);
                listView.setLayoutParams(params);
                r1.addView(listView);
            }
        });


    }
}
