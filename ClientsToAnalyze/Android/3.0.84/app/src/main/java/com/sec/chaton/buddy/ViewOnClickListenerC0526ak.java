package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.p019a.C0513c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0526ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2469a;

    /* renamed from: b */
    final /* synthetic */ C0522ag f2470b;

    ViewOnClickListenerC0526ak(C0522ag c0522ag, C0513c c0513c) {
        this.f2470b = c0522ag;
        this.f2469a = c0513c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2470b.f2456s.mo3423a(this.f2469a);
    }
}
