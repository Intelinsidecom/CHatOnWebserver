package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyProfileEditNameActivity.java */
/* renamed from: com.sec.chaton.buddy.fm */
/* loaded from: classes.dex */
class C1306fm implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ BuddyProfileEditNameActivity f4842a;

    C1306fm(BuddyProfileEditNameActivity buddyProfileEditNameActivity) {
        this.f4842a = buddyProfileEditNameActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f4842a.m6753g();
        return true;
    }
}
