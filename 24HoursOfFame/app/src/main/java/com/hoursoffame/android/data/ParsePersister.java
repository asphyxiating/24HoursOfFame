package com.hoursoffame.android.data;

import com.parse.ParseObject;

public class ParsePersister implements Persister {

    public static final String PARSE_TEXTITEM_CLASS = "text_item";
    public static final String PARSE_TITLE = "title";
    public static final String PARSE_TEXT = "text";

    @Override
    public void saveTextItem(TextItem textItem) {
        ParseObject parseObject = new ParseObject(PARSE_TEXTITEM_CLASS);
        parseObject.put(PARSE_TITLE, textItem.getTitle());
        parseObject.put(PARSE_TEXT, textItem.getText());
        parseObject.saveInBackground();
    }

    @Override
    public TextItem[] retrieveTextItems() {
        return new TextItem[0];
    }
}
