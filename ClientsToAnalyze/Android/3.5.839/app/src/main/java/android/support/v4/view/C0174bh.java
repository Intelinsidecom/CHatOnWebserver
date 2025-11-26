package android.support.v4.view;

import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewCompatJB.java */
/* renamed from: android.support.v4.view.bh */
/* loaded from: classes.dex */
class C0174bh {
    /* renamed from: a */
    public static void m676a(View view) {
        view.postInvalidateOnAnimation();
    }

    /* renamed from: a */
    public static void m678a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    /* renamed from: a */
    public static void m679a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    /* renamed from: b */
    public static int m680b(View view) {
        return view.getImportantForAccessibility();
    }

    /* renamed from: a */
    public static void m677a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    /* renamed from: c */
    public static ViewParent m681c(View view) {
        return view.getParentForAccessibility();
    }
}
