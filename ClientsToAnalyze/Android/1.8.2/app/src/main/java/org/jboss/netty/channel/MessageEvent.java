package org.jboss.netty.channel;

import java.net.SocketAddress;

/* loaded from: classes.dex */
public interface MessageEvent extends ChannelEvent {
    Object getMessage();

    SocketAddress getRemoteAddress();
}
