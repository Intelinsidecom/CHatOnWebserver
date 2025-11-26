package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ev */
/* loaded from: classes.dex */
class C3261ev implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentRegistPushName f12028a;

    C3261ev(FragmentRegistPushName fragmentRegistPushName) {
        this.f12028a = fragmentRegistPushName;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f12028a.f11787a.length() > 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= this.f12028a.f11787a.length()) {
                    break;
                }
                if (this.f12028a.f11787a.getText().charAt(i4) != ' ') {
                    if (this.f12028a.f11805s != null) {
                        this.f12028a.f11805s.setEnabled(true);
                    }
                } else {
                    if (this.f12028a.f11805s != null) {
                        this.f12028a.f11805s.setEnabled(false);
                    }
                    i4++;
                }
            }
        }
        if (this.f12028a.f11787a.length() < 1 && this.f12028a.f11805s != null) {
            this.f12028a.f11805s.setEnabled(false);
        }
    }
}
