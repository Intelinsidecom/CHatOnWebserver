package com.sec.chaton.util;

import com.sec.chaton.p027e.EnumC1450r;

/* compiled from: ProfileImageLoader.java */
/* renamed from: com.sec.chaton.util.bz */
/* loaded from: classes.dex */
class C3211bz {

    /* renamed from: a */
    final /* synthetic */ C3205bt f11590a;

    /* renamed from: b */
    private String f11591b;

    /* renamed from: c */
    private int f11592c;

    /* renamed from: d */
    private EnumC1450r f11593d;

    /* renamed from: e */
    private String f11594e;

    public C3211bz(C3205bt c3205bt, String str, int i) {
        this.f11590a = c3205bt;
        this.f11591b = str;
        this.f11592c = i;
        this.f11593d = EnumC1450r.UNKNOWN;
        this.f11594e = "";
    }

    public C3211bz(C3205bt c3205bt, String str, String str2, int i, EnumC1450r enumC1450r) {
        this.f11590a = c3205bt;
        this.f11591b = str;
        this.f11592c = i;
        this.f11593d = enumC1450r;
        this.f11594e = str2;
    }

    /* renamed from: a */
    public String m11240a() {
        return this.f11591b;
    }

    /* renamed from: b */
    public int m11241b() {
        return this.f11592c;
    }

    /* renamed from: c */
    public EnumC1450r m11242c() {
        return this.f11593d;
    }

    /* renamed from: d */
    public String m11243d() {
        return this.f11594e != null ? this.f11594e : "";
    }
}
