package com.mydemo.adapter.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/6/17.
 */
public class NavHomeVpAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> list;
    FragmentManager fmr;


    public NavHomeVpAdapter(FragmentManager fm) {
        super(fm);
    }
    public NavHomeVpAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.list=list;
        this.fmr=fm;
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
