package com.maximsblog.blogspot.com.maks2013;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutFragment extends Fragment {
	public static AboutFragment newInstance(String content) {
		AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.about_fragment, container,false);
    	TextView t = (TextView) layout.findViewById(R.id.textView2);
	    Linkify.addLinks(t, Linkify.ALL);
	    t.setTextColor(Color.GRAY);
	    t.setText(getResources().getText(R.string.about_text));
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}