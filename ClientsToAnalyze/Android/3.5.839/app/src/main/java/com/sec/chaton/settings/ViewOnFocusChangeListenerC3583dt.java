package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dt */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3583dt implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13100a;

    ViewOnFocusChangeListenerC3583dt(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13100a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f13100a.f13088p.getText())) {
                this.f13100a.f13088p.setText("00");
            } else {
                this.f13100a.f13088p.setText(String.format("%02d", Integer.valueOf(this.f13100a.f13076d)));
            }
        }
    }
}
