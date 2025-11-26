package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C1323bs;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.ak */
/* loaded from: classes.dex */
class ViewOnClickListenerC0248ak implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f595a;

    ViewOnClickListenerC0248ak(DataPacketDialog dataPacketDialog) {
        this.f595a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1323bs.m4576a("PacketDataDialg", Boolean.valueOf(this.f595a.f241b.isChecked()));
        this.f595a.setResult(-1, new Intent());
        this.f595a.finish();
    }
}
