package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C4809aa;

/* compiled from: DataPacketDialog2.java */
/* renamed from: com.sec.chaton.x */
/* loaded from: classes.dex */
class ViewOnClickListenerC4928x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog2 f17989a;

    ViewOnClickListenerC4928x(DataPacketDialog2 dataPacketDialog2) {
        this.f17989a = dataPacketDialog2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C4809aa.m18105a("PacketDataDialg", Boolean.valueOf(this.f17989a.f1924l.isChecked()));
        this.f17989a.m34a();
    }
}
