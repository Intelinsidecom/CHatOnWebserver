package p021c.p022a;

import p021c.C0351j;
import p021c.p023b.p024a.C0338b;
import p021c.p023b.p024a.C0339c;

/* compiled from: AccessToken.java */
/* renamed from: c.a.a */
/* loaded from: classes.dex */
public class C0326a extends AbstractC0331f {

    /* renamed from: c */
    private String f715c;

    /* renamed from: d */
    private long f716d;

    /* renamed from: e */
    private String f717e;

    @Override // p021c.p022a.AbstractC0331f
    /* renamed from: a */
    public /* bridge */ /* synthetic */ String mo1120a(String str) {
        return super.mo1120a(str);
    }

    @Override // p021c.p022a.AbstractC0331f
    /* renamed from: c */
    public /* bridge */ /* synthetic */ String mo1122c() {
        return super.mo1122c();
    }

    @Override // p021c.p022a.AbstractC0331f
    /* renamed from: d */
    public /* bridge */ /* synthetic */ String mo1123d() {
        return super.mo1123d();
    }

    @Override // p021c.p022a.AbstractC0331f
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // p021c.p022a.AbstractC0331f
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // p021c.p022a.AbstractC0331f
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    C0326a(C0334i c0334i) {
        this(c0334i.m1174b());
    }

    C0326a(C0339c c0339c) throws C0351j {
        try {
            this.f717e = c0339c.m1202h("access_token");
        } catch (C0338b e) {
            throw new C0351j(e.getMessage() + ":", e);
        }
    }

    C0326a(String str) {
        super(str);
        this.f715c = mo1120a("screen_name");
        String strMo1120a = mo1120a("user_id");
        if (strMo1120a != null) {
            this.f716d = Long.parseLong(strMo1120a);
        }
    }

    public C0326a(String str, String str2) {
        super(str, str2);
    }

    /* renamed from: a */
    public long m1119a() {
        return this.f716d;
    }

    /* renamed from: b */
    public String m1121b() {
        return this.f717e;
    }
}
