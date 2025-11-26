package com.sec.chaton.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.sec.chaton.push.PushClientService;
import com.sec.chaton.push.SystemStateMoniter;
import com.sec.chaton.push.heartbeat.HeartBeat;
import com.sec.chaton.push.registration.RegistrationManager;

/* loaded from: classes.dex */
public class ServiceUtil {

    /* renamed from: a */
    private static final String f2796a = ServiceUtil.class.getSimpleName();

    /* renamed from: b */
    private static final Intent f2797b = new Intent("com.sec.spp.push.PUSH_CLIENT_SERVICE_ACTION");

    /* renamed from: a */
    public static void m3039a(Context context, boolean z) {
        RegistrationManager.m3010a(context);
        RegistrationManager.m3014c(context);
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) SystemStateMoniter.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) HeartBeat.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushClientService.class), 2, z ? 0 : 1);
    }

    /* renamed from: a */
    public static boolean m3040a(Context context) {
        return context.getPackageManager().resolveService(f2797b, 32) != null;
    }

    /* renamed from: b */
    public static void m3041b(Context context, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) SystemStateMoniter.class), 0, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) HeartBeat.class), 0, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(context, (Class<?>) PushClientService.class), 0, z ? 0 : 1);
    }
}
