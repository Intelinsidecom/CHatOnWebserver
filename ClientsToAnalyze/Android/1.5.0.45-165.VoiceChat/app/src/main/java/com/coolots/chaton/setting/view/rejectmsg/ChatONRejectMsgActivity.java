package com.coolots.chaton.setting.view.rejectmsg;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.dialog.ContextDialogMenuBuilder;
import com.coolots.chaton.common.dialog.ContextDialogMenuInterface;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.common.view.layout.OptionMenuLayout;
import com.coolots.chaton.setting.controller.ChatONRejectMsgAdapter;
import com.coolots.chaton.setting.data.ChatONRejectMsgList;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONRejectMsgActivity extends Activity implements DisposeInterface, ContextDialogMenuInterface {
    private static final int ADD_RESULT = 2;
    private static final String CLASSNAME = "[ChatONRejectMsgActivity]";
    private static final int DELETE_RESULT = 3;
    private static final int DIALOG_DELETE = 2;
    private static final int DIALOG_EDIT_DELETE = 1;
    private static final int DIALOG_NONE = 0;
    private static final int EDIT_RESULT = 1;
    public static final int REJECT_MSG_MAX_CNT = 6;
    private RelativeLayout mActionbarLayout;
    private RelativeLayout mCreateMsgheadlayout;
    private ImageView mDeleteButtonImage;
    private LinearLayout mDeleteButtonLayout;
    private TextView mDeleteButtonText;
    private Dialog mDialog;
    private View mLine;
    private ListView mListView;
    private ChatONRejectMsgAdapter mMsgAdapter;
    private ChatONRejectMsgList mMsgList;
    private TextView mNoListInformView;
    private boolean mPageMoveFlag;
    private TextView mTitle;
    private Dialog mContextDialog = null;
    private final Object mLock = new Object();
    private int mDialogShow = 0;
    private int mDialogShowIndex = 0;
    public AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.1
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ChatONRejectMsgActivity.this.gotoEditPage(position, ChatONRejectMsgActivity.this.getSelectedRejectMsg(ChatONRejectMsgActivity.this.mMsgList, position), 1);
        }
    };
    public AdapterView.OnItemLongClickListener mItemLongClickListener = new AdapterView.OnItemLongClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.2
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            ChatONRejectMsgActivity.this.showPopupDialog(ChatONRejectMsgActivity.this.getSelectedRejectMsg(ChatONRejectMsgActivity.this.mMsgList, position), position);
            return true;
        }
    };

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(C0000R.layout.reject_call_with_msg);
        initActionBar();
        initView();
        this.mDialogShow = 0;
    }

    @Override // android.app.Activity
    protected void onResume() {
        logI("onResume++");
        super.onResume();
        deleteButtonEnableCheck();
        updateComponent();
        synchronized (this.mLock) {
            this.mPageMoveFlag = false;
        }
        if (this.mDialogShow == 1 && this.mDialogShowIndex > 0) {
            showPopupDialog(getSelectedRejectMsg(this.mMsgList, this.mDialogShowIndex - 1), this.mDialogShowIndex - 1);
        } else if (this.mDialogShow == 2 && this.mDialogShowIndex > 0) {
            showDeleteRejectMsg(this.mDialogShowIndex - 1);
        }
        logI("onResume--");
    }

    @Override // android.app.Activity
    protected void onPause() {
        logI("onPause+++");
        if (this.mDialog == null) {
            this.mDialogShow = 0;
            this.mDialogShowIndex = 0;
        } else {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        super.onPause();
        logI("onPause---");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        dispose();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(C0000R.menu.setting_rejectmsg_option, menu);
        OptionMenuLayout.setLayout(this);
        return super.onCreateOptionsMenu(menu);
    }

    private void initActionBar() {
        this.mTitle = (TextView) findViewById(C0000R.id.title_reject_message);
        this.mDeleteButtonLayout = (LinearLayout) findViewById(C0000R.id.reject_call_with_msg_delete_layout);
        this.mDeleteButtonImage = (ImageView) findViewById(C0000R.id.reject_call_with_msg_delete_item_button);
        this.mDeleteButtonText = (TextView) findViewById(C0000R.id.reject_call_with_msg_delete_item_text);
        this.mActionbarLayout = (RelativeLayout) findViewById(C0000R.id.reject_msg_actionbar);
        ChatOnService mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (mChatonservice.getBackgroundThema() == 1) {
            this.mActionbarLayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            this.mTitle.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
            this.mDeleteButtonText.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_dark));
        } else {
            this.mActionbarLayout.setBackgroundColor(getResources().getColor(C0000R.color.chaton_color_011_light));
            this.mTitle.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_light));
            this.mDeleteButtonText.setTextColor(getResources().getColor(C0000R.color.chaton_color_001_light));
        }
    }

    private void initView() {
        this.mNoListInformView = (TextView) findViewById(C0000R.id.reject_call_with_msg_no_messae_info);
        this.mCreateMsgheadlayout = (RelativeLayout) findViewById(C0000R.id.create_reject_message);
        this.mCreateMsgheadlayout.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (ChatONRejectMsgActivity.this.mMsgList.getCount() >= 6) {
                    ChatONRejectMsgActivity.this.showAlertMaximumDialog();
                } else {
                    ChatONRejectMsgActivity.this.gotoEditPage(2);
                }
            }
        });
        this.mMsgList = new ChatONRejectMsgList(((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg(), 6);
        this.mLine = findViewById(C0000R.id.reject_call_with_msg_line);
        LinearLayout linearlayout = (LinearLayout) findViewById(C0000R.id.reject_call_layout);
        FrameLayout listlayout = (FrameLayout) findViewById(C0000R.id.reject_call_With_msg_list_layout);
        ChatOnService mChatonservice = ChatOnService.createService(MainApplication.mContext);
        if (mChatonservice.getBackgroundThema() == 1) {
            linearlayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            this.mMsgAdapter = new ChatONRejectMsgAdapter(this, this.mMsgList, C0000R.layout.reject_call_with_msg_content_item_black, C0000R.id.setting_reject_call_with_msg_item_text, 0, null);
            this.mLine.setBackground(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
            listlayout.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            this.mNoListInformView.setBackgroundColor(getResources().getColor(C0000R.color.tw_light_color001));
            this.mNoListInformView.setTextColor(getResources().getColor(C0000R.color.chaton_color_dark_theme_1));
        } else {
            linearlayout.setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            this.mMsgAdapter = new ChatONRejectMsgAdapter(this, this.mMsgList, C0000R.layout.reject_call_with_msg_content_item, C0000R.id.setting_reject_call_with_msg_item_text, 0, null);
            this.mLine.setBackground(getResources().getDrawable(C0000R.drawable.list_divider));
            listlayout.setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            this.mNoListInformView.setBackgroundColor(getResources().getColor(C0000R.color.list_bg_normal));
            this.mNoListInformView.setTextColor(getResources().getColor(C0000R.color.tw_light_color001));
        }
        this.mListView = (ListView) findViewById(C0000R.id.reject_call_with_msg_list);
        this.mListView.setAdapter((ListAdapter) this.mMsgAdapter);
        this.mListView.setOnItemClickListener(this.mItemClickListener);
        this.mListView.setOnItemLongClickListener(this.mItemLongClickListener);
        if (mChatonservice.getBackgroundThema() == 1) {
            this.mListView.setSelector(C0000R.drawable.list_bg_selector_black);
            this.mListView.setDivider(getResources().getDrawable(C0000R.drawable.list_divider_black_h));
        } else {
            this.mListView.setSelector(C0000R.drawable.list_bg_selector);
            this.mListView.setDivider(getResources().getDrawable(C0000R.drawable.list_divider));
        }
        deleteButtonEnableCheck();
        updateComponent();
        if (getResources().getConfiguration().orientation == 2) {
            this.mDeleteButtonText.setVisibility(0);
        } else {
            this.mDeleteButtonText.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteButtonEnableCheck() {
        if (this.mMsgList.getCount() != 0) {
            this.mDeleteButtonLayout.setClickable(true);
            this.mDeleteButtonImage.setAlpha(255);
            this.mDeleteButtonImage.setEnabled(true);
            this.mDeleteButtonText.setEnabled(true);
            return;
        }
        this.mDeleteButtonLayout.setClickable(false);
        this.mDeleteButtonImage.setAlpha(30);
        this.mDeleteButtonImage.setEnabled(false);
        this.mDeleteButtonText.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComponent() {
        int count = this.mMsgList.getCount();
        String title = String.valueOf(getResources().getString(C0000R.string.notification_rejectMsgTitle)) + " (" + count + "/6)";
        this.mTitle.setText(title);
        if (count == 0) {
            this.mNoListInformView.setVisibility(0);
            this.mListView.setVisibility(8);
        } else {
            this.mNoListInformView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != -1) {
            this.mListView.setAdapter((ListAdapter) this.mMsgAdapter);
            this.mMsgAdapter.notifyDataSetChanged();
            deleteButtonEnableCheck();
            updateComponent();
            synchronized (this.mLock) {
                this.mPageMoveFlag = false;
            }
            return;
        }
        Bundle extras = data.getExtras();
        switch (requestCode) {
            case 1:
                int index = extras.getInt(ChatONRejectMsgEditActivity.EXTRAS_KEY_INDEX);
                String msg = extras.getString(ChatONRejectMsgEditActivity.EXTRAS_KEY_MESSAGE);
                logI("onActivityResult[EDIT_RESULT]: index: " + index + " msg: " + msg);
                if (msg == null || msg.isEmpty()) {
                    Toast.makeText(this, C0000R.string.reject_msg_edit_no_text, 0).show();
                    break;
                } else {
                    this.mMsgList.modifyMessage(index, msg);
                    break;
                }
                break;
            case 2:
                String msg2 = extras.getString(ChatONRejectMsgEditActivity.EXTRAS_KEY_MESSAGE);
                logI("onActivityResult[ADD_RESULT] msg: " + msg2);
                this.mMsgList.addMessage(0, msg2);
                deleteButtonEnableCheck();
                updateComponent();
                break;
            case 3:
                logI("onActivityResult[DELETE_RESULT]");
                List<Boolean> checkList = (List) extras.getSerializable(ChatONRejectMsgDeleteActivity.CHECK_LIST_KEY);
                if (checkList != null) {
                    for (int i = checkList.size() - 1; i >= 1; i--) {
                        if (checkList.get(i).booleanValue()) {
                            this.mMsgList.deleteMessage(i - 1);
                        }
                    }
                    break;
                }
                break;
        }
        this.mListView.setAdapter((ListAdapter) this.mMsgAdapter);
        this.mMsgAdapter.notifyDataSetChanged();
        deleteButtonEnableCheck();
        updateComponent();
        synchronized (this.mLock) {
            this.mPageMoveFlag = false;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(C0000R.layout.reject_call_with_msg);
        initActionBar();
        initView();
        if (this.mContextDialog != null && this.mContextDialog.isShowing()) {
            showPopupDialog(getSelectedRejectMsg(this.mMsgList, this.mDialogShowIndex - 1), this.mDialogShowIndex - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getSelectedRejectMsg(ChatONRejectMsgList list, int index) {
        List<String> defaultString = ((ChatOnResourceInterface) MainApplication.mResources).getDefaultRejectMsg();
        return list.getType(index) == 0 ? list.getMessage(index) : defaultString.get(list.getType(index) - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupDialog(String title, int index) {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        if (this.mContextDialog != null) {
            this.mContextDialog.dismiss();
            this.mContextDialog = null;
        }
        ContextDialogMenuBuilder.Builder contextDialogBuilder = new ContextDialogMenuBuilder.Builder(this, this);
        contextDialogBuilder.setMenuArray(C0000R.array.reject_msg_popup_edit_delete);
        contextDialogBuilder.setTitle(title);
        contextDialogBuilder.setRejectMsgIndex(index);
        this.mContextDialog = contextDialogBuilder.create();
        this.mContextDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.4
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
                if (82 == arg2.getKeyCode() && ChatONRejectMsgActivity.this.mContextDialog != null) {
                    ChatONRejectMsgActivity.this.contextDialogDismiss();
                    return false;
                }
                return false;
            }
        });
        this.mContextDialog.show();
        this.mDialogShow = 1;
        this.mDialogShowIndex = index + 1;
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void sendMsgFromDialog(int which, int index) {
        this.mDialogShow = 0;
        this.mDialogShowIndex = 0;
        switch (which) {
            case 0:
                gotoEditPage(index, getSelectedRejectMsg(this.mMsgList, index), 1);
                break;
            case 1:
                showDeleteRejectMsg(index);
                break;
        }
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void sendMsgFromDialog(int which) {
    }

    @Override // com.coolots.chaton.common.dialog.ContextDialogMenuInterface
    public void contextDialogDismiss() {
        if (this.mContextDialog != null) {
            this.mContextDialog.dismiss();
            if (this.mDialogShow != 2) {
                this.mDialogShow = 0;
                this.mDialogShowIndex = 0;
            }
        }
    }

    private void showDeleteRejectMsg(final int selectedItem) {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(C0000R.string.reject_msg_delete_popup_title);
        bld.setMessage(C0000R.string.reject_msg_delete_popup_note);
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int identification) {
                ChatONRejectMsgActivity.this.mMsgList.deleteMessage(selectedItem);
                ChatONRejectMsgActivity.this.mMsgAdapter.notifyDataSetChanged();
                ChatONRejectMsgActivity.this.deleteButtonEnableCheck();
                ChatONRejectMsgActivity.this.updateComponent();
                dialog.dismiss();
                ChatONRejectMsgActivity.this.mDialog = null;
                ChatONRejectMsgActivity.this.mDialogShow = 0;
                ChatONRejectMsgActivity.this.mDialogShowIndex = 0;
            }
        });
        bld.setNegativeButton(C0000R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int identification) {
                dialog.dismiss();
                ChatONRejectMsgActivity.this.mDialog = null;
                ChatONRejectMsgActivity.this.mDialogShow = 0;
                ChatONRejectMsgActivity.this.mDialogShowIndex = 0;
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss();
                ChatONRejectMsgActivity.this.mDialog = null;
                ChatONRejectMsgActivity.this.mDialogShow = 0;
                ChatONRejectMsgActivity.this.mDialogShowIndex = 0;
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
        this.mDialogShow = 2;
        this.mDialogShowIndex = selectedItem + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAlertMaximumDialog() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(C0000R.string.reject_msg_error_popup_title);
        bld.setMessage(getString(C0000R.string.reject_msg_error_popup_msg, new Object[]{6}));
        bld.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int identification) {
                dialog.dismiss();
                ChatONRejectMsgActivity.this.mDialog = null;
                ChatONRejectMsgActivity.this.mDialogShow = 0;
                ChatONRejectMsgActivity.this.mDialogShowIndex = 0;
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgActivity.9
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface arg0) {
                if (ChatONRejectMsgActivity.this.mDialog != null) {
                    ChatONRejectMsgActivity.this.mDialog.dismiss();
                    ChatONRejectMsgActivity.this.mDialog = null;
                }
            }
        });
        this.mDialog = bld.create();
        this.mDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoEditPage(int result) {
        synchronized (this.mLock) {
            if (!this.mPageMoveFlag) {
                this.mPageMoveFlag = true;
                this.mListView.setAdapter((ListAdapter) null);
                Intent intent = new Intent(MainApplication.mContext, (Class<?>) ChatONRejectMsgEditActivity.class);
                intent.addFlags(8388608);
                Bundle extras = new Bundle();
                extras.putInt(ChatONRejectMsgEditActivity.EXTRAS_KEY_INDEX, 0);
                extras.putInt(ChatONRejectMsgEditActivity.EXTRAS_KEY_COUNT, 0);
                extras.putString(ChatONRejectMsgEditActivity.EXTRAS_KEY_MESSAGE, null);
                intent.putExtras(extras);
                startActivityForResult(intent, result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoEditPage(int index, String msg, int result) {
        synchronized (this.mLock) {
            if (!this.mPageMoveFlag) {
                this.mPageMoveFlag = true;
                this.mListView.setAdapter((ListAdapter) null);
                Intent intent = new Intent(MainApplication.mContext, (Class<?>) ChatONRejectMsgEditActivity.class);
                intent.addFlags(8388608);
                Bundle extras = new Bundle();
                extras.putInt(ChatONRejectMsgEditActivity.EXTRAS_KEY_INDEX, index);
                extras.putInt(ChatONRejectMsgEditActivity.EXTRAS_KEY_COUNT, this.mMsgList.getCount());
                extras.putString(ChatONRejectMsgEditActivity.EXTRAS_KEY_MESSAGE, msg);
                intent.putExtras(extras);
                startActivityForResult(intent, result);
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        this.mDialogShow = 0;
        this.mDialogShowIndex = 0;
        super.onBackPressed();
    }

    public void onClickBackPage(View view) {
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        this.mDialogShow = 0;
        this.mDialogShowIndex = 0;
        finish();
    }

    public void onClickDeleteItem(View view) {
        synchronized (this.mLock) {
            if (!this.mPageMoveFlag) {
                this.mPageMoveFlag = true;
                this.mListView.setAdapter((ListAdapter) null);
                Intent intent = new Intent(MainApplication.mContext, (Class<?>) ChatONRejectMsgDeleteActivity.class);
                intent.addFlags(8388608);
                Bundle extras = new Bundle();
                intent.putExtras(extras);
                startActivityForResult(intent, 3);
            }
        }
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
        if (this.mListView != null) {
            this.mListView.removeAllViewsInLayout();
            this.mListView = null;
        }
        if (this.mNoListInformView != null) {
            this.mNoListInformView = null;
        }
        if (this.mDeleteButtonImage != null) {
            this.mDeleteButtonImage = null;
        }
        if (this.mDeleteButtonText != null) {
            this.mDeleteButtonText = null;
        }
        if (this.mTitle != null) {
            this.mTitle = null;
        }
        if (this.mDialog != null) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        if (this.mCreateMsgheadlayout != null) {
            this.mCreateMsgheadlayout = null;
        }
        System.gc();
    }
}
