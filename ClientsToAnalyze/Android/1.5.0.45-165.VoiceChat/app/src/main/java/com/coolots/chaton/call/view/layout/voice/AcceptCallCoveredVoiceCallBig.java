package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class AcceptCallCoveredVoiceCallBig extends AcceptCallCoveredWidget implements View.OnClickListener, DisposeInterface, View.OnTouchListener {
    public static final String CLASSNAME = "[AcceptCallCoveredVoiceCallBig]";
    private BuddyManagerInterface mBuddyManager;
    private LinearLayout mCallInfoLayout;
    private View.OnClickListener mDuringCallCoverBtnClickListener;
    private Button mMuteBtn;
    private LinearLayout mOptionLayout;
    private TextView mOutgoingText;
    private Button mSpeakerBtn;
    private BuddyImageView mUserImage;

    public AcceptCallCoveredVoiceCallBig(Context context, ChatOnCallActivity parent, Destination destination, ViewGroup r) {
        super(context, parent, destination, r);
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        this.mDuringCallCoverBtnClickListener = new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredVoiceCallBig.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.getId() != AcceptCallCoveredVoiceCallBig.this.mSpeakerBtn.getId()) {
                    if (v.getId() == AcceptCallCoveredVoiceCallBig.this.mMuteBtn.getId()) {
                        if (AcceptCallCoveredVoiceCallBig.this.mParentActivity.isActiveSTTTranslationTTS()) {
                            if (AcceptCallCoveredVoiceCallBig.this.mMuteBtn.isSelected()) {
                                AcceptCallCoveredVoiceCallBig.this.logI("Mute button is unselected during translation");
                                AcceptCallCoveredVoiceCallBig.this.mParentActivity.startRecognition();
                                AcceptCallCoveredVoiceCallBig.this.mMuteBtn.setSelected(false);
                                Message msg = new Message();
                                msg.what = 24;
                                AcceptCallCoveredVoiceCallBig.this.mParentActivity.sendHandlerMessage(msg, 0L);
                                return;
                            }
                            AcceptCallCoveredVoiceCallBig.this.logI("Mute button is selected during translation");
                            AcceptCallCoveredVoiceCallBig.this.mParentActivity.stopRecognition();
                            AcceptCallCoveredVoiceCallBig.this.mMuteBtn.setSelected(true);
                            return;
                        }
                        CallStatusData callInfo = new CallStatusData();
                        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                        if (callInfo.getCallState() == 5) {
                            AcceptCallCoveredVoiceCallBig.this.mParentActivity.stopMute();
                            AcceptCallCoveredVoiceCallBig.this.mMuteBtn.setSelected(false);
                            Message msg2 = new Message();
                            msg2.what = 24;
                            AcceptCallCoveredVoiceCallBig.this.mParentActivity.sendHandlerMessage(msg2, 0L);
                            return;
                        }
                        AcceptCallCoveredVoiceCallBig.this.mParentActivity.startMute();
                        AcceptCallCoveredVoiceCallBig.this.mMuteBtn.setSelected(true);
                        return;
                    }
                    return;
                }
                if (AcceptCallCoveredVoiceCallBig.this.mParentActivity.getAudioPathController() != null) {
                    AcceptCallCoveredVoiceCallBig.this.mParentActivity.getAudioPathController().onClickSpeakerButton();
                }
            }
        };
        int childViewCount = r.getChildCount();
        LayoutInflater inflater = LayoutInflater.from(this.mContext);
        this.mRootGroupView = (ViewGroup) inflater.inflate(C0000R.layout.accept_voice_call_cover_big, r, true);
        this.mClearCoverEndCall = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_big_call_1);
        this.mClearCoverEndCallCircle = (ImageView) this.mRootGroupView.findViewById(C0000R.id.clear_reject_big_circle_1);
        this.mClearCoverEndCallCircle.setVisibility(4);
        this.mClearCoverEndCall.setOnTouchListener(this);
        this.mClearCoverUserName = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_cover_ui_name);
        this.mClearCoverUserMessage = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_accpet_big_cover_ui_message);
        this.mElapsedTime = (Chronometer) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_cover_ui_call_kind);
        this.mUserImage = (BuddyImageView) this.mRootGroupView.findViewById(C0000R.id.voice_ac_call_memberimage_covered);
        this.mCallInfoLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.clear_cover_accept_big_text_layout);
        this.mOutgoingText = (TextView) this.mRootGroupView.findViewById(C0000R.id.clear_accpet_big_cover_status_message);
        this.mOptionLayout = (LinearLayout) this.mRootGroupView.findViewById(C0000R.id.clear_accpet_big_cover_during_option_wdiget);
        this.mSpeakerBtn = (Button) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_cover_speaker);
        this.mMuteBtn = (Button) this.mRootGroupView.findViewById(C0000R.id.clear_accept_big_cover_mute);
        this.mClearEndCallLayout = (FrameLayout) this.mRootGroupView.findViewById(C0000R.id.clear_reject_circle_big_layout_1);
        this.mRedArrowCover = (ImageView) this.mRootGroupView.findViewById(C0000R.id.red_accept_arrow_big_cover);
        this.mRedArrowCover.setBackgroundResource(C0000R.anim.red_arrow_big_effect);
        AnimationDrawable redAnimation = (AnimationDrawable) this.mRedArrowCover.getBackground();
        redAnimation.start();
        this.mRootGroupView.getChildAt(childViewCount).setTag(String.valueOf(getClass().toString()) + getConfiguration());
        this.mSpeakerBtn.setOnClickListener(this.mDuringCallCoverBtnClickListener);
        this.mMuteBtn.setOnClickListener(this.mDuringCallCoverBtnClickListener);
        setMoveImage(C0000R.drawable.clear_accept_circle_big_01, C0000R.drawable.clear_reject_circle_big_01);
        setTouchImage(C0000R.drawable.clear_accept_circle_drag, C0000R.drawable.clear_reject_circle_drag);
        setTouchId(C0000R.id.clear_reject_big_call_1);
    }

    private void setCoveredStatusBarColor(boolean isConnected) {
        if (isConnected) {
            this.mCallInfoLayout.setBackgroundResource(C0000R.color.chaton_covered_status_bar_calling_color);
        } else {
            this.mCallInfoLayout.setBackgroundResource(C0000R.color.chaton_covered_status_bar_during_call_color);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget
    public void setClearCoverActive(CallDisplayUserInfo calluserInfo, int callstate) throws IOException {
        logI("setClearCoverActive()");
        super.setClearCoverActive(calluserInfo, callstate);
        this.mClearCoverUserMessage.setText(calluserInfo.userStateMsg);
        setCallerImage(callstate);
        if (callstate != 3) {
            if (callstate == 1) {
                setCoveredStatusBarColor(true);
            } else {
                setCoveredStatusBarColor(false);
            }
            if (CallState.isConnected(callstate)) {
                this.mOptionLayout.setVisibility(0);
                this.mOutgoingText.setVisibility(8);
                this.mElapsedTime.setVisibility(0);
            } else {
                this.mOptionLayout.setVisibility(8);
                this.mOutgoingText.setVisibility(0);
                this.mElapsedTime.setVisibility(8);
            }
        }
    }

    private void setCallerImage(int callstate) throws IOException {
        if (this.mDestination != null) {
            String buddyID = this.mDestination.getString();
            logI("setCallerImage buddyID = " + buddyID);
            if (this.mParentActivity.isConference()) {
                this.mUserImage.setImageViewMode(4);
            } else {
                this.mUserImage.setImageViewMode(0);
            }
            if (this.mBuddyManager.getKindOfBuddy(buddyID) == 0) {
                if (callstate != 3) {
                    this.mUserImage.loadImageForCover(buddyID, true);
                }
            } else if (callstate != 3) {
                this.mUserImage.setBuddyGroupDefaultImageForCover(true);
            }
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget
    public void setUpdateSpeakerBtnCover(boolean useSpeaker) {
        this.mSpeakerBtn.setSelected(useSpeaker);
    }

    @Override // com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget
    public void setUpdateDuringCallCoverBtn() {
        if (this.mParentActivity.isActiveSTTTranslationTTS()) {
            if (this.mMuteBtn.isSelected()) {
                logI("Mute button is unselected during translation");
                this.mMuteBtn.setSelected(true);
                return;
            } else {
                logI("Mute button is selected during translation");
                this.mMuteBtn.setSelected(false);
                return;
            }
        }
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.getCallState() == 5) {
            this.mMuteBtn.setSelected(true);
        } else {
            this.mMuteBtn.setSelected(false);
        }
        if (this.mParentActivity.getAudioPathController() != null) {
            setUpdateSpeakerBtnCover(this.mParentActivity.getAudioPathController().isSpeakerON());
        }
    }

    @Override // com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mUserImage != null) {
            this.mUserImage.dispose();
            this.mUserImage = null;
        }
        removeAllViewsInLayout();
    }
}
