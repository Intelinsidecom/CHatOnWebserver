package com.sec.chaton.chat.p023a;

import android.os.Handler;
import android.os.Message;

/* compiled from: TransportBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.ag */
/* loaded from: classes.dex */
class HandlerC0895ag extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractC0894af f3820a;

    HandlerC0895ag(AbstractC0894af abstractC0894af) {
        this.f3820a = abstractC0894af;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            this.f3820a.f3794h.f4237Z.setProgress(message.arg1);
        }
    }
}
