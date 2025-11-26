package com.coolots.chaton.common.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.widget.Toast;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.model.EventCode;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CoolotsCallStateEventReceiver extends BroadcastReceiver {
    public static final String ACTION_PHONE_STATE_CHANGED = "android.intent.action.PHONE_STATE";
    public static final String ACTION_SS_INFO_CLI = "android.intent.action.SS_INFO_CLI";
    private static final String CLASSNAME = "[CoolotsCallStateReceiver]";
    private int mPreCallState = 0;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void handleIdleMode(CallStatusData callInfo) {
        int coolotsMode = MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentCoolotsPhoneState();
        logI("onReceive() : state IDLE , mMode: " + coolotsMode);
        switch (coolotsMode) {
            case 0:
                this.mPreCallState = 0;
                break;
            case 3:
                if (CallState.isConnected(callInfo.getCallState())) {
                    MainApplication.mPhoneManager.getHardwareManager().setModeConnectedFor3GIdleMode(false);
                }
                if (callInfo.getCallState() == 4 && !MainApplication.mPhoneManager.getPhoneStateMachine().isHoldBeforeNative()) {
                    logI("Multiple_Call There is Holding ChatONV Voice Call - Return Activate!");
                    if (this.mPreCallState == 5) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(callInfo.getDestination(), 1);
                    } else {
                        MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(callInfo.getDestination(), 0);
                    }
                    this.mPreCallState = 2;
                    if (callInfo.isPlayHoldTone()) {
                        if (coolotsMode == 4) {
                            MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(true);
                        } else if (coolotsMode == 3) {
                            MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(false);
                        } else {
                            MainApplication.mPhoneManager.getHardwareManager().setModeStopHold(false);
                        }
                    }
                }
                if (this.mPreCallState == 5) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(callInfo.getDestination());
                }
                this.mPreCallState = 2;
                MainApplication.mPhoneManager.getPhoneStateMachine().moveToTopForDelayAfter3G(callInfo, MainApplication.mPhoneManager.getPhoneStateMachine().isUseSpeakerBeforeNative());
                MainApplication.mPhoneManager.getPhoneStateMachine().resetBackupCallState();
                break;
            case 4:
                logI("<<moon>> Multiple_Call There is ChatONV Video Call - noti to Activity : end of 3G call");
                Message msg = new Message();
                msg.what = EventCode.EVENT_CALL_3G_IDLE_WHILE_VT;
                if (MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity() != null) {
                    if (callInfo.getCallState() == 4 && !MainApplication.mPhoneManager.getPhoneStateMachine().isHoldBeforeNative()) {
                        msg.arg1 = 1;
                    } else {
                        msg.arg1 = 0;
                    }
                    if (this.mPreCallState == 5) {
                        msg.arg2 = 1;
                    } else {
                        msg.arg2 = 0;
                    }
                    this.mPreCallState = 2;
                    if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity().sendHandlerMessage(msg, 0L);
                    } else {
                        MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(msg);
                    }
                } else {
                    if (!MainApplication.mPhoneManager.getPhoneStateMachine().isHidemeBeforeNative()) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().stopHideMeVideoCall(callInfo.getDestination());
                    }
                    MainApplication.mPhoneManager.getHardwareManager().setModeConnectedFor3GIdleMode(true);
                    if (callInfo.getCallState() == 4 && !MainApplication.mPhoneManager.getPhoneStateMachine().isHoldBeforeNative()) {
                        if (this.mPreCallState == 5) {
                            MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(callInfo.getDestination(), 1);
                        } else {
                            MainApplication.mPhoneManager.getPhoneStateMachine().setUnHoldFor3GIdle(callInfo.getDestination(), 0);
                        }
                        this.mPreCallState = 2;
                    }
                    if (this.mPreCallState == 5) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().muteCall(callInfo.getDestination());
                    }
                    this.mPreCallState = 2;
                }
                MainApplication.mPhoneManager.getPhoneStateMachine().moveToTopForDelayAfter3G(callInfo, MainApplication.mPhoneManager.getPhoneStateMachine().isUseSpeakerBeforeNative());
                MainApplication.mPhoneManager.getPhoneStateMachine().resetBackupCallState();
                break;
        }
    }

    private void handleRingingMode(CallStatusData callInfo, String phoneNum) {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopRecordCall(callInfo.getDestination());
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getStringRecordStopPopup();
            String rscString = "";
            if (rscNumber > 0) {
                rscString = MainApplication.mContext.getString(rscNumber);
            }
            Toast.makeText(MainApplication.mContext, rscString, 2000).show();
        }
        switch (MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentCoolotsPhoneState()) {
            case 0:
                logI("Multiple_Call There is no ChatONV Call - Do Nothing!");
                break;
            case 3:
                if (CallState.isCalling(callInfo.getCallState())) {
                    logI("Multiple_Call There is ChatONV Voice Call (Calling state) - ChatONV hangup!");
                    hangUpCurrentCoolotsAudioCall();
                    break;
                } else {
                    boolean useSpeakerBeforeNative = MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext);
                    if (callInfo.getCallState() == 4) {
                        logI("Multiple_Call ChatONV Call is already hold - Do Nothing!");
                        MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(useSpeakerBeforeNative, true, false);
                        break;
                    } else {
                        logI("Multiple_Call This is 3G Call - ChatONV Holding!");
                        if (5 == callInfo.getCallState()) {
                            MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
                            this.mPreCallState = 5;
                        }
                        MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(callInfo.getDestination());
                        MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
                        MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(useSpeakerBeforeNative, false, false);
                        break;
                    }
                }
            case 4:
                if (CallState.isCalling(callInfo.getCallState())) {
                    logI("Multiple_Call There is ChatONV Video Call (Calling state) - ChatONV hangup!");
                    hangUpCurrentCoolotsVideoCall();
                    break;
                } else {
                    logI("Multiple_Call There is ChatONV Video Call");
                    boolean isPreHideState = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
                    if (callInfo.getCallState() == 4) {
                        logI("Multiple_Call ChatONV Call is already hold - Do Nothing!");
                        MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(true, true, isPreHideState);
                    } else {
                        logI("Multiple_Call This is 3G Call - ChatONV Holding!");
                        if (5 == callInfo.getCallState()) {
                            MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
                            this.mPreCallState = 5;
                        }
                        MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(callInfo.getDestination());
                        MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
                        MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(true, false, isPreHideState);
                    }
                    logI("Multiple_Call There is ChatONV Video Call - noti to Activity - 3G Ringing");
                    Message msg = new Message();
                    msg.what = EventCode.EVENT_CALL_3G_RINGING_WHILE_VT;
                    msg.obj = phoneNum;
                    if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                        MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity().sendHandlerMessage(msg, 0L);
                        break;
                    } else {
                        MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(msg);
                        break;
                    }
                }
        }
        if (MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentMobileCallType() == 1) {
            MainApplication.mPhoneManager.getHardwareManager().getSoundManager().restoreSpeakerFor3G();
        }
    }

    private void handleCallingMode(CallStatusData callInfo) {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isRecording()) {
            MainApplication.mPhoneManager.getPhoneStateMachine().stopRecordCall(callInfo.getDestination());
            int rscNumber = ((ChatOnResourceInterface) MainApplication.mResources).getStringRecordStopPopup();
            String rscString = "";
            if (rscNumber > 0) {
                rscString = MainApplication.mContext.getString(rscNumber);
            }
            Toast.makeText(MainApplication.mContext, rscString, 2000).show();
        }
        int coolotsMode = MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentCoolotsPhoneState();
        logI("Multiple_Call 3G Call State is OFF_HOOK");
        if (coolotsMode != 0) {
            logI("Multiple_Call There is ChatONV Call");
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(true);
            logI("QuickPanel -delete call noti!!!");
            MainApplication.mCallNotification.deleteCallNotification();
            logI("Multiple_Call This is 3G InComing Call");
            switch (coolotsMode) {
                case 3:
                    if (CallState.isCalling(callInfo.getCallState())) {
                        logI("Multiple_Call There is ChatONV Voice Call (Calling state) - ChatONV hangup!");
                        hangUpCurrentCoolotsAudioCall();
                    } else {
                        logI("Multiple_Call There is ChatONV Voice Call");
                        boolean useSpeakerBeforeNative = MainApplication.mPhoneManager.getHardwareManager().getSoundManager().isSpeakerOn(MainApplication.mContext);
                        if (callInfo.getCallState() == 4) {
                            logI("Multiple_Call ChatONV Call is already hold - Do Nothing!");
                            MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(useSpeakerBeforeNative, true, false);
                        } else {
                            logI("Multiple_Call This is 3G Call - ChatONV Holding!");
                            if (5 == callInfo.getCallState()) {
                                MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
                                this.mPreCallState = 5;
                            }
                            MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(callInfo.getDestination());
                            MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
                            MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(useSpeakerBeforeNative, false, false);
                        }
                    }
                    ChatONStatusBarController.clearFlag();
                    break;
                case 4:
                    if (CallState.isCalling(callInfo.getCallState())) {
                        logI("Multiple_Call There is ChatONV Video Call - ChatONV hangup!");
                        hangUpCurrentCoolotsVideoCall();
                    } else {
                        logI("Multiple_Call There is ChatONV Video Call");
                        boolean isPreHideState = MainApplication.mPhoneManager.getPhoneStateMachine().getHideState();
                        if (callInfo.getCallState() == 4) {
                            logI("Multiple_Call ChatONV Call is already hold - Do Nothing!");
                            MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(true, true, isPreHideState);
                        } else {
                            logI("Multiple_Call This is 3G Call - ChatONV Holding!");
                            if (5 == callInfo.getCallState()) {
                                MainApplication.mPhoneManager.getPhoneStateMachine().unMuteCall(callInfo.getDestination());
                                this.mPreCallState = 5;
                            }
                            MainApplication.mPhoneManager.getPhoneStateMachine().holdCall(callInfo.getDestination());
                            MainApplication.mPhoneManager.getHardwareManager().setModeStartHold();
                            MainApplication.mPhoneManager.getPhoneStateMachine().backupCallStateBeforNative(true, false, isPreHideState);
                        }
                        logI("Multiple_Call There is ChatONV Video Call - noti to Activity - 3G Ringing");
                        Message msg = new Message();
                        msg.what = EventCode.EVENT_CALL_3G_CALLING_WHILE_VT;
                        msg.obj = "";
                        if (MainApplication.mPhoneManager.getCoolotsEventListener() == null) {
                            MainApplication.mPhoneManager.getPhoneStateMachine().getCallingActivity().sendHandlerMessage(msg, 0L);
                        } else {
                            MainApplication.mPhoneManager.getCoolotsEventListener().onCallEvent(msg);
                        }
                    }
                    ChatONStatusBarController.clearFlag();
                    break;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        MainApplication.mPhoneManager.getPhoneStateMachine().updateMobilePhoneState();
        if (intent.getAction().equals(ACTION_PHONE_STATE_CHANGED)) {
            logE("<<YHT3>> RECEIVE CALL STATE INTENT!! TYPE:" + intent.getBooleanExtra(((ChatOnResourceInterface) MainApplication.mResources).getExtraVoipCallstate(), false));
            if (!intent.getBooleanExtra(((ChatOnResourceInterface) MainApplication.mResources).getExtraVoipCallstate(), false)) {
                boolean isVideoCall = intent.getBooleanExtra("VOIPCALL_CHECK_CSCALL", true);
                if (isVideoCall) {
                    logE("<<YHT3>> VIDEO CALL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                } else {
                    logE("<<YHT3>> VOICE CALL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
                switch (MainApplication.mPhoneManager.getPhoneStateMachine().getCurrentMobilePhoneState()) {
                    case 0:
                        handleIdleMode(callInfo);
                        break;
                    case 1:
                        String incoming_number = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
                        handleRingingMode(callInfo, incoming_number);
                        break;
                    case 2:
                        handleCallingMode(callInfo);
                        break;
                }
            }
        }
    }

    private void hangUpCurrentCoolotsAudioCall() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        if (callInfo.isValidity() && !CallState.isDisconnected(callInfo.getCallState())) {
            MainApplication.mPhoneManager.getPhoneStateMachine().localHangupCall(callInfo.getDestination(), 1004);
        }
    }

    private void hangUpCurrentCoolotsVideoCall() {
        hangUpCurrentCoolotsAudioCall();
    }
}
