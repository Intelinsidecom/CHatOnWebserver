package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.b */
/* loaded from: classes.dex */
class ViewOnClickListenerC0251b implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f601a;

    ViewOnClickListenerC0251b(DataPacketDialog2 dataPacketDialog2) {
        this.f601a = dataPacketDialog2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4576a("PacketDataDialg", Boolean.valueOf(this.f601a.f245c.isChecked()));
        this.f601a.dismiss();
    }
}
