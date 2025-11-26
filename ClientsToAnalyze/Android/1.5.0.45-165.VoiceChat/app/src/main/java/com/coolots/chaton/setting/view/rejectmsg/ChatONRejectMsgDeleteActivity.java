package com.coolots.chaton.setting.view.rejectmsg;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.setting.controller.ChatONRejectMsgAdapter;
import com.coolots.chaton.setting.data.ChatONRejectMsgData;
import com.coolots.chaton.setting.data.ChatONRejectMsgList;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONRejectMsgDeleteActivity extends Activity implements DisposeInterface, Parcelable {
    public static final String CHECK_LIST_KEY = "check_list_key";
    private static final String CLASSNAME = "[ChatONRejectMsgDeleteActivity]";
    public static final String MESSAGE_LIST_KEY = "message_list_key";
    private RelativeLayout mActionbarLayout;
    private TextView mCancelButtonTxt;
    private ChatOnService mChatonservice;
    private List<Boolean> mCheckList;
    private LinearLayout mDoneButtonArea;
    private TextView mDoneButtonTxt;
    public AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgDeleteActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                boolean check = ((Boolean) ChatONRejectMsgDeleteActivity.this.mCheckList.get(0)).booleanValue() ? false : true;
                int count = ChatONRejectMsgDeleteActivity.this.mCheckList.size();
                for (int i = 0; i < count; i++) {
                    ChatONRejectMsgDeleteActivity.this.mCheckList.set(i, Boolean.valueOf(check));
                }
            } else {
                ChatONRejectMsgDeleteActivity.this.mCheckList.set(position, Boolean.valueOf(((Boolean) ChatONRejectMsgDeleteActivity.this.mCheckList.get(position)).booleanValue() ? false : true));
                ChatONRejectMsgDeleteActivity.this.mCheckList.set(0, Boolean.valueOf(ChatONRejectMsgDeleteActivity.this.isCheckListAllChecked()));
            }
            ChatONRejectMsgDeleteActivity.this.mMsgAdapter.notifyDataSetChanged();
            ChatONRejectMsgDeleteActivity.this.setEnabledSelectedButton(ChatONRejectMsgDeleteActivity.this.isCheckListChecked());
        }
    };
    private View mLine;
    private ListView mListView;
    private ChatONRejectMsgAdapter mMsgAdapter;
    private ChatONRejectMsgList mMsgList;
    private TextView mTitleTxt;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(C0000R.layout.reject_call_with_msg_delete);
        LinearLayout fulllayout = (LinearLayout) findViewById(C0000R.id.reject_Call_with_msg_delete_layout);
        LinearLayout linearlayout = (LinearLayout) findViewById(C0000R.id.reject_call_layout);
        this.mLine = findViewById(C0000R.id.reject_msg_delete_with_msg_line);
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            fulllayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            linearlayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            this.mLine.setBackground(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
        } else {
            linearlayout.setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            fulllayout.setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            this.mLine.setBackground(getResources().getDrawable(C0000R.drawable.list_divider));
        }
        ChatONRejectMsgData msgData = new ChatONRejectMsgData();
        msgData.addMessage(0, getString(C0000R.string.reject_msg_select_all));
        List<String> defaultRejectMsgs = ((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg();
        ChatONRejectMsgList msgList = new ChatONRejectMsgList(defaultRejectMsgs, 6);
        msgData.addMessages(msgList.getMessageList());
        this.mMsgList = new ChatONRejectMsgList(6, msgData);
        this.mCheckList = new ArrayList();
        for (int i = 0; i < this.mMsgList.getCount(); i++) {
            this.mCheckList.add(false);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            this.mMsgAdapter = new ChatONRejectMsgAdapter(this, this.mMsgList, C0000R.layout.list_item_text_with_checkbox_black, C0000R.id.text_view, C0000R.id.checkbox, this.mCheckList);
        } else {
            this.mMsgAdapter = new ChatONRejectMsgAdapter(this, this.mMsgList, C0000R.layout.list_item_text_with_checkbox, C0000R.id.text_view, C0000R.id.checkbox, this.mCheckList);
        }
        this.mListView = (ListView) findViewById(C0000R.id.reject_call_with_msg_list);
        this.mListView.setAdapter((ListAdapter) this.mMsgAdapter);
        this.mActionbarLayout = (RelativeLayout) findViewById(C0000R.id.reject_msg_actionbar);
        this.mTitleTxt = (TextView) findViewById(C0000R.id.title_reject_message);
        this.mCancelButtonTxt = (TextView) findViewById(C0000R.id.cancel_text);
        this.mDoneButtonTxt = (TextView) findViewById(C0000R.id.selected_done_btn);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            this.mActionbarLayout.setBackgroundResource(C0000R.color.tw_light_color001);
            this.mTitleTxt.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mCancelButtonTxt.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mDoneButtonTxt.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mListView.setSelector(C0000R.drawable.list_bg_selector_black);
            this.mListView.setDivider(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
            this.mListView.setDividerHeight(1);
        } else {
            this.mListView.setSelector(C0000R.drawable.list_bg_selector);
            this.mListView.setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
        }
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mDoneButtonArea = (LinearLayout) findViewById(C0000R.id.select_done_layout);
        setEnabledSelectedButton(false);
        getAppOrientation();
    }

    @Override // android.app.Activity
    protected void onResume() {
        logI("onResume");
        super.onResume();
        setEnabledSelectedButton(isCheckListChecked());
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause");
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setEnabledSelectedButton(isCheckListChecked());
    }

    public int getAppOrientation() {
        return getResources().getConfiguration().orientation;
    }

    public void setEnabledSelectedButton(boolean flag) {
        this.mDoneButtonArea.setEnabled(flag);
        this.mDoneButtonTxt.setEnabled(flag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckListChecked() {
        boolean isChecked = false;
        Iterator<Boolean> iter = this.mCheckList.iterator();
        iter.next();
        while (iter.hasNext()) {
            if (iter.next().booleanValue()) {
                isChecked = true;
            }
        }
        return isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCheckListAllChecked() {
        boolean isAllChecked = true;
        Iterator<Boolean> iter = this.mCheckList.iterator();
        iter.next();
        while (iter.hasNext()) {
            if (!iter.next().booleanValue()) {
                isAllChecked = false;
            }
        }
        return isAllChecked;
    }

    public void onClickDone(View view) {
        Intent data = new Intent();
        Bundle extras = new Bundle();
        this.mCheckList.set(0, false);
        extras.putSerializable(CHECK_LIST_KEY, (Serializable) this.mCheckList);
        data.putExtras(extras);
        setResult(-1, data);
        finish();
    }

    public void onClickBackPage(View view) {
        setResult(0, null);
        finish();
    }

    public void onClickCancel(View view) {
        setResult(0, null);
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        setResult(0, null);
        finish();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        if (this.mMsgList != null) {
            this.mMsgList.dispose();
            this.mMsgList = null;
        }
        if (this.mMsgAdapter != null) {
            this.mMsgAdapter.dispose();
            this.mMsgAdapter = null;
        }
        if (this.mCheckList != null) {
            this.mCheckList.clear();
            this.mCheckList = null;
        }
        if (this.mListView != null) {
            this.mListView = null;
        }
        if (this.mDoneButtonArea != null) {
            this.mDoneButtonArea = null;
        }
        if (this.mLine != null) {
            this.mLine = null;
        }
        System.gc();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel arg0, int arg1) {
    }
}
