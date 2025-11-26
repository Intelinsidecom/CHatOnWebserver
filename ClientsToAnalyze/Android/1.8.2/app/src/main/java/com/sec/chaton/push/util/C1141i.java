package com.sec.chaton.push.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.sec.chaton.push.C1126j;
import com.sec.chaton.push.PushClientService;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.receiver.AutoRestartReceiver;
import com.sec.chaton.push.receiver.SystemStateMoniter;

/* compiled from: ServiceUtil.java */
/* renamed from: com.sec.chaton.push.util.i */
/* loaded from: classes.dex */
public class C1141i {

    /* renamed from: a */
    private static final Intent f4148a = new Intent("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");

    /* renamed from: a */
    public static boolean m4319a(Context context) {
        return context.getPackageManager().resolveService(f4148a, 32) != null;
    }

    /* renamed from: a */
    public static void m4317a(Context context, boolean z) {
        m4318a(context, z, null, 0L);
    }

    /* renamed from: a */
    public static void m4318a(Context context, boolean z, Intent intent, long j) {
        SharedPreferences.Editor editorM4240a = C1126j.m4240a();
        C1126j.m4267g(editorM4240a);
        C1126j.m4269h(editorM4240a);
        editorM4240a.commit();
        if (z && intent != null) {
            ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) SystemStateMoniter.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) HeartBeat.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) AutoRestartReceiver.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushClientService.class), 2, z ? 0 : 1);
    }

    /* renamed from: b */
    public static void m4320b(Context context, boolean z) {
        m4321b(context, z, null, 0L);
    }

    /* renamed from: b */
    public static void m4321b(Context context, boolean z, Intent intent, long j) {
        if (z && intent != null) {
            ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) SystemStateMoniter.class), 0, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) HeartBeat.class), 0, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) AutoRestartReceiver.class), 0, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushClientService.class), 0, z ? 0 : 1);
    }
}
