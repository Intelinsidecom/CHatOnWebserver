package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;

/* renamed from: com.sec.chaton.chat.h */
/* loaded from: classes.dex */
class C0146h implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f957a;

    C0146h(ChatFragment chatFragment) {
        this.f957a = chatFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f957a.f766aJ.performClick();
        return false;
    }
}
