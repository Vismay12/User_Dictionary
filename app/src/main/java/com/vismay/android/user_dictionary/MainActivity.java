package com.vismay.android.user_dictionary;

import android.app.Activity;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.UserDictionary;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    ListView dictView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dictView = (ListView) findViewById(R.id.listView);


            ContentResolver resolver = getContentResolver();
            Cursor cursor = resolver.query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
       // dictView.setText("The dictionary has" + cursor.getCount() + "words\n");
        //dictView.append("COLUMNS " + UserDictionary.Words._ID + "FREQUENCY" + UserDictionary.Words.FREQUENCY + "WORD " + UserDictionary.Words.WORD);
        String[] values= {UserDictionary.Words.WORD,UserDictionary.Words.FREQUENCY};
            int[] ids={android.R.id.text1,android.R.id.text2};

           // while (cursor.moveToNext()) {
//                int rowId = cursor.getInt(cursor.getColumnIndex(UserDictionary.Words._ID));
//                int noOfFreq = cursor.getInt(cursor.getColumnIndex(UserDictionary.Words.FREQUENCY));
//                String word = cursor.getString(cursor.getColumnIndex(UserDictionary.Words.WORD));
//                //dictView.append("\n" + rowId + " " + noOfFreq + " " + word);

                SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,values,ids,0);
                dictView.setAdapter(adapter);
            //}



    }


}
