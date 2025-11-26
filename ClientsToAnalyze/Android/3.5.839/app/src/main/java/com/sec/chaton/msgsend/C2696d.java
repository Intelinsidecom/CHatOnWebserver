package com.sec.chaton.msgsend;

import com.sec.chaton.p057e.EnumC2214ab;

/* compiled from: BulkChatMsg.java */
/* renamed from: com.sec.chaton.msgsend.d */
/* loaded from: classes.dex */
public class C2696d {

    /* renamed from: a */
    long f9677a;

    /* renamed from: b */
    EnumC2214ab f9678b;

    /* renamed from: c */
    String f9679c;

    public C2696d(long j, EnumC2214ab enumC2214ab, String str) {
        this.f9677a = j;
        this.f9678b = enumC2214ab;
        this.f9679c = str;
    }

    /* renamed from: a */
    public String m11309a() {
        return this.f9679c;
    }

    /* renamed from: b */
    public EnumC2214ab m11310b() {
        return this.f9678b;
    }

    /* renamed from: c */
    public long m11311c() {
        return this.f9677a;
    }

    public C2696d(C2696d c2696d) {
        this.f9677a = c2696d.m11311c();
        this.f9678b = c2696d.m11310b();
        this.f9679c = c2696d.m11309a();
    }

    /* renamed from: d */
    public C2696d m11312d() {
        return new C2696d(this);
    }
}
