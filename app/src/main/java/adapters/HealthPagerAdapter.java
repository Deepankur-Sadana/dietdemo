package adapters;


import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import fragment.BaseFragment;


/**
 * Adapter Class for Sliding Pager
 */
public class HealthPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    private ArrayList<BaseFragment> fragmentList;
    private String[] titleArray;

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    public HealthPagerAdapter(android.support.v4.app.FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    public void setFragmentList(ArrayList<BaseFragment> fragmentList) {
        this.fragmentList = fragmentList;
    }

    public void setTitleArray(String[] titleArray) {
        this.titleArray = titleArray;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleArray[position];
    }
}