package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.em */
/* loaded from: classes.dex */
class C0675em implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f2897a;

    C0675em(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f2897a = buddyProfileEditNameActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f2897a.m3581b();
        return true;
    }
}
