package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.ce */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1168ce implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4390a;

    ViewOnFocusChangeListenerC1168ce(BuddyFragment buddyFragment) {
        this.f4390a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f4390a.f3677bF.hasFocus()) {
            this.f4390a.m6304K();
        }
    }
}
