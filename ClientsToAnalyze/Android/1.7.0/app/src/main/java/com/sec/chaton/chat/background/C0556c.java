package com.sec.chaton.chat.background;

import java.util.ArrayList;

/* compiled from: Request.java */
/* renamed from: com.sec.chaton.chat.background.c */
/* loaded from: classes.dex */
public class C0556c {

    /* renamed from: a */
    protected String f1918a;

    /* renamed from: b */
    protected long f1919b;

    /* renamed from: c */
    protected ArrayList f1920c;

    /* renamed from: d */
    protected EnumC0561h f1921d;

    /* renamed from: e */
    protected String f1922e;

    /* renamed from: f */
    protected String f1923f;

    /* renamed from: g */
    protected int f1924g;

    /* renamed from: h */
    protected int f1925h;

    /* renamed from: j */
    protected String f1927j;

    /* renamed from: l */
    protected String f1929l;

    /* renamed from: i */
    protected long f1926i = -1;

    /* renamed from: k */
    protected long f1928k = -1;

    /* renamed from: a */
    public C0556c m2733a(String str) {
        this.f1918a = str;
        return this;
    }

    /* renamed from: a */
    public C0556c m2732a(long j) {
        this.f1919b = j;
        return this;
    }

    /* renamed from: a */
    public C0556c m2734a(String[] strArr) {
        if (this.f1920c == null) {
            this.f1920c = new ArrayList();
        } else if (this.f1920c.size() > 0) {
            this.f1920c.clear();
        }
        for (String str : strArr) {
            this.f1920c.add(str);
        }
        return this;
    }

    /* renamed from: a */
    public C0556c m2731a(int i) {
        this.f1924g = i;
        return this;
    }

    /* renamed from: b */
    public C0556c m2736b(int i) {
        this.f1925h = i;
        return this;
    }

    /* renamed from: b */
    public C0556c m2738b(String str) {
        this.f1922e = str;
        return this;
    }

    /* renamed from: c */
    public C0556c m2740c(String str) {
        this.f1923f = str;
        return this;
    }

    /* renamed from: b */
    public C0556c m2737b(long j) {
        this.f1926i = j;
        return this;
    }

    /* renamed from: c */
    public C0556c m2739c(long j) {
        this.f1928k = j;
        return this;
    }

    /* renamed from: d */
    public C0556c m2741d(String str) {
        this.f1927j = str;
        return this;
    }

    /* renamed from: e */
    public C0556c m2742e(String str) {
        this.f1929l = str;
        return this;
    }

    /* renamed from: a */
    public C0558e m2735a() {
        return new C0558e(this);
    }
}
