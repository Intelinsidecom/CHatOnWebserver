package com.sec.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.i */
/* loaded from: classes.dex */
class C3675i implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13587a;

    C3675i(CustomDatePicker customDatePicker) {
        this.f13587a = customDatePicker;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence.length() > 4) {
            this.f13587a.f13355e.setText(charSequence.subSequence(0, 4));
            this.f13587a.f13355e.setSelection(4);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
