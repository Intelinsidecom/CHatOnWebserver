package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cq */
/* loaded from: classes.dex */
class ViewOnClickListenerC0586cq implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2549a;

    ViewOnClickListenerC0586cq(BuddyFragment buddyFragment) {
        this.f2549a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2549a.f1858bt.setText("");
        BuddyFragment.f1731i = true;
        this.f2549a.m3214A();
        this.f2549a.f1804ap.m4054b();
    }
}
