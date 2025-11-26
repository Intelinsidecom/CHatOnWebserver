package com.coolots.chaton.call.screenshare.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.coolots.chaton.call.screenshare.ScreenShareProc;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ScreenShareMessageReceiver extends BroadcastReceiver {
    public static final String CHATON_MSG_RECEIVED = "com.sec.chaton.chat.PUSH_RECEIVED";
    private static final String CLASSNAME = "[ScreenShareMessageReceiver]";
    public static final String PUSH_RECEIVED = "android.provider.Telephony.WAP_PUSH_RECEIVED";
    public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static boolean isShareScreen = false;

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public static void setShare(boolean flag) {
        isShareScreen = flag;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        logI("haeri=Intent recieved: " + intent.getAction());
        if (intent.getAction().equals(SMS_RECEIVED) && isShareScreen) {
            ScreenShareProc.setMessagePause();
        }
        if (intent.getAction().equals(PUSH_RECEIVED)) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String type = intent.getType();
                if (type.trim().equalsIgnoreCase("application/vnd.wap.mms-message") && isShareScreen) {
                    ScreenShareProc.setMessagePause();
                }
            }
        }
        if (intent.getAction().equals(CHATON_MSG_RECEIVED) && isShareScreen) {
            ScreenShareProc.setMessagePause();
        }
    }
}
