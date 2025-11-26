package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.cr */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0587cr implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f2550a;

    ViewOnKeyListenerC0587cr(BuddyFragment buddyFragment) {
        this.f2550a = buddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 67) {
            BuddyFragment.f1731i = true;
            return false;
        }
        return false;
    }
}
