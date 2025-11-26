package android.support.v4.view;

import android.os.Bundle;
import android.support.v4.view.p009a.C0110a;
import android.support.v4.view.p009a.C0124k;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: android.support.v4.view.f */
/* loaded from: classes.dex */
class C0204f implements InterfaceC0211m {

    /* renamed from: a */
    final /* synthetic */ C0109a f481a;

    /* renamed from: b */
    final /* synthetic */ C0203e f482b;

    C0204f(C0203e c0203e, C0109a c0109a) {
        this.f482b = c0203e;
        this.f481a = c0109a;
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public boolean mo709a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f481a.m437b(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: b */
    public void mo711b(View view, AccessibilityEvent accessibilityEvent) {
        this.f481a.mo439d(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public void mo707a(View view, Object obj) {
        this.f481a.mo433a(view, new C0110a(obj));
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: c */
    public void mo712c(View view, AccessibilityEvent accessibilityEvent) {
        this.f481a.m438c(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public boolean mo710a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f481a.mo436a(viewGroup, view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public void mo706a(View view, int i) {
        this.f481a.m432a(view, i);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: d */
    public void mo713d(View view, AccessibilityEvent accessibilityEvent) {
        this.f481a.m434a(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public Object mo705a(View view) {
        C0124k c0124kM430a = this.f481a.m430a(view);
        if (c0124kM430a != null) {
            return c0124kM430a.m580a();
        }
        return null;
    }

    @Override // android.support.v4.view.InterfaceC0211m
    /* renamed from: a */
    public boolean mo708a(View view, int i, Bundle bundle) {
        return this.f481a.mo435a(view, i, bundle);
    }
}
