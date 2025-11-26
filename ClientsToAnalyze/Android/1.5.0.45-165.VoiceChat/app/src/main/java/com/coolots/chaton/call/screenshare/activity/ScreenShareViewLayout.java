package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import com.coolots.chaton.C0000R;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class ScreenShareViewLayout extends ScreenShareLayout implements DisposeInterface {
    private static final String CLASSNAME = "[ScreenShareViewLayout]";
    View.OnClickListener mButtonClickListener;
    private Handler mHandler;
    private RelativeLayout mMainBtnLayout;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenShareViewLayout(Context context, int layoutResId) {
        super(context, layoutResId);
        this.mHandler = new Handler();
        this.mButtonClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ScreenShareViewLayout.this.onButtonEvent.onClickButtonEvent(v.getId());
            }
        };
        this.mPauseMode = 0;
        logI("ScreenShareViewLayout constructor");
        this.mMainBtnLayout = (RelativeLayout) findViewById(C0000R.id.share_btn_layout);
        RelativeLayout.LayoutParams thisLayoutParam = new RelativeLayout.LayoutParams(-2, -2);
        setLayoutParams(thisLayoutParam);
    }

    public void setPause(int mode) {
        this.mPauseMode = mode;
        if (mode == 1) {
            this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewLayout.2
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
        if (mode == 0) {
            this.mHandler.post(new Runnable() { // from class: com.coolots.chaton.call.screenshare.activity.ScreenShareViewLayout.3
                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }
    }

    public void setOtherPause(int mode) {
        if (mode == 1 || mode != 0) {
        }
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void show() {
        super.show();
    }

    @Override // com.coolots.chaton.call.screenshare.activity.ScreenShareLayout
    public void dismiss() {
        setVisibility(8);
        setEnabled(false);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mMainBtnLayout != null) {
            this.mMainBtnLayout.removeAllViewsInLayout();
            this.mMainBtnLayout = null;
        }
    }
}
