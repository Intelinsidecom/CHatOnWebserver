package com.sec.widget;

import android.view.View;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.d */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3670d implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13580a;

    ViewOnFocusChangeListenerC3670d(CustomDatePicker customDatePicker) {
        this.f13580a = customDatePicker;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) throws NumberFormatException {
        if (!z) {
            this.f13580a.m13074j();
        }
    }
}
