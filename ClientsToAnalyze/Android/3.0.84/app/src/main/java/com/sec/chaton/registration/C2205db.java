package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.db */
/* loaded from: classes.dex */
class C2205db implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f8498a;

    C2205db(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f8498a = fragmentNonSelfSMS;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f8498a.f8239g.length() == 4) {
            this.f8498a.f8228I.setEnabled(true);
        } else {
            this.f8498a.f8228I.setEnabled(false);
        }
    }
}
