package org.jboss.netty.handler.codec.http;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.util.internal.StringUtil;

/* loaded from: classes.dex */
public class DefaultHttpMessage implements HttpMessage {
    private boolean chunked;
    private HttpVersion version;
    private final HttpHeaders headers = new HttpHeaders();
    private ChannelBuffer content = ChannelBuffers.EMPTY_BUFFER;

    protected DefaultHttpMessage(HttpVersion httpVersion) {
        setProtocolVersion(httpVersion);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void addHeader(String str, Object obj) {
        this.headers.addHeader(str, obj);
    }

    void appendHeaders(StringBuilder sb) {
        for (Map.Entry entry : getHeaders()) {
            sb.append((String) entry.getKey());
            sb.append(": ");
            sb.append((String) entry.getValue());
            sb.append(StringUtil.NEWLINE);
        }
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void clearHeaders() {
        this.headers.clearHeaders();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public boolean containsHeader(String str) {
        return this.headers.containsHeader(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public ChannelBuffer getContent() {
        return this.content;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    @Deprecated
    public long getContentLength() {
        return HttpHeaders.getContentLength(this);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    @Deprecated
    public long getContentLength(long j) {
        return HttpHeaders.getContentLength(this, j);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public String getHeader(String str) {
        List headers = getHeaders(str);
        if (headers.size() > 0) {
            return (String) headers.get(0);
        }
        return null;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public Set getHeaderNames() {
        return this.headers.getHeaderNames();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public List getHeaders() {
        return this.headers.getHeaders();
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public List getHeaders(String str) {
        return this.headers.getHeaders(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public HttpVersion getProtocolVersion() {
        return this.version;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public boolean isChunked() {
        if (this.chunked) {
            return true;
        }
        return HttpCodecUtil.isTransferEncodingChunked(this);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    @Deprecated
    public boolean isKeepAlive() {
        return HttpHeaders.isKeepAlive(this);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void removeHeader(String str) {
        this.headers.removeHeader(str);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void setChunked(boolean z) {
        this.chunked = z;
        if (z) {
            setContent(ChannelBuffers.EMPTY_BUFFER);
        }
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void setContent(ChannelBuffer channelBuffer) {
        ChannelBuffer channelBuffer2 = channelBuffer == null ? ChannelBuffers.EMPTY_BUFFER : channelBuffer;
        if (channelBuffer2.readable() && isChunked()) {
            throw new IllegalArgumentException("non-empty content disallowed if this.chunked == true");
        }
        this.content = channelBuffer2;
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void setHeader(String str, Iterable iterable) {
        this.headers.setHeader(str, iterable);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void setHeader(String str, Object obj) {
        this.headers.setHeader(str, obj);
    }

    @Override // org.jboss.netty.handler.codec.http.HttpMessage
    public void setProtocolVersion(HttpVersion httpVersion) {
        if (httpVersion == null) {
            throw new NullPointerException("version");
        }
        this.version = httpVersion;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(version: ");
        sb.append(getProtocolVersion().getText());
        sb.append(", keepAlive: ");
        sb.append(isKeepAlive());
        sb.append(", chunked: ");
        sb.append(isChunked());
        sb.append(')');
        sb.append(StringUtil.NEWLINE);
        appendHeaders(sb);
        sb.setLength(sb.length() - StringUtil.NEWLINE.length());
        return sb.toString();
    }
}
