package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyFragment.java */
/* renamed from: com.sec.chaton.buddy.co */
/* loaded from: classes.dex */
class C0434co implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyFragment f1426a;

    C0434co(BuddyFragment buddyFragment) {
        this.f1426a = buddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1426a.m2097J();
        return true;
    }
}
