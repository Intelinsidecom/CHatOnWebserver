package org.jboss.netty.channel;

import java.net.SocketAddress;

/* loaded from: classes.dex */
public interface Channel extends Comparable<Channel> {
    ChannelFuture bind(SocketAddress socketAddress);

    ChannelFuture close();

    ChannelFuture connect(SocketAddress socketAddress);

    ChannelFuture disconnect();

    ChannelFuture getCloseFuture();

    ChannelConfig getConfig();

    Integer getId();

    SocketAddress getLocalAddress();

    Channel getParent();

    ChannelPipeline getPipeline();

    SocketAddress getRemoteAddress();

    boolean isConnected();

    boolean isOpen();

    ChannelFuture write(Object obj);
}
