package com.coolots.chaton.call.view.layout.voice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.controller.InviteViewController;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.coolots.chaton.call.view.listener.SmallerHitTargetTouchListener;
import com.coolots.chaton.common.controller.ChatOnResourceInterface;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ContentDescriptionStringMaker;
import com.coolots.chaton.common.util.ModelCreator;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VoiceCallBtnLayout extends RelativeLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallBtnLayout]";
    public static final int MSG_RECORD_SAVE_NOTI = 1002;
    private static final int RESULT_INVITE_BUDDY_DONE = 2;
    private final int SWITCH_VOICE_TO_VIDEO;
    private FrameLayout mBtnHangup;
    private ImageView mBtnHangupImg;
    private TextView mBtnHangupText;
    private FrameLayout mBtnHeadset;
    private ImageView mBtnHeadsetBottomImg;
    private ImageView mBtnHeadsetImg;
    private TextView mBtnHeadsetText;
    private FrameLayout mBtnInvite;
    private ImageView mBtnInviteImg;
    private TextView mBtnInviteText;
    private FrameLayout mBtnMute;
    private ImageView mBtnMuteBottomImg;
    private ImageView mBtnMuteImg;
    private TextView mBtnMuteText;
    private FrameLayout mBtnSpeaker;
    private ImageView mBtnSpeakerBottomImg;
    private ImageView mBtnSpeakerImg;
    private TextView mBtnSpeakerText;
    private FrameLayout mBtnSwitchCall;
    private ImageView mBtnSwitchCallImg;
    private TextView mBtnSwitchCallText;
    private Drawable mChangeImage;
    private Destination mDestinaion;
    private int mDeviceType;
    private Dialog mDialog;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private boolean mIsActiveShareScreen;
    private boolean mIsDialShowing;
    private ChatOnCallActivity mParentActivity;
    private ViewGroup mRootGroupView;
    private final SmallerHitTargetTouchListener mTouchListener;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VoiceCallBtnLayout(Context context) {
        super(context);
        this.mIsDialShowing = false;
        this.SWITCH_VOICE_TO_VIDEO = 1;
        this.mDeviceType = -1;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_btn, (ViewGroup) this, true);
        this.mBtnInvite = (FrameLayout) findViewById(C0000R.id.record_or_pause_layout);
        this.mBtnSwitchCall = (FrameLayout) findViewById(C0000R.id.keypad_btn_layout);
        this.mBtnHangup = (FrameLayout) findViewById(C0000R.id.end_call_btn_layout);
        this.mBtnSpeaker = (FrameLayout) findViewById(C0000R.id.speaker_btn_layout);
        this.mBtnHeadset = (FrameLayout) findViewById(C0000R.id.hold_btn_layout);
        this.mBtnMute = (FrameLayout) findViewById(C0000R.id.mute_btn_layout);
        this.mBtnInviteImg = (ImageView) findViewById(C0000R.id.record_or_pause_btn_image);
        this.mBtnSwitchCallImg = (ImageView) findViewById(C0000R.id.keypad_btn_image);
        this.mBtnHangupImg = (ImageView) findViewById(C0000R.id.end_call_btn_image);
        this.mBtnSpeakerImg = (ImageView) findViewById(C0000R.id.speaker_btn_image);
        this.mBtnHeadsetImg = (ImageView) findViewById(C0000R.id.hold_btn_image);
        this.mBtnMuteImg = (ImageView) findViewById(C0000R.id.mute_btn_image);
        this.mBtnInviteText = (TextView) findViewById(C0000R.id.record_or_pause_btn_text);
        this.mBtnSwitchCallText = (TextView) findViewById(C0000R.id.keypad_btn_text);
        this.mBtnHangupText = (TextView) findViewById(C0000R.id.end_call_btn_text);
        this.mBtnSpeakerText = (TextView) findViewById(C0000R.id.speaker_btn_text);
        this.mBtnHeadsetText = (TextView) findViewById(C0000R.id.hold_btn_text);
        this.mBtnMuteText = (TextView) findViewById(C0000R.id.mute_btn_text);
        this.mBtnSpeakerBottomImg = (ImageView) findViewById(C0000R.id.speaker_btn_bottom_image);
        this.mBtnHeadsetBottomImg = (ImageView) findViewById(C0000R.id.hold_btn_bottom_image);
        this.mBtnMuteBottomImg = (ImageView) findViewById(C0000R.id.mute_btn_bottom_image);
        this.mBtnInvite.setOnClickListener(this);
        this.mBtnSwitchCall.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnSpeaker.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHeadset.setOnClickListener(this);
        this.mBtnInvite.setOnTouchListener(this.mTouchListener);
        this.mBtnSwitchCall.setOnTouchListener(this.mTouchListener);
        this.mBtnHangup.setOnTouchListener(this.mTouchListener);
        this.mBtnSpeaker.setOnTouchListener(this.mTouchListener);
        this.mBtnMute.setOnTouchListener(this.mTouchListener);
        this.mBtnHeadset.setOnTouchListener(this.mTouchListener);
        this.mBtnInvite.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.invite_buddy, C0000R.string.talk_back_button));
        this.mBtnSwitchCall.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_switch_videocall, C0000R.string.talk_back_button));
        this.mBtnHangup.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_callend, C0000R.string.talk_back_button));
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public VoiceCallBtnLayout(Context context, ViewGroup r) {
        super(context);
        this.mIsDialShowing = false;
        this.SWITCH_VOICE_TO_VIDEO = 1;
        this.mDeviceType = -1;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        int childViewCount = r.getChildCount();
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_btn, r, true);
        this.mBtnInvite = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.record_or_pause_layout);
        this.mBtnSwitchCall = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.keypad_btn_layout);
        this.mBtnHangup = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.end_call_btn_layout);
        this.mBtnSpeaker = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.speaker_btn_layout);
        this.mBtnHeadset = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.hold_btn_layout);
        this.mBtnMute = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.mute_btn_layout);
        this.mBtnInviteImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.record_or_pause_btn_image);
        this.mBtnSwitchCallImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.keypad_btn_image);
        this.mBtnHangupImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.end_call_btn_image);
        this.mBtnSpeakerImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.speaker_btn_image);
        this.mBtnHeadsetImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.hold_btn_image);
        this.mBtnMuteImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.mute_btn_image);
        this.mBtnInviteText = (TextView) this.mRootGroupView.findViewById(C0000R.id.record_or_pause_btn_text);
        this.mBtnSwitchCallText = (TextView) this.mRootGroupView.findViewById(C0000R.id.keypad_btn_text);
        this.mBtnHangupText = (TextView) this.mRootGroupView.findViewById(C0000R.id.end_call_btn_text);
        this.mBtnSpeakerText = (TextView) this.mRootGroupView.findViewById(C0000R.id.speaker_btn_text);
        this.mBtnHeadsetText = (TextView) this.mRootGroupView.findViewById(C0000R.id.hold_btn_text);
        this.mBtnMuteText = (TextView) this.mRootGroupView.findViewById(C0000R.id.mute_btn_text);
        this.mBtnSpeakerBottomImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.speaker_btn_bottom_image);
        this.mBtnHeadsetBottomImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.hold_btn_bottom_image);
        this.mBtnMuteBottomImg = (ImageView) this.mRootGroupView.findViewById(C0000R.id.mute_btn_bottom_image);
        this.mBtnInvite.setOnClickListener(this);
        this.mBtnSwitchCall.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnSpeaker.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHeadset.setOnClickListener(this);
        this.mBtnInvite.setOnTouchListener(this.mTouchListener);
        this.mBtnSwitchCall.setOnTouchListener(this.mTouchListener);
        this.mBtnHangup.setOnTouchListener(this.mTouchListener);
        this.mBtnSpeaker.setOnTouchListener(this.mTouchListener);
        this.mBtnMute.setOnTouchListener(this.mTouchListener);
        this.mBtnHeadset.setOnTouchListener(this.mTouchListener);
        this.mBtnInvite.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.invite_buddy, C0000R.string.talk_back_button));
        this.mBtnSwitchCall.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_switch_videocall, C0000R.string.talk_back_button));
        this.mBtnHangup.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_callend, C0000R.string.talk_back_button));
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public VoiceCallBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsDialShowing = false;
        this.SWITCH_VOICE_TO_VIDEO = 1;
        this.mDeviceType = -1;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_btn, (ViewGroup) this, true);
    }

    public VoiceCallBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mIsDialShowing = false;
        this.SWITCH_VOICE_TO_VIDEO = 1;
        this.mDeviceType = -1;
        this.mTouchListener = new SmallerHitTargetTouchListener();
        this.mIsActiveShareScreen = false;
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean arg0, int arg1, int arg2, int arg3, int arg4) {
        logE("<<kyj>> VoiceCallBtnLayout() => onLayout");
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != 8) {
                int childLeft = getPaddingLeft();
                int childTop = getPaddingTop();
                child.layout(childLeft, childTop, child.getMeasuredWidth() + childLeft, child.getMeasuredHeight() + childTop);
            }
        }
        logE("<<kyj>> VoiceCallBtnLayout() => onLayout2");
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        logE("<<kyj>> VoiceCallBtnLayout() => onMeasure");
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
        logE("<<kyj>> VoiceCallBtnLayout() => onMeasure2");
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBtnInvite = (FrameLayout) findViewById(C0000R.id.record_or_pause_layout);
        this.mBtnSwitchCall = (FrameLayout) findViewById(C0000R.id.keypad_btn_layout);
        this.mBtnHangup = (FrameLayout) findViewById(C0000R.id.end_call_btn_layout);
        this.mBtnSpeaker = (FrameLayout) findViewById(C0000R.id.speaker_btn_layout);
        this.mBtnHeadset = (FrameLayout) findViewById(C0000R.id.hold_btn_layout);
        this.mBtnMute = (FrameLayout) findViewById(C0000R.id.mute_btn_layout);
        this.mBtnInviteImg = (ImageView) findViewById(C0000R.id.record_or_pause_btn_image);
        this.mBtnSwitchCallImg = (ImageView) findViewById(C0000R.id.keypad_btn_image);
        this.mBtnHangupImg = (ImageView) findViewById(C0000R.id.end_call_btn_image);
        this.mBtnSpeakerImg = (ImageView) findViewById(C0000R.id.speaker_btn_image);
        this.mBtnHeadsetImg = (ImageView) findViewById(C0000R.id.hold_btn_image);
        this.mBtnMuteImg = (ImageView) findViewById(C0000R.id.mute_btn_image);
        this.mBtnInviteText = (TextView) findViewById(C0000R.id.record_or_pause_btn_text);
        this.mBtnSwitchCallText = (TextView) findViewById(C0000R.id.keypad_btn_text);
        this.mBtnHangupText = (TextView) findViewById(C0000R.id.end_call_btn_text);
        this.mBtnSpeakerText = (TextView) findViewById(C0000R.id.speaker_btn_text);
        this.mBtnHeadsetText = (TextView) findViewById(C0000R.id.hold_btn_text);
        this.mBtnMuteText = (TextView) findViewById(C0000R.id.mute_btn_text);
        this.mBtnSpeakerBottomImg = (ImageView) findViewById(C0000R.id.speaker_btn_bottom_image);
        this.mBtnHeadsetBottomImg = (ImageView) findViewById(C0000R.id.hold_btn_bottom_image);
        this.mBtnMuteBottomImg = (ImageView) findViewById(C0000R.id.mute_btn_bottom_image);
        this.mBtnInvite.setOnClickListener(this);
        this.mBtnSwitchCall.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnSpeaker.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHeadset.setOnClickListener(this);
        this.mBtnInvite.setOnTouchListener(this.mTouchListener);
        this.mBtnSwitchCall.setOnTouchListener(this.mTouchListener);
        this.mBtnHangup.setOnTouchListener(this.mTouchListener);
        this.mBtnSpeaker.setOnTouchListener(this.mTouchListener);
        this.mBtnMute.setOnTouchListener(this.mTouchListener);
        this.mBtnHeadset.setOnTouchListener(this.mTouchListener);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
    }

    public void setParent(ChatOnCallActivity parent) {
        this.mParentActivity = parent;
        getScreenSize();
        this.mDeviceType = ModelCreator.checkDeviceModel(this.mDisplayWidth, this.mDisplayHeight);
    }

    private void getScreenSize() {
        this.mDisplayWidth = this.mParentActivity.getWindowManager().getDefaultDisplay().getWidth();
        this.mDisplayHeight = this.mParentActivity.getWindowManager().getDefaultDisplay().getHeight();
    }

    public void setCallBtnUpdate(int callState) {
        logI("setCallBtnUpdate()");
        if (this.mParentActivity.getAudioPathController() != null) {
            boolean isSpeakerOn = this.mParentActivity.getAudioPathController().isSpeakerON();
            updateSpeakerStatus(isSpeakerOn);
            boolean isBlueToothOn = this.mParentActivity.getAudioPathController().isBlueToothOn();
            setBTButtonStatus(isBlueToothOn);
            if (callState == 5) {
                updateMuteBackGround(true);
            } else if (this.mParentActivity.mMuteOnBeforeHold) {
                updateMuteBackGround(true);
                if (callState != 4) {
                    this.mParentActivity.startMute();
                }
            } else {
                updateMuteBackGround(false);
            }
            if (callState == 4) {
                this.mBtnMute.setEnabled(false);
            }
        }
    }

    public void setUIState(boolean isOutGoingCall, int callState, Destination destination, boolean isWaitMember) {
        this.mDestinaion = destination;
        int currentState = getCurrentUIState(isOutGoingCall, callState, destination, isWaitMember);
        switch (currentState) {
            case 1:
                this.mBtnSpeaker.setEnabled(true);
                this.mBtnSwitchCall.setEnabled(false);
                this.mBtnMute.setEnabled(false);
                this.mBtnInvite.setEnabled(false);
                break;
            case 2:
                this.mBtnMute.setEnabled(true);
                this.mBtnInvite.setEnabled(setInviteBuddyBtnEnable(isOutGoingCall, destination));
                this.mBtnHeadset.setEnabled(true);
                updateSwitchCallEnable(true);
                break;
            case 4:
                this.mBtnInvite.setEnabled(setInviteBuddyBtnEnable(isOutGoingCall, destination));
                this.mBtnMute.setEnabled(true);
                this.mBtnHeadset.setEnabled(true);
                this.mBtnSwitchCall.setEnabled(false);
                break;
            case 8:
                this.mBtnInvite.setEnabled(false);
                this.mBtnMute.setEnabled(false);
                this.mBtnHeadset.setEnabled(true);
                this.mBtnSwitchCall.setEnabled(false);
                break;
            case 16:
                this.mBtnMute.setEnabled(true);
                this.mBtnInvite.setEnabled(setInviteBuddyBtnEnable(isOutGoingCall, destination));
                this.mBtnHeadset.setEnabled(true);
                updateSwitchCallEnable(true);
                break;
            default:
                logE("<CIH> Error!");
                break;
        }
    }

    public void setIsActiveShareScreen(boolean flag) {
        this.mIsActiveShareScreen = flag;
    }

    public void setBtnClickable(boolean clickable) {
        this.mBtnHeadset.setClickable(clickable);
        this.mBtnInvite.setClickable(clickable);
    }

    private int getCurrentUIState(boolean isOutGoingCall, int callState, Destination destination, boolean isWaitMember) {
        if (CallState.isNotConnected(callState)) {
            return 1;
        }
        if (isWaitMember) {
            return 4;
        }
        if (callState == 4) {
            return 8;
        }
        if (callState == 5) {
            return 16;
        }
        return 2 == callState ? 2 : -1;
    }

    private boolean setInviteBuddyBtnEnable(boolean isOutGoingCall, Destination destination) {
        return InviteViewController.isEnableInviteButton(isOutGoingCall, destination);
    }

    public void updateBalance(String value, String unit) {
    }

    public void updateMuteBackGround(boolean muteOn) {
        if (muteOn) {
            if (getConfiguration() == 1) {
                this.mBtnMute.setSelected(true);
                this.mBtnMuteBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_on);
                this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_off, C0000R.string.talk_back_button));
                return;
            } else {
                this.mBtnMute.setSelected(true);
                this.mBtnMuteBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_on_h);
                this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_off, C0000R.string.talk_back_button));
                return;
            }
        }
        if (getConfiguration() == 1) {
            this.mBtnMute.setSelected(false);
            this.mBtnMuteBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_off);
            this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_on, C0000R.string.talk_back_button));
        } else {
            this.mBtnMute.setSelected(false);
            this.mBtnMuteBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_off_h);
            this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_on, C0000R.string.talk_back_button));
            this.mBtnMuteImg.setPressed(false);
        }
    }

    public void updateMuteEnable(boolean enable) {
        this.mBtnMute.setEnabled(enable);
    }

    public void updateSwitchCallEnable(boolean enable) {
        if (this.mParentActivity.isChangeToConference() || this.mParentActivity.isConference() || this.mParentActivity.mIsLowBattSwitchCall) {
            this.mBtnSwitchCall.setEnabled(false);
        } else {
            this.mBtnSwitchCall.setEnabled(enable);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        logI("onClick()");
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logE("WAIT: change to conference");
                return;
            }
            if (view.getId() == this.mBtnInvite.getId()) {
                logI("mBtnInvite mIsActiveShareScreen: " + this.mIsActiveShareScreen);
                if (this.mIsActiveShareScreen) {
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_to_invite_screenshare), 0).show();
                    return;
                }
                if (this.mParentActivity.getCallFunctionController().getCallSwitchingProcessing() > 0) {
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_invite_buddy_invalid_call_switching), 0).show();
                    return;
                }
                if (((VoiceCallActivity) this.mParentActivity).isHoldCall() || MainApplication.mPhoneManager.getPhoneStateMachine().isPlayHoldTone()) {
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_invite_buddy_invalid_call_hold), 0).show();
                    return;
                }
                this.mParentActivity.getCallFunctionController().setInviteProcessing(true);
                this.mParentActivity.sendSelectedListIntent(0, 2);
                Message msg = new Message();
                msg.what = CallActivity.MSG_ENTERING_PICK_BUDDY_ACTIVITY;
                this.mParentActivity.sendHandlerMessage(msg, 500L);
                this.mBtnInvite.setClickable(false);
                return;
            }
            if (view.getId() == this.mBtnSwitchCall.getId()) {
                logI("mBtnSwitchCall mIsActiveShareScreen: " + this.mIsActiveShareScreen);
                this.mParentActivity.getCallFunctionController().setCallSwitchingProcessing(1);
                if (this.mIsActiveShareScreen) {
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.unable_to_switch_screenshare), 0).show();
                    return;
                }
                if (this.mParentActivity.getCallFunctionController().isInviteProcessing()) {
                    Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.call_switch_call_reject), 0).show();
                    return;
                }
                int voiceMaxNum = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(false) - 1;
                int videoMaxNum = ((ChatOnConfigInterface) MainApplication.mConfig).getConferenceCallMaxPeopleNum(true) - 1;
                boolean isGroup = false;
                if (this.mDestinaion.getDestinationType() == 4 || this.mDestinaion.getDestinationType() == 5) {
                    isGroup = true;
                }
                if (voiceMaxNum == videoMaxNum) {
                    this.mBtnSwitchCall.setEnabled(false);
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().isPlayHoldTone()) {
                        this.mBtnSwitchCall.setEnabled(true);
                        Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.call_switch_on_hold), 0).show();
                        return;
                    }
                    if (isGroup && this.mParentActivity.getConferenceConnectCount() == 0) {
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_no_member);
                        return;
                    }
                    if (this.mParentActivity.getConferenceWaitCount() > 0) {
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_cannot_during_dialing);
                        return;
                    }
                    if (this.mParentActivity.isLowBattery()) {
                        this.mParentActivity.getCallFunctionController().setCallSwitchingProcessing(0);
                        Toast.makeText(getContext(), MainApplication.mContext.getResources().getText(((ChatOnResourceInterface) MainApplication.mResources).getStringLowBattery()), 1).show();
                        this.mParentActivity.mIsLowBattSwitchCall = true;
                        return;
                    }
                    if (this.mParentActivity.sendRequestConsent(1, 2)) {
                        this.mParentActivity.showCallConsentProcessingDialog(1, 2);
                        Message msg2 = new Message();
                        msg2.what = CallActivity.MSG_REQUESTING_SWITCH_TO_VIDEO_CALL;
                        this.mParentActivity.sendHandlerMessage(msg2, 500L);
                    } else {
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_cannot_start);
                    }
                    this.mParentActivity.mIsLowBattSwitchCall = false;
                    return;
                }
                if (voiceMaxNum > videoMaxNum) {
                    if (isGroup && this.mParentActivity.getConferenceConnectCount() > videoMaxNum) {
                        this.mParentActivity.showToast(C0000R.string.voice_call_only);
                        return;
                    }
                    this.mBtnSwitchCall.setEnabled(false);
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().isPlayHoldTone()) {
                        this.mBtnSwitchCall.setEnabled(true);
                        Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.call_switch_on_hold), 0).show();
                        return;
                    }
                    if (isGroup && this.mParentActivity.getConferenceConnectCount() == 0) {
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_no_member);
                        return;
                    }
                    if (this.mParentActivity.getConferenceWaitCount() > 0) {
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_cannot_during_dialing);
                        return;
                    }
                    if (this.mParentActivity.isLowBattery()) {
                        this.mParentActivity.getCallFunctionController().setCallSwitchingProcessing(0);
                        Toast.makeText(getContext(), MainApplication.mContext.getResources().getText(((ChatOnResourceInterface) MainApplication.mResources).getStringLowBattery()), 1).show();
                        return;
                    } else {
                        if (this.mParentActivity.sendRequestConsent(1, 2)) {
                            this.mParentActivity.showCallConsentProcessingDialog(1, 2);
                            Message msg3 = new Message();
                            msg3.what = CallActivity.MSG_REQUESTING_SWITCH_TO_VIDEO_CALL;
                            this.mParentActivity.sendHandlerMessage(msg3, 500L);
                            return;
                        }
                        this.mParentActivity.showToast(C0000R.string.call_switching_to_video_cannot_start);
                        return;
                    }
                }
                return;
            }
            if (view.getId() == this.mBtnHangup.getId()) {
                endCall();
                return;
            }
            if (view.getId() == this.mBtnSpeaker.getId()) {
                if (this.mParentActivity.getAudioPathController() != null) {
                    this.mParentActivity.getAudioPathController().onClickSpeakerButton();
                    return;
                }
                return;
            }
            if (view.getId() == this.mBtnMute.getId()) {
                if (this.mParentActivity.isActiveSTTTranslationTTS()) {
                    if (this.mBtnMute.isSelected()) {
                        logI("Mute button is unselected during translation");
                        this.mParentActivity.startRecognition();
                        updateMuteBackGround(false);
                        Message msg4 = new Message();
                        msg4.what = 24;
                        this.mParentActivity.sendHandlerMessage(msg4, 0L);
                        return;
                    }
                    logI("Mute button is selected during translation");
                    this.mParentActivity.stopRecognition();
                    updateMuteBackGround(true);
                    return;
                }
                CallStatusData callInfo = new CallStatusData();
                MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                if (callInfo.getCallState() == 5) {
                    this.mParentActivity.stopMute();
                    updateMuteBackGround(false);
                    Message msg5 = new Message();
                    msg5.what = 24;
                    this.mParentActivity.sendHandlerMessage(msg5, 0L);
                    return;
                }
                this.mParentActivity.startMute();
                updateMuteBackGround(true);
                return;
            }
            if (view.getId() == this.mBtnHeadset.getId()) {
                if (this.mParentActivity.getAudioPathController() == null) {
                    logI("AudioPathController is null");
                    return;
                }
                if (this.mParentActivity.getAudioPathController().isWatch() && !this.mParentActivity.getAudioPathController().isInstalledWatchApp()) {
                    logI("B model is connected now, but ChatONW is not installed. Bluetooth won't work");
                } else if (this.mParentActivity.getAudioPathController().onClickBlueToothButton()) {
                    this.mParentActivity.gotoBlueToothSettingPage();
                    this.mBtnHeadset.setClickable(false);
                }
            }
        }
    }

    public void endCall() {
        Message msg = new Message();
        msg.what = 11;
        this.mParentActivity.sendHandlerMessage(msg, 0L);
    }

    public boolean isKeypadOn() {
        return !this.mIsDialShowing;
    }

    public void dismiss3GDialog() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            try {
                this.mDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void updateSpeakerStatus(boolean speakerOn) {
        if (speakerOn) {
            this.mBtnSpeaker.setSelected(true);
            this.mBtnSpeakerBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_on);
            this.mBtnSpeaker.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.talk_back_spekerphone, C0000R.string.talk_back_turned_off));
        } else {
            this.mBtnSpeaker.setSelected(false);
            this.mBtnSpeakerBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_off);
            this.mBtnSpeaker.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.talk_back_spekerphone, C0000R.string.talk_back_turned_on));
        }
    }

    public void setBTButtonStatus(boolean btOn) {
        if (btOn) {
            this.mBtnHeadset.setSelected(true);
            this.mBtnHeadsetImg.setBackgroundResource(C0000R.drawable.call_headset_on_icon_selector);
            this.mBtnHeadsetBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_on);
            this.mBtnHeadset.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_switch_speaker, C0000R.string.talk_back_button));
            return;
        }
        this.mBtnHeadset.setSelected(false);
        this.mBtnHeadsetImg.setBackgroundResource(C0000R.drawable.call_headset_off_icon_selector);
        this.mBtnHeadsetBottomImg.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_off);
        this.mBtnHeadset.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_switch_headset, C0000R.string.talk_back_button));
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mBtnInviteImg != null) {
            this.mBtnInviteImg = null;
        }
        if (this.mBtnInviteText != null) {
            this.mBtnInviteText = null;
        }
        if (this.mBtnSwitchCall != null) {
            this.mBtnSwitchCall = null;
        }
        if (this.mBtnSwitchCallImg != null) {
            this.mBtnSwitchCallImg = null;
        }
        if (this.mBtnSwitchCallText != null) {
            this.mBtnSwitchCallText = null;
        }
        if (this.mBtnHangup != null) {
            this.mBtnHangup = null;
        }
        if (this.mBtnHangupImg != null) {
            this.mBtnHangupImg = null;
        }
        if (this.mBtnHangupText != null) {
            this.mBtnHangupText = null;
        }
        if (this.mBtnMute != null) {
            this.mBtnMute = null;
        }
        if (this.mBtnMuteImg != null) {
            this.mBtnMuteImg = null;
        }
        if (this.mBtnMuteText != null) {
            this.mBtnMuteText = null;
        }
        if (this.mBtnMuteBottomImg != null) {
            this.mBtnMuteBottomImg = null;
        }
        if (this.mBtnSpeaker != null) {
            this.mBtnSpeaker = null;
        }
        if (this.mBtnSpeakerImg != null) {
            this.mBtnSpeakerImg = null;
        }
        if (this.mBtnSpeakerText != null) {
            this.mBtnSpeakerText = null;
        }
        if (this.mBtnSpeakerBottomImg != null) {
            this.mBtnSpeakerBottomImg = null;
        }
        if (this.mBtnHeadset != null) {
            this.mBtnHeadset = null;
        }
        if (this.mBtnHeadsetImg != null) {
            this.mBtnHeadsetImg = null;
        }
        if (this.mBtnHeadsetText != null) {
            this.mBtnHeadsetText = null;
        }
        if (this.mBtnHeadsetBottomImg != null) {
            this.mBtnHeadsetBottomImg = null;
        }
        if (this.mChangeImage != null) {
            this.mChangeImage = null;
        }
        if (this.mDialog != null) {
            this.mDialog = null;
        }
        removeAllViewsInLayout();
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }
}
