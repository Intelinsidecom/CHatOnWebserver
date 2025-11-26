package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.j */
/* loaded from: classes.dex */
class C0434j implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1650a;

    C0434j(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1650a = addBuddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f1650a.m1872a(true);
        return true;
    }
}
