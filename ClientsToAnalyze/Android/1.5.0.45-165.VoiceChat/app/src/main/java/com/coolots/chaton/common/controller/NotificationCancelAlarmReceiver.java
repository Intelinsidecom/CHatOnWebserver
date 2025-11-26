package com.coolots.chaton.common.controller;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sds.coolots.common.model.NotificationID;

/* loaded from: classes.dex */
public class NotificationCancelAlarmReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager = null;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (this.notificationManager == null) {
                this.notificationManager = (NotificationManager) context.getSystemService("notification");
            }
            int identification = intent.getExtras().getInt(NotificationID.NOTIFY_MISSED_STR);
            this.notificationManager.cancel(identification);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
