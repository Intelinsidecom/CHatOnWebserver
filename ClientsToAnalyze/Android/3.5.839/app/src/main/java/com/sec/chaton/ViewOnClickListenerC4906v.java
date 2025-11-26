package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.v */
/* loaded from: classes.dex */
class ViewOnClickListenerC4906v implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f17877a;

    ViewOnClickListenerC4906v(DataPacketDialog dataPacketDialog) {
        this.f17877a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f17877a.f1920b.isChecked()) {
            this.f17877a.f1920b.setChecked(false);
        } else {
            this.f17877a.f1920b.setChecked(true);
        }
    }
}
