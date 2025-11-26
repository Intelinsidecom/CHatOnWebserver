package com.sec.chaton.p067j.p071d;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelDownstreamHandler;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelUpstreamHandler;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;

/* compiled from: OneToOneBicoder.java */
/* renamed from: com.sec.chaton.j.d.c */
/* loaded from: classes.dex */
public abstract class AbstractC2446c implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    /* renamed from: a */
    protected abstract Object mo10615a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    /* renamed from: b */
    protected abstract Object mo10616b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo10615a = mo10615a(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo10615a) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objMo10615a != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objMo10615a, messageEvent.getRemoteAddress());
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
        Object objMo10616b = mo10616b(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo10616b) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objMo10616b != null) {
            Channels.fireMessageReceived(channelHandlerContext, objMo10616b, messageEvent.getRemoteAddress());
        }
    }
}
