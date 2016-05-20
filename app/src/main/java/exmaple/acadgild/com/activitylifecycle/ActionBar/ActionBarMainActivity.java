package exmaple.acadgild.com.activitylifecycle.ActionBar;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import exmaple.acadgild.com.activitylifecycle.ActionBar.adapter.TabsPagerAdapter;
import exmaple.acadgild.com.activitylifecycle.R;

/**
 * Created by divyanshu on 01/05/16.
 */
public class ActionBarMainActivity extends FragmentActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener{

    ViewPager viewPager;
    TabsPagerAdapter mAdapter;
    ActionBar actionBar;

    private String[] tabs = {"Button","Colors","Images"};

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_actionbar);


        viewPager = (ViewPager)findViewById(R.id.pager);
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String tab_name : tabs){
            actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
        }

        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
