package com.sec.widget;

import android.view.View;

/* compiled from: CustomDatePicker.java */
/* renamed from: com.sec.widget.j */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3676j implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ CustomDatePicker f13588a;

    ViewOnFocusChangeListenerC3676j(CustomDatePicker customDatePicker) {
        this.f13588a = customDatePicker;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) throws NumberFormatException {
        if (!z) {
            this.f13588a.m13074j();
        }
    }
}
