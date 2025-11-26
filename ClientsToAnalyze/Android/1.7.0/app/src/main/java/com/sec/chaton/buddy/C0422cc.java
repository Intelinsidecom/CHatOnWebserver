package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.cc */
/* loaded from: classes.dex */
class C0422cc implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0426cg f1407a;

    C0422cc(AlertDialogC0426cg alertDialogC0426cg) {
        this.f1407a = alertDialogC0426cg;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            this.f1407a.getButton(-2).setEnabled(true);
        } else {
            this.f1407a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
