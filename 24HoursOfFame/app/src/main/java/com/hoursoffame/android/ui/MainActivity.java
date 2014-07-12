package com.hoursoffame.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.hoursoffame.android.R;
import com.hoursoffame.android.data.LocalPersister;
import com.hoursoffame.android.data.Persister;
import com.hoursoffame.android.ui.CreateTextitemActivity;
import com.hoursoffame.android.ui.adapters.ListViewAdapter;
import com.parse.Parse;


public class MainActivity extends Activity {

    private Persister persister;
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, "43P0a4QuZcCnmepEPYAnmSBXtWo7Gt01oLfSOSmw", "K4CBhkRPuBqXUsjaZMHP5HyEP67QSj45WGZduOPY");
        setContentView(R.layout.activity_main);
        persister = new LocalPersister(getSharedPreferences("Persister", 0));
        listView = (ListView) findViewById(R.id.listView);
        listViewAdapter = new ListViewAdapter(this, persister.retrieveTextItems());
        listView.setAdapter(listViewAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.createTextItem) {
            Intent intent = new Intent(this, CreateTextitemActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
