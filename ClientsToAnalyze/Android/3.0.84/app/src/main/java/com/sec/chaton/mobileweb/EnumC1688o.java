package com.sec.chaton.mobileweb;

import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MobileWebApi.java */
/* renamed from: com.sec.chaton.mobileweb.o */
/* loaded from: classes.dex */
public enum EnumC1688o {
    HANDSHAKE_V1(101, "handshake", "v1"),
    HANDSHAKE_V2(102, "handshake", "v2"),
    PROXY_V2(202, "proxy", "v2"),
    GOPAGE_V1(301, "gopage", "v1"),
    GOPAGE_V2(HttpResponseCode.FOUND, "gopage", "v2"),
    SHARE_V2(402, "share", "v2"),
    BADGECLEAR_V1(501, "badgeclear", "v1");


    /* renamed from: h */
    private int f6211h;

    /* renamed from: i */
    private String f6212i;

    /* renamed from: j */
    private String f6213j;

    /* renamed from: a */
    public static EnumC1688o m6977a(int i) {
        switch (i) {
            case 101:
                return HANDSHAKE_V1;
            case 102:
                return HANDSHAKE_V2;
            case 202:
                return PROXY_V2;
            case 301:
                return GOPAGE_V1;
            case HttpResponseCode.FOUND /* 302 */:
                return GOPAGE_V2;
            case 402:
                return SHARE_V2;
            case 501:
                return BADGECLEAR_V1;
            default:
                return null;
        }
    }

    EnumC1688o(int i, String str, String str2) {
        this.f6211h = i;
        this.f6212i = str;
        this.f6213j = str2;
    }

    /* renamed from: a */
    public int m6978a() {
        return this.f6211h;
    }

    /* renamed from: b */
    public String m6979b() {
        return this.f6212i;
    }

    /* renamed from: c */
    public String m6980c() {
        return this.f6213j;
    }

    /* renamed from: d */
    public String m6981d() {
        return m6979b() + "_" + m6980c();
    }
}
