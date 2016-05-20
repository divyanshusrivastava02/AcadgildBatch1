package exmaple.acadgild.com.activitylifecycle.ActionBar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 01/05/16.
 */
public class ImageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_images,container,false);

        return rootView;
    }
}
