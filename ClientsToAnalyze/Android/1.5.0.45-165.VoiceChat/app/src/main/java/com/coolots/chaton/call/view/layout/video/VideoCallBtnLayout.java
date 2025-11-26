package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.SECConfig;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.call.view.VideoCallActivity;
import com.coolots.chaton.common.util.ContentDescriptionStringMaker;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class VideoCallBtnLayout extends LinearLayout implements View.OnClickListener, DisposeInterface {
    private static final String CLASSNAME = "[VideoCallBtnLayout]";
    private static final int DUAL_CAMERA_CHANGE_FINISH = 6;
    private static final int DUAL_CAMERA_START = 4;
    public static final int DUAL_CAMERA_STOP = 5;
    private static final long IGNORE_TIME_OUT_SEC = 1600;
    private static final int SWITCH_CAMERA = 1;
    private static final int SWITCH_CAMERA_FINISH = 10;
    private static final int SWITCH_CAMERA_SETTING = 8;
    private static final int SWITCH_CAMERA_SET_BTN = 2;
    private static final int SWITCH_CAMERA_START = 9;
    private static final int SWITCH_CAMERA_START_FADE_OUT = 3;
    private static final int SWITCH_DUAL_CAMERA = 7;
    private boolean isDualCameraChanging;
    private boolean isSwitchCameraChanging;
    private RelativeLayout mBtnHangup;
    private RelativeLayout mBtnHideme;
    private RelativeLayout mBtnMute;
    private RelativeLayout mBtnRecord;
    private RelativeLayout mBtnShowme;
    private RelativeLayout mBtnSwitchCamera;
    public ButtonEventHandler mButtonEventHandler;
    private CameraSwitchHandler mCameraSwitchHandler;
    private Timer mIgoreTimer;
    private boolean mIsHideMe;
    private boolean mIsMuteStatus;
    private boolean mIsOutgoing;
    private ChatOnCallActivity mParentActivity;
    private int mSwitchCameraState;
    public WindowManager windowManager;

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public class ButtonEventHandler extends Handler implements DisposeInterface {
        private boolean isDispose = false;

        public ButtonEventHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.isDispose) {
                switch (msg.what) {
                    case 4:
                        VideoCallBtnLayout.this.logI("DUAL_CAMERA_START");
                        VideoCallBtnLayout.this.mParentActivity.startDualCamera();
                        break;
                    case 5:
                        VideoCallBtnLayout.this.logI("DUAL_CAMERA_STOP");
                        VideoCallBtnLayout.this.mParentActivity.stopDualCamera();
                        break;
                    case 6:
                        VideoCallBtnLayout.this.logI("DUAL_CAMERA_CHANGE_FINISH");
                        VideoCallBtnLayout.this.isDualCameraChanging = false;
                        break;
                    case 7:
                        VideoCallBtnLayout.this.logI("SWITCH_DUAL_CAMERA");
                        VideoCallBtnLayout.this.mParentActivity.switchDualCamera();
                        VideoCallBtnLayout.this.mButtonEventHandler.sendEmptyMessage(10);
                        break;
                    case 8:
                        VideoCallBtnLayout.this.logI("SWITCH_CAMERA_SETTING");
                        VideoCallBtnLayout.this.mParentActivity.startFadeInAnimation();
                        VideoCallBtnLayout.this.runIgnoreTimeOut();
                        if (MainApplication.mPhoneManager.getVersion() == 5) {
                            VideoCallBtnLayout.this.mCameraSwitchHandler.sendEmptyMessageDelayed(1, 300L);
                            break;
                        }
                        break;
                    case 9:
                        VideoCallBtnLayout.this.logI("SWITCH_CAMERA_START");
                        if (((VideoCallActivity) VideoCallBtnLayout.this.mParentActivity).getCameraToggle() == 444) {
                            ((VideoCallActivity) VideoCallBtnLayout.this.mParentActivity).setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_REAR);
                        } else {
                            ((VideoCallActivity) VideoCallBtnLayout.this.mParentActivity).setCameraToggle(VideoCallActivity.CAMERA_VISIBLE_FRONT);
                        }
                        VideoCallBtnLayout.this.mParentActivity.initPinchZoomControllerSwitchCamera();
                        break;
                    case 10:
                        VideoCallBtnLayout.this.logI("SWITCH_CAMERA_FINISH");
                        VideoCallBtnLayout.this.isSwitchCameraChanging = false;
                        break;
                }
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.isDispose = true;
        }
    }

    private class CameraSwitchHandler extends Handler implements DisposeInterface {
        private boolean isDispose;

        private CameraSwitchHandler() {
            this.isDispose = false;
        }

        /* synthetic */ CameraSwitchHandler(VideoCallBtnLayout videoCallBtnLayout, CameraSwitchHandler cameraSwitchHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.isDispose) {
                switch (msg.what) {
                    case 1:
                        SECConfig.switchCamera();
                        VideoCallBtnLayout.this.mCameraSwitchHandler.sendEmptyMessageDelayed(3, 300L);
                        VideoCallBtnLayout.this.mButtonEventHandler.sendEmptyMessage(10);
                        break;
                    case 2:
                        VideoCallBtnLayout.this.setCameraBtn();
                        break;
                    case 3:
                        VideoCallBtnLayout.this.mParentActivity.startFadeOutAnimation();
                        break;
                }
                VideoCallBtnLayout.this.mCameraSwitchHandler.removeMessages(msg.what);
            }
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.isDispose = true;
        }
    }

    public VideoCallBtnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsOutgoing = false;
        this.mIsHideMe = false;
        this.mIsMuteStatus = false;
        this.mCameraSwitchHandler = new CameraSwitchHandler(this, null);
        this.mButtonEventHandler = new ButtonEventHandler();
        this.isDualCameraChanging = false;
        this.isSwitchCameraChanging = false;
        this.windowManager = null;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.video_call_btn_with_dualcamera, (ViewGroup) this, true);
    }

    public VideoCallBtnLayout(Context context, AttributeSet attrs, boolean callFromChild) {
        super(context, attrs);
        this.mIsOutgoing = false;
        this.mIsHideMe = false;
        this.mIsMuteStatus = false;
        this.mCameraSwitchHandler = new CameraSwitchHandler(this, null);
        this.mButtonEventHandler = new ButtonEventHandler();
        this.isDualCameraChanging = false;
        this.isSwitchCameraChanging = false;
        this.windowManager = null;
    }

    protected void onFinishInflate(boolean callFromChild) {
        super.onFinishInflate();
    }

    protected void setCameraBtn() {
        this.mBtnSwitchCamera.setOnClickListener(this);
        this.mBtnSwitchCamera.setEnabled(!this.mIsHideMe);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBtnShowme = (RelativeLayout) findViewById(C0000R.id.show_me_btn);
        this.mBtnSwitchCamera = (RelativeLayout) findViewById(C0000R.id.camera_change_btn);
        this.mBtnMute = (RelativeLayout) findViewById(C0000R.id.video_mute_btn);
        this.mBtnHangup = (RelativeLayout) findViewById(C0000R.id.video_end_call_btn);
        this.mBtnHideme = (RelativeLayout) findViewById(C0000R.id.video_hideme_btn);
        this.mBtnRecord = (RelativeLayout) findViewById(C0000R.id.record_stop_btn);
        this.mBtnShowme.setOnClickListener(this);
        this.mBtnSwitchCamera.setOnClickListener(this);
        this.mBtnMute.setOnClickListener(this);
        this.mBtnHangup.setOnClickListener(this);
        this.mBtnHideme.setOnClickListener(this);
        this.mBtnRecord.setOnClickListener(this);
        this.mBtnShowme.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_show_me, C0000R.string.talk_back_button));
        this.mBtnSwitchCamera.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_camera, C0000R.string.talk_back_button));
        this.mBtnHideme.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_hide_me, C0000R.string.talk_back_button));
        this.mBtnHangup.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_callend, C0000R.string.talk_back_button));
    }

    public void setParent(ChatOnCallActivity parent) {
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
                if (isHideMe) {
                    showMeBtnEnable = true;
                } else {
                    cameraChangeBtnVisibility = true;
                    cameraChangeBtnEnable = true;
                }
                setShowMeBtn(showMeBtnEnable);
                setCameraChangeBtn(cameraChangeBtnVisibility, cameraChangeBtnEnable);
                setHideMeBtn(false);
                setIsMuteStatus(true);
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
            case 512:
                setRecordBtnStatus(true);
                setShowMeBtn(false);
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
            if (!isHideMe) {
                return 1;
            }
            return 2;
        }
        if (this.mParentActivity.isRecordingVideo()) {
            return 512;
        }
        if (isShareView) {
            if (isShareViewStartedByMe) {
                if (!isHideMe) {
                    return 128;
                }
                return 64;
            }
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
            this.mBtnSwitchCamera.setVisibility(0);
        } else {
            this.mBtnSwitchCamera.setVisibility(8);
        }
        if (enable) {
            this.mBtnSwitchCamera.setEnabled(true);
        } else {
            this.mBtnSwitchCamera.setEnabled(false);
        }
    }

    private void setHideMeBtn(boolean visibility) {
        if (visibility) {
            TextView TextView = (TextView) findViewById(C0000R.id.hideme_text);
            ImageView TopImage = (ImageView) findViewById(C0000R.id.hideme_top_img);
            if (this.mIsHideMe) {
                TextView.setText(getResources().getString(C0000R.string.call_menu_show_me));
                TopImage.setImageResource(C0000R.drawable.call_show_me_selector);
                this.mBtnHideme.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_show_me, C0000R.string.talk_back_button));
            } else {
                TextView.setText(getResources().getString(C0000R.string.call_menu_hide_me));
                TopImage.setImageResource(C0000R.drawable.call_hide_me_selector);
                this.mBtnHideme.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_menu_hide_me, C0000R.string.talk_back_button));
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
            ImageView topImageView = (ImageView) findViewById(C0000R.id.mute_top_img);
            ImageView bottomImageView = (ImageView) findViewById(C0000R.id.mute_bottom_img);
            if (callState == 5 || this.mIsMuteStatus) {
                topImageView.setSelected(true);
                bottomImageView.setSelected(true);
                this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_off, C0000R.string.talk_back_button));
                return;
            } else {
                topImageView.setSelected(false);
                bottomImageView.setSelected(false);
                this.mBtnMute.setContentDescription(ContentDescriptionStringMaker.makeString(C0000R.string.call_btn_mute_on, C0000R.string.talk_back_button));
                return;
            }
        }
        this.mBtnMute.setVisibility(8);
    }

    public void updateBalance(String value) {
    }

    public void setHideme(boolean isHideme) {
        this.mIsHideMe = isHideme;
    }

    public void setRecordBtnStatus(boolean isRecording) {
        if (isRecording) {
            this.mBtnSwitchCamera.setVisibility(8);
            this.mBtnRecord.setVisibility(0);
        } else {
            this.mBtnSwitchCamera.setVisibility(0);
            this.mBtnRecord.setVisibility(8);
        }
    }

    public void setHangUpButtonToggle(boolean flag) {
        if (this.mBtnHangup != null) {
            this.mBtnHangup.setEnabled(flag);
        }
    }

    public void onClick(View view) {
        logI("onClick()");
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
                        this.mParentActivity.cancelSlectedThemeShot();
                        break;
                    }
                    break;
                case C0000R.id.video_mute_btn /* 2131493167 */:
                    logI("onClick: video_mute_btn");
                    if (this.mParentActivity.isActiveSTTTranslationTTS()) {
                        this.mBtnMute.setVisibility(0);
                        ImageView topImageView = (ImageView) findViewById(C0000R.id.mute_top_img);
                        ImageView bottomImageView = (ImageView) findViewById(C0000R.id.mute_bottom_img);
                        if (topImageView.isSelected() && bottomImageView.isSelected()) {
                            logI("Mute button is unselected during translation");
                            this.mParentActivity.startRecognition();
                            setIsMuteStatus(false);
                            topImageView.setSelected(false);
                            bottomImageView.setSelected(false);
                            return;
                        }
                        logI("Mute button is selected during translation");
                        this.mParentActivity.stopRecognition();
                        setIsMuteStatus(true);
                        topImageView.setSelected(true);
                        bottomImageView.setSelected(true);
                        return;
                    }
                    CallStatusData callInfo = new CallStatusData();
                    MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                    int callState = callInfo.getCallState();
                    if (callState == 5) {
                        this.mParentActivity.stopMute();
                        this.mParentActivity.cancelMute();
                        setIsMuteStatus(false);
                    } else {
                        this.mParentActivity.startMute();
                        this.mParentActivity.notifyMute();
                        setIsMuteStatus(true);
                    }
                    setMuteBtn(true, callState);
                    break;
                case C0000R.id.video_hideme_btn /* 2131493168 */:
                    logI("onClick: video_hideme_btn");
                    TextView TextView = (TextView) findViewById(C0000R.id.hideme_text);
                    ImageView TopImage = (ImageView) findViewById(C0000R.id.hideme_top_img);
                    if (this.mIsHideMe) {
                        TextView.setText(getResources().getString(C0000R.string.call_menu_show_me));
                        TopImage.setImageResource(C0000R.drawable.call_show_me_selector);
                    } else {
                        TextView.setText(getResources().getString(C0000R.string.call_menu_hide_me));
                        TopImage.setImageResource(C0000R.drawable.call_hide_me_selector);
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
                    this.mBtnRecord.setVisibility(8);
                    if (this.mIsHideMe) {
                        setShowMeBtn(true);
                    } else {
                        this.mBtnSwitchCamera.setVisibility(0);
                    }
                    if (this.mParentActivity != null) {
                        this.mParentActivity.stopRecord();
                        break;
                    }
                    break;
                case C0000R.id.video_end_call_btn /* 2131493170 */:
                    logI("onClick: video_end_call_btn");
                    endCall();
                    break;
                case C0000R.id.camera_change_btn /* 2131493389 */:
                    logI("onClick: camera_change_btn");
                    if (!this.isDualCameraChanging && !this.isSwitchCameraChanging) {
                        this.isSwitchCameraChanging = true;
                        if (this.mParentActivity.useDualCamera()) {
                            this.mButtonEventHandler.sendEmptyMessage(7);
                        } else {
                            this.mButtonEventHandler.sendEmptyMessage(8);
                        }
                        this.mButtonEventHandler.sendEmptyMessage(9);
                        break;
                    }
                    break;
            }
            if (view.getId() != C0000R.id.video_end_call_btn) {
                this.mParentActivity.closeOptionsMenu();
            }
            logI("onClick()-----");
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
            this.mBtnShowme.setEnabled(false);
            this.mBtnHideme.setEnabled(false);
            this.mBtnSwitchCamera.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runIgnoreTimeOut() {
        logI("runIgnoreTimeOut");
        if (!this.mIsHideMe) {
            boolean isShowingSwitchCameraBtn = true;
            if (this.mBtnSwitchCamera.getVisibility() != 0) {
                isShowingSwitchCameraBtn = false;
            }
            setCameraChangeBtn(isShowingSwitchCameraBtn, false);
            this.mBtnSwitchCamera.setOnClickListener(null);
            this.mIgoreTimer = new Timer();
            this.mIgoreTimer.schedule(new TimerTask() { // from class: com.coolots.chaton.call.view.layout.video.VideoCallBtnLayout.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    VideoCallBtnLayout.this.mCameraSwitchHandler.sendEmptyMessage(2);
                }
            }, IGNORE_TIME_OUT_SEC);
        }
    }

    public void dispose() {
        if (this.mParentActivity != null) {
            this.mParentActivity = null;
        }
        if (this.mBtnSwitchCamera != null) {
            this.mBtnSwitchCamera.removeCallbacks(null);
            this.mBtnSwitchCamera = null;
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
        if (this.mButtonEventHandler != null) {
            this.mButtonEventHandler.dispose();
            this.mButtonEventHandler = null;
        }
        if (this.mIgoreTimer != null) {
            this.mIgoreTimer.cancel();
            this.mIgoreTimer = null;
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
