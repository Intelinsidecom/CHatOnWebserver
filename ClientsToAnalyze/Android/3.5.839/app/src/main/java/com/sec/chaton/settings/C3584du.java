package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.du */
/* loaded from: classes.dex */
class C3584du implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13101a;

    C3584du(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13101a = alertDialogC3576dm;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if ((editable.toString().equals(this.f13101a.f13089q.getText().toString()) && this.f13101a.f13088p.getText().toString().equals(this.f13101a.f13087o.getText().toString())) || editable.toString().equals("")) {
            if (!editable.toString().equals("")) {
                this.f13101a.f13078f = Integer.parseInt(this.f13101a.f13090r.getText().toString());
            }
            this.f13101a.getButton(-2).setEnabled(false);
            return;
        }
        this.f13101a.getButton(-2).setEnabled(true);
        this.f13101a.f13078f = Integer.parseInt(this.f13101a.f13090r.getText().toString());
    }
}
