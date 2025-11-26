package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0441f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1433a;

    ViewOnClickListenerC0441f(BuddyFragment buddyFragment) {
        this.f1433a = buddyFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1433a.f1159q.setEnabled(false);
        this.f1433a.m2187x();
    }
}
