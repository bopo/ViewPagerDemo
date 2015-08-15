package com.example.viewpagedemo;

import java.util.ArrayList;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * ViewPager适配器，用来绑定数据和view
 * 
 * @author xhb
 */
public class MyPagerAdapter extends PagerAdapter {

	/**
	 * 界面列表
	 */
	private ArrayList<View> views;
	@SuppressWarnings("unused")
	private ArrayList<String> titles;

	public MyPagerAdapter(ArrayList<View> views, ArrayList<String> titles) {
		this.views = views;
		this.titles = titles;
	}

	/**
	 * 获取当前页面数
	 */
	@Override
	public int getCount() {
		return this.views.size();
	}

	/**
	 * 判断是否由对象生成界面
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	/**
	 * 销毁position位置的界面
	 */
	public void destroyItem(View container, int position, Object object) {
		((ViewPager) container).removeView(views.get(position));
	}

	/**
	 * 初始化position位置的界面
	 */
	public Object instantiateItem(View container, int position) {
		((ViewPager) container).addView(views.get(position));
		return views.get(position);
	}
}
