package org.jboss.netty.channel.socket.nio;

import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.ReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.socket.SocketChannelConfig;

/* loaded from: classes.dex */
public interface NioSocketChannelConfig extends SocketChannelConfig {
    ReceiveBufferSizePredictor getReceiveBufferSizePredictor();

    ReceiveBufferSizePredictorFactory getReceiveBufferSizePredictorFactory();

    int getWriteBufferHighWaterMark();

    int getWriteBufferLowWaterMark();

    int getWriteSpinCount();

    void setReceiveBufferSizePredictor(ReceiveBufferSizePredictor receiveBufferSizePredictor);

    void setReceiveBufferSizePredictorFactory(ReceiveBufferSizePredictorFactory receiveBufferSizePredictorFactory);

    void setWriteBufferHighWaterMark(int i);

    void setWriteBufferLowWaterMark(int i);

    void setWriteSpinCount(int i);
}
