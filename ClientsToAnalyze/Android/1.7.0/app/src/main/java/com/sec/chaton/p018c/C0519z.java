package com.sec.chaton.p018c;

import com.sec.chaton.util.EnumC1333h;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: HttpEnvelope.java */
/* renamed from: com.sec.chaton.c.z */
/* loaded from: classes.dex */
public class C0519z {

    /* renamed from: a */
    protected String f1688a;

    /* renamed from: b */
    protected EnumC1333h f1689b;

    /* renamed from: e */
    protected Class f1692e;

    /* renamed from: f */
    protected int f1693f;

    /* renamed from: g */
    protected String f1694g;

    /* renamed from: k */
    protected Class f1698k;

    /* renamed from: c */
    protected EnumC0511r f1690c = EnumC0511r.GET;

    /* renamed from: d */
    protected List f1691d = new ArrayList();

    /* renamed from: h */
    protected List f1695h = new ArrayList();

    /* renamed from: j */
    protected int f1697j = -1;

    /* renamed from: i */
    protected boolean f1696i = true;

    public C0519z(EnumC1333h enumC1333h, String str) {
        this.f1689b = enumC1333h;
        this.f1688a = str;
    }

    /* renamed from: a */
    public C0519z m2581a(EnumC0511r enumC0511r) {
        this.f1690c = enumC0511r;
        return this;
    }

    /* renamed from: a */
    public C0519z m2584a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f1691d.add(new BasicNameValuePair(str, str2));
        }
        return this;
    }

    /* renamed from: b */
    public C0519z m2587b(String str, String str2) {
        if (str != null && str2 != null) {
            this.f1695h.add(new BasicNameValuePair(str, str2));
        }
        return this;
    }

    /* renamed from: a */
    public C0519z m2582a(Class cls) {
        this.f1692e = cls;
        return this;
    }

    /* renamed from: a */
    public C0519z m2580a(int i) {
        this.f1693f = i;
        return this;
    }

    /* renamed from: a */
    public C0519z m2583a(String str) {
        this.f1694g = str;
        return this;
    }

    /* renamed from: a */
    public C0503j m2579a() {
        return new C0503j(this);
    }

    /* renamed from: b */
    public C0519z m2586b(Class cls) {
        this.f1698k = cls;
        return this;
    }

    /* renamed from: b */
    public C0519z m2585b(int i) {
        this.f1697j = i;
        return this;
    }
}
