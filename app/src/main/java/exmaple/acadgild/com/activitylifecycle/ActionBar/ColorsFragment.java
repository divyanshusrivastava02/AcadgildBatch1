package exmaple.acadgild.com.activitylifecycle.ActionBar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 01/05/16.
 */
public class ColorsFragment extends Fragment {

    TextView tvRed, tv_Blue;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_colors,container,false);
        return  rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvRed = (TextView)getActivity().findViewById(R.id.tvRed);
        tv_Blue = (TextView)getActivity().findViewById(R.id.tv_Blue);

        tvRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tvRed.setVisibility(View.GONE);
                tv_Blue.setVisibility(View.VISIBLE);
            }
        });

        tv_Blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRed.setVisibility(View.VISIBLE);
                tv_Blue.setVisibility(View.GONE);
            }
        });
    }
}
