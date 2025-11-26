package com.vlingo.sdk.internal.http.cookies;

import java.util.Hashtable;

/* loaded from: classes.dex */
public interface CookieJarManager {
    void addAllCookiesToHashtable(Hashtable<?, ?> hashtable, String str, String str2);

    void addCookie(Cookie cookie);

    Cookie createCookie(String str, String str2);

    String getCookieValue(String str);

    void mergeCookies(CookieJar cookieJar);

    void removeCookie(String str);

    void save();
}
