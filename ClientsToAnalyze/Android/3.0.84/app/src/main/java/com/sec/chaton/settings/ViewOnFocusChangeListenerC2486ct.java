package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.ct */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2486ct implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9372a;

    ViewOnFocusChangeListenerC2486ct(AlertDialogC2481co alertDialogC2481co) {
        this.f9372a = alertDialogC2481co;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f9372a.f9364q.getText())) {
                this.f9372a.f9364q.setText("00");
            } else {
                this.f9372a.f9364q.setText(String.format("%02d", Integer.valueOf(this.f9372a.f9352e)));
            }
        }
    }
}
