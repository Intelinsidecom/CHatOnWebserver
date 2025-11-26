package com.coolots.chaton.call.view;

import android.R;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.app.StatusBarManager;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.IWindowManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.CoolotsChatOn;
import com.coolots.chaton.buddy.BuddyManagerInterface;
import com.coolots.chaton.call.controller.BargeInController;
import com.coolots.chaton.call.controller.IBargeInListener;
import com.coolots.chaton.call.controller.InviteViewController;
import com.coolots.chaton.call.controller.MemberViewController;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.model.CallUserAddedInfo;
import com.coolots.chaton.call.model.ConferenceCallDisplayUserInfo;
import com.coolots.chaton.call.util.ChatOnTTSPlayer;
import com.coolots.chaton.call.util.DestinationUtil;
import com.coolots.chaton.call.util.ITranslatorDialog;
import com.coolots.chaton.call.view.layout.video.DualCameraPreviewInfo;
import com.coolots.chaton.call.view.layout.video.VideoCallStatusBar;
import com.coolots.chaton.call.view.layout.voice.VoiceCallMemberLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallProximityEnd;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.controller.translation.RecognitionEngineVoice;
import com.coolots.chaton.common.controller.translation.TTSController;
import com.coolots.chaton.common.controller.translation.TranslatorEngineChangsin;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.coolots.chaton.common.util.BatteryInfo;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ModelCreator;
import com.coolots.chaton.common.util.ModelInfomation;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.coolots.chaton.common.view.layout.TimerDialog;
import com.coolots.chaton.setting.data.ChatONSettingData;
import com.coolots.chaton.setting.view.rejectmsg.ChatONRejectMsgEditActivity;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.cover.Scover;
import com.samsung.android.sdk.cover.ScoverManager;
import com.samsung.android.sdk.cover.ScoverState;
import com.samsung.android.service.gesture.GestureEvent;
import com.samsung.android.service.gesture.GestureListener;
import com.samsung.android.service.gesture.GestureManager;
import com.samsung.vip.engine.VIRecognitionLib;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.model.P2PUserInfo;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.util.FileUtil;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ChatOnCallActivity extends CallActivity implements DisposeInterface, IBargeInListener, GestureManager.ServiceConnectionListener, GestureListener, ITranslatorDialog {
    protected static final int ANIMATION_TYPE_CAPTURE = 1;
    protected static final int ANIMATION_TYPE_ENDCALL = 0;
    protected static final String AUTO_MODE = "answeringmode_auto_mode";
    protected static final String AUTO_TIME = "answeringmode_auto_time";
    public static final int BLUETOOTH_DIM = 2;
    public static final int BLUETOOTH_OFF = 0;
    public static final int BLUETOOTH_ON = 1;
    private static final String CHARACTER_SET = "KSC5601";
    private static final String CLASSNAME = "[ChatOnCallActivity]";
    protected static final String CLEAR_COVER_OPEN = "com.samsung.cover.OPEN";
    private static final int DIALOG_NOT_ENOUGH_MEMORY_TO_WRITE = 1;
    protected static final int DIALOG_SHARE_SCREEN_COPYRIGHT = 21;
    private static final int DIALOG_VOICE_RECORD_SAVED = 20;
    private static final int MAX_STRING_BYTE = 80;
    public static final int UPDATE_CALL_BUTTON_STATE = 2000;
    private static final int mLowBatteryLvl = 15;
    protected BargeInController mBargeInController;
    private DualCameraPreviewInfo mDualCameraPreveiwInfo;
    public Chronometer mElapsedTimePublic;
    private GestureManager mGestureManager;
    protected int mGuestLanguageCode;
    protected int mHostLanguageCode;
    protected InviteViewController mInviteViewCtrl;
    protected MemberViewController mMemberViewCtrl;
    protected ViewGroup mMemberViewLayout;
    protected ModelInfomation mModelInfo;
    protected Scover mSCover;
    protected ScoverManager mSCoverManager;
    protected CallUserAddedInfo mUserAddedInfo;
    protected int middleLangCode;
    protected int topLangCode;
    public static long dNow = -1;
    public static Long mPublicTime = null;
    public static boolean mSwitchCall = false;
    protected boolean mIsTranslatorOptionMenuEnable = false;
    protected boolean mAutoReceiveCnt = false;
    protected String mFileName = "";
    private Dialog mShareScreenDialog = null;
    private TimerDialog mTimerDialog = null;
    protected int mAutoReceiveTime = -1;
    private BroadcastReceiver mReceiver = new PhoneAppBroadcastReceiver(this, null);
    protected ChatONDialog callSwtichingDialog = null;
    private AlertDialog callConsentRecordingDialog = null;
    protected int animationtype = -1;
    protected int mMemberCount = -1;
    private EditBoxHandler mEditBoxHandler = new EditBoxHandler();
    protected Toast mToast = null;
    protected Toast mLongToast = null;
    private boolean mNetworkWeakPopup = false;
    private ProgressDialog mCallScreenDialog = null;
    protected Dialog mConsentUserActionDialog = null;
    protected ProgressDialog mCallConsentProgressDialog = null;
    private BuddyManagerInterface mBuddyManager = null;
    protected DestinationUtil mDestinationUtil = new DestinationUtil();
    private CountDownTimer mCountDown = null;
    private String mSetProvider = null;
    private NotificationManager mNotificationManager = null;
    private ActivityManager mActivityManager = null;
    private boolean showQuickPanel = false;
    protected boolean mIsCallHoldOn = false;
    public boolean mIsLowBattSwitchCall = false;
    protected int mHostLangCode = 10;
    protected int mTheOherPartyLangCode = 20;
    protected boolean mIsTranslatorIncomingMsgOnlyChecked = false;
    private IWindowManager mWindowManager = null;
    private final BroadcastReceiver mDockReceiver = new BroadcastReceiver() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ChatOnCallActivity.this.logI("DockReceiver : RESULT_CANCELED during call");
            setResultCode(0);
        }
    };
    private SpeakerSetHandler mSpeakerSetHandler = null;
    StatusBarManager mStatusBarManager = null;
    private Handler mCallAnswerHomeKeyChangeHandler = new Handler() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.2
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ChatOnCallActivity.this.logI("mAnswerCallKeyChangeHandler call: " + msg.what);
            ChatOnCallActivity.this.checkHookingHomeKey(true);
        }
    };
    private Handler mCallEndPowerKeyChangeHandler = new Handler() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.3
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ChatOnCallActivity.this.logI("mEndCallKeyChangeHandler call: " + msg.what);
            ChatOnCallActivity.this.checkHookingPowerKey(true);
        }
    };
    public BroadcastReceiver mEarPhoneEventReceiver = new BroadcastReceiver() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent event = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (event != null) {
                ChatOnCallActivity.this.logI("event event.getAction()" + event.getAction() + " event.getKeyCode(): " + event.getKeyCode() + "event.isLongPress() : " + event.isLongPress());
                if (event.getAction() == 1) {
                    if (event.getKeyCode() == 79) {
                        if (event.isLongPress()) {
                            if (!ChatOnCallActivity.this.mIsOutGoingCall) {
                                ChatOnCallActivity.this.denyCall();
                            }
                        } else if (CallState.isNotConnected(ChatOnCallActivity.this.mCallState)) {
                            if (ChatOnCallActivity.this.mIsOutGoingCall) {
                                ChatOnCallActivity.this.hangupCall();
                            } else {
                                ChatOnCallActivity.this.receiveCall();
                            }
                        } else if (CallState.isConnected(ChatOnCallActivity.this.mCallState)) {
                            ChatOnCallActivity.this.hangupCall();
                        }
                    }
                    abortBroadcast();
                    return;
                }
                if (event.getAction() == 0) {
                    if (event.getKeyCode() == 79 && event.isLongPress() && !ChatOnCallActivity.this.mIsOutGoingCall) {
                        ChatOnCallActivity.this.denyCall();
                    }
                    abortBroadcast();
                }
            }
        }
    };
    private Handler mAlertsOnCallChangeHandler = new Handler() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.5
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ChatOnCallActivity.this.logI("mAlertsOnCallChangeHandler - got message");
            try {
                if (ChatOnCallActivity.this.mStatusBarManager == null) {
                    ChatOnCallActivity.this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
                }
                ChatOnCallActivity.this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(VIRecognitionLib.VI_EQ_ENGINE_RAM_SIZE, !ChatONSettingData.getInstance().isAlertsOnCall()));
            } catch (NoSuchMethodError e) {
                ChatOnCallActivity.this.logE(e.toString());
            } catch (SecurityException e2) {
                ChatOnCallActivity.this.logE(e2.toString());
            }
        }
    };
    private AlertDialog mCreateRejectMsgDialog = null;
    Notification mBluetoothNotification = null;
    private boolean isGestureDone = false;

    public abstract void accpetNativeCall();

    public abstract void airCallHandShape();

    public abstract void airCallSweepRight();

    public abstract void cancelSlectedThemeShot();

    public abstract void closeThemeShotEmotionalAnimation();

    public abstract void displayShareScreenAttention();

    public abstract long getNowDateSetting();

    public abstract void hideNativeCallLayout();

    public abstract void initPinchZoomControllerSwitchCamera();

    public abstract boolean isCartoonView();

    public abstract boolean isRecordingVideo();

    public abstract boolean isShowingAnimationMenu();

    public abstract void makeHideMeImage();

    public abstract void rejectRecordCall();

    public abstract void setAlterImage();

    public abstract void setClearCover();

    public abstract void setHangUpCallUI();

    public abstract void setMenuBtnEnable(boolean z);

    public abstract void setOptionMenu(int i);

    public abstract void setOptionMenuDialog(int i);

    public abstract void setRecordStatement();

    public abstract void setRecordStatus(boolean z);

    public abstract void startFadeInAnimation();

    public abstract void startFadeOutAnimation();

    public abstract void startRecordCallAfterConsent();

    public abstract void updateChangeCall();

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int dialogId, Bundle args) {
        switch (dialogId) {
            case 1:
                this.mTimerDialog = new TimerDialog(this);
                this.mTimerDialog.setData(((Object) getResources().getText(C0000R.string.dialog_not_enough_memory_to_recording_save1)) + "\n" + this.mFileName + "\n" + ((Object) getResources().getText(C0000R.string.dialog_not_enough_memory_to_recording_save2)), 2000);
                this.mTimerDialog.show();
                break;
            case 20:
                showToast(String.valueOf(this.mFileName) + "\n" + getResources().getString(C0000R.string.call_recording_saved));
                break;
            case 21:
                ChatONDialog.Builder builder = new ChatONDialog.Builder(this);
                builder.setTitle(getResources().getText(C0000R.string.screenshare_alertView_attention_title));
                builder.setMessage(getResources().getText(C0000R.string.screenshare_attention_body));
                builder.setPositiveButton(C0000R.string.ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        ((ChatOnConfigInterface) MainApplication.mConfig).setShareScreenCopyRight(true);
                        ChatOnCallActivity.this.displayShareScreenAttention();
                    }
                });
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                    }
                });
                this.mShareScreenDialog = builder.create();
                this.mShareScreenDialog.show();
                return this.mShareScreenDialog;
        }
        return super.onCreateDialog(dialogId, args);
    }

    private boolean requestSystemKeyEvent(int keyCode, boolean request) {
        boolean result = false;
        try {
            if (this.mWindowManager == null) {
                this.mWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
            }
            if (this.mWindowManager != null) {
                logI("requestSystemKeyEvent() " + request);
                result = this.mWindowManager.requestSystemKeyEvent(keyCode, getComponentName(), request);
            }
        } catch (RemoteException e) {
            logE("requestSystemKeyEvent() RemoteException");
        } catch (NoSuchMethodError e2) {
            logE("requestSystemKeyEvent() NoSuchMethodError");
        }
        logI("requestSystemKeyEvent() KEYCODE " + keyCode + " Result " + result);
        return result;
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logI("onCreate()+++++++++++++++++++++++++++++++++++++++++++");
        this.mBuddyManager = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager();
        if (checkCallInstance() == 1) {
            logE("checkCallInstance() is CHECK_CALLINSTANT_TO_CREATE_ACTIVITY_FINISH");
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        if (this.mHandler == null) {
            logE("mHandler is null");
            this.mHandler = new ChatOnCallHandler(this);
        }
        if (this.mAudioPathController == null) {
            logE("mAudioPathController is null");
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        logI("mHandler: " + this.mHandler.toString());
        this.mAudioPathController.setUIHandler(this.mHandler);
        int displayWidth = getWindowManager().getDefaultDisplay().getWidth();
        int displayHeight = getWindowManager().getDefaultDisplay().getHeight();
        this.mModelInfo = ModelCreator.getModelInfo(displayWidth, displayHeight);
        if (!this.mIsOutGoingCall) {
            if (BargeInController.canIStart(this, isDrivingModeOn())) {
                this.mBargeInController = new BargeInController();
                this.mBargeInController.initBargeIn(this);
                showVoiceControlUserGuide();
            }
            if (this.mCallState == 1) {
                this.mGestureManager = new GestureManager(getApplicationContext(), this);
                this.mSetProvider = GestureManager.IR_PROVIDER;
            }
        }
        IntentFilter mediaFilter = new IntentFilter("android.intent.action.MEDIA_BUTTON");
        mediaFilter.setPriority(1);
        registerReceiver(this.mEarPhoneEventReceiver, mediaFilter);
        IntentFilter intentFilterDock = new IntentFilter();
        intentFilterDock.addAction(UiModeManager.ACTION_ENTER_CAR_MODE);
        intentFilterDock.addAction(UiModeManager.ACTION_ENTER_DESK_MODE);
        intentFilterDock.setPriority(1);
        registerReceiver(this.mDockReceiver, intentFilterDock);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction(CLEAR_COVER_OPEN);
        registerReceiver(this.mReceiver, intentFilter);
        setChcekAutoReceive();
        this.mSCover = new Scover();
        try {
            this.mSCover.initialize(this);
        } catch (SsdkUnsupportedException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        this.mSCoverManager = new ScoverManager(this);
        logI("onCreate()--------------------------------------------");
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void updateUserAddedInfo(Destination destination, String myDisplayName) {
        logI("updateUserAddedInfo");
        boolean isConference = isConference(destination);
        if (this.mUserAddedInfo == null) {
            this.mUserAddedInfo = new CallUserAddedInfo(isConference, destination, myDisplayName);
        } else {
            this.mUserAddedInfo.update(isConference, destination);
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        logI("onNewIntent()");
        if (intent.getBooleanExtra("IS_BEFORE_3GCALL", false)) {
            logI("processing after 3G call");
            updateAlertsOnCall(true);
            setForcedSpeakerModeDelay();
            if (MainApplication.mPhoneManager.getPhoneStateMachine().isPlayHoldTone()) {
                MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
            }
        }
        super.onNewIntent(intent);
    }

    private void setForcedSpeakerModeDelay() {
        SpeakerSetHandler speakerSetHandler = null;
        if (this.mSpeakerSetHandler != null) {
            this.mSpeakerSetHandler.dispose();
            this.mSpeakerSetHandler = null;
        }
        this.mSpeakerSetHandler = new SpeakerSetHandler(this, speakerSetHandler);
        this.mSpeakerSetHandler.sendEmptyMessageDelayed(0, 2000L);
    }

    private class SpeakerSetHandler extends Handler {
        private boolean mDispose;

        private SpeakerSetHandler() {
            this.mDispose = false;
        }

        /* synthetic */ SpeakerSetHandler(ChatOnCallActivity chatOnCallActivity, SpeakerSetHandler speakerSetHandler) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.mDispose) {
                if (ChatOnCallActivity.this.getAudioPathController() != null) {
                    ChatOnCallActivity.this.getAudioPathController().updateSpeakerMode();
                }
                ChatOnCallActivity.this.mSpeakerSetHandler.dispose();
                ChatOnCallActivity.this.mSpeakerSetHandler = null;
                super.handleMessage(msg);
            }
        }

        public void dispose() {
            ChatOnCallActivity.this.logI("dispose()");
            this.mDispose = true;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onResume() {
        logI("onResume()");
        try {
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            if (this.mStatusBarManager != null) {
                this.mStatusBarManager.hideCallView();
            }
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
            logE(e2.toString());
        }
        setChcekAutoReceive();
        MainApplication.mCallNotification.deleteCallNotification();
        if (this.mBargeInController != null) {
            this.mBargeInController.startBargeIn();
        }
        if (isAirGestureAcceptCallOn()) {
            registerListener(this.mSetProvider, GestureManager.AIR_MOTION_CALL_ACCEPT);
        }
        super.onResume();
    }

    public boolean isDrivingModeOn() {
        int driving_mode = Settings.System.getInt(getContentResolver(), "driving_mode_on", 0);
        return driving_mode != 0;
    }

    private boolean isDrivingModeChatONVTtsOn() {
        int chatonV_ttsMode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_chaton_call_notification", 0);
        logI("isDrivingModeChatONVTtsOn() = " + chatonV_ttsMode);
        return chatonV_ttsMode != 0;
    }

    public boolean isDrivingModeUIOn() {
        if (isDrivingModeOn() && isDrivingModeChatONVTtsOn()) {
            logI("isDrivingModeUIOn = true");
            return true;
        }
        logI("isDrivingModeUIOn = false");
        return false;
    }

    public boolean isAirGestureAcceptCallOn() {
        int air_gesture = Settings.System.getInt(getContentResolver(), "air_motion_engine", 0);
        int air_accept_call = Settings.System.getInt(getContentResolver(), GestureManager.AIR_MOTION_CALL_ACCEPT, 0);
        logI("isAirGestureAcceptCallOn air on??" + air_gesture + "/ accpt call?" + air_accept_call);
        return (air_gesture == 0 || air_accept_call == 0) ? false : true;
    }

    public boolean isAirGestureAcceptCallSpeakerOn() {
        int air_accept_call_speaker_on = Settings.System.getInt(getContentResolver(), "air_motion_call_accept_auto_start_speaker", 0);
        logI("isAirGestureAcceptCallSpeakerOn?" + air_accept_call_speaker_on);
        return air_accept_call_speaker_on != 0;
    }

    protected void checkHookingHomeKey(boolean isStart) {
        logI("checkHookingHomeKey(" + isStart + ")");
        if (isStart && CallState.isNotConnected(this.mCallState)) {
            requestSystemKeyEvent(3, true);
            ChatONSettingData.getInstance().registCallAnswerHomeKeyHandler(this.mCallAnswerHomeKeyChangeHandler);
        } else if (isCoverOpen()) {
            requestSystemKeyEvent(3, false);
            ChatONSettingData.getInstance().registCallAnswerHomeKeyHandler(null);
        } else {
            requestSystemKeyEvent(3, true);
        }
    }

    protected void checkHookingHomeKeyforCover(boolean isCoverOpen) {
        logI("checkHookingHomeKeyforCover(" + isCoverOpen + ")");
        if (isCoverOpen) {
            if (CallState.isNotConnected(this.mCallState)) {
                requestSystemKeyEvent(3, true);
                ChatONSettingData.getInstance().registCallAnswerHomeKeyHandler(this.mCallAnswerHomeKeyChangeHandler);
                return;
            } else {
                requestSystemKeyEvent(3, false);
                ChatONSettingData.getInstance().registCallAnswerHomeKeyHandler(null);
                return;
            }
        }
        requestSystemKeyEvent(3, true);
        ChatONSettingData.getInstance().registCallAnswerHomeKeyHandler(null);
    }

    protected void checkHookingPowerKey(boolean isStart) {
        logI("checkHookingPowerKey(" + isStart + ")");
        if (isStart) {
            if (CallState.isNotConnected(this.mCallState)) {
                requestSystemKeyEvent(26, true);
                return;
            } else if (ChatONSettingData.getInstance().isUseCallEndPowerKey()) {
                requestSystemKeyEvent(26, true);
                ChatONSettingData.getInstance().registCallEndPowerKeyHandler(this.mCallEndPowerKeyChangeHandler);
                return;
            }
        }
        requestSystemKeyEvent(26, false);
        ChatONSettingData.getInstance().registCallEndPowerKeyHandler(null);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        logI("onUserLeaveHint()");
        if (!CallState.isDisconnected(this.mCallState)) {
            logI("Statusbar Show QuickPanel!!!!!");
            this.showQuickPanel = true;
        }
        if (this.mBargeInController != null) {
            this.mBargeInController.pauseBargeIn();
        }
        super.onUserLeaveHint();
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onPause() {
        logI("onPause()");
        if (this.showQuickPanel || (isApplicationBroughtToBackground() && !isFinishing() && !MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall())) {
            logI("Statusbar Show QuickPanel!!!!!");
            this.showQuickPanel = false;
            MainApplication.mCallNotification.showCallButtonNotification();
        }
        if (isAirGestureAcceptCallOn()) {
            unregisterListener(this.mSetProvider);
        }
        super.onPause();
        if (isFinishCondition()) {
            logE("onPause() Activity is mismatch. Finish call activity!!");
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
            }
        }
    }

    private boolean isFinishCondition() throws SecurityException {
        if (this.mIsNormalTerminatingProcess) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
        List<ActivityManager.RunningTaskInfo> info = activityManager.getRunningTasks(1);
        for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
            if (runningTaskInfo.topActivity.getClassName().equals("com.coolots.chaton.call.view.VoiceCallActivity")) {
                logI("Current activity is VoiceCallActivity.");
                if (!(this instanceof VoiceCallActivity)) {
                    return true;
                }
            } else if (runningTaskInfo.topActivity.getClassName().equals("com.coolots.chaton.call.view.VideoCallActivity")) {
                logI("Current activity is VideoCallActivity.");
                if (!(this instanceof VideoCallActivity)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private boolean isApplicationBroughtToBackground() throws SecurityException {
        logI("isApplicationBroughtToBackground");
        if (this.mActivityManager == null) {
            this.mActivityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
        }
        List<ActivityManager.RunningTaskInfo> tasks = this.mActivityManager.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(MainApplication.mContext.getPackageName()) && !topActivity.getPackageName().equals("com.android.phone")) {
                return true;
            }
        }
        return false;
    }

    public boolean checkForegroundActivity() throws SecurityException {
        try {
            if (this.mActivityManager == null) {
                this.mActivityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
            }
            List<ActivityManager.RunningTaskInfo> runningtaskinfo = this.mActivityManager.getRunningTasks(1);
            ComponentName topActivity = runningtaskinfo.get(0).topActivity;
            String callClassName = MainApplication.mCallIntentGenerator.getCallClassName(this.mUseVideo, false, this.mDestination.getDestinationType() == 3);
            logI("checkForegroundActivity callClassname:  " + callClassName + ", class name:" + topActivity.getClassName());
            return topActivity.getClassName().equals(callClassName);
        } catch (Exception e) {
            logE("checkForegroundActivity exception :" + e);
            return true;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onStop() {
        logI("onStop()");
        super.onStop();
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onDestroy() {
        logI("onDestory()");
        if (CallState.isDisconnected(this.mCallState)) {
            MainApplication.mCallNotification.deleteCallNotification();
            setPublicBaseTime(0L);
        }
        try {
            unregisterReceiver(this.mEarPhoneEventReceiver);
        } catch (IllegalArgumentException e) {
            logE(e.toString());
        }
        this.mEarPhoneEventReceiver = null;
        try {
            unregisterReceiver(this.mDockReceiver);
        } catch (IllegalArgumentException e2) {
            logE(e2.toString());
        }
        try {
            unregisterReceiver(this.mReceiver);
        } catch (IllegalArgumentException e3) {
            logE(e3.toString());
        }
        this.mReceiver = null;
        dispose();
        super.onDestroy();
        this.mDestination = null;
    }

    public boolean isConference() {
        if (this.mDestination == null) {
            return false;
        }
        return this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5;
    }

    public boolean isConference(Destination destination) {
        if (destination == null) {
            return false;
        }
        return destination.getDestinationType() == 4 || destination.getDestinationType() == 5;
    }

    protected void checkNetworkDisconnect() {
        logE("<<YHT100>> checkNetworkDisconnect!!");
        if (CallState.isDisconnected(this.mCallState) && !this.mCallStatusData.is3GConnectType() && this.mCallStatusData.gethangupReason() == 300 && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
            logE("Wi-Fi disconnected on my phone");
            showToast(C0000R.string.popup_wifi_signal_weak);
            this.mNetworkDisconnect = false;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleDelayedQuit() {
        if (ischeckProximityLock()) {
            new VoiceCallProximityEnd().setProximityEndCall();
        }
        super.handleDelayedQuit();
    }

    private boolean ischeckProximityLock() {
        if (MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().getWakeLockForConnectedState() == null) {
            return false;
        }
        return MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().getWakeLockForConnectedState().isHeld();
    }

    public String getRecordFileName(boolean recordVideo, boolean captureImage) {
        File saveFolder;
        String fileName;
        this.mFileName = "";
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        if (recordVideo) {
            saveFolder = new File(FileUtil.VIDEO_SAVE_PATH);
        } else {
            saveFolder = new File(FileUtil.SAVE_PATH);
        }
        if (!saveFolder.exists()) {
            saveFolder.mkdirs();
        }
        if (saveFolder != null) {
        }
        if (recordVideo) {
            if (captureImage) {
                this.mFileName = "REC_VIDEO_" + df.format(now) + ".jpg";
            } else {
                this.mFileName = "REC_VIDEO_" + df.format(now) + ".mp4";
            }
            fileName = String.valueOf(FileUtil.VIDEO_SAVE_PATH) + File.separator + this.mFileName;
        } else {
            this.mFileName = ((Object) getText(C0000R.string.call_record_file_prefix)) + "_" + df.format(now) + ".amr";
            fileName = String.valueOf(FileUtil.SAVE_PATH) + File.separator + this.mFileName;
        }
        logE("fileName: " + fileName);
        return fileName;
    }

    public boolean captureImage() {
        if (!FileUtil.statusOfSDCard()) {
            showToast(getResources().getString(MainApplication.mResources.getStringCheckExternalStorage()));
            return false;
        }
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().captureImage(this.mDestination, getRecordFileName(true, true));
        logI("haeri capture media scanning!!!!!!!!");
        return true;
    }

    public boolean captureMyImage() {
        logI("captureMyImage()");
        if (!FileUtil.statusOfSDCard()) {
            showToast(getResources().getString(MainApplication.mResources.getStringCheckExternalStorage()));
            return false;
        }
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().captureMyImage(this.mDestination, String.valueOf(FileUtil.VIDEO_SAVE_PATH) + "/outgoing_take_picture.jpg");
        return true;
    }

    private void setChcekAutoReceive() {
        logI("setChcekAutoReceive()");
        this.mAutoReceiveTime = Settings.System.getInt(getContentResolver(), AUTO_TIME, 0);
    }

    public void autoReceiveCall() {
        if (this.mAutoReceiveTime != -1) {
            this.mAutoReceiveCnt = true;
            Message msg = new Message();
            msg.what = 100;
            sendHandlerMessage(msg, this.mAutoReceiveTime * 1000);
        }
    }

    public void cacelReceiveCall() {
        this.mAutoReceiveCnt = false;
        this.mHandler.removeMessages(100);
    }

    private class PhoneAppBroadcastReceiver extends BroadcastReceiver {
        private PhoneAppBroadcastReceiver() {
        }

        /* synthetic */ PhoneAppBroadcastReceiver(ChatOnCallActivity chatOnCallActivity, PhoneAppBroadcastReceiver phoneAppBroadcastReceiver) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                ChatOnCallActivity.this.logI("PhoneAppBroadcastReceiver() " + action);
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    if (intent.hasExtra("state")) {
                        if (intent.getIntExtra("state", 0) == 1) {
                            if (ChatOnCallActivity.this.mCallState == 1 && !ChatOnCallActivity.this.mIsOutGoingCall) {
                                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().startPeriodicCallWaitingTone();
                            }
                            if (ChatOnCallActivity.this.mAutoReceiveTime != -1 && ChatOnCallActivity.this.mAutoReceiveCnt) {
                                ChatOnCallActivity.this.autoReceiveCall();
                                return;
                            }
                            return;
                        }
                        MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopPeriodicCallWaitingTone();
                        ChatOnCallActivity.this.mAutoReceiveCnt = false;
                        return;
                    }
                    return;
                }
                if (action.equals("android.intent.action.BATTERY_LOW")) {
                    ChatOnCallActivity.this.logE(" ACTION_BATTERY_LOW");
                    ChatOnCallActivity.this.lowBatteryStatus();
                    return;
                }
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    ChatOnCallActivity.this.logE(" ACTION_POWER_CONNECTED");
                    ChatOnCallActivity.this.mIsLowBattSwitchCall = false;
                    ChatOnCallActivity.this.updateChangeCall();
                } else {
                    if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                        ChatOnCallActivity.this.logI("ACTION_MEDIA_BUTTON : call accept using earphone button");
                        if (CallState.isNotConnected(ChatOnCallActivity.this.mCallState) && !ChatOnCallActivity.this.mIsOutGoingCall) {
                            ChatOnCallActivity.this.logI("ACTION_MEDIA_BUTTON :accept call");
                            ChatOnCallActivity.this.receiveCall();
                            return;
                        }
                        return;
                    }
                    if (action.equals(ChatOnCallActivity.CLEAR_COVER_OPEN)) {
                        ChatOnCallActivity.this.setClearCover();
                    }
                }
            }
        }
    }

    protected void delayedSpeakerSetting() {
        logE("delayedSpeakerSetting()");
        Message msg = new Message();
        msg.what = 14;
        sendHandlerMessage(msg, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lowBatteryStatus() {
        Message msg = new Message();
        msg.what = 13;
        sendHandlerMessage(msg, 0L);
    }

    public boolean startRecordCall() {
        String fileName;
        logI("startRecordCall()");
        if (!FileUtil.statusOfSDCard()) {
            showToast(getResources().getString(MainApplication.mResources.getStringCheckExternalStorage()));
            return false;
        }
        if (!FileUtil.isBytesAvailableofSDCard()) {
            showToast(C0000R.string.video_record_memry_full);
            return false;
        }
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        if (this.mUseVideo) {
            fileName = getRecordFileName(true, false);
        } else {
            fileName = getRecordFileName(false, false);
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().startRecordCall(this.mDestination, this.mUseVideo, fileName);
        return true;
    }

    public void setEmotionalAnimation(int code, boolean repeat) {
        if (CallState.isConnected(this.mCallState)) {
            logE(" setEmotionalAnimation(): " + code);
            MainApplication.mPhoneManager.getPhoneStateMachine().setEmotionalAnimation(this.mDestination, code, repeat);
        }
    }

    public void setThemeShot(int titleNum, int index, boolean isSave) {
        if (CallState.isConnected(this.mCallState)) {
            logE(" setThemeShot(): " + titleNum + ", " + index);
            if (titleNum == 4 && index == 0) {
                MainApplication.mPhoneManager.getPhoneStateMachine().setThemeShot(this.mDestination, titleNum, 2, isSave);
            } else if (titleNum == 4 && index == 2) {
                MainApplication.mPhoneManager.getPhoneStateMachine().setThemeShot(this.mDestination, titleNum, 0, isSave);
            } else {
                MainApplication.mPhoneManager.getPhoneStateMachine().setThemeShot(this.mDestination, titleNum, index, isSave);
            }
        }
    }

    public boolean isThemeShotActive(int titleNum, int index) {
        if (!CallState.isConnected(this.mCallState)) {
            return false;
        }
        logE("isThemeShotActive(): " + titleNum + ", " + index);
        if (titleNum == 4 && index == 0) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().isThemeShotActive(titleNum, 2);
        }
        if (titleNum == 4 && index == 2) {
            return MainApplication.mPhoneManager.getPhoneStateMachine().isThemeShotActive(titleNum, 0);
        }
        return MainApplication.mPhoneManager.getPhoneStateMachine().isThemeShotActive(titleNum, index);
    }

    public void setCartoonView(int code) {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().setCartoonView(this.mDestination, code);
        }
    }

    public void setFaceEmotion(int code) {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().setFaceEmotion(this.mDestination, code);
        }
    }

    public void setEmotionalEyeContact(boolean useEyeContact) {
        if (CallState.isConnected(this.mCallState)) {
            MainApplication.mPhoneManager.getPhoneStateMachine().setEmotionalEyeContact(useEyeContact);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void dismissEveryDialog() {
        super.dismissEveryDialog();
        if (this.mTimerDialog != null && this.mTimerDialog.isShowing()) {
            this.mTimerDialog.dispose();
        }
        if (this.mShareScreenDialog != null && this.mShareScreenDialog.isShowing()) {
            this.mShareScreenDialog.dismiss();
        }
    }

    public String getUserName(String userID) {
        String userName = this.mUserAddedInfo.getUserDisplayNameByUserID(this.mDestination.getString());
        if (userName != null && !userName.isEmpty()) {
            logI("getUserName()1 name : " + userName);
            return userName;
        }
        String userName2 = "";
        if (this.mDestination.getDestinationType() == 4) {
            logI("mDestination.getDestinationType() = " + this.mDestination.getDestinationType());
            ArrayList<SimpleUserInfo> memberList = this.mDestination.getConferenceMember();
            Iterator<SimpleUserInfo> it = memberList.iterator();
            while (it.hasNext()) {
                SimpleUserInfo userInfo = it.next();
                if (userInfo.getUserID().equals(userID)) {
                    userName2 = userInfo.getUserName();
                }
            }
            logI("<CIH> userID = " + userID);
            logI("<CIH> MainApplication.mConfig.getProfileUserID() = " + MainApplication.mConfig.getProfileUserID());
            if (userID.equals(MainApplication.mConfig.getProfileUserID())) {
                userName2 = MainApplication.mConfig.getProfileUserName();
            }
        } else if (this.mDestination.getDestinationType() == 5) {
            userName2 = "";
            ArrayList<P2PUserInfo> memberList2 = this.mDestination.getP2PConferenceMember();
            Iterator<P2PUserInfo> it2 = memberList2.iterator();
            while (it2.hasNext()) {
                P2PUserInfo userInfo2 = it2.next();
                if (userInfo2.userID.equals(userID)) {
                    userName2 = userInfo2.userName;
                }
            }
        } else {
            userName2 = this.mCallStatusData.getHostDisplayName();
        }
        ChatONStringConvert.getInstance().removeFooter(userName2);
        logI("getUserName()2 name : " + userName2);
        return userName2;
    }

    public boolean isLowBattery() {
        BatteryInfo batteryInfo = new BatteryInfo();
        return !batteryInfo.isCharging() && batteryInfo.isLowBattery();
    }

    public synchronized void showToast(String message) {
        if (this.mToast == null) {
            this.mToast = Toast.makeText(this, "null", 0);
        }
        this.mToast.setText(message);
        this.mToast.show();
    }

    public synchronized void showLongToast(String message) {
        if (this.mLongToast == null) {
            this.mLongToast = Toast.makeText(this, "null", 1);
        }
        this.mLongToast.setText(message);
        this.mLongToast.show();
    }

    public synchronized void showLongToast(int rID) {
        showLongToast(getString(rID));
    }

    public synchronized void showToast(int rID) {
        if (this.mToast == null) {
            this.mToast = Toast.makeText(this, "null", 0);
        }
        this.mToast.setText(getString(rID));
        this.mToast.show();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coolots.chaton.call.view.ChatOnCallActivity$8] */
    public synchronized void showToast(int rID, int duration) {
        if (this.mToast == null) {
            this.mToast = Toast.makeText(this, "null", 0);
        }
        this.mToast.setText(getString(rID));
        this.mToast.setDuration(0);
        int length = duration + ErrorCode.DB_ERR_DATABASE_NOT_OPENED;
        if (length <= 0) {
            this.mToast.show();
        } else {
            this.mCountDown = new CountDownTimer(duration, 1000L) { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.8
                @Override // android.os.CountDownTimer
                public void onTick(long millisUntilFinished) {
                    if (ChatOnCallActivity.this.mToast != null) {
                        if (CallState.isDisconnected(ChatOnCallActivity.this.mCallState)) {
                            ChatOnCallActivity.this.mToast.cancel();
                        } else {
                            ChatOnCallActivity.this.mToast.show();
                        }
                    }
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                }
            }.start();
        }
    }

    public void receiveCallSwitchAsk(final int mediaType, String userID) throws Resources.NotFoundException {
        logE("receiveCallSwitchAsk(): " + mediaType + getUserName(userID));
        String message = "";
        if (mediaType == 1) {
            message = getResources().getString(C0000R.string.call_switch_alert_msg_video, getUserName(userID));
        } else if (mediaType == 2) {
            message = getResources().getString(C0000R.string.call_switch_alert_msg_voice, getUserName(userID));
        }
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(getResources().getString(C0000R.string.information_str_title_1));
        bld.setMessage(message);
        bld.setNegativeButton(getResources().getString(C0000R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                ChatOnCallActivity.this.sendAcceptConsent(false);
                ChatOnCallActivity.this.callSwtichingDialog = null;
            }
        });
        bld.setPositiveButton(getResources().getString(C0000R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                if (ChatOnCallActivity.this.isLowBattery() && mediaType == 2) {
                    ChatOnCallActivity.this.showToast(C0000R.string.callswitching_impossible_to_video_lowbattery);
                    ChatOnCallActivity.this.sendAcceptConsent(false);
                } else {
                    ChatOnCallActivity.this.sendAcceptConsent(true);
                }
                ChatOnCallActivity.this.callSwtichingDialog = null;
            }
        });
        this.callSwtichingDialog = bld.create();
        this.callSwtichingDialog.show();
    }

    public void receiveShareScreenAsk(String userID) {
        logE("receiveShareScreenAsk(): " + getUserName(userID));
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        bld.setTitle(getResources().getString(C0000R.string.information_str_title_1));
        bld.setMessage("Share Screen 요청을 수락하시겠습니까?");
        bld.setNegativeButton(getResources().getString(C0000R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.11
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                ChatOnCallActivity.this.sendAcceptConsent(false);
                ChatOnCallActivity.this.callSwtichingDialog = null;
            }
        });
        bld.setPositiveButton(getResources().getString(C0000R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                ChatOnCallActivity.this.sendAcceptConsent(true);
                ChatOnCallActivity.this.callSwtichingDialog = null;
            }
        });
        this.callSwtichingDialog = bld.create();
        this.callSwtichingDialog.show();
    }

    public void displayDialog(int dialogID) {
        if (dialogID == 10002) {
            showDialog(1);
        } else if (dialogID == 12222) {
            showDialog(20);
        } else if (dialogID == 21) {
            showDialog(21);
        }
    }

    public void updateAlertsOnCall(boolean isCallStart) {
        logI("updateAlertsOnCall(" + isCallStart + ")");
        if (isCallStart) {
            try {
                if (this.mStatusBarManager == null) {
                    this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
                }
                this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(VIRecognitionLib.VI_EQ_ENGINE_RAM_SIZE, !ChatONSettingData.getInstance().isAlertsOnCall()));
            } catch (NoSuchMethodError e) {
                logE(e.toString());
            } catch (SecurityException e2) {
                logE(e2.toString());
            }
            ChatONSettingData.getInstance().registAlertsOnCallHandler(this.mAlertsOnCallChangeHandler);
            return;
        }
        try {
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(VIRecognitionLib.VI_EQ_ENGINE_RAM_SIZE, false));
        } catch (NoSuchMethodError e3) {
            logE(e3.toString());
        } catch (SecurityException e4) {
            logE(e4.toString());
        }
        ChatONSettingData.getInstance().registAlertsOnCallHandler(null);
    }

    public long getGroupIDByUserInfo() {
        long groupID;
        ArrayList<String> userIDList;
        logI("getGroupIDByUserInfo()");
        if (this.mDestination.getGroupID() == 0) {
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            this.mCallState = callInfo.getCallState();
            logI("current call state: " + CallState.getCallStateDescription(this.mCallState));
            logI("call accept?: " + callInfo.isCallAccept());
            if (CallState.isConnected(this.mCallState)) {
                userIDList = this.mDestinationUtil.getConnectUserIDList(this.mDestination);
            } else if (CallState.isNotConnected(this.mCallState) && !isOutGoingCall()) {
                userIDList = this.mDestinationUtil.getConnectUserIDList(this.mDestination);
            } else if ((!CallState.isNotConnected(this.mCallState) || !isOutGoingCall()) && !callInfo.isCallAccept() && !isOutGoingCall()) {
                userIDList = this.mDestinationUtil.getConnectUserIDList(this.mDestination);
            } else {
                userIDList = this.mDestinationUtil.getAllConferenceMemberIDList(this.mDestination);
            }
            if (userIDList.isEmpty()) {
                logI("getGroupIDByUserInfo(): userIDList is empty");
                return 0L;
            }
            groupID = this.mBuddyManager.getGroupIDByUserIDList(userIDList);
            if (groupID == -1) {
                logI("getGroupIDByUserInfo() groupID = -1");
                return 0L;
            }
        } else {
            groupID = this.mDestination.getGroupID();
            logI("getGroupIDByUserInfo() groupID in Destination: " + groupID);
        }
        logI("getGroupIDByUserInfo() return groupID = " + groupID);
        return groupID;
    }

    public ConferenceCallDisplayUserInfo getConferenceMemberName() {
        logI("getConferenceMemberName()");
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        this.mCallState = callInfo.getCallState();
        logI("current call state: " + CallState.getCallStateDescription(this.mCallState));
        logI("call accept?: " + callInfo.isCallAccept());
        if (CallState.isConnected(this.mCallState)) {
            if (this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 0) {
                return null;
            }
            return this.mDestinationUtil.getConferenceConnectedMember(callInfo.getDestination(), this.mUserAddedInfo, true);
        }
        if (CallState.isNotConnected(this.mCallState) && !isOutGoingCall()) {
            return this.mDestinationUtil.getConferenceConnectedMember(callInfo.getDestination(), this.mUserAddedInfo, false);
        }
        if (CallState.isNotConnected(this.mCallState) && isOutGoingCall()) {
            return this.mDestinationUtil.getConferenceAllMemberNameCount(callInfo.getDestination(), this.mUserAddedInfo);
        }
        if (!callInfo.isCallAccept() && !isOutGoingCall()) {
            return this.mDestinationUtil.getConferenceConnectedMember(callInfo.getDestination(), this.mUserAddedInfo, false);
        }
        return this.mDestinationUtil.getConferenceAllMemberNameCount(callInfo.getDestination(), this.mUserAddedInfo);
    }

    public int getConferenceWaitCount() {
        return this.mDestinationUtil.getConferenceWaitCount(this.mDestination);
    }

    public int getConferenceConnectCount() {
        if (this.mDestination != null) {
            return this.mDestinationUtil.getConferenceConnectCount(this.mDestination);
        }
        return -1;
    }

    public int getWaitCountForHost() {
        return this.mDestinationUtil.getWaitCount();
    }

    public int getConnectCountForHost() {
        return this.mDestinationUtil.getConnectCount();
    }

    public boolean getHideState() {
        if (getCallFunctionController().getCallSwitchingProcessing() != 2 && getCallFunctionController().getCallSwitchingProcessing() != 1) {
            return false;
        }
        boolean hideState = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
        return hideState;
    }

    public void showBgActivity(boolean isRetryVideo) {
        Intent intent = new Intent(this, (Class<?>) RetryCallBGActivity.class);
        Bundle extras = new Bundle();
        extras.putBoolean("retry_call_bg_is_video_call", isRetryVideo);
        extras.putParcelable("retry_call_destination", this.mDestination);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void onClickMemberViewBack(View view) {
        logI("onClickMemberViewBack()");
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.endMemberView();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCreateRejectMsgDialog() {
        sendRejectMessage(null);
    }

    class EditBoxHandler extends Handler implements DisposeInterface {
        private boolean bDisposed = false;

        EditBoxHandler() {
        }

        @Override // com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            this.bDisposed = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (!this.bDisposed && msg != null && msg.what == 1000) {
                if (msg.arg2 > 0) {
                    ChatOnCallActivity.this.showToast(ChatOnCallActivity.this.getString(C0000R.string.reject_msg_edit_page_byte_info_noti, new Object[]{Integer.valueOf(ChatOnCallActivity.MAX_STRING_BYTE)}));
                }
                super.handleMessage(msg);
            }
        }
    }

    public CallDisplayUserInfo getCallOtherPartyUserInfo() {
        CallDisplayUserInfo info = new CallDisplayUserInfo();
        info.userID = this.mDestination.getString();
        info.userName = this.mUserAddedInfo.getUserDisplayNameByUserID(this.mDestination.getString());
        info.userStateMsg = this.mUserAddedInfo.getUserMessageByUserID(this.mDestination.getString());
        logI("getCallOtherPartyUserInfo() " + info.toString());
        return info;
    }

    public void showChangeToConferenceDialog() {
        logI("showChangeToConferenceDialog()");
        dismissChangeToConferenceDialog();
        this.mCallScreenDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
        this.mCallScreenDialog.setMessage(getString(C0000R.string.change_to_conference_wait));
        this.mCallScreenDialog.setIndeterminate(true);
        this.mCallScreenDialog.setCancelable(false);
        this.mCallScreenDialog.setCanceledOnTouchOutside(false);
        this.mCallScreenDialog.setIndeterminateDrawable(getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
        this.mCallScreenDialog.show();
    }

    protected void dismissChangeToConferenceDialog() {
        if (this.mCallScreenDialog != null) {
            this.mCallScreenDialog.dismiss();
            this.mCallScreenDialog = null;
        }
    }

    protected void notifySpeakerphone() {
        logI("notifySpeakerphone()");
        if (!CallState.isDisconnected(this.mCallState)) {
            try {
                if (this.mStatusBarManager == null) {
                    this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
                }
                this.mStatusBarManager.setIcon("speakerphone", R.drawable.stat_sys_speakerphone, 0, "스피커폰 활성화");
            } catch (NoSuchMethodError e) {
            } catch (SecurityException e2) {
                logE(e2.toString());
            }
        }
    }

    protected void cancelSpeakerphone() {
        try {
            logI("cancelSpeakerphone()");
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            this.mStatusBarManager.removeIcon("speakerphone");
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
            logE(e2.toString());
        }
    }

    public void notifyMute() {
        logI("notifyMute()");
        try {
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            this.mStatusBarManager.setIcon("mute", R.drawable.stat_notify_call_mute, 0, "음소거 활성화");
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
            logE(e2.toString());
        }
    }

    public void cancelMute() {
        try {
            logI("cancelMute()");
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            this.mStatusBarManager.removeIcon("mute");
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
            logE(e2.toString());
        }
    }

    protected void notifyBTHeadset() {
        logI("notifyBTHeadset()");
        String expandedTitle = getString(C0000R.string.bluetooth_headset);
        this.mBluetoothNotification = new Notification(MainApplication.mContext, C0000R.drawable.stat_sys_phone_call_bluetooth, null, 0L, expandedTitle, null, new Intent());
        this.mBluetoothNotification.flags = 2;
        if (this.mNotificationManager == null) {
            this.mNotificationManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        }
        this.mNotificationManager.notify(2, this.mBluetoothNotification);
    }

    protected void cancelBTHeadset() {
        logI("cancelBTHeadset()");
        if (this.mNotificationManager == null) {
            this.mNotificationManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        }
        this.mNotificationManager.cancel(2);
    }

    public HashMap<String, Long> getUserNoList() {
        return null;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        this.mAlertsOnCallChangeHandler = null;
        this.mCallAnswerHomeKeyChangeHandler = null;
        this.mCallEndPowerKeyChangeHandler = null;
        this.mUiModeManager = null;
        this.mAudioPathController = null;
        this.mCallDate = null;
        this.mCallStatusData = null;
        this.mBuddyManager = null;
        this.mDestinationUtil = null;
        this.mFileName = null;
        this.mHostDisplayName = null;
        this.mWindowManager = null;
        if (this.mCountDown != null) {
            this.mCountDown.cancel();
            this.mCountDown = null;
        }
        if (this.mToast != null) {
            this.mToast.cancel();
            this.mToast = null;
        }
        if (this.mLongToast != null) {
            this.mLongToast.cancel();
            this.mLongToast = null;
        }
        if (this.mEditBoxHandler != null) {
            this.mEditBoxHandler.dispose();
            this.mEditBoxHandler = null;
        }
        if (this.mCallScreenDialog != null) {
            this.mCallScreenDialog.dismiss();
            this.mCallScreenDialog = null;
        }
        if (this.mUserAddedInfo != null) {
            this.mUserAddedInfo.dispose();
            this.mUserAddedInfo = null;
        }
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        if (this.mGestureManager != null) {
            unregisterListener(this.mSetProvider);
            this.mGestureManager.unbindFromService();
            this.mGestureManager = null;
            this.mSetProvider = null;
        }
        if (this.mBluetoothNotification != null) {
            this.mBluetoothNotification = null;
        }
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        hideVoiceControlUserGuide();
        this.mStatusBarManager = null;
        this.mNotificationManager = null;
        this.mActivityManager = null;
    }

    public void notifyCallEndToOtherActivity() {
        Intent intent = new Intent(CoolotsChatOn.BROADCAST_CALL_END);
        sendBroadcast(intent);
    }

    public void handleConferenceChangeHold(ArrayList<String> userIDList) {
        logI("handleConferenceChangeHold()");
        String name = null;
        Iterator<String> it = userIDList.iterator();
        while (it.hasNext()) {
            String userID = it.next();
            name = this.mUserAddedInfo.getUserDisplayNameByUserID(userID);
        }
        showToast(String.valueOf(getString(C0000R.string.call_on_hold)) + " : " + name);
        this.mIsCallHoldOn = true;
    }

    public void handleConferenceChangeUnhold(ArrayList<String> userIDList) {
        logI("handleConferenceChangeUnhold()");
        String name = null;
        Iterator<String> it = userIDList.iterator();
        while (it.hasNext()) {
            String userID = it.next();
            name = this.mUserAddedInfo.getUserDisplayNameByUserID(userID);
        }
        showToast(String.valueOf(getString(C0000R.string.call_info_nofi_hold_release_message)) + " : " + name);
        this.mIsCallHoldOn = false;
    }

    public boolean checkDestinationForUIUpdate() {
        if (CallState.isCalling(this.mCallState) && isOutGoingCall()) {
            if (this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 0) {
                return false;
            }
        } else if (CallState.isCalling(this.mCallState) && !isOutGoingCall() && this.mDestinationUtil.getConferenceConnectCount(this.mDestination) == 0) {
            return false;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent event) {
        logI("dispatchKeyEvent()");
        if (event.getKeyCode() == 3) {
            if (event.getAction() == 0 && isCoverOpen() && !this.mIsOutGoingCall && ChatONSettingData.getInstance().isUseCallAnswerHomeKey()) {
                logI("dispatchKeyEvent()------KEYCODE_HOME");
                receiveCall();
            }
            return true;
        }
        if (event.getKeyCode() == 26 && event.getAction() == 0) {
            logI("dispatchKeyEvent()------KEYCODE_POWER");
            if (ChatONSettingData.getInstance().isUseCallEndPowerKey() && CallState.isConnected(this.mCallState)) {
                hangupCall();
            } else if (CallState.isNotConnected(this.mCallState) && !MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
                MainApplication.mPhoneManager.getHardwareManager().getSoundManager().stopRingStream();
                ScreenOff();
                checkHookingPowerKey(false);
            }
        }
        return super.dispatchKeyEvent(event);
    }

    private void ScreenOff() {
        logI("screenOff");
        PowerManager pm = (PowerManager) MainApplication.mContext.getSystemService("power");
        pm.goToSleep(SystemClock.uptimeMillis());
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleReceiveCallNetworkWeak(int bandWidth) {
        logI("handleReceiveCallNetworkWeak()");
        if (CallState.isConnected(this.mCallState)) {
            showToast(C0000R.string.popup_msg_network_weak_during_videocall_atnt, 5000);
            setNetworkWeakPopupExist(false);
        } else {
            setNetworkWeakPopupExist(true);
        }
    }

    public boolean showNetworkWeakPopup() {
        logI("showNetworkWeakPopup() retrun value?" + this.mNetworkWeakPopup);
        return this.mNetworkWeakPopup;
    }

    public void setNetworkWeakPopupExist(boolean exist) {
        logI("setNetworkWeakPopupExist() retrun value?" + exist);
        this.mNetworkWeakPopup = exist;
    }

    public void sendSelectedListIntent(int type, int resultType) {
        this.mInviteViewCtrl.sendSelectedListIntent(type, resultType, isConference(), this.mDestinationUtil, this.mDestination, this.mUserAddedInfo);
    }

    public void startDualCamera(int x, int y, int width, int height) {
        logE("startDualCamera() width = " + width + " height = " + height);
        if (width % 2 == 1) {
            width--;
        }
        if (height % 2 == 1) {
            height--;
        }
        MainApplication.mPhoneManager.getPhoneStateMachine().startDualCamera(this.mDestination, x, y, width, height);
    }

    public void stopDualCamera() {
        MainApplication.mPhoneManager.getPhoneStateMachine().stopDualCamera(this.mDestination);
    }

    public void switchDualCamera(int x, int y, int width, int height) {
        logE("switchDualCamera() width = " + width + " height = " + height);
        MainApplication.mPhoneManager.getPhoneStateMachine().switchDualCameraMode(this.mDestination, x, y, width, height);
    }

    public void setDualPosition(int x, int y, int width, int height) {
        logE("setDualPosition() width = " + width + " height = " + height);
        MainApplication.mPhoneManager.getPhoneStateMachine().setDualPosition(this.mDestination, x, y, width, height);
    }

    public void updateMemberCount() {
        if (CallState.isConnected(this.mCallState) && !this.mInviteViewCtrl.isActive() && isConference()) {
            this.mMemberCount = getConferenceConnectCount();
            logI("updateMemberCount() " + this.mMemberCount);
        }
    }

    protected void checkWaitMemberForInviteView() {
        this.mInviteViewCtrl.checkWaitMemberForInviteView(this.mCallState, isConference(), isOutGoingCall(), this.mDestinationUtil, this.mDestination, false, this.mUserAddedInfo, getCallOtherPartyUserInfo());
    }

    protected void checkInviteView() {
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.checkInviteView(this.mCallState, isConference(), isOutGoingCall(), this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, getCallOtherPartyUserInfo());
        }
    }

    protected void checkMemberView() {
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.checkMemberView(this.mDestination, this.mUserAddedInfo);
        }
    }

    protected void startMemberView(VideoCallStatusBar videoCallStatusBar) {
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.startMemberView(this.mIsOutGoingCall, this.mDestination, this.mUserAddedInfo, videoCallStatusBar);
        }
    }

    protected void startMemberView(VoiceCallMemberLayout voiceCallStatusBar) {
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.startMemberView(this.mIsOutGoingCall, this.mDestination, this.mUserAddedInfo, voiceCallStatusBar);
        }
    }

    protected void endMemberView() {
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.endMemberView();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public boolean isChangeToConference() {
        return this.mIsChangeToConference;
    }

    public void sendRejectMessage(String rejectMsg) {
        String userID = "";
        short deviceID = 0;
        String userName = "";
        if (isConference()) {
            Iterator it = this.mDestination.getConferenceMember().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SimpleUserInfo userInfo = (SimpleUserInfo) it.next();
                if (SimpleUserInfo.TYPE_HOST.equals(userInfo.getUserType())) {
                    userID = userInfo.getUserID();
                    deviceID = userInfo.getDeviceID().shortValue();
                    userName = userInfo.getUserName();
                    break;
                }
            }
        } else {
            userID = this.mDestination.getPhoneNo();
            deviceID = this.mDestDeviceID;
            userName = getCallOtherPartyUserInfo().userName;
        }
        if (rejectMsg != null && !rejectMsg.isEmpty()) {
            MainApplication.mPhoneManager.getPhoneStateMachine().sendRejectMessage(userID, deviceID, rejectMsg, userName);
            return;
        }
        Intent intent = new Intent(MainApplication.mContext, (Class<?>) ChatONRejectMsgEditActivity.class);
        intent.addFlags(805306368);
        Bundle extras = new Bundle();
        extras.putBoolean(ChatONRejectMsgEditActivity.EXTRAS_KEY_SEND_MSG, true);
        extras.putString(ChatONRejectMsgEditActivity.EXTRAS_KEY_USERID, userID);
        extras.putShort(ChatONRejectMsgEditActivity.EXTRAS_KEY_DEVICEID, deviceID);
        extras.putString(ChatONRejectMsgEditActivity.EXTRAS_KEY_USERNAME, userName);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void setInviteProcessing(boolean value) {
        if (getCallFunctionController() != null) {
            getCallFunctionController().setInviteProcessing(value);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void notifyStopShareViewFailed() {
        showToast(C0000R.string.sharecamera_failed_to_exit);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleReceiveCallProposeRep(int result, int type) {
        if (result == 0) {
            switch (type) {
                case 1:
                    dismissCallConsentProcessingDialog();
                    break;
                case 2:
                    dismissCallConsentProcessingDialog();
                    break;
                case 3:
                    dismissCallConsentProcessingDialog();
                    break;
                case 4:
                    dismissCallConsentProcessingDialog();
                    break;
                case 5:
                    dismissCallConsentProcessingDialog();
                    break;
            }
        }
    }

    public void showCallConsentUserActionDialog(final int consentType, final int consentOption, String requesterID) {
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        ChatONDialog.Builder bld = new ChatONDialog.Builder(this);
        switch (consentType) {
            case 1:
                if (consentOption == 1) {
                    bld.setMessage(getString(C0000R.string.call_switch_alert_msg_video, new Object[]{getUserName(requesterID)}));
                    break;
                } else if (consentOption == 2) {
                    bld.setMessage(getString(C0000R.string.call_switch_alert_msg_voice, new Object[]{getUserName(requesterID)}));
                    break;
                }
                break;
            case 2:
                bld.setMessage(getString(C0000R.string.share_view_other_party_accept_popup, new Object[]{"'" + getUserName(requesterID) + "'"}));
                break;
            case 3:
                this.mIsShareScreenCaller = false;
                bld.setMessage(getString(C0000R.string.screenshare_consent_popup, new Object[]{getUserName(requesterID)}));
                break;
            case 4:
                bld.setMessage(getString(C0000R.string.call_consent_alert_msg_record_video, new Object[]{getUserName(requesterID)}));
                break;
            case 5:
                ChatOnTTSPlayer chatOnTTSPlayer = new ChatOnTTSPlayer();
                chatOnTTSPlayer.startTTS(getString(C0000R.string.translator_accept_tts_message, new Object[]{getUserName(requesterID)}));
                int language = TranslationUtil.get2ndConsentParamLanguage(consentOption);
                bld.setMessage(getString(C0000R.string.translator_accept_message, new Object[]{getUserName(requesterID), TranslationUtil.toStringLanguage(language)}));
                break;
        }
        bld.setTitle(getResources().getString(C0000R.string.information_str_title_1));
        bld.setCancelable(true);
        bld.setNegativeButton(getResources().getString(C0000R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(ChatOnCallActivity.this.mDestination, false);
                ChatOnCallActivity.this.mConsentUserActionDialog = null;
            }
        });
        bld.setPositiveButton(getResources().getString(C0000R.string.confirm), new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int arg1) {
                if (consentType == 4 && consentOption == 2) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().sendNotifyStartVideoRecord();
                } else if (consentType == 1 && consentOption == 1) {
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
                        ChatOnCallActivity.this.stopRecordCall();
                    }
                    if (ChatOnCallActivity.this.mUseDualCamera) {
                        ChatOnCallActivity.this.stopDualCamera();
                    }
                } else if (consentType == 1 && consentOption == 2) {
                    if (ChatOnCallActivity.this.isLowBattery()) {
                        ChatOnCallActivity.this.showToast(C0000R.string.callswitching_impossible_to_video_lowbattery);
                        MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(ChatOnCallActivity.this.mDestination, false);
                        ChatOnCallActivity.this.mConsentUserActionDialog = null;
                        return;
                    }
                } else if (consentType == 5) {
                    ChatOnCallActivity.this.initSTTTranslationTTS();
                } else if (consentType == 3) {
                    ChatOnCallActivity.this.mIsShareScreenWaitForAccepting = true;
                }
                MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(ChatOnCallActivity.this.mDestination, true);
                ChatOnCallActivity.this.mConsentUserActionDialog = null;
            }
        });
        bld.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.15
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(ChatOnCallActivity.this.mDestination, false);
                ChatOnCallActivity.this.mConsentUserActionDialog = null;
            }
        });
        if (consentType == 1 && consentOption == 2 && (isChangeToConference() || isConference())) {
            MainApplication.mPhoneManager.getPhoneStateMachine().acceptConsent(this.mDestination, false);
            this.mConsentUserActionDialog = null;
        } else {
            logI("<CIH> showCallConsentUserActionDialog(), consentType = " + consentType);
            this.mConsentUserActionDialog = bld.create();
            this.mConsentUserActionDialog.setCanceledOnTouchOutside(false);
            this.mConsentUserActionDialog.show();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void dismissCallConsentUserActionDialog() {
        logI("<CIH> dismissCallConsentUserActionDialog()");
        if (this.mConsentUserActionDialog != null) {
            this.mConsentUserActionDialog.dismiss();
            this.mConsentUserActionDialog = null;
        }
    }

    public void showCallConsentProcessingDialog(int consentType, int option) {
        logI("<CIH> showCallConsentProcessingDialog()");
        dismissConsentDialog();
        this.mCallConsentProgressDialog = new ProgressDialog(this, C0000R.style.ChatOnVProgress);
        switch (consentType) {
            case 1:
                if (option == 1) {
                    this.mCallConsentProgressDialog.setMessage(getString(C0000R.string.call_menu_switch_voicecall));
                    break;
                } else {
                    this.mCallConsentProgressDialog.setMessage(getString(C0000R.string.call_menu_switch_videocall));
                    break;
                }
            case 3:
                this.mCallConsentProgressDialog.setMessage(getString(C0000R.string.wait_other_party_confirm));
                break;
            case 5:
                this.mCallConsentProgressDialog.setMessage("번역을 대기중");
                break;
        }
        this.mCallConsentProgressDialog.setIndeterminate(true);
        this.mCallConsentProgressDialog.setCancelable(false);
        this.mCallConsentProgressDialog.setCanceledOnTouchOutside(false);
        this.mCallConsentProgressDialog.setIndeterminateDrawable(getResources().getDrawable(C0000R.drawable.chaton_ani_progress));
        this.mCallConsentProgressDialog.show();
    }

    public void dismissCallConsentProcessingDialog() {
        logI("<CIH> dismissCallConsentProcessingDialog()");
        if (this.mCallConsentProgressDialog != null) {
            this.mCallConsentProgressDialog.dismiss();
            this.mCallConsentProgressDialog = null;
        }
    }

    public ArrayList<String> getConferenceConnectUserIDList() {
        return this.mDestinationUtil.getConferenceConnectUserIDList(this.mDestination, null);
    }

    @Override // com.coolots.chaton.call.controller.IBargeInListener
    public void onResultBargeIn(int result) {
        if (result != 1) {
            if (result == 2) {
                denyCall();
                return;
            }
            return;
        }
        receiveCall();
    }

    public void registerListener(String provider, String eventType) {
        if (this.mGestureManager != null) {
            this.mGestureManager.registerListener(this, provider, eventType);
        }
    }

    public void unregisterListener(String provider) {
        if (this.mGestureManager != null) {
            this.mGestureManager.unregisterListener(this, provider);
        }
    }

    public void unregisterGestureManager() {
        logI("unregisterGestureManager()");
        if (this.mGestureManager != null) {
            unregisterListener(this.mSetProvider);
            this.mGestureManager.unbindFromService();
            this.mGestureManager = null;
            this.mSetProvider = null;
        }
    }

    @Override // com.samsung.android.service.gesture.GestureListener
    public void onGestureEvent(GestureEvent arg0) {
        logI("onGestureEvent() arg0.getEvent() = " + arg0.getEvent());
        switch (arg0.getEvent()) {
            case 0:
            case 1:
            case 3:
            case 4:
                if (!this.isGestureDone) {
                    if (isDrivingModeUIOn()) {
                        this.isGestureDone = true;
                    }
                    airCallSweepRight();
                    break;
                }
                break;
            case 6:
                if (!this.isGestureDone) {
                    this.isGestureDone = true;
                    airCallHandShape();
                }
                unregisterGestureManager();
                break;
        }
    }

    @Override // com.samsung.android.service.gesture.GestureManager.ServiceConnectionListener
    public void onServiceConnected() {
        if (isAirGestureAcceptCallOn()) {
            registerListener(this.mSetProvider, GestureManager.AIR_MOTION_CALL_ACCEPT);
        }
    }

    @Override // com.samsung.android.service.gesture.GestureManager.ServiceConnectionListener
    public void onServiceDisconnected() {
        unregisterListener(this.mSetProvider);
    }

    public boolean useDualCamera() {
        return this.mUseDualCamera;
    }

    public Locale getSVoiceLocale() {
        String sVoiceLocaleLanguage = Settings.System.getString(MainApplication.mContext.getContentResolver(), "voicetalk_language");
        logI("<CIH> sVoiceLocaleLanguage = " + sVoiceLocaleLanguage);
        if (sVoiceLocaleLanguage != null && !sVoiceLocaleLanguage.isEmpty()) {
            String[] locInfo = sVoiceLocaleLanguage.split("-");
            if (locInfo.length > 1) {
                return new Locale(locInfo[0], locInfo[1]);
            }
            return new Locale(locInfo[0]);
        }
        return Locale.getDefault();
    }

    public void changeLocale(Locale locale) {
        Resources res = MainApplication.mContext.getResources();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, res.getDisplayMetrics());
    }

    private void showVoiceControlUserGuide() {
        if (CallState.isNotConnected(this.mCallState)) {
            logI("showVoiceControlUserGuide()");
            if (this.mNotificationManager == null) {
                this.mNotificationManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
            }
            Locale systemLocale = MainApplication.mContext.getResources().getConfiguration().locale;
            Locale sVoiceLoc = getSVoiceLocale();
            changeLocale(sVoiceLoc);
            String strAnswer = getString(C0000R.string.button_to_answer);
            String strReject = getString(C0000R.string.call_swipe_left_message);
            changeLocale(systemLocale);
            String expandedTitle = getString(C0000R.string.voice_control);
            String expandedText = String.format(getString(C0000R.string.voice_control_incoming_call_msg_new), strAnswer, strReject);
            Notification notice = new Notification(C0000R.drawable.indicator_voice_talk, expandedText, System.currentTimeMillis());
            Intent intent = new Intent();
            PendingIntent launchIntent = PendingIntent.getActivity(MainApplication.mContext, 0, intent, 0);
            notice.setLatestEventInfo(MainApplication.mContext, expandedTitle, expandedText, launchIntent);
            this.mNotificationManager.notify(1, notice);
        }
    }

    public void hideVoiceControlUserGuide() {
        logI("hideVoiceControlUserGuide()");
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(1);
            this.mNotificationManager = null;
        }
    }

    public void initDualCameraPreviewInfo(VideoCallActivity activity) {
        this.mDualCameraPreveiwInfo = new DualCameraPreviewInfo(activity);
    }

    public void startDualCamera() {
        this.mDualCameraPreveiwInfo.setPreViewInfoForStartCamera();
        Point daulCameraPreivewPoint = this.mDualCameraPreveiwInfo.getPoint();
        startDualCamera(daulCameraPreivewPoint.y, daulCameraPreivewPoint.x, this.mDualCameraPreveiwInfo.getHeight(), this.mDualCameraPreveiwInfo.getWidth());
    }

    public void switchDualCamera() {
        this.mDualCameraPreveiwInfo.setPreViewInfoForSwitchCamera();
        Point daulCameraPreivewPoint = this.mDualCameraPreveiwInfo.getPoint();
        switchDualCamera(daulCameraPreivewPoint.y, daulCameraPreivewPoint.x, this.mDualCameraPreveiwInfo.getHeight(), this.mDualCameraPreveiwInfo.getWidth());
    }

    protected void setDualPositionForDualPosition(boolean isforce) {
        Point pre_peviewwPoint = this.mDualCameraPreveiwInfo.getPoint();
        this.mDualCameraPreveiwInfo.setPreViewInfoForDualPosition();
        Point preivewPoint = this.mDualCameraPreveiwInfo.getPoint();
        if ((pre_peviewwPoint.x != preivewPoint.x && pre_peviewwPoint.y != preivewPoint.y) || isforce) {
            setDualPosition(preivewPoint.y, preivewPoint.x, this.mDualCameraPreveiwInfo.getWidth(), this.mDualCameraPreveiwInfo.getHeight());
        }
    }

    public boolean isCoverOpen() {
        boolean result = true;
        if (Build.VERSION.SDK_INT >= 19) {
            if (this.mSCoverManager == null) {
                return true;
            }
            ScoverState coverState = this.mSCoverManager.getCoverState();
            if (coverState != null) {
                result = coverState.getSwitchState();
                logI("<CIH> width = " + coverState.getWindowWidth());
                logI("<CIH> height= " + coverState.getWindowHeight());
            } else {
                logI("<CIH> this device is not supported S View Cover");
            }
            this.mSCoverManager.getCoverState();
            if (!result) {
                logI("<CIH> close state");
                return result;
            }
            this.mSCoverManager.getCoverState();
            if (result) {
                logI("<CIH> open state");
                return result;
            }
            logI("<CIH> unknown state");
            return result;
        }
        if (this.mWindowManager == null) {
            this.mWindowManager = IWindowManager.Stub.asInterface(ServiceManager.getService("window"));
        }
        try {
            boolean result2 = this.mWindowManager.isCoverOpen();
            return result2;
        } catch (RemoteException e) {
            e.printStackTrace();
            return true;
        } catch (NoSuchMethodError e2) {
            e2.printStackTrace();
            return true;
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        logI("onConfigurationChanged()");
        if (MainApplication.mCallNotification.showQuickPanel()) {
            MainApplication.mCallNotification.showCallButtonNotification();
        }
        super.onConfigurationChanged(newConfig);
    }

    public Long getLayoutCallBaseTime() {
        if (mPublicTime != null && mPublicTime.longValue() != 0) {
            return mPublicTime;
        }
        mPublicTime = Long.valueOf(SystemClock.elapsedRealtime() - getNowDateSetting());
        InCallQuickPanel.callBaseTime = mPublicTime.longValue();
        return mPublicTime;
    }

    public static void setPublicBaseTime(Long baseTime) {
        mPublicTime = baseTime;
        InCallQuickPanel.callBaseTime = baseTime.longValue();
    }

    public void changeCoverLockUI(boolean isSuppress) {
        logI("changeCoverLockUI()");
        logI("changeCoverLockUI " + isSuppress);
        Intent mCallEndIntent = new Intent();
        mCallEndIntent.setAction("com.samsung.cover.STATE_CHANGE");
        mCallEndIntent.putExtra("suppressCoverUI", isSuppress);
        mCallEndIntent.putExtra("sender", "ChatOnVCoverMode");
        sendBroadcast(mCallEndIntent);
    }

    public void disableCoverLockUI(int delay) {
        logI("disableCoverLockUI()");
        if (CallState.isNotConnected(this.mCallState)) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.coolots.chaton.call.view.ChatOnCallActivity.16
                @Override // java.lang.Runnable
                public void run() {
                    if (!ChatOnCallActivity.this.isCoverOpen()) {
                        ChatOnCallActivity.this.changeCoverLockUI(true);
                    }
                }
            }, delay);
        }
    }

    protected boolean initSTTTranslationTTS() {
        RecognitionEngine recognitionEngine = new RecognitionEngineVoice();
        TranslatorEngine translatorEngine = new TranslatorEngineChangsin();
        TTSController ttsEngine = new TTSController();
        return initSTTTranslationTTS(recognitionEngine, translatorEngine, ttsEngine);
    }

    protected void initSTTTranslationTTSLanguage(boolean isRequester, int fistLanguage, int secondLanguage) {
        if (isRequester) {
            this.mHostLanguageCode = fistLanguage;
            this.mGuestLanguageCode = secondLanguage;
        } else {
            this.mHostLanguageCode = secondLanguage;
            this.mGuestLanguageCode = secondLanguage;
        }
        if (initSTTTranslationTTSLanguage(this.mHostLanguageCode, this.mGuestLanguageCode)) {
            CallStatusData callInfo = new CallStatusData();
            MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
            if (callInfo.getCallState() != 5) {
                startMute();
            }
        } else {
            showToast("음성인식 언어 설정 초기화 오류");
        }
        if (!startRecognition()) {
            showToast("음성인식 시작 오류");
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public boolean closeSTTTranslationTTS(boolean mySignOff) {
        if (!super.closeSTTTranslationTTS(mySignOff)) {
            return false;
        }
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.getCallState() == 5) {
            stopMute();
        }
        return true;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public Set<Integer> sendTranslatorHostLanguage(int hostLangCode) {
        return getTranslationSupportedOutLanguage(hostLangCode);
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public void sendTranslatorHostLanguageCode(int hostLangCode) {
        this.mHostLangCode = hostLangCode;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public int getTranslatorHostLanguageCode() {
        return this.mHostLangCode;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public void sendTranslatorTheOtherPartyLanguageCode(int theOherPartyLangCode) {
        this.mTheOherPartyLangCode = theOherPartyLangCode;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public int getTranslatorTheOherPartyLanguageCode() {
        return this.mTheOherPartyLangCode;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorDialog
    public void sendIncomingMsgOnly(boolean isChecked) {
        this.mIsTranslatorIncomingMsgOnlyChecked = isChecked;
    }

    public ModelInfomation getModelInfo() {
        return this.mModelInfo;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void dismissConsentDialog() {
        dismissCallConsentProcessingDialog();
        dismissCallConsentUserActionDialog();
    }
}
