package com.sec.chaton.network;

import com.sec.chaton.util.AesCipher;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TcpContext {

    /* renamed from: a */
    static HashMap f2466a = new HashMap();

    /* renamed from: b */
    protected String f2467b;

    /* renamed from: c */
    protected String f2468c;

    /* renamed from: d */
    protected int f2469d;

    /* renamed from: e */
    protected AesCipher f2470e;

    /* renamed from: f */
    protected long f2471f;

    /* renamed from: g */
    TcpClient f2472g;

    /* renamed from: h */
    protected long f2473h;

    /* renamed from: i */
    public NetResultReceiver f2474i = null;

    /* renamed from: j */
    public NetResultReceiver f2475j = null;

    /* renamed from: k */
    public NetResultReceiver f2476k = null;

    /* renamed from: l */
    public NetResultReceiver f2477l = null;

    /* renamed from: m */
    public NetResultReceiver f2478m = null;

    public class Builder {

        /* renamed from: a */
        protected String f2479a = null;

        /* renamed from: b */
        protected String f2480b = null;

        /* renamed from: c */
        protected int f2481c = Integer.MIN_VALUE;

        /* renamed from: d */
        protected AesCipher f2482d = null;

        /* renamed from: e */
        protected long f2483e = Long.MAX_VALUE;

        /* renamed from: a */
        public Builder m2794a(int i) {
            this.f2481c = i;
            return this;
        }

        /* renamed from: a */
        public Builder m2795a(AesCipher aesCipher) {
            this.f2482d = aesCipher;
            return this;
        }

        /* renamed from: a */
        public Builder m2796a(String str) {
            this.f2479a = str;
            return this;
        }

        /* renamed from: a */
        public TcpContext m2797a() {
            return new TcpContext(this);
        }

        /* renamed from: b */
        public Builder m2798b(String str) {
            this.f2480b = str;
            return this;
        }
    }

    protected TcpContext(Builder builder) throws NoSuchFieldException {
        this.f2467b = null;
        this.f2468c = null;
        this.f2469d = Integer.MIN_VALUE;
        this.f2470e = null;
        this.f2471f = -2147483648L;
        this.f2472g = null;
        this.f2473h = 0L;
        if (builder.f2479a == null) {
            throw new NoSuchFieldException("No Context ID");
        }
        this.f2467b = builder.f2479a;
        if (builder.f2480b == null) {
            throw new NoSuchFieldException("No Domain");
        }
        if (builder.f2480b.length() == 0) {
            throw new NoSuchFieldException("No Domain actually. Domain length is 0");
        }
        this.f2468c = builder.f2480b;
        if (builder.f2481c == Integer.MIN_VALUE) {
            throw new NoSuchFieldException("No Port");
        }
        this.f2469d = builder.f2481c;
        this.f2470e = builder.f2482d;
        this.f2471f = builder.f2483e;
        this.f2473h = Long.MAX_VALUE;
        this.f2472g = m2779a(this);
    }

    /* renamed from: a */
    static synchronized int m2778a() {
        int i;
        int i2 = 0;
        Iterator it = new ArrayList(f2466a.values()).iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((TcpContext) it.next()).m2792h().m2776d();
                i2 = i + 1;
            }
        }
        return i;
    }

    /* renamed from: a */
    static synchronized TcpClient m2779a(TcpContext tcpContext) {
        TcpContext tcpContext2 = (TcpContext) f2466a.get(tcpContext.m2787c());
        if (tcpContext2 == null) {
            tcpContext.f2472g = new TcpClient(tcpContext);
            f2466a.put(tcpContext.m2787c(), tcpContext);
        } else {
            tcpContext2.f2468c = tcpContext.m2788d();
            tcpContext2.f2469d = tcpContext.m2789e();
            tcpContext2.f2470e = tcpContext.m2790f();
            tcpContext2.f2471f = tcpContext.m2791g();
            tcpContext2.f2473h = tcpContext.m2793i();
            tcpContext.f2472g = tcpContext2.m2792h();
        }
        return tcpContext.m2792h();
    }

    /* renamed from: b */
    static synchronized int m2780b() {
        int i;
        int i2 = 0;
        Iterator it = f2466a.values().iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                ((TcpContext) it.next()).m2792h().m2777f();
                i2 = i + 1;
            }
        }
        return i;
    }

    /* renamed from: b */
    static synchronized TcpContext m2781b(TcpContext tcpContext) {
        TcpContext tcpContext2;
        tcpContext2 = (TcpContext) f2466a.get(tcpContext.m2787c());
        if (tcpContext2 == null) {
            f2466a.put(tcpContext.m2787c(), tcpContext);
            tcpContext2 = tcpContext;
        } else {
            tcpContext2.f2468c = tcpContext.m2788d();
            tcpContext2.f2469d = tcpContext.m2789e();
            tcpContext2.f2470e = tcpContext.m2790f();
            tcpContext2.f2471f = tcpContext.m2791g();
            tcpContext2.f2473h = tcpContext.m2793i();
            tcpContext.f2472g = tcpContext2.m2792h();
        }
        return tcpContext2;
    }

    /* renamed from: c */
    static synchronized void m2782c(TcpContext tcpContext) {
        tcpContext.m2792h().m2776d();
    }

    /* renamed from: d */
    static synchronized void m2783d(TcpContext tcpContext) {
        f2466a.remove(tcpContext.m2787c());
        ChatONLogWriter.m3506b("removeTcpContext: " + tcpContext.m2787c(), "TcpContext");
    }

    /* renamed from: a */
    public void m2784a(long j) {
        TcpContext tcpContextM2781b = m2781b(this);
        this.f2473h = j;
        tcpContextM2781b.f2473h = j;
    }

    /* renamed from: a */
    public synchronized void m2785a(String str, int i) {
        this.f2468c = str;
        this.f2469d = i;
    }

    /* renamed from: a */
    public synchronized void m2786a(byte[] bArr, byte[] bArr2) {
        this.f2470e = new AesCipher(bArr, bArr2);
    }

    /* renamed from: c */
    public String m2787c() {
        return this.f2467b;
    }

    /* renamed from: d */
    public String m2788d() {
        return this.f2468c;
    }

    /* renamed from: e */
    public int m2789e() {
        return this.f2469d;
    }

    public boolean equals(Object obj) {
        try {
            return this.f2467b.equals(((TcpContext) obj).m2787c());
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: f */
    public AesCipher m2790f() {
        return this.f2470e;
    }

    /* renamed from: g */
    public long m2791g() {
        return this.f2471f;
    }

    /* renamed from: h */
    TcpClient m2792h() {
        return this.f2472g;
    }

    /* renamed from: i */
    public long m2793i() {
        return this.f2473h;
    }
}
