package com.sec.chaton.receiver;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.BlackScreenNotification;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import java.util.List;

/* loaded from: classes.dex */
public class ScreenReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws PendingIntent.CanceledException {
        String string = context.getSharedPreferences("password_lock", 0).getString("app_lock_state", "OFF");
        if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            C1786r.m6064d("Screen Receiver ON");
            GlobalApplication.f2777c = true;
        } else if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            C1786r.m6064d("Screen Receiver OFF");
            GlobalApplication.f2777c = false;
        }
        if (BlackScreenNotification.f6234a) {
            C1786r.m6064d("ScreenReceiver blackScreenNotificationOn");
            return;
        }
        if (m4326a(context).equals("com.sec.chaton") && string.equals(C1781m.m6025c())) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                String strM4325b = m4325b(context);
                if (!strM4325b.equals("com.sec.chaton.util.ScreenOnNotification") && !strM4325b.equals("com.sec.chaton.util.BlackScreenNotification")) {
                    Intent intent2 = new Intent(context, (Class<?>) ActivityPasswordLockSet.class);
                    intent2.putExtra("MODE", "RECEIVER");
                    intent2.addFlags(536870912);
                    try {
                        PendingIntent.getActivity(context, 0, intent2, 134217728).send();
                    } catch (PendingIntent.CanceledException e) {
                        e.printStackTrace();
                    }
                }
                GlobalApplication.f2777c = false;
                return;
            }
            if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                GlobalApplication.f2777c = true;
            }
        }
    }

    /* renamed from: a */
    public String m4326a(Context context) throws SecurityException {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        Log.d("-----------Screen Receiver package name", runningTasks.get(0).topActivity.getPackageName());
        return runningTasks.get(0).topActivity.getPackageName();
    }

    /* renamed from: b */
    public static String m4325b(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
    }
}
