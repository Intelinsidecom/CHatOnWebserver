package com.coolots.chaton.login;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.coolots.chaton.GCMIntentService;
import com.coolots.p2pmsg.model.StoreEPInfoAsk;
import com.google.android.gcm.GCMRegistrar;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.model.IntentName;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.login.PushManager;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class GCMPushManager extends PushManager {
    private static final int TIME_RETRY_REGISTRATION = 5000;
    private AlarmManager alarmMnger = null;

    public GCMPushManager() {
        this.mPushType = StoreEPInfoAsk.EP_TYPE_GCM;
    }

    @Override // com.sds.coolots.login.PushManager
    protected void register() throws PackageManager.NameNotFoundException {
        Log.m2963i("[GCMPushManager]haeri=register()");
        GCMRegistrar.checkDevice(MainApplication.mContext);
        GCMRegistrar.checkManifest(MainApplication.mContext);
        String regID = GCMRegistrar.getRegistrationId(MainApplication.mContext);
        if (regID == null || regID.isEmpty()) {
            GCMRegistrar.register(MainApplication.mContext, GCMIntentService.GCM_SENDER_ID);
        } else {
            setRegisterStatus(true, regID);
        }
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void reRegister() throws PackageManager.NameNotFoundException {
        unsetAlarmForRetry();
        register();
    }

    @Override // com.sds.coolots.login.PushManagerInterface
    public void setErrorCode(int errorCode) {
        setAlarmForRetry();
    }

    @Override // com.sds.coolots.login.PushManager
    protected void unregister() {
        GCMRegistrar.unregister(MainApplication.mContext);
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
}
