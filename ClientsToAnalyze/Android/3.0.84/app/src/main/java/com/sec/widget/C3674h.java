package com.sec.widget;

import android.widget.CompoundButton;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.h */
/* loaded from: classes.dex */
class C3674h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13586a;

    C3674h(CustomDatePicker customDatePicker) {
        this.f13586a = customDatePicker;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws NumberFormatException {
        this.f13586a.f13365o = z;
        this.f13586a.m13074j();
    }
}
