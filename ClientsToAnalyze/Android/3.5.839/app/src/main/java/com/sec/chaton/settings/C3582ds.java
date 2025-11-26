package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.ds */
/* loaded from: classes.dex */
class C3582ds implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13099a;

    C3582ds(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13099a = alertDialogC3576dm;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f13099a.f13087o.getText().toString()) && this.f13099a.f13090r.getText().toString().equals(this.f13099a.f13089q.getText().toString())) || editable.toString().equals("")) {
            this.f13099a.getButton(-2).setEnabled(false);
            if (!editable.toString().equals("")) {
                this.f13099a.f13076d = Integer.parseInt(this.f13099a.f13088p.getText().toString());
                return;
            }
            return;
        }
        this.f13099a.getButton(-2).setEnabled(true);
        this.f13099a.f13076d = Integer.parseInt(this.f13099a.f13088p.getText().toString());
    }
}
