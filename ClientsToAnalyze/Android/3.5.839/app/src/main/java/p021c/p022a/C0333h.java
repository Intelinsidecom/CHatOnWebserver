package p021c.p022a;

/* compiled from: RequestToken.java */
/* renamed from: c.a.h */
/* loaded from: classes.dex */
public class C0333h extends AbstractC0331f {

    /* renamed from: c */
    private C0328c f761c;

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
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    C0333h(C0334i c0334i, C0328c c0328c) {
        super(c0334i);
        this.f761c = c0328c;
    }

    /* renamed from: a */
    public String m1168a() {
        return this.f761c.m1147c() + "?oauth_token=" + mo1123d();
    }

    /* renamed from: b */
    public C0326a m1169b(String str) {
        return this.f761c.m1134a(this, str);
    }

    @Override // p021c.p022a.AbstractC0331f
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        C0333h c0333h = (C0333h) obj;
        if (this.f761c != null) {
            if (this.f761c.equals(c0333h.f761c)) {
                return true;
            }
        } else if (c0333h.f761c == null) {
            return true;
        }
        return false;
    }

    @Override // p021c.p022a.AbstractC0331f
    public int hashCode() {
        return (this.f761c != null ? this.f761c.hashCode() : 0) + (super.hashCode() * 31);
    }
}
