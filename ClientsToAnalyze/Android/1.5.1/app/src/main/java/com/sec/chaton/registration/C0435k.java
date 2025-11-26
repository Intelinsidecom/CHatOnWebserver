package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: com.sec.chaton.registration.k */
/* loaded from: classes.dex */
class C0435k implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityNonSelfSMS f2948a;

    C0435k(ActivityNonSelfSMS activityNonSelfSMS) {
        this.f2948a = activityNonSelfSMS;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2948a.f2829v.length() > 0) {
            for (int i4 = 0; i4 < this.f2948a.f2829v.length(); i4++) {
                if (this.f2948a.f2829v.getText().charAt(i4) != ' ' && this.f2948a.f2816i.length() == 6 && this.f2948a.f2808a != null) {
                    this.f2948a.f2818k.setEnabled(true);
                    return;
                }
                this.f2948a.f2818k.setEnabled(false);
            }
        }
    }
}
