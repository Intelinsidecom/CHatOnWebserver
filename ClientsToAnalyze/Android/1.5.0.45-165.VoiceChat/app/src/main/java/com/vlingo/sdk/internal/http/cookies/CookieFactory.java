package com.vlingo.sdk.internal.http.cookies;

/* loaded from: classes.dex */
public class CookieFactory {
    public static synchronized Cookie newInstance(String name, String value) {
        return CookieJarManagerSingleton.getInstance().createCookie(name, value);
    }
}
