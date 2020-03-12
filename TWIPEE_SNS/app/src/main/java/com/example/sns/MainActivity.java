package com.example.sns;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    public MainViewPagerAdapter mainViewPagerAdapter = null;
    private Context mContext = MainActivity.this;
    private ViewPager viewPager;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView(){
        mainViewPagerAdapter = new MainViewPagerAdapter(mContext, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabs);
        viewPager.setAdapter(mainViewPagerAdapter);
        tabs.setupWithViewPager(viewPager);

    }

}
