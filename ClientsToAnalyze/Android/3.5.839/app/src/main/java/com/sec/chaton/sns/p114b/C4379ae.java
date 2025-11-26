package com.sec.chaton.sns.p114b;

/* compiled from: SnsHelper.java */
/* renamed from: com.sec.chaton.sns.b.ae */
/* loaded from: classes.dex */
public class C4379ae {

    /* renamed from: a */
    private String f15851a;

    /* renamed from: b */
    private String f15852b;

    /* renamed from: c */
    private String f15853c;

    /* renamed from: d */
    private String f15854d;

    /* renamed from: e */
    private String f15855e;

    /* renamed from: f */
    private boolean f15856f;

    public C4379ae(String str, String str2, String str3, boolean z) {
        this.f15855e = null;
        this.f15851a = str;
        this.f15852b = str2;
        this.f15854d = str3;
        this.f15856f = z;
    }

    public C4379ae(String str, String str2, String str3, String str4) {
        this.f15855e = null;
        this.f15851a = str;
        this.f15852b = str2;
        this.f15853c = str3;
        this.f15854d = str4;
        this.f15856f = false;
    }

    /* renamed from: a */
    public String m16625a() {
        return this.f15851a;
    }

    /* renamed from: b */
    public String m16627b() {
        return this.f15853c;
    }

    /* renamed from: c */
    public String m16628c() {
        return this.f15854d;
    }

    /* renamed from: d */
    public String m16629d() {
        return this.f15855e;
    }

    /* renamed from: a */
    public void m16626a(String str) {
        this.f15855e = str;
    }

    /* renamed from: e */
    public boolean m16630e() {
        return this.f15856f;
    }

    /* renamed from: f */
    public String m16631f() {
        return this.f15852b;
    }

    public int hashCode() {
        int iHashCode = ((((this.f15851a.hashCode() + 1073) * 37) + this.f15852b.hashCode()) * 37) + this.f15854d.hashCode();
        if (this.f15855e != null) {
            return (iHashCode * 37) + this.f15855e.hashCode();
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C4379ae)) {
            return false;
        }
        C4379ae c4379ae = (C4379ae) obj;
        return c4379ae.f15851a == this.f15851a && c4379ae.f15852b == this.f15852b && c4379ae.f15854d == this.f15854d;
    }

    public String toString() {
        return "SnsFriend id=" + this.f15851a + ", name=" + this.f15852b + ", isUser=" + this.f15856f + ", imageUrl=" + this.f15854d;
    }
}
