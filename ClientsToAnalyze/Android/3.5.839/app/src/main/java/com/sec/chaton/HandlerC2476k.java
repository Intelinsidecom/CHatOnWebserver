package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.k */
/* loaded from: classes.dex */
class HandlerC2476k extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f8882a;

    HandlerC2476k(AdminMenu adminMenu) {
        this.f8882a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f8882a.f1885V.dismiss();
        this.f8882a.f1886W = false;
        this.f8882a.m2851i();
    }
}
