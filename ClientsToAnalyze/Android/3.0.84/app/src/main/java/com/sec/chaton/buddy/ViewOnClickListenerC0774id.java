package com.sec.chaton.buddy;

import android.view.View;
import com.sec.chaton.p025d.C1330h;

/* compiled from: SpecialBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.id */
/* loaded from: classes.dex */
class ViewOnClickListenerC0774id implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpecialBuddyFragment f3045a;

    ViewOnClickListenerC0774id(SpecialBuddyFragment specialBuddyFragment) {
        this.f3045a = specialBuddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3045a.f2316u) {
            this.f3045a.f2316u = false;
            new C1330h(this.f3045a.f2299d).m5750f(this.f3045a.f2302g.m4000a());
            this.f3045a.m3887c(this.f3045a.f2316u);
        } else {
            this.f3045a.f2316u = true;
            new C1330h(this.f3045a.f2299d).m5746e(this.f3045a.f2302g.m4000a());
            this.f3045a.m3887c(this.f3045a.f2316u);
        }
    }
}
