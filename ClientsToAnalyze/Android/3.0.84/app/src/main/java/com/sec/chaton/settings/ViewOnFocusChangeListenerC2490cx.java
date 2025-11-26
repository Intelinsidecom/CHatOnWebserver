package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.cx */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC2490cx implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC2481co f9376a;

    ViewOnFocusChangeListenerC2490cx(AlertDialogC2481co alertDialogC2481co) {
        this.f9376a = alertDialogC2481co;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f9376a.f9365r.getText())) {
                this.f9376a.f9365r.setText("00");
            } else {
                this.f9376a.f9365r.setText(String.format("%02d", Integer.valueOf(this.f9376a.f9353f)));
            }
        }
    }
}
