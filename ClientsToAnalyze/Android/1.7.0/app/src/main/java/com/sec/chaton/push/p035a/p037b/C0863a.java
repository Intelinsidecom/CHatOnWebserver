package com.sec.chaton.push.p035a.p037b;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* compiled from: AbstractConnectionManager.java */
/* renamed from: com.sec.chaton.push.a.b.a */
/* loaded from: classes.dex */
class C0863a implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC0865c f2988a;

    C0863a(AbstractC0865c abstractC0865c) {
        this.f2988a = abstractC0865c;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        synchronized (this.f2988a) {
            this.f2988a.f2992d = null;
        }
    }
}
