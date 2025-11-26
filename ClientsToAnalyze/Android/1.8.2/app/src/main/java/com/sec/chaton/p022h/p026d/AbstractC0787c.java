package com.sec.chaton.p022h.p026d;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* compiled from: OneToOneBicoder.java */
/* renamed from: com.sec.chaton.h.d.c */
/* loaded from: classes.dex */
public abstract class AbstractC0787c implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    /* renamed from: a */
    protected abstract Object mo3370a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    /* renamed from: b */
    protected abstract Object mo3371b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo3370a = mo3370a(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo3370a) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objMo3370a != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objMo3370a, messageEvent.getRemoteAddress());
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
        Object objMo3371b = mo3371b(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo3371b) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objMo3371b != null) {
            Channels.fireMessageReceived(channelHandlerContext, objMo3371b, messageEvent.getRemoteAddress());
        }
    }
}
