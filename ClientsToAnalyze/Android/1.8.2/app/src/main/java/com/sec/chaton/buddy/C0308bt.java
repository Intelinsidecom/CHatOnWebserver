package com.sec.chaton.buddy;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.bt */
/* loaded from: classes.dex */
class C0308bt implements TextView.OnEditorActionListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0307bs f1427a;

    C0308bt(AlertDialogC0307bs alertDialogC0307bs) {
        this.f1427a = alertDialogC0307bs;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        this.f1427a.m2387b();
        this.f1427a.dismiss();
        return true;
    }
}
