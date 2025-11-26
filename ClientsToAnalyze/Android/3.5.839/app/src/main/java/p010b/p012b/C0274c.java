package p010b.p012b;

import p010b.p013c.InterfaceC0282a;

/* compiled from: AuthorizationFactory.java */
/* renamed from: b.b.c */
/* loaded from: classes.dex */
public final class C0274c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [b.b.f] */
    /* renamed from: a */
    public static InterfaceC0273b m956a(InterfaceC0282a interfaceC0282a) {
        C0275d c0275d = null;
        c0275d = null;
        String strM982f = interfaceC0282a.m982f();
        String strM983g = interfaceC0282a.m983g();
        if (strM982f != null && strM983g != null) {
            ?? c0277f = new C0277f(interfaceC0282a);
            String strM984h = interfaceC0282a.m984h();
            String strM985i = interfaceC0282a.m985i();
            c0275d = c0277f;
            c0275d = c0277f;
            if (strM984h != null && strM985i != null) {
                c0277f.mo972a(new C0272a(strM984h, strM985i));
                c0275d = c0277f;
            }
        } else {
            String strM980d = interfaceC0282a.m980d();
            String strM981e = interfaceC0282a.m981e();
            if (strM980d != null && strM981e != null) {
                c0275d = new C0275d(strM980d, strM981e);
            }
        }
        if (c0275d == null) {
            return C0276e.m958a();
        }
        return c0275d;
    }
}
