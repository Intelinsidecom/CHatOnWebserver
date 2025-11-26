package com.vlingo.sdk.internal.http.cookies;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import java.util.Date;
import org.apache.http.impl.cookie.BasicClientCookie;

/* loaded from: classes.dex */
public class AndroidCookie extends BasicClientCookie implements Cookie {
    private static final int FIELD_COUNT = 5;
    private static final char FIELD_DELIMITER = ',';
    private static final int FIELD_INDEX_DOMAIN = 2;
    private static final int FIELD_INDEX_EXPIRES = 4;
    private static final int FIELD_INDEX_NAME = 0;
    private static final int FIELD_INDEX_PATH = 3;
    private static final int FIELD_INDEX_VALUE = 1;
    private static final Logger log = Logger.getLogger(AndroidCookie.class);

    public AndroidCookie(String name, String value) {
        super(name, value);
    }

    @Override // com.vlingo.sdk.internal.http.cookies.Cookie
    public long getExpires() {
        Date date = getExpiryDate();
        if (date == null) {
            return 0L;
        }
        return date.getTime();
    }

    @Override // com.vlingo.sdk.internal.http.cookies.Cookie
    public boolean isExpired() {
        return isExpired(new Date());
    }

    @Override // com.vlingo.sdk.internal.http.cookies.Cookie
    public boolean isMatch(String domain, String path) {
        boolean isMatch = true;
        if (getDomain() != null && getDomain().length() > 0) {
            isMatch = true & (domain != null && domain.equalsIgnoreCase(domain));
        }
        if (getPath() == null || getPath().length() <= 0) {
            return isMatch;
        }
        return isMatch & (path != null && path.startsWith(getPath()));
    }

    @Override // com.vlingo.sdk.internal.http.cookies.Cookie
    public void setExpires(long expires) {
        Date expiryDate = new Date(expires);
        setExpiryDate(expiryDate);
    }

    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append(FIELD_DELIMITER);
        sb.append(getValue());
        sb.append(FIELD_DELIMITER);
        if (getDomain() != null) {
            sb.append(getDomain());
        }
        sb.append(FIELD_DELIMITER);
        if (getPath() != null) {
            sb.append(getPath());
        }
        sb.append(FIELD_DELIMITER);
        if (getExpiryDate() != null) {
            sb.append(getExpires());
        }
        return sb.toString();
    }

    public static AndroidCookie deserialize(String data) throws Exception {
        log.debug("** deserialize(" + data + ")");
        String[] fields = StringUtils.split(data, FIELD_DELIMITER);
        if (fields.length != 5) {
            throw new Exception("Badly formatted cookie data");
        }
        AndroidCookie c = new AndroidCookie(fields[0], fields[1]);
        if (fields[2] != null && fields[2].length() > 0) {
            c.setDomain(fields[2]);
        }
        if (fields[3] != null && fields[3].length() > 0) {
            c.setPath(fields[3]);
        }
        if (fields[4] != null && fields[4].length() > 0) {
            c.setExpires(Long.parseLong(fields[4]));
        }
        return c;
    }

    @Override // org.apache.http.impl.cookie.BasicClientCookie
    public String toString() {
        return "AndroidCookie: expires=" + getExpires() + " isExpired=" + isExpired() + " domain=" + getDomain() + " path=" + getPath() + " name=" + getName() + " value=" + getValue() + " version=" + getVersion();
    }

    public boolean equals(Object o) {
        if (o instanceof AndroidCookie) {
            AndroidCookie ac = (AndroidCookie) o;
            return StringUtils.isEqual(getName(), ac.getName()) && StringUtils.isEqual(getValue(), ac.getValue()) && StringUtils.isEqual(getPath(), ac.getPath()) && StringUtils.isEqual(getDomain(), ac.getDomain());
        }
        return super.equals(o);
    }

    public int hashCode() {
        int hash = getName() != null ? 31 * getName().hashCode() : 31;
        if (getValue() != null) {
            hash *= getValue().hashCode();
        }
        if (getPath() != null) {
            hash *= getPath().hashCode();
        }
        if (getDomain() != null) {
            return hash * getDomain().hashCode();
        }
        return hash;
    }
}
