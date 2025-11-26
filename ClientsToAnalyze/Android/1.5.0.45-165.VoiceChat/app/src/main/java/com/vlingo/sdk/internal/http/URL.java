package com.vlingo.sdk.internal.http;

import com.coolots.sso.util.ChatONVAPII;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class URL {
    private static final Logger log = Logger.getLogger(URL.class);
    public String host;
    private int index;
    public String path;
    public int port;
    public String url;
    public boolean useSSL;

    public URL(String url) {
        this.host = "";
        this.port = 80;
        this.path = "";
        this.useSSL = false;
        this.url = url;
        parseFromURL(url);
    }

    public URL(String host, int port, String path) {
        this.host = "";
        this.port = 80;
        this.path = "";
        this.useSSL = false;
        this.host = host;
        this.port = port;
        this.path = path;
        this.url = toString();
    }

    public void parseFromURL(String url) {
        if (url != null && url.length() > 5) {
            try {
                this.index = 0;
                this.useSSL = parseUseSSL(url);
                this.host = parseHostname(url);
                this.port = parsePort(url);
                this.path = parseFile(url);
            } catch (Exception e) {
                log.error("URL1", "Malformed URL: " + e.getMessage() + " url=" + url);
            }
        }
    }

    public int hashCode() {
        int hash = this.port * 3 * (this.useSSL ? 7 : 11);
        if (this.url != null) {
            hash = (hash * 89) + this.url.hashCode();
        }
        if (this.host != null) {
            hash = (hash * 89) + this.host.hashCode();
        }
        if (this.path != null) {
            return (hash * 89) + this.path.hashCode();
        }
        return hash;
    }

    public boolean equals(Object ob) {
        if (ob instanceof URL) {
            URL obURL = (URL) ob;
            return StringUtils.isEqual(this.url, obURL.url) && StringUtils.isEqual(this.host, obURL.host) && StringUtils.isEqual(this.path, obURL.path) && this.port == obURL.port && this.useSSL == obURL.useSSL;
        }
        return super.equals(ob);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.useSSL) {
            sb.append("https://");
        } else {
            sb.append("http://");
        }
        sb.append(this.host);
        sb.append(ChatONVAPII.USERID_DELEMETER);
        sb.append(this.port);
        sb.append(this.path);
        return sb.toString();
    }

    private boolean parseUseSSL(String url) {
        int n = url.indexOf(58);
        String token = url.substring(0, n);
        this.index = n + 1;
        return token.equals("https");
    }

    private String parseHostname(String url) {
        String buf = url.substring(this.index);
        if (buf.startsWith("//")) {
            buf = buf.substring(2);
            this.index += 2;
        }
        int n = buf.indexOf(58);
        if (n < 0) {
            n = buf.indexOf(47);
        }
        if (n < 0) {
            n = buf.length();
        }
        String token = buf.substring(0, n);
        this.index += n;
        return token;
    }

    private int parsePort(String url) throws NumberFormatException {
        int p = this.useSSL ? 443 : 80;
        String buf = url.substring(this.index);
        if (!buf.startsWith(ChatONVAPII.USERID_DELEMETER)) {
            return p;
        }
        String buf2 = buf.substring(1);
        this.index++;
        int n = buf2.indexOf(47);
        if (n < 0) {
            n = buf2.indexOf(63);
        }
        if (n < 0) {
            n = buf2.length();
        }
        try {
            int p2 = Integer.parseInt(buf2.substring(0, n));
            if (p2 <= 0) {
                throw new NumberFormatException();
            }
            this.index += n;
            return p2;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid port");
        }
    }

    private String parseFile(String url) {
        String buf = url.substring(this.index);
        if (buf.length() == 0) {
            return "";
        }
        int n = buf.indexOf(35);
        int m = buf.indexOf(63);
        if (n < 0 && m < 0) {
            n = buf.length();
        } else if (n < 0 || (m > 0 && m < n)) {
            n = m;
        }
        String token = buf.substring(0, n);
        this.index += n;
        return token;
    }

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getPort() {
        return this.port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return this.useSSL ? "https" : "http";
    }
}
