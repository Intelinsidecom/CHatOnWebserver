package com.coolots.chaton.call.view;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.buddy.model.BuddyListChildItem;
import com.coolots.chaton.call.controller.ChatONBlueTooth;
import com.coolots.chaton.call.controller.IInviteViewController;
import com.coolots.chaton.call.controller.IMemberViewController;
import com.coolots.chaton.call.controller.InviteViewController;
import com.coolots.chaton.call.controller.MemberViewController;
import com.coolots.chaton.call.model.CallDisplayUserInfo;
import com.coolots.chaton.call.screenshare.ScreenShareService;
import com.coolots.chaton.call.util.BubbleTTSPlayer;
import com.coolots.chaton.call.util.ChatOnTranslationDataController;
import com.coolots.chaton.call.util.ITranslationTTSInterface;
import com.coolots.chaton.call.util.ITranslatorDialog;
import com.coolots.chaton.call.util.TranslatorViewController;
import com.coolots.chaton.call.view.layout.CallTranslatorScrollViewLayout;
import com.coolots.chaton.call.view.layout.EndedCallCoveredLayout;
import com.coolots.chaton.call.view.layout.EndedCallCoveredLayoutBig;
import com.coolots.chaton.call.view.layout.EndedCallCoveredWidget;
import com.coolots.chaton.call.view.layout.IncomingSlidingWidget;
import com.coolots.chaton.call.view.layout.IncomingSlidingWidgetCover;
import com.coolots.chaton.call.view.layout.IncomingSlidingWidgetCoverBig;
import com.coolots.chaton.call.view.layout.ShowCallMemberViewlayout;
import com.coolots.chaton.call.view.layout.SlidingWidgetCover;
import com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredVoiceCall;
import com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredVoiceCallBig;
import com.coolots.chaton.call.view.layout.voice.AcceptCallCoveredWidget;
import com.coolots.chaton.call.view.layout.voice.VoiceCallBtnLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallDrivingBtnLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallEndBtnLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallIncomingLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallMemberLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallTranslatorLayout;
import com.coolots.chaton.call.view.layout.voice.VoiceCallerImageLayout;
import com.coolots.chaton.calllog.CallLogManager;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.coolots.chaton.common.util.ChatONDialog;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.coolots.chaton.common.util.ChatONTranslatorChangeLanguageDialog;
import com.coolots.chaton.common.util.ChatONTranslatorDialog;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.common.util.ChatOnService;
import com.coolots.chaton.common.util.ViewRecycleUtil;
import com.coolots.chaton.common.view.layout.OptionMenuLayout;
import com.coolots.sso.util.ChatONInterface;
import com.google.protobuf.CodedOutputStream;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.entitlement.EntitlementController;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.ConsentDisplayInfo;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.call.view.CallActivity;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.ErrorCode;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.util.ModelInfoUtil;
import com.sds.coolots.common.util.PhoneNumberUtil;
import com.sds.coolots.common.view.DisposeInterface;
import com.sec.spp.push.Config;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class VoiceCallActivity extends ChatOnCallActivity implements DisposeInterface, Animation.AnimationListener, IInviteViewController, IMemberViewController, ITranslatorDialog, ITranslationTTSInterface {
    private static final int BLINK_DELAYED_CALL_END_BUTTON = 555;
    private static final int CLAER_COVER_CALL_SCREEN_DIM_DELAY = 0;
    private static final int CLAER_COVER_CALL_SCREEN_TIMEOUT = 8000;
    private static final String CLASSNAME = "[VoiceCallActivity]";
    private static final int RESULT_INVITE_BUDDY_DONE = 2;
    private static final int SAMSUNG_CALL_SCREEN_DIM_DELAY = 20000;
    private static final int SAMSUNG_CALL_SCREEN_TIMEOUT = 30000;
    private static final int TRANSLATOR_CHANGE_LANGUAGE_DIALOG = 999;
    private static final int TRANSLATOR_DIALOG = 99;
    private static String mBackupBaseTime = "BACKUPBASETIME";
    private static String mMenuOpen = "MENUOPEN";
    private boolean isConnectedCall;
    private boolean isHoldCall;
    private BubbleTTSPlayer mBubbleTTSPlayer;
    private VoiceCallBtnLayout mCallBtnLayout;
    private VoiceCallDrivingBtnLayout mCallDrivingBtnLayout;
    private VoiceCallEndBtnLayout mCallEndBtnLayout;
    private VoiceCallIncomingLayout mCallIncomingLayout;
    private CallLogManager mCallLogManager;
    private VoiceCallMemberLayout mCallMemberLayout;
    private IncomingSlidingWidget mCallReceiveBtnLayout;
    public CallTranslatorScrollViewLayout mCallTranslatorScrollViewLayout;
    private VoiceCallerImageLayout mCallerImageLayout;
    public CallDisplayUserInfo mCalluserInfo;
    private AcceptCallCoveredWidget mCoverAccpetCallLayout;
    private EndedCallCoveredWidget mCoverEndedLayout;
    private SlidingWidgetCover mCoverReceiveLayout;
    private FrameLayout mEndCallBackGround;
    private FrameLayout mFrameLayout1;
    private FrameLayout mFrameLayout2;
    private FrameLayout mFrameLayout3;
    private FrameLayout mFrameLayout4;
    private Toast mHoldRetrieveToast;
    private Toast mHoldToast;
    private InviteViewMemberLayout mIncomingInviteviewMemberLayout;
    private InviteViewMemberLayout mInviteviewMemberLayout;
    private LinearLayout mLineaLayout1;
    private FrameLayout mOnCallBackGround;
    public TranslatorViewController mTranslatorViewController;
    private VoiceCallTranslatorLayout mVoiceCallTranslatorLayout;
    private boolean PREV_LAYOUT = false;
    private boolean mClickVoiceGroupMemberActivity = false;
    public boolean mIsRecord = false;
    private Dialog mConnectFailDialog = null;
    private Dialog mTranslatorDialog = null;
    private Dialog mTranslatorChangeLanguageDialog = null;
    private Object hangupMutex = new Object();
    private Object mBackUpObj = null;
    private boolean mHangUpCall = false;
    private ChatOnTranslationDataController mChatOnTranslationDataController = new ChatOnTranslationDataController();
    private AudioManager mAudioManager = null;
    private InputMethodManager imm = null;
    private boolean mIsPowerLongPressed = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        logI("onCreate()++++++++++++++++++++++++++++++++++++++++");
        if (!isDrivingModeUIOn()) {
            setRequestedOrientation(5);
        }
        this.mHandler = new VoiceCallHandler(this);
        this.mCallLogManager = (CallLogManager) MainApplication.mPhoneManager.getCallLogManager();
        if (getIntent().getIntExtra(EventCode.EVENT_IDENTIFIER, -1) == 7300) {
            this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
        }
        super.onCreate(savedInstanceState);
        if (checkCallInstance() == 1) {
            logI("onCreate() check call instance()");
            finish();
            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                overridePendingTransition(0, 0);
                return;
            }
            return;
        }
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            setContentView(C0000R.layout.scamera_voice_call);
        } else {
            setContentView(C0000R.layout.voice_call);
        }
        getWindow().getDecorView().setSystemUiVisibility(CodedOutputStream.DEFAULT_BUFFER_SIZE);
        initActivity();
        hidekeyboard();
        this.mHangUpCall = false;
        logI("onCreate()-------------------------------------------");
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        logI("onNewIntent()");
        super.onNewIntent(intent);
        restartCall();
        resetLayoutData();
        dismissVoiceDialog();
        setCallerImageHandler();
        this.mHandler.removeMessages(BLINK_DELAYED_CALL_END_BUTTON);
        if (this.mHangUpCall) {
            if (CallState.isNotConnected(this.mCallState) || CallState.isDisconnected(this.mCallState)) {
                logI("finish() receive new intent!!!! ");
                finish();
                if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                    overridePendingTransition(0, 0);
                }
                Intent intents = MainApplication.mCallIntentGenerator.getCallIntent(this.mUseVideo, false, this.mDestination.getDestinationType() == 3);
                intents.putExtra(EventCode.EVENT_IDENTIFIER, EventCode.EVENT_CALL_ACTION);
                intents.setAction(CallActivity.getStringForEvent(EventCode.EVENT_CALL_ACTION));
                intents.addFlags(268435456);
                intents.addFlags(536870912);
                intents.addFlags(8388608);
                MainApplication.mContext.startActivity(intents);
            }
        }
    }

    private void resetLayoutData() {
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        logI("<CIH> resetLayoutData()");
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.removeImage();
            this.mCallerImageLayout.setMember(this.mDestination, this.mIsOutGoingCall);
        }
        if (this.mCallIncomingLayout != null) {
            this.mCallIncomingLayout.removeImage();
            this.mCallIncomingLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.setDestination(this.mDestination);
        }
        if (this.mCallBtnLayout != null) {
            if (this.mCallStatusData.getCallState() == 5) {
                this.mCallBtnLayout.updateMuteBackGround(true);
            } else {
                this.mCallBtnLayout.updateMuteBackGround(false);
            }
        }
    }

    public void updateActivityTimeout() {
        logI("updateActivityTimeout()");
        if (MainApplication.mConfig.isClearCover()) {
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            if (!isCoverOpen()) {
                lp.userActivityTimeout = 8000L;
                lp.screenDimDuration = 0L;
            } else {
                lp.userActivityTimeout = Config.CONNECTION_TIMEOUT;
                lp.screenDimDuration = 20000L;
            }
            getWindow().setAttributes(lp);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onResume() {
        logI("onResume()++");
        if (this.mClickVoiceGroupMemberActivity) {
            this.mClickVoiceGroupMemberActivity = false;
        }
        checkCallInstanceNRefresh();
        logI("ShareScreen-- mCallStatusData.isActiveShareScreen(): " + this.mCallStatusData.isActiveShareScreen());
        if (this.mCallStatusData.isActiveShareScreen() == 1) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        } else if (this.mCallStatusData.isActiveShareScreen() == 3) {
            sendBroadcast(new Intent(ScreenShareService.LOCK_SCREEN_UNLOCK));
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForShareScreenProximity();
        } else {
            updateProximity();
        }
        this.mIsCallHoldOn = this.mCallStatusData.isPlayHoldTone();
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setCallBtnUpdate(this.mCallState);
        }
        if (getCallFunctionController().getCallSwitchingProcessing() == 1) {
            updateUIComponent();
            getCallFunctionController().setCallSwitchingProcessing(0);
        }
        updateActivityTimeout();
        enableBtnForShareScreen();
        super.onResume();
        if (MainApplication.mPhoneManager.getClientType() != 2) {
            startOutGoingCallForEngine();
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setBtnClickable(true);
        }
        logI("onResume()--");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkHoldForScreenShare() {
        if (this.mCallStatusData != null && this.mCallerImageLayout != null) {
            if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
                this.mCallerImageLayout.setDisableHoldBtn(true);
            } else {
                this.mCallerImageLayout.setDisableHoldBtn(false);
            }
        }
    }

    private void enableBtnForShareScreen() {
        if (this.mCallBtnLayout != null) {
            if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
                this.mCallBtnLayout.setIsActiveShareScreen(true);
            } else {
                this.mCallBtnLayout.setIsActiveShareScreen(false);
            }
        }
        if (!MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext)) {
            cancelSpeakerphone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProximity() {
        logI("updateProximity()");
        if (this.mAudioManager == null) {
            this.mAudioManager = (AudioManager) MainApplication.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        }
        if ((isOutGoingCall() && !CallState.isDisconnected(this.mCallState)) || (!isOutGoingCall() && CallState.isConnected(this.mCallState))) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
        } else {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        logE("onWindowFocusChanged() hasFocus : " + hasFocus);
        if (!hasFocus && !checkForegroundActivity() && (CallState.isCalling(this.mCallState) || (CallState.isConnected(this.mCallState) && !MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()))) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(true);
            MainApplication.mCallNotification.showCallButtonNotification();
        } else if (hasFocus) {
            MainApplication.mCallNotification.deleteCallNotification();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onPause() {
        logI("onPause()");
        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        super.onPause();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onStop() {
        logI("onStop()");
        super.onStop();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity
    protected void onUserLeaveHint() {
        logI("onUserLeaveHint()");
        closeOptionsMenu();
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording() && !this.mClickVoiceGroupMemberActivity) {
            stopRecordCall();
            showToast(C0000R.string.call_btn_record_stop_popup);
        }
        logI("ShareScreen-- mCallStatusData.isActiveShareScreen(): " + this.mCallStatusData.isActiveShareScreen());
        if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
            sendBroadcast(new Intent(ScreenShareService.CHECK_KEYGUARD_LOCK));
        }
        super.onUserLeaveHint();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.call.view.CallActivity, android.app.Activity
    protected void onDestroy() {
        logI("onDestroy()");
        dispose();
        super.onDestroy();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void initActivity() {
        logI(" initActivity()+++++++++++++++++");
        this.mLineaLayout1 = (LinearLayout) findViewById(C0000R.id.linearlayout1);
        this.mFrameLayout1 = (FrameLayout) findViewById(C0000R.id.framelayout1);
        this.mFrameLayout2 = (FrameLayout) findViewById(C0000R.id.framelayout2);
        this.mFrameLayout3 = (FrameLayout) findViewById(C0000R.id.framelayout3);
        this.mFrameLayout4 = (FrameLayout) findViewById(C0000R.id.framelayout4);
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        updateNotConnectedCallLayout();
        logI(" initActivity()---------------");
    }

    private void updateNotConnectedCallLayout() {
        if (CallState.isNotConnected(this.mCallState)) {
            changeCoverLockUI(false);
            if (this.mIsOutGoingCall) {
                SetOutGoingCallLayout();
            } else {
                SetInComingCallLayout();
            }
        }
    }

    private void SetOutGoingCallLayout() {
        logI("SetOutGoingCallLayout()");
        this.mCallerImageLayout = new VoiceCallerImageLayout(this, this.mFrameLayout1);
        this.mCallerImageLayout.setParent(this);
        this.mCallerImageLayout.setMember(this.mDestination, this.mIsOutGoingCall);
        this.mCallMemberLayout = new VoiceCallMemberLayout(this, this.mFrameLayout1);
        this.mCallMemberLayout.setParent(this);
        this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        this.mInviteviewMemberLayout = new InviteViewMemberLayout(this, this.mFrameLayout1, 2);
        this.mCallBtnLayout = new VoiceCallBtnLayout(this, this.mFrameLayout2);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
        params.gravity = 80;
        this.mCallBtnLayout.setLayoutParams(params);
        this.mCallBtnLayout.setParent(this);
        if (this.mCallStatusData.getCallState() == 5) {
            this.mCallBtnLayout.updateMuteBackGround(true);
        } else {
            this.mCallBtnLayout.updateMuteBackGround(false);
        }
        this.mCallBtnLayout.setCallBtnUpdate(this.mCallState);
        setCallerImageHandler();
        restoreData();
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.endInviteView();
        }
        this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
        this.mInviteViewCtrl.stop();
        checkWaitMemberForInviteView();
        updateMemberCount();
    }

    private void SetInComingCallLayout() {
        logI("SetInComingCallLayout()");
        this.mCallIncomingLayout = new VoiceCallIncomingLayout(this, this.mLineaLayout1);
        this.mCallIncomingLayout.setParent(this);
        this.mCallIncomingLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        this.mCallIncomingLayout.setStatusBarVisibility(8);
        disableCoverLockUI(1000);
        if (isCoverOpen()) {
            if (isDrivingModeUIOn()) {
                this.mCallDrivingBtnLayout = new VoiceCallDrivingBtnLayout(this, this.mFrameLayout2);
                this.mCallDrivingBtnLayout.setParent(this);
                this.mCallDrivingBtnLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
                this.mCallDrivingBtnLayout.setCallMode(this.mIsOutGoingCall);
                this.mIncomingInviteviewMemberLayout = (InviteViewMemberLayout) this.mCallDrivingBtnLayout.getLayoutreference().findViewById(C0000R.id.voice_call_inviteview_member_incoming);
                this.mIncomingInviteviewMemberLayout.setVisibility(0);
            } else {
                this.mIncomingInviteviewMemberLayout = (InviteViewMemberLayout) this.mCallIncomingLayout.getLayoutreference().findViewById(C0000R.id.voice_call_inviteview_member_incoming);
                this.mIncomingInviteviewMemberLayout.setVisibility(0);
                this.mCallReceiveBtnLayout = new IncomingSlidingWidget(this, this.mFrameLayout2);
                this.mCallReceiveBtnLayout.initialize(this, this.mDestination, this.mCalluserInfo);
                this.mCallReceiveBtnLayout.setVisibility(0);
            }
            if (this.mInviteViewCtrl != null) {
                this.mInviteViewCtrl.endInviteView();
            }
            this.mInviteViewCtrl = new InviteViewController(this, this, this.mIncomingInviteviewMemberLayout.getInviteViewLayout(), this.mIncomingInviteviewMemberLayout.getInviteListView());
            this.mInviteViewCtrl.stop();
            checkWaitMemberForInviteView();
            updateMemberCount();
        } else {
            if (ModelInfoUtil.IS_MODEL_H) {
                this.mCoverReceiveLayout = new IncomingSlidingWidgetCoverBig(this, this, this.mDestination, this.mFrameLayout3);
            } else {
                this.mCoverReceiveLayout = new IncomingSlidingWidgetCover(this, this, this.mDestination, this.mFrameLayout3);
            }
            this.mCoverReceiveLayout.setClearCoverActive(this.mCalluserInfo, getResources().getString(C0000R.string.voice_call));
        }
        setCallerImageHandler();
        restoreData();
    }

    private void setVisibilityAlllayOut(int SetVisibleState) {
        logI("setVisibilityAlllayOut() -start-");
        setVisibilityLayout(this.mFrameLayout1, SetVisibleState);
        setVisibilityLayout(this.mFrameLayout2, SetVisibleState);
        setVisibilityLayout(this.mFrameLayout3, SetVisibleState);
        logI("setVisibilityAlllayOut() -end-");
    }

    private void updateUIOutgoingCall() {
        if (isCoverOpen()) {
            if (this.mCoverAccpetCallLayout != null) {
                setVisibilityLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString(), 8);
            }
            if (this.mCallerImageLayout != null) {
                setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 0);
            }
            if (this.mCallBtnLayout != null) {
                setVisibilityLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString(), 0);
            }
            if (this.mInviteviewMemberLayout != null) {
                setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 0);
                viewInviteView();
            } else {
                this.mInviteviewMemberLayout = new InviteViewMemberLayout(this, this.mFrameLayout1, 2);
            }
            if (this.mCallMemberLayout != null) {
                setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 0);
            }
            if (this.mInviteViewCtrl != null) {
                this.mInviteViewCtrl.endInviteView();
            }
            if (this.mInviteViewCtrl == null) {
                this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
            }
            this.mInviteViewCtrl.stop();
            checkWaitMemberForInviteView();
            updateMemberCount();
            return;
        }
        if (this.mCoverAccpetCallLayout == null || !findViewLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString())) {
            if (ModelInfoUtil.IS_MODEL_H) {
                this.mCoverAccpetCallLayout = new AcceptCallCoveredVoiceCallBig(this, this, this.mDestination, this.mFrameLayout3);
            } else {
                this.mCoverAccpetCallLayout = new AcceptCallCoveredVoiceCall(this, this, this.mDestination, this.mFrameLayout3);
            }
            this.mCoverAccpetCallLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType());
            this.mCoverAccpetCallLayout.setMember(this.mDestination, this.mCalluserInfo, this.mCallState);
        }
        setVisibilityLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString(), 0);
        if (this.mCallerImageLayout != null) {
            setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 8);
        }
        if (this.mCallBtnLayout != null) {
            setVisibilityLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString(), 8);
        }
        if (this.mInviteviewMemberLayout != null) {
            setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 8);
            goneInviteView();
        }
        if (this.mCallMemberLayout != null) {
            setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 8);
        }
    }

    private void SetNotConnectedCallLayout() {
        if (this.mAudioPathController != null) {
            if (this.mAudioPathController.isBlueToothOn()) {
                onBTButton();
                disableSpeakerButton();
            }
            updateAlertsOnCall(true);
            checkHookingHomeKey(!this.mIsOutGoingCall);
            checkHookingPowerKey(!this.mIsOutGoingCall);
            if (this.mIsOutGoingCall) {
                disableCoverLockUI(500);
                updateUIOutgoingCall();
            } else {
                disableCoverLockUI(500);
                setVisibilityAlllayOut(8);
                if (isCoverOpen()) {
                    if (this.mCallIncomingLayout != null) {
                        setVisibilityLayout(this.mLineaLayout1, this.mCallIncomingLayout.getClass().toString(), 0);
                    } else {
                        this.mCallIncomingLayout = new VoiceCallIncomingLayout(this, this.mLineaLayout1);
                        this.mCallIncomingLayout.setParent(this);
                        this.mCallIncomingLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
                        this.mCallIncomingLayout.setStatusBarVisibility(8);
                    }
                    this.mCallIncomingLayout.sendAccessibilityEvent();
                    if (this.mCoverReceiveLayout != null) {
                        setVisibilityLayout(this.mFrameLayout3, this.mCoverReceiveLayout.getClass().toString(), 8);
                    }
                    if (isDrivingModeUIOn()) {
                        if (this.mCallDrivingBtnLayout != null) {
                            setVisibilityLayout(this.mFrameLayout2, this.mCallDrivingBtnLayout.getClass().toString(), 0);
                        } else {
                            this.mCallDrivingBtnLayout = new VoiceCallDrivingBtnLayout(this, this.mFrameLayout2);
                            this.mCallDrivingBtnLayout.setParent(this);
                            this.mCallDrivingBtnLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
                            this.mCallDrivingBtnLayout.setCallMode(this.mIsOutGoingCall);
                        }
                        if (this.mIncomingInviteviewMemberLayout == null) {
                            this.mIncomingInviteviewMemberLayout = (InviteViewMemberLayout) this.mCallDrivingBtnLayout.getLayoutreference().findViewById(C0000R.id.voice_call_inviteview_member_incoming);
                        }
                        this.mIncomingInviteviewMemberLayout.setVisibility(0);
                        if (this.mInviteViewCtrl != null) {
                            this.mInviteViewCtrl.endInviteView();
                        }
                        if (this.mInviteViewCtrl == null) {
                            this.mInviteViewCtrl = new InviteViewController(this, this, this.mIncomingInviteviewMemberLayout.getInviteViewLayout(), this.mIncomingInviteviewMemberLayout.getInviteListView());
                        }
                        this.mInviteViewCtrl.stop();
                        checkWaitMemberForInviteView();
                        updateMemberCount();
                    } else {
                        if (this.mCallReceiveBtnLayout != null) {
                            setVisibilityLayout(this.mFrameLayout2, this.mCallReceiveBtnLayout.getClass().toString(), 0);
                        } else {
                            this.mCallReceiveBtnLayout = new IncomingSlidingWidget(this, this.mFrameLayout2);
                            this.mCallReceiveBtnLayout.initialize(this, this.mDestination, this.mCalluserInfo);
                        }
                        this.mCallReceiveBtnLayout.setVisibility(0);
                        if (this.mIncomingInviteviewMemberLayout == null) {
                            this.mIncomingInviteviewMemberLayout = (InviteViewMemberLayout) this.mCallIncomingLayout.getLayoutreference().findViewById(C0000R.id.voice_call_inviteview_member_incoming);
                        }
                        this.mIncomingInviteviewMemberLayout.setVisibility(0);
                        if (this.mInviteViewCtrl != null) {
                            this.mInviteViewCtrl.endInviteView();
                        }
                        if (this.mInviteViewCtrl == null) {
                            this.mInviteViewCtrl = new InviteViewController(this, this, this.mIncomingInviteviewMemberLayout.getInviteViewLayout(), this.mIncomingInviteviewMemberLayout.getInviteListView());
                        }
                        this.mInviteViewCtrl.stop();
                        checkWaitMemberForInviteView();
                        updateMemberCount();
                    }
                } else {
                    if (this.mCoverReceiveLayout == null) {
                        if (ModelInfoUtil.IS_MODEL_H) {
                            this.mCoverReceiveLayout = new IncomingSlidingWidgetCoverBig(this, this, this.mDestination, this.mFrameLayout3);
                        } else {
                            this.mCoverReceiveLayout = new IncomingSlidingWidgetCover(this, this, this.mDestination, this.mFrameLayout3);
                        }
                        this.mCoverReceiveLayout.setClearCoverActive(this.mCalluserInfo, getResources().getString(C0000R.string.voice_call));
                    } else {
                        setVisibilityLayout(this.mFrameLayout3, this.mCoverReceiveLayout.getClass().toString(), 0);
                    }
                    this.mCoverReceiveLayout.sendAccessibilityEvent();
                    if (this.mCallDrivingBtnLayout != null) {
                        setVisibilityLayout(this.mFrameLayout2, this.mCallDrivingBtnLayout.getClass().toString(), 8);
                    }
                    if (this.mCallReceiveBtnLayout != null) {
                        setVisibilityLayout(this.mFrameLayout2, this.mCallReceiveBtnLayout.getClass().toString(), 8);
                    }
                    if (this.mCallIncomingLayout != null) {
                        setVisibilityLayout(this.mLineaLayout1, this.mCallIncomingLayout.getClass().toString(), 8);
                    }
                }
                showCallIncomingAnimation();
                if (!isDrivingModeUIOn() && this.mCallReceiveBtnLayout != null) {
                    this.mCallReceiveBtnLayout.showReceveBtnAnimation();
                }
                if (this.mAutoReceiveTime >= 1) {
                    this.mAutoReceiveCnt = true;
                    if (this.mAudioPathController.isBlueToothConnected() || this.mAudioPathController.isEarPhonePlugged()) {
                        autoReceiveCall();
                    }
                }
            }
            if (!this.mIsOutGoingCall && EntitlementController.isATNTDevice() && !this.mIsOutGoingCall && !PhoneManager.isWifiNetworkConnected(MainApplication.mContext)) {
                showToast(C0000R.string.atnt_entitlement_incoming_alert_msg, EventCode.EVENT_CONF_MAKE_SUCCESS);
            }
            this.isConnectedCall = false;
            this.isHoldCall = false;
            return;
        }
        logI("mAudioPathController == null");
    }

    private void SetConnectedCallLayout() {
        if (this.mAudioPathController != null) {
            checkHookingHomeKey(false);
            checkHookingPowerKey(true);
            changeCoverLockUI(true);
            if (this.mAudioPathController.isWatch()) {
                boolean isCallAcceptedByBargeIn = false;
                if (this.mBargeInController != null) {
                    isCallAcceptedByBargeIn = this.mBargeInController.isAcceptByVoice();
                    hideVoiceControlUserGuide();
                    this.mBargeInController.dispose();
                    this.mBargeInController = null;
                }
                if (!this.isConnectedCall) {
                    this.mAudioPathController.initCallConnectedForWatch(false, isCallAcceptedByBargeIn);
                }
            } else {
                if (this.mAudioPathController.isBlueToothOn()) {
                    onBTButton();
                    disableSpeakerButton();
                }
                if (this.mBargeInController != null) {
                    if (this.mBargeInController.isAcceptByVoice()) {
                        this.mAudioPathController.initCallConnectedByBargeIn(false);
                    }
                    hideVoiceControlUserGuide();
                    this.mBargeInController.dispose();
                    this.mBargeInController = null;
                }
            }
            if (this.mIncomingInviteviewMemberLayout != null) {
                this.mIncomingInviteviewMemberLayout.setVisibility(8);
            }
            logI("-------------updateUIComponent()------CONNECTED");
            if (this.mCallerImageLayout == null || !findViewLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString())) {
                this.mCallerImageLayout = new VoiceCallerImageLayout(this, this.mFrameLayout1);
                this.mCallerImageLayout.setParent(this);
                this.mCallerImageLayout.setMember(this.mDestination, this.mIsOutGoingCall);
            }
            if (this.mCallMemberLayout == null || !findViewLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString())) {
                this.mCallMemberLayout = new VoiceCallMemberLayout(this, this.mFrameLayout1);
                this.mCallMemberLayout.setParent(this);
                this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
            }
            if (this.mInviteviewMemberLayout == null || !findViewLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString())) {
                this.mInviteviewMemberLayout = new InviteViewMemberLayout(this, this.mFrameLayout1, 2);
            }
            if (getResources().getConfiguration().orientation == 2) {
                LinearLayout inviteBuddiesMainLayout = (LinearLayout) this.mInviteviewMemberLayout.getInviteBuddiesMainLayout();
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) inviteBuddiesMainLayout.getLayoutParams();
                layoutParams.width = 1005;
                layoutParams.topMargin = 0;
                inviteBuddiesMainLayout.setLayoutParams(layoutParams);
            }
            if (this.mCallBtnLayout == null || !findViewLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString())) {
                this.mCallBtnLayout = new VoiceCallBtnLayout(this, this.mFrameLayout2);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -2);
                params.gravity = 80;
                this.mCallBtnLayout.setLayoutParams(params);
                this.mCallBtnLayout.setParent(this);
            }
            if (this.mMemberViewLayout == null || !findViewLayout(this.mFrameLayout4, this.mMemberViewLayout.getClass().toString())) {
                this.mMemberViewLayout = new ShowCallMemberViewlayout(this, this.mFrameLayout4);
                this.mMemberViewCtrl = new MemberViewController(this, this, ((ShowCallMemberViewlayout) this.mMemberViewLayout).getLayoutreference());
            }
            if (isCoverOpen()) {
                if (this.mCoverAccpetCallLayout != null) {
                    setVisibilityLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString(), 8);
                }
                if (this.mCallerImageLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 0);
                }
                if (this.mCallBtnLayout != null) {
                    setVisibilityLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString(), 0);
                }
                if (this.mInviteviewMemberLayout != null) {
                    if (isConference() || isChangeToConference()) {
                        setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 0);
                        viewInviteView();
                    } else {
                        setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 8);
                        goneInviteView();
                    }
                }
                if (this.mCallMemberLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 0);
                }
            } else {
                if (this.mCoverAccpetCallLayout == null || !findViewLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString())) {
                    if (ModelInfoUtil.IS_MODEL_H) {
                        this.mCoverAccpetCallLayout = new AcceptCallCoveredVoiceCallBig(this, this, this.mDestination, this.mFrameLayout3);
                    } else {
                        this.mCoverAccpetCallLayout = new AcceptCallCoveredVoiceCall(this, this, this.mDestination, this.mFrameLayout3);
                    }
                    this.mCoverAccpetCallLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType());
                    this.mCoverAccpetCallLayout.setMember(this.mDestination, this.mCalluserInfo, this.mCallState);
                }
                setVisibilityLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString(), 0);
                if (this.mCallerImageLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 8);
                }
                if (this.mCallBtnLayout != null) {
                    setVisibilityLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString(), 8);
                }
                if (this.mInviteviewMemberLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 8);
                    goneInviteView();
                }
                if (this.mCallMemberLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 8);
                }
            }
            if (MainApplication.mPhoneManager.isTranslateTest() && (this.mVoiceCallTranslatorLayout == null || !findViewLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString()))) {
                this.mVoiceCallTranslatorLayout = new VoiceCallTranslatorLayout(this, this.mFrameLayout1);
                this.mVoiceCallTranslatorLayout.setParent(this);
                this.mCallTranslatorScrollViewLayout = (CallTranslatorScrollViewLayout) this.mVoiceCallTranslatorLayout.getLayoutreference().findViewById(C0000R.id.voice_call_translator_content_id);
                if (this.mIsTranslatorOptionMenuEnable) {
                    setVisibilityLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString(), 0);
                    this.mCallTranslatorScrollViewLayout.setVisibility(0);
                } else {
                    setVisibilityLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString(), 8);
                    this.mCallTranslatorScrollViewLayout.setVisibility(8);
                }
                initTranslatorViewController();
            }
            if (this.mCallDrivingBtnLayout != null) {
                removeViewLayout(this.mFrameLayout2, this.mCallDrivingBtnLayout.getClass().toString());
                this.mCallDrivingBtnLayout.dispose();
                this.mCallDrivingBtnLayout = null;
            }
            if (this.mCallEndBtnLayout != null) {
                removeViewLayout(this.mFrameLayout2, this.mCallEndBtnLayout.getClass().toString());
                this.mCallEndBtnLayout.dispose();
                this.mCallEndBtnLayout = null;
            }
            if (this.mCallReceiveBtnLayout != null) {
                removeViewLayout(this.mFrameLayout2, this.mCallReceiveBtnLayout.getClass().toString());
                this.mCallReceiveBtnLayout.dispose();
                this.mCallReceiveBtnLayout = null;
            }
            if (this.mCallIncomingLayout != null) {
                removeViewLayout(this.mLineaLayout1, this.mCallIncomingLayout.getClass().toString());
                this.mCallIncomingLayout.dispose();
                this.mCallIncomingLayout = null;
            }
            if (this.mCoverEndedLayout != null) {
                removeViewLayout(this.mFrameLayout3, this.mCoverEndedLayout.getClass().toString());
                this.mCoverEndedLayout.dispose();
                this.mCoverEndedLayout = null;
            }
            if (this.mCoverReceiveLayout != null) {
                removeViewLayout(this.mFrameLayout3, this.mCoverReceiveLayout.getClass().toString());
                this.mCoverReceiveLayout.dispose();
                this.mCoverReceiveLayout = null;
            }
            this.isConnectedCall = true;
            if (4 == this.mCallState) {
                this.isHoldCall = true;
            } else {
                this.isHoldCall = false;
            }
            if (this.mInviteViewCtrl != null) {
                this.mInviteViewCtrl.endInviteView();
            }
            this.mInviteViewCtrl = new InviteViewController(this, this, this.mInviteviewMemberLayout.getInviteViewLayout(), this.mInviteviewMemberLayout.getInviteListView());
            this.mInviteViewCtrl.stop();
            checkWaitMemberForInviteView();
            checkInviteView();
            updateMemberCount();
            enableBtnForShareScreen();
            setCallerImageHandler();
            logI("SetConnectedtCallLayout -End-");
            return;
        }
        logI("mAudioPathController == null");
    }

    private void SetDisconnectCallLayout() {
        if (MainApplication.mPhoneManager.isTranslateTest()) {
            closeSTTTranslationTTS(false);
        }
        notifyCallEndToOtherActivity();
        this.mHangUpCall = true;
        updateAlertsOnCall(false);
        checkHookingHomeKey(false);
        checkHookingPowerKey(false);
        if (this.mHoldToast != null) {
            this.mHoldToast.cancel();
        }
        if (this.mHoldRetrieveToast != null) {
            this.mHoldRetrieveToast.cancel();
        }
        cancelSpeakerphone();
        cancelBTHeadset();
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.endInviteView();
        }
        closeOptionsMenu();
        logI("updateUIComponent isConnectedCall: " + this.isConnectedCall + " mIsOutGoingCall: " + this.mIsOutGoingCall);
        if (this.isConnectedCall || this.mIsOutGoingCall || (MainApplication.mPhoneManager.getPhoneStateMachine().getHangupCode() != 0 && this.mCallStatusData.isActiveShareScreen() == 2)) {
            this.mHandler.sendEmptyMessageDelayed(BLINK_DELAYED_CALL_END_BUTTON, 1000L);
            if (this.mCallMemberLayout == null || !findViewLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString())) {
                this.mCallMemberLayout = new VoiceCallMemberLayout(this, this.mFrameLayout1);
                this.mCallMemberLayout.setParent(this);
                this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
            }
            if (this.mInviteViewCtrl != null) {
                this.mInviteViewCtrl.endInviteView();
            }
            if (this.mInviteviewMemberLayout != null) {
                setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 8);
            }
            if (MainApplication.mPhoneManager.isTranslateTest() && this.mVoiceCallTranslatorLayout != null) {
                setVisibilityLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString(), 8);
                this.mCallTranslatorScrollViewLayout.setVisibility(8);
            }
            if (this.mCallBtnLayout != null) {
                this.mCallBtnLayout.dismiss3GDialog();
                setVisibilityLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString(), 8);
                removeViewLayout(this.mFrameLayout2, this.mCallBtnLayout.getClass().toString());
                this.mCallBtnLayout.dispose();
                this.mCallBtnLayout = null;
            }
            if (this.mCallEndBtnLayout == null || !findViewLayout(this.mFrameLayout2, this.mCallEndBtnLayout.getClass().toString())) {
                this.mCallEndBtnLayout = new VoiceCallEndBtnLayout(this, this.mFrameLayout2);
                this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
            }
            if (this.mCallReceiveBtnLayout != null) {
                setVisibilityLayout(this.mFrameLayout2, this.mCallReceiveBtnLayout.getClass().toString(), 8);
            }
            if (this.mCallDrivingBtnLayout != null) {
                setVisibilityLayout(this.mFrameLayout2, this.mCallDrivingBtnLayout.getClass().toString(), 8);
            }
            if (this.mCoverAccpetCallLayout != null) {
                removeViewLayout(this.mFrameLayout3, this.mCoverAccpetCallLayout.getClass().toString());
                this.mCoverAccpetCallLayout.dispose();
                this.mCoverAccpetCallLayout = null;
            }
            if (isCoverOpen()) {
                if (this.mCallerImageLayout == null || !findViewLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString())) {
                    this.mCallerImageLayout = new VoiceCallerImageLayout(this, this.mFrameLayout1);
                    this.mCallerImageLayout.setParent(this);
                    this.mCallerImageLayout.setMember(this.mDestination, this.mIsOutGoingCall);
                } else {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 0);
                }
                if (this.mCallMemberLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 0);
                }
                if (this.mCoverEndedLayout != null) {
                    setVisibilityLayout(this.mFrameLayout3, this.mCoverEndedLayout.getClass().toString(), 8);
                }
            } else {
                if (this.mCoverEndedLayout == null || !findViewLayout(this.mFrameLayout3, this.mCoverEndedLayout.getClass().toString())) {
                    if (ModelInfoUtil.IS_MODEL_H) {
                        this.mCoverEndedLayout = new EndedCallCoveredLayoutBig(this, this.mFrameLayout3, this.mDestination, this);
                    } else {
                        this.mCoverEndedLayout = new EndedCallCoveredLayout(this, this.mFrameLayout3, this.mDestination, this);
                    }
                    this.mCoverEndedLayout.setCallType(true);
                    this.mCoverEndedLayout.setClearCoverActive(this.mCalluserInfo);
                }
                if (this.mCallerImageLayout != null) {
                    setVisibilityLayout(this.mFrameLayout1, this.mCallerImageLayout.getClass().toString(), 8);
                }
            }
            if (this.isHoldCall) {
                showToast(C0000R.string.call_info_nofi_hold_release_message);
                this.isHoldCall = false;
            }
            if (this.mIsRecord && !this.mClickVoiceGroupMemberActivity) {
                stopRecordCall();
                setRecordStatement();
                this.mHandler.sendEmptyMessageDelayed(ErrorCode.VOICE_RECORD_FILE_SAVED, 1000L);
            }
            setCallerImageHandler();
            dismissVoiceDialog();
            notiToUserDisconnectedInActivity();
            delayedQuit();
            checkNetworkDisconnect();
            return;
        }
        if (this.mCallMemberLayout == null) {
            this.mCallMemberLayout = new VoiceCallMemberLayout(this, this.mFrameLayout1);
            this.mCallMemberLayout.setParent(this);
            this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
            setVisibilityLayout(this.mFrameLayout1, this.mCallMemberLayout.getClass().toString(), 8);
        }
        if (this.mCallEndBtnLayout == null) {
            this.mCallEndBtnLayout = new VoiceCallEndBtnLayout(this, this.mFrameLayout2);
            this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
            setVisibilityLayout(this.mFrameLayout2, this.mCallEndBtnLayout.getClass().toString(), 8);
        }
        quitActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibilityLayout(ViewGroup viewgroup, String LayOutName, int SetVisibleState) {
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            if ((String.valueOf(LayOutName) + getResources().getConfiguration().orientation).equals((String) viewgroup.getChildAt(i).getTag())) {
                Log.m2963i("YKYU " + ((String) viewgroup.getChildAt(i).getTag()) + " is " + SetVisibleState);
                viewgroup.getChildAt(i).setVisibility(SetVisibleState);
            }
        }
    }

    private void setVisibilityLayout(ViewGroup viewgroup, int SetVisibleState) {
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            viewgroup.getChildAt(i).setVisibility(SetVisibleState);
        }
    }

    private void removeViewLayout(ViewGroup viewgroup, String LayOutName) {
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            if ((String.valueOf(LayOutName) + getResources().getConfiguration().orientation).equals((String) viewgroup.getChildAt(i).getTag())) {
                viewgroup.removeViewAt(i);
                return;
            }
        }
    }

    private boolean findViewLayout(ViewGroup viewgroup, String LayOutName) {
        for (int i = 0; i < viewgroup.getChildCount(); i++) {
            if ((String.valueOf(LayOutName) + getResources().getConfiguration().orientation).equals((String) viewgroup.getChildAt(i).getTag())) {
                return true;
            }
        }
        return false;
    }

    private void restoreData() {
        HashMap<String, Object> hMap;
        logI("restoreData()");
        if (this.mBackUpObj != null) {
            logI(" Orientation backUpObj != null");
            if (this.mCallMemberLayout != null && (hMap = (HashMap) this.mBackUpObj) != null) {
                logI("mBackupBaseTime: " + mBackupBaseTime);
                this.mCallMemberLayout.setLayoutCallBaseTime((Long) hMap.get(mBackupBaseTime), this.mCallState);
                this.mCallMemberLayout.updatetMenuStatus(((Boolean) hMap.get(mMenuOpen)).booleanValue());
                if (this.mCoverAccpetCallLayout != null) {
                    this.mCoverAccpetCallLayout.setLayoutCallBaseTime((Long) hMap.get(mBackupBaseTime), this.mCallState);
                }
            }
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setCallBtnUpdate(this.mCallState);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public boolean checkCallInstanceNRefresh() {
        super.checkCallInstanceNRefresh();
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        }
        if (this.mCallIncomingLayout != null) {
            this.mCallIncomingLayout.setMember(this.mDestination, this.mIsOutGoingCall, this.mCalluserInfo);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.setMember(this.mDestination, this.mIsOutGoingCall);
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.setData(this.mDestination, this, this.mCalluserInfo.userNo);
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.setDestination(this.mDestination);
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setMember(this.mDestination, this.mCalluserInfo, this.mCallState);
        }
        return true;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateUIComponent() {
        logI("updateUIComponent() CallState: " + CallState.getCallStateDescription(this.mCallState) + " call transf: " + this.mCallStatusData.isCallTransforming());
        if (this.mCallState == 5) {
            notifyMute();
        } else {
            cancelMute();
        }
        if (MainApplication.mCallNotification.showQuickPanel()) {
            MainApplication.mCallNotification.showCallButtonNotification();
        }
        if (CallState.isNotConnected(this.mCallState)) {
            SetNotConnectedCallLayout();
        } else if (CallState.isConnected(this.mCallState)) {
            SetConnectedCallLayout();
        } else if (CallState.isDisconnected(this.mCallState)) {
            SetDisconnectCallLayout();
        }
        updateCallState();
        checkHoldForScreenShare();
        logI("updateUIComponent()--");
    }

    public boolean isHoldCall() {
        if (4 != this.mCallState) {
            return false;
        }
        return true;
    }

    private void updateCallState() {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0);
            this.mCallBtnLayout.setCallBtnUpdate(this.mCallState);
        }
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), 0);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType());
            this.mCoverAccpetCallLayout.setUpdateDuringCallCoverBtn();
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), 0, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0, this.mIsChangeToConference);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void receiveCall() {
        logI("receiveCall()");
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        unregisterGestureManager();
        this.mAutoReceiveCnt = false;
        cacelReceiveCall();
        int retVal = MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, true, 10, MainApplication.mConfig.isSecureCommunication(), "");
        if (retVal != 0) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALL_ACTION;
            sendHandlerMessage(msg, 0L);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCall() {
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        this.mAutoReceiveCnt = false;
        cancelSpeakerphone();
        cancelBTHeadset();
        int retVal = MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, false, 100, MainApplication.mConfig.isSecureCommunication(), "");
        if (retVal != 0) {
            Message msg = new Message();
            msg.what = EventCode.EVENT_CALL_ACTION;
            sendHandlerMessage(msg, 0L);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void denyCallwithRejectMsg(int hangupCode, String hangupMsg) {
        if (hangupCode != -1) {
            if (this.mBargeInController != null) {
                this.mBargeInController.dispose();
            }
            cancelSpeakerphone();
            cancelBTHeadset();
            sendRejectMessage(hangupMsg);
            int retVal = MainApplication.mPhoneManager.getPhoneStateMachine().connectCall(this.mDestination, this.mCallID, false, hangupCode, MainApplication.mConfig.isSecureCommunication(), hangupMsg);
            if (retVal != 0) {
                Message mMsg = new Message();
                mMsg.what = EventCode.EVENT_CALL_ACTION;
                sendHandlerMessage(mMsg, 0L);
            }
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupCall() {
        if (this.mBargeInController != null) {
            this.mBargeInController.dispose();
        }
        cancelBTHeadset();
        synchronized (this.hangupMutex) {
            new Thread(new Runnable() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    int ret = MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(VoiceCallActivity.this.mDestination, 10);
                    if (ret == -1012) {
                        Message msg = new Message();
                        msg.what = EventCode.EVENT_CALL_ACTION;
                        VoiceCallActivity.this.sendHandlerMessage(msg, 0L);
                    }
                    if (ret == -1106) {
                        VoiceCallActivity.this.logI(" hangupCall == ERROR_INVALID_CALL_SATATE_FOR_END_CALL ");
                        VoiceCallActivity.this.mHandler.sendEmptyMessage(EventCode.EVENT_CALL_ACTION);
                    }
                }
            }).start();
        }
    }

    protected class VoiceCallHandler extends ChatOnCallHandler implements DisposeInterface {
        private boolean bDisposed;

        public VoiceCallHandler(CallActivity parent) {
            super(parent);
            this.bDisposed = false;
        }

        @Override // com.coolots.chaton.call.view.ChatOnCallHandler, com.sds.coolots.call.view.CallHandler, com.sds.coolots.common.view.DisposeInterface
        public void dispose() {
            VoiceCallActivity.this.logI("Dispose VoiceCallHandler");
            this.bDisposed = true;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.coolots.chaton.call.view.ChatOnCallHandler, com.sds.coolots.call.view.CallHandler, android.os.Handler
        public void handleMessage(Message msg) {
            VoiceCallActivity.this.logI("VoiceCallHandler handleMessage(" + msg + ")");
            if (this.bDisposed) {
                VoiceCallActivity.this.logI("VoiceCallHandler was disposed. so this message is going to be ignored.");
                return;
            }
            switch (msg.what) {
                case 10:
                    VoiceCallActivity.this.logI("MSG_DELAYED_QUIT");
                    VoiceCallActivity.this.changeCoverLockUI(false);
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForEnd();
                    break;
                case VoiceCallActivity.BLINK_DELAYED_CALL_END_BUTTON /* 555 */:
                    VoiceCallActivity.this.logI("BLINK_DELAYED_CALL_END_BUTTON");
                    if (VoiceCallActivity.this.isCoverOpen()) {
                        if (VoiceCallActivity.this.mCallEndBtnLayout != null) {
                            VoiceCallActivity.this.mCallEndBtnLayout.setVisibility(0);
                            break;
                        }
                    } else if (VoiceCallActivity.this.mCallEndBtnLayout != null) {
                        VoiceCallActivity.this.mCallEndBtnLayout.setVisibility(8);
                        break;
                    }
                    break;
                case 2000:
                    VoiceCallActivity.this.logI("UPDATE_CALL_BUTTON_STATE");
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        VoiceCallActivity.this.mCallBtnLayout.setBtnClickable(true);
                        break;
                    }
                    break;
                case EventCode.EVENT_CONF_UPDATE_MEMBER /* 7004 */:
                    VoiceCallActivity.this.logI("EventCode.EVENT_CONF_UPDATE_MEMBER");
                    VoiceCallActivity.this.mDestination = (Destination) msg.obj;
                    VoiceCallActivity.this.updateLayoutChangeDestination();
                    VoiceCallActivity.this.checkInviteView();
                    VoiceCallActivity.this.checkMemberView();
                    if (VoiceCallActivity.this.mCoverAccpetCallLayout != null) {
                        VoiceCallActivity.this.mCoverAccpetCallLayout.setUIState(VoiceCallActivity.this.mIsOutGoingCall, VoiceCallActivity.this.mCallState, VoiceCallActivity.this.mDestination.getDestinationType());
                        VoiceCallActivity.this.mCoverAccpetCallLayout.setMember(VoiceCallActivity.this.mDestination, VoiceCallActivity.this.mCalluserInfo, VoiceCallActivity.this.mCallState);
                        break;
                    }
                    break;
                case EventCode.EVENT_CONF_CHANGE_HOLD /* 7018 */:
                    VoiceCallActivity.this.logI("EventCode.EVENT_CONF_CHANGE_HOLD");
                    ArrayList<String> userIDList = (ArrayList) msg.obj;
                    VoiceCallActivity.this.handleConferenceChangeHold(userIDList);
                    break;
                case EventCode.EVENT_CONF_CHANGE_UNHOLD /* 7019 */:
                    VoiceCallActivity.this.logI("EventCode.EVENT_CONF_CHANGE_UNHOLD");
                    ArrayList<String> userIDList1 = (ArrayList) msg.obj;
                    VoiceCallActivity.this.handleConferenceChangeUnhold(userIDList1);
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERENCE_START /* 7602 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_CONFERENCE_START()");
                    VoiceCallActivity.this.handleChangeToConferenceStart();
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERNECE_FAILURE /* 7603 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_CONFERNECE_FAILURE()");
                    VoiceCallActivity.this.handleChangeToConferenceFailure();
                    break;
                case EventCode.EVENT_CHANGE_TO_CONFERENCE_FINISH /* 7604 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_CONFERENCE_FINISH()");
                    VoiceCallActivity.this.handleChangeToConferenceFinish();
                    VoiceCallActivity.this.checkCallInstanceNRefresh();
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        FrameLayout switchCallBtn = (FrameLayout) VoiceCallActivity.this.mCallBtnLayout.getLayoutreference().findViewById(C0000R.id.keypad_btn_layout);
                        switchCallBtn.setEnabled(false);
                    }
                    VoiceCallActivity.this.checkWaitMemberForInviteView();
                    VoiceCallActivity.this.updateMemberCount();
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_START /* 7610 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_P2P_START");
                    VoiceCallActivity.this.mDestination = (Destination) msg.obj;
                    VoiceCallActivity.this.checkCallInstanceNRefresh();
                    VoiceCallActivity.this.updateLayoutChangeDestination();
                    VoiceCallActivity.this.mCallerImageLayout.setDisableHoldBtn(false);
                    if (VoiceCallActivity.this.mMemberViewCtrl != null && VoiceCallActivity.this.mMemberViewCtrl.ismMemberViewActive()) {
                        VoiceCallActivity.this.endMemberView();
                        if (VoiceCallActivity.this.mCallMemberLayout != null) {
                            VoiceCallActivity.this.mCallMemberLayout.clickableStatusBarFuctionBtn();
                        }
                    }
                    if (VoiceCallActivity.this.mInviteViewCtrl.isActive() || !VoiceCallActivity.this.isConference()) {
                        VoiceCallActivity.this.mInviteViewCtrl.endInviteView();
                        VoiceCallActivity.this.setVisibilityLayout(VoiceCallActivity.this.mFrameLayout1, VoiceCallActivity.this.mInviteviewMemberLayout.getClass().toString(), 8);
                        VoiceCallActivity.this.goneInviteView();
                        break;
                    }
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_FAILURE /* 7611 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_P2P_FAILURE");
                    VoiceCallActivity.this.mCallerImageLayout.setDisableHoldBtn(false);
                    VoiceCallActivity.this.handleChangeToP2PFailure();
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_NOTI_MSG /* 7612 */:
                    VoiceCallActivity.this.logE("EVENT_CHANGE_TO_P2P_NOTI_MSG");
                    VoiceCallActivity.this.mCallerImageLayout.setDisableHoldBtn(true);
                    String removedMemberUserID = (String) msg.obj;
                    if (removedMemberUserID == null) {
                        VoiceCallActivity.this.showToast(C0000R.string.change_to_p2p_start);
                    } else {
                        VoiceCallActivity voiceCallActivity = VoiceCallActivity.this;
                        Resources resources = VoiceCallActivity.this.getResources();
                        ChatONStringConvert.getInstance();
                        voiceCallActivity.showToast(resources.getString(C0000R.string.change_to_p2p_invite_call_ended, ChatONStringConvert.getInstance().removeFooter(VoiceCallActivity.this.getUserName(removedMemberUserID))));
                    }
                    if (VoiceCallActivity.this.mMemberViewCtrl != null && VoiceCallActivity.this.mMemberViewCtrl.ismMemberViewActive()) {
                        VoiceCallActivity.this.endMemberView();
                        if (VoiceCallActivity.this.mCallMemberLayout != null) {
                            VoiceCallActivity.this.mCallMemberLayout.clickableStatusBarFuctionBtn();
                        }
                    }
                    if ((VoiceCallActivity.this.mInviteViewCtrl.isActive() || !VoiceCallActivity.this.isConference()) && VoiceCallActivity.this.mInviteviewMemberLayout != null) {
                        VoiceCallActivity.this.mInviteViewCtrl.endInviteView();
                        VoiceCallActivity.this.setVisibilityLayout(VoiceCallActivity.this.mFrameLayout1, VoiceCallActivity.this.mInviteviewMemberLayout.getClass().toString(), 8);
                        VoiceCallActivity.this.goneInviteView();
                        break;
                    }
                    break;
                case EventCode.EVENT_CHANGE_TO_P2P_FAIL_TIMER /* 7613 */:
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_P2P_FAIL_TIMER");
                    VoiceCallActivity.this.logI("EVENT_CHANGE_TO_P2P_FAILURE");
                    VoiceCallActivity.this.mCallerImageLayout.setDisableHoldBtn(false);
                    VoiceCallActivity.this.handleChangeToP2PFailure();
                    break;
                case EventCode.EVENT_SHARE_SCREEN_START /* 8112 */:
                    VoiceCallActivity.this.logI("ShareScreen- EventCode.EVENT_SHARE_SCREEN_START (Voice)");
                    VoiceCallActivity.this.dismissCallConsentProcessingDialog();
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        VoiceCallActivity.this.mCallBtnLayout.setIsActiveShareScreen(true);
                        break;
                    }
                    break;
                case EventCode.EVENT_SHARE_SCREEN_END /* 8113 */:
                    VoiceCallActivity.this.logI("ShareScreen- EventCode.EVENT_SHARE_SCREEN_END");
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
                    VoiceCallActivity.this.updateProximity();
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        VoiceCallActivity.this.mCallBtnLayout.setIsActiveShareScreen(false);
                    }
                    VoiceCallActivity.this.checkHoldForScreenShare();
                    break;
                case EventCode.EVENT_SHARE_SCREEN_PAUSE /* 8114 */:
                    VoiceCallActivity.this.logI("ShareScreen- EventCode.EVENT_SHARE_SCREEN_PAUSE (Voice)");
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releasePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_VIDEO_CALL);
                    if (VoiceCallActivity.this.checkForegroundActivity()) {
                        MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForShareScreenProximity();
                        VoiceCallActivity.this.updateProximity();
                    }
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        VoiceCallActivity.this.mCallBtnLayout.setIsActiveShareScreen(true);
                        break;
                    }
                    break;
                case EventCode.EVENT_SHARE_SCREEN_RESTART /* 8115 */:
                    VoiceCallActivity.this.logI("ShareScreen- EventCode.EVENT_SHARE_SCREEN_RESTART (Voice)");
                    MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
                    if (VoiceCallActivity.this.mCallBtnLayout != null) {
                        VoiceCallActivity.this.mCallBtnLayout.setIsActiveShareScreen(true);
                        break;
                    }
                    break;
                case ErrorCode.VOICE_RECORD_FILE_SAVED /* 12222 */:
                    VoiceCallActivity.this.logI("ErrorCode.VOICE_RECORD_FILE_SAVED");
                    VoiceCallActivity.this.setDisplayDialog(ErrorCode.VOICE_RECORD_FILE_SAVED);
                    break;
                case EventCode.EVENT_DEBUG_MSG /* 95000 */:
                    VoiceCallActivity.this.logI("EventCode.EVENT_VOICE_ACTIVITY_CHANGE");
                    String debugMsg = (String) msg.obj;
                    VoiceCallActivity.this.showToast(debugMsg);
                    break;
                case EventCode.EVENT_WRONG_CALL_STATE_MOVE_TO_END_CALL_PAGE /* 95017 */:
                    VoiceCallActivity.this.logI("EVENT_WRONG_CALL_STATE_MOVE_TO_END_CALL_PAGE");
                    VoiceCallActivity.this.handleCallEvent(3);
                    break;
            }
            super.handleMessage(msg);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 2) {
            getCallFunctionController().setInviteProcessing(false);
            if (isHoldCall() || MainApplication.mPhoneManager.getPhoneStateMachine().isPlayHoldTone()) {
                this.mIsChangeToConference = false;
                Toast.makeText(this, getResources().getString(C0000R.string.unable_invite_buddy_invalid_call_hold), 0).show();
                return;
            }
            if (MainApplication.mPhoneManager.IsLinkagewithChatON()) {
                String[] results = (String[]) data.getExtras().get(ChatONInterface.EXTRAS_KEY_RESULT);
                new ArrayList();
                ArrayList<String> buddyNoList = new ArrayList<>();
                for (int i = 0; i < results.length; i++) {
                    logI("onActivityResult add No = [" + results[i] + "]");
                    buddyNoList.add(results[i]);
                }
                ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
                ArrayList<BuddyListChildItem> buddyselectList = chatonservice.getBuddyItemAsBuddyNoList(buddyNoList);
                this.mInviteViewCtrl.preprocessInviteView(buddyselectList, this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, this.mCalluserInfo);
                return;
            }
            this.mInviteViewCtrl.preprocessInviteView(data, this.mDestinationUtil, this.mDestination, this.mUserAddedInfo, this.mCalluserInfo);
        }
    }

    private void saveData() {
        logI("saveData()");
        if (this.mCallMemberLayout != null) {
            HashMap<String, Object> hMap = new HashMap<>();
            logI("mBackupBaseTime: " + mBackupBaseTime);
            hMap.put(mBackupBaseTime, this.mCallMemberLayout.getLayoutCallBaseTime());
            hMap.put(mMenuOpen, Boolean.valueOf(this.mCallMemberLayout.isMenuOpen()));
            this.mBackUpObj = hMap;
        }
    }

    private void setCallerImageHandler() {
        logI("---------setCallerImageHandler");
        if (this.mCallIncomingLayout != null) {
            this.mCallIncomingLayout.setCallerImage(this.mCalluserInfo.userID);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.setCallerImage(this.mCallState, this.mCalluserInfo.userID);
        }
    }

    private void hidekeyboard() {
        logI("hidekeyboard()");
        try {
            if (this.imm == null) {
                this.imm = (InputMethodManager) getSystemService("input_method");
            }
            if (this.imm != null && this.mCallMemberLayout != null) {
                this.imm.hideSoftInputFromWindow(this.mCallMemberLayout.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        ViewRecycleUtil.recurisveRecycle(getWindow().getDecorView());
        super.dispose();
        this.hangupMutex = null;
        this.mCallLogManager = null;
        this.mCalluserInfo = null;
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.dispose();
            this.mCallBtnLayout = null;
        }
        if (this.mCallEndBtnLayout != null) {
            this.mCallEndBtnLayout.dispose();
            this.mCallEndBtnLayout = null;
        }
        if (this.mOnCallBackGround != null) {
            this.mOnCallBackGround = null;
        }
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.dispose();
            this.mCallMemberLayout = null;
        }
        if (this.mInviteviewMemberLayout != null) {
            this.mInviteviewMemberLayout.dispose();
            this.mInviteviewMemberLayout = null;
        }
        if (MainApplication.mPhoneManager.isTranslateTest() && this.mVoiceCallTranslatorLayout != null) {
            this.mVoiceCallTranslatorLayout.dispose();
            this.mVoiceCallTranslatorLayout = null;
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.dispose();
            this.mCallerImageLayout = null;
        }
        if (this.mCallReceiveBtnLayout != null) {
            this.mCallReceiveBtnLayout.dispose();
            this.mCallReceiveBtnLayout = null;
        }
        if (this.mCallIncomingLayout != null) {
            this.mCallIncomingLayout.dispose();
            this.mCallIncomingLayout = null;
        }
        if (this.mCallDrivingBtnLayout != null) {
            this.mCallDrivingBtnLayout.dispose();
            this.mCallDrivingBtnLayout = null;
        }
        if (this.mEndCallBackGround != null) {
            this.mEndCallBackGround.removeAllViewsInLayout();
            this.mEndCallBackGround = null;
        }
        if (this.mHandler != null) {
            this.mHandler.dispose();
            this.mHandler = null;
        }
        if (this.mInviteViewCtrl != null) {
            this.mInviteViewCtrl.endInviteView();
            this.mInviteViewCtrl.dispose();
            this.mInviteViewCtrl = null;
        }
        if (this.mMemberViewLayout != null) {
            this.mMemberViewLayout.removeAllViewsInLayout();
            this.mMemberViewLayout = null;
        }
        if (this.mMemberViewCtrl != null) {
            this.mMemberViewCtrl.dispose();
            this.mMemberViewCtrl = null;
        }
        if (this.mChatOnTranslationDataController != null) {
            this.mChatOnTranslationDataController.dispose();
        }
        if (this.mCoverReceiveLayout != null) {
            this.mCoverReceiveLayout.dispose();
            this.mCoverReceiveLayout = null;
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.dispose();
            this.mCoverAccpetCallLayout = null;
        }
        if (this.mCoverEndedLayout != null) {
            this.mCoverEndedLayout.dispose();
            this.mCoverEndedLayout = null;
        }
        if (this.mChatOnTranslationDataController != null) {
            this.mChatOnTranslationDataController.dispose();
            this.mChatOnTranslationDataController = null;
        }
        removeAllView();
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        this.mAudioManager = null;
        this.imm = null;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void toggleCamera() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateHoldState(boolean bHold) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void updateMuteState(boolean bMute) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected int calculateDuration() {
        return 0;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showDialPad(boolean showPad) {
        if (showPad) {
            logI("SHOW DIALPAD");
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showConnectDialog(int msg) {
        if (msg == 1000) {
            showDialog(1000);
        } else if (msg == 1001) {
            showDialog(1001);
        } else if (msg == 1002) {
            showDialog(1002);
        }
    }

    @Override // android.app.Activity
    protected Dialog onCreateDialog(int menuID) throws Resources.NotFoundException {
        switch (menuID) {
            case TRANSLATOR_DIALOG /* 99 */:
                Set<Integer> voiceLanguage = getRecognitionSupportedVoiceLanguage();
                Set<Integer> transferLanguage = getTranslationSupportedOutLanguage(this.topLangCode);
                final ChatONTranslatorDialog.Builder builder4 = new ChatONTranslatorDialog.Builder(this, this, voiceLanguage);
                builder4.setTitle(getResources().getText(C0000R.string.call_menu_translator));
                builder4.setMessageTop(getResources().getText(C0000R.string.translator_incoming_messages_only));
                builder4.setMyImage(MainApplication.mConfig.getProfileUserID());
                builder4.setOtherPartyImage(this.mCalluserInfo.userID);
                builder4.setMyName(MainApplication.mConfig.getProfileUserName());
                builder4.setOtherPartyName(this.mCalluserInfo.userName);
                builder4.setTopCountryLanguageCode(10);
                builder4.setMiddleCountryLanguageCode(20, transferLanguage);
                builder4.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.8
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        if (MainApplication.mPhoneManager.isTranslateTest()) {
                            VoiceCallActivity.this.topLangCode = builder4.getTopCountryLanguageCode();
                            VoiceCallActivity.this.middleLangCode = builder4.getMiddleCountryLanguageCode();
                            VoiceCallActivity.this.sendTranslatorHostLanguageCode(VoiceCallActivity.this.topLangCode);
                            VoiceCallActivity.this.sendTranslatorTheOtherPartyLanguageCode(VoiceCallActivity.this.middleLangCode);
                            VoiceCallActivity.this.sendRequestConsent(5, TranslationUtil.toConsentParamLanguage(VoiceCallActivity.this.mHostLangCode, VoiceCallActivity.this.mTheOherPartyLangCode));
                            return;
                        }
                        VoiceCallActivity.this.removeDialog(VoiceCallActivity.TRANSLATOR_DIALOG);
                    }
                });
                builder4.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.9
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VoiceCallActivity.this.removeDialog(VoiceCallActivity.TRANSLATOR_DIALOG);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder4.setCancelable(true);
                builder4.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.10
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VoiceCallActivity.this.removeDialog(VoiceCallActivity.TRANSLATOR_DIALOG);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mTranslatorDialog = builder4.create();
                return this.mTranslatorDialog;
            case 104:
            case 1002:
                Log.m2954d("DIALOG_CONNTECT_FAIL");
                ChatONDialog.Builder builder = new ChatONDialog.Builder(this);
                String user_name = null;
                if (0 == 0) {
                    user_name = this.mCallStatusData.getHostDisplayName();
                }
                String msg = getResources().getString(C0000R.string.video_connect_fail_msg, user_name);
                builder.setTitle(getResources().getText(C0000R.string.video_connect_fail_title));
                builder.setMessage(msg);
                builder.setPositiveButton(C0000R.string.confirm_yes, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        VoiceCallActivity.this.quitActivity();
                        VoiceCallActivity.this.removeDialog(104);
                        VoiceCallActivity.this.setRetryCallStatus();
                    }
                });
                builder.setNegativeButton(C0000R.string.confirm_no, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VoiceCallActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder.setCancelable(true);
                builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VoiceCallActivity.this.removeDialog(104);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mConnectFailDialog = builder.create();
                return this.mConnectFailDialog;
            case 999:
                Set<Integer> changeVoiceLanguage = getRecognitionSupportedVoiceLanguage();
                final ChatONTranslatorChangeLanguageDialog.Builder builder5 = new ChatONTranslatorChangeLanguageDialog.Builder(this, changeVoiceLanguage);
                builder5.setTitle(getResources().getText(C0000R.string.translator_change_lang_title));
                builder5.setMessageTop(((Object) getResources().getText(C0000R.string.translator_message_top)) + " : ");
                String middleMessage = getResources().getString(C0000R.string.translator_chagne_lang_message_middle, changeToStringLangCode(this.mGuestLanguageCode));
                builder5.setMessageMiddle(middleMessage);
                builder5.setCountryLanguageCode(this.mHostLanguageCode);
                builder5.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.11
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        VoiceCallActivity.this.setRecognitionVoiceLanguage(builder5.getCountryLanguageCode());
                        VoiceCallActivity.this.removeDialog(999);
                    }
                });
                builder5.setNegativeButton(C0000R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.12
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VoiceCallActivity.this.removeDialog(999);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder5.setCancelable(true);
                builder5.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.13
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                            VoiceCallActivity.this.removeDialog(999);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                this.mTranslatorChangeLanguageDialog = builder5.create();
                return this.mTranslatorChangeLanguageDialog;
            case 1000:
                ChatONDialog.Builder builder2 = new ChatONDialog.Builder(this);
                builder2.setTitle(getResources().getText(C0000R.string.information_str_title_1));
                builder2.setMessage(getResources().getText(C0000R.string.information_str_msg_1));
                if (MainApplication.mConfig.isUseWifiOnly()) {
                    builder2.setMessage(getResources().getText(C0000R.string.unable_make_call_wifi_only_on));
                } else {
                    builder2.setMessage(getResources().getText(C0000R.string.information_str_msg_1));
                }
                builder2.setPositiveButton(C0000R.string.alert_dialog_ok, new DialogInterface.OnClickListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialog, int arg1) {
                        try {
                            VoiceCallActivity.this.removeDialog(1000);
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                builder2.setCancelable(true);
                builder2.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.3
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VoiceCallActivity.this.removeDialog(1000);
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                Dialog dialog = builder2.create();
                return dialog;
            case 1001:
                AlertDialog.Builder builder22 = new AlertDialog.Builder(this);
                builder22.setTitle(getResources().getText(C0000R.string.information_str_title_2));
                builder22.setMessage(getResources().getText(C0000R.string.information_str_msg_2));
                builder22.setCancelable(true);
                builder22.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.coolots.chaton.call.view.VoiceCallActivity.4
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface arg0) {
                        try {
                            VoiceCallActivity.this.removeDialog(1000);
                            VoiceCallActivity.this.finish();
                            if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
                                VoiceCallActivity.this.overridePendingTransition(0, 0);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                Dialog dialog2 = builder22.create();
                return dialog2;
            default:
                return super.onCreateDialog(menuID);
        }
    }

    public String changeToStringLangCode(int langCode) {
        switch (langCode) {
            case 0:
                break;
            case 10:
                break;
            case 20:
                break;
            case 21:
                break;
            case 30:
                break;
            case 31:
                break;
            case 40:
                break;
            case 50:
                break;
        }
        return "English";
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecord() {
        stopRecordCall();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupLowBattery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRetryCallStatus() {
        String userNumber;
        if (VAppPhoneManager.checkAirPlainMode(this)) {
            logI("Call Fail: Airplain Mode");
            showConnectDialog(1001);
            return;
        }
        if (!PhoneManager.isNetworkConnected(MainApplication.mContext)) {
            logI("Call Fail: Network Disconnected");
            showConnectDialog(1000);
            return;
        }
        if (!MainApplication.mPhoneManager.IsLinkagewithChatON()) {
            userNumber = ChatONStringConvert.getInstance().removeAfterAt(this.mDestination.getPhoneNo());
        } else {
            PhoneNumberUtil phoneUtil = new PhoneNumberUtil(ChatONStringConvert.getInstance().removeAfterAt(this.mDestination.getPhoneNo()));
            userNumber = phoneUtil.getPhoneNumber();
        }
        Intent intent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + userNumber));
        startActivity(intent);
        finish();
        if (MainApplication.mPhoneManager.isRemoveNativeAnimation()) {
            overridePendingTransition(0, 0);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldOnStateToast() {
        if (this.mHoldToast == null) {
            this.mHoldToast = Toast.makeText(this, C0000R.string.call_on_hold, 2000);
        }
        this.mHoldToast.show();
        this.mIsCallHoldOn = true;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallHoldRetrievedStateToast() {
        if (this.mHoldRetrieveToast == null) {
            this.mHoldRetrieveToast = Toast.makeText(this, C0000R.string.call_retrieved, 2000);
        }
        this.mHoldRetrieveToast.show();
        this.mIsCallHoldOn = false;
    }

    protected void dismissVoiceDialog() {
        dismissCallConsentProcessingDialog();
        if (this.mConnectFailDialog != null && this.mConnectFailDialog.isShowing()) {
            this.mConnectFailDialog.dismiss();
        }
        if (this.mTranslatorDialog != null && this.mTranslatorDialog.isShowing()) {
            this.mTranslatorDialog.dismiss();
        }
        if (this.mTranslatorChangeLanguageDialog != null && this.mTranslatorChangeLanguageDialog.isShowing()) {
            this.mTranslatorChangeLanguageDialog.dismiss();
        }
    }

    public void setClickVoiceGroupMemberActivity() {
        Log.m2954d("setClickVoiceGroupMemberActivity()");
        this.mClickVoiceGroupMemberActivity = true;
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (CallState.isNotConnected(this.mCallState)) {
                if (!this.mIsOutGoingCall && this.mCallReceiveBtnLayout != null) {
                    this.mCallReceiveBtnLayout.closeRejectMsg();
                }
            } else if (CallState.isConnected(this.mCallState)) {
                if (this.mMemberViewCtrl != null && this.mMemberViewCtrl.ismMemberViewActive()) {
                    endMemberView();
                    if (this.mCallMemberLayout != null) {
                        this.mCallMemberLayout.clickableStatusBarFuctionBtn();
                    }
                }
                closeOptionsMenu();
            }
            return true;
        }
        if (keyCode == 26) {
            this.mIsPowerLongPressed = false;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override // com.sds.coolots.call.view.CallActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int arg0, KeyEvent arg1) {
        switch (arg0) {
            case 3:
                logI("onKeyDown: KEYCODE_HOME");
                if (!this.mIsOutGoingCall) {
                    receiveCall();
                    return true;
                }
                break;
            case 26:
                logI("onKeyDown: KEYCODE_POWER");
                if (arg1.isLongPress()) {
                    this.mIsPowerLongPressed = true;
                    break;
                } else if (!this.mIsPowerLongPressed && CallState.isConnected(this.mCallState)) {
                    this.mCallBtnLayout.endCall();
                    return true;
                }
                break;
        }
        return super.onKeyDown(arg0, arg1);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setHideMe() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setShowMe() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        logI("onConfigurationChanged()");
        this.mMemberCount = getConferenceConnectCount();
        if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            setContentView(C0000R.layout.scamera_voice_call);
        } else {
            setContentView(C0000R.layout.voice_call);
        }
        saveData();
        removeAllView();
        initActivity();
        updateUIComponent();
        if (this.mCallMemberLayout != null && this.mMemberViewCtrl != null && this.mMemberViewCtrl.ismMemberViewActive()) {
            startMemberView(this.mCallMemberLayout);
            this.mCallMemberLayout.unClickableStatusBarFuctionBtn();
        }
        super.onConfigurationChanged(newConfig);
    }

    public void removeAllView() {
        if (this.mLineaLayout1 != null) {
            this.mLineaLayout1.removeAllViews();
        }
        if (this.mFrameLayout1 != null) {
            this.mFrameLayout1.removeAllViews();
        }
        if (this.mFrameLayout2 != null) {
            this.mFrameLayout2.removeAllViews();
        }
        if (this.mFrameLayout3 != null) {
            this.mFrameLayout3.removeAllViews();
        }
        if (this.mFrameLayout4 != null) {
            this.mFrameLayout4.removeAllViews();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void setDisplayDialog(int dialogID) {
        displayDialog(dialogID);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenu(int menuId) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void hideNativeCallLayout() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void accpetNativeCall() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallEndAnimation() {
        logI("ANIMATION showCallEndAnimation");
        if (getForegounrdActivity(MainApplication.mContext).equals(getClass().getName())) {
            logE("ANIMATION start CallEndAnimation");
            this.animationtype = 0;
            AnimationSet anisetDownside = new AnimationSet(true);
            AnimationSet anisetUpside = new AnimationSet(true);
            TranslateAnimation transDownside = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, 1.0f);
            TranslateAnimation transUpside = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f);
            anisetDownside.addAnimation(transDownside);
            anisetUpside.addAnimation(transUpside);
            AlphaAnimation alpha = new AlphaAnimation(1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            anisetDownside.addAnimation(alpha);
            anisetUpside.addAnimation(alpha);
            anisetDownside.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
            anisetUpside.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
            anisetDownside.setDuration(400L);
            anisetDownside.setFillAfter(true);
            anisetUpside.setDuration(400L);
            anisetUpside.setFillAfter(true);
            if (this.mCallMemberLayout != null) {
                this.mCallMemberLayout.getLayoutreference().startAnimation(anisetUpside);
            }
            if (this.mCallEndBtnLayout != null) {
                this.mCallEndBtnLayout.getLayoutreference().startAnimation(anisetDownside);
            }
            anisetDownside.setAnimationListener(this);
            return;
        }
        logI("ANIMATION just finish Activity");
        super.finish();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showCallIncomingAnimation() {
        ViewGroup refLayout;
        logI("showCallIncomingAnimation()");
        TranslateAnimation mIncomingLayoutTrans = new TranslateAnimation(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 1, -1.0f, 1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        mIncomingLayoutTrans.setInterpolator(AnimationUtils.loadInterpolator(MainApplication.mContext, R.anim.decelerate_interpolator));
        mIncomingLayoutTrans.setDuration(400L);
        if (this.mCallIncomingLayout != null) {
            this.mCallIncomingLayout.getLayoutreference().startAnimation(mIncomingLayoutTrans);
        }
        if (isDrivingModeUIOn() && this.mCallDrivingBtnLayout != null && (refLayout = this.mCallDrivingBtnLayout.getLayoutreference()) != null) {
            refLayout.startAnimation(mIncomingLayoutTrans);
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation arg0) {
        logI("ANIMATION onAnimationEnd");
        if (this.animationtype == 0) {
            super.finish();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation arg0) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation arg0) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecordingForCallSwitching() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            stopRecordCall();
            showToast(C0000R.string.call_btn_record_stop_popup);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handlePopupCloseForCallSwitch() {
        if (this.callSwtichingDialog != null) {
            this.callSwtichingDialog.cancel();
            this.callSwtichingDialog = null;
        }
        dismissCallConsentProcessingDialog();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatus(boolean isRecord) {
        this.mIsRecord = isRecord;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startRecordCallAfterConsent() {
        logI("CALLCONSENT Recording 시작");
        startRecordCall();
        this.mIsRecord = true;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setRecordStatement() {
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.updateRecordStatement();
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void makeHideMeImage() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void onBTButton() {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setBTButtonStatus(true);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        }
        notifyBTHeadset();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void offBTButton() {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setBTButtonStatus(false);
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForProximity();
        }
        cancelBTHeadset();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableBTButton() {
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setBtButtonEnable(false);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void enableSpeakerButton() {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.updateSpeakerStatus(true);
            notifySpeakerphone();
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setUpdateSpeakerBtnCover(true);
            notifySpeakerphone();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void disableSpeakerButton() {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.updateSpeakerStatus(false);
            cancelSpeakerphone();
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setUpdateSpeakerBtnCover(false);
            cancelSpeakerphone();
        }
        if (this.mCallStatusData.isActiveShareScreen() == 3) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquireLockForShareScreenProximity();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void gotoBlueToothSettingPage() {
        startActivity(ChatONBlueTooth.getBlueToothSettingPageIntent());
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    private void startShareScreen() {
        MainApplication.mPhoneManager.getPhoneStateMachine().setOtherPartyName(this.mDestination, this.mCalluserInfo.userName);
        if (sendRequestConsent(3, 0)) {
            showCallConsentProcessingDialog(3, 0);
        }
    }

    private void preCheckForShareScreen() {
        if (((ChatOnConfigInterface) MainApplication.mConfig).isShareScreenCopyRight()) {
            displayShareScreenAttention();
        } else {
            displayDialog(21);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        int retItemID = item.getItemId();
        switch (retItemID) {
            case C0000R.id.voice_call_show_member /* 2131493656 */:
                if (this.mCallMemberLayout != null) {
                    startMemberView(this.mCallMemberLayout);
                    this.mCallMemberLayout.unClickableStatusBarFuctionBtn();
                    invalidateOptionsMenu();
                    break;
                }
                break;
            case C0000R.id.voice_call_share_screen /* 2131493659 */:
                this.mIsShareScreenCaller = false;
                if (this.mIsCallHoldOn) {
                    Toast.makeText(this, getResources().getString(C0000R.string.screenshare_other_call_hold), 0).show();
                    break;
                } else {
                    preCheckForShareScreen();
                    break;
                }
            case C0000R.id.voice_call_share_screen_end /* 2131493660 */:
                MainApplication.mPhoneManager.getShareScreenManager().stopShareScreen(MainApplication.mPhoneManager.getShareScreenManager().getCurrentCallDestination());
                break;
            case C0000R.id.voice_call_translator_on /* 2131493661 */:
                this.mIsTranslatorOptionMenuEnable = false;
                closeSTTTranslationTTS(false);
                initSTTTranslationTTS();
                showDialog(TRANSLATOR_DIALOG);
                translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                break;
            case C0000R.id.voice_call_translator_off /* 2131493662 */:
                this.mIsTranslatorOptionMenuEnable = false;
                closeSTTTranslationTTS(true);
                translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        if ((this.mMemberViewCtrl != null && this.mMemberViewCtrl.ismMemberViewActive()) || !CallState.isConnected(this.mCallState)) {
            return false;
        }
        if (isChangeToConference()) {
            showToast(C0000R.string.change_to_conference_wait);
            logE("WAIT: change to conference");
            return false;
        }
        menu.clear();
        MenuInflater inflater = getMenuInflater();
        logI("---onCreateOptionsMenu");
        if (this.mDestination.getDestinationType() == 4 || this.mDestination.getDestinationType() == 5) {
            if (ModelInfoUtil.IS_MODEL_SCAMERA) {
                inflater.inflate(C0000R.menu.scamera_voice_call_group_menu, menu);
            } else {
                inflater.inflate(C0000R.menu.voice_call_group_menu, menu);
                menu.getItem(0).setVisible(false);
                if (this.mIsShareScreenWaitForAccepting || this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0) {
                    menu.getItem(2).setVisible(false);
                    menu.getItem(3).setVisible(false);
                } else if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
                    menu.getItem(2).setVisible(false);
                    menu.getItem(3).setVisible(true);
                } else {
                    if (MainApplication.mPhoneManager.getPhoneStateMachine().getNegoFeatureController().isConfShareScreen()) {
                        menu.getItem(2).setVisible(true);
                    } else {
                        menu.getItem(2).setVisible(false);
                    }
                    menu.getItem(3).setVisible(false);
                    if (this.mCallStatusData.getCallState() == 4) {
                        menu.getItem(2).setVisible(false);
                        invalidateOptionsMenu();
                    }
                }
            }
        } else if (ModelInfoUtil.IS_MODEL_SCAMERA) {
            inflater.inflate(C0000R.menu.scamera_voice_call_menu, menu);
        } else if (MainApplication.mPhoneManager.isTranslateTest()) {
            inflater.inflate(C0000R.menu.voice_call_menu, menu);
            menu.getItem(0).setVisible(false);
            if (MainApplication.mPhoneManager.isTranslateTest()) {
                if (!this.mIsTranslatorOptionMenuEnable) {
                    menu.getItem(1).setVisible(true);
                    menu.getItem(2).setVisible(false);
                } else {
                    menu.getItem(2).setVisible(true);
                    menu.getItem(1).setVisible(false);
                }
            } else {
                menu.getItem(1).setVisible(false);
                menu.getItem(2).setVisible(false);
            }
            if (this.mIsShareScreenWaitForAccepting || this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0) {
                menu.getItem(3).setVisible(false);
                menu.getItem(4).setVisible(false);
            } else if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
                menu.getItem(3).setVisible(false);
                menu.getItem(4).setVisible(true);
            } else {
                menu.getItem(3).setVisible(true);
                menu.getItem(4).setVisible(false);
                if (this.mCallStatusData.getCallState() == 4) {
                    menu.getItem(3).setVisible(false);
                }
            }
        } else {
            inflater.inflate(C0000R.menu.voice_call_menu_with_sharescreen, menu);
            if (this.mIsShareScreenWaitForAccepting || this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0) {
                menu.getItem(0).setVisible(false);
                menu.getItem(1).setVisible(false);
            } else if (this.mCallStatusData.isActiveShareScreen() == 1 || this.mCallStatusData.isActiveShareScreen() == 3) {
                menu.getItem(0).setVisible(false);
                menu.getItem(1).setVisible(true);
            } else {
                menu.getItem(0).setVisible(true);
                menu.getItem(1).setVisible(false);
                if (this.mCallStatusData.getCallState() == 4) {
                    menu.getItem(0).setVisible(false);
                    invalidateOptionsMenu();
                }
            }
        }
        OptionMenuLayout.setLayout(this);
        return super.onPrepareOptionsMenu(menu);
    }

    private boolean isChatOnMember() {
        ChatOnService chatonservice = ChatOnService.createService(MainApplication.mContext);
        String AccountId = ChatONStringConvert.getInstance().removeFooter(this.mDestination.getString());
        return chatonservice != null && chatonservice.isChatOnBuddy(AccountId) == 4;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void closeThemeShotEmotionalAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setMenuBtnEnable(boolean enable) {
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setMenuButtonEnable(enable);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void rejectRecordCall() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void clickableHoldButton() {
        this.mCallerImageLayout.setHoldBtnClickable();
        if (this.mVoiceCallTranslatorLayout != null && findViewLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString())) {
            this.mVoiceCallTranslatorLayout.setHoldBtnClickable();
        }
    }

    public void setMuteEnable(boolean enable) {
        this.mCallBtnLayout.updateMuteEnable(enable);
    }

    public void setChangeCallEnable(boolean enable) {
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.updateSwitchCallEnable(enable);
        }
    }

    public void setMuteBackGround(boolean MuteOn) {
        this.mCallBtnLayout.updateMuteBackGround(MuteOn);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleEarphonePlugged(boolean isPlugged) {
    }

    @Override // com.coolots.chaton.call.controller.IMemberViewController
    public void goneOtherViewForMemberView() {
    }

    @Override // com.coolots.chaton.call.controller.IMemberViewController
    public void showOtherViewForMemberView() {
        updateUIComponent();
    }

    @Override // com.coolots.chaton.call.controller.IMemberViewController
    public void updateLayoutChangeDestination() {
        this.mCalluserInfo = getCallOtherPartyUserInfo();
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setMember(this.mDestination, isOutGoingCall(), this.mCalluserInfo);
        }
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), 0, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0, this.mIsChangeToConference);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setMember(this.mDestination, this.mCalluserInfo, this.mCallState);
        }
        setCallerImageHandler();
    }

    @Override // com.coolots.chaton.call.controller.IInviteViewController
    public void viewTopStatusBar() {
    }

    public void InviteViewCheck() {
        if (this.mInviteviewMemberLayout != null) {
            if (!this.mInviteviewMemberLayout.isShowing()) {
                viewInviteView();
            } else {
                goneInviteView();
            }
        }
    }

    public void goneInviteView() {
        if (CallState.isConnected(this.mCallState) && this.mInviteViewCtrl != null && this.mInviteViewCtrl.isActive() && this.mInviteviewMemberLayout != null && this.mInviteviewMemberLayout.isShowing()) {
            this.mInviteviewMemberLayout.showInviteViewByAnimation(false);
        }
    }

    public void viewInviteView() {
        if (CallState.isConnected(this.mCallState) && this.mInviteViewCtrl != null && this.mInviteViewCtrl.isActive() && this.mInviteviewMemberLayout != null && !this.mInviteviewMemberLayout.isShowing()) {
            this.mInviteviewMemberLayout.showInviteViewByAnimation(true);
        }
    }

    @Override // com.coolots.chaton.call.controller.IInviteViewController
    public void showProgressBarInviteView() {
        if (!isConference()) {
            handleChangeToConferenceStart();
        }
    }

    @Override // com.coolots.chaton.call.controller.IInviteViewController
    public void disableButtonDuringInviteView() {
        logI("disableButtonDuringInviteView()");
        if (this.mCallBtnLayout != null) {
            this.mCallBtnLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination, true);
        }
        if (this.mCallerImageLayout != null) {
            this.mCallerImageLayout.setUIState(this.mIsOutGoingCall, this.mCallState, this.mDestination.getDestinationType(), 0, this.mDestinationUtil.getConferenceWaitCount(this.mDestination) > 0, this.mIsChangeToConference);
        }
    }

    @Override // com.coolots.chaton.call.controller.IInviteViewController
    public void updateLayoutNoInvite() {
        updateLayoutChangeDestination();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void showToastForShareView(int kind, String rejecterID) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void startShareView(boolean isStarter) {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopShareView() {
    }

    public void openChatService() {
        ChatOnService chatonservice = ChatOnService.createService(this);
        logI("openChatService No room number");
        if (isConference()) {
            logI("openChatService No room number conference");
            ArrayList<String> callmemberAccountIDlist = this.mDestinationUtil.getConferenceConnectUserIDList(this.mDestination, null);
            ArrayList<String> callmemberBuddyIDlist = chatonservice.getChatOnBuddyNumberAsIdList(callmemberAccountIDlist);
            chatonservice.openChatService(callmemberBuddyIDlist);
            return;
        }
        logI("openChatService No room number 1:1");
        String AccountId = ChatONStringConvert.getInstance().removeFooter(this.mDestination.getString());
        chatonservice.openChatService(chatonservice.getChatOnBuddyNumber(AccountId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceStart() {
        this.mIsChangeToConference = true;
        this.mMemberCount = getConferenceConnectCount();
        disableButtonDuringInviteView();
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
        if (this.mInviteviewMemberLayout != null) {
            setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 0);
            viewInviteView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFailure() {
        this.mIsChangeToConference = false;
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_fail);
        disableButtonDuringInviteView();
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
        if ((this.mInviteViewCtrl.isActive() || !isConference()) && this.mInviteviewMemberLayout != null) {
            this.mInviteViewCtrl.endInviteView();
            setVisibilityLayout(this.mFrameLayout1, this.mInviteviewMemberLayout.getClass().toString(), 8);
            goneInviteView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToConferenceFinish() {
        this.mIsChangeToConference = false;
        dismissChangeToConferenceDialog();
        showToast(C0000R.string.change_to_conference_finish);
        this.mMemberCount = -1;
        disableButtonDuringInviteView();
        if (this.mCallMemberLayout != null) {
            this.mCallMemberLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
        if (this.mCoverAccpetCallLayout != null) {
            this.mCoverAccpetCallLayout.setChangeConferenceCall(this.mIsChangeToConference);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void initPinchZoomControllerSwitchCamera() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeToP2PFailure() {
        logI("handleChangeToP2PFailure()");
        hangupCall();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentReject(int type, int option, ConsentDisplayInfo cdi) {
        logI("<CIH> notifyConsentReject()");
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        switch (type) {
            case 1:
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.call_switch_timercancel_voice));
                    }
                } else if (!cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID()) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getResources().getString(C0000R.string.call_switch_reject_msg_voice, getUserName(cdi.rejecterID)));
                }
                setChangeCallEnable(true);
                break;
            case 2:
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.share_view_toast_popup_5));
                        break;
                    }
                } else if ((cdi.rejecterID == null || !cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getResources().getString(C0000R.string.share_view_toast_popup_7, getUserName(cdi.rejecterID)));
                    break;
                }
                break;
            case 3:
                this.mIsShareScreenWaitForAccepting = false;
                setChangeCallEnable(true);
                this.mIsShareScreenCaller = false;
                if (cdi.isTimeout) {
                    if (cdi.isSender) {
                        showToast(getResources().getString(C0000R.string.screenshare_consent_timeout));
                        break;
                    }
                } else if ((cdi.rejecterID == null || !cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) && !"".equals(cdi.rejecterID) && cdi.rejecterID != null && !cdi.rejecterID.isEmpty()) {
                    showToast(getResources().getString(C0000R.string.screenshare_consent_reject, getUserName(cdi.rejecterID)));
                    break;
                }
                break;
            case 4:
                if (option == 2) {
                    if (!cdi.rejecterID.equals(MainApplication.mConfig.getProfileUserID())) {
                        showToast(getResources().getString(C0000R.string.call_consent_alert_msg_record_reject_video));
                        break;
                    }
                } else if (option != 1) {
                    logE("<CIH> option Error, option = " + option);
                    break;
                }
                break;
            case 5:
                showToast("번역이 거절되었습니다");
                break;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentAccept(int type, int option, ConsentDisplayInfo cdi) {
        logI("<CIH> notifyConsentAccept()");
        dismissCallConsentUserActionDialog();
        dismissCallConsentProcessingDialog();
        switch (type) {
            case 1:
                showToast(getResources().getString(C0000R.string.call_switch_accept_msg_voice));
                super.notifyConsentAccept(type, option, cdi);
                break;
            case 2:
                showToast(getResources().getString(C0000R.string.share_view_toast_popup_2));
                startShareView(cdi.isSender);
                break;
            case 3:
                this.mIsShareScreenWaitForAccepting = false;
                if (cdi.isSender) {
                    this.mIsShareScreenCaller = true;
                }
                dismissCallConsentProcessingDialog();
                break;
            case 4:
                if (option == 2) {
                    startRecordCallAfterConsent();
                    break;
                } else if (option != 1) {
                    logE("<CIH> option Error, option = " + option);
                    break;
                }
                break;
            case 5:
                if (MainApplication.mPhoneManager.isTranslateTest()) {
                    showToast("번역이 수락되었습니다");
                    this.mIsTranslatorOptionMenuEnable = true;
                    translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
                    this.mVoiceCallTranslatorLayout.setStartTranslatorUI();
                    initTranslatorViewController();
                    enableSpeakerMode();
                    initSTTTranslationTTSLanguage(cdi.isSender, TranslationUtil.get1stConsentParamLanguage(option), TranslationUtil.get2ndConsentParamLanguage(option));
                    break;
                }
                break;
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void notifyConsentRequestAskReceive(int type, int option, String requesterID) {
        closeOptionsMenu();
        dismissVoiceDialog();
        showCallConsentUserActionDialog(type, option, requesterID);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStart(TranslationDisplayData data) {
        logI("YKYU handleRecognitionStart()");
        logI("YKYU" + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleRecognitionStart(data);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionEnd(TranslationDisplayData data) {
        logI("YKYU handleRecognitionEnd() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU " + data.toString());
        boolean incomingMsgOnly = false;
        if (this.mTranslatorViewController != null) {
            incomingMsgOnly = this.mTranslatorViewController.getInComingMsgOnlyOnOff(data);
            this.mTranslatorViewController.handleRecognitionEnd(data, incomingMsgOnly);
        }
        if (!incomingMsgOnly && !startTranslation(data)) {
            Log.m2963i("YKYU Translation START ERROR!!!");
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleRecognitionStop() {
        logI("YKYU handleRecognitionStop()");
        this.mIsTranslatorOptionMenuEnable = false;
        closeSTTTranslationTTS(false);
        initSTTTranslationTTS();
        translatorChagneUi(this.mIsTranslatorOptionMenuEnable);
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationStart(TranslationDisplayData data) {
        logI("YKYU handleTranslationStart()");
        logI("YKYU" + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTranslationStart(data);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTranslationEnd(TranslationDisplayData data) {
        logI("handleTranslationEnd() " + data.getRecognizedText() + ",  " + data.getTranslatedText());
        logI("YKYU" + data.toString());
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTranslationEnd(data);
        }
        if (this.mBubbleTTSPlayer != null) {
            this.mBubbleTTSPlayer.play();
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSStart(String id) {
        logI(id);
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTTSStart(id);
        }
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void handleTTSEnd(String id) {
        logI(id);
        if (this.mTranslatorViewController != null) {
            this.mTranslatorViewController.handleTTSEnd(id);
        }
        if (this.mBubbleTTSPlayer != null) {
            this.mBubbleTTSPlayer.stop();
            this.mBubbleTTSPlayer.play();
        }
    }

    @Override // com.coolots.chaton.call.util.ITranslationTTSInterface
    public void TTS_Start(TranslationDisplayData data) {
        playTTS(data);
    }

    public void Start_BubbleTTSPlayer() {
        startTTSMode();
        if (this.mBubbleTTSPlayer == null) {
            this.mBubbleTTSPlayer = new BubbleTTSPlayer(this.mChatOnTranslationDataController, this);
        }
        this.mBubbleTTSPlayer.init();
    }

    public void End_BubbleTTSPlayer() {
        this.mBubbleTTSPlayer.finish();
        stopTTSMode();
    }

    public void translatorChagneUi(boolean isTranslator) {
        if (isTranslator) {
            this.mCallMemberLayout.setVisibility(8);
            this.mInviteviewMemberLayout.setVisibility(8);
            if (MainApplication.mPhoneManager.isTranslateTest()) {
                setVisibilityLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString(), 0);
                this.mVoiceCallTranslatorLayout.initHold();
                this.mCallTranslatorScrollViewLayout.setVisibility(0);
                this.mCallerImageLayout.displayHoldUI(false);
                return;
            }
            return;
        }
        if (MainApplication.mPhoneManager.isTranslateTest()) {
            setVisibilityLayout(this.mFrameLayout1, this.mVoiceCallTranslatorLayout.getClass().toString(), 8);
            this.mCallTranslatorScrollViewLayout.setVisibility(8);
            this.mCallerImageLayout.displayHoldUI(true);
        }
        this.mCallMemberLayout.setVisibility(0);
        this.mInviteviewMemberLayout.setVisibility(0);
    }

    public void initTranslatorViewController() {
        if (this.mTranslatorViewController == null) {
            this.mTranslatorViewController = new TranslatorViewController(getCallOtherPartyUserInfo().userName, this.mDestination, this.mChatOnTranslationDataController, this.mIsTranslatorIncomingMsgOnlyChecked);
            this.mTranslatorViewController.addITranslatorViewController(this.mCallTranslatorScrollViewLayout);
            this.mTranslatorViewController.addITranslatorViewController(this.mCallMemberLayout);
        } else {
            this.mTranslatorViewController.removeITranslatorViewController();
            this.mTranslatorViewController.addITranslatorViewController(this.mCallTranslatorScrollViewLayout);
            this.mTranslatorViewController.addITranslatorViewController(this.mCallMemberLayout);
            this.mTranslatorViewController.loadAllDatatoTranslatorView();
        }
        this.mVoiceCallTranslatorLayout.setTranslateModeValue(this.mTranslatorViewController.getTranslateModeValue());
    }

    public void enableSpeakerMode() {
        getAudioPathController().onClickSpeakerButton();
        enableSpeakerButton();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeInAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void startFadeOutAnimation() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isRecordingVideo() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallSweepRight() {
        if (isDrivingModeUIOn()) {
            receiveCall();
        } else {
            this.mCallReceiveBtnLayout.airCallSweepRight();
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void airCallHandShape() {
        if (isDrivingModeUIOn()) {
            receiveCall();
            return;
        }
        this.mCallReceiveBtnLayout.airCallHandShape();
        if (isAirGestureAcceptCallSpeakerOn()) {
            this.mAudioPathController.initCallConnectedByBargeIn(false);
        }
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setOptionMenuDialog(int menuId) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isCartoonView() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setClearCover() {
        logE("setClearCover() isCoverOpen" + isCoverOpen());
        MainApplication.mPhoneManager.getPhoneStateMachine().setClearCoverScreenLock(isCoverOpen());
        if (isCoverOpen()) {
            this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(65536, false));
            checkHookingHomeKeyforCover(true);
            if (!isDrivingModeUIOn()) {
                setRequestedOrientation(5);
            } else {
                setRequestedOrientation(2);
            }
        } else {
            this.mStatusBarManager.disable(ChatONStatusBarController.setFlag(65536, true));
            checkHookingHomeKeyforCover(false);
            setRequestedOrientation(1);
        }
        updateUIComponent();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setAlterImage() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void displayShareScreenAttention() {
        startShareScreen();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupEntitlement() {
        showToast(getString(C0000R.string.information_str_msg_22, new Object[]{611}));
        hangupCall();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void hangupNetworkErrorEntitlement() {
        showToast(C0000R.string.information_str_msg_23);
        hangupCall();
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public long getNowDateSetting() {
        Date d = MainApplication.mPhoneManager.getPhoneStateMachine().getCallConnectedTime();
        if (d == null) {
            return 0L;
        }
        Date dN = new Date();
        dNow = dN.getTime() - d.getTime();
        return dNow;
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void setMuteStateForVideo(boolean muteOn) {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void setHangUpCallUI() {
        SetDisconnectCallLayout();
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void removeRecordUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    protected void errorForUI() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void startRecordTime() {
    }

    @Override // com.sds.coolots.call.view.CallActivity
    public void stopRecordFromEngine() {
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public boolean isShowingAnimationMenu() {
        return false;
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void updateChangeCall() {
        setChangeCallEnable(true);
    }

    @Override // com.coolots.chaton.call.view.ChatOnCallActivity
    public void cancelSlectedThemeShot() {
    }
}
