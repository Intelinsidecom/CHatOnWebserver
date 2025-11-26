package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Locale;

/* loaded from: classes.dex */
public class VideoCallDrivingBtnLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VideoCallDrivingBtnLayout]";
    private LinearLayout mAnswerBtn;
    private TextView mAnswerText;
    private LinearLayout mCancelBtn;
    private LinearLayout mIncomingCallDrivingBtnLayout;
    private boolean mIsOutgoing;
    private LinearLayout mOutgoingCallDrivingBtnLayout;
    private ChatOnCallActivity mParentActivity;
    private LinearLayout mRejectBtn;
    private TextView mRejectText;
    public WindowManager windowManager;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VideoCallDrivingBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsOutgoing = false;
        this.windowManager = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_driving_btn, (ViewGroup) this, true);
    }

    public VideoCallDrivingBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mIsOutgoing = false;
        this.windowManager = null;
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mIncomingCallDrivingBtnLayout = (LinearLayout) findViewById(C0000R.id.video_call_driving_incoming_btn_layout);
        this.mOutgoingCallDrivingBtnLayout = (LinearLayout) findViewById(C0000R.id.video_call_driving_outgoing_btn_layout);
        this.mAnswerBtn = (LinearLayout) findViewById(C0000R.id.carkit_answer_frame_layout);
        this.mRejectBtn = (LinearLayout) findViewById(C0000R.id.carkit_reject_frame_layout);
        this.mCancelBtn = (LinearLayout) findViewById(C0000R.id.carkit_cancel_frame_layout);
        this.mAnswerText = (TextView) findViewById(C0000R.id.carkit_answer_text);
        this.mRejectText = (TextView) findViewById(C0000R.id.carkit_reject_text);
        this.mAnswerBtn.setOnClickListener(this);
        this.mRejectBtn.setOnClickListener(this);
        this.mCancelBtn.setOnClickListener(this);
    }

    private void setBtnTextAccordingToSVoice() throws Resources.NotFoundException {
        Locale systemLocale = MainApplication.mContext.getResources().getConfiguration().locale;
        Locale sVoiceLoc = this.mParentActivity.getSVoiceLocale();
        this.mParentActivity.changeLocale(sVoiceLoc);
        String strAnswer = getResources().getString(C0000R.string.button_to_answer);
        this.mAnswerText.setText(strAnswer);
        String strReject = getResources().getString(C0000R.string.call_swipe_left_message);
        this.mRejectText.setText(strReject);
        this.mParentActivity.changeLocale(systemLocale);
    }

    public void setCallMode(boolean isOutgoingCall) {
        if (isOutgoingCall) {
            this.mOutgoingCallDrivingBtnLayout.setVisibility(0);
            this.mIncomingCallDrivingBtnLayout.setVisibility(8);
        } else {
            this.mOutgoingCallDrivingBtnLayout.setVisibility(8);
            this.mIncomingCallDrivingBtnLayout.setVisibility(0);
        }
    }

    public void setParent(ChatOnCallActivity parent) throws Resources.NotFoundException {
        this.mParentActivity = parent;
        setBtnTextAccordingToSVoice();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        logI("onClick()");
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logI("WAIT: change to conference");
                return;
            }
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logI("WAIT: change to conference");
                return;
            }
            if (view.getId() == this.mAnswerBtn.getId()) {
                if (this.mParentActivity != null) {
                    Log.m2958e("AnswerBtn receiveCall()");
                    this.mParentActivity.receiveCall();
                    setVisibility(8);
                    dispose();
                    return;
                }
                return;
            }
            if (view.getId() == this.mRejectBtn.getId()) {
                if (this.mParentActivity != null) {
                    Log.m2958e("mRejectBtn denyCall()");
                    this.mParentActivity.denyCall();
                    return;
                }
                return;
            }
            if (view.getId() == this.mCancelBtn.getId()) {
                Log.m2958e("mCancelBtn CancelCall()");
                endCall();
            }
        }
    }

    public void endCall() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        Message msg = new Message();
        msg.what = 11;
        if (this.mParentActivity != null) {
            this.mParentActivity.sendHandlerMessage(msg, 0L);
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mAnswerBtn != null) {
            this.mAnswerBtn = null;
        }
        if (this.mRejectBtn != null) {
            this.mRejectBtn = null;
        }
        if (this.mCancelBtn != null) {
            this.mCancelBtn = null;
        }
        this.windowManager = null;
        removeAllViewsInLayout();
    }

    public int getStatusBarHeight() {
        Rect rectgle = new Rect();
        Window window = this.mParentActivity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectgle);
        return rectgle.top;
    }

    @Override // android.view.View
    public Display getDisplay() {
        if (this.windowManager == null) {
            this.windowManager = (WindowManager) this.mParentActivity.getSystemService("window");
        }
        return this.windowManager.getDefaultDisplay();
    }
}
