package com.coolots.chaton.calllog.noti;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public final class ChatONNotificationManager {
    public static final int CHATON_V_MISSED_CALL_NOTI_ID = 1000;
    public static final int CHATON_V_REJECT_MSG_NOTI_ID = 2000;
    private static final String CLASSNAME = "[ChatONNotificationManager]";
    private static ChatONNotificationManager instance = new ChatONNotificationManager();
    private int mMissedCallCnt;
    private NotificationManager mMissedCallNotiManager;
    private int mRejectMsgCnt;
    private NotificationManager mRejectMsgNotiManager;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private ChatONNotificationManager() {
        this.mMissedCallNotiManager = null;
        this.mRejectMsgNotiManager = null;
        logI("[ChatONNotificationManager] new Instance");
        this.mMissedCallCnt = 0;
        this.mRejectMsgCnt = 0;
        this.mMissedCallNotiManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
        this.mRejectMsgNotiManager = (NotificationManager) MainApplication.mContext.getSystemService("notification");
    }

    public static ChatONNotificationManager getInstance() {
        return instance;
    }

    public void notifyMissedCall(long callSeconds, String username, String phoneNumber, int iconID, int tickerStringID, int missedCallTitleID, int missedCallsTitle, int missedCallsMsg) {
        String titleText;
        String expandedText;
        logI("notifyMissedCall()");
        String displayName = getDisplayName(username, phoneNumber);
        Notification notification = new Notification();
        notification.icon = iconID;
        if (tickerStringID == 0) {
            notification.tickerText = "";
        } else {
            notification.tickerText = MainApplication.mContext.getString(tickerStringID, displayName);
        }
        notification.when = callSeconds;
        this.mMissedCallCnt++;
        notification.number = 0;
        if (this.mMissedCallCnt == 1) {
            if (missedCallTitleID == 0) {
                titleText = "";
            } else {
                titleText = MainApplication.mContext.getString(missedCallTitleID);
            }
            expandedText = displayName;
        } else {
            if (missedCallsTitle == 0) {
                titleText = "";
            } else {
                titleText = MainApplication.mContext.getString(missedCallsTitle);
            }
            if (missedCallsMsg == 0) {
                expandedText = "";
            } else {
                expandedText = MainApplication.mContext.getString(missedCallsMsg, Integer.valueOf(this.mMissedCallCnt));
            }
        }
        Intent createIntentBR = new Intent(ChatONNotificationBR.MISSED_CALL_CREATE_ACTION_NAME);
        PendingIntent pIntent = PendingIntent.getBroadcast(MainApplication.mContext, 0, createIntentBR, 0);
        notification.setLatestEventInfo(MainApplication.mContext, titleText, expandedText, pIntent);
        notification.flags |= 16;
        Intent deleteIntentBR = new Intent(ChatONNotificationBR.MISSED_CALL_DELETE_ACTION_NAME);
        notification.deleteIntent = PendingIntent.getBroadcast(MainApplication.mContext, 0, deleteIntentBR, 0);
        this.mMissedCallNotiManager.notify(1000, notification);
    }

    public void notifyRejectMsg(long callSeconds, String username, String phoneNumber, String msg, int iconID, int tickerStringID, int RejectMsgTitleID, int rejectMsgsTitleID) {
        String titleText;
        String expandedText;
        logI("notifyRejectMsg()");
        String displayName = getDisplayName(username, phoneNumber);
        Notification notification = new Notification();
        notification.icon = iconID;
        notification.when = callSeconds;
        this.mRejectMsgCnt++;
        notification.number = 0;
        if (this.mRejectMsgCnt == 1) {
            titleText = MainApplication.mContext.getString(RejectMsgTitleID);
            expandedText = String.valueOf(displayName) + " : " + msg;
            notification.tickerText = expandedText;
        } else {
            titleText = MainApplication.mContext.getString(rejectMsgsTitleID, Integer.valueOf(this.mRejectMsgCnt));
            expandedText = String.valueOf(displayName) + " : " + msg;
            notification.tickerText = expandedText;
        }
        Intent createIntentBR = new Intent(ChatONNotificationBR.REJECT_MSG_CREATE_ACTION_NAME);
        PendingIntent pIntent = PendingIntent.getBroadcast(MainApplication.mContext, 0, createIntentBR, 0);
        notification.setLatestEventInfo(MainApplication.mContext, titleText, expandedText, pIntent);
        notification.flags |= 16;
        Intent deleteIntentBR = new Intent(ChatONNotificationBR.REJECT_MSG_DELETE_ACTION_NAME);
        notification.deleteIntent = PendingIntent.getBroadcast(MainApplication.mContext, 0, deleteIntentBR, 0);
        this.mRejectMsgNotiManager.notify(2000, notification);
    }

    private String getDisplayName(String username, String phoneNumber) {
        return (username == null || username.isEmpty()) ? (phoneNumber == null || phoneNumber.isEmpty()) ? "..." : phoneNumber : username;
    }

    public void notifyCancel(int notiID) {
        logI("notifyCancel()");
        if (notiID == 1000) {
            this.mMissedCallNotiManager.cancel(notiID);
            this.mMissedCallCnt = 0;
        } else if (notiID == 2000) {
            this.mRejectMsgNotiManager.cancel(notiID);
            this.mRejectMsgCnt = 0;
        }
    }

    public Intent createCallLogMissedCallIntent() {
        Intent intent;
        Bundle extras = new Bundle();
        if (this.mMissedCallCnt > 1) {
            logI("createCallLogMissedCallIntent() goto call log list");
            intent = new Intent("com.coolots.chaton.buddy.view.BuddyMainListActivity.Update");
            intent.putExtra("tab", "logs");
            intent.putExtra("show_charge_alert", false);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            logI("createCallLogMissedCallIntent() goto call log detail");
            intent = new Intent("com.coolots.chaton.calllog.view.CallLogDetailActivity.Update");
            extras.putBoolean("rejected_call", false);
            extras.putBoolean("missed_call", true);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
            intent.putExtra("direct", true);
            intent.putExtras(extras);
        }
        notifyCancel(1000);
        return intent;
    }

    public Intent createCallLogRejectMsgIntent() {
        Intent intent;
        Bundle extras = new Bundle();
        if (this.mRejectMsgCnt > 1) {
            logI("createCallLogRejectMsgIntent() goto call log list");
            intent = new Intent("com.coolots.chaton.buddy.view.BuddyMainListActivity.Update", (Uri) null);
            intent.putExtra("tab", "logs");
            intent.putExtra("show_charge_alert", false);
            intent.setFlags(268435456);
            intent.addFlags(67108864);
            intent.addFlags(536870912);
        } else {
            logI("createCallLogRejectMsgIntent() goto call log detail");
            intent = new Intent("com.coolots.chaton.calllog.view.CallLogDetailActivity.Update", (Uri) null);
            extras.putBoolean("rejected_call", true);
            extras.putBoolean("missed_call", false);
            intent.putExtras(extras);
            intent.addFlags(268435456);
            intent.addFlags(536870912);
        }
        notifyCancel(2000);
        return intent;
    }
}
