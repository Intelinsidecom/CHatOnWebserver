package p010b.p014d.p016b;

import java.io.Serializable;
import p010b.InterfaceC0281c;
import p010b.p014d.p015a.AbstractC0297l;

/* compiled from: RateLimitStatusJSONImpl.java */
/* renamed from: b.d.b.a */
/* loaded from: classes.dex */
final class C0303a implements InterfaceC0281c, Serializable {

    /* renamed from: a */
    private int f682a;

    /* renamed from: b */
    private int f683b;

    /* renamed from: c */
    private int f684c;

    /* renamed from: d */
    private int f685d;

    private C0303a(int i, int i2, int i3) {
        this.f683b = i;
        this.f682a = i2;
        this.f684c = i3;
        this.f685d = (int) (((i3 * 1000) - System.currentTimeMillis()) / 1000);
    }

    /* renamed from: a */
    static InterfaceC0281c m1031a(AbstractC0297l abstractC0297l) throws NumberFormatException {
        String strMo1026a;
        if (abstractC0297l == null || (strMo1026a = abstractC0297l.mo1026a("X-Rate-Limit-Limit")) == null) {
            return null;
        }
        int i = Integer.parseInt(strMo1026a);
        String strMo1026a2 = abstractC0297l.mo1026a("X-Rate-Limit-Remaining");
        if (strMo1026a2 == null) {
            return null;
        }
        int i2 = Integer.parseInt(strMo1026a2);
        String strMo1026a3 = abstractC0297l.mo1026a("X-Rate-Limit-Reset");
        if (strMo1026a3 != null) {
            return new C0303a(i, i2, (int) Long.parseLong(strMo1026a3));
        }
        return null;
    }

    @Override // p010b.InterfaceC0281c
    /* renamed from: a */
    public int mo976a() {
        return this.f685d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0303a c0303a = (C0303a) obj;
        return this.f683b == c0303a.f683b && this.f682a == c0303a.f682a && this.f684c == c0303a.f684c && this.f685d == c0303a.f685d;
    }

    public int hashCode() {
        return (((((this.f682a * 31) + this.f683b) * 31) + this.f684c) * 31) + this.f685d;
    }

    public String toString() {
        return "RateLimitStatusJSONImpl{remaining=" + this.f682a + ", limit=" + this.f683b + ", resetTimeInSeconds=" + this.f684c + ", secondsUntilReset=" + this.f685d + '}';
    }
}
