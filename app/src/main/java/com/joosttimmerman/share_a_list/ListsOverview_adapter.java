package com.joosttimmerman.share_a_list;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import database.ListName;

/**
 * Created by Joost on 12-9-2014.
 */
public class ListsOverview_adapter extends ArrayAdapter<ListName> {

    Context context;
    List<ListName> listnames;

    public ListsOverview_adapter(Context context, int resourceId, List<ListName> listnames) {
        super(context, resourceId, listnames);

        this.listnames = listnames;
        this.context = context;
    }

    // private view holder class for performance
    private class ViewHolder {
        CheckBox checked;
        TextView item_name;
        int pos;
    }

    // get the view and set item details
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        ListName item = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.listitem_lists_overview, null);
            holder = new ViewHolder();

            holder.checked = (CheckBox) convertView.findViewById(R.id.grocery_checkbox);
            holder.item_name = (TextView) convertView.findViewById(R.id.item_name);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // set the actual info
        holder.pos = position;
        holder.checked.setChecked(false);
        holder.item_name.setText(item.getListName());

        return convertView;
    }

}