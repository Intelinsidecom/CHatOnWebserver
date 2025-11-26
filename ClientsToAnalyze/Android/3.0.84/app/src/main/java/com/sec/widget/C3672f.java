package com.sec.widget;

import android.widget.NumberPicker;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.f */
/* loaded from: classes.dex */
class C3672f implements NumberPicker.OnValueChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13584a;

    C3672f(CustomDatePicker customDatePicker) {
        this.f13584a = customDatePicker;
    }

    @Override // android.widget.NumberPicker.OnValueChangeListener
    public void onValueChange(NumberPicker numberPicker, int i, int i2) throws NumberFormatException {
        this.f13584a.f13362l = i2 - 1;
        this.f13584a.m13074j();
    }
}
