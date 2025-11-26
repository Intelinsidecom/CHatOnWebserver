package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;
import com.sec.chaton.registration.ActivityRegistPushName;

/* compiled from: ActivityRegistPushName.java */
/* renamed from: com.sec.chaton.registration.af */
/* loaded from: classes.dex */
class C0934af implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ActivityRegistPushName.RegistPushNameFragment f3321a;

    C0934af(ActivityRegistPushName.RegistPushNameFragment registPushNameFragment) {
        this.f3321a = registPushNameFragment;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f3321a.f3232a.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f3321a.f3232a.length()) {
                    break;
                }
                if (this.f3321a.f3232a.getText().charAt(i4) != ' ') {
                    this.f3321a.f3233b.setEnabled(true);
                    this.f3321a.f3246o.setButtonEnabled(true);
                    break;
                } else {
                    this.f3321a.f3233b.setEnabled(false);
                    this.f3321a.f3246o.setButtonEnabled(false);
                    i4++;
                }
            }
        }
        if (this.f3321a.f3232a.length() < 1) {
            this.f3321a.f3233b.setEnabled(false);
            this.f3321a.f3246o.setButtonEnabled(false);
        }
    }
}
