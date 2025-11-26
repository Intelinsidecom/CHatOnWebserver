package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bm */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0405bm implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1379a;

    ViewOnKeyListenerC0405bm(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1379a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        this.f1379a.m2070a(true);
        return true;
    }
}
