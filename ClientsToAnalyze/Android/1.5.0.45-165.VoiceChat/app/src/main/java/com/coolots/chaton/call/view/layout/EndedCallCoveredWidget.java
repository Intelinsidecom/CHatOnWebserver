package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public abstract class EndedCallCoveredWidget extends RelativeLayout implements DisposeInterface {
    protected static final String CLASSNAME = "[EndCallCoveredLayout]";
    protected Chronometer mClearCoverEndedtime;
    protected TextView mClearCoverUserMessage;
    protected TextView mClearCoverUserName;
    protected Destination mDestination;
    protected boolean mIsVoiceCall;
    protected ChatOnCallActivity mParentActivity;
    protected ViewGroup mRootGroupView;

    public abstract void initialize(Destination destination, ChatOnCallActivity chatOnCallActivity);

    public abstract void setClearCoverActive(CallDisplayUserInfo callDisplayUserInfo);

    protected void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public EndedCallCoveredWidget(Context context, ViewGroup r, Destination destination, ChatOnCallActivity parentActivity) {
        super(context);
        this.mContext = context;
        this.mDestination = destination;
        this.mParentActivity = parentActivity;
    }

    public EndedCallCoveredWidget(Context context) {
        super(context);
        this.mContext = context;
    }

    public EndedCallCoveredWidget(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public EndedCallCoveredWidget(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    public void setCallType(boolean isVoiceCall) {
        this.mIsVoiceCall = isVoiceCall;
    }

    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        if (this.mClearCoverUserName != null) {
            this.mClearCoverUserName = null;
        }
        if (this.mClearCoverUserMessage != null) {
            this.mClearCoverUserMessage = null;
        }
        removeAllViewsInLayout();
    }

    protected int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
