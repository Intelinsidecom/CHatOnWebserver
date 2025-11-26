package com.coolots.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.coolots.chaton.login.SPPPushManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManagerInterface;
import com.sec.spp.push.Config;
import java.util.List;

/* loaded from: classes.dex */
public class SPPBroadcastReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[SPPBroadcastReceiver]";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(SPPPushManager.EP_ID_SPP)) {
            String mMessage = intent.getStringExtra(Config.NOTIFICATION_INTENT_APP_DATA);
            String mAppId = intent.getStringExtra("appId");
            boolean bAck = intent.getBooleanExtra(Config.NOTIFICATION_INTENT_ACK, false);
            String mNotiId = intent.getStringExtra(Config.NOTIFICATION_INTENT_NOTIID);
            logI("haeri=received push msg from server appID:" + mAppId + ", notiID:" + mNotiId);
            if (mMessage == null) {
                logE("received push message is null!!!!!!!!!!!! it is strange case!!!");
                return;
            }
            if (bAck) {
                logE("<<SPP>> WE MUST SEND ACK MSG!!");
            }
            if (VAppPhoneManager.isCoolotsServiceRunning(context)) {
                PushManagerInterface pushManager = getSPPPushManager();
                if (pushManager != null) {
                    pushManager.onReceivePushMessage(3, mMessage);
                    return;
                }
                return;
            }
            if (VAppPhoneManager.startCoolotsService(context, false)) {
                logE("startCooLots Service to handle received push message");
                PushManagerInterface pushManager2 = getSPPPushManager();
                if (pushManager2 != null) {
                    pushManager2.onReceivePushMessage(3, mMessage);
                }
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
