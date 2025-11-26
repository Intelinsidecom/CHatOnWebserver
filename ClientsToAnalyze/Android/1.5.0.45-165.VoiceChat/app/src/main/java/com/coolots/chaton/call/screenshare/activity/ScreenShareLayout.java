package com.coolots.chaton.call.screenshare.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.coolots.chaton.call.screenshare.core.OverlayView;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public abstract class ScreenShareLayout extends RelativeLayout {
    private static final String CLASSNAME = "[ScreenShareLayout]";
    public LayoutInflater inflater;
    protected OverlayView.OnSendCommandData mOnSendCommandData;
    protected int mPauseMode;
    protected boolean mShow;
    protected int mUserID;
    OnButtonEvent onButtonEvent;

    public interface OnButtonEvent {
        void onClickButtonEvent(int i);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public ScreenShareLayout(Context context, int layoutResId) {
        super(context);
        this.mPauseMode = 0;
        this.inflater = null;
        logI("ScreenShareLayout contructor");
        if (this.inflater == null) {
            this.inflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        }
        this.inflater.inflate(layoutResId, this);
    }

    public void setOnButtonEvent(OnButtonEvent Event) {
        logI("setOnButtonEvent()");
        this.onButtonEvent = Event;
    }

    public void show() {
        logI("show()");
        setVisibility(0);
        setEnabled(true);
        this.mShow = true;
    }

    public void dismiss() {
        logI("dismiss()");
        setVisibility(8);
        setEnabled(false);
        this.mShow = false;
    }

    public void SetOnSendCommandData(OverlayView.OnSendCommandData onSendCmd) {
        this.mOnSendCommandData = onSendCmd;
    }

    public void OnRecveData(int command, byte[] data) {
    }

    public int getPauseMode() {
        return this.mPauseMode;
    }

    public boolean getIsShow() {
        return this.mShow;
    }
}
