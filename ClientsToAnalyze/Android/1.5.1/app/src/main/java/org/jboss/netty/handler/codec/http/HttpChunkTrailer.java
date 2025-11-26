package org.jboss.netty.handler.codec.http;

import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public interface HttpChunkTrailer extends HttpChunk {
    void addHeader(String str, Object obj);

    void clearHeaders();

    boolean containsHeader(String str);

    String getHeader(String str);

    Set getHeaderNames();

    List getHeaders();

    List getHeaders(String str);

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    boolean isLast();

    void removeHeader(String str);

    void setHeader(String str, Iterable iterable);

    void setHeader(String str, Object obj);
}
