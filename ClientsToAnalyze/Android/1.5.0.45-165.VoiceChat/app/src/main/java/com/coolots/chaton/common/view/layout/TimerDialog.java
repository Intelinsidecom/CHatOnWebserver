package com.coolots.chaton.common.view.layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class TimerDialog implements DisposeInterface {
    private static final int DELAYED_DISMISS_DIALOG = 1;
    private AlertDialog.Builder mAlertDialog;
    private Context mContext;
    private Dialog mDialog;
    private String mMessage;
    private int mTime;
    private TimerDialogHandler mTimerDialogHandler;

    public TimerDialog(Context context) {
        this.mContext = context;
    }

    public void setData(String message, int time) {
        this.mMessage = message;
        this.mTime = time;
        initTimerDialog();
    }

    private void initTimerDialog() {
        this.mTimerDialogHandler = new TimerDialogHandler(this, null);
        this.mAlertDialog = new AlertDialog.Builder(this.mContext);
        this.mAlertDialog.setMessage(this.mMessage);
        this.mDialog = this.mAlertDialog.create();
    }

    public void show() {
        this.mDialog.show();
        this.mTimerDialogHandler.sendEmptyMessageDelayed(1, this.mTime);
    }

    public boolean isShowing() {
        return this.mDialog.isShowing();
    }

    private final class TimerDialogHandler extends Handler implements DisposeInterface {
        private boolean bDisposed;

        private TimerDialogHandler() {
            this.bDisposed = false;
        }

        /* synthetic */ TimerDialogHandler(TimerDialog timerDialog, TimerDialogHandler timerDialogHandler) {
            this();
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed && msg.what == 1) {
                TimerDialog.this.mDialog.dismiss();
            }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mMessage != null) {
            this.mMessage = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.mDialog != null) {
            this.mDialog = null;
        }
        if (this.mTimerDialogHandler != null) {
            this.mTimerDialogHandler.dispose();
            this.mTimerDialogHandler = null;
        }
        if (this.mAlertDialog != null) {
            this.mAlertDialog = null;
        }
    }
}
