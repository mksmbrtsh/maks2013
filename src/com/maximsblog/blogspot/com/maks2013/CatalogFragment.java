package com.maximsblog.blogspot.com.maks2013;

import android.content.Intent;
import android.database.Cursor;
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
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public final class CatalogFragment extends Fragment implements OnItemClickListener {
	private SimpleCursorAdapter adapter;
	
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
    	ListView list = (ListView) layout.findViewById(R.id.catalog_list);
    	list.setOnItemClickListener(this);
        
        
        Cursor employees = ((MainActivity)getActivity()).employees;
        
        adapter = new SimpleCursorAdapter(getActivity(), 
				android.R.layout.simple_list_item_2, 
				employees, 
				new String[] {"name", "p"}, 
				new int[] {android.R.id.text1, android.R.id.text2});
        list.setAdapter(adapter);
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
		intent.putExtra("note", adapter.getCursor().getString(OpenDBHelper.NOTE));
		intent.putExtra("p", adapter.getCursor().getString(OpenDBHelper.P));
		intent.putExtra("z", adapter.getCursor().getString(OpenDBHelper.Z));
		getActivity().startActivity(intent);
	}

}
