package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.do */
/* loaded from: classes.dex */
class C1254do implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f4756a;

    C1254do(BuddyFragment buddyFragment) {
        this.f4756a = buddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f4756a.m6369a(this.f4756a.f3677bF, false);
        return true;
    }
}
