package com.sec.google.android.p134a.p135a;

import java.io.ByteArrayOutputStream;

/* compiled from: PduComposer.java */
/* renamed from: com.sec.google.android.a.a.l */
/* loaded from: classes.dex */
class C5089l {

    /* renamed from: a */
    int f18540a;

    /* renamed from: b */
    final /* synthetic */ C5087j f18541b;

    /* renamed from: c */
    private C5090m f18542c;

    /* renamed from: d */
    private C5090m f18543d;

    private C5089l(C5087j c5087j) {
        this.f18541b = c5087j;
        this.f18542c = null;
        this.f18543d = null;
        this.f18540a = 0;
    }

    /* renamed from: a */
    void m19361a() {
        if (this.f18543d != null) {
            throw new RuntimeException("BUG: Invalid newbuf() before copy()");
        }
        C5090m c5090m = new C5090m();
        c5090m.f18544a = this.f18541b.f18534a;
        c5090m.f18545b = this.f18541b.f18535b;
        c5090m.f18546c = this.f18542c;
        this.f18542c = c5090m;
        this.f18540a++;
        this.f18541b.f18534a = new ByteArrayOutputStream();
        this.f18541b.f18535b = 0;
    }

    /* renamed from: b */
    void m19362b() {
        ByteArrayOutputStream byteArrayOutputStream = this.f18541b.f18534a;
        int i = this.f18541b.f18535b;
        this.f18541b.f18534a = this.f18542c.f18544a;
        this.f18541b.f18535b = this.f18542c.f18545b;
        this.f18543d = this.f18542c;
        this.f18542c = this.f18542c.f18546c;
        this.f18540a--;
        this.f18543d.f18544a = byteArrayOutputStream;
        this.f18543d.f18545b = i;
    }

    /* renamed from: c */
    void m19363c() {
        if (this.f18543d != null) {
            this.f18541b.m19351a(this.f18543d.f18544a.toByteArray(), 0, this.f18543d.f18545b);
        }
        this.f18543d = null;
    }

    /* renamed from: d */
    C5091n m19364d() {
        C5091n c5091n = new C5091n(this.f18541b);
        c5091n.f18548b = this.f18541b.f18535b;
        c5091n.f18549c = this.f18540a;
        return c5091n;
    }
}
