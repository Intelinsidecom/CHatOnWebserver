package com.sec.chaton.push.p051b.p052a;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* compiled from: AbstractConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.b */
/* loaded from: classes.dex */
class C2058b implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC2057a f7916a;

    C2058b(AbstractC2057a abstractC2057a) {
        this.f7916a = abstractC2057a;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        synchronized (this.f7916a) {
            this.f7916a.f7913d = null;
        }
    }
}
