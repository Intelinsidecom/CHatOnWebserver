package android.support.v4.view;

import android.support.v4.view.p009a.C0110a;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: android.support.v4.view.c */
/* loaded from: classes.dex */
class C0193c implements InterfaceC0208j {

    /* renamed from: a */
    final /* synthetic */ C0109a f477a;

    /* renamed from: b */
    final /* synthetic */ C0166b f478b;

    C0193c(C0166b c0166b, C0109a c0109a) {
        this.f478b = c0166b;
        this.f477a = c0109a;
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: a */
    public boolean mo693a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f477a.m437b(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: b */
    public void mo695b(View view, AccessibilityEvent accessibilityEvent) {
        this.f477a.mo439d(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: a */
    public void mo692a(View view, Object obj) {
        this.f477a.mo433a(view, new C0110a(obj));
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: c */
    public void mo696c(View view, AccessibilityEvent accessibilityEvent) {
        this.f477a.m438c(view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: a */
    public boolean mo694a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f477a.mo436a(viewGroup, view, accessibilityEvent);
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: a */
    public void mo691a(View view, int i) {
        this.f477a.m432a(view, i);
    }

    @Override // android.support.v4.view.InterfaceC0208j
    /* renamed from: d */
    public void mo697d(View view, AccessibilityEvent accessibilityEvent) {
        this.f477a.m434a(view, accessibilityEvent);
    }
}
