package com.coolots.chaton.common.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ContextDialogMenuArrayAdapter extends ArrayAdapter<String> {
    private LayoutInflater inflater;
    private Context mContext;
    private int mDisableIdx;
    private ArrayList<String> menuTextList;

    public ContextDialogMenuArrayAdapter(Context c, int textViewResourceId, ArrayList<String> arrays) {
        super(c, textViewResourceId, arrays);
        this.inflater = null;
        this.menuTextList = null;
        this.mContext = null;
        this.mDisableIdx = -1;
        this.inflater = LayoutInflater.from(c);
        this.mContext = c;
        this.menuTextList = arrays;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return super.getCount();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public String getItem(int position) {
        return (String) super.getItem(position);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void setDisableMenuItem(int index) {
        this.mDisableIdx = index;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertview, ViewGroup parent) {
        View v = convertview;
        if (v == null) {
            v = this.inflater.inflate(C0000R.layout.context_simple_list_item, (ViewGroup) null);
        }
        TextView menuItemTextView = (TextView) v.findViewById(C0000R.id.contextmenu_item_text);
        menuItemTextView.setText(this.menuTextList.get(position));
        if (this.mDisableIdx != -1) {
            if (position == 0) {
                menuItemTextView.setEnabled(true);
            } else if (position == this.mDisableIdx) {
                menuItemTextView.setEnabled(false);
                menuItemTextView.setClickable(false);
            }
        }
        return v;
    }
}
