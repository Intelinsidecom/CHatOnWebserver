package org.jboss.netty.handler.codec.http;

import java.util.List;
import java.util.Set;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.handler.codec.http.HttpHeaders;

/* loaded from: classes.dex */
public class DefaultHttpChunkTrailer implements HttpChunkTrailer {
    private final HttpHeaders headers = new HttpHeaders() { // from class: org.jboss.netty.handler.codec.http.DefaultHttpChunkTrailer.1
        @Override // org.jboss.netty.handler.codec.http.HttpHeaders
        void validateHeaderName(String str) {
            super.validateHeaderName(str);
            if (str.equalsIgnoreCase("Content-Length") || str.equalsIgnoreCase(HttpHeaders.Names.TRANSFER_ENCODING) || str.equalsIgnoreCase(HttpHeaders.Names.TRAILER)) {
                throw new IllegalArgumentException("prohibited trailing header: " + str);
            }
        }
    };

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer, org.jboss.netty.handler.codec.http.HttpChunk
    public boolean isLast() {
        return true;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public void addHeader(String str, Object obj) {
        this.headers.addHeader(str, obj);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public void setHeader(String str, Object obj) {
        this.headers.setHeader(str, obj);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public void setHeader(String str, Iterable iterable) {
        this.headers.setHeader(str, iterable);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public void clearHeaders() {
        this.headers.clearHeaders();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public String getHeader(String str) {
        return this.headers.getHeader(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public List getHeaders(String str) {
        return this.headers.getHeaders(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public List getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public boolean containsHeader(String str) {
        return this.headers.containsHeader(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunkTrailer
    public Set getHeaderNames() {
        return this.headers.getHeaderNames();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    public ChannelBuffer getContent() {
        return ChannelBuffers.EMPTY_BUFFER;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpChunk
    public void setContent(ChannelBuffer channelBuffer) {
        throw new IllegalStateException("read-only");
    }
}
