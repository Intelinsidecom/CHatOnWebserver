package com.sec.chaton.msgsend;

import com.sec.chaton.p027e.EnumC1455w;

/* compiled from: BulkChatMsg.java */
/* renamed from: com.sec.chaton.msgsend.b */
/* loaded from: classes.dex */
public class C1742b {

    /* renamed from: a */
    long f6426a;

    /* renamed from: b */
    EnumC1455w f6427b;

    /* renamed from: c */
    String f6428c;

    public C1742b(long j, EnumC1455w enumC1455w, String str) {
        this.f6426a = j;
        this.f6427b = enumC1455w;
        this.f6428c = str;
    }

    /* renamed from: a */
    public String m7158a() {
        return this.f6428c;
    }

    /* renamed from: b */
    public EnumC1455w m7159b() {
        return this.f6427b;
    }

    /* renamed from: c */
    public long m7160c() {
        return this.f6426a;
    }

    public C1742b(C1742b c1742b) {
        this.f6426a = c1742b.m7160c();
        this.f6427b = c1742b.m7159b();
        this.f6428c = c1742b.m7158a();
    }

    /* renamed from: d */
    public C1742b m7161d() {
        return new C1742b(this);
    }
}
