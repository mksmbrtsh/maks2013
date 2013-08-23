package com.maximsblog.blogspot.com.maks2013;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LpFragment extends Fragment implements OnClickListener {
	public static LpFragment newInstance(String content) {
		LpFragment fragment = new LpFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.lp_fragment,container,false);
    	Button button = (Button) layout.findViewById(R.id.button1);
    	button.setOnClickListener(this);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

	@Override
	public void onClick(View v) {
		String url = "http://www.aviasalon.com/ru/static/page/letnaya_programma.htm";
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
	}
}
