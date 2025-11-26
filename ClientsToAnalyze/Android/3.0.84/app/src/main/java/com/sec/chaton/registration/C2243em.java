package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.em */
/* loaded from: classes.dex */
class C2243em implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f8538a;

    C2243em(FragmentRegistPushName fragmentRegistPushName) {
        this.f8538a = fragmentRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f8538a.f8313a.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f8538a.f8313a.length()) {
                    break;
                }
                if (this.f8538a.f8313a.getText().charAt(i4) != ' ') {
                    if (this.f8538a.f8331s != null) {
                        this.f8538a.f8331s.setEnabled(true);
                    }
                } else {
                    this.f8538a.f8331s.setEnabled(false);
                    i4++;
                }
            }
        }
        if (this.f8538a.f8313a.length() < 1 && this.f8538a.f8331s != null) {
            this.f8538a.f8331s.setEnabled(false);
        }
    }
}
