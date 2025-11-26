package com.coolots.chaton.setting.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.setting.data.ChatONRejectMsgList;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONRejectMsgAdapter extends BaseAdapter implements DisposeInterface {
    private static final String CLASSNAME = "[ChatONRejectMsgAdapter]";
    private int mCheckBoxID;
    private List<Boolean> mCheckList;
    private LayoutInflater mInflater;
    private ChatONRejectMsgList mItem;
    private int mItemLayout;
    private int mTextViewID;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ChatONRejectMsgAdapter(Context context, ChatONRejectMsgList item, int itemLayout, int textViewID, int checkBoxID, List<Boolean> checkList) {
        logI("ChatONRejectMsgAdapter create");
        item.description();
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mItem = item;
        this.mItemLayout = itemLayout;
        this.mTextViewID = textViewID;
        this.mCheckBoxID = checkBoxID;
        this.mCheckList = checkList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItem.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.mItem.getMessage(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int position) {
        return this.mItem.getType(position);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        logI("getView(" + position + ")");
        this.mItem.description(position);
        if (convertView == null) {
            logI("convertView reload..... ");
            int res = this.mItemLayout;
            convertView = this.mInflater.inflate(res, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(this.mTextViewID);
        if (textView == null) {
            logI("textView == null " + position);
        } else {
            if (this.mItem.getType(position) == 0) {
                textView.setText(this.mItem.getMessage(position));
            } else {
                List<String> defaultString = ((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg();
                textView.setText(defaultString.get(this.mItem.getType(position) - 1));
            }
            CheckBox checkBox = (CheckBox) convertView.findViewById(this.mCheckBoxID);
            if (this.mCheckList == null) {
                if (checkBox != null) {
                    checkBox.setVisibility(8);
                }
            } else if (checkBox != null) {
                checkBox.setVisibility(0);
                checkBox.setChecked(this.mCheckList.get(position).booleanValue());
            }
            logI("-------------------------------------------");
        }
        return convertView;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mInflater = null;
        if (this.mItem != null) {
            this.mItem.dispose();
            this.mItem = null;
        }
        if (this.mCheckList != null) {
            this.mCheckList.clear();
            this.mCheckList = null;
        }
    }
}
