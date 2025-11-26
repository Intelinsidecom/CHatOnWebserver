package com.sec.widget;

import android.widget.NumberPicker;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.g */
/* loaded from: classes.dex */
class C3673g implements NumberPicker.OnValueChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13585a;

    C3673g(CustomDatePicker customDatePicker) {
        this.f13585a = customDatePicker;
    }

    @Override // android.widget.NumberPicker.OnValueChangeListener
    public void onValueChange(NumberPicker numberPicker, int i, int i2) throws NumberFormatException {
        this.f13585a.f13363m = i2;
        this.f13585a.m13074j();
    }
}
