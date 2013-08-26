package com.maximsblog.blogspot.com.maks2013;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Locale;
 
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
 
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class OpenDBHelper extends SQLiteAssetHelper {

	public static final String DATABASE_NAME = "catalog";
	public static final String DATABASE_NAME2 = "catalogen";
	private static final int DATABASE_VERSION = 1;
	
	
	public static final int NAME = 1;
	public static final int NOTE = 2;
	public static final int P = 3;
	public static final int Z = 4;


	public OpenDBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public OpenDBHelper(Context context, boolean notru) 
	{
			super(context, DATABASE_NAME2, null, DATABASE_VERSION);
	}

	public Cursor getEmployees() {

		SQLiteDatabase db = getReadableDatabase();
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

		String [] sqlSelect = {"0 _id", "name", "note", "p", "z"}; 
		String sqlTables = "catalog";

		qb.setTables(sqlTables);
		Cursor c = qb.query(db, sqlSelect, null, null,
				null, null, null);

		c.moveToFirst();
		return c;

	}

}