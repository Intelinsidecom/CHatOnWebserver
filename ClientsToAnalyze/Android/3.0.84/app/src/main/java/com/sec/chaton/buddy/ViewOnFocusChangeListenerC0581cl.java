package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cl */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0581cl implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2543a;

    ViewOnFocusChangeListenerC0581cl(BuddyFragment buddyFragment) {
        this.f2543a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f2543a.f1858bt.hasFocus()) {
            this.f2543a.m3240N();
        }
    }
}
