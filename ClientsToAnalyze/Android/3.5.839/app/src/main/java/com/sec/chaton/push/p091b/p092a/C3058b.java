package com.sec.chaton.push.p091b.p092a;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* compiled from: AbstractConnectionManager.java */
/* renamed from: com.sec.chaton.push.b.a.b */
/* loaded from: classes.dex */
class C3058b implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC3057a f11326a;

    C3058b(AbstractC3057a abstractC3057a) {
        this.f11326a = abstractC3057a;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        synchronized (this.f11326a) {
            this.f11326a.f11323d = null;
        }
    }
}
