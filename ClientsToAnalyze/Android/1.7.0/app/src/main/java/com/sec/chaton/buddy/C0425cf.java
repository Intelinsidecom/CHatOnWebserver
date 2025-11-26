package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.cf */
/* loaded from: classes.dex */
class C0425cf implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0426cg f1410a;

    C0425cf(AlertDialogC0426cg alertDialogC0426cg) {
        this.f1410a = alertDialogC0426cg;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1410a.m2374b();
        this.f1410a.dismiss();
        return true;
    }
}
