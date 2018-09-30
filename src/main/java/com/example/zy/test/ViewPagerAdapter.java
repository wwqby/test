package com.example.zy.test;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.List;

/**
 * /*@Description
 * /*created by wwq on 2018/8/28 0028
 * /*@company zhongyiqiankun
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    public ViewPagerAdapter(FragmentManager fm, List<Fragment>list) {
        super(fm);
        this.list=list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

}
