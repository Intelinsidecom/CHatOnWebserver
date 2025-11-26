package com.sec.chaton.util.logcollector.scheduler;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.logcollector.LogCollectService;

/* loaded from: classes.dex */
public class GatheringScheduler extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f17833a = GatheringScheduler.class.getSimpleName();

    /* renamed from: a */
    public static void m18565a(Context context, long j) {
        ((AlarmManager) context.getSystemService("alarm")).set(0, System.currentTimeMillis() + j, PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) GatheringScheduler.class), 0));
    }

    /* renamed from: a */
    public static void m18564a(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) GatheringScheduler.class), 0));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C4904y.f17873c) {
            C4904y.m18641c("GatheringScheduler.onReceive()", f17833a);
        }
        LogCollectService.m18548a(context);
    }
}
