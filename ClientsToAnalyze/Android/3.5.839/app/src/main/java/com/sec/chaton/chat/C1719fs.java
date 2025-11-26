package com.sec.chaton.chat;

import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: ChatInfoMoreFragment.java */
/* renamed from: com.sec.chaton.chat.fs */
/* loaded from: classes.dex */
class C1719fs implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC1716fp f6330a;

    C1719fs(AlertDialogC1716fp alertDialogC1716fp) {
        this.f6330a = alertDialogC1716fp;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (String.valueOf(charSequence).trim().length() > 0) {
            if (Build.VERSION.SDK_INT < 14) {
                this.f6330a.getButton(-1).setEnabled(true);
                return;
            } else {
                this.f6330a.getButton(-2).setEnabled(true);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 14) {
            this.f6330a.getButton(-1).setEnabled(false);
        } else {
            this.f6330a.getButton(-2).setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
