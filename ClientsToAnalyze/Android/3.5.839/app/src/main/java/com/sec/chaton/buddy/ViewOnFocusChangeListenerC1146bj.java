package com.sec.chaton.buddy;

import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.bj */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC1146bj implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4365a;

    ViewOnFocusChangeListenerC1146bj(BuddyFragment buddyFragment) {
        this.f4365a = buddyFragment;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            this.f4365a.f3745ci.setEnabled(false);
        } else {
            this.f4365a.f3745ci.setEnabled(true);
        }
    }
}
