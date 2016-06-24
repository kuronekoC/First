package com.mydemo.activity.base;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.mydemo.activity.R;
import com.mydemo.application.MyApplication;
import com.mydemo.utils.SPutils;


/**
 * @desc 启动屏，引导页
 *
 * @author  注意：1.全屏；2。延时
 */
public class SplashActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//全屏
		requestWindowFeature(Window.FEATURE_NO_TITLE); 
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		//判断
		// 是否第一次 第一次则引导页
		boolean isFirstOpen = (Boolean) SPutils.get(this,
				MyApplication.FIRST_OPEN, false);
		//没有，默认值
		// getBoolean(this, AppConstants.FIRST_OPEN);
		if (!isFirstOpen) {
			Intent intent = new Intent(this, WelcomeGuideActivity.class);
			startActivity(intent);
			finish();
			return;// 后面都不运行
		}
		// 非第一次 正常运行
		setContentView(R.layout.activity_s1_splash);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				enterHomeActivity();
			}
		}, 2000);
	}

	private void enterHomeActivity() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

	}

}
