package com.coolots.chaton.common.controller;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.coolots.chaton.common.util.ChatOnConfigInterface;
import com.coolots.chaton.login.SPPPushManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallState;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.controller.PhoneManager;
import com.sds.coolots.common.model.CoolotsWakeLockList;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManagerInterface;
import java.util.List;

/* loaded from: classes.dex */
public class CoolotsEventReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[EventReceiver]";
    static final String EXTRA_CALLTYPE = "android.phone.extra.calltype";
    static final String EXTRA_VTCALL = "android.intent.extra.VTCallDialer";

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent incomingIntent) throws SecurityException {
        if (incomingIntent != null) {
            String intentAction = incomingIntent.getAction();
            if (MainApplication.mPhoneManager.getClientType() == 2) {
                logE("<<SPP>> intentAction:" + intentAction);
            }
            if (intentAction.equals("android.intent.action.NEW_OUTGOING_CALL")) {
                handleOutGoingCall(incomingIntent, context);
            }
            if (intentAction.equals("android.intent.action.MEDIA_MOUNTED") || intentAction.equals("android.intent.action.MEDIA_UNMOUNTED") || intentAction.equals("android.intent.action.MEDIA_EJECT")) {
                handleExternalStorageChange();
                return;
            }
            if (intentAction.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                handleNetworkConnectivityChange(context, false);
                return;
            }
            if (intentAction.equals("android.net.wifi.STATE_CHANGE")) {
                handleNetworkConnectivityChange(context, true);
                return;
            }
            if (intentAction.equals(IntentName.ACTION_ALARM_NONCE_TIME)) {
                handleNonceEvent(context);
                return;
            }
            if (intentAction.equals(IntentName.ACTION_ALARM_NONCE_DELETE_TIME)) {
                handleNonceDeleteEvent();
                return;
            }
            if (intentAction.equals(IntentName.ACTION_ALARM_GOES_OFF)) {
                handleWakeUpEvent();
                return;
            }
            if (intentAction.equals(IntentName.ACTION_ALARM_PUSH_REREGISTER)) {
                handleSPPReRegister();
                return;
            }
            if (intentAction.equals("android.intent.action.AIRPLANE_MODE")) {
                handleChangeAirplaneMode(context);
                return;
            }
            if (intentAction.equals("android.intent.action.LOCALE_CHANGED")) {
                CallStatusData callInfo = new CallStatusData();
                MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
                if (CallState.isCalling(callInfo.getCallState()) || CallState.isConnected(callInfo.getCallState())) {
                    logI("Quickpanel - update! when LOCALE changed!!");
                    MainApplication.mCallNotification.showCallButtonNotification();
                    return;
                }
                return;
            }
            if (intentAction.equals("android.intent.action.HEADSET_PLUG") || intentAction.equals("android.intent.action.DOCK_EVENT") || intentAction.equals(((ChatOnConfigInterface) MainApplication.mConfig).getBTConnectActionName()) || intentAction.equals(((ChatOnConfigInterface) MainApplication.mConfig).getBTAudioPathActionName())) {
                if (intentAction.equals("android.intent.action.HEADSET_PLUG")) {
                    handleHeadsetPlug(incomingIntent);
                }
                handleAudioPathEvent(incomingIntent);
                return;
            }
            if (intentAction.equals("android.intent.action.SCREEN_OFF")) {
                if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentMobileCall()) {
                    logI("haeri=3G call connected!!!!!!!!!!!!!!!!!!!");
                    return;
                }
                ActivityManager activityManager = (ActivityManager) MainApplication.mContext.getSystemService("activity");
                List<ActivityManager.RunningTaskInfo> info = activityManager.getRunningTasks(1);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
                    if (runningTaskInfo.topActivity.getClassName().equals("com.coolots.chaton.call.view.VoiceCallActivity") || runningTaskInfo.topActivity.getClassName().equals("com.coolots.chaton.call.view.VideoCallActivity") || runningTaskInfo.topActivity.getClassName().equals("com.coolots.chaton.call.view.LiveShareViewActivity")) {
                        logI("CallActivity is running!!!!!!!");
                        return;
                    }
                }
                MainApplication.mCallNotification.showCallButtonNotification();
                MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(true);
                return;
            }
            if (intentAction.equals(IntentName.ACTION_ALARM_PREVENT_UMTS)) {
                handlePreventUMTSEvent();
            }
        }
    }

    private void handlePreventUMTSEvent() {
        if (MainApplication.mPhoneManager.getPreventUMTSManager() != null) {
            MainApplication.mPhoneManager.getPreventUMTSManager().sendPreventUMTSAlarm();
        }
    }

    private void handleHeadsetPlug(Intent intent) {
        if (intent.hasExtra("state")) {
            if (intent.getIntExtra("state", 0) == 1) {
                MainApplication.mPhoneManager.getPhoneStateMachine().setEarPhone(true);
            } else {
                MainApplication.mPhoneManager.getPhoneStateMachine().setEarPhone(false);
            }
        }
    }

    private void handleAudioPathEvent(Intent intent) {
        MainApplication.mPhoneManager.getPhoneStateMachine().setAudioPathInfo(intent);
    }

    private void handleChangeAirplaneMode(Context context) {
        boolean bEnableAirplaneMode = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        logE("<<handleChangeAirplaneMode>> Current AirPlaneMode : " + bEnableAirplaneMode);
        if (bEnableAirplaneMode) {
            logE("<<handleChangeAirplaneMode>> handleChangeAirplaneMode!! Current AirPlaneMode!!");
            if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentCallOccupied()) {
                MainApplication.mPhoneManager.getPhoneStateMachine().hangUpCurrentCoolotsCall(300);
            }
        }
    }

    private void handleSPPReRegister() {
        PushManagerInterface pushManager = getSPPPushManager();
        if (pushManager != null) {
            pushManager.reRegister();
        }
    }

    private PushManagerInterface getSPPPushManager() {
        List<PushManagerInterface> pushManagerList = MainApplication.mPhoneManager.getPushManager();
        if (pushManagerList == null) {
            return null;
        }
        for (PushManagerInterface pushManager : pushManagerList) {
            if (pushManager instanceof SPPPushManager) {
                return pushManager;
            }
        }
        return null;
    }

    private void handleOutGoingCall(Intent incomingIntent, Context context) {
        logE("handleConnectivityAction : android.intent.action.NEW_OUTGOING_CALL");
        if (incomingIntent == null) {
        }
    }

    private void handleExternalStorageChange() {
        logE("handleExternalStorageChange()");
        ((ChatOnConfigInterface) MainApplication.mConfig).getSDCardWritable(true);
    }

    private void handleNetworkConnectivityChange(Context context, boolean isWIFIEvent) {
        if (!PhoneManager.isNetworkConnected(context)) {
            if (!isWIFIEvent || !MainApplication.mPhoneManager.isStartedRequestHIPRI()) {
                logI("[handleNetworkConnectivityChange] network disconnected!");
                if (MainApplication.mPhoneManager.getPhoneStateMachine().isCurrentCallOccupied()) {
                    MainApplication.mPhoneManager.getPhoneStateMachine().hangUpCurrentCoolotsCall(300);
                }
                if (PhoneManager.mSupportTcp) {
                    MainApplication.mPhoneManager.getLoginManager().logout(true);
                    return;
                }
                return;
            }
            return;
        }
        if (!MainApplication.mPhoneManager.getLoginManager().isLogin()) {
            if (PhoneManager.mSupportTcp || !MainApplication.mPhoneManager.getLoginManager().isDuringLogin()) {
                MainApplication.mPhoneManager.getLoginManager().login();
                return;
            }
            return;
        }
        if (!MainApplication.mPhoneManager.getLoginManager().isValidNonce()) {
            MainApplication.mPhoneManager.getLoginManager().sendNonceAsk();
        }
        if (PhoneManager.mSupportTcp) {
            MainApplication.mPhoneManager.getLoginManager().login();
        }
    }

    private void handleWakeUpEvent() {
        logE("handleWakeUpEvent : com.sds.coolots.ACTION_ALARM_GOES_OFF");
        if (PhoneManager.mSupportTcp) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().acquirePartialWakeLock(CoolotsWakeLockList.WAKELOCK_TAG_KEEPALIVE);
        }
    }

    private void handleNonceEvent(Context context) {
        logE("<<YHT2>> handleNonceEvent : nonce changed");
        if (!PhoneManager.isNetworkConnected(context)) {
            MainApplication.mPhoneManager.getLoginManager().setNonce("");
        } else {
            MainApplication.mPhoneManager.getLoginManager().sendNonceAsk();
        }
    }

    private void handleServerInfoEvent(Context context) {
        logE("<<YHT2>> handleServerInfoEvent : serverInfo changed");
        if (!PhoneManager.isNetworkConnected(context)) {
            MainApplication.mPhoneManager.getLoginManager().resetServerInfo();
        } else {
            MainApplication.mPhoneManager.getLoginManager().sendServerInfoAsk();
        }
    }

    private void handleNonceDeleteEvent() {
        logE("<<YHT3>> handleNonceDeleteEvent : nonce delete:");
        MainApplication.mPhoneManager.getLoginManager().deleteNonce();
    }
}
