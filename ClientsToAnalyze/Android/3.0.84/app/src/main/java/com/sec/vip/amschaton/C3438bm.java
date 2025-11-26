package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bm */
/* loaded from: classes.dex */
class C3438bm implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC3437bl f12586a;

    C3438bm(ViewOnClickListenerC3437bl viewOnClickListenerC3437bl) {
        this.f12586a = viewOnClickListenerC3437bl;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f12586a.f12577c.setText(String.format("(%d/%d)", Integer.valueOf(this.f12586a.f12584j.m12320a(editable.toString())), Integer.valueOf(this.f12586a.f12580f)));
        this.f12586a.m12309d();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
