package com.coolots.chaton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.login.GCMPushManager;
import com.google.android.gcm.GCMBaseIntentService;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManagerInterface;
import java.util.List;

/* loaded from: classes.dex */
public class GCMIntentService extends GCMBaseIntentService {
    private static final String CLASSNAME = "[GCMIntentService]";
    public static final String GCM_SENDER_ID = "1036180741787";
    private static final String MESSAGE_KEY = "msg";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public GCMIntentService() {
        super(GCM_SENDER_ID);
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    protected void onError(Context context, String errorCode) {
        logE("<<YHT2>> onError!!!!!! errorCode:" + errorCode);
        PushManagerInterface pushManager = getGCMPushManager();
        if (pushManager != null) {
            pushManager.setErrorCode(0);
        }
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    protected void onMessage(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String mMessage = extras.getString("msg");
            logE("<<YHT2>> onMessage!!!!!! mMessage:" + mMessage);
            PushManagerInterface pushManager = getGCMPushManager();
            if (pushManager != null) {
                if (VAppPhoneManager.isCoolotsServiceRunning(context)) {
                    pushManager.onReceivePushMessage(3, mMessage);
                } else if (VAppPhoneManager.startCoolotsService(context, false)) {
                    logE("startCooLots Service to handle received push message");
                    pushManager.onReceivePushMessage(3, mMessage);
                }
            }
        }
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    protected void onRegistered(Context context, String regID) {
        PushManagerInterface pushManager = getGCMPushManager();
        if (pushManager != null) {
            pushManager.setRegisterStatus(true, regID);
        }
    }

    @Override // com.google.android.gcm.GCMBaseIntentService
    protected void onUnregistered(Context context, String regID) {
        PushManagerInterface pushManager = getGCMPushManager();
        if (pushManager != null) {
            pushManager.setRegisterStatus(false, "");
        }
    }

    private PushManagerInterface getGCMPushManager() {
        List<PushManagerInterface> pushManagerList = MainApplication.mPhoneManager.getPushManager();
        if (pushManagerList == null) {
            return null;
        }
        for (PushManagerInterface pushManager : pushManagerList) {
            if (pushManager instanceof GCMPushManager) {
                return pushManager;
            }
        }
        return null;
    }
}
