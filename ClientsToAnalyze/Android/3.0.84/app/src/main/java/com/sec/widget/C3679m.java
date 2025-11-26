package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.m */
/* loaded from: classes.dex */
class C3679m implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13591a;

    C3679m(CustomDatePicker customDatePicker) {
        this.f13591a = customDatePicker;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 2) {
            this.f13591a.f13353c.setText(charSequence.subSequence(0, 2));
            this.f13591a.f13353c.setSelection(2);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
