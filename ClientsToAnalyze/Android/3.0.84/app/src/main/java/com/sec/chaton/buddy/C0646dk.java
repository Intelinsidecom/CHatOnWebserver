package com.sec.chaton.buddy;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.dk */
/* loaded from: classes.dex */
class C0646dk implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC0599dc f2866a;

    C0646dk(AlertDialogC0599dc alertDialogC0599dc) {
        this.f2866a = alertDialogC0599dc;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f2866a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f2866a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f2866a.getButton(-1).setEnabled(false);
        } else {
            this.f2866a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
