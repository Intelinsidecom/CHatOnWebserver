package com.vlingo.sdk.internal.vlservice;

import com.vlingo.sdk.internal.http.cookies.AndroidCookie;
import com.vlingo.sdk.internal.http.cookies.AndroidCookieJar;
import com.vlingo.sdk.internal.http.cookies.Cookie;
import com.vlingo.sdk.internal.http.cookies.CookieJar;
import com.vlingo.sdk.internal.http.cookies.CookieJarManager;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.settings.Settings;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class AndroidVLServiceCookieManager implements CookieJarManager {
    private static final Logger log = Logger.getLogger(AndroidVLServiceCookieManager.class);
    private AndroidCookieJar persistentCookieJar;

    public AndroidVLServiceCookieManager() {
        log.debug("** creating VLServiceCookieManager");
        this.persistentCookieJar = new AndroidCookieJar(Settings.KEY_COOKIE_DATA);
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public void addAllCookiesToHashtable(Hashtable cookies, String domain, String path) {
        log.debug("** add all cookies to hashtable: " + cookies + " domain=" + domain + " path=" + path);
        this.persistentCookieJar.clearExpired();
        for (Cookie c : this.persistentCookieJar.getCookies()) {
            log.debug("** got cookie " + c);
            if (c.isMatch(domain, path)) {
                log.debug("** adding cookie: " + c);
                cookies.put(c.getName(), c.getValue());
            } else {
                log.debug("** ignoring cookie: " + c);
            }
        }
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public String getCookieValue(String cookieName) {
        Cookie c = this.persistentCookieJar.getCookieByName(cookieName);
        log.debug("getCookieValue name=" + cookieName);
        if (c != null) {
            return c.getValue();
        }
        return null;
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public Cookie createCookie(String name, String value) {
        log.debug("createCookie: name=" + name + ", value=" + value);
        return new AndroidCookie(name, value);
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public void mergeCookies(CookieJar newCookies) {
        log.debug("merge cookies: " + this + " " + newCookies);
        this.persistentCookieJar.mergeCookies(newCookies);
        this.persistentCookieJar.save();
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public void addCookie(Cookie c) {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    public void resetCookies() {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public void save() {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJarManager
    public void removeCookie(String name) {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }
}
