package com.hoursoffame.android.data;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class LocalPersister implements Persister {

    private SharedPreferences sharedPreferences;

    public LocalPersister(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void saveTextItem(TextItem textItem) {
        Set<String> set = sharedPreferences.getStringSet("text item", new HashSet<String>());
        set.add(textItem.getText() + " / " + textItem.getTitle());
        sharedPreferences.edit().putStringSet("text item", set).commit();
    }

    @Override
    public TextItem[] retrieveTextItems() {
        Set<String> set = sharedPreferences.getStringSet("text item", new HashSet<String>());
        TextItem[] textItems = new TextItem[set.size()];
        int i = 0;
        for (String string : set) {
            TextItem textItem = new TextItem();
            textItem.setText(string.substring(0, string.indexOf("/")));
            textItem.setTitle(string.substring(string.indexOf("/"), string.length()));
            textItems[i]= textItem;
            i++;
        }
        return textItems;
    }
}
