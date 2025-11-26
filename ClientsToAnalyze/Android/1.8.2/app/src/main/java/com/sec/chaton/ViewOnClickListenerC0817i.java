package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C1789u;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.i */
/* loaded from: classes.dex */
class ViewOnClickListenerC0817i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f3008a;

    ViewOnClickListenerC0817i(DataPacketDialog2 dataPacketDialog2) {
        this.f3008a = dataPacketDialog2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1789u.m6076a("PacketDataDialg", Boolean.valueOf(this.f3008a.f210c.isChecked()));
        this.f3008a.dismiss();
    }
}
