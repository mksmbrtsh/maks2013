package com.maximsblog.blogspot.com.maks2013;

import java.util.Locale;

import android.content.Context;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;

import com.viewpagerindicator.TabPageIndicator;
import com.google.android.gms.ads.AdView;
import com.maximsblog.blogspot.com.maks2013.R;

import android.view.MotionEvent;

public class MainActivity extends FragmentActivity {
	private String[] mTitlesPage;
	public Cursor employees;
	public OpenDBHelper mDBh;
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		mTitlesPage = getResources().getStringArray(R.array.titles);

		FragmentPagerAdapter adapter = new ItemPageAdapter(
				getSupportFragmentManager());

		NonSwipeableViewPager pager = (NonSwipeableViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		Configuration sysConfig = getResources().getConfiguration();
		mDBh = new OpenDBHelper(this);
		employees = mDBh.getEmployees();
		adView = (AdView) findViewById(R.id.adView);
	}

	class ItemPageAdapter extends FragmentPagerAdapter {
		public ItemPageAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			if (position == 0)
				return SchemFragment.newInstance(mTitlesPage[position
						% mTitlesPage.length]);
			else if (position == 1)
				return CatalogFragment.newInstance(mTitlesPage[position
						% mTitlesPage.length]);
			else if (position == 2)
				return DpFragment.newInstance(mTitlesPage[position
						% mTitlesPage.length]);
			else if (position == 3)
				return LpFragment.newInstance(mTitlesPage[position
						% mTitlesPage.length]);
			else if (position == 4)
				return AboutFragment.newInstance(mTitlesPage[position
						% mTitlesPage.length]);
			return null;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitlesPage[position % mTitlesPage.length];
		}

		@Override
		public int getCount() {
			return mTitlesPage.length;
		}
	}

	@Override
	protected void onPause() {
		adView.pause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		adView.resume();
	}
}
