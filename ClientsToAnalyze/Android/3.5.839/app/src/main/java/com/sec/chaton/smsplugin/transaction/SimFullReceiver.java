package com.sec.chaton.smsplugin.transaction;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p112ui.ManageSimMessages;

/* loaded from: classes.dex */
public class SimFullReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Settings.Secure.getInt(context.getContentResolver(), "device_provisioned", 0) == 1 && "android.provider.Telephony.SIM_FULL".equals(intent.getAction())) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Intent intent2 = new Intent(context, (Class<?>) ManageSimMessages.class);
            intent2.setAction("android.intent.action.VIEW");
            intent2.setFlags(268435456);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 0);
            Notification notification = new Notification();
            notification.icon = R.drawable.stat_sys_no_sim;
            notification.tickerText = context.getString(R.string.sim_full_title);
            notification.defaults = -1;
            notification.setLatestEventInfo(context, context.getString(R.string.sim_full_title), context.getString(R.string.sim_full_body), activity);
            notificationManager.notify(234, notification);
        }
    }
}
