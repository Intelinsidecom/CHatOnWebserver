package com.sec.chaton;

import android.view.View;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.f */
/* loaded from: classes.dex */
class ViewOnClickListenerC0712f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f2669a;

    ViewOnClickListenerC0712f(DataPacketDialog2 dataPacketDialog2) {
        this.f2669a = dataPacketDialog2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f2669a.f210c.isChecked()) {
            this.f2669a.f210c.setChecked(false);
        } else {
            this.f2669a.f210c.setChecked(true);
        }
    }
}
