package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cw */
/* loaded from: classes.dex */
class C2489cw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9375a;

    C2489cw(AlertDialogC2481co alertDialogC2481co) {
        this.f9375a = alertDialogC2481co;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f9375a.f9364q.getText().toString()) && this.f9375a.f9363p.getText().toString().equals(this.f9375a.f9362o.getText().toString())) || editable.toString().equals("")) {
            if (!editable.toString().equals("")) {
                this.f9375a.f9353f = Integer.parseInt(this.f9375a.f9365r.getText().toString());
            }
            this.f9375a.getButton(-2).setEnabled(false);
            return;
        }
        this.f9375a.getButton(-2).setEnabled(true);
        this.f9375a.f9353f = Integer.parseInt(this.f9375a.f9365r.getText().toString());
    }
}
