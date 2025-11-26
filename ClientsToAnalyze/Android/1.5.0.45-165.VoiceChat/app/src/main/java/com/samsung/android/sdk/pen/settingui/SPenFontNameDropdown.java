package com.samsung.android.sdk.pen.settingui;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.pen.util.SpenFont;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class SPenFontNameDropdown extends SPenDropdownView implements AdapterView.OnItemClickListener {
    private final Context context;
    private final Handler mHandler;
    private final SPenImageUtil mImageUtil;
    private final ArrayList<String> mItemList;
    private final ListView mListView;
    private NameDropdownSelectListner mListener;
    private final View root;
    private final Runnable runnable;
    private int windowHeight;
    private int windowWidth;

    public interface NameDropdownSelectListner {
        void onSelectItem(int i);
    }

    private class ListAdapter extends ArrayAdapter<String> {
        Context context;
        List<String> items;

        public ListAdapter(Context context, int textViewResourceId, List<String> list) {
            super(context, textViewResourceId, list);
            this.items = new ArrayList();
            this.items = list;
            this.context = context;
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(this.context);
                convertView = inflater.inflate(R.layout.simple_spinner_item, parent, false);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.text1);
            tv.setSingleLine(true);
            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setText(this.items.get(position));
            tv.setTextColor(-16777216);
            tv.setTextSize(0, SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(15.0f));
            tv.setGravity(19);
            tv.setPadding(SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(6.0f), 0, SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(6.0f), 0);
            tv.setMinimumHeight(SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(37.0f));
            Typeface tf = SpenFont.getTypeFace(position);
            tv.setTypeface(tf);
            return convertView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(this.context);
                convertView = inflater.inflate(R.layout.simple_spinner_item, parent, false);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.text1);
            tv.setSingleLine(true);
            tv.setEllipsize(TextUtils.TruncateAt.END);
            tv.setText(this.items.get(position));
            tv.setTextColor(-16777216);
            tv.setTextSize(0, SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(15.0f));
            tv.setGravity(19);
            tv.setPadding(SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(6.0f), 0, SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(6.0f), 0);
            tv.setMinimumHeight(SPenFontNameDropdown.this.mImageUtil.getIntValueAppliedDensity(37.0f));
            Typeface tf = SpenFont.getTypeFace(position);
            tv.setTypeface(tf);
            return convertView;
        }
    }

    public SPenFontNameDropdown(View anchor, ArrayList<String> itemList, int width, int height, float ratio) throws Resources.NotFoundException, IOException {
        super(anchor);
        this.mListener = null;
        this.windowWidth = 0;
        this.windowHeight = 0;
        this.runnable = new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown.1
            @Override // java.lang.Runnable
            public void run() {
                int mtempHeight;
                try {
                    if (SPenFontNameDropdown.this.context != null) {
                        int mtempHeight2 = SPenFontNameDropdown.this.windowHeight;
                        if (mtempHeight2 <= SPenFontNameDropdown.this.window.getMaxAvailableHeight(SPenFontNameDropdown.this.anchor)) {
                            mtempHeight = SPenFontNameDropdown.this.windowHeight;
                        } else {
                            mtempHeight = SPenFontNameDropdown.this.window.getMaxAvailableHeight(SPenFontNameDropdown.this.anchor);
                        }
                        SPenFontNameDropdown.this.window.update(SPenFontNameDropdown.this.anchor, SPenFontNameDropdown.this.windowWidth, mtempHeight);
                    }
                } catch (IllegalArgumentException e) {
                }
            }
        };
        this.mHandler = new Handler();
        this.windowWidth = width;
        this.windowHeight = height;
        this.context = anchor.getContext();
        this.mItemList = itemList;
        this.mImageUtil = new SPenImageUtil(this.context, "", ratio);
        FrameLayout dropdownLayout = new FrameLayout(this.context);
        FrameLayout.LayoutParams dropdownLayoutParam = new FrameLayout.LayoutParams(-2, -2);
        dropdownLayout.setLayoutParams(dropdownLayoutParam);
        this.mListView = new ListView(this.context);
        this.mListView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        dropdownLayout.addView(this.mListView);
        this.root = dropdownLayout;
        setContentView(this.root);
        ArrayAdapter<String> adapter = new ListAdapter(this.context, R.layout.simple_list_item_1, this.mItemList);
        this.mListView.setAdapter((android.widget.ListAdapter) adapter);
        this.mListView.setOnItemClickListener(this);
        this.mListView.setDivider(this.mImageUtil.setDrawableImg("tw_list_divider_holo_light"));
        this.mListView.setDividerHeight(1);
        Drawable background = this.mImageUtil.setDrawableImg("tw_menu_dropdown_panel_holo_light");
        setBackgroundDrawable(background);
        this.window.setWidth(width);
        this.window.setHeight(height);
    }

    public void updatePosition() {
        if (this.mHandler != null && this.window != null && this.window.isShowing()) {
            this.mHandler.postDelayed(this.runnable, 100L);
        }
    }

    public void show(int x, int y, String setItem) {
        int mtempHeight;
        super.show();
        int index = this.mItemList.indexOf(setItem);
        if (index != -1) {
            this.mListView.setSelection(index);
        }
        this.root.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.root.measure(-2, -2);
        int mtempHeight2 = this.windowHeight;
        if (mtempHeight2 > this.window.getMaxAvailableHeight(this.anchor)) {
            mtempHeight = this.window.getMaxAvailableHeight(this.anchor);
        } else {
            mtempHeight = this.windowHeight;
        }
        this.window.setWidth(this.windowWidth);
        this.window.setHeight(mtempHeight);
        this.window.showAsDropDown(this.anchor, x, y);
        updatePosition();
    }

    public void changeOrientation(Configuration config) {
        dismiss();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
        if (this.mListener != null) {
            this.mListener.onSelectItem(position);
        }
        dismiss();
    }

    public void setOnItemSelectListner(NameDropdownSelectListner listner) {
        this.mListener = listner;
    }
}
