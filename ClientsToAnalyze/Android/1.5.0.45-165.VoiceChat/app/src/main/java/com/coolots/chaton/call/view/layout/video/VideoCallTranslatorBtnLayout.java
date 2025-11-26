package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.call.view.layout.TranslatorSlidingDrawer;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class VideoCallTranslatorBtnLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VideoCallBtnLayout]";
    private static final long IGNORE_TIME_OUT_SEC = 1600;
    private static final int SWITCH_CAMERA = 1;
    private static final int SWITCH_CAMERA_SET_BTN = 2;
    private static final int SWITCH_CAMERA_START_FADE_OUT = 3;
    private static final int TRANSLATOR_CHANGE_LANGUAGE_DIALOG = 999;
    private FrameLayout mBtnCamera;
    private FrameLayout mBtnHangup;
    private FrameLayout mBtnHideme;
    private ImageView mBtnHidemeCenterImage;
    private FrameLayout mBtnMute;
    private ImageView mBtnMuteBottomImage;
    private ImageView mBtnMuteCenterImage;
    private FrameLayout mBtnRecord;
    private FrameLayout mBtnShowme;
    private FrameLayout mBtnTranslatorChangeLanguage;
    private FrameLayout mBtnTranslatorTTSOff;
    private FrameLayout mBtnTranslatorTTSOn;
    private CameraSwitchHandler mCameraSwitchHandler;
    private Timer mIgoreTimer;
    private boolean mIsHideMe;
    private boolean mIsMuteStatus;
    private boolean mIsOutgoing;
    private boolean mIsRecord;
    private boolean mOpenTranslatorMsg;
    private VideoCallActivity mParentActivity;
    private Button mTranslatorHandle;
    private TranslatorSlidingDrawer mTranslatorSlidingDrawer;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private class CameraSwitchHandler extends Handler implements DisposeInterface {
        private boolean isDispose;

        private CameraSwitchHandler() {
            this.isDispose = false;
        }

        /* synthetic */ CameraSwitchHandler(VideoCallTranslatorBtnLayout videoCallTranslatorBtnLayout, CameraSwitchHandler cameraSwitchHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) throws Resources.NotFoundException {
            if (!this.isDispose) {
                switch (msg.what) {
                    case 1:
                        SECConfig.switchCamera();
                        VideoCallTranslatorBtnLayout.this.mCameraSwitchHandler.sendEmptyMessageDelayed(3, 300L);
                        break;
                    case 2:
                        VideoCallTranslatorBtnLayout.this.setCameraBtn();
                        break;
                    case 3:
                        VideoCallTranslatorBtnLayout.this.mParentActivity.startFadeOutAnimation();
                        break;
                }
                VideoCallTranslatorBtnLayout.this.mCameraSwitchHandler.removeMessages(msg.what);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.isDispose = true;
        }
    }

    public VideoCallTranslatorBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsRecord = false;
        this.mIsOutgoing = false;
        this.mIsHideMe = false;
        this.mIsMuteStatus = false;
        this.mCameraSwitchHandler = new CameraSwitchHandler(this, null);
        this.mOpenTranslatorMsg = false;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_translator_btn, (ViewGroup) this, true);
    }

    public VideoCallTranslatorBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mIsRecord = false;
        this.mIsOutgoing = false;
        this.mIsHideMe = false;
        this.mIsMuteStatus = false;
        this.mCameraSwitchHandler = new CameraSwitchHandler(this, null);
        this.mOpenTranslatorMsg = false;
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    protected void setCameraBtn() {
        this.mBtnCamera.setOnClickListener(this);
        this.mBtnCamera.setEnabled(!this.mIsHideMe);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBtnShowme = (FrameLayout) findViewById(C0000R.id.show_me_btn);
        this.mBtnTranslatorTTSOn = (FrameLayout) findViewById(C0000R.id.translator_tts_on_btn);
        this.mBtnTranslatorTTSOff = (FrameLayout) findViewById(C0000R.id.translator_tts_off_btn);
        this.mBtnTranslatorChangeLanguage = (FrameLayout) findViewById(C0000R.id.translator_change_language_btn);
        this.mBtnCamera = (FrameLayout) findViewById(C0000R.id.camera_change_btn);
        this.mBtnMute = (FrameLayout) findViewById(C0000R.id.video_mute_btn);
        this.mBtnMuteCenterImage = (ImageView) findViewById(C0000R.id.video_mute_center_image);
        this.mBtnMuteBottomImage = (ImageView) findViewById(C0000R.id.video_mute_bottom_image);
        this.mBtnHangup = (FrameLayout) findViewById(C0000R.id.video_end_call_btn);
        this.mBtnHideme = (FrameLayout) findViewById(C0000R.id.video_hideme_btn);
        this.mBtnHidemeCenterImage = (ImageView) findViewById(C0000R.id.video_hideme_btn_center_image);
        this.mBtnRecord = (FrameLayout) findViewById(C0000R.id.record_stop_btn);
        this.mTranslatorSlidingDrawer = (TranslatorSlidingDrawer) findViewById(C0000R.id.video_call_translator_container);
        this.mTranslatorHandle = (Button) findViewById(C0000R.id.video_call_translator_handle);
        this.mTranslatorSlidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallTranslatorBtnLayout.1
            @Override // android.widget.SlidingDrawer.OnDrawerOpenListener
            public void onDrawerOpened() {
                if (VideoCallTranslatorBtnLayout.this.mTranslatorHandle != null) {
                    if (MainApplication.mContext.getResources().getConfiguration().orientation == 1) {
                    }
                    VideoCallTranslatorBtnLayout.this.mOpenTranslatorMsg = true;
                }
            }
        });
        this.mTranslatorSlidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallTranslatorBtnLayout.2
            @Override // android.widget.SlidingDrawer.OnDrawerCloseListener
            public void onDrawerClosed() {
                if (VideoCallTranslatorBtnLayout.this.mTranslatorHandle != null) {
                    if (MainApplication.mContext.getResources().getConfiguration().orientation != 1) {
                    }
                    VideoCallTranslatorBtnLayout.this.mOpenTranslatorMsg = false;
                }
            }
        });
        this.mBtnShowme.setOnClickListener(this);
        this.mBtnTranslatorTTSOn.setOnClickListener(this);
        this.mBtnTranslatorTTSOff.setOnClickListener(this);
        this.mBtnTranslatorChangeLanguage.setOnClickListener(this);
        this.mBtnCamera.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnHideme.setOnClickListener(this);
        this.mBtnRecord.setOnClickListener(this);
    }

    public void setParent(VideoCallActivity parent, int deviceType) {
        this.mParentActivity = parent;
    }

    public void setUIState(int callState, boolean isShareView, boolean isShareViewStartedByMe) {
        boolean isHideMe = this.mIsHideMe;
        int currentState = getCurrentUIState(callState, isShareView, isShareViewStartedByMe, isHideMe);
        logI("<CIH> currentState = " + currentState);
        switch (currentState) {
            case 1:
                setShowMeBtn(false);
                setCameraChangeBtn(true, true);
                setHideMeBtn(true);
                setMuteBtn(false, callState);
                break;
            case 2:
                setShowMeBtn(false);
                setCameraChangeBtn(true, false);
                setHideMeBtn(true);
                setMuteBtn(false, callState);
                break;
            case 4:
            case 32:
            case 128:
                setShowMeBtn(false);
                setCameraChangeBtn(true, true);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 8:
                boolean cameraChangeBtnVisibility = false;
                boolean cameraChangeBtnEnable = false;
                boolean showMeBtnEnable = false;
                if (!isHideMe) {
                    cameraChangeBtnEnable = true;
                    cameraChangeBtnVisibility = true;
                    showMeBtnEnable = false;
                } else if (this.mBtnCamera.getVisibility() == 0 && !isHideMe) {
                    if (isShareView && !isShareViewStartedByMe) {
                        cameraChangeBtnVisibility = true;
                        cameraChangeBtnEnable = false;
                    } else {
                        cameraChangeBtnEnable = true;
                        cameraChangeBtnVisibility = true;
                    }
                    showMeBtnEnable = false;
                } else if (isHideMe) {
                    cameraChangeBtnEnable = false;
                    cameraChangeBtnVisibility = false;
                    showMeBtnEnable = true;
                }
                setShowMeBtn(showMeBtnEnable);
                setCameraChangeBtn(cameraChangeBtnVisibility, cameraChangeBtnEnable);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 16:
                setShowMeBtn(true);
                setCameraChangeBtn(false, true);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 64:
                setShowMeBtn(true);
                setCameraChangeBtn(false, false);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            case 256:
                setShowMeBtn(false);
                setCameraChangeBtn(true, false);
                setHideMeBtn(false);
                setMuteBtn(true, callState);
                break;
            default:
                logI("<CIH> Error!");
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

    public void setShowMeBtn(boolean visibility) {
        if (visibility) {
            this.mBtnShowme.setVisibility(0);
            this.mBtnShowme.setEnabled(true);
        } else {
            this.mBtnShowme.setVisibility(8);
            this.mBtnShowme.setEnabled(false);
        }
    }

    private void setCameraChangeBtn(boolean visibility, boolean enable) {
        if (visibility) {
            this.mBtnCamera.setVisibility(0);
        } else {
            this.mBtnCamera.setVisibility(8);
        }
        if (enable) {
            this.mBtnCamera.setEnabled(true);
        } else {
            this.mBtnCamera.setEnabled(false);
        }
    }

    private void setHideMeBtn(boolean visibility) {
        if (visibility) {
            if (this.mIsHideMe) {
                this.mBtnHidemeCenterImage.setBackgroundResource(C0000R.drawable.call_show_me_selector);
            } else {
                this.mBtnHidemeCenterImage.setBackgroundResource(C0000R.drawable.call_hide_me_selector);
            }
            this.mBtnHideme.setVisibility(0);
            this.mBtnHideme.setEnabled(true);
            return;
        }
        this.mBtnHideme.setVisibility(8);
        this.mBtnHideme.setEnabled(false);
    }

    public void setIsMuteStatus(boolean muteOn) {
        this.mIsMuteStatus = muteOn;
    }

    private void setMuteBtn(boolean enable, int callState) {
        if (enable) {
            this.mBtnMute.setVisibility(0);
            this.mBtnMute.setEnabled(true);
            this.mBtnMuteCenterImage.setEnabled(true);
            this.mBtnMuteBottomImage.setEnabled(true);
            if (callState == 5 || this.mIsMuteStatus) {
                this.mBtnMuteCenterImage.setBackgroundResource(C0000R.drawable.call_mute_on_icon_selector);
                this.mBtnMuteBottomImage.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_on);
                return;
            } else {
                this.mBtnMuteCenterImage.setBackgroundResource(C0000R.drawable.call_mute_icon_selector);
                this.mBtnMuteBottomImage.setBackgroundResource(C0000R.drawable.call_btn_focus_switch_off);
                return;
            }
        }
        this.mBtnMute.setVisibility(8);
        this.mBtnMute.setEnabled(false);
        this.mBtnMuteCenterImage.setEnabled(false);
        this.mBtnMuteBottomImage.setEnabled(false);
    }

    public void updateBalance(String value) {
    }

    public void setHideme(boolean isHideme) {
        this.mIsHideMe = isHideme;
    }

    public void setRecordBtnStatus(boolean flag) {
        this.mIsRecord = flag;
        if (flag) {
            this.mBtnCamera.setVisibility(8);
            this.mBtnRecord.setVisibility(0);
        } else {
            this.mBtnCamera.setVisibility(0);
            this.mBtnRecord.setVisibility(8);
        }
    }

    public void setHangUpButtonToggle(boolean flag) {
        if (this.mBtnHangup != null) {
            this.mBtnHangup.setEnabled(flag);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws Throwable {
        if (this.mParentActivity != null) {
            if (this.mParentActivity.isChangeToConference()) {
                Toast.makeText(this.mParentActivity, getResources().getString(C0000R.string.change_to_conference_wait), 0).show();
                logI("WAIT: change to conference");
                return;
            }
            switch (view.getId()) {
                case C0000R.id.show_me_btn /* 2131493165 */:
                    if (this.mParentActivity != null) {
                        this.mParentActivity.setShowMe();
                        break;
                    }
                    break;
                case C0000R.id.video_mute_btn /* 2131493167 */:
                    logI("onClick: video_mute_btn");
                    CallStatusData callInfo = new CallStatusData();
                    MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                    int callState = callInfo.getCallState();
                    if (callState == 5) {
                        this.mParentActivity.stopMute();
                        setIsMuteStatus(false);
                    } else {
                        this.mParentActivity.startMute();
                        setIsMuteStatus(true);
                    }
                    setMuteBtn(true, callState);
                    break;
                case C0000R.id.video_hideme_btn /* 2131493168 */:
                    logI("onClick: video_hideme_btn");
                    if (this.mIsHideMe) {
                        this.mBtnHidemeCenterImage.setBackgroundResource(C0000R.drawable.call_show_me_selector);
                    } else {
                        this.mBtnHidemeCenterImage.setBackgroundResource(C0000R.drawable.call_hide_me_selector);
                    }
                    if (this.mIsHideMe && this.mParentActivity != null) {
                        this.mParentActivity.setShowMe();
                        break;
                    } else if (!this.mIsHideMe && this.mParentActivity != null) {
                        this.mParentActivity.setHideMe();
                        break;
                    }
                    break;
                case C0000R.id.record_stop_btn /* 2131493169 */:
                    logI("onClick: record_stop_btn");
                    if (this.mIsRecord) {
                        this.mBtnRecord.setVisibility(8);
                        if (this.mIsHideMe) {
                            setShowMeBtn(true);
                        } else {
                            this.mBtnCamera.setVisibility(0);
                        }
                        if (this.mParentActivity != null) {
                            this.mParentActivity.stopRecord();
                            break;
                        }
                    } else {
                        this.mBtnRecord.setVisibility(0);
                        this.mBtnCamera.setVisibility(8);
                        break;
                    }
                    break;
                case C0000R.id.video_end_call_btn /* 2131493170 */:
                    logI("onClick: video_end_call_btn");
                    endCall();
                    break;
                case C0000R.id.camera_change_btn /* 2131493389 */:
                    logI("onClick: camera_change_btn");
                    this.mParentActivity.startFadeInAnimation();
                    runIgnoreTimeOut();
                    if (MainApplication.mPhoneManager.getVersion() == 5) {
                        this.mCameraSwitchHandler.sendEmptyMessageDelayed(1, 300L);
                    }
                    if (this.mParentActivity.getCameraToggle() == 444) {
                        this.mParentActivity.setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_REAR);
                    } else {
                        this.mParentActivity.setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_FRONT);
                    }
                    this.mParentActivity.initPinchZoomControllerSwitchCamera();
                    break;
                case C0000R.id.translator_tts_on_btn /* 2131493551 */:
                    this.mBtnTranslatorTTSOn.setVisibility(8);
                    this.mBtnTranslatorTTSOff.setVisibility(0);
                    this.mParentActivity.Start_BubbleTTSPlayer();
                    break;
                case C0000R.id.translator_tts_off_btn /* 2131493552 */:
                    this.mBtnTranslatorTTSOff.setVisibility(8);
                    this.mBtnTranslatorTTSOn.setVisibility(0);
                    this.mParentActivity.End_BubbleTTSPlayer();
                    break;
                case C0000R.id.translator_change_language_btn /* 2131493553 */:
                    this.mParentActivity.showDialog(999);
                    break;
            }
            if (view.getId() != C0000R.id.video_end_call_btn) {
                this.mParentActivity.closeOptionsMenu();
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
        if (!this.mIsOutgoing) {
            this.mBtnHangup.setEnabled(false);
        }
    }

    private void runIgnoreTimeOut() {
        logI("runIgnoreTimeOut");
        setCameraChangeBtn(true, false);
        this.mBtnCamera.setOnClickListener(null);
        this.mIgoreTimer = new Timer();
        this.mIgoreTimer.schedule(new TimerTask() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallTranslatorBtnLayout.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                VideoCallTranslatorBtnLayout.this.mCameraSwitchHandler.sendEmptyMessage(2);
            }
        }, IGNORE_TIME_OUT_SEC);
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mBtnCamera != null) {
            this.mBtnCamera.removeCallbacks(null);
            this.mBtnCamera = null;
        }
        if (this.mBtnMute != null) {
            this.mBtnMute.removeCallbacks(null);
            this.mBtnMute = null;
        }
        if (this.mBtnHangup != null) {
            this.mBtnHangup.removeCallbacks(null);
            this.mBtnHangup = null;
        }
        if (this.mCameraSwitchHandler != null) {
            this.mCameraSwitchHandler.dispose();
            this.mCameraSwitchHandler = null;
        }
        if (this.mIgoreTimer != null) {
            this.mIgoreTimer.cancel();
            this.mIgoreTimer = null;
        }
        removeAllViewsInLayout();
    }
}
