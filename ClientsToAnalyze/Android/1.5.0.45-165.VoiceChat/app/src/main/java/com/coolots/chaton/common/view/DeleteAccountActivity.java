package com.coolots.chaton.common.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.join.ChatOnVJoinManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class DeleteAccountActivity extends Activity implements DisposeInterface {
    private ProgressDialog mDeleteAccountProgressDialog;
    private UIHandler uiHandler = new UIHandler(this, null);

    private class UIHandler extends Handler implements DisposeInterface {
        private boolean bDisposed;

        private UIHandler() {
            this.bDisposed = false;
        }

        /* synthetic */ UIHandler(DeleteAccountActivity deleteAccountActivity, UIHandler uIHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (this.bDisposed || msg.what != 1000) {
                return;
            }
            DeleteAccountActivity.this.dismissProgressDialog();
            Log.m2958e("DeleteAccountActivity <CIH> event occurred");
            DeleteAccountActivity.this.finish();
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0000R.layout.deleted_account);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        showProgressDialog();
        ChatOnVJoinManager joinManager = (ChatOnVJoinManager) MainApplication.mPhoneManager.getJoinManager();
        if (joinManager.isExistChatONVAccount()) {
            joinManager.deleteChatONVAccount();
        } else {
            joinManager.deleteAccountFromWeb();
        }
        this.uiHandler.sendEmptyMessageDelayed(1000, 500L);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        dispose();
        super.onDestroy();
        Log.m2963i("<CIH> kill process");
        Process.killProcess(Process.myPid());
    }

    private void showProgressDialog() {
        this.mDeleteAccountProgressDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
        this.mDeleteAccountProgressDialog.setMessage(getResources().getString(C0000R.string.deleted_account));
        this.mDeleteAccountProgressDialog.setIndeterminate(true);
        this.mDeleteAccountProgressDialog.setCancelable(true);
        this.mDeleteAccountProgressDialog.setCanceledOnTouchOutside(false);
        this.mDeleteAccountProgressDialog.setIndeterminateDrawable(getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
        this.mDeleteAccountProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        if (this.mDeleteAccountProgressDialog != null) {
            if (this.mDeleteAccountProgressDialog.isShowing()) {
                this.mDeleteAccountProgressDialog.dismiss();
            }
            this.mDeleteAccountProgressDialog = null;
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.uiHandler != null) {
            this.uiHandler.dispose();
            this.uiHandler = null;
        }
        if (this.mDeleteAccountProgressDialog != null) {
            this.mDeleteAccountProgressDialog.dismiss();
            this.mDeleteAccountProgressDialog = null;
        }
    }
}
