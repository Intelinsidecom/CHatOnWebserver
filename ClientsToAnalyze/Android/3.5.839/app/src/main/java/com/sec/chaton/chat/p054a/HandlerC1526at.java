package com.sec.chaton.chat.p054a;

import android.os.Handler;
import android.os.Message;

/* compiled from: TransportBubbleDrawer.java */
/* renamed from: com.sec.chaton.chat.a.at */
/* loaded from: classes.dex */
class HandlerC1526at extends Handler {

    /* renamed from: a */
    final /* synthetic */ AbstractC1525as f5916a;

    HandlerC1526at(AbstractC1525as abstractC1525as) {
        this.f5916a = abstractC1525as;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null) {
            this.f5916a.f5861h.f6438ah.setProgress(message.arg1);
        }
    }
}
