package com.sec.chaton.trunk;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.facebook.FacebookManager;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.widget.SMSProgressBar;

/* loaded from: classes.dex */
public class CommentFragment extends Fragment implements FacebookManager.OnResultListener {
    private static final int MAX_CHARACTER = 140;
    private static final int REQUEST_CODE_FACEBOOK_UPLOAD = 1;
    public static final int RESPONSE_CODE_CONTENT_DELETED = 1;
    private Activity attachedActivity;
    private FacebookManager facebookManager;
    private Handler handler = new Handler() { // from class: com.sec.chaton.trunk.CommentFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            HttpEntry httpEntry = (HttpEntry) message.obj;
            switch (message.what) {
                case TrunkMessageControl.METHOD_ADD_COMMENT /* 904 */:
                    ChatONLogWriter.m3508c("[TRUNK] Received METHOD_ADD_COMMENT", CommentFragment.this.getClass().getSimpleName());
                    if (CommentFragment.this.waitProgressDialog.isShowing()) {
                        CommentFragment.this.waitProgressDialog.dismiss();
                    }
                    if (httpEntry.m1951b() != HttpResultCode.SUCCESS) {
                        if (httpEntry.m1951b() == HttpResultCode.ERROR) {
                            if (httpEntry.m1957f() != 89411) {
                                new AlertDialog.Builder(CommentFragment.this.attachedActivity).setMessage(CommentFragment.this.getResources().getString(C0062R.string.setting_profile_update_status_failed)).setPositiveButton(CommentFragment.this.getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.CommentFragment.1.1
                                    @Override // android.content.DialogInterface.OnClickListener
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        CommentFragment.this.mTrunkControl.addComment(CommentFragment.this.mSessionId, CommentFragment.this.mContentId, CommentFragment.this.mEditView.getText().toString());
                                        ChatONLogWriter.m3508c("[TRUNK] Send, mSessionId: " + CommentFragment.this.mSessionId + "mContentId: " + CommentFragment.this.mContentId, CommentFragment.this.getClass().getSimpleName());
                                        if (CommentFragment.this.waitProgressDialog.isShowing()) {
                                            return;
                                        }
                                        CommentFragment.this.waitProgressDialog.show();
                                    }
                                }).setNegativeButton(CommentFragment.this.getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
                                break;
                            } else {
                                CommentFragment.this.showContentDeletedPopup();
                                break;
                            }
                        }
                    } else {
                        Toast.makeText(CommentFragment.this.attachedActivity, C0062R.string.facebook_post_completed, 1).show();
                        CommentFragment.this.attachedActivity.setResult(-1);
                        CommentFragment.this.attachedActivity.finish();
                        break;
                    }
                    break;
            }
        }
    };
    private Button mCancelBtn;
    private String mContentId;
    private Context mContext;
    private EditText mEditView;
    private String mFilePath;
    private boolean mIsShare;
    private Button mSendBtn;
    private String mSessionId;
    private TextView mTrunkCommentTitle;
    private TrunkMessageControl mTrunkControl;
    private ProgressDialog waitProgressDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void showContentDeletedPopup() {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(this.attachedActivity).setTitle((CharSequence) null).setMessage(C0062R.string.trunk_content_deleted).setPositiveButton(C0062R.string.dialog_ok, new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.CommentFragment.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                new TrunkDatabaseHelper(CommentFragment.this.attachedActivity).removeTrunkItem(CommentFragment.this.mContentId);
                CommentFragment.this.attachedActivity.setResult(1);
                CommentFragment.this.attachedActivity.finish();
            }
        }).create();
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.facebookManager.m2352a(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = GlobalApplication.m2387e();
        this.waitProgressDialog = (ProgressDialog) new SMSProgressBar(getActivity()).onCreate(C0062R.string.setting_webview_please_wait);
        this.waitProgressDialog.setCancelable(false);
        Intent intent = getActivity().getIntent();
        this.mIsShare = intent.getBooleanExtra("isShare", false);
        this.mSessionId = intent.getStringExtra("sessionId");
        this.mContentId = intent.getStringExtra("contentId");
        this.mFilePath = intent.getStringExtra("filePath");
        this.mTrunkControl = new TrunkMessageControl(this.mContext, this.handler);
        this.attachedActivity = getActivity();
        if (this.facebookManager == null) {
            this.facebookManager = new FacebookManager(this.attachedActivity, this);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChatONLogWriter.m3508c("[LIFE] onCreateView, Memory Address:" + this, getClass().getSimpleName());
        View viewInflate = layoutInflater.inflate(C0062R.layout.trunk_comment_fragment, viewGroup, false);
        if (this.mIsShare) {
            this.attachedActivity.setTitle(C0062R.string.trunk_btn_share);
        } else {
            this.attachedActivity.setTitle(C0062R.string.trunk_btn_comment);
        }
        this.mEditView = (EditText) viewInflate.findViewById(C0062R.id.trunkCommentEdit);
        this.mEditView.addTextChangedListener(new TextWatcher() { // from class: com.sec.chaton.trunk.CommentFragment.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (CommentFragment.this.mEditView.length() > 0) {
                    for (int i4 = 0; i4 < CommentFragment.this.mEditView.length(); i4++) {
                        if (CommentFragment.this.mEditView.getText().length() > 0) {
                            CommentFragment.this.mSendBtn.setEnabled(true);
                        } else {
                            CommentFragment.this.mSendBtn.setEnabled(false);
                        }
                    }
                }
                if (CommentFragment.this.mEditView.length() < 1) {
                    CommentFragment.this.mSendBtn.setEnabled(false);
                }
                if (CommentFragment.this.mEditView.length() >= CommentFragment.MAX_CHARACTER) {
                    Toast.makeText(CommentFragment.this.mContext, C0062R.string.setting_input_length_exceed, 1).show();
                }
            }
        });
        this.mSendBtn = (Button) viewInflate.findViewById(C0062R.id.trunkCommentSendBtn);
        this.mSendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.CommentFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommentFragment.this.mIsShare) {
                    CommentFragment.this.facebookManager.m2354a(1, BitmapFactory.decodeFile(CommentFragment.this.mFilePath), CommentFragment.this.mEditView.getText().toString());
                    return;
                }
                CommentFragment.this.mTrunkControl.addComment(CommentFragment.this.mSessionId, CommentFragment.this.mContentId, CommentFragment.this.mEditView.getText().toString());
                ChatONLogWriter.m3508c("[TRUNK] Send, mSessionId: " + CommentFragment.this.mSessionId + "mContentId: " + CommentFragment.this.mContentId, CommentFragment.this.getClass().getSimpleName());
                if (CommentFragment.this.waitProgressDialog.isShowing()) {
                    return;
                }
                CommentFragment.this.waitProgressDialog.show();
            }
        });
        this.mCancelBtn = (Button) viewInflate.findViewById(C0062R.id.trunkCommentCancelBtn);
        this.mCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.trunk.CommentFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentFragment.this.attachedActivity.setResult(0);
                CommentFragment.this.attachedActivity.finish();
            }
        });
        return viewInflate;
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onReady(int i, boolean z) {
        if (this.waitProgressDialog.isShowing()) {
            return;
        }
        this.waitProgressDialog.show();
    }

    @Override // com.sec.chaton.facebook.FacebookManager.OnResultListener
    public void onResult(int i, int i2, String str) {
        if (i2 == -1) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Success : " + (str != null ? str : ""), getClass().getSimpleName());
            if (this.waitProgressDialog.isShowing()) {
                this.waitProgressDialog.dismiss();
            }
            Toast.makeText(this.attachedActivity, C0062R.string.facebook_post_completed, 1).show();
            return;
        }
        if (i2 == 0) {
            ChatONLogWriter.m3506b("Facebook Request " + i + " Cancel", getClass().getSimpleName());
            return;
        }
        ChatONLogWriter.m3506b("Facebook Request " + i + " Error(" + i2 + ") : " + str, getClass().getSimpleName());
        if (this.waitProgressDialog.isShowing()) {
            this.waitProgressDialog.dismiss();
        }
        new AlertDialog.Builder(this.attachedActivity).setMessage(getResources().getString(C0062R.string.setting_profile_update_status_failed)).setPositiveButton(getResources().getString(C0062R.string.buddy_list_dialog_addbuddy_button_retry), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.trunk.CommentFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                CommentFragment.this.facebookManager.m2354a(1, BitmapFactory.decodeFile(CommentFragment.this.mFilePath), CommentFragment.this.mEditView.getText().toString());
            }
        }).setNegativeButton(getResources().getString(C0062R.string.dialog_cancel), (DialogInterface.OnClickListener) null).show();
    }
}
