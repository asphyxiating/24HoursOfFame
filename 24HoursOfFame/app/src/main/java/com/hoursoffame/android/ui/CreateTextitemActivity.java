package com.hoursoffame.android.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hoursoffame.android.R;
import com.hoursoffame.android.data.ParsePersister;
import com.hoursoffame.android.data.Persister;
import com.hoursoffame.android.data.TextItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CreateTextitemActivity extends Activity {

    private EditText titleEditText;
    private EditText textEditText;
    private Persister persister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_textitem_activity);
        titleEditText = (EditText) findViewById(R.id.titleEditText);
        textEditText = (EditText) findViewById(R.id.textEditText);
        persister = new ParsePersister();
        persister.retrieveTextItems();
    }

    public void saveOnClick(View view) {
        TextItem textItem = new TextItem();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = df.format(calendar.getTime());

        textItem.setTitle(titleEditText.getText().toString());
        textItem.setText(textEditText.getText().toString());
        textItem.setCreationTime(formattedDate);
        persister.saveTextItem(textItem);
        finish();

    }
}
