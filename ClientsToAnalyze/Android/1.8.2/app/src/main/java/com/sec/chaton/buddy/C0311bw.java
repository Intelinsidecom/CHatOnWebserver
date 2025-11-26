package com.sec.chaton.buddy;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.bw */
/* loaded from: classes.dex */
class C0311bw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0307bs f1430a;

    C0311bw(AlertDialogC0307bs alertDialogC0307bs) {
        this.f1430a = alertDialogC0307bs;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            this.f1430a.getButton(-2).setEnabled(true);
        } else {
            this.f1430a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
