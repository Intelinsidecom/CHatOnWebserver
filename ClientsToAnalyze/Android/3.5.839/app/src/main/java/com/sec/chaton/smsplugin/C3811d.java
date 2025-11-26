package com.sec.chaton.smsplugin;

import android.app.Activity;
import android.content.Context;
import com.sec.chaton.smsplugin.p111h.C3890m;

/* compiled from: LogTag.java */
/* renamed from: com.sec.chaton.smsplugin.d */
/* loaded from: classes.dex */
public class C3811d {
    /* renamed from: a */
    private static String m14482a(String[] strArr) {
        if (strArr.length == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        int length = strArr.length - 1;
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
            sb.append(", ");
        }
        if (strArr[length] != null) {
            sb.append(strArr[length]);
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: d */
    private static String m14488d(String str, Object... objArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < objArr.length) {
                if (objArr[i2] instanceof String[]) {
                    objArr[i2] = m14482a((String[]) objArr[i2]);
                }
                i = i2 + 1;
            } else {
                return "[" + Thread.currentThread().getId() + "] " + String.format(str, objArr);
            }
        }
    }

    /* renamed from: a */
    public static void m14485a(String str, Object... objArr) {
        C3890m.m14996b("Mms", m14488d(str, objArr));
    }

    /* renamed from: b */
    public static void m14486b(String str, Object... objArr) {
        C3890m.m14997c("Mms", m14488d(str, objArr));
    }

    /* renamed from: c */
    public static void m14487c(String str, Object... objArr) {
        C3890m.m14999e("Mms", m14488d(str, objArr));
    }

    /* renamed from: a */
    public static void m14483a(Context context) {
    }

    /* renamed from: a */
    public static void m14484a(String str, Activity activity) {
        C3890m.m14995a("Mms", "WARNING!!!! " + str, new RuntimeException());
    }
}
