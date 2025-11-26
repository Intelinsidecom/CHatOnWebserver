package com.sec.chaton.p037j.p041d;

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
public abstract class AbstractC1569c implements ChannelDownstreamHandler, ChannelUpstreamHandler {
    /* renamed from: a */
    protected abstract Object mo6671a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    /* renamed from: b */
    protected abstract Object mo6672b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj);

    @Override // org.jboss.netty.channel.ChannelDownstreamHandler
    public void handleDownstream(ChannelHandlerContext channelHandlerContext, ChannelEvent channelEvent) {
        if (!(channelEvent instanceof MessageEvent)) {
            channelHandlerContext.sendDownstream(channelEvent);
            return;
        }
        MessageEvent messageEvent = (MessageEvent) channelEvent;
        Object message = messageEvent.getMessage();
        Object objMo6671a = mo6671a(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo6671a) {
            channelHandlerContext.sendDownstream(channelEvent);
        } else if (objMo6671a != null) {
            Channels.write(channelHandlerContext, messageEvent.getFuture(), objMo6671a, messageEvent.getRemoteAddress());
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
        Object objMo6672b = mo6672b(channelHandlerContext, messageEvent.getChannel(), message);
        if (message == objMo6672b) {
            channelHandlerContext.sendUpstream(channelEvent);
        } else if (objMo6672b != null) {
            Channels.fireMessageReceived(channelHandlerContext, objMo6672b, messageEvent.getRemoteAddress());
        }
    }
}
