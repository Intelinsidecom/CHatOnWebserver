package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;
import com.sec.chaton.buddy.AddBuddyActivity;

/* compiled from: AddBuddyActivity.java */
/* renamed from: com.sec.chaton.buddy.bq */
/* loaded from: classes.dex */
class C0409bq implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AddBuddyActivity.AddBuddyFragment f1383a;

    C0409bq(AddBuddyActivity.AddBuddyFragment addBuddyFragment) {
        this.f1383a = addBuddyFragment;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f1383a.m2070a(true);
        return true;
    }
}
