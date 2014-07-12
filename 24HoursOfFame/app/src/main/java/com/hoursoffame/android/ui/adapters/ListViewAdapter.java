package com.hoursoffame.android.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hoursoffame.android.data.TextItem;

public class ListViewAdapter extends ArrayAdapter<TextItem> {


    public ListViewAdapter(Context context, TextItem[] textItems) {
        super(context, 0, textItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(getContext());
        TextItem textItem = getItem(position);
        textView.setText(textItem.getText() + textItem.getTitle());
        textView.setPadding(10, 10, 10, 10);
        return textView;
    }
}
