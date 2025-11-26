package com.sec.chaton.localbackup;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: SecretKeyView.java */
/* renamed from: com.sec.chaton.localbackup.x */
/* loaded from: classes.dex */
class C2565x implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SecretKeyView f9193a;

    C2565x(SecretKeyView secretKeyView) {
        this.f9193a = secretKeyView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f9193a.f9014i = this.f9193a.f9008c.getText().toString();
        if (this.f9193a.f9014i.length() < 8 || this.f9193a.f9011f.length() <= 0) {
            this.f9193a.m10853a(false);
        } else {
            this.f9193a.m10853a(true);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
