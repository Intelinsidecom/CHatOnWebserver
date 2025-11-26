package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dn */
/* loaded from: classes.dex */
class C3577dn implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13094a;

    C3577dn(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13094a = alertDialogC3576dm;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f13094a.f13088p.getText().toString()) && this.f13094a.f13090r.getText().toString().equals(this.f13094a.f13089q.getText().toString())) || editable.toString().equals("")) {
            if (!editable.toString().equals("")) {
                this.f13094a.f13075c = Integer.parseInt(this.f13094a.f13087o.getText().toString());
            }
            this.f13094a.getButton(-2).setEnabled(false);
            return;
        }
        this.f13094a.f13075c = Integer.parseInt(this.f13094a.f13087o.getText().toString());
        this.f13094a.getButton(-2).setEnabled(true);
    }
}
