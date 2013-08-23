package com.maximsblog.blogspot.com.maks2013;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class DpFragment extends Fragment {
	public static DpFragment newInstance(String content) {
		DpFragment fragment = new DpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dp_fragment,container,false);
    	TextView t = (TextView) layout.findViewById(R.id.textView1);
	    Linkify.addLinks(t, Linkify.ALL);
	    t.setTextColor(Color.GRAY);
	    t.setText(getResources().getText(R.string.dp));
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
