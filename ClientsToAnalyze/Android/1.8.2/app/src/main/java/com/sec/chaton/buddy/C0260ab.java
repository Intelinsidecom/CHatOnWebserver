package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyChatInfoActivity.java */
/* renamed from: com.sec.chaton.buddy.ab */
/* loaded from: classes.dex */
class C0260ab implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyChatInfoActivity f1355a;

    C0260ab(BuddyChatInfoActivity buddyChatInfoActivity) {
        this.f1355a = buddyChatInfoActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1355a.m1893a();
        return true;
    }
}
