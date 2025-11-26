package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.buddy.p019a.C0513c;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.aj */
/* loaded from: classes.dex */
class ViewOnClickListenerC0525aj implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0513c f2467a;

    /* renamed from: b */
    final /* synthetic */ C0522ag f2468b;

    ViewOnClickListenerC0525aj(C0522ag c0522ag, C0513c c0513c) {
        this.f2468b = c0522ag;
        this.f2467a = c0513c;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2468b.f2457t.mo3424a(this.f2467a, view);
    }
}
