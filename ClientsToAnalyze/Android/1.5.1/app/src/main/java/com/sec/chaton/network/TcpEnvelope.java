package com.sec.chaton.network;

import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONPref;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class TcpEnvelope {

    /* renamed from: h */
    private static AtomicInteger f2484h = null;

    /* renamed from: a */
    protected String f2485a;

    /* renamed from: b */
    protected int f2486b;

    /* renamed from: c */
    protected GeneratedMessageLite f2487c;

    /* renamed from: d */
    protected long f2488d;

    /* renamed from: e */
    protected NetResultReceiver f2489e;

    /* renamed from: f */
    protected long f2490f;

    /* renamed from: g */
    protected long f2491g;

    public class Builder {

        /* renamed from: a */
        protected String f2492a = null;

        /* renamed from: b */
        protected int f2493b = -1;

        /* renamed from: c */
        protected GeneratedMessageLite f2494c = null;

        /* renamed from: d */
        protected long f2495d = -1;

        /* renamed from: e */
        protected NetResultReceiver f2496e = null;

        /* renamed from: f */
        protected long f2497f;

        /* renamed from: g */
        protected long f2498g;

        public Builder() {
            m2810a();
        }

        /* renamed from: a */
        public Builder m2810a() {
            this.f2497f = SystemClock.elapsedRealtime();
            this.f2498g = Long.MAX_VALUE;
            return this;
        }

        /* renamed from: a */
        public Builder m2811a(int i) {
            this.f2493b = i;
            return this;
        }

        /* renamed from: a */
        public Builder m2812a(long j) {
            this.f2497f = SystemClock.elapsedRealtime();
            this.f2498g = j;
            return this;
        }

        /* renamed from: a */
        public Builder m2813a(GeneratedMessageLite generatedMessageLite) {
            this.f2494c = generatedMessageLite;
            return this;
        }

        /* renamed from: a */
        public Builder m2814a(NetResultReceiver netResultReceiver) {
            this.f2496e = netResultReceiver;
            return this;
        }

        /* renamed from: a */
        public Builder m2815a(String str) {
            this.f2492a = str;
            return this;
        }

        /* renamed from: b */
        public TcpEnvelope m2816b() {
            return new TcpEnvelope(this);
        }
    }

    protected TcpEnvelope(Builder builder) {
        this.f2485a = null;
        this.f2486b = -1;
        this.f2487c = null;
        this.f2488d = -1L;
        this.f2489e = null;
        this.f2485a = builder.f2492a;
        if (this.f2485a == null) {
            this.f2485a = ChatONPref.m3519a().getString("uid", "");
        }
        this.f2486b = builder.f2493b;
        this.f2487c = builder.f2494c;
        this.f2488d = GpbTypeValue.m2724a(this.f2486b, this.f2487c);
        if (!GpbTypeValue.m2727a(this.f2487c)) {
            ChatONLogWriter.m3499a("[LOG_MODE message] GPB Required field is not assigned in MessageMicro: uid=" + this.f2485a + ", type=" + this.f2486b + ", msgId=" + this.f2488d, "");
        }
        this.f2489e = builder.f2496e;
        this.f2490f = builder.f2497f;
        this.f2491g = builder.f2498g;
    }

    /* renamed from: g */
    public static synchronized void m2799g() {
        if (f2484h == null) {
            f2484h = new AtomicInteger(0);
        }
        f2484h.set(0);
    }

    /* renamed from: a */
    public String m2800a() {
        return this.f2485a;
    }

    /* renamed from: a */
    public void m2801a(NetResultReceiver netResultReceiver) {
        this.f2489e = netResultReceiver;
    }

    /* renamed from: a */
    public void m2802a(Object obj) {
        if (this.f2489e == null) {
            return;
        }
        this.f2489e.m2748a(1, obj);
    }

    /* renamed from: a */
    public void m2803a(Object obj, Object obj2) {
        if (this.f2489e == null) {
            return;
        }
        this.f2489e.m2749a(1, obj, obj2);
    }

    /* renamed from: a */
    public boolean m2804a(long j) {
        return this.f2491g < j - this.f2490f;
    }

    /* renamed from: b */
    public int m2805b() {
        return this.f2486b;
    }

    /* renamed from: c */
    public GeneratedMessageLite m2806c() {
        return this.f2487c;
    }

    /* renamed from: d */
    public long m2807d() {
        return this.f2488d;
    }

    /* renamed from: e */
    public NetResultReceiver m2808e() {
        return this.f2489e;
    }

    /* renamed from: f */
    public boolean m2809f() {
        return m2804a(SystemClock.elapsedRealtime());
    }
}
