package com.hoursoffame.android.data;

import com.hoursoffame.android.ui.MainActivity;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ParsePersister implements Persister {

    public static final String PARSE_TEXTITEM_CLASS = "text_item";
    public static final String PARSE_TITLE = "title";
    public static final String PARSE_TEXT = "text";
    public static final String PARSE_CREATION_TIME = "creation_time";

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
                textItem.setCreationTime(parseObject.getString(PARSE_CREATION_TIME));
                textItems[i] = textItem;
            }
            if (mainActivity != null) {
                mainActivity.setTextItems(textItems);
            }
        }
    };


    @Override
    public void saveTextItem(TextItem textItem) {
        ParseObject parseObject = new ParseObject(PARSE_TEXTITEM_CLASS);
        parseObject.put(PARSE_TITLE, textItem.getTitle());
        parseObject.put(PARSE_TEXT, textItem.getText());
        parseObject.put(PARSE_CREATION_TIME, textItem.getCreationTime());
        parseObject.saveInBackground();
    }

    @Override
    public TextItem[] retrieveTextItems() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery(PARSE_TEXTITEM_CLASS);
        query.findInBackground(callback);
        return new TextItem[0];
    }
}
