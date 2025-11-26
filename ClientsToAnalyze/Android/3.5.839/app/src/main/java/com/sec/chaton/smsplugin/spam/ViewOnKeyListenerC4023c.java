package com.sec.chaton.smsplugin.spam;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.c */
/* loaded from: classes.dex */
class ViewOnKeyListenerC4023c implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14502a;

    ViewOnKeyListenerC4023c(ManageSpamMessages manageSpamMessages) {
        this.f14502a = manageSpamMessages;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 20 || this.f14502a.f14286d == null || this.f14502a.f14286d.getVisibility() != 0) {
            return false;
        }
        this.f14502a.f14286d.requestFocus();
        return true;
    }
}
