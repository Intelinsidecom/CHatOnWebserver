package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.c */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0569c implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f2531a;

    ViewOnFocusChangeListenerC0569c(AddBuddyFragment addBuddyFragment) {
        this.f2531a = addBuddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!this.f2531a.f1699t.hasFocus()) {
            this.f2531a.m3197a();
        }
    }
}
