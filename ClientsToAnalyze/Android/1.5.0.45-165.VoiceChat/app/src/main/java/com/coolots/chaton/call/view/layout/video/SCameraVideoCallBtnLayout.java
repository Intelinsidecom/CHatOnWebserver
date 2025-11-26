package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.LiveShareViewActivity;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Timer;

/* loaded from: classes.dex */
public class SCameraVideoCallBtnLayout extends VideoCallBtnLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[SCameraVideoCallBtnLayout]";
    private static final int RESULT_INVITE_BUDDY_DONE = 2;
    private Button mBtnHangup;
    private Button mBtnHideme;
    private Button mBtnInvitebuddies;
    private Button mBtnMute;
    private Button mBtnRecord;
    private Button mBtnShowme;
    private Timer mIgoreTimer;
    private boolean mIsHideMe;
    private boolean mIsMuteStatus;
    private boolean mIsOutgoing;
    private boolean mIsRecord;
    private ChatOnCallActivity mParentActivity;
    private VideoCallActivity mVideoCallActivity;

    /* renamed from: wm */
    public WindowManager f12wm;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public SCameraVideoCallBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs, true);
        this.mIsRecord = false;
        this.mIsOutgoing = false;
        this.mIsHideMe = false;
        this.mIsMuteStatus = false;
        this.f12wm = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.scamera_video_call_btn, (ViewGroup) this, true);
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    protected void setCameraBtn() {
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout, android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate(true);
        this.mBtnShowme = (Button) findViewById(C0000R.id.show_me_btn);
        this.mBtnInvitebuddies = (Button) findViewById(C0000R.id.invite_buddies_btn);
        this.mBtnMute = (Button) findViewById(C0000R.id.video_mute_btn);
        this.mBtnHangup = (Button) findViewById(C0000R.id.video_end_call_btn);
        this.mBtnHideme = (Button) findViewById(C0000R.id.video_hideme_btn);
        this.mBtnRecord = (Button) findViewById(C0000R.id.record_stop_btn);
        this.mBtnShowme.setOnClickListener(this);
        this.mBtnInvitebuddies.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnHideme.setOnClickListener(this);
        this.mBtnRecord.setOnClickListener(this);
    }

    public void setParent(ChatOnCallActivity parent, int deviceType) {
        this.mParentActivity = parent;
        this.mVideoCallActivity = (VideoCallActivity) parent;
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void setUIState(int callState, boolean isShareView, boolean isShareViewStartedByMe) {
        boolean showMeBtnEnable;
        boolean isHideMe = this.mIsHideMe;
        int currentState = getCurrentUIState(callState, isShareView, isShareViewStartedByMe, isHideMe);
        logE("<CIH> currentState = " + currentState);
        switch (currentState) {
            case 1:
            case 2:
                setShowMeBtn(false);
                setInviteBuddyChangeBtn(true, false);
                setHideMeBtn(true);
                setMuteBtn(false, callState);
                this.mIsOutgoing = true;
                break;
            case 4:
            case 32:
            case 128:
                setShowMeBtn(false);
                if (this.mParentActivity.isOutGoingCall()) {
                    setInviteBuddyChangeBtn(true, true);
                } else {
                    setInviteBuddyChangeBtn(true, false);
                }
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 8:
                if (!isHideMe) {
                    showMeBtnEnable = false;
                } else {
                    showMeBtnEnable = true;
                }
                setShowMeBtn(showMeBtnEnable);
                if (this.mParentActivity.isOutGoingCall()) {
                    if (isHideMe) {
                        setInviteBuddyChangeBtn(false, true);
                    } else {
                        setInviteBuddyChangeBtn(true, true);
                    }
                } else if (isHideMe) {
                    setInviteBuddyChangeBtn(false, false);
                } else {
                    setInviteBuddyChangeBtn(true, false);
                }
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 16:
                setShowMeBtn(true);
                setInviteBuddyChangeBtn(false, true);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 64:
                setShowMeBtn(true);
                if (this.mParentActivity.isOutGoingCall()) {
                    setInviteBuddyChangeBtn(true, true);
                } else {
                    setInviteBuddyChangeBtn(true, false);
                }
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 256:
                if (this.mParentActivity instanceof LiveShareViewActivity) {
                    setMuteBtn(true, callState);
                    break;
                } else if (this.mParentActivity instanceof VideoCallActivity) {
                    setShowMeBtn(false);
                    if (this.mParentActivity.isOutGoingCall()) {
                        setInviteBuddyChangeBtn(true, true);
                    } else {
                        setInviteBuddyChangeBtn(true, false);
                    }
                    setHideMeBtn(false);
                    setMuteBtn(true, callState);
                    break;
                }
                break;
            default:
                logE("<CIH> Error!");
                break;
        }
    }

    private int getCurrentUIState(int callState, boolean isShareView, boolean isShareViewStartedByMe, boolean isHideMe) {
        if (CallState.isNotConnected(callState)) {
            return !isHideMe ? 1 : 2;
        }
        if (isShareView && isShareViewStartedByMe && !isHideMe) {
            return 128;
        }
        if (isShareView && isShareViewStartedByMe && isHideMe) {
            return 64;
        }
        if (isShareView && !isShareViewStartedByMe) {
            return 256;
        }
        if (5 == callState) {
            return 8;
        }
        if (isHideMe) {
            return 16;
        }
        if (!isHideMe) {
            return 32;
        }
        if (2 == callState) {
            return 4;
        }
        return -1;
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void setShowMeBtn(boolean visibility) {
        if (visibility) {
            this.mBtnShowme.setVisibility(0);
            this.mBtnShowme.setEnabled(true);
        } else {
            this.mBtnShowme.setVisibility(8);
            this.mBtnShowme.setEnabled(false);
        }
    }

    private void setInviteBuddyChangeBtn(boolean visibility, boolean enable) {
        if (visibility) {
            this.mBtnInvitebuddies.setVisibility(0);
        } else {
            this.mBtnInvitebuddies.setVisibility(8);
        }
        if (enable) {
            this.mBtnInvitebuddies.setEnabled(true);
        } else {
            this.mBtnInvitebuddies.setEnabled(false);
        }
    }

    private void setHideMeBtn(boolean visibility) {
        if (visibility) {
            if (this.mIsHideMe) {
                if (this.mVideoCallActivity.isLandscapeMode()) {
                    this.mBtnHideme.setText(getResources().getString(C0000R.string.call_menu_show_me));
                }
                this.mBtnHideme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_show_me_selector, 0, 0);
            } else {
                if (this.mVideoCallActivity.isLandscapeMode()) {
                    this.mBtnHideme.setText(getResources().getString(C0000R.string.call_menu_hide_me));
                }
                this.mBtnHideme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_hide_me_selector, 0, 0);
            }
            this.mBtnHideme.setVisibility(0);
            this.mBtnHideme.setEnabled(true);
            return;
        }
        this.mBtnHideme.setVisibility(8);
        this.mBtnHideme.setEnabled(false);
    }

    private void setMuteBtn(boolean enable, int callState) {
        if (enable) {
            this.mBtnMute.setVisibility(0);
            this.mBtnMute.setEnabled(true);
            if (callState == 5) {
                this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_on_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_on);
                return;
            } else {
                this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_off);
                return;
            }
        }
        this.mBtnMute.setVisibility(8);
        this.mBtnMute.setEnabled(false);
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void updateBalance(String value) {
    }

    public void setMuteBtnUpdate(int callState) {
        if (callState == 5) {
            logE("<<YHT101>> setMoteBtnUpdate true");
            this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_on_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_on);
        } else {
            logE("<<YHT101>> setMoteBtnUpdate false");
            this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_off);
        }
    }

    public void setNativeMuteBtnStatus(boolean muteOn) {
        if (muteOn) {
            this.mParentActivity.startMute();
            this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_on);
        } else if (this.mIsMuteStatus) {
            this.mParentActivity.startMute();
            this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_on);
        } else {
            this.mParentActivity.stopMute();
            this.mBtnMute.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_mute_icon_selector, 0, C0000R.drawable.call_btn_focus_switch_off);
        }
    }

    public void onClickOptionMenuHideme(boolean toHideme) {
        if (toHideme) {
            setInviteBuddyChangeBtn(false, false);
            setShowMeBtn(true);
        } else {
            if (this.mParentActivity.isOutGoingCall()) {
                setInviteBuddyChangeBtn(true, true);
            } else {
                setInviteBuddyChangeBtn(true, false);
            }
            setShowMeBtn(false);
        }
    }

    public void setCameraBtnEnabled(boolean enable) {
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void setHideme(boolean isHideme) {
        this.mIsHideMe = isHideme;
    }

    public void setShowmeBtnToggle(boolean isShowme) {
        if (isShowme) {
            this.mBtnShowme.setText(getResources().getString(C0000R.string.call_menu_show_me));
            this.mBtnShowme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_show_me_selector, 0, 0);
        } else {
            this.mBtnShowme.setText(getResources().getString(C0000R.string.call_menu_hide_me));
            this.mBtnShowme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_hide_me_selector, 0, 0);
        }
    }

    public void setHidemeBtnToggle(boolean isHideme) {
        logE("isHideme = " + isHideme);
        if (isHideme) {
            if (isLandscapeMode()) {
                this.mBtnHideme.setText(getResources().getString(C0000R.string.call_menu_hide_me));
            }
            this.mBtnHideme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_show_me_selector, 0, 0);
        } else {
            if (isLandscapeMode()) {
                this.mBtnHideme.setText(getResources().getString(C0000R.string.call_menu_show_me));
            }
            this.mBtnHideme.setCompoundDrawablesWithIntrinsicBounds(0, C0000R.drawable.call_hide_me_selector, 0, 0);
        }
    }

    public boolean isLandscapeMode() {
        boolean isLandscape = false;
        if (this.f12wm == null) {
            this.f12wm = (WindowManager) this.mVideoCallActivity.getSystemService("window");
        }
        Display disp = this.f12wm.getDefaultDisplay();
        int rotation = disp.getRotation();
        logE("rotation = " + rotation);
        switch (rotation) {
            case 0:
            case 2:
                isLandscape = false;
                break;
            case 1:
            case 3:
                isLandscape = true;
                break;
        }
        logE("isLandscape = " + isLandscape);
        return isLandscape;
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void setRecordBtnStatus(boolean flag) {
        this.mIsRecord = flag;
        if (flag) {
            this.mBtnInvitebuddies.setVisibility(8);
            this.mBtnRecord.setVisibility(0);
        } else {
            this.mBtnInvitebuddies.setVisibility(0);
            this.mBtnRecord.setVisibility(8);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void setHangUpButtonToggle(boolean flag) {
        if (this.mBtnHangup != null) {
            this.mBtnHangup.setEnabled(flag);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout, android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logE("WAIT: change to conference");
                return;
            }
            if (view != null) {
                switch (view.getId()) {
                    case C0000R.id.show_me_btn /* 2131493165 */:
                        if (this.mParentActivity instanceof LiveShareViewActivity) {
                            setShowmeBtnToggle(this.mIsHideMe ? false : true);
                            if (this.mIsHideMe && this.mParentActivity != null) {
                                this.mParentActivity.setShowMe();
                                break;
                            } else if (!this.mIsHideMe && this.mParentActivity != null) {
                                this.mParentActivity.setHideMe();
                                break;
                            }
                        } else if (this.mParentActivity != null) {
                            this.mParentActivity.setShowMe();
                            break;
                        }
                        break;
                    case C0000R.id.invite_buddies_btn /* 2131493166 */:
                        logE("onClick: invite_buddies_btn");
                        this.mParentActivity.sendSelectedListIntent(1, 2);
                        break;
                    case C0000R.id.video_mute_btn /* 2131493167 */:
                        logE("onClick: video_mute_btn");
                        CallStatusData callInfo = new CallStatusData();
                        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                        int callState = callInfo.getCallState();
                        if (callState == 5) {
                            this.mParentActivity.stopMute();
                            this.mIsMuteStatus = false;
                        } else {
                            this.mParentActivity.startMute();
                            this.mIsMuteStatus = true;
                        }
                        setMuteBtn(true, callState);
                        break;
                    case C0000R.id.video_hideme_btn /* 2131493168 */:
                        logE("onClick: video_hideme_btn");
                        setHidemeBtnToggle(this.mIsHideMe);
                        if (this.mIsHideMe && this.mParentActivity != null) {
                            this.mParentActivity.setShowMe();
                            break;
                        } else if (!this.mIsHideMe && this.mParentActivity != null) {
                            this.mParentActivity.setHideMe();
                            break;
                        }
                        break;
                    case C0000R.id.record_stop_btn /* 2131493169 */:
                        logE("onClick: record_stop_btn");
                        if (this.mIsRecord) {
                            this.mBtnRecord.setVisibility(8);
                            this.mBtnInvitebuddies.setVisibility(0);
                            if (this.mParentActivity != null) {
                                this.mParentActivity.stopRecord();
                                break;
                            }
                        } else {
                            this.mBtnRecord.setVisibility(0);
                            this.mBtnInvitebuddies.setVisibility(8);
                            break;
                        }
                        break;
                    case C0000R.id.video_end_call_btn /* 2131493170 */:
                        logE("onClick: video_end_call_btn");
                        endCall();
                        break;
                }
                if (view.getId() != C0000R.id.video_end_call_btn) {
                    this.mParentActivity.closeOptionsMenu();
                }
            }
        }
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout
    public void endCall() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        Message msg = new Message();
        msg.what = 11;
        if (this.mParentActivity != null) {
            this.mParentActivity.sendHandlerMessage(msg, 0L);
        }
        if (!this.mIsOutgoing) {
            this.mBtnHangup.setEnabled(false);
        }
    }

    @Override // com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        this.f12wm = null;
        if (this.mBtnInvitebuddies != null) {
            this.mBtnInvitebuddies.removeCallbacks(null);
            this.mBtnInvitebuddies = null;
        }
        if (this.mBtnMute != null) {
            this.mBtnMute.removeCallbacks(null);
            this.mBtnMute = null;
        }
        if (this.mBtnHangup != null) {
            this.mBtnHangup.removeCallbacks(null);
            this.mBtnHangup = null;
        }
        if (this.mIgoreTimer != null) {
            this.mIgoreTimer.cancel();
            this.mIgoreTimer = null;
        }
        removeAllViewsInLayout();
    }
}
