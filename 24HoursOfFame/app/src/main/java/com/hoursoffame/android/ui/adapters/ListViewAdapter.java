package com.hoursoffame.android.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hoursoffame.android.R;
import com.hoursoffame.android.data.TextItem;

public class ListViewAdapter extends ArrayAdapter<TextItem> {

    TextItem textItem;

    public ListViewAdapter(Context context, TextItem[] textItems) {
        super(context, 0, textItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        RelativeLayout relLayout = (RelativeLayout) inflater.inflate(R.layout.textitem_in_listview, null);

        textItem = getItem(position);

        TextView titleTv = (TextView) relLayout.findViewById(R.id.title);
        TextView textTv = (TextView) relLayout.findViewById(R.id.text);
        TextView timestampTv = (TextView) relLayout.findViewById(R.id.timestamp);

        titleTv.setText(textItem.getTitle());
        textTv.setText(textItem.getText());
        timestampTv.setText(textItem.getCreationTime());


        /*TextView textView = new TextView(getContext());
        TextItem textItem = getItem(position);

        textView.setText(textItem.getTitle() + " / " + textItem.getText() + " / " + textItem.getCreationTime());
        textView.setPadding(10, 10, 10, 10); */
        return relLayout;
    }
}
