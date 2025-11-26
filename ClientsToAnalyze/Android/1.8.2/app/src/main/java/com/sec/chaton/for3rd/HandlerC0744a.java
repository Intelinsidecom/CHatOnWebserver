package com.sec.chaton.for3rd;

import android.os.Handler;
import android.os.Message;

/* compiled from: AddonStatusService.java */
/* renamed from: com.sec.chaton.for3rd.a */
/* loaded from: classes.dex */
class HandlerC0744a extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddonStatusService f2744a;

    HandlerC0744a(AddonStatusService addonStatusService) {
        this.f2744a = addonStatusService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2744a.stopSelf();
    }
}
