package com.sec.chaton.settings;

import android.view.View;

/* compiled from: CustomTimePicker.java */
/* renamed from: com.sec.chaton.settings.dw */
/* loaded from: classes.dex */
class ViewOnClickListenerC3586dw implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AlertDialogC3576dm f13103a;

    ViewOnClickListenerC3586dw(AlertDialogC3576dm alertDialogC3576dm) {
        this.f13103a = alertDialogC3576dm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f13103a.f13092t != null) {
            this.f13103a.f13092t.setChecked(!this.f13103a.f13092t.isChecked());
        }
    }
}
