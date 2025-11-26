package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.k */
/* loaded from: classes.dex */
class C3677k implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13589a;

    C3677k(CustomDatePicker customDatePicker) {
        this.f13589a = customDatePicker;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 2) {
            this.f13589a.f13354d.setText(charSequence.subSequence(0, 2));
            this.f13589a.f13354d.setSelection(2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
