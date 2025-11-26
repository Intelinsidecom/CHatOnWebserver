package com.sec.chaton;

import android.view.View;
import com.sec.chaton.util.C1789u;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.e */
/* loaded from: classes.dex */
class ViewOnClickListenerC0655e implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f2529a;

    ViewOnClickListenerC0655e(DataPacketDialog dataPacketDialog) {
        this.f2529a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1789u.m6076a("PacketDataDialg", Boolean.valueOf(this.f2529a.f205b.isChecked()));
        this.f2529a.finish();
    }
}
