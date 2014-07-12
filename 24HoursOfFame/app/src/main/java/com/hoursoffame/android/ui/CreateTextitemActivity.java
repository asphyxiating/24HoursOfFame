package com.hoursoffame.android.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.hoursoffame.android.R;
import com.hoursoffame.android.data.LocalPersister;
import com.hoursoffame.android.data.ParsePersister;
import com.hoursoffame.android.data.Persister;
import com.hoursoffame.android.data.TextItem;


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
        textItem.setTitle(titleEditText.getText().toString());
        textItem.setText(textEditText.getText().toString());
        persister.saveTextItem(textItem);
        finish();
    }
}
