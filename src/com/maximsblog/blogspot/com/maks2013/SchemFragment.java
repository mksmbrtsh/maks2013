package com.maximsblog.blogspot.com.maks2013;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class SchemFragment extends Fragment {

	private float mX;
	private float mY;

	public static SchemFragment newInstance(String content) {
		SchemFragment fragment = new SchemFragment();

		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout layout = (LinearLayout) inflater.inflate(
				R.layout.schem_fragment, container, false);
		/*Display display = ((WindowManager)
                getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int displayWidth = display.getWidth();             
        int displayHeight = display.getHeight();    
        
		Scheme s = new Scheme(this.getActivity(), displayWidth, displayHeight);
		//layout.addView(s);
		*/
		return layout;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
