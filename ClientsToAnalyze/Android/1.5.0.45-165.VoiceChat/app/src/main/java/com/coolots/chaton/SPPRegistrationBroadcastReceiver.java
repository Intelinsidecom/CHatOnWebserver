package com.coolots.chaton;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.coolots.chaton.login.SPPPushManager;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManagerInterface;
import com.sec.spp.push.Config;
import java.util.List;

/* loaded from: classes.dex */
public class SPPRegistrationBroadcastReceiver extends BroadcastReceiver {
    private static final String CLASSNAME = "[SPPRegistrationBroadcastReceiver]";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context mContext, Intent incomingIntent) {
        if (incomingIntent != null) {
            String intentAction = incomingIntent.getAction();
            if (intentAction.equals(Config.PUSH_REGISTRATION_CHANGED_ACTION)) {
                handleSPPRegistrationChange(incomingIntent);
            }
        }
    }

    private void handleSPPRegistrationChange(Intent intent) {
        String appId = intent.getStringExtra("appId");
        logE("<<SPP>> handleSPPRegistrationChange: appId:" + appId);
        if (appId == null) {
            logE("<<SPP>> appId==null");
        }
        if (appId.equals(Config.DEFAULT_REGISTRATION_ID)) {
            logE("<<SPP>> PUSH_REGISTRATION_FAIL!! errorCode:" + intent.getIntExtra(Config.EXTRA_ERROR, 1000));
            return;
        }
        if (appId.equals(Config.DEFAULT_DEREGISTRATION_ID)) {
            logE("<<SPP>> PUSH_DEREGISTRATION_FAIL!! errorCode:" + intent.getIntExtra(Config.EXTRA_ERROR, 1000));
            return;
        }
        if (appId.equals(SPPPushManager.EP_ID_SPP)) {
            int registrationState = intent.getIntExtra(Config.EXTRA_PUSH_STATUS, 1);
            logE("<<SPP>> registrationState:" + registrationState);
            PushManagerInterface pushManager = getSPPPushManager();
            if (pushManager != null) {
                switch (registrationState) {
                    case 0:
                        String intentRegId = intent.getStringExtra(Config.EXTRA_REGID);
                        logE("<<SPP>> REGID:" + intentRegId);
                        pushManager.setRegisterStatus(true, intentRegId);
                        break;
                    case 1:
                        int errorCode = intent.getIntExtra(Config.EXTRA_ERROR, 1000);
                        logE("<<SPP>> PUSH_REGISTRATION_FAIL. errorCode:" + errorCode);
                        pushManager.setErrorCode(errorCode);
                        break;
                    case 2:
                        logE("<<SPP>> PUSH_DEREGISTRATION_SUCCESS");
                        pushManager.setRegisterStatus(false, "");
                        break;
                    case 3:
                        logE("<<SPP>> PUSH_DEREGISTRATION_FAIL. errorCode:" + intent.getIntExtra(Config.EXTRA_ERROR, 1000));
                        break;
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
