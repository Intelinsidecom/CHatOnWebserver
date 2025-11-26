package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.registration.ActivityNonSelfSMS;

/* compiled from: ActivityNonSelfSMS.java */
/* renamed from: com.sec.chaton.registration.be */
/* loaded from: classes.dex */
class C0960be implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS.NonSelfSMSFragment f3352a;

    C0960be(ActivityNonSelfSMS.NonSelfSMSFragment nonSelfSMSFragment) {
        this.f3352a = nonSelfSMSFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3352a.f3160f.length() == 4) {
            this.f3352a.f3163i.setEnabled(true);
            this.f3352a.f3162h.setButtonEnabled(true);
        } else {
            this.f3352a.f3163i.setEnabled(false);
            this.f3352a.f3162h.setButtonEnabled(false);
        }
    }
}
