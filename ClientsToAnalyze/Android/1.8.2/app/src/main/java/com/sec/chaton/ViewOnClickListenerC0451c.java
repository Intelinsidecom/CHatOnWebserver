package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.c */
/* loaded from: classes.dex */
class ViewOnClickListenerC0451c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f1721a;

    ViewOnClickListenerC0451c(DataPacketDialog dataPacketDialog) {
        this.f1721a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1721a.f205b.isChecked()) {
            this.f1721a.f205b.setChecked(false);
        } else {
            this.f1721a.f205b.setChecked(true);
        }
    }
}
