package com.sec.chaton.push.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import com.sec.chaton.push.C2099k;
import com.sec.chaton.push.PushClientService;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.receiver.AutoRestartReceiver;
import com.sec.chaton.push.receiver.SystemStateMoniter;
import java.util.ArrayList;

/* compiled from: ServiceUtil.java */
/* renamed from: com.sec.chaton.push.util.i */
/* loaded from: classes.dex */
public class C2117i {

    /* renamed from: a */
    private static final Intent f8054a = new Intent("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");

    /* renamed from: a */
    public static boolean m8370a(Context context) {
        return context.getPackageManager().resolveService(f8054a, 32) != null;
    }

    /* renamed from: a */
    public static void m8368a(Context context, boolean z) {
        m8369a(context, z, null, 0L);
    }

    /* renamed from: a */
    public static void m8369a(Context context, boolean z, Intent intent, long j) {
        SharedPreferences.Editor editorM8284a = C2099k.m8284a();
        C2099k.m8319j(editorM8284a);
        C2099k.m8320k(editorM8284a);
        editorM8284a.commit();
        if (z && intent != null) {
            ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(new ComponentName(context, (Class<?>) SystemStateMoniter.class));
        arrayList.add(new ComponentName(context, (Class<?>) HeartBeat.class));
        arrayList.add(new ComponentName(context, (Class<?>) AutoRestartReceiver.class));
        arrayList.add(new ComponentName(context, (Class<?>) PushClientService.class));
        for (int i = 0; i < arrayList.size(); i++) {
            ComponentName componentName = (ComponentName) arrayList.get(i);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                arrayList2.add(componentName);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (i2 == arrayList.size()) {
                packageManager.setComponentEnabledSetting((ComponentName) arrayList.get(i2), 2, z ? 0 : 1);
            } else {
                packageManager.setComponentEnabledSetting((ComponentName) arrayList.get(i2), 2, 1);
            }
        }
        arrayList.clear();
        arrayList2.clear();
    }

    /* renamed from: b */
    public static void m8371b(Context context, boolean z) {
        m8372b(context, z, null, 0L);
    }

    /* renamed from: b */
    public static void m8372b(Context context, boolean z, Intent intent, long j) {
        if (z && intent != null) {
            ((AlarmManager) context.getSystemService("alarm")).set(2, SystemClock.elapsedRealtime() + j, PendingIntent.getBroadcast(context, 0, intent, 0));
        }
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(new ComponentName(context, (Class<?>) SystemStateMoniter.class));
        arrayList.add(new ComponentName(context, (Class<?>) HeartBeat.class));
        arrayList.add(new ComponentName(context, (Class<?>) AutoRestartReceiver.class));
        arrayList.add(new ComponentName(context, (Class<?>) PushClientService.class));
        for (int i = 0; i < arrayList.size(); i++) {
            ComponentName componentName = (ComponentName) arrayList.get(i);
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                arrayList2.add(componentName);
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            if (i2 == arrayList.size()) {
                packageManager.setComponentEnabledSetting((ComponentName) arrayList.get(i2), 0, z ? 0 : 1);
            } else {
                packageManager.setComponentEnabledSetting((ComponentName) arrayList.get(i2), 0, 1);
            }
        }
        arrayList.clear();
        arrayList2.clear();
    }
}
