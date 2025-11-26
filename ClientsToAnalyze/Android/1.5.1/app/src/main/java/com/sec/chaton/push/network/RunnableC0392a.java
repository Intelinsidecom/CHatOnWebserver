package com.sec.chaton.push.network;

import com.google.protobuf.MessageLite;

/* renamed from: com.sec.chaton.push.network.a */
/* loaded from: classes.dex */
class RunnableC0392a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MessageLite f2738a;

    /* renamed from: b */
    final /* synthetic */ MessageContext f2739b;

    RunnableC0392a(MessageContext messageContext, MessageLite messageLite) {
        this.f2739b = messageContext;
        this.f2738a = messageLite;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2739b.f2735b.mo2960a(this.f2739b.f2734a, this.f2738a);
    }
}
