package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dp */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3579dp implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13096a;

    ViewOnFocusChangeListenerC3579dp(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13096a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f13096a.f13087o.getText())) {
                this.f13096a.f13087o.setText("00");
            } else {
                this.f13096a.f13087o.setText(String.format("%02d", Integer.valueOf(this.f13096a.f13075c)));
            }
        }
    }
}
