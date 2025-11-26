package com.sec.chaton.msgbox;

import android.view.KeyEvent;
import android.view.View;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.e */
/* loaded from: classes.dex */
class ViewOnKeyListenerC1718e implements View.OnKeyListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f6375a;

    ViewOnKeyListenerC1718e(MsgboxFragment msgboxFragment) {
        this.f6375a = msgboxFragment;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && i == 67) {
            this.f6375a.f6247P = true;
            return false;
        }
        return false;
    }
}
