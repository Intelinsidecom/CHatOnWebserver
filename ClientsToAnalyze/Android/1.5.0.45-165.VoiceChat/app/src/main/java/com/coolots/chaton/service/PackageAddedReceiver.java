package com.coolots.chaton.service;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.login.SPPPushManager;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManagerInterface;
import java.util.List;

/* loaded from: classes.dex */
public class PackageAddedReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[PackageAddedReceiver]";
    private static final String PACKAGE_NAME_COOLOTS = "com.coolots.chaton";
    private static final String PACKAGE_NAME_SPP = "com.sec.spp.push";
    public NotificationManager mNotificationManager = null;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String userID;
        PushManagerInterface pushManager;
        logI("haeri=onReceive");
        String action = intent.getAction();
        String packageName = intent.getData().getSchemeSpecificPart();
        if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
            logI("Pacakge added: " + action + ", " + packageName);
            if (PACKAGE_NAME_SPP.equals(packageName) && (userID = MainApplication.mConfig.getProfileUserID()) != null && !userID.isEmpty() && (pushManager = getSPPPushManager()) != null) {
                pushManager.registerDevice(MainApplication.mConfig.getProfileUserID(), MainApplication.mConfig.getProfileDeviceID(), EngineInterface.getInstance());
                return;
            }
            return;
        }
        if ("android.intent.action.PACKAGE_INSTALL".equals(action)) {
            logI("Pacakge install: " + action + ", " + packageName);
            return;
        }
        if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
            if (!intent.getBooleanExtra("android.intent.extra.REPLACING", false)) {
                logI("Pacakge removed: " + action + ", " + packageName);
            }
        } else if ("android.intent.action.PACKAGE_CHANGED".equals(action)) {
            logI("Pacakge changed: " + action + ", " + packageName);
        } else if ("android.intent.action.PACKAGE_REPLACED".equals(action)) {
            logI("Pacakge replaced: " + action + ", " + packageName);
            if (PACKAGE_NAME_COOLOTS.equals(packageName)) {
                VAppPhoneManager.startCoolotsService(context, false);
            }
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
}
