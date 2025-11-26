package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bi */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC0551bi implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2510a;

    ViewOnFocusChangeListenerC0551bi(BuddyFragment buddyFragment) {
        this.f2510a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f2510a.f1833bT.setEnabled(false);
        } else {
            this.f2510a.f1833bT.setEnabled(true);
        }
    }
}
