package com.sec.chaton.chat;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.gx */
/* loaded from: classes.dex */
class C1751gx implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1747gt f6579a;

    C1751gx(AlertDialogC1747gt alertDialogC1747gt) {
        this.f6579a = alertDialogC1747gt;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String strValueOf = String.valueOf(charSequence);
        if (strValueOf.trim().length() > 0 && !strValueOf.trim().equals(this.f6579a.f6572i)) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f6579a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f6579a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f6579a.getButton(-1).setEnabled(false);
        } else {
            this.f6579a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
