package com.mydemo.activity.listcontent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mydemo.activity.R;
import com.mydemo.activity.navhome.NavHomeVpActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/18.
 */
public class ListContentActivity extends Activity {
    @Bind(R.id.t1)
    TextView mT1;
    @Bind(R.id.t2)
    TextView mT2;
    @Bind(R.id.t3)
    TextView mT3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s2_list_content);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.t1, R.id.t2, R.id.t3})
    public void onClick(View view) {
        Intent it=new Intent();
        switch (view.getId()) {
            case R.id.t1:
                /**
                 * StickHeaderListView   适合无数据交互
                 */
                it.setClass(this,NavHomeVpActivity.class);
                break;
            case R.id.t2:
                /**
                 * 下拉刷新，上啦
                 */
                it.setClass(this,NavHomeVpActivity.class);
                break;
            case R.id.t3:
                /**
                 * 分组扩展
                 */
                it.setClass(this,NavHomeVpActivity.class);
                break;
        }
       startActivity(it);
    }
}
