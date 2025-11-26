package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.eb */
/* loaded from: classes.dex */
class C3241eb implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f12008a;

    C3241eb(FragmentRegist fragmentRegist) {
        this.f12008a = fragmentRegist;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f12008a.f11728Q.equals("AR") || this.f12008a.f11728Q.equals("MX") || this.f12008a.f11728Q.equals("BR") ? this.f12008a.f11719H.getText().length() <= 0 || this.f12008a.f11720I.m18658a().length() <= 0 : this.f12008a.f11720I.m18658a().length() <= 0) {
            if (this.f12008a.f11722K != null) {
                this.f12008a.f11722K.setEnabled(false);
                return;
            }
            return;
        }
        if (this.f12008a.f11716E != null) {
            if (this.f12008a.f11759ar != null) {
                if (this.f12008a.f11759ar.length() > 0) {
                    for (int i4 = 0; i4 < this.f12008a.f11759ar.length(); i4++) {
                        if (this.f12008a.f11759ar.getText().charAt(i4) != ' ') {
                            if (this.f12008a.f11722K != null) {
                                this.f12008a.f11722K.setEnabled(true);
                                return;
                            }
                            return;
                        }
                        if (this.f12008a.f11722K != null) {
                            this.f12008a.f11722K.setEnabled(false);
                        }
                    }
                    return;
                }
                if (this.f12008a.f11722K != null) {
                    this.f12008a.f11722K.setEnabled(false);
                    return;
                }
                return;
            }
            if (this.f12008a.f11722K != null) {
                this.f12008a.f11722K.setEnabled(true);
            }
        }
    }
}
