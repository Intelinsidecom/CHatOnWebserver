package com.sec.chaton.p067j;

import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.j.ap */
/* loaded from: classes.dex */
public class C2427ap {

    /* renamed from: a */
    protected String f8642a = null;

    /* renamed from: b */
    protected int f8643b = -1;

    /* renamed from: c */
    protected GeneratedMessageLite f8644c = null;

    /* renamed from: d */
    protected long f8645d = -1;

    /* renamed from: e */
    protected C2466q f8646e = null;

    /* renamed from: f */
    protected long f8647f;

    /* renamed from: g */
    protected long f8648g;

    public C2427ap() {
        m10516a();
    }

    /* renamed from: a */
    public C2427ap m10521a(String str) {
        this.f8642a = str;
        return this;
    }

    /* renamed from: a */
    public C2427ap m10517a(int i) {
        this.f8643b = i;
        return this;
    }

    /* renamed from: a */
    public C2427ap m10519a(GeneratedMessageLite generatedMessageLite) {
        this.f8644c = generatedMessageLite;
        return this;
    }

    /* renamed from: a */
    public C2427ap m10520a(C2466q c2466q) {
        this.f8646e = c2466q;
        return this;
    }

    /* renamed from: a */
    public C2427ap m10518a(long j) {
        this.f8647f = SystemClock.elapsedRealtime();
        this.f8648g = j;
        return this;
    }

    /* renamed from: a */
    public C2427ap m10516a() {
        this.f8647f = SystemClock.elapsedRealtime();
        this.f8648g = Long.MAX_VALUE;
        return this;
    }

    /* renamed from: b */
    public C2426ao m10522b() {
        return new C2426ao(this);
    }
}
