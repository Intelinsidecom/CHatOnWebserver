package com.sec.chaton.p037j;

import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.j.ah */
/* loaded from: classes.dex */
public class C1549ah {

    /* renamed from: a */
    protected String f5695a = null;

    /* renamed from: b */
    protected int f5696b = -1;

    /* renamed from: c */
    protected GeneratedMessageLite f5697c = null;

    /* renamed from: d */
    protected long f5698d = -1;

    /* renamed from: e */
    protected C1589q f5699e = null;

    /* renamed from: f */
    protected long f5700f;

    /* renamed from: g */
    protected long f5701g;

    public C1549ah() {
        m6578a();
    }

    /* renamed from: a */
    public C1549ah m6583a(String str) {
        this.f5695a = str;
        return this;
    }

    /* renamed from: a */
    public C1549ah m6579a(int i) {
        this.f5696b = i;
        return this;
    }

    /* renamed from: a */
    public C1549ah m6581a(GeneratedMessageLite generatedMessageLite) {
        this.f5697c = generatedMessageLite;
        return this;
    }

    /* renamed from: a */
    public C1549ah m6582a(C1589q c1589q) {
        this.f5699e = c1589q;
        return this;
    }

    /* renamed from: a */
    public C1549ah m6580a(long j) {
        this.f5700f = SystemClock.elapsedRealtime();
        this.f5701g = j;
        return this;
    }

    /* renamed from: a */
    public C1549ah m6578a() {
        this.f5700f = SystemClock.elapsedRealtime();
        this.f5701g = Long.MAX_VALUE;
        return this;
    }

    /* renamed from: b */
    public C1548ag m6584b() {
        return new C1548ag(this);
    }
}
