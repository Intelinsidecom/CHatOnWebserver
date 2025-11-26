package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.m */
/* loaded from: classes.dex */
class ViewOnClickListenerC1668m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f6153a;

    ViewOnClickListenerC1668m(DataPacketDialog dataPacketDialog) {
        this.f6153a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f6153a.f672b.isChecked()) {
            this.f6153a.f672b.setChecked(false);
        } else {
            this.f6153a.f672b.setChecked(true);
        }
    }
}
