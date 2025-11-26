package com.coolots.chaton.common.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ServiceWakeUpReceiver extends BroadcastReceiver {
    public static final String ACTION_CHECK_SERVICE = "action_check_service";
    public static final String ACTION_RESTART_SERVICE = "action_restart_service";
    private static final String CLASSNAME = "[ServiceWakeUpReceiver]";
    public static final int DURATION_TO_CHECK_SERVICE = 1800000;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(ACTION_RESTART_SERVICE)) {
            VAppPhoneManager.startCoolotsService(context, false);
            return;
        }
        if (intent.getAction() != null && intent.getAction().equals(ACTION_CHECK_SERVICE)) {
            logI("<<YHT3>> CHECK START SERVICE!!");
            if (!VAppPhoneManager.isCoolotsServiceRunning(context)) {
                logE("<<YHT3>> startService!!");
                VAppPhoneManager.startCoolotsService(context, false);
            }
        }
    }
}
