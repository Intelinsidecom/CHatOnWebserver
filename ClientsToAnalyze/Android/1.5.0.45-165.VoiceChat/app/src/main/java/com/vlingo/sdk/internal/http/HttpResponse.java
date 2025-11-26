package com.vlingo.sdk.internal.http;

import com.vlingo.sdk.internal.http.cookies.CookieJar;
import java.io.UnsupportedEncodingException;

/* loaded from: classes.dex */
public class HttpResponse {
    CookieJar cookies;
    private final byte[] data;
    public final int responseCode;

    public HttpResponse(int responseCode, byte[] data) {
        this(responseCode, data, null);
    }

    public HttpResponse(int responseCode, byte[] data, CookieJar cookies) {
        this.responseCode = responseCode;
        this.data = data;
        this.cookies = cookies;
    }

    public CookieJar getCookies() {
        return this.cookies;
    }

    public int getDataLength() {
        if (this.data != null) {
            return this.data.length;
        }
        return 0;
    }

    public byte[] getDataAsBytes() {
        return this.data;
    }

    public String getDataAsString() {
        return getDataAsString("UTF-8");
    }

    public String getDataAsString(String encoding) {
        try {
            if (this.data == null) {
                return "";
            }
            String result = new String(this.data, encoding);
            return result;
        } catch (UnsupportedEncodingException e) {
            String result2 = new String(this.data);
            return result2;
        }
    }
}
