package com.example.zy.test;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FragmentTestActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.view_pager);
        List<Fragment> list=new ArrayList<>();
        list.add(TextFragment.newInstance("电影"));
        list.add(TextFragment.newInstance("电视"));
        list.add(TextFragment.newInstance("动画"));
        list.add(TextFragment.newInstance("小说"));
        list.add(TextFragment.newInstance("音乐"));

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
