package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.socket.SocketChannelConfig;

/* loaded from: classes.dex */
public interface NioSocketChannelConfig extends SocketChannelConfig {
    ReceiveBufferSizePredictor getReceiveBufferSizePredictor();

    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    int getWriteSpinCount();
}
