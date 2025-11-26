package com.sec.chaton.push.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.sec.chaton.push.C0904h;
import com.sec.chaton.push.PushClientService;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.receiver.AutoRestartReceiver;
import com.sec.chaton.push.receiver.SystemStateMoniter;

/* compiled from: ServiceUtil.java */
/* renamed from: com.sec.chaton.push.util.a */
/* loaded from: classes.dex */
public class C0915a {

    /* renamed from: a */
    private static final Intent f3108a = new Intent("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");

    /* renamed from: a */
    public static boolean m3609a(Context context) {
        return context.getPackageManager().resolveService(f3108a, 32) != null;
    }

    /* renamed from: a */
    public static void m3607a(Context context, boolean z) {
        m3608a(context, z, null, 0L);
    }

    /* renamed from: a */
    public static void m3608a(Context context, boolean z, Intent intent, long j) {
        SharedPreferences.Editor editorM3538a = C0904h.m3538a();
        C0904h.m3565g(editorM3538a);
        C0904h.m3567h(editorM3538a);
        editorM3538a.commit();
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
    public static void m3610b(Context context, boolean z) {
        m3611b(context, z, null, 0L);
    }

    /* renamed from: b */
    public static void m3611b(Context context, boolean z, Intent intent, long j) {
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
