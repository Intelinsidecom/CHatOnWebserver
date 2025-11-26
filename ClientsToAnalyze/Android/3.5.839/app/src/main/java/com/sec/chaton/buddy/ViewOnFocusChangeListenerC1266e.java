package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.e */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1266e implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4799a;

    ViewOnFocusChangeListenerC1266e(AddBuddyFragment addBuddyFragment) {
        this.f4799a = addBuddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f4799a.f3548s.hasFocus()) {
            this.f4799a.m6267a();
        }
    }
}
