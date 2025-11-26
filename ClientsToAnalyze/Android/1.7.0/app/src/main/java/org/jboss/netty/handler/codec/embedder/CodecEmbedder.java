package org.jboss.netty.handler.codec.embedder;

import org.jboss.netty.channel.ChannelPipeline;

/* loaded from: classes.dex */
public interface CodecEmbedder {
    boolean finish();

    ChannelPipeline getPipeline();

    boolean offer(Object obj);

    Object peek();

    Object poll();

    Object[] pollAll();

    Object[] pollAll(Object[] objArr);

    int size();
}
