package com.hoursoffame.android.data;

public interface Persister {

    void saveTextItem(TextItem textItem);

    TextItem[] retrieveTextItems();

}
