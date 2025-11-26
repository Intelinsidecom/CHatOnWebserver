package com.sec.chaton.push.p041b.p042a;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* compiled from: AbstractConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.b */
/* loaded from: classes.dex */
class C1085b implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC1084a f4013a;

    C1085b(AbstractC1084a abstractC1084a) {
        this.f4013a = abstractC1084a;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        synchronized (this.f4013a) {
            this.f4013a.f4010d = null;
        }
    }
}
