package com.coolots.chaton.login;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.os.SystemClock;
import com.coolots.chaton.common.view.EngineeringConfigActivity;
import com.coolots.p2pmsg.model.StoreEPInfoAsk;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManager;
import com.sec.spp.push.Config;
import com.sec.spp.push.IPushClientService;

/* loaded from: classes.dex */
public class SPPPushManager extends PushManager {
    public static final String CLASSNAME = "[SPPPushManager]";
    public static String EP_ID_SPP = "20885e963697374d";
    public static final int ERR_APPLICATION_ALREADY_DEREGISTRATION = -105;
    public static final int ERR_BAD_REQUEST_FOR_PROVISION = 3000;
    public static final int ERR_CONNECTION_MAX_EXCEEDED = 4000;
    public static final int ERR_DEREGISTRATION_FAILED = 4008;
    public static final int ERR_FAIL_TO_AUTHENTICATE = 3001;
    public static final int ERR_INITIALIZATION_ALREADY_COMPLETED = -102;
    public static final int ERR_INITIALIZATION_FAIL = -104;
    public static final int ERR_INTERNAL_SERVER_ERROR = 2002;
    public static final int ERR_INTERRUPTED = 2003;
    public static final int ERR_INVALID_APP_ID = 4003;
    public static final int ERR_INVALID_DEVICE_TOKEN = 4002;
    public static final int ERR_INVALID_DEVICE_TOKEN_TO_REPROVISION = 3002;
    public static final int ERR_INVALID_REG_ID = 4004;
    public static final int ERR_INVALID_STATE = 4001;
    public static final int ERR_NETWORK_NOT_AVAILABLE = -2;
    public static final int ERR_PROVISIONING_DATA_EXISTS = -100;
    public static final int ERR_PROVISIONING_FAIL = -103;
    public static final int ERR_PROVISION_EXCEPTION = 3003;
    public static final int ERR_REGISTRATION_FAILED = 4007;
    public static final int ERR_REPROVISIONING_REQUIRED = 4006;
    public static final int ERR_RESET_BY_NEW_INITIALIZATION = 4005;
    public static final int ERR_SUCCESS = 1000;
    public static final int ERR_TIMEOUT = -1;
    public static final int ERR_UNEXPECTED_MESSAGE = 2001;
    public static final int ERR_UNKNOWN_MESSAGE_TYPE = 2000;
    public static final int ERR_UNSUPPORTED_PING_SPECIFICATION = 4012;
    public static final int ERR_WRONG_APP_ID = 4010;
    public static final int ERR_WRONG_DEVICE_TOKEN = 4009;
    public static final int ERR_WRONG_REG_ID = 4011;
    private static final int TIME_RETRY_REGISTRATION = 5000;
    private IPushClientService mService = null;
    private AlarmManager alarmMnger = null;

    private void logE(String message) {
        Log.m2958e("[SPPPushManager]" + message);
    }

    public SPPPushManager() {
        this.mPushType = StoreEPInfoAsk.EP_TYPE_SPP;
        if (MainApplication.mPhoneManager.getClientType() == 2) {
            String centerDomain = EngineeringConfigActivity.getCenterDomain();
            if (centerDomain.contains("-v-int.coolots.com")) {
                EP_ID_SPP = "20885e963697374d";
            } else {
                EP_ID_SPP = "c523f78424aed530";
            }
        }
    }

    @Override // com.sds.coolots.login.PushManager
    protected void register() {
        Log.m2958e("<<SPP>> START REGIST!!");
        ComponentName componentName = MainApplication.mContext.startService(new Intent("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION"));
        if (componentName == null) {
            logE("Fail to start SPP Service!!");
        } else {
            sendRegisterMessage();
        }
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void reRegister() {
        sendRegisterMessage();
        unsetAlarmForRetry();
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void setErrorCode(int errorCode) {
        switch (errorCode) {
            case 3000:
            case 3001:
            case 4003:
            case 4004:
            case 4010:
            case 4011:
                handleSPPCriticalError();
                break;
            default:
                setAlarmForRetry();
                break;
        }
    }

    private void handleSPPCriticalError() {
    }

    private void setAlarmForRetry() {
        Intent intent = new Intent(IntentName.ACTION_ALARM_PUSH_REREGISTER);
        PendingIntent sender = PendingIntent.getBroadcast(MainApplication.mContext, 0, intent, 0);
        long firstTime = SystemClock.elapsedRealtime();
        if (this.alarmMnger == null) {
            this.alarmMnger = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
        }
        this.alarmMnger.cancel(sender);
        this.alarmMnger.set(2, Config.DISCONNECT_TIMEOUT + firstTime, sender);
    }

    private void unsetAlarmForRetry() {
        Intent intent = new Intent(IntentName.ACTION_ALARM_PUSH_REREGISTER);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainApplication.mContext, 0, intent, 0);
        if (this.alarmMnger == null) {
            this.alarmMnger = (AlarmManager) MainApplication.mContext.getSystemService("alarm");
        }
        this.alarmMnger.cancel(pendingIntent);
    }

    @Override // com.sds.coolots.login.PushManager
    protected void unregister() {
        Log.m2958e("<<SPP>> START UNREGIST!!");
        Intent intent = new Intent(Config.PUSH_SERVICE_REQUEST);
        intent.putExtra(Config.EXTRA_REQTYPE, 2);
        intent.putExtra("appId", EP_ID_SPP);
        intent.putExtra(Config.EXTRA_USERDATA, MainApplication.mContext.getPackageName());
        MainApplication.mContext.sendBroadcast(intent);
    }

    private void sendRegisterMessage() {
        Intent intent = new Intent(Config.PUSH_SERVICE_REQUEST);
        intent.putExtra(Config.EXTRA_REQTYPE, 1);
        intent.putExtra("appId", EP_ID_SPP);
        Log.m2958e("<<SPP>> packageName:" + MainApplication.mContext.getPackageName());
        Log.m2958e("<<SPP>> EP_ID_SPP:" + EP_ID_SPP);
        intent.putExtra(Config.EXTRA_USERDATA, MainApplication.mContext.getPackageName());
        MainApplication.mContext.sendBroadcast(intent);
    }
}
