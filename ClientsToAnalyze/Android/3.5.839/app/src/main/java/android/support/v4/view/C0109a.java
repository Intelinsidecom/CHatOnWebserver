package android.support.v4.view;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.p009a.C0110a;
import android.support.v4.view.p009a.C0124k;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: android.support.v4.view.a */
/* loaded from: classes.dex */
public class C0109a {

    /* renamed from: b */
    private static final InterfaceC0202d f446b;

    /* renamed from: c */
    private static final Object f447c;

    /* renamed from: a */
    final Object f448a = f446b.mo661a(this);

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f446b = new C0203e();
        } else if (Build.VERSION.SDK_INT >= 14) {
            f446b = new C0166b();
        } else {
            f446b = new C0205g();
        }
        f447c = f446b.mo660a();
    }

    /* renamed from: a */
    Object m431a() {
        return this.f448a;
    }

    /* renamed from: a */
    public void m432a(View view, int i) {
        f446b.mo662a(f447c, view, i);
    }

    /* renamed from: a */
    public void m434a(View view, AccessibilityEvent accessibilityEvent) {
        f446b.mo668d(f447c, view, accessibilityEvent);
    }

    /* renamed from: b */
    public boolean m437b(View view, AccessibilityEvent accessibilityEvent) {
        return f446b.mo664a(f447c, view, accessibilityEvent);
    }

    /* renamed from: c */
    public void m438c(View view, AccessibilityEvent accessibilityEvent) {
        f446b.mo667c(f447c, view, accessibilityEvent);
    }

    /* renamed from: d */
    public void mo439d(View view, AccessibilityEvent accessibilityEvent) {
        f446b.mo666b(f447c, view, accessibilityEvent);
    }

    /* renamed from: a */
    public void mo433a(View view, C0110a c0110a) {
        f446b.mo663a(f447c, view, c0110a);
    }

    /* renamed from: a */
    public boolean mo436a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f446b.mo665a(f447c, viewGroup, view, accessibilityEvent);
    }

    /* renamed from: a */
    public C0124k m430a(View view) {
        return f446b.mo703a(f447c, view);
    }

    /* renamed from: a */
    public boolean mo435a(View view, int i, Bundle bundle) {
        return f446b.mo704a(f447c, view, i, bundle);
    }
}
