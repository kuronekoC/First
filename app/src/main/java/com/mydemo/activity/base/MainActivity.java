package com.mydemo.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.mydemo.activity.R;
import com.mydemo.activity.navhome.NavHomeLayActivity;
import com.mydemo.activity.navhome.NavHomeVpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @desc Demo 分类主页引导  每项为一个 主要常用界面结构
 * <p/>
 * 1注意  1.注解的导入  compile 'com.jakewharton:butterknife:7.0.0'
 * 再  设置→Plugin(插件)→添加  Butterknife(水果刀) Zelezny
 * 2. v4包     compile 'com.android.support:support-v4:23.0.1'
 * 3.开源动画框架   compile 'com.nineoldandroids:library:2.4.0'
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.t1)
    TextView mT1;
    @Bind(R.id.t2)
    TextView mT2;
    @Bind(R.id.t3)
    TextView mT3;
    @Bind(R.id.t4)
    TextView mT4;
    @Bind(R.id.t5)
    TextView mT5;
    @Bind(R.id.t6)
    TextView mT6;
    @Bind(R.id.t7)
    TextView mT7;
    @Bind(R.id.t8)
    TextView mT8;
    @Bind(R.id.t9)
    TextView mT9;
    @Bind(R.id.t10)
    TextView mT10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.t1, R.id.t2, R.id.t3, R.id.t4, R.id.t5, R.id.t6, R.id.t7, R.id.t8, R.id.t9, R.id.t10})
    public void onClick(View view) {
        Intent it=new Intent();
        switch (view.getId()) {
            case R.id.t1:
                /**
             * 导航主页 ViewPager+RadioGroup+Fragment
             */
                it.setClass(this,NavHomeVpActivity.class);
                break;
            case R.id.t2:
                /**
                 * 导航主页 Layout+Views+Fragment
                 */
                it.setClass(this,NavHomeLayActivity.class);
                break;
            case R.id.t3:
                /**
                 * ListView-相关
                 */
                it.setClass(this,NavHomeLayActivity.class);
                break;
            case R.id.t4:
                break;
            case R.id.t5:
                break;
            case R.id.t6:
                break;
            case R.id.t7:
                break;
            case R.id.t8:
                break;
            case R.id.t9:
                break;
            case R.id.t10:
                break;
        }
        startActivity(it);
    }
}
