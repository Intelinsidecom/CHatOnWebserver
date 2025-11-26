package com.sec.chaton.registration;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: FragmentRegist.java */
/* renamed from: com.sec.chaton.registration.dx */
/* loaded from: classes.dex */
class C2227dx implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ FragmentRegist f8521a;

    C2227dx(FragmentRegist fragmentRegist) {
        this.f8521a = fragmentRegist;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f8521a.f8268H.equals("AR") || this.f8521a.f8268H.equals("MX") || this.f8521a.f8268H.equals("BR") ? this.f8521a.f8312z.getText().length() <= 0 || this.f8521a.f8261A.m11463a().length() <= 0 : this.f8521a.f8261A.m11463a().length() <= 0) {
            if (this.f8521a.f8263C != null) {
                this.f8521a.f8263C.setEnabled(false);
            }
        } else if (this.f8521a.f8309w != null && this.f8521a.f8263C != null) {
            this.f8521a.f8263C.setEnabled(true);
        }
    }
}
