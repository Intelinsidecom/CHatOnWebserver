package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class SCameraVoiceCallerImageLayout extends VoiceCallerImageLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[SCameraVoiceCallerImageLayout]";
    private Button mBtnHold;
    private BuddyManagerInterface mBuddyManager;
    public TextView mCallStateInfo;
    private BuddyImageView mConfUserImage;
    private Destination mDestination;
    private LinearLayout mHoldLayout;
    private TextView mHoldText;
    private ImageView mIconBluetooth;
    private ViewGroup mIconLayout;
    private ViewGroup mMemberLayout;
    private VoiceCallActivity mParentActivity;
    public ImageView mRec;
    public TextView mRecText;
    private BuddyImageView mUserImage;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public SCameraVoiceCallerImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs, true);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.scamera_voice_call_caller_image, (ViewGroup) this, true);
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate(true);
        this.mMemberLayout = (ViewGroup) findViewById(C0000R.id.voice_call_member_layout);
        this.mUserImage = (BuddyImageView) findViewById(C0000R.id.voice_call_memberimage);
        this.mConfUserImage = (BuddyImageView) findViewById(C0000R.id.voice_call_memberimage_conf);
        this.mRec = (ImageView) findViewById(C0000R.id.call_icon_rec);
        this.mRecText = (TextView) findViewById(C0000R.id.voice_call_rec_text);
        this.mIconLayout = (ViewGroup) findViewById(C0000R.id.voice_call_icon_layout);
        this.mIconBluetooth = (ImageView) findViewById(C0000R.id.voice_call_bluetooth);
        this.mHoldLayout = (LinearLayout) findViewById(C0000R.id.voice_call_hold_layout);
        this.mBtnHold = (Button) findViewById(C0000R.id.voice_call_hold_btn);
        this.mHoldText = (TextView) findViewById(C0000R.id.voice_call_hold_text);
        this.mCallStateInfo = (TextView) findViewById(C0000R.id.voice_call_state_info);
        this.mMemberLayout.setOnClickListener(this);
        this.mBtnHold.setClickable(false);
        this.mBtnHold.setFocusable(false);
        this.mHoldLayout.setOnClickListener(this);
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    public void setUIState(boolean isOutGoingCall, int callState, int destType, int networkState, boolean isExistWaitMember) {
        if (CallState.isNotConnected(callState)) {
            this.mIconLayout.setVisibility(8);
            this.mCallStateInfo.setVisibility(0);
            return;
        }
        if (CallState.isConnected(callState)) {
            this.mIconLayout.setVisibility(0);
            this.mCallStateInfo.setVisibility(8);
            if (callState == 4) {
                this.mBtnHold.setBackgroundResource(C0000R.drawable.call_play_icon_selector);
                this.mBtnHold.setPadding(0, 20, 0, 12);
                this.mHoldText.setText(C0000R.string.call_btn_off_hold);
            } else {
                this.mBtnHold.setBackgroundResource(C0000R.drawable.call_hold_icon_selector);
                this.mBtnHold.setPadding(0, 20, 0, 12);
                this.mHoldText.setText(C0000R.string.call_btn_hold);
            }
            this.mHoldLayout.setEnabled(!isExistWaitMember);
            this.mHoldText.setEnabled(!isExistWaitMember);
            this.mBtnHold.setEnabled(isExistWaitMember ? false : true);
            return;
        }
        if (CallState.isDisconnected(callState)) {
            this.mIconLayout.setVisibility(8);
            this.mCallStateInfo.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void setMember(Destination destination, boolean isOutGoingCall) throws Throwable {
        logI("setMember()");
        this.mDestination = destination;
        setMemberInfo();
    }

    private void setMemberInfo() throws Throwable {
        switch (this.mDestination.getDestinationType()) {
            case 4:
                this.mUserImage.setVisibility(8);
                this.mConfUserImage.setVisibility(0);
                this.mConfUserImage.setImageViewMode(4);
                long groupID = this.mParentActivity.getGroupIDByUserInfo();
                if (groupID != 0) {
                    this.mConfUserImage.loadImage(groupID);
                    break;
                }
                break;
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void setCallerImage(long userno) throws Throwable {
        logE("setCallerImage~");
        this.mUserImage.setImageViewMode(0);
        if (this.mBuddyManager.getKindOfBuddy(userno) == 0) {
            this.mUserImage.loadImage(userno);
        } else {
            this.mUserImage.setBuddyGroupDefaultImage();
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mMemberLayout.getId()) {
            this.mParentActivity.closeOptionsMenu();
            return;
        }
        if (view.getId() == this.mHoldLayout.getId()) {
            this.mHoldLayout.setOnClickListener(null);
            Message msg = new Message();
            msg.what = 22;
            this.mParentActivity.sendHandlerMessage(msg, 3000L);
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            if (callInfo.getCallState() == 4) {
                this.mParentActivity.stopHold();
                this.mBtnHold.setBackgroundResource(C0000R.drawable.call_hold_icon_selector);
                this.mBtnHold.setPadding(0, 20, 0, 12);
                this.mHoldText.setText(C0000R.string.call_btn_hold);
                if (this.mParentActivity.mMuteOnBeforeHold) {
                    this.mParentActivity.setMuteEnable(true);
                    this.mParentActivity.startMute();
                    this.mParentActivity.setMuteBackGround(true);
                    Message msg2 = new Message();
                    msg2.what = 24;
                    this.mParentActivity.sendHandlerMessage(msg2, 0L);
                    return;
                }
                return;
            }
            if (callInfo.getCallState() == 5) {
                this.mParentActivity.stopMute();
                this.mParentActivity.setMuteBackGround(true);
                Message msg3 = new Message();
                msg3.what = 23;
                this.mParentActivity.sendHandlerMessage(msg3, 0L);
            }
            this.mParentActivity.setMuteEnable(false);
            this.mParentActivity.startHold();
            this.mBtnHold.setBackgroundResource(C0000R.drawable.call_play_icon_selector);
            this.mBtnHold.setPadding(0, 20, 0, 12);
            this.mHoldText.setText(C0000R.string.call_btn_off_hold);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void updateRecordStatement() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            this.mRec.setVisibility(0);
            this.mRecText.setVisibility(0);
        } else {
            this.mRec.setVisibility(8);
            this.mRecText.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void setBTIconStatus(boolean btOn) {
        if (btOn) {
            this.mIconBluetooth.setVisibility(0);
        } else {
            this.mIconBluetooth.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mUserImage != null) {
            this.mUserImage.dispose();
            this.mUserImage = null;
        }
        if (this.mConfUserImage != null) {
            this.mConfUserImage.dispose();
            this.mConfUserImage = null;
        }
        if (this.mIconBluetooth != null) {
            this.mIconBluetooth = null;
        }
        if (this.mRec != null) {
            this.mRec = null;
        }
        if (this.mRecText != null) {
            this.mRecText = null;
        }
        if (this.mMemberLayout != null) {
            this.mMemberLayout = null;
        }
        if (this.mBuddyManager != null) {
            this.mBuddyManager = null;
        }
        removeAllViewsInLayout();
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void removeImage() {
        this.mUserImage.setImageResource(C0000R.drawable.call_img_unknown);
    }

    @Override // com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout
    public void setHoldBtnClickable() {
        this.mHoldLayout.setOnClickListener(this);
    }
}
