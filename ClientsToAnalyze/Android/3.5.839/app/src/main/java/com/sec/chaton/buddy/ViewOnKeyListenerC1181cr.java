package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cr */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1181cr implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4409a;

    ViewOnKeyListenerC1181cr(BuddyFragment buddyFragment) {
        this.f4409a = buddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 67) {
            this.f4409a.f3718bw = true;
            return false;
        }
        return false;
    }
}
