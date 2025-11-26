package org.jboss.netty.handler.execution;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.util.EstimatableObjectWrapper;

/* loaded from: classes.dex */
public class ChannelEventRunnable implements Runnable, EstimatableObjectWrapper {
    private final ChannelHandlerContext ctx;

    /* renamed from: e */
    private final ChannelEvent f13708e;
    int estimatedSize;

    public ChannelEventRunnable(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.ctx = channelHandlerContext;
        this.f13708e = channelEvent;
    }

    public ChannelHandlerContext getContext() {
        return this.ctx;
    }

    public ChannelEvent getEvent() {
        return this.f13708e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ctx.sendUpstream(this.f13708e);
    }

    @Override // org.jboss.netty.util.EstimatableObjectWrapper
    public Object unwrap() {
        return this.f13708e;
    }
}
