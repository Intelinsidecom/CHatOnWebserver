package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.dd */
/* loaded from: classes.dex */
class ViewOnClickListenerC1194dd implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4423a;

    ViewOnClickListenerC1194dd(BuddyFragment buddyFragment) {
        this.f4423a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f4423a.f3718bw = true;
        this.f4423a.f3677bF.setText("");
        this.f4423a.m6574x();
    }
}
