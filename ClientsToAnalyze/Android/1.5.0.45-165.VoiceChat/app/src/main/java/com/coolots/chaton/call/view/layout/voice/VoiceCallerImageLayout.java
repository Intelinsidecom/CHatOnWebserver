package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
public class VoiceCallerImageLayout extends FrameLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallerImageLayout]";
    private ImageView mBtnHold;
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
    private ViewGroup mRootGroupView;
    private BuddyImageView mUserImage;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VoiceCallerImageLayout(Context context, ViewGroup r) {
        super(context);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_caller_image, r, true);
        this.mMemberLayout = (ViewGroup) this.mRootGroupView.findViewById(C0000R.id.voice_call_member_layout);
        this.mUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_call_memberimage);
        this.mConfUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_call_memberimage_conf);
        this.mRec = (ImageView) this.mRootGroupView.findViewById(C0000R.id.call_icon_rec);
        this.mRecText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_rec_text);
        this.mIconLayout = (ViewGroup) this.mRootGroupView.findViewById(C0000R.id.voice_call_icon_layout);
        this.mIconBluetooth = (ImageView) this.mRootGroupView.findViewById(C0000R.id.voice_call_bluetooth);
        this.mHoldLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.voice_call_hold_layout);
        this.mBtnHold = (ImageView) this.mRootGroupView.findViewById(C0000R.id.voice_call_hold_btn);
        this.mHoldText = (TextView) this.mRootGroupView.findViewById(C0000R.id.voice_call_hold_text);
        this.mMemberLayout.setOnClickListener(this);
        this.mBtnHold.setClickable(false);
        this.mBtnHold.setFocusable(false);
        this.mHoldLayout.setOnClickListener(this);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public VoiceCallerImageLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_caller_image, (ViewGroup) this, true);
    }

    public VoiceCallerImageLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        logE("<<kyj>> VoiceCallerImageLayout() => onFinishInflate");
        this.mMemberLayout = (ViewGroup) findViewById(C0000R.id.voice_call_member_layout);
        this.mUserImage = (BuddyImageView) findViewById(C0000R.id.voice_call_memberimage);
        this.mConfUserImage = (BuddyImageView) findViewById(C0000R.id.voice_call_memberimage_conf);
        this.mRec = (ImageView) findViewById(C0000R.id.call_icon_rec);
        this.mRecText = (TextView) findViewById(C0000R.id.voice_call_rec_text);
        this.mIconLayout = (ViewGroup) findViewById(C0000R.id.voice_call_icon_layout);
        this.mIconBluetooth = (ImageView) findViewById(C0000R.id.voice_call_bluetooth);
        this.mHoldLayout = (LinearLayout) findViewById(C0000R.id.voice_call_hold_layout);
        this.mBtnHold = (ImageView) findViewById(C0000R.id.voice_call_hold_btn);
        this.mHoldText = (TextView) findViewById(C0000R.id.voice_call_hold_text);
        this.mCallStateInfo = (TextView) findViewById(C0000R.id.voice_call_state_info);
        this.mMemberLayout.setOnClickListener(this);
        this.mBtnHold.setClickable(false);
        this.mBtnHold.setFocusable(false);
        this.mHoldLayout.setOnClickListener(this);
    }

    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        logE("<<kyj>> VoiceCallerImageLayout() => onLayout");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
            }
        }
        logE("<<kyj>> VoiceCallerImageLayout() => onLayout2");
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logE("<<kyj>> VoiceCallerImageLayout() => onMeasure");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                measureChild(child, widthMeasureSpec, heightMeasureSpec);
            }
        }
        int maxWidth = 0 + getPaddingLeft() + getPaddingRight();
        int maxHeight = 0 + getPaddingTop() + getPaddingBottom();
        Drawable drawable = getBackground();
        if (drawable != null) {
            maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
            maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
        }
        setMeasuredDimension(resolveSize(maxWidth, widthMeasureSpec), resolveSize(maxHeight, heightMeasureSpec));
        logE("<<kyj>> VoiceCallerImageLayout() => onMeasure2");
    }

    public void setUIState(boolean isOutGoingCall, int callState, int destType, int networkState, boolean isExistWaitMember, boolean isChangeToConference) {
        if (CallState.isNotConnected(callState)) {
            this.mIconLayout.setVisibility(8);
            return;
        }
        if (CallState.isConnected(callState)) {
            this.mIconLayout.setVisibility(0);
            if (callState == 4) {
                this.mBtnHold.setBackgroundResource(C0000R.drawable.call_play_icon_selector);
                this.mHoldText.setText(C0000R.string.call_btn_off_hold);
            } else {
                this.mBtnHold.setBackgroundResource(C0000R.drawable.call_hold_icon_selector);
                this.mHoldText.setText(C0000R.string.call_btn_hold);
            }
            setDisableHoldBtn(isChangeToConference);
            return;
        }
        if (CallState.isDisconnected(callState)) {
            this.mIconLayout.setVisibility(8);
        }
    }

    public void setHoldUI() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.getCallState() == 4) {
            this.mBtnHold.setBackgroundResource(C0000R.drawable.call_play_icon_selector);
            this.mHoldText.setText(C0000R.string.call_btn_off_hold);
        } else {
            this.mBtnHold.setBackgroundResource(C0000R.drawable.call_hold_icon_selector);
            this.mHoldText.setText(C0000R.string.call_btn_hold);
        }
    }

    public void displayHoldUI(boolean OnOff) {
        setHoldUI();
        if (OnOff) {
            this.mHoldLayout.setVisibility(0);
        } else {
            this.mHoldLayout.setVisibility(8);
        }
    }

    public void setMember(Destination destination, boolean isOutGoingCall) {
        logI("setMember()");
        this.mDestination = destination;
        setMemberInfo();
    }

    private void setMemberInfo() throws Throwable {
        switch (this.mDestination.getDestinationType()) {
            case 2:
                this.mUserImage.setVisibility(0);
                this.mConfUserImage.setVisibility(8);
                break;
            case 4:
            case 5:
                this.mUserImage.setVisibility(8);
                this.mConfUserImage.setVisibility(0);
                this.mConfUserImage.setImageViewMode(5);
                if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                    String groupName = this.mParentActivity.getDestination().getGroupName();
                    this.mConfUserImage.loadImage(groupName, true);
                    break;
                } else {
                    long groupID = this.mParentActivity.getGroupIDByUserInfo();
                    if (groupID != 0) {
                        this.mConfUserImage.loadImage(groupID);
                        break;
                    }
                }
                break;
        }
    }

    public void setCallerImage(long userno) throws Throwable {
        logI("setCallerImage~");
        this.mUserImage.setImageViewMode(0);
        if (this.mBuddyManager.getKindOfBuddy(userno) == 0) {
            this.mUserImage.loadImage(userno);
        } else {
            this.mUserImage.setBuddyGroupDefaultImage();
        }
    }

    public void setCallerImage(int callState, String userno) {
        logI("setCallerImage buddyID = " + userno);
        this.mUserImage.setImageViewMode(0);
        if (this.mBuddyManager.getKindOfBuddy(userno) == 0) {
            if (CallState.isNotConnected(callState)) {
                this.mUserImage.loadImage(userno, false);
                return;
            } else {
                this.mUserImage.loadImage(userno, true);
                return;
            }
        }
        this.mUserImage.setBuddyGroupDefaultImage();
    }

    public void onClick(View view) {
        logI("onClick()");
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
                this.mHoldText.setText(C0000R.string.call_btn_hold);
                this.mParentActivity.setChangeCallEnable(true);
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
            this.mParentActivity.setChangeCallEnable(false);
            this.mParentActivity.startHold();
            this.mBtnHold.setBackgroundResource(C0000R.drawable.call_play_icon_selector);
            this.mHoldText.setText(C0000R.string.call_btn_off_hold);
        }
    }

    public void updateRecordStatement() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            this.mRec.setVisibility(0);
            this.mRecText.setVisibility(0);
        } else {
            this.mRec.setVisibility(8);
            this.mRecText.setVisibility(8);
        }
    }

    public void setBTIconStatus(boolean btOn) {
        if (btOn) {
            this.mIconBluetooth.setVisibility(0);
        } else {
            this.mIconBluetooth.setVisibility(8);
        }
    }

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

    public void removeImage() {
        this.mUserImage.setImageResource(C0000R.drawable.call_image);
    }

    public void setHoldBtnClickable() {
        this.mHoldLayout.setOnClickListener(this);
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    public void setDisableHoldBtn(boolean isDisable) {
        if (isDisable) {
            this.mHoldLayout.setEnabled(false);
            this.mBtnHold.setEnabled(false);
            this.mBtnHold.setClickable(false);
            this.mBtnHold.setFocusable(false);
            this.mHoldText.setEnabled(false);
            return;
        }
        this.mHoldLayout.setEnabled(true);
        this.mBtnHold.setEnabled(true);
        this.mBtnHold.setClickable(true);
        this.mBtnHold.setFocusable(true);
        this.mHoldText.setEnabled(true);
    }
}
