package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cp */
/* loaded from: classes.dex */
class C2482cp implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9368a;

    C2482cp(AlertDialogC2481co alertDialogC2481co) {
        this.f9368a = alertDialogC2481co;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f9368a.f9363p.getText().toString()) && this.f9368a.f9365r.getText().toString().equals(this.f9368a.f9364q.getText().toString())) || editable.toString().equals("")) {
            if (!editable.toString().equals("")) {
                this.f9368a.f9350c = Integer.parseInt(this.f9368a.f9362o.getText().toString());
            }
            this.f9368a.getButton(-2).setEnabled(false);
            return;
        }
        this.f9368a.f9350c = Integer.parseInt(this.f9368a.f9362o.getText().toString());
        this.f9368a.getButton(-2).setEnabled(true);
    }
}
