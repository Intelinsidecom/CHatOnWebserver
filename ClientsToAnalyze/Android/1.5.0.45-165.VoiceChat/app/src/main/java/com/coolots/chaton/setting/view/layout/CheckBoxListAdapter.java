package com.coolots.chaton.setting.view.layout;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/* loaded from: classes.dex */
public class CheckBoxListAdapter extends ArrayAdapter<CharSequence> {
    private boolean[] mClickedDialogEntryIndices;
    private Context mContext;
    private CharSequence[] mEntries;
    private LayoutInflater mInflater;
    private int mResource;

    public CheckBoxListAdapter(Context context, int layoutResource, CharSequence[] objects) {
        super(context, layoutResource, objects);
        this.mContext = context;
        this.mResource = layoutResource;
        this.mEntries = objects;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void setData(boolean[] clickedDialogEntryIndices) {
        this.mClickedDialogEntryIndices = clickedDialogEntryIndices;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = this.mInflater.inflate(this.mResource, (ViewGroup) null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.title);
        textView.setText(this.mEntries[position]);
        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);
        checkBox.setChecked(this.mClickedDialogEntryIndices[position]);
        return convertView;
    }
}
