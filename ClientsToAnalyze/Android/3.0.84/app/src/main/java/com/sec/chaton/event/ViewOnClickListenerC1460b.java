package com.sec.chaton.event;

import android.view.View;

/* compiled from: EventDialog.java */
/* renamed from: com.sec.chaton.event.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC1460b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EventDialog f5437a;

    ViewOnClickListenerC1460b(EventDialog eventDialog) {
        this.f5437a = eventDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f5437a.f5420c.isChecked()) {
            this.f5437a.f5420c.setChecked(false);
        } else {
            this.f5437a.f5420c.setChecked(true);
        }
    }
}
