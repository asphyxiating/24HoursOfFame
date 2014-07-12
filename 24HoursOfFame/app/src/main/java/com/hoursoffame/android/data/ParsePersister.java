package com.hoursoffame.android.data;

import android.content.Context;
import android.util.Log;

import com.hoursoffame.android.ui.MainActivity;
import com.hoursoffame.android.ui.adapters.ListViewAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Arrays;
import java.util.List;

public class ParsePersister implements Persister {

    public static final String PARSE_TEXTITEM_CLASS = "text_item";
    public static final String PARSE_TITLE = "title";
    public static final String PARSE_TEXT = "text";

    private MainActivity mainActivity;

    public ParsePersister(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public ParsePersister() {
    }

    private FindCallback<ParseObject> callback = new FindCallback<ParseObject>() {
        @Override
        public void done(List<ParseObject> parseObjects, ParseException e) {
            TextItem[] textItems = new TextItem[parseObjects.size()];
            for (int i = 0; i < parseObjects.size(); i++) {
                TextItem textItem = new TextItem();
                ParseObject parseObject = parseObjects.get(i);
                textItem.setTitle(parseObject.getString(PARSE_TITLE));
                textItem.setText(parseObject.getString(PARSE_TEXT));
                textItems[i] = textItem;
            }
            mainActivity.setTextItems(textItems);
        }
    };


    @Override
    public void saveTextItem(TextItem textItem) {
        ParseObject parseObject = new ParseObject(PARSE_TEXTITEM_CLASS);
        parseObject.put(PARSE_TITLE, textItem.getTitle());
        parseObject.put(PARSE_TEXT, textItem.getText());
        parseObject.saveInBackground();
    }

    @Override
    public TextItem[] retrieveTextItems() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(PARSE_TEXTITEM_CLASS);
        query.findInBackground(callback);
        return new TextItem[0];
    }
}
