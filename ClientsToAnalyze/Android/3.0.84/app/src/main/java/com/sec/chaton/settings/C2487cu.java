package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cu */
/* loaded from: classes.dex */
class C2487cu implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9373a;

    C2487cu(AlertDialogC2481co alertDialogC2481co) {
        this.f9373a = alertDialogC2481co;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f9373a.f9362o.getText().toString()) && this.f9373a.f9365r.getText().toString().equals(this.f9373a.f9364q.getText().toString())) || editable.toString().equals("")) {
            this.f9373a.getButton(-2).setEnabled(false);
            if (!editable.toString().equals("")) {
                this.f9373a.f9351d = Integer.parseInt(this.f9373a.f9363p.getText().toString());
                return;
            }
            return;
        }
        this.f9373a.getButton(-2).setEnabled(true);
        this.f9373a.f9351d = Integer.parseInt(this.f9373a.f9363p.getText().toString());
    }
}
