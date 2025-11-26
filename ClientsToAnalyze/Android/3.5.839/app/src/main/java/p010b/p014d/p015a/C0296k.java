package p010b.p014d.p015a;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import p010b.p012b.InterfaceC0273b;

/* compiled from: HttpRequest.java */
/* renamed from: b.d.a.k */
/* loaded from: classes.dex */
public final class C0296k implements Serializable {

    /* renamed from: f */
    private static final C0295j[] f657f = new C0295j[0];

    /* renamed from: a */
    private final EnumC0301p f658a;

    /* renamed from: b */
    private final String f659b;

    /* renamed from: c */
    private final C0295j[] f660c;

    /* renamed from: d */
    private final InterfaceC0273b f661d;

    /* renamed from: e */
    private Map<String, String> f662e;

    public C0296k(EnumC0301p enumC0301p, String str, C0295j[] c0295jArr, InterfaceC0273b interfaceC0273b, Map<String, String> map) {
        this.f658a = enumC0301p;
        if (enumC0301p != EnumC0301p.POST && c0295jArr != null && c0295jArr.length != 0) {
            this.f659b = str + "?" + C0295j.m1011b(c0295jArr);
            this.f660c = f657f;
        } else {
            this.f659b = str;
            this.f660c = c0295jArr;
        }
        this.f661d = interfaceC0273b;
        this.f662e = map;
    }

    /* renamed from: a */
    public EnumC0301p m1019a() {
        return this.f658a;
    }

    /* renamed from: b */
    public C0295j[] m1020b() {
        return this.f660c;
    }

    /* renamed from: c */
    public String m1021c() {
        return this.f659b;
    }

    /* renamed from: d */
    public InterfaceC0273b m1022d() {
        return this.f661d;
    }

    /* renamed from: e */
    public Map<String, String> m1023e() {
        return this.f662e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0296k c0296k = (C0296k) obj;
        if (this.f661d == null ? c0296k.f661d != null : !this.f661d.equals(c0296k.f661d)) {
            return false;
        }
        if (!Arrays.equals(this.f660c, c0296k.f660c)) {
            return false;
        }
        if (this.f662e == null ? c0296k.f662e != null : !this.f662e.equals(c0296k.f662e)) {
            return false;
        }
        if (this.f658a == null ? c0296k.f658a != null : !this.f658a.equals(c0296k.f658a)) {
            return false;
        }
        if (this.f659b != null) {
            if (this.f659b.equals(c0296k.f659b)) {
                return true;
            }
        } else if (c0296k.f659b == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f661d != null ? this.f661d.hashCode() : 0) + (((this.f660c != null ? Arrays.hashCode(this.f660c) : 0) + (((this.f659b != null ? this.f659b.hashCode() : 0) + ((this.f658a != null ? this.f658a.hashCode() : 0) * 31)) * 31)) * 31)) * 31) + (this.f662e != null ? this.f662e.hashCode() : 0);
    }

    public String toString() {
        return "HttpRequest{requestMethod=" + this.f658a + ", url='" + this.f659b + "', postParams=" + (this.f660c == null ? null : Arrays.asList(this.f660c)) + ", authentication=" + this.f661d + ", requestHeaders=" + this.f662e + '}';
    }
}
