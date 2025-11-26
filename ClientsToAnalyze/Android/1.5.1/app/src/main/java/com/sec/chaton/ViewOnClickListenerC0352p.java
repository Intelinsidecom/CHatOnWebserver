package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.p */
/* loaded from: classes.dex */
class ViewOnClickListenerC0352p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f2585a;

    ViewOnClickListenerC0352p(DataPacketDialog dataPacketDialog) {
        this.f2585a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ChatONPref.m3520a("PacketDataDialg", Boolean.valueOf(this.f2585a.f286c.isChecked()));
        this.f2585a.finish();
    }
}
