package com.sec.chaton.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.CountDownTimer;

/* loaded from: classes.dex */
public class SmsMessager {

    /* renamed from: a */
    static BroadcastReceiver f3737a;

    /* renamed from: b */
    static BroadcastReceiver f3738b;

    /* renamed from: c */
    private static String f3739c = "";

    /* renamed from: d */
    private static CountDownTimer f3740d;

    /* renamed from: a */
    public static void m3660a(Context context) {
        if (f3737a != null) {
            context.unregisterReceiver(f3737a);
            f3737a = null;
        }
        if (f3738b != null) {
            context.unregisterReceiver(f3738b);
            f3738b = null;
        }
    }

    /* renamed from: b */
    public static void m3661b(Context context) {
        if (f3740d != null) {
            ChatONLogWriter.m3506b("Self SMS Timer canceled", null);
            f3740d.cancel();
            f3740d = null;
        }
    }
}
