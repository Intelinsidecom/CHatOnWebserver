package com.sec.widget;

import android.widget.NumberPicker;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.c */
/* loaded from: classes.dex */
class C3669c implements NumberPicker.OnValueChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13579a;

    C3669c(CustomDatePicker customDatePicker) {
        this.f13579a = customDatePicker;
    }

    @Override // android.widget.NumberPicker.OnValueChangeListener
    public void onValueChange(NumberPicker numberPicker, int i, int i2) throws NumberFormatException {
        this.f13579a.f13361k = i2;
        this.f13579a.m13074j();
    }
}
