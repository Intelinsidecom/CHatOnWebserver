package com.vlingo.sdk.internal.http.cookies;

/* loaded from: classes.dex */
public interface Cookie {
    String getDomain();

    long getExpires();

    String getName();

    String getPath();

    String getValue();

    boolean isExpired();

    boolean isMatch(String str, String str2);

    void setDomain(String str);

    void setExpires(long j);

    void setPath(String str);

    void setValue(String str);
}
