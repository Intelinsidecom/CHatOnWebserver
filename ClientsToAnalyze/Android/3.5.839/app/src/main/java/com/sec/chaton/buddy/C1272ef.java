package com.sec.chaton.buddy;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: BuddyGroupDialog.java */
/* renamed from: com.sec.chaton.buddy.ef */
/* loaded from: classes.dex */
class C1272ef implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1262dw f4806a;

    C1272ef(AlertDialogC1262dw alertDialogC1262dw) {
        this.f4806a = alertDialogC1262dw;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f4806a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f4806a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f4806a.getButton(-1).setEnabled(false);
        } else {
            this.f4806a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
