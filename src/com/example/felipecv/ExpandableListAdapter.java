package com.example.felipecv;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
	 
    private Activity context;
    private Map<String, List<String>> titleCollections;
    private List<String> title;
 
    public ExpandableListAdapter(Activity context, List<String> title,
            Map<String, List<String>> titleCollections) {
        this.context = context;
        this.titleCollections = titleCollections;
        this.title = title;
    }
 
    public Object getChild(int groupPosition, int childPosition) {
        return titleCollections.get(title.get(groupPosition)).get(childPosition);
    }
 
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
 
    public View getChildView(final int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        final String subtitle = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();
 
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_item, null);
        }
 
        TextView item = (TextView) convertView.findViewById(R.id.subtitle);

        item.setText(subtitle);
        return convertView;
    }
 
    public int getChildrenCount(int groupPosition) {
        return titleCollections.get(title.get(groupPosition)).size();
    }
 
    public Object getGroup(int groupPosition) {
        return title.get(groupPosition);
    }
 
    public int getGroupCount() {
        return title.size();
    }
 
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        String titleName = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.group_item,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.title);
        item.setTypeface(null, Typeface.BOLD);
        item.setText(titleName);
        return convertView;
    }
 
    public boolean hasStableIds() {
        return true;
    }
 
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}