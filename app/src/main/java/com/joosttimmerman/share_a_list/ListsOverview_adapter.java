package com.joosttimmerman.share_a_list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Joost on 10-9-2014.
 */
public class ListsOverview_adapter extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;

    public ListsOverview_adapter(Activity context,String[] web, Integer[] imageId) {
        super(context, R.layout.rowlayout_lists_overview, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.rowlayout_lists_overview, null, true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);

        return rowView;
    }
}