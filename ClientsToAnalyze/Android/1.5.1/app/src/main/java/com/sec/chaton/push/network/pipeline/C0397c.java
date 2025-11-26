package com.sec.chaton.push.network.pipeline;

import com.google.protobuf.MessageLite;
import com.sec.chaton.push.network.MessageContext;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;

/* renamed from: com.sec.chaton.push.network.pipeline.c */
/* loaded from: classes.dex */
class C0397c implements ChannelFutureListener {

    /* renamed from: a */
    final /* synthetic */ MessageContext f2776a;

    /* renamed from: b */
    final /* synthetic */ PushMessageChannelHandler f2777b;

    C0397c(PushMessageChannelHandler pushMessageChannelHandler, MessageContext messageContext) {
        this.f2777b = pushMessageChannelHandler;
        this.f2776a = messageContext;
    }

    @Override // org.jboss.netty.channel.ChannelFutureListener
    public void operationComplete(ChannelFuture channelFuture) {
        if (channelFuture.isDone() && channelFuture.isSuccess()) {
            this.f2776a.m2974b((MessageLite) null);
        } else {
            this.f2776a.m2970a(-2);
        }
    }
}
