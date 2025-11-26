package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.VoiceCallActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VoiceCallTranslatorMemberLayout extends FrameLayout implements DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallTranslatorMemberLayout]";
    private static final int TRANSLATOR_CHANGE_LANGUAGE_DIALOG = 999;
    private View.OnClickListener mButtonClickListener;
    private LinearLayout mHoldButton;
    private ImageView mHoldImageView;
    private boolean mHoldOnOff;
    private LinearLayout mLanguageButton;
    private ViewGroup mMemberLayout;
    private VoiceCallActivity mParentActivity;
    private ViewGroup mRootGroupView;
    private LinearLayout mTTSButton;
    private ImageView mTTSImageView;
    private boolean mTTSOnOff;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public VoiceCallTranslatorMemberLayout(Context context, ViewGroup r) {
        super(context);
        this.mHoldOnOff = false;
        this.mTTSOnOff = false;
        this.mButtonClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.VoiceCallTranslatorMemberLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (view.getId()) {
                    case C0000R.id.translator_tts /* 2131493546 */:
                        VoiceCallTranslatorMemberLayout.this.mTTSOnOff = !VoiceCallTranslatorMemberLayout.this.mTTSOnOff;
                        break;
                }
                VoiceCallTranslatorMemberLayout.this.setUI(view);
                VoiceCallTranslatorMemberLayout.this.setCommand(view);
            }
        };
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.voice_call_translator, r, true);
        this.mHoldButton = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.translator_hold);
        this.mTTSButton = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.translator_tts);
        this.mLanguageButton = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.translator_change_language);
        this.mHoldImageView = (ImageView) this.mRootGroupView.findViewById(C0000R.id.translator_image_hold);
        this.mTTSImageView = (ImageView) this.mRootGroupView.findViewById(C0000R.id.translator_image_tts);
        this.mHoldButton.setOnClickListener(this.mButtonClickListener);
        this.mTTSButton.setOnClickListener(this.mButtonClickListener);
        this.mLanguageButton.setOnClickListener(this.mButtonClickListener);
        initHold();
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
    }

    public void setParent(VoiceCallActivity parent) {
        this.mParentActivity = parent;
    }

    public ViewGroup getLayoutreference() {
        if (this.mRootGroupView != null) {
            return this.mRootGroupView;
        }
        return null;
    }

    public void initHold() {
        setHoldOnOffUI(getHoldState());
    }

    private boolean getHoldState() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        return callInfo.getCallState() == 4;
    }

    private void setTTSOnOffCommand() {
        if (this.mTTSOnOff) {
            this.mParentActivity.Start_BubbleTTSPlayer();
        } else {
            this.mParentActivity.End_BubbleTTSPlayer();
        }
    }

    private void setHoldOnOffCommand() {
        this.mHoldButton.setOnClickListener(null);
        Message msg = new Message();
        msg.what = 22;
        this.mParentActivity.sendHandlerMessage(msg, 3000L);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.getCallState() == 4) {
            this.mParentActivity.stopHold();
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCommand(View view) {
        switch (view.getId()) {
            case C0000R.id.translator_tts /* 2131493546 */:
                setTTSOnOffCommand();
                break;
            case C0000R.id.translator_change_language /* 2131493549 */:
                this.mParentActivity.showDialog(999);
                break;
            case C0000R.id.translator_hold /* 2131493634 */:
                setHoldOnOffCommand();
                break;
        }
    }

    private void setHoldOnOffUI() {
        setHoldOnOffUI(!getHoldState());
    }

    private void setHoldOnOffUI(boolean OnOff) {
        if (OnOff) {
            this.mHoldImageView.setBackgroundResource(C0000R.drawable.translator_hold_on_image_selector);
        } else {
            this.mHoldImageView.setBackgroundResource(C0000R.drawable.translator_hold_off_image_selector);
        }
    }

    private void setTTSOnOffUI() {
        if (this.mTTSOnOff) {
            this.mTTSImageView.setBackgroundResource(C0000R.drawable.translator_tts_on_image_selector);
        } else {
            this.mTTSImageView.setBackgroundResource(C0000R.drawable.translator_tts_off_image_selector);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUI(View view) {
        switch (view.getId()) {
            case C0000R.id.translator_tts /* 2131493546 */:
                setTTSOnOffUI();
                break;
            case C0000R.id.translator_hold /* 2131493634 */:
                setHoldOnOffUI();
                break;
        }
    }

    public void setHoldBtnClickable() {
        this.mHoldButton.setOnClickListener(this.mButtonClickListener);
    }

    private int getConfiguration() {
        return getResources().getConfiguration().orientation;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mHoldImageView != null) {
            this.mHoldImageView = null;
        }
        if (this.mTTSImageView != null) {
            this.mTTSImageView = null;
        }
        if (this.mHoldButton != null) {
            this.mHoldButton.removeAllViews();
        }
        if (this.mTTSButton != null) {
            this.mTTSButton.removeAllViews();
        }
        if (this.mLanguageButton != null) {
            this.mLanguageButton.removeAllViews();
        }
        removeAllViewsInLayout();
    }
}
