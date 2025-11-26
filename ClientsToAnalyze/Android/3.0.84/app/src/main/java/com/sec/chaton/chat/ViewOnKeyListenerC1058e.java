package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.e */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1058e implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f4168a;

    ViewOnKeyListenerC1058e(ChatFragment chatFragment) {
        this.f4168a = chatFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (66 != i || 1 != keyEvent.getAction() || !this.f4168a.f3507I) {
            return false;
        }
        this.f4168a.m4682E();
        return true;
    }
}
