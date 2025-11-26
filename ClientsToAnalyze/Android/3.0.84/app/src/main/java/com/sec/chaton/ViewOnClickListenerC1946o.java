package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C3159aa;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.o */
/* loaded from: classes.dex */
class ViewOnClickListenerC1946o implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f7460a;

    ViewOnClickListenerC1946o(DataPacketDialog2 dataPacketDialog2) {
        this.f7460a = dataPacketDialog2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3159aa.m10963a("PacketDataDialg", Boolean.valueOf(this.f7460a.f676c.isChecked()));
        this.f7460a.dismiss();
    }
}
