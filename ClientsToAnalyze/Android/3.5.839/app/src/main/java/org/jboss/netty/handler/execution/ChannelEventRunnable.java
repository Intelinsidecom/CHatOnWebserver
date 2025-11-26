package org.jboss.netty.handler.execution;

import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;

/* loaded from: classes.dex */
public class ChannelEventRunnable implements Runnable {
    private final ChannelHandlerContext ctx;

    /* renamed from: e */
    private final ChannelEvent f19098e;

    public ChannelEventRunnable(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        this.ctx = channelHandlerContext;
        this.f19098e = channelEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ctx.sendUpstream(this.f19098e);
    }
}
