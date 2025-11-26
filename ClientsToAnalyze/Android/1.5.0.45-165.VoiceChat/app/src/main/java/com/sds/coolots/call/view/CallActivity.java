package com.sds.coolots.call.view;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.KeyEvent;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.CallFunctionControllerInterface;
import com.sds.coolots.call.CallingInterface;
import com.sds.coolots.call.PhoneStateMachine;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.ConsentDisplayInfo;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.nego.NegoFeatureControllerInterface;
import com.sds.coolots.common.controller.audiopath.AudioPathControllerInterface;
import com.sds.coolots.common.controller.translation.C1248b;
import com.sds.coolots.common.controller.translation.data.C1250a;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.coolotsinterface.MotionListener;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class CallActivity extends Activity implements CallingInterface, DisposeInterface {
    public static final int CHECK_CALLINSTANT_TO_CREATE_ACTIVITY_FINISH = 1;
    public static final int CHECK_CALLINSTANT_TO_CREATE_ACTIVITY_IGNORE = 2;
    public static final int CHECK_CALLINSTANT_TO_CREATE_ACTIVITY_VALID = 0;
    public static final int DIALOG_CONNTECT_FAIL = 104;
    public static final int MSG_ADD_FLAG_KEYGUARD_LOCK = 31;
    public static final int MSG_AUTO_RECEIVE_CALL = 100;
    public static final int MSG_BT_BUTTON_DISABLE = 21;
    public static final int MSG_BT_BUTTON_OFF = 20;
    public static final int MSG_BT_BUTTON_ON = 19;
    public static final int MSG_CLEAR_FLAG_KEYGUARD_LOCK = 32;
    public static final int MSG_DELAYED_QUIT = 10;
    public static final int MSG_EARPHONE_PLUGGED = 25;
    public static final int MSG_EARPHONE_UNPLUGGED = 26;
    public static final int MSG_ENTERING_PICK_BUDDY_ACTIVITY = 6421;
    public static final int MSG_HANGUP_CALL = 11;
    public static final int MSG_HANGUP_ENTITLEMENT = 27;
    public static final int MSG_HOLD_BUTTON_CLICKABLE = 22;
    public static final int MSG_LOW_BATTERY = 13;
    public static final int MSG_NETWORK_ERROR_HANGUP_ENTITLEMENT = 28;
    public static final int MSG_NOTIFY_VIDEO_CALL_HANGUP_SOON_IN_UCAMERA = 29;
    public static final int MSG_NOT_CONNTECT_FLY = 1001;
    public static final int MSG_NOT_CONNTECT_NETWORK = 1000;
    public static final int MSG_PREVIOUS_MUTE_OFF = 24;
    public static final int MSG_PREVIOUS_MUTE_ON = 23;
    public static final int MSG_RECORD_SAVE_NOTI = 1002;
    public static final int MSG_REQUESTING_SWITCH_TO_VIDEO_CALL = 7421;
    public static final int MSG_SPEAKER_BUTTON_DISABLE = 18;
    public static final int MSG_SPEAKER_BUTTON_ENABLE = 17;
    public static final int MSG_SPEAKER_DISABLE = 16;
    public static final int MSG_SPEAKER_ENABLE = 15;
    public static final int MSG_SPEAKER_SETTING = 14;
    public static final int MSG_TESTMODE_RECEIVE = 12;
    public static final int MSG_VIDEO_CALL_HANGUP_IN_UCAMERA = 30;
    public static final int SHARE_VIEW_TOAST_CANNOT_START = 6;
    public static final int SHARE_VIEW_TOAST_END = 2;
    public static final int SHARE_VIEW_TOAST_END_SIMULTANEOUS_START = 5;
    public static final int SHARE_VIEW_TOAST_END_STARTER = 3;
    public static final int SHARE_VIEW_TOAST_END_TIMEOUT = 4;
    public static final int SHARE_VIEW_TOAST_REJECTED = 7;
    public static final int SHARE_VIEW_TOAST_START = 1;
    public static final int SHARE_VIEW_TOAST_START_ASK = 0;

    /* renamed from: c */
    private static final String f2870c = "[CallActivity]";

    /* renamed from: d */
    private static final int f2871d = 900000;

    /* renamed from: e */
    private static final int f2872e = 840000;
    protected String mCallDate;
    protected int mCallID;
    protected int mCallState;
    protected Destination mDestination;
    protected int mDuration;
    protected CallHandler mHandler;
    protected boolean mIsCallAccept;
    protected boolean mIsLiveShare;
    protected boolean mIsOutGoingCall;
    protected boolean mIsPushSuccess;
    protected boolean mIsSecureCommunication;
    protected UiModeManager mUiModeManager;
    protected boolean mUseVideo;

    /* renamed from: f */
    private Date f2875f = null;
    protected boolean mNetworkDisconnect = false;
    public CallStatusData mCallStatusData = new CallStatusData();
    protected boolean mIsNormalTerminatingProcess = false;
    protected boolean mRetryCall = false;
    protected boolean mRetryVideo = false;
    protected boolean mIsUpNomalTerminatingCall = false;
    protected boolean mUseNoiseReduction = true;
    protected int mEmotionalAnimationType = 0;
    protected boolean mAlwaysEmotional = false;
    protected int mThemeShotType = 0;
    protected String mHostDisplayName = "";
    protected boolean mUseDualCamera = false;
    protected boolean mIsDefaultHideMeImage = false;
    protected boolean mIs3GConnectType = false;
    protected boolean mUseAvatar = false;
    protected int mIsActivieShareScreen = -1;
    protected AudioPathControllerInterface mAudioPathController = null;
    protected CallFunctionControllerInterface mCallFunctionController = null;
    protected NegoFeatureControllerInterface mNegoFeatureController = null;
    protected Dialog mConferenceDeleteDialog = null;
    protected Dialog mConferenceStatusDialog = null;
    protected Dialog mConferenceAddDialog = null;
    protected boolean mPreviousCarMode = false;
    protected short mDestDeviceID = -1;
    public boolean mMuteOnBeforeHold = false;
    public boolean mIsShareScreenCaller = false;
    public boolean mIsShareScreenWaitForAccepting = false;
    protected boolean mIsChangeToConference = false;
    protected boolean isAlreadySendPlaceCall = false;

    /* renamed from: a */
    AudioManager f2873a = null;

    /* renamed from: g */
    private MotionListener f2876g = null;

    /* renamed from: b */
    ActivityManager f2874b = null;

    /* renamed from: a */
    private void m2802a(String str) {
        Log.m2958e(f2870c + str);
    }

    /* renamed from: b */
    private void m2803b(String str) {
        Log.m2963i(f2870c + str);
    }

    /* renamed from: c */
    private void m2804c() {
        m2803b("checkRetryCallOnPause()++");
        if (this.mRetryCall) {
            cancelDelayedQuit();
            finish();
        }
        m2803b("checkRetryCallOnPause()--");
    }

    /* renamed from: d */
    private void m2805d() {
        if (this.mRetryCall) {
            return;
        }
        m2803b("[[[LHH]]] retryp mRetryCall = false");
        if (this.mDestination != null) {
            this.mDestination = null;
        }
        if (this.mCallStatusData != null) {
            this.mCallStatusData = null;
        }
        if (this.mHandler != null) {
            this.mHandler.dispose();
            this.mHandler = null;
        }
        if (this.mConferenceDeleteDialog != null) {
            this.mConferenceDeleteDialog = null;
        }
        if (this.mConferenceStatusDialog != null) {
            this.mConferenceStatusDialog = null;
        }
        if (this.mConferenceAddDialog != null) {
            this.mConferenceAddDialog = null;
        }
        this.mRetryCall = false;
    }

    /* renamed from: e */
    private boolean m2806e() {
        return ((PowerManager) MainApplication.mContext.getSystemService("power")).isScreenOn();
    }

    /* renamed from: f */
    private void m2807f() {
        m2803b("callInstanceRefresh()");
        int i = this.mCallID;
        int i2 = this.mCallState;
        this.mDestination = this.mCallStatusData.getDestination();
        this.mUseVideo = this.mCallStatusData.isUseVideo();
        this.mCallID = this.mCallStatusData.getCallID();
        this.mCallState = this.mCallStatusData.getCallState();
        this.mIsCallAccept = this.mCallStatusData.isCallAccept();
        this.mIsOutGoingCall = this.mCallStatusData.isOutGoingCall();
        this.mIsPushSuccess = this.mCallStatusData.isPushSuccess();
        this.mIsSecureCommunication = this.mCallStatusData.isSecureCommunication();
        this.mUseNoiseReduction = this.mCallStatusData.isNoiseReduction();
        this.mEmotionalAnimationType = this.mCallStatusData.getEmotionalAnimationType();
        this.mAlwaysEmotional = this.mCallStatusData.isAlwaysEmotional();
        this.mThemeShotType = this.mCallStatusData.getThemeShotType();
        this.mHostDisplayName = this.mCallStatusData.getHostDisplayName();
        this.mAudioPathController = this.mCallStatusData.getAudioPathController();
        this.mCallFunctionController = this.mCallStatusData.getCallFunctionController();
        this.mNegoFeatureController = this.mCallStatusData.getNegoFeatureController();
        this.mIsDefaultHideMeImage = this.mCallStatusData.isDefaultHideMeImage();
        this.mUseDualCamera = this.mCallStatusData.isUseDualCamera();
        this.mIs3GConnectType = this.mCallStatusData.is3GConnectType();
        this.mUseAvatar = this.mCallStatusData.isUseAvatar();
        this.mIsActivieShareScreen = this.mCallStatusData.isActiveShareScreen();
        this.mIsLiveShare = this.mCallStatusData.isLiveShare();
        this.mDestDeviceID = this.mCallStatusData.getDestDeviceID();
        updateUserAddedInfo(this.mDestination, this.mHostDisplayName);
        m2803b("mCallID: " + this.mCallID + ", oldCallID: " + i);
        if (i != this.mCallID && this.mAudioPathController != null) {
            m2803b("callInstanceRefresh () mHandler: " + (this.mHandler == null ? this.mHandler : this.mHandler.toString()));
            if (!this.mAudioPathController.getUIHandler()) {
                this.mAudioPathController.setUIHandler(this.mHandler);
            }
        }
        if (CallState.isConnected(i2) && CallState.isDisconnected(this.mCallState) && this.mCallStatusData.gethangupReason() == 1005) {
            m2802a("<<YHT100>> SET NETWORK DISCONNECT FLAG!!");
            this.mNetworkDisconnect = true;
        }
    }

    /* renamed from: g */
    private void m2808g() {
        m2802a("volumeUpVoice()");
        this.f2873a = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!this.mAudioPathController.isBlueToothConnected() || !this.mAudioPathController.isBlueToothOn()) {
            int streamVolume = this.f2873a.getStreamVolume(0);
            int streamMaxVolume = this.f2873a.getStreamMaxVolume(0);
            if (streamVolume + 1 < streamMaxVolume) {
                streamMaxVolume = streamVolume + 1;
            }
            this.f2873a.setStreamVolume(0, streamMaxVolume, 1);
            return;
        }
        int bTStreamType = MainApplication.mNativeSetting.getBTStreamType();
        int streamVolume2 = this.f2873a.getStreamVolume(bTStreamType);
        int streamMaxVolume2 = this.f2873a.getStreamMaxVolume(bTStreamType);
        if (streamVolume2 + 1 < streamMaxVolume2) {
            streamMaxVolume2 = streamVolume2 + 1;
        }
        this.f2873a.setStreamVolume(bTStreamType, streamMaxVolume2, 1);
    }

    public static String getStringForEvent(int i) {
        String str = "";
        switch (i) {
            case 10:
                str = "MSG_DELAYED_QUIT";
                break;
            case 14:
                str = "MSG_SPEAKER_SETTING";
                break;
            case EventCode.EVENT_CALL_CALLING /* 7100 */:
                str = "EVENT_CALL_CALLING";
                break;
            case EventCode.EVENT_CALL_CONNECTED /* 7101 */:
                str = "EVENT_CALL_CONNECTED";
                break;
            case EventCode.EVENT_CALL_HANGUP /* 7102 */:
                str = "EVENT_CALL_HANGUP";
                break;
            case EventCode.EVENT_CALL_HOLD /* 7103 */:
                str = "EVENT_CALL_HOLD";
                break;
            case EventCode.EVENT_CALL_UNHOLD /* 7104 */:
                str = "EVENT_CALL_UNHOLD";
                break;
            case EventCode.EVENT_CALL_MUTE /* 7105 */:
                str = "EVENT_CALL_MUTE";
                break;
            case EventCode.EVENT_CALL_UNMUTE /* 7106 */:
                str = "EVENT_CALL_UNMUTE";
                break;
            case EventCode.EVENT_CALL_ERROR /* 7107 */:
                str = "EVENT_CALL_ERROR";
                break;
            case EventCode.EVENT_CALL_BUSY /* 7108 */:
                str = "EVENT_CALL_BUSY";
                break;
            case EventCode.EVENT_CALL_ACTION /* 7300 */:
                str = "EVENT_CALL_ACTION";
                break;
            case EventCode.EVENT_UPDATE_CREDIT /* 7400 */:
                str = "EVENT_UPDATE_CREDIT";
                break;
        }
        return "com.sds.coolots.CallingActivity." + str;
    }

    /* renamed from: h */
    private void m2809h() {
        m2802a("volumeDownVoice()");
        this.f2873a = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!this.mAudioPathController.isBlueToothConnected() || !this.mAudioPathController.isBlueToothOn()) {
            int streamVolume = this.f2873a.getStreamVolume(0);
            this.f2873a.setStreamVolume(0, streamVolume + (-1) <= 0 ? 0 : streamVolume - 1, 1);
        } else {
            int bTStreamType = MainApplication.mNativeSetting.getBTStreamType();
            int streamVolume2 = this.f2873a.getStreamVolume(bTStreamType);
            this.f2873a.setStreamVolume(bTStreamType, streamVolume2 + (-1) <= 0 ? 0 : streamVolume2 - 1, 1);
        }
    }

    public void SendTranslateData(String str, String str2, int i) {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().sendTranslateData(str, str2, i);
        }
    }

    /* renamed from: a */
    void m2810a() {
        if (this.f2876g != null) {
            this.f2876g.startMotionCatch();
            m2802a("startMotionCatch()!!!!!!!");
        }
    }

    public int addConferenceMember(ArrayList arrayList, ArrayList arrayList2) {
        return (this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5 || this.mDestination.getDestinationType() == 2) ? MainApplication.mPhoneManager.getPhoneStateMachine().addConferenceMember(this.mDestination, arrayList, arrayList2) : PhoneStateMachine.ERROR_INVALID_CALL_TYPE;
    }

    protected void addFlagKeyGuardLock() {
        getWindow().addFlags(4194304);
    }

    /* renamed from: b */
    void m2811b() {
        if (this.f2876g != null) {
            this.f2876g.stopMotionCatch();
            m2802a("stopMotionCatch()!!!!!!!");
        }
    }

    protected String calculateCurrentTimeInFormatyyyyMMddHHmmss() {
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        m2803b("calculateCurrentTimeInFormat_yyyyMMddHHmmss() : " + str);
        return str;
    }

    protected abstract int calculateDuration();

    public void cancelDelayedQuit() {
        m2803b("cancelDelayedQuit()");
        if (this.mHandler != null) {
            this.mHandler.removeMessages(10);
        }
        this.f2875f = null;
    }

    public int checkCallInstance() {
        m2803b("checkCallInstance()");
        if (this.mCallStatusData == null) {
            return 2;
        }
        this.mCallStatusData.updateCallState();
        if (this.mCallStatusData.isValidity()) {
            return 0;
        }
        m2802a("You have to finish this activity.");
        return 1;
    }

    public boolean checkCallInstanceNRefresh() {
        int iCheckCallInstance = checkCallInstance();
        if (iCheckCallInstance == 1) {
            return false;
        }
        if (iCheckCallInstance == 2) {
            return true;
        }
        m2807f();
        return true;
    }

    protected void clearFlagKeyGuarLock() {
        getWindow().clearFlags(4194304);
    }

    public abstract void clickableHoldButton();

    public boolean closeSTTTranslationTTS(boolean z) {
        if (this.mDestination.getDestinationType() != 2) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().closeSTTTranslationTTS(z);
        return true;
    }

    public void delayedQuit() {
        m2802a("delayedQuit()");
        Message message = new Message();
        message.what = 10;
        sendHandlerMessage(message, 4000L);
        this.f2875f = new Date();
    }

    public abstract void denyCall();

    public abstract void denyCallwithRejectMsg(int i, String str);

    public abstract void disableBTButton();

    public abstract void disableSpeakerButton();

    public void disableSpeakerCall() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            return;
        }
        Log.m2958e("disableSpeakerCall()");
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().setSpeakerPhone(false);
    }

    public abstract void dismissCallConsentUserActionDialog();

    public abstract void dismissConsentDialog();

    protected void dismissEveryDialog() {
        if (this.mConferenceAddDialog != null && this.mConferenceAddDialog.isShowing()) {
            this.mConferenceAddDialog.dismiss();
        }
        if (this.mConferenceStatusDialog != null && this.mConferenceStatusDialog.isShowing()) {
            this.mConferenceStatusDialog.dismiss();
        }
        if (this.mConferenceDeleteDialog == null || !this.mConferenceDeleteDialog.isShowing()) {
            return;
        }
        this.mConferenceDeleteDialog.dismiss();
    }

    public abstract void enableSpeakerButton();

    public void enableSpeakerCall() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            return;
        }
        Log.m2958e("enableSpeakerCall()");
        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().setSpeakerPhone(true);
    }

    protected abstract void errorForUI();

    @Override // android.app.Activity
    public void finish() {
        m2803b("finish()");
        this.mIsNormalTerminatingProcess = true;
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        super.finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    public AudioPathControllerInterface getAudioPathController() {
        return this.mAudioPathController;
    }

    protected String getCallDate() {
        return this.mCallDate;
    }

    public CallFunctionControllerInterface getCallFunctionController() {
        return this.mCallFunctionController;
    }

    public int getCallState() {
        return this.mCallState;
    }

    public Destination getDestination() {
        return this.mDestination;
    }

    protected int getDuration() {
        return this.mDuration;
    }

    protected String getForegounrdActivity(Context context) throws SecurityException {
        this.f2874b = (ActivityManager) context.getSystemService("activity");
        List<ActivityManager.RunningTaskInfo> runningTasks = this.f2874b.getRunningTasks(1);
        return runningTasks != null ? runningTasks.get(0).topActivity.getClassName() : "";
    }

    public int getHangupCode() {
        return MainApplication.mPhoneManager.getPhoneStateMachine().getHangupCode();
    }

    public NegoFeatureControllerInterface getNegoFeatureController() {
        return this.mNegoFeatureController;
    }

    public Set getRecognitionSupportedVoiceLanguage() {
        if (this.mDestination.getDestinationType() == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().getRecognitionSupportedVoiceLanguage();
        }
        return null;
    }

    public C1250a getTranslationList() {
        if (this.mDestination.getDestinationType() == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationList();
        }
        return null;
    }

    public Set getTranslationSupportedOutLanguage(int i) {
        if (this.mDestination.getDestinationType() == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationSupportedOutLanguage(i);
        }
        return null;
    }

    public abstract void gotoBlueToothSettingPage();

    public void handleActivityForCallSwitch(Intent intent) {
        stopRecordingForCallSwitching();
        this.mIsNormalTerminatingProcess = true;
        finish();
        if (intent != null) {
            MainApplication.mContext.startActivity(intent);
        }
    }

    public void handleCallEvent(int i) {
        m2802a("++current call state is " + CallState.getCallStateDescription(this.mCallState));
        switch (this.mCallState) {
            case -1:
            case 3:
                m2803b("QuickPanel - delete Nofi when CallSate = STATE_DISCONNECTED||STATE_ERROR");
                MainApplication.mCallNotification.deleteCallNotification();
                this.mCallState = 3;
                dismissEveryDialog();
                updateUIComponent();
                break;
            case 0:
            case 1:
                this.mCallState = 1;
                updateUIComponent();
                this.mCallDate = calculateCurrentTimeInFormatyyyyMMddHHmmss();
                if (MainApplication.mPhoneManager.isTestReceiveMode()) {
                    this.mHandler.sendEmptyMessageDelayed(12, 1000L);
                    break;
                }
                break;
            case 2:
                this.mCallState = 2;
                updateUIComponent();
                switch (i) {
                    case 17:
                        updateHoldState(false);
                        break;
                    case 18:
                        updateMuteState(false);
                        break;
                }
            case 4:
                this.mCallState = 4;
                updateUIComponent();
                updateHoldState(true);
                break;
            case 5:
                this.mCallState = 5;
                updateUIComponent();
                updateMuteState(true);
                break;
        }
        if (!this.mIsOutGoingCall) {
            if (this.mCallState == 1) {
                m2810a();
            } else {
                m2811b();
            }
        }
        m2802a("--current call state is " + CallState.getCallStateDescription(this.mCallState));
    }

    public void handleDelayedQuit() {
        handleImmediatelyQuit();
    }

    public abstract void handleEarphonePlugged(boolean z);

    public void handleImmediatelyQuit() {
        cancelDelayedQuit();
        this.mIsNormalTerminatingProcess = true;
        showCallEndAnimation();
        if (m2806e()) {
            return;
        }
        m2803b("haeri=screen is OFF!!!!!!!!!!!!!!!!!!!!!!");
        finish();
    }

    public abstract void handlePopupCloseForCallSwitch();

    public abstract void handleReceiveCallNetworkWeak(int i);

    public abstract void handleReceiveCallProposeRep(int i, int i2);

    public abstract void handleRecognitionEnd(TranslationDisplayData translationDisplayData);

    public abstract void handleRecognitionStart(TranslationDisplayData translationDisplayData);

    public abstract void handleRecognitionStop();

    public void handleStartShareScreen() {
        m2803b("<<YHT223>> handleStartShareScreen() finish activity!! " + this.mIsShareScreenCaller);
        Toast.makeText(this, "handleStartShareScreen", 1);
        if (this.mIsShareScreenCaller) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            startActivity(intent);
        }
        finish();
    }

    public abstract void handleTTSEnd(String str);

    public abstract void handleTTSStart(String str);

    public abstract void handleTranslationEnd(TranslationDisplayData translationDisplayData);

    public abstract void handleTranslationStart(TranslationDisplayData translationDisplayData);

    public abstract void hangupCall();

    protected void hangupCausedByTimeConstraint() {
    }

    public abstract void hangupEntitlement();

    public abstract void hangupLowBattery();

    public abstract void hangupNetworkErrorEntitlement();

    protected abstract void initActivity();

    public boolean initSTTTranslationTTS(RecognitionEngine recognitionEngine, TranslatorEngine translatorEngine, ITTSController iTTSController) {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().initSTTTranslationTTS(recognitionEngine, translatorEngine, iTTSController, this.mHandler, EventCode.EVENT_RECOGNITION_START, EventCode.EVENT_RECOGNITION_END, EventCode.EVENT_RECOGNITION_STOP, EventCode.EVENT_TRANSLATION_START, EventCode.EVENT_TRANSLATION_END, EventCode.EVENT_TTS_START, EventCode.EVENT_TTS_STOP) : 1) == 0;
    }

    public boolean initSTTTranslationTTSLanguage(int i, int i2) {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().initSTTTranslationTTSLanguage(i, i2) : 1) == 0;
    }

    public boolean isActiveSTTTranslationTTS() {
        return MainApplication.mPhoneManager.getPhoneStateMachine().isActiveSTTTranslationTTS();
    }

    protected boolean isAutorotationActive() throws Settings.SettingNotFoundException {
        int i;
        try {
            i = Settings.System.getInt(getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            i = 0;
        }
        return i == 1;
    }

    protected boolean isChangeCarMode() {
        return this.mPreviousCarMode ? this.mUiModeManager.getCurrentModeType() != 3 : this.mUiModeManager.getCurrentModeType() == 3;
    }

    public boolean isChangeToConference() {
        return this.mIsChangeToConference;
    }

    public boolean isCradleMode() {
        return this.mUiModeManager.getCurrentModeType() == 3;
    }

    public boolean isLiveShare() {
        return this.mIsLiveShare;
    }

    public boolean isOutGoingCall() {
        return this.mIsOutGoingCall;
    }

    public boolean isTranslatableString(String str) {
        return C1248b.m2882a(str);
    }

    public boolean isUseFrontCamera() {
        return false;
    }

    public boolean isUseVideo() {
        return this.mUseVideo;
    }

    public void notiToUserDisconnectedInActivity() {
        if (this.mIsUpNomalTerminatingCall) {
            MainApplication.mPopupCreator.notifyDisconnect(this);
        }
    }

    public void notifyConsentAccept(int i, int i2, ConsentDisplayInfo consentDisplayInfo) {
        if (i2 == 1) {
            MainApplication.mPhoneManager.getPhoneStateMachine().notifyChangeCallType(false);
        } else {
            MainApplication.mPhoneManager.getPhoneStateMachine().notifyChangeCallType(true);
        }
    }

    public abstract void notifyConsentReject(int i, int i2, ConsentDisplayInfo consentDisplayInfo);

    public abstract void notifyConsentRequestAskReceive(int i, int i2, String str);

    protected void notifyHangupSoonCausedByTimeConstraint() {
    }

    protected abstract void notifyStopShareViewFailed();

    public abstract void offBTButton();

    public abstract void onBTButton();

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        m2803b("onCreate()++++++++++++++++++++++++++++++++++++++++++++++++");
        super.onCreate(bundle);
        this.f2876g = MainApplication.mNativeInterfaceCreator.createMotionListener();
        this.mUiModeManager = (UiModeManager) getSystemService("uimode");
        if (this.mUiModeManager.getCurrentModeType() == 3) {
            this.mPreviousCarMode = true;
        } else {
            this.mPreviousCarMode = false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(this.mCallStatusData);
        if (!checkCallInstanceNRefresh()) {
            finish();
            return;
        }
        m2803b("onCreate() : mCallID : " + this.mCallID);
        MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(this);
        m2803b("onCreate()-------------------------------------------------");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        m2803b("onDestroy()");
        dispose();
        this.f2876g.stopMotionCatch();
        this.f2876g = null;
        super.onDestroy();
        if (!this.mIsNormalTerminatingProcess && CallState.isDisconnected(this.mCallState)) {
            MainApplication.mPhoneManager.getHardwareManager().releaseAll(true, false);
        }
        if (!MainApplication.mConfig.getSipIdSendOnly().equals("")) {
            MainApplication.mPhoneManager.getConfigManager().requestReturnPhoneNoAsk();
        }
        m2805d();
        this.mUiModeManager = null;
        this.f2873a = null;
        this.f2874b = null;
        try {
            MainApplication.mContext.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        m2803b("onKeyDown : " + keyEvent.toString());
        switch (i) {
            case 24:
                if (CallState.isNotConnected(this.mCallState)) {
                    if (this.mIsOutGoingCall) {
                        m2808g();
                        return true;
                    }
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
                        return true;
                    }
                    MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingStream();
                    MainApplication.mPhoneManager.getPhoneStateMachine().notifyStopRingtone();
                    return true;
                }
                if (CallState.isConnected(this.mCallState)) {
                    m2808g();
                    return true;
                }
                break;
            case 25:
                if (CallState.isNotConnected(this.mCallState)) {
                    if (this.mIsOutGoingCall) {
                        m2809h();
                        return true;
                    }
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
                        return true;
                    }
                    MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingStream();
                    MainApplication.mPhoneManager.getPhoneStateMachine().notifyStopRingtone();
                    return true;
                }
                if (CallState.isConnected(this.mCallState)) {
                    m2809h();
                    return true;
                }
                break;
            case 79:
                if (keyEvent.isLongPress() && !this.mIsOutGoingCall) {
                    denyCall();
                    return true;
                }
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        m2803b("onKeyLongPress : ");
        if ((i != 25 && i != 24) || !CallState.isNotConnected(this.mCallState) || this.mIsOutGoingCall) {
            return super.onKeyLongPress(i, keyEvent);
        }
        if (!MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingStream();
            MainApplication.mPhoneManager.getPhoneStateMachine().notifyStopRingtone();
        }
        return true;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                if (!CallState.isDisconnected(this.mCallState)) {
                    return true;
                }
                cancelDelayedQuit();
                this.mIsNormalTerminatingProcess = true;
                return super.onKeyUp(i, keyEvent);
            case 24:
            case 25:
                if (!this.mIsOutGoingCall && CallState.isNotConnected(this.mCallState)) {
                    return true;
                }
                break;
            case 79:
                if (!keyEvent.isLongPress()) {
                    if (!CallState.isNotConnected(this.mCallState)) {
                        if (!CallState.isConnected(this.mCallState)) {
                            return false;
                        }
                        hangupCall();
                        return true;
                    }
                    if (this.mIsOutGoingCall) {
                        hangupCall();
                        return true;
                    }
                    receiveCall();
                    return true;
                }
                if (!this.mIsOutGoingCall) {
                    denyCall();
                    return true;
                }
                break;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        dismissEveryDialog();
        if (!this.mUseVideo) {
            setScreenLock(false);
        }
        super.onPause();
        MainApplication.mPhoneManager.getKeyGuardManager().updateKeyguardPolicy(!CallState.isDisconnected(this.mCallState));
        MainApplication.mPhoneManager.getKeyGuardManager().updateKeyguardLock(false);
        m2804c();
    }

    @Override // android.app.Activity
    protected void onResume() {
        m2803b("onResume()");
        if (MainApplication.mMainActivity != null) {
            MainApplication.mMainActivity.hideCallProgressDialog();
        }
        setScreenLock(true);
        if (this.mUiModeManager.getCurrentModeType() == 3) {
            this.mPreviousCarMode = true;
        } else {
            this.mPreviousCarMode = false;
        }
        MainApplication.mPhoneManager.getKeyGuardManager().updateKeyguardPolicy(CallState.isDisconnected(this.mCallState) ? false : true);
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.f2875f == null || new Date().getTime() - this.f2875f.getTime() <= 3000) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onStop() {
        if (!this.mUseVideo) {
            setScreenLock(false);
        }
        super.onStop();
    }

    public void playTTS(TranslationDisplayData translationDisplayData) {
        if (this.mDestination.getDestinationType() == 2) {
            MainApplication.mPhoneManager.getPhoneStateMachine().playTTS(translationDisplayData);
        }
    }

    protected void quitActivity() {
        m2802a("quitActivity()");
        Message message = new Message();
        message.what = 10;
        sendHandlerMessage(message, 0L);
    }

    public abstract void receiveCall();

    public void removeConferenceMember(String str) {
        if (this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5) {
            MainApplication.mPhoneManager.getPhoneStateMachine().removeConferenceMember(this.mDestination, str);
        }
    }

    protected abstract void removeRecordUI();

    public void restartCall() {
        cancelDelayedQuit();
        checkCallInstanceNRefresh();
        this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
        MainApplication.mPhoneManager.getPhoneStateMachine().setCallingActivity(this);
    }

    public boolean sendAcceptConsent(boolean z) {
        MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(this.mDestination, z);
        return false;
    }

    @Override // com.sds.coolots.call.CallingInterface
    public void sendHandlerMessage(Message message, long j) {
        if (this.mHandler != null) {
            if (j == 0) {
                this.mHandler.sendMessage(message);
            } else {
                this.mHandler.sendMessageDelayed(message, j);
            }
        }
    }

    public boolean sendRequestConsent(int i, int i2) {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().requestConsent(this.mDestination, i, i2) == 0) {
            return true;
        }
        m2803b("<CIH> sendRequestConsent() isSucess = false");
        Message message = new Message();
        message.what = EventCode.EVENT_DISMISS_CONSENT_DIALOG;
        this.mHandler.sendMessageDelayed(message, 300L);
        return false;
    }

    protected void sendShareViewAccept(boolean z) {
        m2802a("sendShareViewAccept()");
        MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(this.mDestination, z);
    }

    protected void sendShareViewEnd() {
        m2803b("sendShareViewEnd");
        if (this.mDestination.getDestinationType() == 2 || this.mDestination.getDestinationType() == 5 || this.mDestination.getDestinationType() == 4) {
            MainApplication.mPhoneManager.getPhoneStateMachine().finishShareView(this.mDestination, 3);
        }
    }

    protected void setCallDate(String str) {
        this.mCallDate = str;
    }

    public abstract void setDisplayDialog(int i);

    protected void setDuration(int i) {
        this.mDuration = i;
    }

    public abstract void setHideMe();

    public void setMuteState(boolean z) {
        this.mMuteOnBeforeHold = z;
        setMuteStateForVideo(z);
    }

    protected abstract void setMuteStateForVideo(boolean z);

    public void setPreviewGuideLineStatus(int i, int i2, int i3) {
        MainApplication.mPhoneManager.getPhoneStateMachine().setPreviewOutLineStatus(this.mDestination, i, i2, i3);
    }

    public boolean setRecognitionVoiceLanguage(int i) {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().setRecognitionVoiceLanguage(i) : 1) == 0;
    }

    public void setRetryCall(boolean z) {
        m2803b("[[[LHH]]] retryp Enter setRetryCall");
        if (this.mDestination.getDestinationType() == 4 && this.mDestination.getConferenceMember().size() == 0) {
            MainApplication.mPopupCreator.notifyConferenceFinish(this);
            return;
        }
        if (this.mDestination.getDestinationType() == 5 && this.mDestination.getP2PConferenceMember().size() == 0) {
            MainApplication.mPopupCreator.notifyConferenceFinish(this);
            return;
        }
        m2803b("[[[LHH]]] retryp call set");
        this.mRetryCall = true;
        this.isAlreadySendPlaceCall = false;
        this.mRetryVideo = z;
    }

    public void setScreenLock(boolean z) {
        m2803b("setScreenLock()");
        CallActivity callActivity = (CallActivity) MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity();
        if (callActivity == null) {
            return;
        }
        int callState = callActivity.getCallState();
        if (!z) {
            if (CallState.isDisconnected(callState)) {
                MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
            }
        } else if ((CallState.isCalling(callState) && callActivity.isOutGoingCall()) || CallState.isConnected(callState)) {
            callActivity.isUseVideo();
        }
    }

    public abstract void setShowMe();

    public abstract void showCallEndAnimation();

    public abstract void showCallHoldOnStateToast();

    public abstract void showCallHoldRetrievedStateToast();

    public abstract void showCallIncomingAnimation();

    public abstract void showConnectDialog(int i);

    public abstract void showCreateRejectMsgDialog();

    public abstract void showDialPad(boolean z);

    public abstract void showToastForShareView(int i, String str);

    public void startHideMeVideoCall(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        MainApplication.mPhoneManager.getPhoneStateMachine().startHideMeVideoCall(this.mDestination, byteBuffer, i, i2, i3, i4, z, z2);
    }

    public void startHold() {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(this.mDestination);
        }
    }

    public void startMute() {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(this.mDestination);
        }
    }

    protected void startOutGoingCallForEngine() {
        if (this.mDestination.getDestinationType() == 2 && this.mIsOutGoingCall && CallState.isCalling(this.mCallState) && !this.isAlreadySendPlaceCall) {
            MainApplication.mPhoneManager.getPhoneStateMachine().startOutgoingCallForEngine();
            Log.m2958e("startOutGoingCallForEngine");
            this.isAlreadySendPlaceCall = true;
        }
    }

    public boolean startRecognition() {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().startRecognition() : 1) == 0;
    }

    public boolean startRecordCall(String str) {
        String string = MainApplication.mResources.getStringCheckExternalStorage() != 0 ? getResources().getString(MainApplication.mResources.getStringCheckExternalStorage()) : "";
        if (!FileUtil.statusOfSDCard()) {
            Toast.makeText(this, string, 0).show();
            return false;
        }
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().startRecordCall(this.mDestination, this.mUseVideo, str);
        return true;
    }

    public abstract void startRecordTime();

    public abstract void startShareView(boolean z);

    public boolean startTTSMode() {
        if (this.mDestination.getDestinationType() == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().startTTSMode();
        }
        return false;
    }

    public boolean startTranslation(TranslationDisplayData translationDisplayData) {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().startTranslation(translationDisplayData) : 1) == 0;
    }

    public void stopHideMeVideoCall() {
        MainApplication.mPhoneManager.getPhoneStateMachine().stopHideMeVideoCall(this.mDestination);
    }

    public void stopHold() {
        MainApplication.mPhoneManager.getPhoneStateMachine().unHoldCall(this.mDestination);
    }

    public void stopMute() {
        if (this.mCallState == 5) {
            MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(this.mDestination);
        }
    }

    public boolean stopRecognition() {
        return (this.mDestination.getDestinationType() == 2 ? MainApplication.mPhoneManager.getPhoneStateMachine().stopRecognition() : 1) == 0;
    }

    public abstract void stopRecord();

    public void stopRecordCall() {
        if (CallState.isConnected(this.mCallState) || CallState.isDisconnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopRecordCall(this.mDestination);
        }
    }

    public abstract void stopRecordFromEngine();

    public abstract void stopRecordingForCallSwitching();

    public abstract void stopShareView();

    public boolean stopTTSMode() {
        if (this.mDestination.getDestinationType() == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().stopTTSMode();
        }
        return false;
    }

    public abstract void toggleCamera();

    protected abstract void updateHoldState(boolean z);

    protected abstract void updateMuteState(boolean z);

    protected abstract void updateUIComponent();

    public abstract void updateUserAddedInfo(Destination destination, String str);
}
