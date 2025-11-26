package com.sec.widget;

import android.view.View;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.l */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3678l implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13590a;

    ViewOnFocusChangeListenerC3678l(CustomDatePicker customDatePicker) {
        this.f13590a = customDatePicker;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) throws NumberFormatException {
        if (!z) {
            this.f13590a.m13074j();
        }
    }
}
