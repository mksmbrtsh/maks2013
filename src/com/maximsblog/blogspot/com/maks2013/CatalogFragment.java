package com.maximsblog.blogspot.com.maks2013;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public final class CatalogFragment extends Fragment implements OnItemClickListener, OnClickListener {
	private SimpleCursorAdapter adapter;
	private EditText mSearch;
	private ListView mList;
	private Cursor mCursor;
	
    public static CatalogFragment newInstance(String content) {
        CatalogFragment fragment = new CatalogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.catalog_fragment,container,false);
    	mList = (ListView) layout.findViewById(R.id.catalog_list);
    	mList.setOnItemClickListener(this);
    	mSearch = (EditText) layout.findViewById(R.id.search);
    	ImageButton searchBtn = (ImageButton)layout.findViewById(R.id.search_btn);
    	searchBtn.setOnClickListener(this);
        mCursor = ((MainActivity)getActivity()).employees;
        
        adapter = new SimpleCursorAdapter(getActivity(), 
				android.R.layout.simple_list_item_2, 
				mCursor, 
				new String[] {"name", "z"}, 
				new int[] {android.R.id.text1, android.R.id.text2});
        mList.setAdapter(adapter);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		Intent intent = new Intent(getActivity(), InfoFragment.infoActivity.class);
		intent.putExtra("name", adapter.getCursor().getString(OpenDBHelper.NAME));
		intent.putExtra("z", adapter.getCursor().getString(OpenDBHelper.Z));
		getActivity().startActivity(intent);
	}

	@Override
	public void onClick(View v) {
		SQLiteDatabase db = ((MainActivity)getActivity()).mDBh.getReadableDatabase();
		mCursor.requery();
		mCursor = db.query(OpenDBHelper.DATABASE_NAME, new String[] {"0 _id", "name", "z" }, 
				"name"+" LIKE '%"+mSearch.getText().toString().toUpperCase()+"%'", null, null, null, null);
		adapter = new SimpleCursorAdapter(getActivity(), 
				android.R.layout.simple_list_item_2, 
				mCursor, 
				new String[] {"name", "z"}, 
				new int[] {android.R.id.text1, android.R.id.text2});
		mList.setAdapter(adapter);
	}

}
