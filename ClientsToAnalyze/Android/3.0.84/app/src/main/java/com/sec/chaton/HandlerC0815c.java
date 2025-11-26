package com.sec.chaton;

import android.os.Handler;
import android.os.Message;

/* compiled from: AdminMenu.java */
/* renamed from: com.sec.chaton.c */
/* loaded from: classes.dex */
class HandlerC0815c extends Handler {

    /* renamed from: a */
    final /* synthetic */ AdminMenu f3111a;

    HandlerC0815c(AdminMenu adminMenu) {
        this.f3111a = adminMenu;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f3111a.f631D.dismiss();
        this.f3111a.f632E = false;
        this.f3111a.m1103d();
    }
}
