package com.coolots.chaton.call.view.layout.voice;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.LinearLayout;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* loaded from: classes.dex */
public class VoiceCallMenuLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    public static final String CLASSNAME = "[VoiceCallMenuLayout]";
    private AnimationCallback mAnimationCallback;
    private Button mBtnConferenceCall;
    private Button mBtnSendFile;
    private Button mBtnSwitchHeadset;
    private Button mBtnSwitchVideoCall;
    private Destination mDestination;
    private VoiceCallMemberLayout mParentLayout;

    public interface AnimationCallback {
        void onHideMenuAnimationFinish();

        void onShowMenuAnimationFinish();
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public VoiceCallMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_menu, (ViewGroup) this, true);
    }

    public void setAnimationCallback(AnimationCallback callback) {
        this.mAnimationCallback = callback;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initLayout();
        if (AnimationUtils.loadAnimation(getContext(), C0000R.anim.show_menu) != null) {
            setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(getContext(), C0000R.anim.show_menu)));
            setLayoutAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.layout.voice.VoiceCallMenuLayout.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    VoiceCallMenuLayout.this.enableMenu(true);
                    if (VoiceCallMenuLayout.this.mAnimationCallback != null) {
                        VoiceCallMenuLayout.this.mAnimationCallback.onShowMenuAnimationFinish();
                    }
                    VoiceCallMenuLayout.this.mParentLayout.changeMenuButton(false);
                    VoiceCallMenuLayout.this.mParentLayout.setMenuOpen(true);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    VoiceCallMenuLayout.this.enableMenu(false);
                    VoiceCallMenuLayout.this.mParentLayout.setMenuBackgroudVisibility();
                }
            });
        }
    }

    private void initLayout() {
        this.mBtnSwitchVideoCall = (Button) findViewById(C0000R.id.menu_switch_video_call);
        this.mBtnSwitchHeadset = (Button) findViewById(C0000R.id.menu_switch_headset);
        this.mBtnSendFile = (Button) findViewById(C0000R.id.menu_send_file);
        this.mBtnConferenceCall = (Button) findViewById(C0000R.id.menu_conference_call);
        this.mBtnSwitchVideoCall.setOnClickListener(this);
        this.mBtnSwitchHeadset.setOnClickListener(this);
        this.mBtnSendFile.setOnClickListener(this);
        this.mBtnConferenceCall.setOnClickListener(this);
    }

    public void setParent(VoiceCallMemberLayout parent, int destType) {
        this.mParentLayout = parent;
        if (destType == 4 || destType == 5) {
            this.mBtnConferenceCall.setVisibility(0);
        }
    }

    public void showMenu() {
        Log.m2958e("<<YHT2>> [VoiceCallMenuLayout] showMenu!!");
        startLayoutAnimation();
        Log.m2958e("<<YHT2>> [VoiceCallMenuLayout] showMenu!! #2");
    }

    public void hideMenu() throws Resources.NotFoundException {
        Animation anim = AnimationUtils.loadAnimation(getContext(), C0000R.anim.hide_menu);
        if (anim != null) {
            anim.setAnimationListener(new Animation.AnimationListener() { // from class: com.coolots.chaton.call.view.layout.voice.VoiceCallMenuLayout.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    VoiceCallMenuLayout.this.enableMenu(true);
                    VoiceCallMenuLayout.this.setVisibility(8);
                    if (VoiceCallMenuLayout.this.mAnimationCallback != null) {
                        VoiceCallMenuLayout.this.mAnimationCallback.onHideMenuAnimationFinish();
                    }
                    VoiceCallMenuLayout.this.mParentLayout.changeMenuButton(true);
                    VoiceCallMenuLayout.this.mParentLayout.setMenuOpen(false);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    VoiceCallMenuLayout.this.enableMenu(false);
                    VoiceCallMenuLayout.this.mParentLayout.setMenuBackgroudVisibility();
                }
            });
            startAnimation(anim);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableMenu(boolean enabled) {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.getCallState() == 4) {
            this.mBtnSwitchVideoCall.setEnabled(false);
        } else {
            this.mBtnSwitchVideoCall.setEnabled(enabled);
        }
        if (CoolotsChatOn.mPhoneManager.getChatOnContactManager().isFriend(this.mDestination.getString())) {
            this.mBtnSendFile.setEnabled(enabled);
        } else {
            this.mBtnSendFile.setEnabled(false);
        }
        this.mBtnSwitchHeadset.setEnabled(enabled);
        this.mBtnConferenceCall.setEnabled(enabled);
    }

    public void setMember(Destination destination) {
        this.mDestination = destination;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.mBtnSwitchVideoCall.getId()) {
            if (this.mParentLayout != null) {
                this.mParentLayout.setVoiceOptionMenu(6);
            }
        } else if (view.getId() == this.mBtnSwitchHeadset.getId()) {
            if (this.mParentLayout != null) {
                this.mParentLayout.setVoiceOptionMenu(5);
            }
        } else if (view.getId() == this.mBtnSendFile.getId()) {
            if (this.mParentLayout != null) {
                this.mParentLayout.setVoiceOptionMenu(40);
            }
        } else if (view.getId() == this.mBtnConferenceCall.getId() && this.mParentLayout != null) {
            this.mParentLayout.setVoiceOptionMenu(12);
        }
    }

    public void setBTButtonStatus(boolean btOn) {
        if (btOn) {
            this.mBtnSwitchHeadset.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_video_option_bluetooth_off, 0, 0);
            this.mBtnSwitchHeadset.setText(C0000R.string.call_menu_switch_speaker);
        } else {
            this.mBtnSwitchHeadset.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_video_option_bluetooth, 0, 0);
            this.mBtnSwitchHeadset.setText(C0000R.string.call_menu_switch_headset);
        }
    }

    public void setBtButtonEnable(boolean headsetOn) {
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mBtnConferenceCall != null) {
            this.mBtnConferenceCall = null;
        }
        if (this.mBtnSendFile != null) {
            this.mBtnSendFile = null;
        }
        if (this.mBtnSwitchHeadset != null) {
            this.mBtnSwitchHeadset = null;
        }
        if (this.mBtnSwitchVideoCall != null) {
            this.mBtnSwitchVideoCall = null;
        }
    }
}
