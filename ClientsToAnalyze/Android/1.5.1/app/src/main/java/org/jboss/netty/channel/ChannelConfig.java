package org.jboss.netty.channel;

import java.util.Map;
import org.jboss.netty.buffer.ChannelBufferFactory;

/* loaded from: classes.dex */
public interface ChannelConfig {
    ChannelBufferFactory getBufferFactory();

    int getConnectTimeoutMillis();

    ChannelPipelineFactory getPipelineFactory();

    void setBufferFactory(ChannelBufferFactory channelBufferFactory);

    void setConnectTimeoutMillis(int i);

    boolean setOption(String str, Object obj);

    void setOptions(Map map);

    void setPipelineFactory(ChannelPipelineFactory channelPipelineFactory);
}
