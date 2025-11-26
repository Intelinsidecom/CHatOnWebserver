package com.sec.chaton.p037j;

import com.sec.chaton.p035io.p036a.C1536a;
import com.sec.chaton.util.C3164af;
import com.sec.chaton.util.EnumC3219cg;
import com.sec.common.p066d.p067a.AbstractC3314a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HttpEnvelope.java */
/* renamed from: com.sec.chaton.j.j */
/* loaded from: classes.dex */
public class C1582j {

    /* renamed from: a */
    protected String f5872a;

    /* renamed from: b */
    protected EnumC3219cg f5873b;

    /* renamed from: e */
    protected Class<?> f5876e;

    /* renamed from: f */
    protected int f5877f;

    /* renamed from: c */
    protected EnumC1583k f5874c = EnumC1583k.GET;

    /* renamed from: d */
    protected Map<String, String> f5875d = new HashMap();

    /* renamed from: g */
    protected String f5878g = "text/xml";

    /* renamed from: h */
    protected Map<String, String> f5879h = new HashMap();

    /* renamed from: k */
    protected int f5882k = 30000;

    /* renamed from: l */
    protected Class<?> f5883l = C3164af.class;

    /* renamed from: m */
    protected AbstractC3314a f5884m = new C1536a();

    /* renamed from: i */
    protected boolean f5880i = true;

    /* renamed from: j */
    protected boolean f5881j = true;

    public C1582j(EnumC3219cg enumC3219cg, String str) {
        this.f5873b = enumC3219cg;
        this.f5872a = str;
    }

    /* renamed from: a */
    public C1582j m6710a(EnumC1583k enumC1583k) {
        this.f5874c = enumC1583k;
        return this;
    }

    /* renamed from: a */
    public C1582j m6714a(String str, String str2) {
        if (str != null && str2 != null) {
            this.f5875d.put(str, str2);
        }
        return this;
    }

    /* renamed from: b */
    public C1582j m6718b(String str, String str2) {
        if (str != null && str2 != null) {
            if ("Content-Type".equals(str)) {
                m6713a(str2);
            } else {
                this.f5879h.put(str, str2);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C1582j m6712a(Class<?> cls) {
        this.f5876e = cls;
        return this;
    }

    /* renamed from: a */
    public C1582j m6709a(int i) {
        this.f5877f = i;
        return this;
    }

    /* renamed from: a */
    public C1582j m6713a(String str) {
        this.f5878g = str;
        return this;
    }

    /* renamed from: a */
    public C1580h m6708a() {
        return new C1580h(this, null);
    }

    /* renamed from: b */
    public C1582j m6717b(Class<?> cls) {
        this.f5883l = cls;
        return this;
    }

    /* renamed from: a */
    public C1582j m6711a(AbstractC3314a abstractC3314a) {
        this.f5884m = abstractC3314a;
        return this;
    }

    /* renamed from: a */
    public C1582j m6715a(boolean z) {
        this.f5880i = z;
        return this;
    }

    /* renamed from: b */
    public C1582j m6719b(boolean z) {
        this.f5881j = z;
        return this;
    }

    /* renamed from: b */
    public C1582j m6716b(int i) {
        this.f5882k = i;
        return this;
    }
}
