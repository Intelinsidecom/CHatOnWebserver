package org.jboss.netty.channel;

/* loaded from: classes.dex */
public interface ReceiveBufferSizePredictor {
    int nextReceiveBufferSize();

    void previousReceiveBufferSize(int i);
}
