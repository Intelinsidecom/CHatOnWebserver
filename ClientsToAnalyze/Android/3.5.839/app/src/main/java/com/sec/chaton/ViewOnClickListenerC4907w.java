package com.sec.chaton;

import android.content.Intent;
import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.w */
/* loaded from: classes.dex */
class ViewOnClickListenerC4907w implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f17878a;

    ViewOnClickListenerC4907w(DataPacketDialog dataPacketDialog) {
        this.f17878a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4809aa.m18105a("PacketDataDialg", Boolean.valueOf(this.f17878a.f1920b.isChecked()));
        this.f17878a.setResult(-1, new Intent());
        this.f17878a.finish();
    }
}
