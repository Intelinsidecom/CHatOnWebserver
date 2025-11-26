package com.sec.chaton.chat.background;

import com.sec.chaton.msgsend.EnumC2706n;
import java.util.ArrayList;

/* compiled from: Request.java */
/* renamed from: com.sec.chaton.chat.background.i */
/* loaded from: classes.dex */
public class C1590i {

    /* renamed from: a */
    protected String f6070a;

    /* renamed from: c */
    protected ArrayList<String> f6072c;

    /* renamed from: d */
    protected EnumC1591j f6073d;

    /* renamed from: e */
    protected String f6074e;

    /* renamed from: f */
    protected String f6075f;

    /* renamed from: g */
    protected int f6076g;

    /* renamed from: h */
    protected int f6077h;

    /* renamed from: j */
    protected String f6079j;

    /* renamed from: l */
    protected String f6081l;

    /* renamed from: m */
    protected String f6082m;

    /* renamed from: n */
    protected String f6083n;

    /* renamed from: o */
    protected String f6084o;

    /* renamed from: q */
    protected String f6086q;

    /* renamed from: r */
    protected int f6087r;

    /* renamed from: b */
    protected long f6071b = -1;

    /* renamed from: i */
    protected long f6078i = -1;

    /* renamed from: k */
    protected long f6080k = -1;

    /* renamed from: p */
    protected EnumC2706n f6085p = EnumC2706n.f9699d;

    /* renamed from: a */
    public C1590i m8472a(int i) {
        this.f6087r = i;
        return this;
    }

    /* renamed from: a */
    public C1590i m8475a(String str) {
        this.f6070a = str;
        return this;
    }

    /* renamed from: a */
    public C1590i m8473a(long j) {
        this.f6071b = j;
        return this;
    }

    /* renamed from: a */
    public C1590i m8476a(String[] strArr) {
        if (this.f6072c == null) {
            this.f6072c = new ArrayList<>();
        } else if (this.f6072c.size() > 0) {
            this.f6072c.clear();
        }
        if (strArr != null) {
            for (String str : strArr) {
                this.f6072c.add(str);
            }
        }
        return this;
    }

    /* renamed from: b */
    public C1590i m8477b(int i) {
        this.f6076g = i;
        return this;
    }

    /* renamed from: c */
    public C1590i m8480c(int i) {
        this.f6077h = i;
        return this;
    }

    /* renamed from: b */
    public C1590i m8479b(String str) {
        this.f6074e = str;
        return this;
    }

    /* renamed from: c */
    public C1590i m8482c(String str) {
        this.f6075f = str;
        return this;
    }

    /* renamed from: b */
    public C1590i m8478b(long j) {
        this.f6078i = j;
        return this;
    }

    /* renamed from: c */
    public C1590i m8481c(long j) {
        this.f6080k = j;
        return this;
    }

    /* renamed from: d */
    public C1590i m8483d(String str) {
        this.f6079j = str;
        return this;
    }

    /* renamed from: e */
    public C1590i m8484e(String str) {
        this.f6081l = str;
        return this;
    }

    /* renamed from: f */
    public C1590i m8485f(String str) {
        this.f6082m = str;
        return this;
    }

    /* renamed from: g */
    public C1590i m8486g(String str) {
        this.f6083n = str;
        return this;
    }

    /* renamed from: h */
    public C1590i m8487h(String str) {
        this.f6084o = str;
        return this;
    }

    /* renamed from: a */
    public C1590i m8474a(EnumC2706n enumC2706n) {
        this.f6085p = enumC2706n;
        return this;
    }

    /* renamed from: i */
    public C1590i m8488i(String str) {
        this.f6086q = str;
        return this;
    }

    /* renamed from: a */
    public C1589h mo8471a() {
        return new C1589h(this);
    }
}
