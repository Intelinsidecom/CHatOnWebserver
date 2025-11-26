package com.sec.chaton.p018c.p020b;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* compiled from: OneToOneBicoder.java */
/* renamed from: com.sec.chaton.c.b.h */
/* loaded from: classes.dex */
public abstract class AbstractC0487h implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    /* renamed from: a */
    protected abstract Object mo2479a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    /* renamed from: b */
    protected abstract Object mo2482b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo2479a = mo2479a(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo2479a) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objMo2479a != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objMo2479a, messageEvent.getRemoteAddress());
        }
    }

    @Override // org.jboss.netty.channel.ChannelUpstreamHandler
    public void handleUpstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendUpstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo2482b = mo2482b(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo2482b) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objMo2482b != null) {
            Channels.fireMessageReceived(channelHandlerContext, objMo2482b, messageEvent.getRemoteAddress());
        }
    }
}
