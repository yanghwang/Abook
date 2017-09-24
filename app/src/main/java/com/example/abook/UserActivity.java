package com.example.abook;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {
    ActionBar.Tab tab1, tab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("사용자");

        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1 = bar.newTab();
        tab1.setText("사용자 정보");
        tab1.setTabListener(new MyTabListener(this,UserInformationFragment.class.getName()));
        bar.addTab(tab1);

        tab2 = bar.newTab();
        tab2.setText("예약 확인");
        tab2.setTabListener(new MyTabListener(this,BookCheckFragment.class.getName()));
        bar.addTab(tab2);
    }

    public   class  MyTabListener implements ActionBar.TabListener{
        private Fragment mFragment;
        private final Activity mActivity;
        private final String mFragName;

        public MyTabListener(Activity activity, String fragName){
            mActivity = activity;
            mFragName = fragName;
    }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            mFragment = Fragment.instantiate(mActivity,mFragName);
            ft.add(android.R.id.content, mFragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(mFragment);
            mFragment = null;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }
}
