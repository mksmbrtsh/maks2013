package com.maximsblog.blogspot.com.maks2013;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class InfoFragment extends Fragment {

	private String mName;
	private String mNote;
	private String mP;
	private String mZ;
	private TextView mNameView;
	private TextView mNoteView;
	private TextView mPView;
	private TextView mZView;
	
    public static InfoFragment newInstance() {
    	InfoFragment fragment = new InfoFragment();
        return fragment;
    }

    
    public static class infoActivity extends FragmentActivity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			if (savedInstanceState == null) {
				InfoFragment details = new InfoFragment();
				details.setArguments(getIntent().getExtras());
				getSupportFragmentManager().beginTransaction()
						.add(android.R.id.content, details).commit();
			}
		}
		
    }
    @Override
	public void onAttach(android.app.Activity activity) {
		super.onAttach(activity);
		setRetainInstance(true);
		Intent intent = activity.getIntent();
		if (intent != null) {
			mName = intent.getStringExtra("name");
			mNote = intent.getStringExtra("note");
			mP = intent.getStringExtra("p");
			mZ = intent.getStringExtra("z");
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.info_fragment,container,false);
    	mNameView = (TextView)layout.findViewById(R.id.name);
    	mNoteView = (TextView)layout.findViewById(R.id.note);
    	mPView = (TextView)layout.findViewById(R.id.p);
    	mZView = (TextView)layout.findViewById(R.id.z);
        return layout;
    }
    
    @Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mNameView.setText(mName);
		mNoteView.setText(mNote);
		mZView.setText(getString(R.string.z) + " " + mZ);
		mPView.setText(getString(R.string.p) + " " + mP);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}