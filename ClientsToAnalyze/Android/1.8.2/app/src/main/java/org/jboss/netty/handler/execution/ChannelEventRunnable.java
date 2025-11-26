package org.jboss.netty.handler.execution;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.util.EstimatableObjectWrapper;

/* loaded from: classes.dex */
public class ChannelEventRunnable implements Runnable, EstimatableObjectWrapper {
    private final ChannelHandlerContext ctx;

    /* renamed from: e */
    private final ChannelEvent f7872e;
    int estimatedSize;

    public ChannelEventRunnable(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.ctx = channelHandlerContext;
        this.f7872e = channelEvent;
    }

    public ChannelHandlerContext getContext() {
        return this.ctx;
    }

    public ChannelEvent getEvent() {
        return this.f7872e;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ctx.sendUpstream(this.f7872e);
    }

    @Override // org.jboss.netty.util.EstimatableObjectWrapper
    public Object unwrap() {
        return this.f7872e;
    }
}
