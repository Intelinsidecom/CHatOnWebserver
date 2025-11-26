package com.sec.chaton.event;

import android.view.View;

/* compiled from: EventDialog.java */
/* renamed from: com.sec.chaton.event.d */
/* loaded from: classes.dex */
class ViewOnClickListenerC1462d implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ EventDialog f5439a;

    ViewOnClickListenerC1462d(EventDialog eventDialog) {
        this.f5439a = eventDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1464f.m6393b(this.f5439a.f5420c.isChecked());
        this.f5439a.finish();
    }
}
