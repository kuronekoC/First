package com.mydemo.activity.navhome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mydemo.activity.R;
import com.mydemo.application.MyApplication;
import com.mydemo.fragment.navhome.TestFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/17.
 */
public class NavHomeLayActivity extends FragmentActivity {

    @Bind(R.id.container)
    FrameLayout mContainer;
    @Bind(R.id.home)
    ImageView mHome;
    @Bind(R.id.shopping)
    ImageView mShopping;
    @Bind(R.id.map)
    ImageView mMap;
    @Bind(R.id.shopcart)
    ImageView mShopcart;
    @Bind(R.id.me)
    ImageView mMe;

    private List<ImageView> imgList=new ArrayList<ImageView>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home_fmr);
        ButterKnife.bind(this);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment fragment = new TestFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment, MyApplication.fragment1Tag).commit();
        }
        mHome.setSelected(true);
        setTagAndListener();

//        initData();
//        initListener();
    }

    private void setTagAndListener() {
        mHome.setTag(MyApplication.fragment1Tag);
        mShopping.setTag(MyApplication.fragment2Tag);
        mMap.setTag(MyApplication.fragment3Tag);
        mShopcart.setTag(MyApplication.fragment4Tag);
        mMe.setTag(MyApplication.fragment5Tag);


        imgList.add(mHome);
        imgList.add(mShopping);
        imgList.add(mMap);
        imgList.add(mShopcart);
        imgList.add(mMe);

        mHome.setOnClickListener(listener);
        mShopping.setOnClickListener(listener);
        mMap.setOnClickListener(listener);
        mShopcart.setOnClickListener(listener);
        mMe.setOnClickListener(listener);

    }

    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment1 = fm.findFragmentByTag(MyApplication.fragment1Tag);
            Fragment fragment2 = fm.findFragmentByTag(MyApplication.fragment2Tag);
            Fragment fragment3 = fm.findFragmentByTag(MyApplication.fragment3Tag);
            Fragment fragment4 = fm.findFragmentByTag(MyApplication.fragment4Tag);
            Fragment fragment5 = fm.findFragmentByTag(MyApplication.fragment5Tag);
            if (fragment1 != null) {
                ft.hide(fragment1);
            }
            if (fragment2 != null) {
                ft.hide(fragment2);
            }
            if (fragment3 != null) {
                ft.hide(fragment3);
            }
            if (fragment4 != null) {
                ft.hide(fragment4);
            }
            if (fragment5 != null) {
                ft.hide(fragment5);
            }
            switch (view.getId()) {
                case R.id.home:
                    if(fragment1 == null){
                        fragment1 = new TestFragment();
                        ft.add(R.id.container, fragment1, MyApplication.fragment1Tag);
                    }else {
                        ft.show(fragment1);
                    }
                    mHome.setSelected(true);
                    mShopping.setSelected(false);
                    mMap.setSelected(false);
                    mShopcart.setSelected(false);
                    mMe.setSelected(false);
                    break;
                case R.id.shopping:
                    if(fragment2 == null){
                        fragment2 = new TestFragment();
                        ft.add(R.id.container, fragment2, MyApplication.fragment2Tag);
                    }else {
                        ft.show(fragment2);
                    }
                    mHome.setSelected(false);
                    mShopping.setSelected(true);
                    mMap.setSelected(false);
                    mShopcart.setSelected(false);
                    mMe.setSelected(false);
                    break;
                case R.id.map:
                    if(fragment3 == null){
                        fragment3 = new TestFragment();
                        ft.add(R.id.container, fragment3, MyApplication.fragment3Tag);
                    }else {
                        ft.show(fragment3);
                    }
                    mHome.setSelected(false);
                    mShopping.setSelected(false);
                    mMap.setSelected(true);
                    mShopcart.setSelected(false);
                    mMe.setSelected(false);
                    break;
                case R.id.shopcart:
                    if(fragment4 == null){
                        fragment4 = new TestFragment();
                        ft.add(R.id.container, fragment4, MyApplication.fragment4Tag);
                    }else {
                        ft.show(fragment4);
                    }
                    mHome.setSelected(false);
                    mShopping.setSelected(false);
                    mMap.setSelected(false);
                    mShopcart.setSelected(true);
                    mMe.setSelected(false);
                    break;
                case R.id.me:
                    if(fragment5 == null){
                        fragment5 = new TestFragment();
                        ft.add(R.id.container, fragment5, MyApplication.fragment5Tag);
                    }else {
                        ft.show(fragment5);
                    }
                    mHome.setSelected(false);
                    mShopping.setSelected(false);
                    mMap.setSelected(false);
                    mShopcart.setSelected(false);
                    mMe.setSelected(true);
                    break;
            }
            ft.commit();
        }
    };
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        for (int i = 0; i < imgList.size(); i++) {
            ImageView mTab =(ImageView) imgList.get(i);
            FragmentManager fm = getSupportFragmentManager();
            Fragment fragment = fm.findFragmentByTag((String) mTab.getTag());
            FragmentTransaction ft = fm.beginTransaction();
            if (fragment != null) {
                if (!mTab.isSelected()) {
                    ft.hide(fragment);
                }
            }
            ft.commit();
        }
    }
}
