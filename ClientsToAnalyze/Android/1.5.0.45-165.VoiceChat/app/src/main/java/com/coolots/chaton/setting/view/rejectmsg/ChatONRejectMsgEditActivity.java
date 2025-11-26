package com.coolots.chaton.setting.view.rejectmsg;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.EditRejectTextByteLengthFilter;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class ChatONRejectMsgEditActivity extends Activity implements View.OnClickListener, DisposeInterface {
    private static final String CHARACTER_SET = "KSC5601";
    private static final String CLASSNAME = "[ChatONRejectMsgEditActivity]";
    public static final String EXTRAS_KEY_COUNT = "key_count";
    public static final String EXTRAS_KEY_DEVICEID = "key_deviceid";
    public static final String EXTRAS_KEY_INDEX = "key_index";
    public static final String EXTRAS_KEY_MESSAGE = "key_message";
    public static final String EXTRAS_KEY_SEND_MSG = "key_send_msg";
    public static final String EXTRAS_KEY_USERID = "key_userid";
    public static final String EXTRAS_KEY_USERNAME = "key_username";
    private static final int MAX_STRING_BYTE = 80;
    private static Toast mToast;
    private View mBtnBack;
    private View mBtnCancel;
    private View mBtnDone;
    private TextView mCancelButtonTxt;
    private ChatOnService mChatonservice;
    private TextView mDoneButtonTxt;
    private boolean mEditBoxFilter;
    private EditText mEditText;
    private Handler mHandler;
    private RejectMessageInfo mRejectMsgInfo;
    private int mSelectedIndex;
    private String mSelectedMsg;
    private TextView mTitleText;
    private int mCursorStartPos = 0;
    private int mCursorEndPos = 0;
    private LinkedHashMap<String, RejectMessageInfo> mRejectMsgMap = null;
    private boolean isSendingRejectMsgFinish = false;
    private InputMethodManager mgr = null;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static class RejectMessageInfo {
        private short mDeviceID;
        private boolean mIsSendMsg;
        private String mRejectMsg;
        private String mUserID;
        private String mUserName;

        public RejectMessageInfo(boolean mIsSendMsg, String mUserID, short mDeviceID, String mUserName, String mRejectMsg) {
            this.mIsSendMsg = mIsSendMsg;
            this.mUserID = mUserID;
            this.mDeviceID = mDeviceID;
            this.mUserName = mUserName;
            this.mRejectMsg = mRejectMsg;
        }

        public boolean isSendMsg() {
            return this.mIsSendMsg;
        }

        public void setSendMsg(boolean mIsSendMsg) {
            this.mIsSendMsg = mIsSendMsg;
        }

        public String getUserID() {
            return this.mUserID;
        }

        public void setUserID(String mUserID) {
            this.mUserID = mUserID;
        }

        public short getDeviceID() {
            return this.mDeviceID;
        }

        public void setDeviceID(short mDeviceID) {
            this.mDeviceID = mDeviceID;
        }

        public String getUserName() {
            return this.mUserName;
        }

        public void setUserName(String mUserName) {
            this.mUserName = mUserName;
        }

        public String getRejectMsg() {
            return this.mRejectMsg;
        }

        public void setRejectMsg(String mRejectMsg) {
            this.mRejectMsg = mRejectMsg;
        }
    }

    class EditBoxHandler extends Handler {
        EditBoxHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg == null || msg.what != 1000 || !ChatONRejectMsgEditActivity.this.mEditBoxFilter) {
                return;
            }
            ChatONRejectMsgEditActivity.this.updateTitleText();
            if (msg.arg2 <= 0) {
                ChatONRejectMsgEditActivity.this.mSelectedMsg = ChatONRejectMsgEditActivity.this.mEditText.getText().toString();
            } else {
                ChatONRejectMsgEditActivity.mToast.setText(ChatONRejectMsgEditActivity.this.getString(C0000R.string.reject_msg_edit_page_byte_info_noti, new Object[]{Integer.valueOf(ChatONRejectMsgEditActivity.MAX_STRING_BYTE)}));
                ChatONRejectMsgEditActivity.mToast.show();
                if (msg.obj != null) {
                    ChatONRejectMsgEditActivity.this.mSelectedMsg = (String) msg.obj;
                    ChatONRejectMsgEditActivity.this.mCursorStartPos = ChatONRejectMsgEditActivity.this.mEditText.getSelectionStart();
                    ChatONRejectMsgEditActivity.this.mCursorEndPos = ChatONRejectMsgEditActivity.this.mEditText.getSelectionEnd();
                    ChatONRejectMsgEditActivity.this.mEditText.setText(ChatONRejectMsgEditActivity.this.mSelectedMsg);
                    ChatONRejectMsgEditActivity.this.mEditText.setSelection(ChatONRejectMsgEditActivity.this.mCursorStartPos, ChatONRejectMsgEditActivity.this.mCursorEndPos);
                    ChatONRejectMsgEditActivity.this.initView();
                }
            }
            if (ChatONRejectMsgEditActivity.this.mSelectedMsg == null || ChatONRejectMsgEditActivity.this.mSelectedMsg.isEmpty()) {
                ChatONRejectMsgEditActivity.this.setEnabledSelectedButton(false);
            } else {
                ChatONRejectMsgEditActivity.this.setEnabledSelectedButton(true);
            }
            ChatONRejectMsgEditActivity.this.mCursorStartPos = ChatONRejectMsgEditActivity.this.mEditText.getSelectionStart();
            ChatONRejectMsgEditActivity.this.mCursorEndPos = ChatONRejectMsgEditActivity.this.mEditText.getSelectionEnd();
            super.handleMessage(msg);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (this.mChatonservice.getBackgroundThema() == 1) {
            setContentView(C0000R.layout.reject_call_with_msg_edit_black);
        } else {
            setContentView(C0000R.layout.reject_call_with_msg_edit);
        }
        mToast = Toast.makeText(this, "null", 0);
        Bundle extras = getIntent().getExtras();
        this.mSelectedIndex = extras.getInt(EXTRAS_KEY_INDEX);
        this.mSelectedMsg = extras.getString(EXTRAS_KEY_MESSAGE);
        this.mRejectMsgInfo = new RejectMessageInfo(extras.getBoolean(EXTRAS_KEY_SEND_MSG), extras.getString(EXTRAS_KEY_USERID), extras.getShort(EXTRAS_KEY_DEVICEID), extras.getString(EXTRAS_KEY_USERNAME), null);
        if (this.mSelectedMsg == null || this.mSelectedMsg.isEmpty()) {
            this.mCursorEndPos = 0;
            this.mCursorStartPos = 0;
        } else {
            this.mCursorStartPos = 0;
            this.mCursorEndPos = this.mSelectedMsg.length();
        }
        this.mRejectMsgMap = new LinkedHashMap<>();
        initView();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        logI("onNewIntent");
        Bundle extras = intent.getExtras();
        logI("issendmsg = " + extras.getBoolean(EXTRAS_KEY_SEND_MSG) + " userid = " + extras.getString(EXTRAS_KEY_USERID) + " deviceid = " + ((int) extras.getShort(EXTRAS_KEY_DEVICEID)) + " name = " + extras.getString(EXTRAS_KEY_USERNAME) + " index = " + extras.getInt(EXTRAS_KEY_INDEX) + " msg = " + extras.getString(EXTRAS_KEY_MESSAGE));
        this.mSelectedIndex = extras.getInt(EXTRAS_KEY_INDEX);
        this.mSelectedMsg = extras.getString(EXTRAS_KEY_MESSAGE);
        initActionBar();
        initView();
        if (extras.getBoolean(EXTRAS_KEY_SEND_MSG)) {
            if (this.mRejectMsgMap != null && !this.mRejectMsgMap.isEmpty() && this.mRejectMsgMap.containsKey(extras.getString(EXTRAS_KEY_USERID))) {
                this.mRejectMsgInfo = this.mRejectMsgMap.get(extras.getString(EXTRAS_KEY_USERID));
                String savedRejectMsg = this.mRejectMsgInfo.getRejectMsg();
                if (savedRejectMsg != null && !savedRejectMsg.isEmpty()) {
                    this.mEditText.setText(savedRejectMsg);
                    this.mCursorEndPos = savedRejectMsg.length();
                    this.mEditText.setSelection(this.mCursorEndPos);
                    setEnabledSelectedButton(true);
                    return;
                }
                return;
            }
            this.mRejectMsgInfo = new RejectMessageInfo(extras.getBoolean(EXTRAS_KEY_SEND_MSG), extras.getString(EXTRAS_KEY_USERID), extras.getShort(EXTRAS_KEY_DEVICEID), extras.getString(EXTRAS_KEY_USERNAME), null);
            return;
        }
        this.mSelectedIndex = extras.getInt(EXTRAS_KEY_INDEX);
        this.mSelectedMsg = extras.getString(EXTRAS_KEY_MESSAGE);
        if (this.mSelectedMsg == null || this.mSelectedMsg.isEmpty()) {
            this.mCursorEndPos = 0;
            this.mCursorStartPos = 0;
        } else {
            this.mCursorStartPos = 0;
            this.mCursorEndPos = this.mSelectedMsg.length();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        initView();
    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(C0000R.layout.action_bar_two_text_btn);
            actionBar.setDisplayOptions(16);
            this.mTitleText = (TextView) findViewById(C0000R.id.action_title);
            updateTitleText();
            this.mCancelButtonTxt = (TextView) findViewById(C0000R.id.action_btn_cancel);
            this.mCancelButtonTxt.setText(getResources().getString(C0000R.string.cancel));
            this.mDoneButtonTxt = (TextView) findViewById(C0000R.id.action_btn_done);
            this.mDoneButtonTxt.setText(getResources().getString(C0000R.string.done));
            this.mBtnBack = findViewById(C0000R.id.action_back);
            this.mBtnBack.setOnClickListener(this);
            this.mBtnCancel = findViewById(C0000R.id.action_btn1);
            this.mBtnCancel.setOnClickListener(this);
            this.mBtnDone = findViewById(C0000R.id.action_btn2);
            this.mBtnDone.setOnClickListener(this);
            setEnabledSelectedButton(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTitleText() {
        if (this.mRejectMsgInfo != null && this.mRejectMsgInfo.isSendMsg()) {
            this.mTitleText.setText(String.valueOf(this.mRejectMsgInfo.getUserName()) + " (" + getRemainText() + ")");
        } else {
            this.mTitleText.setText("(" + getRemainText() + ")");
        }
        this.mTitleText.setContentDescription(getString(C0000R.string.preference_3_1_summary));
    }

    private String getRemainText() {
        String resultStr = "0";
        if (this.mEditText != null) {
            resultStr = String.valueOf(calEditTextBytes());
        }
        return String.valueOf(resultStr) + getString(C0000R.string.reject_msg_edit_page_byte_info, new Object[]{Integer.valueOf(MAX_STRING_BYTE)});
    }

    private int calEditTextBytes() {
        return EditRejectTextByteLengthFilter.getByteLength(CHARACTER_SET, this.mEditText.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.mHandler = new EditBoxHandler();
        if (this.mChatonservice == null) {
            this.mChatonservice = ChatOnService.createService(MainApplication.mContext);
        }
        if (this.mChatonservice.getBackgroundThema() == 1) {
            setContentView(C0000R.layout.reject_call_with_msg_edit_black);
            getActionBar().getCustomView().setBackgroundResource(C0000R.color.tw_light_color001);
            this.mTitleText.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mCancelButtonTxt.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mDoneButtonTxt.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
        } else {
            setContentView(C0000R.layout.reject_call_with_msg_edit);
        }
        this.mEditText = (EditText) findViewById(C0000R.id.reject_call_with_msg_edit_text_view);
        this.mEditText.setFilters(new InputFilter[]{new EditRejectTextByteLengthFilter(MAX_STRING_BYTE, CHARACTER_SET, this.mHandler)});
        this.mEditText.requestFocus();
        if (this.mSelectedMsg == null || this.mSelectedMsg.isEmpty()) {
            this.mEditText.setText("");
            this.mEditText.setHint(C0000R.string.reject_msg_edit_page_edit_box_hint);
            setEnabledSelectedButton(false);
        } else {
            this.mEditText.setText(this.mSelectedMsg);
            this.mCursorEndPos = this.mSelectedMsg.length();
            this.mEditText.setSelection(this.mCursorEndPos);
            setEnabledSelectedButton(true);
        }
    }

    public void setEnabledSelectedButton(boolean flag) {
        this.mBtnDone.setEnabled(flag);
        this.mDoneButtonTxt.setEnabled(flag);
    }

    protected void hideSoftKeyboard(View view) {
        if (this.mgr == null) {
            this.mgr = (InputMethodManager) getSystemService("input_method");
        }
        this.mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
        this.mgr = null;
    }

    protected void showSoftKeyboard() {
        if (this.mgr == null) {
            this.mgr = (InputMethodManager) getSystemService("input_method");
        }
        this.mgr.showSoftInput(getCurrentFocus(), 1);
        this.mgr = null;
    }

    @Override // android.app.Activity
    protected void onPause() {
        stopEditBoxFiltering();
        if (!this.isSendingRejectMsgFinish) {
            if (this.mRejectMsgMap.containsKey(this.mRejectMsgInfo.getUserID())) {
                this.mRejectMsgMap.remove(this.mRejectMsgInfo.getUserID());
            }
            this.mRejectMsgInfo.setRejectMsg(this.mEditText.getText().toString());
            this.mRejectMsgMap.put(this.mRejectMsgInfo.getUserID(), this.mRejectMsgInfo);
            logI("cnt = " + this.mRejectMsgMap.size() + " msg = " + this.mEditText.getText().toString());
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        startEditBoxFiltering();
        if (this.mRejectMsgMap != null && !this.mRejectMsgMap.isEmpty() && this.mRejectMsgMap.containsKey(this.mRejectMsgInfo.getUserID())) {
            this.mRejectMsgMap.remove(this.mRejectMsgInfo.getUserID());
        }
        super.onResume();
    }

    private void stopEditBoxFiltering() {
        this.mEditBoxFilter = false;
    }

    private void startEditBoxFiltering() {
        this.mEditBoxFilter = true;
    }

    public void onClickDoneButton(View view) {
        stopEditBoxFiltering();
        String editMsg = this.mEditText.getText().toString();
        if (hasText(editMsg)) {
            if (this.mRejectMsgInfo.isSendMsg()) {
                if (this.mRejectMsgInfo.getUserID() != null && !this.mRejectMsgInfo.getUserID().isEmpty() && this.mRejectMsgInfo.getDeviceID() > 0) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().sendRejectMessage(this.mRejectMsgInfo.getUserID(), this.mRejectMsgInfo.getDeviceID(), editMsg, this.mRejectMsgInfo.getUserName());
                } else {
                    logI("Can not send reject message!!!!");
                }
                if (this.mRejectMsgMap != null && !this.mRejectMsgMap.isEmpty()) {
                    startNextRejectMsgEditActivity();
                    return;
                }
            } else {
                Intent data = new Intent();
                Bundle extras = new Bundle();
                extras.putInt(EXTRAS_KEY_INDEX, this.mSelectedIndex);
                extras.putString(EXTRAS_KEY_MESSAGE, this.mEditText.getText().toString());
                data.putExtras(extras);
                setResult(-1, data);
            }
            finish();
            return;
        }
        Toast.makeText(this, getString(C0000R.string.popup_reject_invalid_characters), 0).show();
    }

    public void startNextRejectMsgEditActivity() {
        this.isSendingRejectMsgFinish = true;
        Iterator<String> iter = this.mRejectMsgMap.keySet().iterator();
        if (iter.hasNext()) {
            String nextUserID = iter.next();
            Intent intent = new Intent(MainApplication.mContext, (Class<?>) ChatONRejectMsgEditActivity.class);
            intent.addFlags(805306368);
            Bundle extras = new Bundle();
            extras.putBoolean(EXTRAS_KEY_SEND_MSG, this.mRejectMsgMap.get(nextUserID).isSendMsg());
            extras.putString(EXTRAS_KEY_USERID, this.mRejectMsgMap.get(nextUserID).getUserID());
            extras.putShort(EXTRAS_KEY_DEVICEID, this.mRejectMsgMap.get(nextUserID).getDeviceID());
            extras.putString(EXTRAS_KEY_USERNAME, this.mRejectMsgMap.get(nextUserID).getUserName());
            intent.putExtras(extras);
            startActivity(intent);
        }
    }

    private boolean hasText(String str) {
        String checkingStr = str.replaceAll(String.valueOf('\n'), "").replaceAll(" ", "");
        if (!checkingStr.equals("")) {
            return true;
        }
        return false;
    }

    public void onClickBackPage() {
        stopEditBoxFiltering();
        if (!this.mRejectMsgInfo.isSendMsg()) {
            setResult(0, null);
        } else if (this.mRejectMsgMap != null && !this.mRejectMsgMap.isEmpty()) {
            startNextRejectMsgEditActivity();
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        stopEditBoxFiltering();
        if (!this.mRejectMsgInfo.isSendMsg()) {
            setResult(0, null);
        } else if (this.mRejectMsgMap != null && !this.mRejectMsgMap.isEmpty()) {
            startNextRejectMsgEditActivity();
            return;
        }
        super.onBackPressed();
    }

    public void onClickEditText(View view) {
        this.mCursorStartPos = this.mEditText.getSelectionStart();
        this.mCursorEndPos = this.mEditText.getSelectionEnd();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mBtnBack.getId()) {
            onClickBackPage();
        } else if (view.getId() == this.mBtnCancel.getId()) {
            onBackPressed();
        } else if (view.getId() == this.mBtnDone.getId()) {
            onClickDoneButton(view);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        this.mEditText = null;
        this.mBtnBack = null;
        this.mBtnCancel = null;
        this.mBtnDone = null;
        this.mHandler = null;
        if (this.mRejectMsgMap != null) {
            this.mRejectMsgMap.clear();
            this.mRejectMsgMap = null;
        }
        this.mgr = null;
        System.gc();
    }
}
