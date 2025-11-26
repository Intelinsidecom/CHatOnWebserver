package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: EditTextWithClearButton.java */
/* renamed from: com.sec.widget.s */
/* loaded from: classes.dex */
class C2147s implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ EditTextWithClearButton f7815a;

    C2147s(EditTextWithClearButton editTextWithClearButton) {
        this.f7815a = editTextWithClearButton;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f7815a.f7716f > 0 && this.f7815a.isFocused() && this.f7815a.f7715e >= 0 && charSequence.length() == this.f7815a.f7715e) {
            C2153y.m7535a(this.f7815a.getContext(), this.f7815a.f7716f, 0).show();
        }
        this.f7815a.m7453a(charSequence.length() > 0);
    }
}
