package com.example.abook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 김성질 on 2017-09-17.
 */

public class PagerAdapter_AnimalDetail extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter_AnimalDetail(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                AnimalDetailAll tab1 = new AnimalDetailAll();
                return tab1;
            case 1:
                AnimalDetailTreat tab2 = new AnimalDetailTreat();
                return tab2;
            case 2:
                AnimalDetailBeauty tab3 = new AnimalDetailBeauty();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
