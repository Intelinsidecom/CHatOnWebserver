package com.sec.chaton.util;

import android.app.Activity;

/* compiled from: ThemeUtils.java */
/* renamed from: com.sec.chaton.util.cm */
/* loaded from: classes.dex */
public class C4875cm {

    /* renamed from: a */
    private static final String f17782a = C4875cm.class.getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static void m18511a(Activity activity) {
        try {
            activity.setTheme(((InterfaceC4876cn) activity).getDefaultTheme());
        } catch (ClassCastException e) {
            if (C4904y.f17874d) {
                C4904y.m18645d("The activity (" + activity + ") doesn't implement IThemable interface.", f17782a);
            }
        }
    }
}
