package com.sec.chaton.receiver;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.chat.notification.ScreenNotification2;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private String f8072a = ScreenReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            C3250y.m11454d("Screen Receiver ON");
            return;
        }
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            C3250y.m11454d("Screen Receiver OFF");
            try {
                m8380c(context);
            } catch (Exception e) {
                C3250y.m11443a(e, this.f8072a);
            }
        }
    }

    /* renamed from: c */
    private void m8380c(Context context) throws PendingIntent.CanceledException {
        String string = context.getSharedPreferences("PASSWORD_LOCK", 0).getString("LOCK_STATE", C3241p.m11409e());
        if ((m8381a(context).equals("com.sec.chaton") || m8381a(context).equals("com.sec.chatonforcanada")) && string.equals(C3241p.m11408d())) {
            if (!m8379b(context).equals(ScreenNotification2.class.getName())) {
                C3250y.m11453c("Lockstate: true, Display password lock screen", this.f8072a);
                Intent intent = new Intent(context, (Class<?>) ActivityPasswordLockSet.class);
                intent.putExtra("MODE", "RECEIVER");
                try {
                    PendingIntent.getActivity(context, 0, intent, 134217728).send();
                    return;
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        C3250y.m11453c("Lockstate: false, Do not display password lock screen", this.f8072a);
    }

    /* renamed from: a */
    public String m8381a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
    }

    /* renamed from: b */
    public static String m8379b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
    }
}
