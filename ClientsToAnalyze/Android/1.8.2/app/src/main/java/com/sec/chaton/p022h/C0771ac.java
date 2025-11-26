package com.sec.chaton.p022h;

import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;

/* compiled from: TcpEnvelope.java */
/* renamed from: com.sec.chaton.h.ac */
/* loaded from: classes.dex */
public class C0771ac {

    /* renamed from: a */
    protected String f2812a = null;

    /* renamed from: b */
    protected int f2813b = -1;

    /* renamed from: c */
    protected GeneratedMessageLite f2814c = null;

    /* renamed from: d */
    protected long f2815d = -1;

    /* renamed from: e */
    protected C0805o f2816e = null;

    /* renamed from: f */
    protected long f2817f;

    /* renamed from: g */
    protected long f2818g;

    public C0771ac() {
        m3293a();
    }

    /* renamed from: a */
    public C0771ac m3298a(String str) {
        this.f2812a = str;
        return this;
    }

    /* renamed from: a */
    public C0771ac m3294a(int i) {
        this.f2813b = i;
        return this;
    }

    /* renamed from: a */
    public C0771ac m3296a(GeneratedMessageLite generatedMessageLite) {
        this.f2814c = generatedMessageLite;
        return this;
    }

    /* renamed from: a */
    public C0771ac m3297a(C0805o c0805o) {
        this.f2816e = c0805o;
        return this;
    }

    /* renamed from: a */
    public C0771ac m3295a(long j) {
        this.f2817f = SystemClock.elapsedRealtime();
        this.f2818g = j;
        return this;
    }

    /* renamed from: a */
    public C0771ac m3293a() {
        this.f2817f = SystemClock.elapsedRealtime();
        this.f2818g = Long.MAX_VALUE;
        return this;
    }

    /* renamed from: b */
    public C0770ab m3299b() {
        return new C0770ab(this);
    }
}
