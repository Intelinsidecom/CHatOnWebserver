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
    private Map<String, List<String>> params;
    private String path;
    private final String uri;

    public QueryStringDecoder(String str) {
        this(str, HttpCodecUtil.DEFAULT_CHARSET);
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

    @Deprecated
    public QueryStringDecoder(String str, String str2) {
        this(str, Charset.forName(str2));
    }

    public QueryStringDecoder(URI uri) {
        this(uri, HttpCodecUtil.DEFAULT_CHARSET);
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

    @Deprecated
    public QueryStringDecoder(URI uri, String str) {
        this(uri, Charset.forName(str));
    }

    public String getPath() {
        if (this.path == null) {
            int iIndexOf = this.uri.indexOf(63);
            if (iIndexOf < 0) {
                this.path = this.uri;
            } else {
                String strSubstring = this.uri.substring(0, iIndexOf);
                this.path = strSubstring;
                return strSubstring;
            }
        }
        return this.path;
    }

    public Map<String, List<String>> getParameters() {
        if (this.params == null) {
            int length = getPath().length();
            if (this.uri.length() == length) {
                return Collections.emptyMap();
            }
            this.params = decodeParams(this.uri.substring(length + 1));
        }
        return this.params;
    }

    private Map<String, List<String>> decodeParams(String str) {
        String str2;
        int i;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        int i3 = 0;
        String strDecodeComponent = null;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '=' && strDecodeComponent == null) {
                if (i3 != i2) {
                    strDecodeComponent = decodeComponent(str.substring(i3, i2), this.charset);
                }
                str2 = strDecodeComponent;
                i = i2 + 1;
            } else if (cCharAt == '&') {
                if (strDecodeComponent == null && i3 != i2) {
                    addParam(linkedHashMap, decodeComponent(str.substring(i3, i2), this.charset), "");
                    str2 = strDecodeComponent;
                } else if (strDecodeComponent != null) {
                    addParam(linkedHashMap, strDecodeComponent, decodeComponent(str.substring(i3, i2), this.charset));
                    str2 = null;
                } else {
                    str2 = strDecodeComponent;
                }
                i = i2 + 1;
            } else {
                int i4 = i3;
                str2 = strDecodeComponent;
                i = i4;
            }
            i2++;
            int i5 = i;
            strDecodeComponent = str2;
            i3 = i5;
        }
        if (i3 != i2) {
            if (strDecodeComponent == null) {
                addParam(linkedHashMap, decodeComponent(str.substring(i3, i2), this.charset), "");
            } else {
                addParam(linkedHashMap, strDecodeComponent, decodeComponent(str.substring(i3, i2), this.charset));
            }
        } else if (strDecodeComponent != null) {
            addParam(linkedHashMap, strDecodeComponent, "");
        }
        return linkedHashMap;
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

    private static void addParam(Map<String, List<String>> map, String str, String str2) {
        List<String> arrayList = map.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>(1);
            map.put(str, arrayList);
        }
        arrayList.add(str2);
    }
}
