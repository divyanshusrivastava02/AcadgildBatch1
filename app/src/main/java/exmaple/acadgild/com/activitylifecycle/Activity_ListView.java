package exmaple.acadgild.com.activitylifecycle;

/**
 * Created by divyanshu on 20/03/16.
 */
import android.app.Activity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;
public class Activity_ListView extends Activity {

    ListView l1;
    String[] t1={"video1","video2","video1","video2","video1","video2","video1","video2"};
    String[] d1={"lesson1","lesson2","lesson1","lesson2","lesson1","lesson2","lesson1","lesson2"};
    int[] i1 ={R.drawable.ic_aadhar_card,
            R.drawable.ic_contact,
            R.drawable.ic_aadhar_card,
            R.drawable.ic_contact,
            R.drawable.ic_aadhar_card,
            R.drawable.ic_contact,
            R.drawable.ic_aadhar_card,
            R.drawable.ic_contact};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_main);
        l1=(ListView)findViewById(R.id.list);
        l1.setAdapter(new dataListAdapter(t1,d1,i1));
    }

    class dataListAdapter extends BaseAdapter {
        String[] Title, Detail;
        int[] imge;

        dataListAdapter() {
            Title = null;
            Detail = null;
            imge=null;
        }

        public dataListAdapter(String[] text, String[] text1,int[] text3) {
            Title = text;
            Detail = text1;
            imge = text3;

        }

        public int getCount() {
            // TODO Auto-generated method stub
            return Title.length;
        }

        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View row;
            row = inflater.inflate(R.layout.custom, parent, false);
            TextView title, detail;
            ImageView i1;
            title = (TextView) row.findViewById(R.id.title);
            detail = (TextView) row.findViewById(R.id.detail);
            i1=(ImageView)row.findViewById(R.id.img);



            title.setText(Title[position]);
            detail.setText(Detail[position]);
            i1.setImageResource(imge[position]);
            i1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            return (row);
        }
    }
}
