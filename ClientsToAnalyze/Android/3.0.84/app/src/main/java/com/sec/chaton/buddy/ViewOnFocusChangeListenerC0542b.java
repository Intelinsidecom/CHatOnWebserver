package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.b */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0542b implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2501a;

    ViewOnFocusChangeListenerC0542b(AddBuddyFragment addBuddyFragment) {
        this.f2501a = addBuddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f2501a.f1695p.hasFocus()) {
            this.f2501a.m3197a();
        }
    }
}
