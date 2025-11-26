package p010b.p014d.p016b;

import p010b.InterfaceC0281c;
import p010b.p013c.InterfaceC0282a;
import p010b.p014d.p015a.AbstractC0297l;

/* compiled from: z_T4JInternalJSONImplFactory.java */
/* renamed from: b.d.b.c */
/* loaded from: classes.dex */
public class C0305c implements InterfaceC0304b {

    /* renamed from: a */
    private InterfaceC0282a f686a;

    /* renamed from: a */
    public static InterfaceC0281c m1032a(AbstractC0297l abstractC0297l) {
        return C0303a.m1031a(abstractC0297l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0305c)) {
            return false;
        }
        C0305c c0305c = (C0305c) obj;
        if (this.f686a != null) {
            if (this.f686a.equals(c0305c.f686a)) {
                return true;
            }
        } else if (c0305c.f686a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (this.f686a != null) {
            return this.f686a.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "JSONImplFactory{conf=" + this.f686a + '}';
    }
}
