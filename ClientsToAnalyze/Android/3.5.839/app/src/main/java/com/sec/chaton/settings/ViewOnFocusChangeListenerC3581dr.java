package com.sec.chaton.settings;

import android.text.TextUtils;
import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dr */
/* loaded from: classes.dex */
class ViewOnFocusChangeListenerC3581dr implements View.OnFocusChangeListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13098a;

    ViewOnFocusChangeListenerC3581dr(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13098a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(this.f13098a.f13089q.getText())) {
                this.f13098a.f13089q.setText("00");
            } else {
                this.f13098a.f13089q.setText(String.format("%02d", Integer.valueOf(this.f13098a.f13077e)));
            }
        }
    }
}
