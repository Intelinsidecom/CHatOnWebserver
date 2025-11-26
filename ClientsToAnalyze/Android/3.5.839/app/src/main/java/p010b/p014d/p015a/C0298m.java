package p010b.p014d.p015a;

import p010b.C0320g;

/* compiled from: HttpResponseEvent.java */
/* renamed from: b.d.a.m */
/* loaded from: classes.dex */
public final class C0298m {

    /* renamed from: a */
    private C0296k f671a;

    /* renamed from: b */
    private AbstractC0297l f672b;

    /* renamed from: c */
    private C0320g f673c;

    C0298m(C0296k c0296k, AbstractC0297l abstractC0297l, C0320g c0320g) {
        this.f671a = c0296k;
        this.f672b = abstractC0297l;
        this.f673c = c0320g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0298m c0298m = (C0298m) obj;
        if (this.f671a == null ? c0298m.f671a != null : !this.f671a.equals(c0298m.f671a)) {
            return false;
        }
        if (this.f672b != null) {
            if (this.f672b.equals(c0298m.f672b)) {
                return true;
            }
        } else if (c0298m.f672b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f671a != null ? this.f671a.hashCode() : 0) * 31) + (this.f672b != null ? this.f672b.hashCode() : 0);
    }

    public String toString() {
        return "HttpResponseEvent{request=" + this.f671a + ", response=" + this.f672b + '}';
    }
}
