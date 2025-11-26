package org.jboss.netty.handler.codec.http;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class QueryStringDecoder {
    private final Charset charset;
    private Map params;
    private String path;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpCodecUtil.DEFAULT_CHARSET);
    }

    @Deprecated
    public QueryStringDecoder(String str, String str2) {
        this(str, Charset.forName(str2));
    }

    public QueryStringDecoder(String str, Charset charset) {
        if (str == null) {
            throw new NullPointerException("uri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.uri = str;
        this.charset = charset;
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpCodecUtil.DEFAULT_CHARSET);
    }

    @Deprecated
    public QueryStringDecoder(URI uri, String str) {
        this(uri, Charset.forName(str));
    }

    public QueryStringDecoder(URI uri, Charset charset) {
        if (uri == null) {
            throw new NullPointerException("uri");
        }
        if (charset == null) {
            throw new NullPointerException("charset");
        }
        this.uri = uri.toASCIIString();
        this.charset = charset;
    }

    private static void addParam(Map map, String str, String str2) {
        List arrayList = (List) map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList(1);
            map.put(str, arrayList);
        }
        arrayList.add(str2);
    }

    private static String decodeComponent(String str, Charset charset) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, charset.name());
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(charset.name());
        }
    }

    private Map decodeParams(String str) {
        String str2;
        int i = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        String strDecodeComponent = null;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '=' && strDecodeComponent == null) {
                strDecodeComponent = i2 != i ? decodeComponent(str.substring(i2, i), this.charset) : strDecodeComponent;
                i2 = i + 1;
            } else if (cCharAt == '&') {
                if (strDecodeComponent == null && i2 != i) {
                    addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "");
                    str2 = strDecodeComponent;
                } else if (strDecodeComponent != null) {
                    addParam(linkedHashMap, strDecodeComponent, decodeComponent(str.substring(i2, i), this.charset));
                    str2 = null;
                } else {
                    str2 = strDecodeComponent;
                }
                strDecodeComponent = str2;
                i2 = i + 1;
            }
            i++;
        }
        if (i2 != i) {
            if (strDecodeComponent == null) {
                addParam(linkedHashMap, decodeComponent(str.substring(i2, i), this.charset), "");
            } else {
                addParam(linkedHashMap, strDecodeComponent, decodeComponent(str.substring(i2, i), this.charset));
            }
        } else if (strDecodeComponent != null) {
            addParam(linkedHashMap, strDecodeComponent, "");
        }
        return linkedHashMap;
    }

    public Map getParameters() {
        if (this.params == null) {
            int length = getPath().length();
            if (this.uri.length() == length) {
                return Collections.emptyMap();
            }
            this.params = decodeParams(this.uri.substring(length + 1));
        }
        return this.params;
    }

    public String getPath() {
        if (this.path == null) {
            int iIndexOf = this.uri.indexOf(63);
            if (iIndexOf >= 0) {
                String strSubstring = this.uri.substring(0, iIndexOf);
                this.path = strSubstring;
                return strSubstring;
            }
            this.path = this.uri;
        }
        return this.path;
    }
}
