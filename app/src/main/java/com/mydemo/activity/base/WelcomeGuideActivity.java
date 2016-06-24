package com.mydemo.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.mydemo.activity.R;
import com.mydemo.adapter.base.GuideViewPagerAdapter;
import com.mydemo.application.MyApplication;
import com.mydemo.utils.SPutils;

import java.util.ArrayList;
import java.util.List;


/**
 * 引导页 滑动
 *
 * 注意 1.添加页面的方式
 */

public class WelcomeGuideActivity extends Activity implements OnClickListener {
	private ViewPager vp;
	private GuideViewPagerAdapter adapter;
	private List<View> views;
	private Button startBtn;
	// 引导页图片资源
	private static final int[] pics = { R.layout.guide_view1,
			R.layout.guide_view2, R.layout.guide_view3 };
	// 底部小点图片
	private ImageView[] dots;
	// 记录当前选中位置
	private int currentIndex;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_s1_welcome_guide);
		views = new ArrayList<View>();
		// 初始化引导页视图列表
		for (int i = 0; i < pics.length; i++) {
			View view = LayoutInflater.from(this).inflate(pics[i], null);

			if (i == pics.length - 1) {
				startBtn = (Button) view.findViewById(R.id.btn_login);
				startBtn.setTag("enter");
				startBtn.setOnClickListener(this);
			}
			views.add(view);
		}

		vp = (ViewPager) findViewById(R.id.vp_guide);
		// 初始化adapter
		adapter = new GuideViewPagerAdapter(views);
		vp.setAdapter(adapter);
		vp.addOnPageChangeListener(new PageChangeListener());
		// (listener)
		 initDots();
	}
	
	private class PageChangeListener implements OnPageChangeListener {
		// 当滑动状态改变时调用
		@Override
		public void onPageScrollStateChanged(int position) {
			// arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
		}

		// 当前页面被滑动时调用
		@Override
		public void onPageScrolled(int position, float arg1, int arg2) {
			System.out.println(arg1);
			System.out.println(arg2);
			System.out.println(position);
			// arg0 :当前页面，及你点击滑动的页面
			// arg1:当前页面偏移的百分比
			// arg2:当前页面偏移的像素位置
		}

		// 当新的页面被选中时调用
		@Override
		public void onPageSelected(int position) {
			// 设置底部小点选中状态
			setCurDot(position);
		}

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getTag().equals("enter")) {
			enterMainActivity();
			return;
		}
		
		int position = (Integer) v.getTag();
		setCurView(position);
		setCurDot(position);

	}
	/**
	 *  跳转 加载欢迎 页
	 */
	private void enterMainActivity() {
		Intent intent = new Intent(WelcomeGuideActivity.this,
				SplashActivity.class);
		startActivity(intent);
		SPutils.put(WelcomeGuideActivity.this, MyApplication.FIRST_OPEN, true);
		finish();
	}
	/**
	 * 初始化 底部圆点
	 */
	private void initDots() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
		dots = new ImageView[pics.length];

		// 循环取得小点图片
		for (int i = 0; i < pics.length; i++) {
			// 得到一个LinearLayout下面的每一个子元素
			dots[i] = (ImageView) ll.getChildAt(i);
			dots[i].setEnabled(false);// 都设为灰色
			dots[i].setOnClickListener(this);
			dots[i].setTag(i);// 设置位置tag，方便取出与当前位置对应
		}

		currentIndex = 0;
		dots[currentIndex].setEnabled(true); // 设置为白色，即选中状态

	}
	/**
	 * 设置当前view
	 * 
	 * @param position
	 */
	private void setCurView(int position) {
		if (position < 0 || position >= pics.length) {
			return;
		}
		vp.setCurrentItem(position);
	}
	/**
	 * 设置当前指示点
	 * 
	 * @param position
	 */
	private void setCurDot(int position) {
		if (position < 0 || position > pics.length || currentIndex == position) {
			return;
		}
		dots[position].setEnabled(true);
		dots[currentIndex].setEnabled(false);
		currentIndex = position;
	}

}
