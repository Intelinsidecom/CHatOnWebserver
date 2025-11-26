package com.coolots.chaton.call.screenshare.util;

import android.app.Service;
import android.content.Context;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class AlertView extends OverlayView implements DisposeInterface {
    private static final String CLASSNAME = "[AlertView]";
    private Button mAlertCancelBtn;
    private String mAlertMessage;
    private Button mAlertNeutralBtn;
    private Button mAlertOKBtn;
    private String mAlertTitle;
    private String mCancelBtnTitle;
    private boolean mCancelable;
    private LinearLayout mDialogViewLayout;
    private String mNeutralBtnTitle;
    private String mOKBtnTitle;
    private OnClickListener mOnClickListenerCancel;
    private OnClickListener mOnClickListenerNeutral;
    private OnClickListener mOnClickListenerOK;
    private boolean mShowing;
    private TextView mTextMessage;
    private TextView mTextTitle;

    public interface OnClickListener {
        void onClick(AlertView alertView, int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public AlertView(Service service) {
        super(service, C0000R.layout.screenshare_alert_view);
        this.mAlertTitle = null;
        this.mAlertMessage = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        this.mCancelable = true;
        this.mShowing = false;
    }

    public AlertView(Context context) {
        super(context, C0000R.layout.screenshare_alert_view);
        this.mAlertTitle = null;
        this.mAlertMessage = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        this.mCancelable = true;
        this.mShowing = false;
        this.mContext = context;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void setupLayoutParams() {
        this.layoutParams = new WindowManager.LayoutParams(-1, -1, 2021, 256, -3);
        this.layoutParams.gravity = getGravity();
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView, android.widget.RelativeLayout
    public int getGravity() {
        return 51;
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    protected void onInflateView() {
        logI("onInflateView() ");
        this.mDialogViewLayout = (LinearLayout) findViewById(C0000R.id.alret_dialog_view);
        LinearLayout alertBtns = (LinearLayout) findViewById(C0000R.id.alert_btns);
        this.mTextTitle = (TextView) findViewById(C0000R.id.alert_title);
        this.mTextMessage = (TextView) findViewById(C0000R.id.alert_msg);
        this.mAlertOKBtn = (Button) findViewById(C0000R.id.alert_btn1);
        this.mAlertNeutralBtn = (Button) findViewById(C0000R.id.alert_btn2);
        this.mAlertCancelBtn = (Button) findViewById(C0000R.id.alert_btn3);
        if (this.mAlertTitle == null) {
            this.mDialogViewLayout.removeView(this.mTextTitle);
        } else {
            this.mTextTitle.setText(this.mAlertTitle);
        }
        if (this.mAlertMessage == null) {
            this.mDialogViewLayout.removeView(this.mTextMessage);
        } else {
            this.mTextMessage.setText(this.mAlertMessage);
        }
        if (this.mOKBtnTitle == null && this.mCancelBtnTitle == null && this.mNeutralBtnTitle == null) {
            this.mDialogViewLayout.removeView(alertBtns);
            return;
        }
        if (this.mOKBtnTitle == null) {
            alertBtns.removeView(this.mAlertOKBtn);
        } else {
            this.mAlertOKBtn.setText(this.mOKBtnTitle);
            this.mAlertOKBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.AlertView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) throws Resources.NotFoundException {
                    AlertView.this.logI("mAlertOKBtn.setOnClickListener(new View.OnClickListener()");
                    AlertView.this.mOnClickListenerOK.onClick(AlertView.this, 1);
                    AlertView.this.dismiss();
                    AlertView.this.setVisibility(8);
                }
            });
        }
        if (this.mNeutralBtnTitle == null) {
            alertBtns.removeView(this.mAlertNeutralBtn);
        } else {
            this.mAlertNeutralBtn.setText(this.mNeutralBtnTitle);
            this.mAlertNeutralBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.AlertView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View v) throws Resources.NotFoundException {
                    AlertView.this.mOnClickListenerNeutral.onClick(AlertView.this, 2);
                    AlertView.this.dismiss();
                }
            });
        }
        if (this.mCancelBtnTitle == null) {
            alertBtns.removeView(this.mAlertCancelBtn);
        } else {
            this.mAlertCancelBtn.setText(this.mCancelBtnTitle);
            this.mAlertCancelBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.util.AlertView.3
                @Override // android.view.View.OnClickListener
                public void onClick(View v) throws Resources.NotFoundException {
                    AlertView.this.mOnClickListenerCancel.onClick(AlertView.this, 3);
                    AlertView.this.dismiss();
                }
            });
        }
        setCancelable(this.mCancelable);
    }

    public void setTitle(String title) {
        this.mAlertTitle = title;
    }

    public void setMessage(String message) {
        this.mAlertMessage = message;
    }

    public void setTitle(int resid) {
        this.mAlertTitle = getResources().getString(resid);
    }

    public void setMessage(int resid) {
        this.mAlertMessage = getResources().getString(resid);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void show() throws Resources.NotFoundException {
        logI("AlertView show ");
        this.mShowing = true;
        load();
        Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_in);
        animation.reset();
        this.mDialogViewLayout.clearAnimation();
        this.mDialogViewLayout.startAnimation(animation);
        setEnabled(true);
    }

    public void setPositiveButton(String title, OnClickListener onClickListener) {
        logI("setPositiveButton() ");
        this.mOKBtnTitle = title;
        this.mOnClickListenerOK = onClickListener;
    }

    public void setNeutralButton(String title, OnClickListener onClickListener) {
        this.mNeutralBtnTitle = title;
        this.mOnClickListenerNeutral = onClickListener;
    }

    public void setNegativeButton(String title, OnClickListener onClickListener) {
        this.mCancelBtnTitle = title;
        this.mOnClickListenerCancel = onClickListener;
    }

    public void setPositiveButton(int resid, OnClickListener onClickListener) {
        logI("setPositiveButton AlertView ok!!!");
        this.mOKBtnTitle = getResources().getString(resid);
        this.mOnClickListenerOK = onClickListener;
    }

    public void setNeutralButton(int resid, OnClickListener onClickListener) {
        logI("setPositiveButton AlertView ok!!!");
        this.mNeutralBtnTitle = getResources().getString(resid);
        this.mOnClickListenerNeutral = onClickListener;
    }

    public void setNegativeButton(int resid, OnClickListener onClickListener) {
        this.mCancelBtnTitle = getResources().getString(resid);
        this.mOnClickListenerCancel = onClickListener;
    }

    public void setCancelable(boolean cancelable) {
        this.mCancelable = cancelable;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) throws Resources.NotFoundException {
        logI("haeri===dispatchKeyEvent");
        if (event.getKeyCode() == 4 && event.getAction() == 0 && this.mCancelable) {
            dismiss();
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // com.coolots.chaton.call.screenshare.core.OverlayView
    public void dismiss() throws Resources.NotFoundException {
        if (this.mShowing) {
            setEnabled(false);
            Animation animation = AnimationUtils.loadAnimation(getContext(), C0000R.anim.screenshare_zoom_out);
            animation.reset();
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.screenshare.util.AlertView.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation arg0) {
                    AlertView.this.unload();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation arg0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation arg0) {
                }
            });
            this.mDialogViewLayout.clearAnimation();
            this.mDialogViewLayout.startAnimation(animation);
        }
        this.mShowing = false;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        this.mAlertTitle = null;
        this.mAlertMessage = null;
        this.mOKBtnTitle = null;
        this.mCancelBtnTitle = null;
        this.mNeutralBtnTitle = null;
        if (this.mTextTitle != null) {
            this.mTextTitle.removeCallbacks(null);
            this.mTextTitle = null;
        }
        if (this.mTextMessage != null) {
            this.mTextMessage.removeCallbacks(null);
            this.mTextMessage = null;
        }
        if (this.mAlertOKBtn != null) {
            this.mAlertOKBtn.removeCallbacks(null);
            this.mAlertOKBtn = null;
        }
        if (this.mAlertCancelBtn != null) {
            this.mAlertCancelBtn.removeCallbacks(null);
            this.mAlertCancelBtn = null;
        }
        if (this.mAlertNeutralBtn != null) {
            this.mAlertNeutralBtn.removeCallbacks(null);
            this.mAlertNeutralBtn = null;
        }
        if (this.mOnClickListenerOK != null) {
            this.mOnClickListenerOK = null;
        }
        if (this.mOnClickListenerCancel != null) {
            this.mOnClickListenerCancel = null;
        }
        if (this.mOnClickListenerNeutral != null) {
            this.mOnClickListenerNeutral = null;
        }
        if (this.mDialogViewLayout != null) {
            this.mDialogViewLayout.removeAllViewsInLayout();
            this.mDialogViewLayout = null;
        }
    }

    public void showWithoutAnimation() {
        logI("AlertView show ");
        this.mShowing = true;
        load();
        setEnabled(true);
    }
}
