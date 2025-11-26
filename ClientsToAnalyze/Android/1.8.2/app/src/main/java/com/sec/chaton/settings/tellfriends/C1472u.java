package com.sec.chaton.settings.tellfriends;

import weibo4android.Weibo;
import weibo4android.http.AccessToken;
import weibo4android.http.RequestToken;

/* compiled from: OAuthConstant.java */
/* renamed from: com.sec.chaton.settings.tellfriends.u */
/* loaded from: classes.dex */
public class C1472u {

    /* renamed from: a */
    private static Weibo f5387a = null;

    /* renamed from: b */
    private static C1472u f5388b = null;

    /* renamed from: c */
    private RequestToken f5389c;

    /* renamed from: d */
    private AccessToken f5390d;

    /* renamed from: e */
    private String f5391e;

    /* renamed from: f */
    private String f5392f;

    private C1472u() {
    }

    /* renamed from: a */
    public static synchronized C1472u m5199a() {
        if (f5388b == null) {
            f5388b = new C1472u();
        }
        return f5388b;
    }

    /* renamed from: b */
    public Weibo m5203b() {
        if (f5387a == null) {
            f5387a = new Weibo();
        }
        return f5387a;
    }

    /* renamed from: a */
    public void m5200a(Weibo weibo) {
        f5387a = weibo;
    }

    /* renamed from: a */
    public void m5201a(AccessToken accessToken) {
        this.f5390d = accessToken;
        this.f5391e = accessToken.getToken();
        this.f5392f = accessToken.getTokenSecret();
    }

    /* renamed from: c */
    public RequestToken m5204c() {
        return this.f5389c;
    }

    /* renamed from: a */
    public void m5202a(RequestToken requestToken) {
        this.f5389c = requestToken;
    }
}
