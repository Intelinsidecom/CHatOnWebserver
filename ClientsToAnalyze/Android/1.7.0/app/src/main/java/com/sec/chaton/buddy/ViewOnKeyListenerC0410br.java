package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.view.View;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.br */
/* loaded from: classes.dex */
class ViewOnKeyListenerC0410br implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1384a;

    ViewOnKeyListenerC0410br(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1384a = addBuddyFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || (i != 66 && i != 23)) {
            return false;
        }
        this.f1384a.m2070a(true);
        return true;
    }
}
