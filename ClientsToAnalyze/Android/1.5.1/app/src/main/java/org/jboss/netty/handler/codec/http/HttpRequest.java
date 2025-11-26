package org.jboss.netty.handler.codec.http;

/* loaded from: classes.dex */
public interface HttpRequest extends HttpMessage {
    HttpMethod getMethod();

    String getUri();

    void setMethod(HttpMethod httpMethod);

    void setUri(String str);
}
