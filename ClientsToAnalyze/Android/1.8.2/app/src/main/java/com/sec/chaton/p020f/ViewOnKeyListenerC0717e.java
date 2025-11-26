package com.sec.chaton.p020f;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: DialogMenuAdapter.java */
/* renamed from: com.sec.chaton.f.e */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0717e implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ C0719g f2681a;

    /* renamed from: b */
    final /* synthetic */ C0715c f2682b;

    ViewOnKeyListenerC0717e(C0715c c0715c, C0719g c0719g) {
        this.f2682b = c0715c;
        this.f2681a = c0719g;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || keyEvent.getAction() != 1) {
            return false;
        }
        this.f2682b.f2676b.mo2602a(C0715c.f2675a, this.f2681a.f2685c);
        this.f2682b.f2676b.m2603b();
        return true;
    }
}
