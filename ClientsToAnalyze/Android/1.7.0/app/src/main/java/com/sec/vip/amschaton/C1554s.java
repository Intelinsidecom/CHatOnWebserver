package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.s */
/* loaded from: classes.dex */
class C1554s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1382as f5410a;

    C1554s(ViewOnClickListenerC1382as viewOnClickListenerC1382as) {
        this.f5410a = viewOnClickListenerC1382as;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f5410a.f4840c.setText(String.format("(%d/%d)", Integer.valueOf(this.f5410a.f4847j.m5627a(editable.toString())), Integer.valueOf(this.f5410a.f4843f)));
        this.f5410a.m4954d();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
