package p010b.p012b;

import java.io.Serializable;
import p010b.p014d.p015a.C0286a;
import p010b.p014d.p015a.C0296k;

/* compiled from: BasicAuthorization.java */
/* renamed from: b.b.d */
/* loaded from: classes.dex */
public class C0275d implements InterfaceC0273b, Serializable {

    /* renamed from: a */
    private String f615a;

    /* renamed from: b */
    private String f616b;

    /* renamed from: c */
    private String f617c = m957a();

    public C0275d(String str, String str2) {
        this.f615a = str;
        this.f616b = str2;
    }

    /* renamed from: a */
    private String m957a() {
        if (this.f615a == null || this.f616b == null) {
            return null;
        }
        return "Basic " + C0286a.m991a((this.f615a + ":" + this.f616b).getBytes());
    }

    @Override // p010b.p012b.InterfaceC0273b
    /* renamed from: a */
    public String mo955a(C0296k c0296k) {
        return this.f617c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0275d) {
            return this.f617c.equals(((C0275d) obj).f617c);
        }
        return false;
    }

    public int hashCode() {
        return this.f617c.hashCode();
    }

    public String toString() {
        return "BasicAuthorization{userId='" + this.f615a + "', password='**********''}";
    }
}
