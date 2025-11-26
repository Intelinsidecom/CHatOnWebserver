package com.coolots.chaton.common.coolotsinterface;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.StatusBarManager;
import android.content.Intent;
import android.os.Process;
import android.os.SystemProperties;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.view.ChatOnCallActivity;
import com.coolots.chaton.calllog.noti.ChatONNotificationManager;
import com.coolots.chaton.common.controller.ChatONStatusBarController;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.common.view.layout.InCallQuickPanel;
import com.coolots.chaton.service.CoolotsService;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.CallStatusData;
import com.sds.coolots.common.coolotsinterface.CallNotificationInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class CallButtonNotification implements CallNotificationInterface {
    private static final String CLASSNAME = "[CallButtonNotification]";
    private InCallQuickPanel mQuickPanel;
    StatusBarManager mStatusBarManager = null;

    private void logI(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallNotificationInterface
    public boolean showQuickPanel() {
        logI("showQuickPanel()?" + this.mQuickPanel);
        if (this.mQuickPanel == null) {
            logI("mQuickPanel == null");
            return false;
        }
        logI("mQuickPanel != null");
        return true;
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallNotificationInterface
    public void showCallButtonNotification() {
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        logI("showCallButtonNotification() callInfo?" + callInfo + " /callstate?" + callInfo.getCallState());
        if (callInfo.getCallState() == 0 || callInfo.getCallState() == 3 || callInfo.getCallState() == -1) {
            stopServiceForeGroundDeleteQuickPanel();
            logI("STATE_DISCONNECTED do not show QuickPanel");
            return;
        }
        logI("showCallButtonNotification() - QuickPanel update!!");
        try {
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            if (this.mStatusBarManager != null) {
                logI("Statusbar COLOR change to GREEN!!!!");
                this.mStatusBarManager.showCallView();
            }
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
        }
        startServiceForegroundWithQuickPanel();
    }

    private void startServiceForegroundWithQuickPanel() {
        logI("startServiceForegroundWithQuickPanel()");
        Intent quickPanelShowIntent = new Intent();
        quickPanelShowIntent.setAction(CoolotsService.QUICKPANELSHOW_ACTION);
        MainApplication.mContext.sendBroadcast(quickPanelShowIntent);
        if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
            logI("LCD_FRAME send Intent SSRM_STATUS_VALUE false");
            Intent boostIntent = new Intent();
            boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
            boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
            boostIntent.putExtra("SSRM_STATUS_VALUE", false);
            boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
            boostIntent.putExtra("PID", Process.myPid());
            MainApplication.mContext.sendBroadcast(boostIntent);
            SystemProperties.set("hw.enable.chatOn", "0");
        }
    }

    private void stopServiceForeGroundDeleteQuickPanel() {
        logI("stopServiceForegroundWithQuickPanel()");
        Intent quickPanelDeleteIntent = new Intent();
        quickPanelDeleteIntent.setAction(CoolotsService.QUICKPANELDELETE_ACTION);
        MainApplication.mContext.sendBroadcast(quickPanelDeleteIntent);
        CallStatusData callInfo = new CallStatusData();
        MainApplication.mPhoneManager.getPhoneStateMachine().updateCallInfo(callInfo);
        logI("stopServiceForeGroundDeleteQuickPanel() callInfo?" + callInfo + " /callstate?" + callInfo.getCallState());
        if (callInfo.getCallState() == 0 || callInfo.getCallState() == 3 || callInfo.getCallState() == -1) {
            removeStatusbarIcon();
            ChatOnCallActivity.setPublicBaseTime(0L);
            return;
        }
        if (MainApplication.mConfig.isFixedLCDFrame() && MainApplication.mContext != null) {
            logI("LCD_FRAME send Intent SSRM_STATUS_VALUE true");
            Intent boostIntent = new Intent();
            boostIntent.setAction("com.sec.android.intent.action.SSRM_REQUEST");
            boostIntent.putExtra("SSRM_STATUS_NAME", "ChatOnV_vtCall");
            boostIntent.putExtra("SSRM_STATUS_VALUE", true);
            boostIntent.putExtra("PackageName", MainApplication.mContext.getApplicationInfo().packageName);
            boostIntent.putExtra("PID", Process.myPid());
            MainApplication.mContext.sendBroadcast(boostIntent);
            SystemProperties.set("hw.enable.chatOn", "1");
        }
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallNotificationInterface
    public Notification getQuickPanelNotification() {
        logI("getQuickPanelNotification()");
        this.mQuickPanel = new InCallQuickPanel(MainApplication.mContext, C0000R.layout.voice_call_quick_panel);
        Notification notifi = new Notification(C0000R.drawable.stat_sys_vp_phone_chat, "ChatON Voice & Video Chat", System.currentTimeMillis());
        notifi.contentView = this.mQuickPanel;
        notifi.twQuickPanelEvent = 1;
        notifi.contentIntent = PendingIntent.getActivity(MainApplication.mContext, 0, new Intent(), 0);
        notifi.flags |= 2;
        return notifi;
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallNotificationInterface
    public void deleteCallNotification() {
        logI("deleteCallNotification() - QuickPanel delete!!");
        if (this.mStatusBarManager == null) {
            this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
        }
        try {
            if (this.mStatusBarManager != null) {
                this.mStatusBarManager.hideCallView();
            }
        } catch (IllegalArgumentException e) {
        } catch (NoSuchMethodError e2) {
        } catch (SecurityException e3) {
        }
        stopServiceForeGroundDeleteQuickPanel();
        this.mQuickPanel = null;
    }

    @Override // com.sds.coolots.common.coolotsinterface.CallNotificationInterface
    public void showRejectMessageNotification(String userID, String rejectMsg) {
        logI("showRejectMessageNotification");
        ChatONNotificationManager.getInstance().notifyRejectMsg(System.currentTimeMillis(), ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getDisplayNameByUserID(userID), ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().getBuddyMessageByUserID(userID), rejectMsg, C0000R.drawable.stausbar_noti_icon, C0000R.string.notification_rejectMsgTicker, C0000R.string.notification_rejectMsgTitle, C0000R.string.notification_rejectMsgsTitle);
    }

    private void removeStatusbarIcon() {
        logI("removeStatusbarIcon()");
        try {
            if (this.mStatusBarManager == null) {
                this.mStatusBarManager = (StatusBarManager) MainApplication.mContext.getSystemService("statusbar");
            }
            if (this.mStatusBarManager != null) {
                this.mStatusBarManager.disable(ChatONStatusBarController.clearFlag());
                this.mStatusBarManager.removeIcon("speakerphone");
                this.mStatusBarManager.removeIcon("mute");
            }
        } catch (NoSuchMethodError e) {
        } catch (SecurityException e2) {
        }
    }
}
