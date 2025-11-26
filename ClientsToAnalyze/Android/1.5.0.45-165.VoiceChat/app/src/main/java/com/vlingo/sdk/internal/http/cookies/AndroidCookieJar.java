package com.vlingo.sdk.internal.http.cookies;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.HttpConnection;
import com.vlingo.sdk.internal.settings.Settings;
import com.vlingo.sdk.internal.util.StringUtils;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.impl.client.BasicCookieStore;

/* loaded from: classes.dex */
public class AndroidCookieJar implements CookieJar {
    private static final Logger log = Logger.getLogger(CookieJar.class);
    protected BasicCookieStore m_Store;
    private String prefName;

    public AndroidCookieJar() {
        this.m_Store = new BasicCookieStore();
    }

    public AndroidCookieJar(String preferenceName) {
        this();
        this.prefName = preferenceName;
        load();
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJar
    public void addCookie(Cookie c) {
        AndroidCookie cookie = (AndroidCookie) c;
        this.m_Store.addCookie(cookie);
    }

    @Override // com.vlingo.sdk.internal.http.cookies.CookieJar
    public void mergeCookies(CookieJar srcJar) {
        if (srcJar != null) {
            List<org.apache.http.cookie.Cookie> l = ((AndroidCookieJar) srcJar).m_Store.getCookies();
            org.apache.http.cookie.Cookie[] a = new org.apache.http.cookie.Cookie[l.size()];
            l.toArray(a);
            this.m_Store.addCookies(a);
        }
    }

    public List<Cookie> getCookies() {
        Iterator<org.apache.http.cookie.Cookie> i = this.m_Store.getCookies().iterator();
        List<Cookie> cList = new LinkedList<>();
        while (i.hasNext()) {
            AndroidCookie c = (AndroidCookie) i.next();
            cList.add(c);
        }
        return cList;
    }

    public void removeCookie(String name) {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    public Cookie getCookieByName(String name) {
        Iterator<org.apache.http.cookie.Cookie> i = this.m_Store.getCookies().iterator();
        while (i.hasNext()) {
            AndroidCookie c = (AndroidCookie) i.next();
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public Enumeration<?> keys() {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    public void addCookiesToHttpRequest(HttpConnection conn) throws IOException {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    public void saveCookiesFromHttpResponse(HttpConnection conn) {
        throw new UnsupportedOperationException("??? Is this really an un-used method ???");
    }

    public boolean clearExpired() {
        return this.m_Store.clearExpired(new Date());
    }

    private void load() {
        if (this.prefName == null) {
            throw new IllegalStateException("Can't call load() on non-persistant AndroidCookieJar");
        }
        String cookiesString = Settings.getPersistentString(this.prefName, null);
        log.debug("loading: " + cookiesString);
        if (cookiesString != null && cookiesString.length() > 0) {
            String[] cookies = StringUtils.split(cookiesString, '|');
            for (String str : cookies) {
                try {
                    AndroidCookie c = AndroidCookie.deserialize(str);
                    addCookie(c);
                } catch (Exception e) {
                }
            }
            clearExpired();
        }
    }

    public void save() {
        if (this.prefName == null) {
            throw new IllegalStateException("Can't call save() on non-persistant AndroidCookieJar");
        }
        Iterator<org.apache.http.cookie.Cookie> i = this.m_Store.getCookies().iterator();
        StringBuffer sb = new StringBuffer();
        while (i.hasNext()) {
            AndroidCookie c = (AndroidCookie) i.next();
            sb.append(c.serialize());
            sb.append('|');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        log.debug("saving: " + sb.toString());
        Settings.setPersistentString(this.prefName, sb.toString());
    }
}
