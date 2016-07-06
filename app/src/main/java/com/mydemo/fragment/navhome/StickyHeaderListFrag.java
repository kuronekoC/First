package com.mydemo.fragment.navhome;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mydemo.activity.R;

/**
 * Created by Administrator on 2016/7/6.
 */
public class StickyHeaderListFrag extends Fragment {
    View v;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment, container, false);
        initView();
        initData();

        return v;
    }

    private void initView(){

    }

    private void initData(){

    }
}
