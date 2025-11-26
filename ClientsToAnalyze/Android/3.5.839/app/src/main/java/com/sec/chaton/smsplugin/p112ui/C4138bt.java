package com.sec.chaton.smsplugin.p112ui;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.bt */
/* loaded from: classes.dex */
class C4138bt implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ C4132bn f15411a;

    C4138bt(C4132bn c4132bn) {
        this.f15411a = c4132bn;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f15411a.f15399t.getText().length() > 0) {
            this.f15411a.f15397r.setEnabled(true);
        } else {
            this.f15411a.f15397r.setEnabled(false);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
