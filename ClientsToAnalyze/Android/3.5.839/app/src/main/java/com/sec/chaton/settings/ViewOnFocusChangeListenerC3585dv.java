package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dv */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3585dv implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13102a;

    ViewOnFocusChangeListenerC3585dv(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13102a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f13102a.f13090r.getText())) {
                this.f13102a.f13090r.setText("00");
            } else {
                this.f13102a.f13090r.setText(String.format("%02d", Integer.valueOf(this.f13102a.f13078f)));
            }
        }
    }
}
