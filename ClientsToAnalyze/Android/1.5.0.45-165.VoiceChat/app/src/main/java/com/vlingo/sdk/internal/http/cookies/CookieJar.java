package com.vlingo.sdk.internal.http.cookies;

/* loaded from: classes.dex */
public interface CookieJar {
    void addCookie(Cookie cookie);

    void mergeCookies(CookieJar cookieJar);
}
