package com.sec.chaton.p037j;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3250y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.j.ag */
/* loaded from: classes.dex */
public class C1548ag {

    /* renamed from: h */
    private static AtomicInteger f5687h = null;

    /* renamed from: a */
    protected String f5688a;

    /* renamed from: b */
    protected int f5689b;

    /* renamed from: c */
    protected GeneratedMessageLite f5690c;

    /* renamed from: d */
    protected long f5691d;

    /* renamed from: e */
    protected C1589q f5692e;

    /* renamed from: f */
    protected long f5693f;

    /* renamed from: g */
    protected long f5694g;

    protected C1548ag(C1549ah c1549ah) {
        this.f5688a = null;
        this.f5689b = -1;
        this.f5690c = null;
        this.f5691d = -1L;
        this.f5692e = null;
        this.f5688a = c1549ah.f5695a;
        if (this.f5688a == null) {
            this.f5688a = C3159aa.m10962a().m10979a("uid", "");
        }
        this.f5689b = c1549ah.f5696b;
        this.f5690c = c1549ah.f5697c;
        this.f5691d = C1579g.m6692a(this.f5689b, this.f5690c);
        if (!C1579g.m6695a(this.f5690c)) {
            C3250y.m11442a("[LOG_MODE message] GPB Required field is not assigned in MessageMicro: uid=" + this.f5688a + ", type=" + this.f5689b + ", msgId=" + this.f5691d, "");
        }
        this.f5692e = c1549ah.f5699e;
        this.f5693f = c1549ah.f5700f;
        this.f5694g = c1549ah.f5701g;
    }

    /* renamed from: a */
    public String m6569a() {
        return this.f5688a;
    }

    /* renamed from: b */
    public int m6574b() {
        return this.f5689b;
    }

    /* renamed from: c */
    public GeneratedMessageLite m6575c() {
        return this.f5690c;
    }

    /* renamed from: d */
    public long m6576d() {
        return this.f5691d;
    }

    /* renamed from: e */
    public C1589q m6577e() {
        return this.f5692e;
    }

    /* renamed from: a */
    public void m6571a(C1589q c1589q) {
        this.f5692e = c1589q;
    }

    /* renamed from: a */
    public void m6572a(Object obj, Object obj2) {
        if (this.f5692e != null) {
            this.f5692e.m6729a(1, obj, obj2);
        }
    }

    /* renamed from: a */
    public void m6570a(int i, Object obj) {
        if (this.f5692e != null) {
            this.f5692e.m6728a(i, obj);
        }
    }

    /* renamed from: a */
    public boolean m6573a(long j) {
        return this.f5694g < j - this.f5693f;
    }

    /* renamed from: f */
    public static synchronized void m6568f() {
        if (f5687h == null) {
            f5687h = new AtomicInteger(0);
        }
        f5687h.set(0);
    }
}
