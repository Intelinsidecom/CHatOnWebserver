package com.sec.chaton.smsplugin.p111h;

import android.annotation.SuppressLint;
import android.content.Context;

/* compiled from: Recycler.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.h.w */
/* loaded from: classes.dex */
public abstract class AbstractC3900w {

    /* renamed from: a */
    private static C3902y f14014a;

    /* renamed from: b */
    private static C3901x f14015b;

    /* renamed from: a */
    protected abstract void mo15069a(Context context, long j, int i);

    /* renamed from: b */
    public abstract int mo15070b(Context context);

    /* renamed from: a */
    public static C3902y m15065a() {
        if (f14014a == null) {
            f14014a = new C3902y();
        }
        return f14014a;
    }

    /* renamed from: b */
    public static C3901x m15067b() {
        if (f14015b == null) {
            f14015b = new C3901x();
        }
        return f14015b;
    }

    /* renamed from: a */
    public void m15068a(Context context, long j) {
        if (m15066a(context)) {
            mo15069a(context, j, mo15070b(context));
        }
    }

    /* renamed from: a */
    public static boolean m15066a(Context context) {
        return false;
    }
}
