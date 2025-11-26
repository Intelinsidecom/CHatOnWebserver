package com.sec.chaton.chat;

import android.view.KeyEvent;
import android.widget.TextView;
import java.io.IOException;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aj */
/* loaded from: classes.dex */
class C0468aj implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1936a;

    C0468aj(ChatFragment chatFragment) {
        this.f1936a = chatFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) throws IOException {
        if (i != 4 && (!this.f1936a.f1808aW || keyEvent.getKeyCode() != 66)) {
            return false;
        }
        this.f1936a.f1800aO.setSoundEffectsEnabled(false);
        this.f1936a.m2607e();
        return true;
    }
}
