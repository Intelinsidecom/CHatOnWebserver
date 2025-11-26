package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0236b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f768a;

    ViewOnClickListenerC0236b(DataPacketDialog dataPacketDialog) {
        this.f768a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f768a.f205b.isChecked()) {
            this.f768a.f205b.setChecked(false);
        } else {
            this.f768a.f205b.setChecked(true);
        }
    }
}
