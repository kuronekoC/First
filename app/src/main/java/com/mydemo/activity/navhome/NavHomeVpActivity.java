package com.mydemo.activity.navhome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.mydemo.activity.R;
import com.mydemo.adapter.base.NavHomeVpAdapter;
import com.mydemo.fragment.navhome.TestFragment;
import com.mydemo.view.base.NoSlidViewPager;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/6/17.
 * 导航主页  FragmentActivity  待解决问题 主体相关 ActionBar 沉浸etc
 * ViewPager+Raio
 */
public class NavHomeVpActivity extends FragmentActivity {
    @Bind(R.id.vp_nav)
    NoSlidViewPager mVpNav;
    @Bind(R.id.rg_nav_bar)
    RadioGroup mRgNavBar;

    @Bind(R.id.rb_1)
    RadioButton mRb1;
    @Bind(R.id.rb_2)
    RadioButton mRb2;
    @Bind(R.id.rb_3)
    RadioButton mRb3;
    @Bind(R.id.rb_4)
    RadioButton mRb4;
    @Bind(R.id.rb_5)
    RadioButton mRb5;

    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    Fragment fragment1, fragment2, fragment3, fragment4, fragment5;
    NavHomeVpAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_home_vp);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initData() {
//        fragment1 = new HomeActivity();
//        fragment2 = new ShopActivity();
//        fragment3 = new MapVActivity();
//        fragment4 = new ShopCartFragment();
//        fragment5 = new MeFragment();
        fragment1 = new TestFragment();
        fragment2 = new TestFragment();
        fragment3 = new TestFragment();
        fragment4 = new TestFragment();
        fragment5 = new TestFragment();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);
        fragmentList.add(fragment5);

        adapter = new NavHomeVpAdapter(getSupportFragmentManager(), fragmentList);
        mVpNav.setAdapter(adapter);
        mVpNav.setPagingEnabled(false);
        mVpNav.setOffscreenPageLimit(4);//设置不预加载
        mVpNav.setCurrentItem(0);
    }

    private void initListener() {
        //VP监听
        mVpNav.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mRb1.setChecked(true);
                        break;
                    case 1:
                        mRb2.setChecked(true);
                        break;
                    case 2:
                        mRb3.setChecked(true);
                        break;
                    case 3:
                        mRb4.setChecked(true);
                        break;
                    case 4:
                        mRb5.setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        //RG监听
        mRgNavBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int rbID) {
                switch (rbID) {
                    case R.id.rb_1:
                        mVpNav.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        mVpNav.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        mVpNav.setCurrentItem(2);
                        break;
                    case R.id.rb_4:
                        mVpNav.setCurrentItem(3);
                        break;
                    case R.id.rb_5:
                        mVpNav.setCurrentItem(4);
                        break;

                }
            }
        });
    }
}
