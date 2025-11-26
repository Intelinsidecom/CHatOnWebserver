package com.vlingo.sdk.internal.http.cookies;

import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.internal.http.date.HttpDateParser;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.HttpConnection;
import com.vlingo.sdk.internal.recognizer.sr3.HttpConnectionAdapter;
import com.vlingo.sdk.internal.util.StringUtils;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class CookieHandler {
    private static final Logger log = Logger.getLogger(CookieHandler.class);

    private interface ConnectionWrapper {
        String getHeaderField(int i) throws IOException;

        String getHeaderFieldKey(int i) throws IOException;

        String getHost();
    }

    public static CookieJar extractCookies(HttpConnection conn) {
        return extractCookies(conn, (CookieJar) null);
    }

    public static CookieJar extractCookies(HttpConnectionAdapter conn) {
        return extractCookies(conn, (CookieJar) null);
    }

    public static CookieJar extractCookies(HttpURLConnection conn) {
        return extractCookies(conn, (CookieJar) null);
    }

    public static CookieJar extractCookies(HttpConnection conn, CookieJar cookieJar) {
        return extractCookies(new HttpConnectionWrapper(conn), cookieJar);
    }

    public static CookieJar extractCookies(HttpConnectionAdapter conn, CookieJar cookieJar) {
        return extractCookies(new HttpConnectionAdapterWrapper(conn), cookieJar);
    }

    public static CookieJar extractCookies(HttpURLConnection conn, CookieJar cookieJar) {
        return extractCookies(new HttpURLConnectionWrapper(conn), cookieJar);
    }

    private static class HttpConnectionWrapper implements ConnectionWrapper {
        private HttpConnection connection;

        public HttpConnectionWrapper(HttpConnection connection) {
            if (connection == null) {
                throw new IllegalArgumentException("you MUST provide a non-null 'connection'");
            }
            this.connection = connection;
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHost() {
            return this.connection.getHost();
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderFieldKey(int i) throws IOException {
            return this.connection.getHeaderFieldKey(i);
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderField(int i) throws IOException {
            return this.connection.getHeaderField(i);
        }
    }

    private static class HttpConnectionAdapterWrapper implements ConnectionWrapper {
        private HttpConnectionAdapter connection;

        public HttpConnectionAdapterWrapper(HttpConnectionAdapter connection) {
            if (connection == null) {
                throw new IllegalArgumentException("you MUST provide a non-null 'connection'");
            }
            this.connection = connection;
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHost() {
            return "";
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderFieldKey(int i) throws IOException {
            return this.connection.getResponseHeaderFieldKey(i);
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderField(int i) throws IOException {
            return this.connection.getResponseHeaderField(i);
        }
    }

    private static class HttpURLConnectionWrapper implements ConnectionWrapper {
        private HttpURLConnection connection;

        public HttpURLConnectionWrapper(HttpURLConnection connection) {
            if (connection == null) {
                throw new IllegalArgumentException("you MUST provide a non-null 'connection'");
            }
            this.connection = connection;
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHost() {
            return this.connection.getURL().getHost();
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderFieldKey(int i) {
            return this.connection.getHeaderFieldKey(i);
        }

        @Override // com.vlingo.sdk.internal.http.cookies.CookieHandler.ConnectionWrapper
        public String getHeaderField(int i) {
            return this.connection.getHeaderField(i);
        }
    }

    private static CookieJar extractCookies(ConnectionWrapper conn, CookieJar cookieJar) {
        log.debug("** extracting cookies");
        String domain = conn.getHost();
        log.debug("** domain: " + domain);
        int i = 0;
        while (true) {
            try {
                String key = conn.getHeaderFieldKey(i);
                if (key == null) {
                    break;
                }
                log.debug("** checking key: " + key + ": " + conn.getHeaderField(i));
                if (key.equalsIgnoreCase(HttpUtil.HEADER_SET_COOKIE)) {
                    log.debug("** got cookie");
                    String value = conn.getHeaderField(i);
                    log.debug("** value: " + value);
                    if (value != null) {
                        if (cookieJar == null) {
                            cookieJar = CookieJarFactory.newInstance();
                        }
                        parseSetCookieString(value, domain, cookieJar);
                    }
                }
                i++;
            } catch (Exception ex) {
                log.error("COK1", "Exception while extracting cookies: " + ex.toString());
                ex.printStackTrace();
            }
        }
        log.debug("** done extracting");
        return cookieJar;
    }

    public static void parseSetCookieString(String cookieString, String domain, CookieJar cookieJar) {
        log.debug("** parseSetCookieString cookie-string=" + cookieString + ", domain=" + domain + " jar=" + cookieJar);
        try {
            String[] cookies = StringUtils.split(cookieString, ',');
            int i = 0;
            while (i < cookies.length) {
                String cookie = cookies[i];
                if (cookie.indexOf("Expires=") != -1 || cookie.indexOf("expires=") != -1) {
                    i++;
                    cookie = String.valueOf(cookie) + "," + cookies[i];
                }
                int eqIndex = cookie.indexOf(61);
                int colonIndex = -1;
                Cookie c = null;
                if (eqIndex != -1) {
                    String cname = cookie.substring(0, eqIndex);
                    String cvalue = "";
                    if (cookie.length() > eqIndex + 1) {
                        colonIndex = cookie.indexOf(59, eqIndex + 1);
                        if (colonIndex != -1) {
                            cvalue = cookie.substring(eqIndex + 1, colonIndex);
                        } else {
                            cvalue = cookie.substring(eqIndex + 1);
                        }
                    }
                    c = CookieFactory.newInstance(cname.trim(), cvalue.trim());
                    c.setDomain(domain);
                    cookieJar.addCookie(c);
                }
                log.debug("** got cookie: " + cookie);
                if (colonIndex != -1 && cookie.length() > colonIndex + 1) {
                    String paramsStr = cookie.substring(colonIndex + 1);
                    String[] params = StringUtils.split(paramsStr, ';');
                    for (String str : params) {
                        String pv = str.trim();
                        int peqIndex = pv.indexOf("=");
                        String pname = pv.substring(0, peqIndex).trim();
                        String pvalue = pv.substring(peqIndex + 1).trim();
                        if (pvalue.startsWith("\"") && pvalue.endsWith("\"")) {
                            pvalue = pvalue.substring(1, pvalue.length() - 1);
                        }
                        if (c != null) {
                            if ("Domain".equalsIgnoreCase(pname)) {
                                c.setDomain(pvalue);
                            } else if ("Path".equalsIgnoreCase(pname)) {
                                c.setPath(pvalue);
                            } else if ("Expires".equalsIgnoreCase(pname)) {
                                long expires = 0;
                                try {
                                    expires = HttpDateParser.parse(pvalue);
                                } catch (Exception e) {
                                }
                                if (expires > 0 && (c.getExpires() == 0 || expires < c.getExpires())) {
                                    c.setExpires(expires);
                                }
                            } else if ("Max-Age".equalsIgnoreCase(pname)) {
                                long expires2 = 0;
                                try {
                                    expires2 = Long.parseLong(pvalue) * 1000;
                                } catch (Exception e2) {
                                }
                                if (expires2 > 0) {
                                    long expires3 = expires2 + System.currentTimeMillis();
                                    if (c.getExpires() == 0 || expires3 < c.getExpires()) {
                                        c.setExpires(expires3);
                                    }
                                }
                            }
                        }
                    }
                }
                log.debug("** parsed cookie: " + c.toString());
                i++;
            }
        } catch (Exception ex) {
            log.error("COK2", "Error parsing cookie: " + ex.toString());
            log.debug("Cookie string: " + cookieString);
            log.debug("Domain: " + domain);
            ex.printStackTrace();
        }
    }
}
