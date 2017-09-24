package com.example.abook;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class QnAActivity extends AppCompatActivity implements PopularQuestionFragment.OnFragmentInteractionListener, NewQuestionFragment.OnFragmentInteractionListener, MyQuestionFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qna);

        //플로팅액션버튼
        FloatingActionButton fab_create = (FloatingActionButton)findViewById(R.id.fab_create);

        fab_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QnAActivity.this,QnAAddActivity.class);
                startActivity(intent);
            }
        });

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout_qna);
        tabLayout.addTab(tabLayout.newTab().setText("인기질문"));
        tabLayout.addTab(tabLayout.newTab().setText("최신질문"));
        tabLayout.addTab(tabLayout.newTab().setText("내질문"));

        final ViewPager viewPager = (ViewPager)findViewById(R.id.viewPager_qna);
        final PagerAdapter_QnA adapter = new PagerAdapter_QnA(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
