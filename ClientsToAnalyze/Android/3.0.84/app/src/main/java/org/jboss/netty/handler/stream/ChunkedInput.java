package org.jboss.netty.handler.stream;

/* loaded from: classes.dex */
public interface ChunkedInput {
    void close();

    boolean hasNextChunk();

    boolean isEndOfInput();

    Object nextChunk();
}
