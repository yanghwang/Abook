package com.example.abook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 김성질 on 2017-09-19.
 */

public class PagerAdapter_QnA extends FragmentStatePagerAdapter {
    int mNoOfTabs;

    public PagerAdapter_QnA(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                PopularQuestionFragment tab1 = new PopularQuestionFragment();
                return tab1;
            case 1:
                NewQuestionFragment tab2 = new NewQuestionFragment();
                return tab2;
            case 2:
                MyQuestionFragment tab3 = new MyQuestionFragment();
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
