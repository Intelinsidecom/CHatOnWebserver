package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cs */
/* loaded from: classes.dex */
class C2485cs implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9371a;

    C2485cs(AlertDialogC2481co alertDialogC2481co) {
        this.f9371a = alertDialogC2481co;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f9371a.f9365r.getText().toString()) && this.f9371a.f9363p.getText().toString().equals(this.f9371a.f9362o.getText().toString())) || editable.toString().equals("")) {
            this.f9371a.getButton(-2).setEnabled(false);
            if (!editable.toString().equals("")) {
                this.f9371a.f9352e = Integer.parseInt(this.f9371a.f9364q.getText().toString());
                return;
            }
            return;
        }
        this.f9371a.f9352e = Integer.parseInt(this.f9371a.f9364q.getText().toString());
        this.f9371a.getButton(-2).setEnabled(true);
    }
}
