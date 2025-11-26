package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dq */
/* loaded from: classes.dex */
class C3580dq implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13097a;

    C3580dq(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13097a = alertDialogC3576dm;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f13097a.f13090r.getText().toString()) && this.f13097a.f13088p.getText().toString().equals(this.f13097a.f13087o.getText().toString())) || editable.toString().equals("")) {
            this.f13097a.getButton(-2).setEnabled(false);
            if (!editable.toString().equals("")) {
                this.f13097a.f13077e = Integer.parseInt(this.f13097a.f13089q.getText().toString());
                return;
            }
            return;
        }
        this.f13097a.f13077e = Integer.parseInt(this.f13097a.f13089q.getText().toString());
        this.f13097a.getButton(-2).setEnabled(true);
    }
}
