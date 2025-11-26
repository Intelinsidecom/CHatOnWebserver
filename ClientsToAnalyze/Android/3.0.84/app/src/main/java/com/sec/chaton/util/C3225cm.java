package com.sec.chaton.util;

import android.app.Activity;

/* compiled from: ThemeUtils.java */
/* renamed from: com.sec.chaton.util.cm */
/* loaded from: classes.dex */
public class C3225cm {

    /* renamed from: a */
    private static final String f11660a = C3225cm.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m11337a(Activity activity) {
        try {
            activity.setTheme(((InterfaceC3226cn) activity).getDefaultTheme());
        } catch (ClassCastException e) {
            if (C3250y.f11736d) {
                C3250y.m11455d("The activity (" + activity + ") doesn't implement IThemable interface.", f11660a);
            }
        }
    }
}
