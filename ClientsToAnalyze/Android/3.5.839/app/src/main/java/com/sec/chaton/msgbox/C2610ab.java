package com.sec.chaton.msgbox;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.ab */
/* loaded from: classes.dex */
class C2610ab implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f9428a;

    C2610ab(MsgboxFragment msgboxFragment) {
        this.f9428a = msgboxFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f9428a.m11073m();
        return true;
    }
}
