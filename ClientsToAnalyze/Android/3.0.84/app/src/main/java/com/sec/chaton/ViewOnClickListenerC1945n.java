package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C3159aa;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.n */
/* loaded from: classes.dex */
class ViewOnClickListenerC1945n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f7459a;

    ViewOnClickListenerC1945n(DataPacketDialog dataPacketDialog) {
        this.f7459a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C3159aa.m10963a("PacketDataDialg", Boolean.valueOf(this.f7459a.f672b.isChecked()));
        this.f7459a.setResult(-1, new Intent());
        this.f7459a.finish();
    }
}
