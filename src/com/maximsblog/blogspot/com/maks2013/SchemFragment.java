package com.maximsblog.blogspot.com.maks2013;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
		final ImageView schema = (ImageView) layout.findViewById(R.id.schema);
		Bitmap bitmap = ((BitmapDrawable) schema.getDrawable()).getBitmap();

		final int height = bitmap.getHeight();
		final int width = bitmap.getWidth();

		schema.setOnTouchListener(new View.OnTouchListener() {

			public boolean onTouch(View arg0, MotionEvent event) {

				float curX, curY;

				switch (event.getAction()) {

				case MotionEvent.ACTION_DOWN:
					mX = event.getX();
					mY = event.getY();
					break;
				case MotionEvent.ACTION_MOVE:
					curX = event.getX();
					curY = event.getY();
					int dx = (int) (mX - curX);
					int dy = (int) (mY - curY);
					int nx = dx + schema.getScrollX();
					int ny = dy + schema.getScrollY();

					if (nx + schema.getWidth() > width)
						dx = 0;
					if (ny + schema.getHeight()> height)
						dy = 0;
					if (nx < 0)
						dx = 0;
					if (ny < 0)
						dy = 0;
					schema.scrollBy(dx, dy);
					mX = curX;
					mY = curY;

					break;
				case MotionEvent.ACTION_UP:
					curX = event.getX();
					curY = event.getY();

					schema.scrollBy((int) (mX - curX), (int) (mY - curY));

					break;
				}

				return true;
			}
		});
		return layout;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
