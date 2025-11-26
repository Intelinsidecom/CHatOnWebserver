package com.sec.chaton.buddy.honeycomb;

import android.view.View;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.util.C1786r;

/* compiled from: BuddySelectAdapter.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0420c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0257c f1628a;

    /* renamed from: b */
    final /* synthetic */ C0418a f1629b;

    ViewOnClickListenerC0420c(C0418a c0418a, C0257c c0257c) {
        this.f1629b = c0418a;
        this.f1628a = c0257c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1786r.m6067f("onClick() buddyNo : " + this.f1628a.m2318a(), C0418a.f1615a);
        this.f1628a.m2322a(false);
        this.f1629b.f1616b.mo2367a(this.f1628a);
        this.f1629b.f1625k.mo2044c(this.f1628a.m2318a());
    }
}
