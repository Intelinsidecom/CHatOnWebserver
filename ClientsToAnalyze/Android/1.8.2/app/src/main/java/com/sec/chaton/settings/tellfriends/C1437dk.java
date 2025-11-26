package com.sec.chaton.settings.tellfriends;

import android.graphics.drawable.Drawable;
import twitter4j.Twitter;

/* compiled from: TwitterUtil.java */
/* renamed from: com.sec.chaton.settings.tellfriends.dk */
/* loaded from: classes.dex */
public class C1437dk {

    /* renamed from: e */
    private static C1437dk f5321e;

    /* renamed from: a */
    public Twitter f5322a = null;

    /* renamed from: b */
    public Drawable f5323b = null;

    /* renamed from: c */
    public String f5324c = null;

    /* renamed from: d */
    public String f5325d = null;

    /* renamed from: a */
    public static C1437dk m5166a() {
        if (f5321e != null) {
            return f5321e;
        }
        f5321e = new C1437dk();
        return f5321e;
    }

    private C1437dk() {
    }

    /* renamed from: b */
    public String m5168b() {
        return this.f5324c;
    }

    /* renamed from: c */
    public String m5169c() {
        return this.f5325d;
    }

    /* renamed from: a */
    public void m5167a(Twitter twitter) {
        this.f5322a = twitter;
    }

    /* renamed from: d */
    public Twitter m5170d() {
        return this.f5322a;
    }

    /* renamed from: e */
    public void m5171e() {
        this.f5322a = null;
        this.f5324c = null;
        this.f5323b = null;
        this.f5325d = null;
    }
}
