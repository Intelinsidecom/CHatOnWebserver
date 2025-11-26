package com.sec.chaton.chat.background;

import com.sec.chaton.msgsend.EnumC1751k;
import java.util.ArrayList;

/* compiled from: Request.java */
/* renamed from: com.sec.chaton.chat.background.i */
/* loaded from: classes.dex */
public class C0975i {

    /* renamed from: a */
    protected String f4015a;

    /* renamed from: c */
    protected ArrayList<String> f4017c;

    /* renamed from: d */
    protected EnumC0976j f4018d;

    /* renamed from: e */
    protected String f4019e;

    /* renamed from: f */
    protected String f4020f;

    /* renamed from: g */
    protected int f4021g;

    /* renamed from: h */
    protected int f4022h;

    /* renamed from: j */
    protected String f4024j;

    /* renamed from: l */
    protected String f4026l;

    /* renamed from: m */
    protected String f4027m;

    /* renamed from: n */
    protected String f4028n;

    /* renamed from: o */
    protected String f4029o;

    /* renamed from: q */
    protected String f4031q;

    /* renamed from: b */
    protected long f4016b = -1;

    /* renamed from: i */
    protected long f4023i = -1;

    /* renamed from: k */
    protected long f4025k = -1;

    /* renamed from: p */
    protected EnumC1751k f4030p = EnumC1751k.f6455d;

    /* renamed from: a */
    public C0975i m5223a(String str) {
        this.f4015a = str;
        return this;
    }

    /* renamed from: a */
    public C0975i m5221a(long j) {
        this.f4016b = j;
        return this;
    }

    /* renamed from: a */
    public C0975i m5224a(String[] strArr) {
        if (this.f4017c == null) {
            this.f4017c = new ArrayList<>();
        } else if (this.f4017c.size() > 0) {
            this.f4017c.clear();
        }
        if (strArr != null) {
            for (String str : strArr) {
                this.f4017c.add(str);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0975i m5220a(int i) {
        this.f4021g = i;
        return this;
    }

    /* renamed from: b */
    public C0975i m5225b(int i) {
        this.f4022h = i;
        return this;
    }

    /* renamed from: b */
    public C0975i m5227b(String str) {
        this.f4019e = str;
        return this;
    }

    /* renamed from: c */
    public C0975i m5229c(String str) {
        this.f4020f = str;
        return this;
    }

    /* renamed from: b */
    public C0975i m5226b(long j) {
        this.f4023i = j;
        return this;
    }

    /* renamed from: c */
    public C0975i m5228c(long j) {
        this.f4025k = j;
        return this;
    }

    /* renamed from: d */
    public C0975i m5230d(String str) {
        this.f4024j = str;
        return this;
    }

    /* renamed from: e */
    public C0975i m5231e(String str) {
        this.f4026l = str;
        return this;
    }

    /* renamed from: f */
    public C0975i m5232f(String str) {
        this.f4027m = str;
        return this;
    }

    /* renamed from: g */
    public C0975i m5233g(String str) {
        this.f4028n = str;
        return this;
    }

    /* renamed from: h */
    public C0975i m5234h(String str) {
        this.f4029o = str;
        return this;
    }

    /* renamed from: a */
    public C0975i m5222a(EnumC1751k enumC1751k) {
        this.f4030p = enumC1751k;
        return this;
    }

    /* renamed from: i */
    public C0975i m5235i(String str) {
        this.f4031q = str;
        return this;
    }

    /* renamed from: a */
    public C0974h mo5219a() {
        return new C0974h(this);
    }
}
