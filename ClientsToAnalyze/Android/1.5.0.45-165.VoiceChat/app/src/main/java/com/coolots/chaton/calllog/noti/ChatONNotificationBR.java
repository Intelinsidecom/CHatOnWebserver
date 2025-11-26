package com.coolots.chaton.calllog.noti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatONNotificationBR extends BroadcastReceiver {
    private static final String CLASSNAME = "[ChatONNotificationBR]";
    public static final String MISSED_CALL_CREATE_ACTION_NAME = "com.coolots.chaton.MISSEDCALL_CREATE_NOTIFICATION";
    public static final String MISSED_CALL_DELETE_ACTION_NAME = "com.coolots.chaton.MISSEDCALL_DELETE_NOTIFICATION";
    public static final String REJECT_MSG_CREATE_ACTION_NAME = "com.coolots.chaton.REJECT_MSG_CREATE_NOTIFICATION";
    public static final String REJECT_MSG_DELETE_ACTION_NAME = "com.coolots.chaton.REJECT_MSG_DELETE_NOTIFICATION";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        logI("action: " + action);
        if (MISSED_CALL_CREATE_ACTION_NAME.equals(action)) {
            MainApplication.mContext.startActivity(ChatONNotificationManager.getInstance().createCallLogMissedCallIntent());
            return;
        }
        if (MISSED_CALL_DELETE_ACTION_NAME.equals(action)) {
            ChatONNotificationManager.getInstance().notifyCancel(1000);
        } else if (REJECT_MSG_CREATE_ACTION_NAME.equals(action)) {
            MainApplication.mContext.startActivity(ChatONNotificationManager.getInstance().createCallLogRejectMsgIntent());
        } else if (REJECT_MSG_DELETE_ACTION_NAME.equals(action)) {
            ChatONNotificationManager.getInstance().notifyCancel(2000);
        }
    }
}
