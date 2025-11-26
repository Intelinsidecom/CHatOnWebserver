package com.vlingo.sdk.internal.vlservice;

import com.vlingo.sdk.internal.http.cookies.CookieJarManager;
import com.vlingo.sdk.internal.http.cookies.CookieJarManagerSingleton;

/* loaded from: classes.dex */
public abstract class VLServiceCookieManager {
    public static synchronized CookieJarManager getInstance() {
        return CookieJarManagerSingleton.getInstance();
    }
}
