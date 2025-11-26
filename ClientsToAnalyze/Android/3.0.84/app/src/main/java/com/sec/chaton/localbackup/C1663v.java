package com.sec.chaton.localbackup;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.v */
/* loaded from: classes.dex */
class C1663v implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f6148a;

    C1663v(SecretKeyView secretKeyView) {
        this.f6148a = secretKeyView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6148a.f5972i = this.f6148a.f5966c.getText().toString();
        if (this.f6148a.f5972i.length() < 8 || this.f6148a.f5969f.length() <= 0) {
            this.f6148a.m6825a(false);
        } else {
            this.f6148a.m6825a(true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
