package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.da */
/* loaded from: classes.dex */
class C3213da implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentNonSelfSMS f11978a;

    C3213da(FragmentNonSelfSMS fragmentNonSelfSMS) {
        this.f11978a = fragmentNonSelfSMS;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f11978a.f11685g.length() == 4) {
            this.f11978a.f11673J.setEnabled(true);
        } else {
            this.f11978a.f11673J.setEnabled(false);
        }
    }
}
