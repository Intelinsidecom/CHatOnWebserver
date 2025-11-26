package com.sec.chaton.smsplugin.spam;

import android.os.Handler;
import android.os.Message;

/* compiled from: ManageSpamMessages.java */
/* renamed from: com.sec.chaton.smsplugin.spam.k */
/* loaded from: classes.dex */
class HandlerC4033k extends Handler {

    /* renamed from: a */
    final /* synthetic */ ManageSpamMessages f14540a;

    HandlerC4033k(ManageSpamMessages manageSpamMessages) {
        this.f14540a = manageSpamMessages;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f14540a.f14293k != null) {
            this.f14540a.f14293k.dismiss();
        }
        this.f14540a.m15313a(0);
    }
}
