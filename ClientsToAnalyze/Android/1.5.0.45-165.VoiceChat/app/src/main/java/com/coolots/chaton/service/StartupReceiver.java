package com.coolots.chaton.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.util.ChatONVAccountUtil;
import com.sds.coolots.call.entitlement.EntitlementController;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class StartupReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[CoolotsStartupReceiver]";
    private static final int HANDLER_WHAT_KILLPROCESS = 123;

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if (!ChatONVAccountUtil.checkCooLotsAccountValidity(context)) {
                VAppPhoneManager.stopCoolotsService(context);
                KillProcessHandler handler = new KillProcessHandler();
                handler.init();
                handler.sendEmptyMessage(HANDLER_WHAT_KILLPROCESS);
                return;
            }
            String intentAction = intent.getAction();
            if (intentAction.equals("android.intent.action.BOOT_COMPLETED")) {
                handleBootCompleted(context);
                handleCheckEntitlement(context);
            }
        }
    }

    private void handleBootCompleted(Context context) {
        logI("handleBootCompleted : android.intent.action.BOOT_COMPLETED");
        if (!VAppPhoneManager.startCoolotsService(context, false)) {
            logE("handleBootCompleted : Could not start service ");
        }
    }

    private void handleCheckEntitlement(Context context) {
        logI("handleCheckEntitlement()");
        EntitlementController.removeAllData(context);
    }

    class KillProcessHandler extends Handler {
        boolean dispose = false;

        KillProcessHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (this.dispose && msg.what == StartupReceiver.HANDLER_WHAT_KILLPROCESS) {
                StartupReceiver.this.logI("kill process");
                Process.killProcess(Process.myPid());
                this.dispose = false;
            }
        }

        public void init() {
            this.dispose = true;
        }
    }
}
