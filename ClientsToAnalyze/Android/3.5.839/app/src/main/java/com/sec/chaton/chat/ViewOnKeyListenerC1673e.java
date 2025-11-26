package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.e */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1673e implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f6229a;

    ViewOnKeyListenerC1673e(ChatFragment chatFragment) {
        this.f6229a = chatFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) throws IllegalStateException {
        if (66 != i || 1 != keyEvent.getAction() || !this.f6229a.f5496M) {
            return false;
        }
        if (this.f6229a.f5513aF != null) {
            this.f6229a.f5513aF.m11538a();
        }
        this.f6229a.f5496M = false;
        return true;
    }
}
