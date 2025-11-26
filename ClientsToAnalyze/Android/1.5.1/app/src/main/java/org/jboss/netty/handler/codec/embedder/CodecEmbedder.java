package org.jboss.netty.handler.codec.embedder;

/* loaded from: classes.dex */
public interface CodecEmbedder {
    boolean finish();

    boolean offer(Object obj);

    Object peek();

    Object poll();

    Object[] pollAll();

    Object[] pollAll(Object[] objArr);

    int size();
}
