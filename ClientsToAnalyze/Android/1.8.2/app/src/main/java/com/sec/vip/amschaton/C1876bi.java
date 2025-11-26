package com.sec.vip.amschaton;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: TextInputLayout.java */
/* renamed from: com.sec.vip.amschaton.bi */
/* loaded from: classes.dex */
class C1876bi implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1875bh f6863a;

    C1876bi(ViewOnClickListenerC1875bh viewOnClickListenerC1875bh) {
        this.f6863a = viewOnClickListenerC1875bh;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f6863a.f6854c.setText(String.format("(%d/%d)", Integer.valueOf(this.f6863a.f6861j.m6498a(editable.toString())), Integer.valueOf(this.f6863a.f6857f)));
        this.f6863a.m6487d();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
