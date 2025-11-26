package com.sec.chaton.settings.tellfriends;

/* compiled from: SnsHelper.java */
/* renamed from: com.sec.chaton.settings.tellfriends.ai */
/* loaded from: classes.dex */
public class C2732ai {

    /* renamed from: a */
    private String f10082a;

    /* renamed from: b */
    private String f10083b;

    /* renamed from: c */
    private String f10084c;

    /* renamed from: d */
    private String f10085d;

    /* renamed from: e */
    private String f10086e;

    /* renamed from: f */
    private boolean f10087f;

    public C2732ai(String str, String str2, String str3, boolean z) {
        this.f10086e = null;
        this.f10082a = str;
        this.f10083b = str2;
        this.f10085d = str3;
        this.f10087f = z;
    }

    public C2732ai(String str, String str2, String str3, String str4) {
        this.f10086e = null;
        this.f10082a = str;
        this.f10083b = str2;
        this.f10084c = str3;
        this.f10085d = str4;
        this.f10087f = false;
    }

    /* renamed from: a */
    public String m9783a() {
        return this.f10082a;
    }

    /* renamed from: b */
    public String m9785b() {
        return this.f10084c;
    }

    /* renamed from: c */
    public String m9786c() {
        return this.f10085d;
    }

    /* renamed from: d */
    public String m9787d() {
        return this.f10086e;
    }

    /* renamed from: a */
    public void m9784a(String str) {
        this.f10086e = str;
    }

    /* renamed from: e */
    public boolean m9788e() {
        return this.f10087f;
    }

    /* renamed from: f */
    public String m9789f() {
        return this.f10083b;
    }

    public int hashCode() {
        int iHashCode = ((((this.f10082a.hashCode() + 1073) * 37) + this.f10083b.hashCode()) * 37) + this.f10085d.hashCode();
        if (this.f10086e != null) {
            return (iHashCode * 37) + this.f10086e.hashCode();
        }
        return iHashCode;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C2732ai)) {
            return false;
        }
        C2732ai c2732ai = (C2732ai) obj;
        return c2732ai.f10082a == this.f10082a && c2732ai.f10083b == this.f10083b && c2732ai.f10085d == this.f10085d;
    }

    public String toString() {
        return "SnsFriend id=" + this.f10082a + ", name=" + this.f10083b + ", isUser=" + this.f10087f + ", imageUrl=" + this.f10085d;
    }
}
