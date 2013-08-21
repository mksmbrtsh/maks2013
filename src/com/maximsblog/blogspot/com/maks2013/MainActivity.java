package com.maximsblog.blogspot.com.maks2013;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.viewpagerindicator.TabPageIndicator;
import com.maximsblog.blogspot.com.maks2013.R;

public class MainActivity extends FragmentActivity {
    private String[] mTitlesPage;
	private Cursor  employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mTitlesPage = getResources().getStringArray(R.array.titles);
        
        FragmentPagerAdapter adapter = new ItemPageAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        TabPageIndicator indicator = (TabPageIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        
        OpenDBHelper dbh = new OpenDBHelper(this);
        employees = dbh.getEmployees(); // you would not typically call this on the main thread
    }

    class ItemPageAdapter extends FragmentPagerAdapter {
        public ItemPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TestFragment.newInstance(mTitlesPage[position % mTitlesPage.length]);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitlesPage[position % mTitlesPage.length].toUpperCase();
        }

        @Override
        public int getCount() {
          return mTitlesPage.length;
        }
    }
}
