package com.sec.chaton.smsplugin.transaction;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.PluginConversationList;

/* loaded from: classes.dex */
public class SmsRejectedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i;
        int i2;
        if (Settings.Secure.getInt(context.getContentResolver(), "device_provisioned", 0) == 1 && "android.provider.Telephony.SMS_REJECTED".equals(intent.getAction())) {
            boolean z = intent.getIntExtra("result", -1) == 3;
            if (z) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                Intent intent2 = new Intent(context, (Class<?>) PluginConversationList.class);
                intent2.setAction("android.intent.action.VIEW");
                intent2.setFlags(872415232);
                PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 0);
                Notification notification = new Notification();
                notification.icon = R.drawable.stat_sys_no_sim;
                if (z) {
                    i = R.string.sms_full_title;
                    i2 = R.string.sms_full_body;
                } else {
                    i = R.string.sms_rejected_title;
                    i2 = R.string.sms_rejected_body;
                }
                notification.tickerText = context.getString(i);
                notification.defaults = -1;
                notification.setLatestEventInfo(context, context.getString(i), context.getString(i2), activity);
                notificationManager.notify(239, notification);
            }
        }
    }
}
