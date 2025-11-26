package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: AddBuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.c */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1163c implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyFragment f4382a;

    ViewOnKeyListenerC1163c(AddBuddyFragment addBuddyFragment) {
        this.f4382a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        view.performClick();
        return true;
    }
}
