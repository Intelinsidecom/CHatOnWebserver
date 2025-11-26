package com.android.common.p028b;

import android.content.Context;
import android.content.Intent;

/* compiled from: UserHappinessSignals.java */
/* renamed from: com.android.common.b.a */
/* loaded from: classes.dex */
public class C0359a {

    /* renamed from: a */
    private static boolean f865a = false;

    /* renamed from: a */
    public static void m1255a(boolean z) {
        f865a = z;
    }

    /* renamed from: a */
    public static void m1254a(Context context) {
        if (f865a) {
            Intent intent = new Intent("com.android.common.speech.LOG_EVENT");
            intent.putExtra("app_name", "voiceime");
            intent.putExtra("extra_event", 21);
            intent.putExtra("", context.getPackageName());
            intent.putExtra("timestamp", System.currentTimeMillis());
            context.sendBroadcast(intent);
            m1255a(false);
        }
    }
}
