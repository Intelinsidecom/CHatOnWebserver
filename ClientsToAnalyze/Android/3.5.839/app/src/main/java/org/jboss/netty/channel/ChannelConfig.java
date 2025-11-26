package org.jboss.netty.channel;

import java.util.Map;
import org.jboss.netty.buffer.ChannelBufferFactory;

/* loaded from: classes.dex */
public interface ChannelConfig {
    ChannelBufferFactory getBufferFactory();

    int getConnectTimeoutMillis();

    void setOptions(Map<String, Object> map);
}
