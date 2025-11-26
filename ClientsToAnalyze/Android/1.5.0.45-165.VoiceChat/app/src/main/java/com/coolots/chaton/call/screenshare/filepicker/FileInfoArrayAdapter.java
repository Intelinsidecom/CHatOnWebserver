package com.coolots.chaton.call.screenshare.filepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.sds.coolots.common.util.Log;
import java.util.List;

/* loaded from: classes.dex */
public class FileInfoArrayAdapter extends ArrayAdapter<FileInfo> {
    private static final String CLASSNAME = "[FileInfoArrayAdapter]";
    private Context mContext;
    private LayoutInflater mInflater;
    private List<FileInfo> mItems;
    private int mLayoutResourceId;

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public FileInfoArrayAdapter(Context context, int layoutResourceId, List<FileInfo> objects) {
        super(context, layoutResourceId, objects);
        this.mContext = context;
        this.mLayoutResourceId = layoutResourceId;
        this.mItems = objects;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public FileInfo getItem(int position) {
        return this.mItems.get(position);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = this.mInflater.inflate(this.mLayoutResourceId, (ViewGroup) null);
        }
        FileInfo fileInfo = this.mItems.get(position);
        if (fileInfo != null) {
            logI("<CIH> name = " + fileInfo.getName() + " category = " + fileInfo.getCategory());
            ImageView icon = (ImageView) v.findViewById(C0000R.id.filepicker_icon);
            if (icon != null) {
                icon.setImageResource(fileInfo.getIconResId());
            }
            TextView name = (TextView) v.findViewById(C0000R.id.filepicker_name);
            if (name != null) {
                name.setText(fileInfo.getName());
            }
        }
        return v;
    }
}
