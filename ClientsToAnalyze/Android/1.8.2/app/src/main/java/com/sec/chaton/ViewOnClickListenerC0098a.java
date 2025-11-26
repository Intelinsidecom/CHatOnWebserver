package com.sec.chaton;

import android.view.View;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: DataPacketDialog.java */
/* renamed from: com.sec.chaton.a */
/* loaded from: classes.dex */
class ViewOnClickListenerC0098a implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DataPacketDialog f304a;

    ViewOnClickListenerC0098a(DataPacketDialog dataPacketDialog) {
        this.f304a = dataPacketDialog;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f304a.finish();
        GlobalApplication.m3258a(GlobalApplication.m3260b());
    }
}
