package com.sec.chaton.p067j;

import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.j.ao */
/* loaded from: classes.dex */
public class C2426ao {

    /* renamed from: h */
    private static AtomicInteger f8634h = null;

    /* renamed from: a */
    protected String f8635a;

    /* renamed from: b */
    protected int f8636b;

    /* renamed from: c */
    protected GeneratedMessageLite f8637c;

    /* renamed from: d */
    protected long f8638d;

    /* renamed from: e */
    protected C2466q f8639e;

    /* renamed from: f */
    protected long f8640f;

    /* renamed from: g */
    protected long f8641g;

    protected C2426ao(C2427ap c2427ap) {
        this.f8635a = null;
        this.f8636b = -1;
        this.f8637c = null;
        this.f8638d = -1L;
        this.f8639e = null;
        this.f8635a = c2427ap.f8642a;
        if (this.f8635a == null) {
            this.f8635a = C4809aa.m18104a().m18121a("uid", "");
        }
        this.f8636b = c2427ap.f8643b;
        this.f8637c = c2427ap.f8644c;
        this.f8638d = C2460k.m10654a(this.f8636b, this.f8637c);
        if (!C2460k.m10657a(this.f8637c)) {
            C4904y.m18634a("[LOG_MODE message] GPB Required field is not assigned in MessageMicro: uid=" + this.f8635a + ", type=" + this.f8636b + ", msgId=" + this.f8638d, "");
        }
        this.f8639e = c2427ap.f8646e;
        this.f8640f = c2427ap.f8647f;
        this.f8641g = c2427ap.f8648g;
    }

    /* renamed from: a */
    public String m10507a() {
        return this.f8635a;
    }

    /* renamed from: b */
    public int m10512b() {
        return this.f8636b;
    }

    /* renamed from: c */
    public GeneratedMessageLite m10513c() {
        return this.f8637c;
    }

    /* renamed from: d */
    public long m10514d() {
        return this.f8638d;
    }

    /* renamed from: e */
    public C2466q m10515e() {
        return this.f8639e;
    }

    /* renamed from: a */
    public void m10509a(C2466q c2466q) {
        this.f8639e = c2466q;
    }

    /* renamed from: a */
    public void m10510a(Object obj, Object obj2) {
        if (this.f8639e != null) {
            this.f8639e.m10673a(1, obj, obj2);
        }
    }

    /* renamed from: a */
    public void m10508a(int i, Object obj) {
        if (this.f8639e != null) {
            this.f8639e.m10672a(i, obj);
        }
    }

    /* renamed from: a */
    public boolean m10511a(long j) {
        return this.f8641g < j - this.f8640f;
    }

    /* renamed from: f */
    public static synchronized void m10506f() {
        if (f8634h == null) {
            f8634h = new AtomicInteger(0);
        }
        f8634h.set(0);
    }
}
