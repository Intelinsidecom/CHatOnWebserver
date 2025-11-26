package com.sec.chaton.p018c;

import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.c.n */
/* loaded from: classes.dex */
public class C0507n {

    /* renamed from: a */
    protected String f1643a = null;

    /* renamed from: b */
    protected int f1644b = -1;

    /* renamed from: c */
    protected GeneratedMessageLite f1645c = null;

    /* renamed from: d */
    protected long f1646d = -1;

    /* renamed from: e */
    protected C0490c f1647e = null;

    /* renamed from: f */
    protected long f1648f;

    /* renamed from: g */
    protected long f1649g;

    public C0507n() {
        m2555a();
    }

    /* renamed from: a */
    public C0507n m2560a(String str) {
        this.f1643a = str;
        return this;
    }

    /* renamed from: a */
    public C0507n m2556a(int i) {
        this.f1644b = i;
        return this;
    }

    /* renamed from: a */
    public C0507n m2558a(GeneratedMessageLite generatedMessageLite) {
        this.f1645c = generatedMessageLite;
        return this;
    }

    /* renamed from: a */
    public C0507n m2559a(C0490c c0490c) {
        this.f1647e = c0490c;
        return this;
    }

    /* renamed from: a */
    public C0507n m2557a(long j) {
        this.f1648f = SystemClock.elapsedRealtime();
        this.f1649g = j;
        return this;
    }

    /* renamed from: a */
    public C0507n m2555a() {
        this.f1648f = SystemClock.elapsedRealtime();
        this.f1649g = Long.MAX_VALUE;
        return this;
    }

    /* renamed from: b */
    public C0510q m2561b() {
        return new C0510q(this);
    }
}
