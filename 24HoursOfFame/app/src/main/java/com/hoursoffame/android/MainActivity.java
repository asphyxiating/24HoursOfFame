package com.hoursoffame.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.hoursoffame.android.data.LocalPersister;
import com.hoursoffame.android.data.Persister;
import com.hoursoffame.android.data.TextItem;
import com.hoursoffame.android.ui.CreateTextitemActivity;


public class MainActivity extends Activity {

    private Persister persister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persister = new LocalPersister(getSharedPreferences("Persister", 0));

        TextItem textItem1 = new TextItem();
        textItem1.setTitle("steffi");
        textItem1.setText("likes Alice in Wonderland");
        TextItem textItem2 = new TextItem();
        textItem2.setTitle("sam");
        textItem2.setText("likes crack");
        persister.saveTextItem(textItem1);
        persister.saveTextItem(textItem2);
        TextItem[] textItems = persister.retrieveTextItems();
        for (TextItem textItem : textItems) {
            Log.d(MainActivity.class.getCanonicalName(), "Title: " + textItem.getTitle() + " text: " + textItem.getTitle());
        }
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
