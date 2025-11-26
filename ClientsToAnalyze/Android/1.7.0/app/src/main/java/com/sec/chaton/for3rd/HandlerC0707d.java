package com.sec.chaton.for3rd;

import android.os.Handler;
import android.os.Message;

/* compiled from: AddonStatusService.java */
/* renamed from: com.sec.chaton.for3rd.d */
/* loaded from: classes.dex */
class HandlerC0707d extends Handler {

    /* renamed from: a */
    final /* synthetic */ AddonStatusService f2392a;

    HandlerC0707d(AddonStatusService addonStatusService) {
        this.f2392a = addonStatusService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f2392a.stopSelf();
    }
}
