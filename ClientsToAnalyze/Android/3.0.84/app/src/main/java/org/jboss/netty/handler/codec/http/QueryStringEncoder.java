package org.jboss.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class QueryStringEncoder {
    private final Charset charset;
    private final List<Param> params;
    private final String uri;

    public QueryStringEncoder(String str) {
        this(str, HttpCodecUtil.DEFAULT_CHARSET);
    }

    public QueryStringEncoder(String str, Charset charset) {
        this.params = new ArrayList();
        if (str == null) {
            throw new NullPointerException("uri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.uri = str;
        this.charset = charset;
    }

    @Deprecated
    public QueryStringEncoder(String str, String str2) {
        this(str, Charset.forName(str2));
    }

    public void addParam(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (str2 == null) {
            throw new NullPointerException("value");
        }
        this.params.add(new Param(str, str2));
    }

    public URI toUri() {
        return new URI(toString());
    }

    public String toString() {
        if (this.params.isEmpty()) {
            return this.uri;
        }
        StringBuilder sbAppend = new StringBuilder(this.uri).append("?");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.params.size()) {
                Param param = this.params.get(i2);
                sbAppend.append(encodeComponent(param.name, this.charset));
                sbAppend.append("=");
                sbAppend.append(encodeComponent(param.value, this.charset));
                if (i2 != this.params.size() - 1) {
                    sbAppend.append("&");
                }
                i = i2 + 1;
            } else {
                return sbAppend.toString();
            }
        }
    }

    private static String encodeComponent(String str, Charset charset) {
        try {
            return URLEncoder.encode(str, charset.name()).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    final class Param {
        final String name;
        final String value;

        Param(String str, String str2) {
            this.value = str2;
            this.name = str;
        }
    }
}
