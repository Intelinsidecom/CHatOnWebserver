package com.sec.chaton.chat;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditChatTitleDialog.java */
/* renamed from: com.sec.chaton.chat.fb */
/* loaded from: classes.dex */
class C1087fb implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1082ex f4349a;

    C1087fb(AlertDialogC1082ex alertDialogC1082ex) {
        this.f4349a = alertDialogC1082ex;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f4349a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f4349a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f4349a.getButton(-1).setEnabled(false);
        } else {
            this.f4349a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
