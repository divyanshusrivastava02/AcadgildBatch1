package exmaple.acadgild.com.activitylifecycle.ActionBar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import exmaple.acadgild.com.activitylifecycle.ActionBar.ButtonsFragment;
import exmaple.acadgild.com.activitylifecycle.ActionBar.ColorsFragment;
import exmaple.acadgild.com.activitylifecycle.ActionBar.ImageFragment;

/**
 * Created by divyanshu on 01/05/16.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ButtonsFragment();
            case 1:
                return new ColorsFragment();
            case 2:
                return new ImageFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
