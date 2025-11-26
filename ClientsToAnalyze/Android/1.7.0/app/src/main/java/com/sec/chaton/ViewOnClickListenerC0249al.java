package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.al */
/* loaded from: classes.dex */
class ViewOnClickListenerC0249al implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f596a;

    ViewOnClickListenerC0249al(DataPacketDialog dataPacketDialog) {
        this.f596a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f596a.f241b.isChecked()) {
            this.f596a.f241b.setChecked(false);
        } else {
            this.f596a.f241b.setChecked(true);
        }
    }
}
