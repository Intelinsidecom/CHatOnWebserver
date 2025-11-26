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
class SPenFontNameDropdown2 extends SPenDropdownView implements AdapterView.OnItemClickListener {
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
            tv.setTextSize(0, SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(18.0f));
            tv.setGravity(3);
            tv.setGravity(16);
            tv.setPadding(SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(8.0f), 0, SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(10.0f), 0);
            tv.setMinimumHeight(SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(41.0f));
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
            tv.setTextSize(0, SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(18.0f));
            tv.setGravity(19);
            tv.setPadding(SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(8.0f), 0, SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(10.0f), 0);
            tv.setMinimumHeight(SPenFontNameDropdown2.this.mImageUtil.getIntValueAppliedDensity(41.0f));
            Typeface tf = SpenFont.getTypeFace(position);
            tv.setTypeface(tf);
            return convertView;
        }
    }

    public SPenFontNameDropdown2(View anchor, ArrayList<String> itemList, int width, int height, float ratio) throws Resources.NotFoundException, IOException {
        super(anchor);
        this.mListener = null;
        this.windowWidth = 0;
        this.windowHeight = 0;
        this.runnable = new Runnable() { // from class: com.samsung.android.sdk.pen.settingui.SPenFontNameDropdown2.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SPenFontNameDropdown2.this.context != null) {
                        SPenFontNameDropdown2.this.window.update(SPenFontNameDropdown2.this.anchor, SPenFontNameDropdown2.this.windowWidth, SPenFontNameDropdown2.this.windowHeight);
                    }
                    if (SPenFontNameDropdown2.this.window.isShowing()) {
                        SPenFontNameDropdown2.this.mHandler.postDelayed(SPenFontNameDropdown2.this.runnable, 100L);
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
        Drawable background = this.mImageUtil.setDrawableImg("tw_menu_dropdown_panel_holo_light");
        setBackgroundDrawable(background);
        this.window.setWidth(width);
        this.window.setHeight(height);
    }

    public void show(int x, int y, String setItem) {
        super.show();
        int index = this.mItemList.indexOf(setItem);
        if (index != -1) {
            this.mListView.setSelection(index);
        }
        this.root.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        this.root.measure(-2, -2);
        this.window.showAsDropDown(this.anchor, x, y);
        this.mHandler.post(this.runnable);
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
