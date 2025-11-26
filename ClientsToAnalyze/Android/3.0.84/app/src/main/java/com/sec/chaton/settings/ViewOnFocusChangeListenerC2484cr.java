package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cr */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2484cr implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9370a;

    ViewOnFocusChangeListenerC2484cr(AlertDialogC2481co alertDialogC2481co) {
        this.f9370a = alertDialogC2481co;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f9370a.f9362o.getText())) {
                this.f9370a.f9362o.setText("00");
            } else {
                this.f9370a.f9362o.setText(String.format("%02d", Integer.valueOf(this.f9370a.f9350c)));
            }
        }
    }
}
