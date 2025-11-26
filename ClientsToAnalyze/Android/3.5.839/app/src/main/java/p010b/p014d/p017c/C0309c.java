package p010b.p014d.p017c;

import java.util.Date;
import p010b.p013c.C0283b;

/* compiled from: StdOutLogger.java */
/* renamed from: b.d.c.c */
/* loaded from: classes.dex */
final class C0309c extends AbstractC0307a {

    /* renamed from: a */
    private static final boolean f689a = C0283b.m989a().m979c();

    C0309c() {
    }

    @Override // p010b.p014d.p017c.AbstractC0307a
    /* renamed from: a */
    public boolean mo1041a() {
        return f689a;
    }

    @Override // p010b.p014d.p017c.AbstractC0307a
    /* renamed from: a */
    public void mo1038a(String str) {
        if (f689a) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    @Override // p010b.p014d.p017c.AbstractC0307a
    /* renamed from: a */
    public void mo1039a(String str, String str2) {
        if (f689a) {
            mo1038a(str + str2);
        }
    }

    @Override // p010b.p014d.p017c.AbstractC0307a
    /* renamed from: a */
    public void mo1040a(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }
}
