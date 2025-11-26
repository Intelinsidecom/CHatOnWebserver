package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cv */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2488cv implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9374a;

    ViewOnFocusChangeListenerC2488cv(AlertDialogC2481co alertDialogC2481co) {
        this.f9374a = alertDialogC2481co;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f9374a.f9363p.getText())) {
                this.f9374a.f9363p.setText("00");
            } else {
                this.f9374a.f9363p.setText(String.format("%02d", Integer.valueOf(this.f9374a.f9351d)));
            }
        }
    }
}
