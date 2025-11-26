package com.sec.chaton.settings;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentPasswordLockHint.java */
/* renamed from: com.sec.chaton.settings.dw */
/* loaded from: classes.dex */
class C2659dw implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentPasswordLockHint f9924a;

    C2659dw(FragmentPasswordLockHint fragmentPasswordLockHint) {
        this.f9924a = fragmentPasswordLockHint;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f9924a.f9166c.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f9924a.f9166c.length()) {
                    break;
                }
                if (this.f9924a.f9166c.getText().charAt(i4) != ' ') {
                    if (this.f9924a.f9169f != null) {
                        this.f9924a.f9169f.setEnabled(true);
                    }
                } else {
                    i4++;
                }
            }
        }
        if (this.f9924a.f9166c.length() < 1 && this.f9924a.f9169f != null) {
            this.f9924a.f9169f.setEnabled(false);
        }
    }
}
