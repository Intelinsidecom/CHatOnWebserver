package org.jboss.netty.channel;

import java.util.Map;

/* loaded from: classes.dex */
public interface ChannelPipeline {
    void addAfter(String str, String str2, ChannelHandler channelHandler);

    void addBefore(String str, String str2, ChannelHandler channelHandler);

    void addFirst(String str, ChannelHandler channelHandler);

    void addLast(String str, ChannelHandler channelHandler);

    void attach(Channel channel, ChannelSink channelSink);

    ChannelHandler get(Class cls);

    ChannelHandler get(String str);

    Channel getChannel();

    ChannelHandlerContext getContext(Class cls);

    ChannelHandlerContext getContext(String str);

    ChannelHandlerContext getContext(ChannelHandler channelHandler);

    ChannelHandler getFirst();

    ChannelHandler getLast();

    ChannelSink getSink();

    boolean isAttached();

    ChannelHandler remove(Class cls);

    ChannelHandler remove(String str);

    void remove(ChannelHandler channelHandler);

    ChannelHandler removeFirst();

    ChannelHandler removeLast();

    ChannelHandler replace(Class cls, String str, ChannelHandler channelHandler);

    ChannelHandler replace(String str, String str2, ChannelHandler channelHandler);

    void replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2);

    void sendDownstream(ChannelEvent channelEvent);

    void sendUpstream(ChannelEvent channelEvent);

    Map toMap();
}
