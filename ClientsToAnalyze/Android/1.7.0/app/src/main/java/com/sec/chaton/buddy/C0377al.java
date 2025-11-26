package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyGroupProfileActivity.java */
/* renamed from: com.sec.chaton.buddy.al */
/* loaded from: classes.dex */
class C0377al implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyGroupProfileActivity f1345a;

    C0377al(BuddyGroupProfileActivity buddyGroupProfileActivity) {
        this.f1345a = buddyGroupProfileActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1345a.m2229c();
        return true;
    }
}
