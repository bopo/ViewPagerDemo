package com.example.viewpagedemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class GuideActivity extends Activity {

	// 翻页控件
	private ViewPager mViewPager;
	// 这4个是底部显示当前状态点imageView
	private ImageView mPage0;
	private ImageView mPage1;
	private ImageView mPage2;
	private ImageView mPage3;
	//点击体验button
	private Button whats_new_start_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ExitApplication.getInstance().addActivity(this);
		// 设置无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 设置全屏
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		mViewPager = (ViewPager) findViewById(R.id.whatsnew_viewpager);
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mPage0 = (ImageView) findViewById(R.id.page0);
		mPage1 = (ImageView) findViewById(R.id.page1);
		mPage2 = (ImageView) findViewById(R.id.page2);
		mPage3 = (ImageView) findViewById(R.id.page3);
		/*
		 * 这里是每一页要显示的布局，根据应用需要和特点自由设计显示的内容 以及需要显示多少页等
		 */
		LayoutInflater mLi = LayoutInflater.from(this);
		View view1 = mLi.inflate(R.layout.whats_news_gallery_one, null);
		View view2 = mLi.inflate(R.layout.whats_news_gallery_two, null);
		View view3 = mLi.inflate(R.layout.whats_news_gallery_three, null);
		View view4 = mLi.inflate(R.layout.whats_news_gallery_four, null);
		// 在第四个界面上绑定button
		whats_new_start_btn = (Button) view4
				.findViewById(R.id.whats_new_start_btn);
		whats_new_start_btn.setOnClickListener(new buttonClickListener());
		/*
		 * 这里将每一页显示的view存放到ArrayList集合中 可以在ViewPager适配器中顺序调用展示
		 */
		final ArrayList<View> views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		/*
		 * 每个页面的Title数据存放到ArrayList集合中 可以在ViewPager适配器中调用展示
		 */
		final ArrayList<String> titles = new ArrayList<String>();
		titles.add("tab1");
		titles.add("tab2");
		titles.add("tab3");
		titles.add("tab4");
		// 填充ViewPager的数据适配器
		MyPagerAdapter mPagerAdapter = new MyPagerAdapter(views, titles);
		mViewPager.setAdapter(mPagerAdapter);
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {
		public void onPageSelected(int page) {
			// 翻页时当前page,改变当前状态园点图片
			switch (page) {
			case 0:
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 1:
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 2:
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				break;
			}
		}

		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		public void onPageScrollStateChanged(int arg0) {
		}
	}

	public class buttonClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Intent it = new Intent(GuideActivity.this, HomeActivity.class);
			startActivity(it); // 点击最后一页的button进入主界面
			GuideActivity.this.overridePendingTransition(
					R.anim.new_dync_in_from_right, R.anim.new_dync_out_to_left);
			GuideActivity.this.finish();
		}
	}
}
