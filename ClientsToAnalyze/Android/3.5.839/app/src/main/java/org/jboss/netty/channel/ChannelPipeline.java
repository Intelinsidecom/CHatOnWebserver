package org.jboss.netty.channel;

import java.util.Map;

/* loaded from: classes.dex */
public interface ChannelPipeline {
    void addLast(String str, ChannelHandler channelHandler);

    void attach(Channel channel, ChannelSink channelSink);

    <T extends ChannelHandler> T get(Class<T> cls);

    ChannelHandler get(String str);

    Channel getChannel();

    ChannelHandler getLast();

    void sendDownstream(ChannelEvent channelEvent);

    void sendUpstream(ChannelEvent channelEvent);

    Map<String, ChannelHandler> toMap();
}
