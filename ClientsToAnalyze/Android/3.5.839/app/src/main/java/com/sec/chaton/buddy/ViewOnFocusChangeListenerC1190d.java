package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.d */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1190d implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4418a;

    ViewOnFocusChangeListenerC1190d(AddBuddyFragment addBuddyFragment) {
        this.f4418a = addBuddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f4418a.f3544o.hasFocus()) {
            this.f4418a.m6267a();
        }
    }
}
