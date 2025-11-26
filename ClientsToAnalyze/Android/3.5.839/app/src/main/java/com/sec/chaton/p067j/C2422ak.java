package com.sec.chaton.p067j;

import com.sec.chaton.global.C2349a;
import com.sec.chaton.msgsend.C2684ab;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4844bi;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5034k;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TcpContext.java */
/* renamed from: com.sec.chaton.j.ak */
/* loaded from: classes.dex */
public class C2422ak {

    /* renamed from: b */
    protected String f8620b;

    /* renamed from: c */
    protected String f8621c;

    /* renamed from: d */
    protected int f8622d;

    /* renamed from: e */
    protected C4808a f8623e;

    /* renamed from: f */
    protected long f8624f;

    /* renamed from: g */
    C2417af f8625g;

    /* renamed from: h */
    protected long f8626h;

    /* renamed from: j */
    private Map<Integer, C2466q> f8627j;

    /* renamed from: i */
    private static final String f8619i = C2422ak.class.getSimpleName();

    /* renamed from: a */
    static HashMap<String, C2422ak> f8618a = new HashMap<>();

    /* renamed from: a */
    static synchronized C2417af m10478a(C2422ak c2422ak) {
        C2422ak c2422ak2 = f8618a.get(c2422ak.m10492c());
        if (c2422ak2 == null) {
            c2422ak.f8625g = new C2417af(c2422ak);
            f8618a.put(c2422ak.m10492c(), c2422ak);
            C2684ab.m11290a(f8619i, "TcpContext, getClient(), created and inserted. %s", c2422ak);
        } else {
            c2422ak2.f8621c = c2422ak.m10493d();
            c2422ak2.f8622d = c2422ak.m10494e();
            c2422ak2.f8623e = c2422ak.m10495f();
            c2422ak2.f8624f = c2422ak.m10496g();
            c2422ak2.f8626h = c2422ak.m10498i();
            c2422ak.f8625g = c2422ak2.m10497h();
        }
        return c2422ak.m10497h();
    }

    /* renamed from: b */
    static synchronized C2422ak m10483b(C2422ak c2422ak) {
        C2422ak c2422ak2 = f8618a.get(c2422ak.m10492c());
        if (c2422ak2 == null) {
            f8618a.put(c2422ak.m10492c(), c2422ak);
            C2684ab.m11290a(f8619i, "TcpContext, getContext(), created and inserted. %s", c2422ak);
        } else {
            c2422ak2.f8621c = c2422ak.m10493d();
            c2422ak2.f8622d = c2422ak.m10494e();
            c2422ak2.f8623e = c2422ak.m10495f();
            c2422ak2.f8624f = c2422ak.m10496g();
            c2422ak2.f8626h = c2422ak.m10498i();
            c2422ak.f8625g = c2422ak2.m10497h();
            c2422ak = c2422ak2;
        }
        return c2422ak;
    }

    public String toString() {
        return String.format("%s : id(%s), domain(%s), port(%d), expireTime(%d), aliveTime(%d), ", getClass().getName() + '@' + Integer.toHexString(hashCode()), this.f8620b, this.f8621c, Integer.valueOf(this.f8622d), Long.valueOf(this.f8624f), Long.valueOf(this.f8626h));
    }

    /* renamed from: c */
    static synchronized void m10484c(C2422ak c2422ak) {
        c2422ak.m10497h().m10471d();
    }

    /* renamed from: d */
    static synchronized void m10485d(C2422ak c2422ak) {
        C2422ak c2422akRemove = f8618a.remove(c2422ak.m10492c());
        if (c2422akRemove != null) {
            c2422akRemove.m10486j();
            C2684ab.m11290a(f8619i, "TcpContext, removeTcpContext() %s", c2422ak);
        }
        C4904y.m18639b("removeTcpContext: " + c2422ak.m10492c(), "TcpContext");
    }

    /* renamed from: a */
    static synchronized boolean m10480a(int i) {
        boolean zM10526a;
        zM10526a = C2428aq.m10526a(new C2423al(C2428aq.m10527b(), "closeAll", i));
        if (!zM10526a) {
            C4904y.m18639b("tcp_queue, TcpContext.closeAll() : queue offer fail.", f8619i);
        }
        return zM10526a;
    }

    /* renamed from: b */
    static synchronized int m10482b(int i) {
        int i2;
        int i3 = 0;
        Iterator it = new ArrayList(f8618a.values()).iterator();
        while (true) {
            i2 = i3;
            if (it.hasNext()) {
                ((C2422ak) it.next()).m10497h().m10465a(i);
                i3 = i2 + 1;
            }
        }
        return i2;
    }

    /* renamed from: a */
    static synchronized boolean m10479a() {
        boolean zM10526a;
        zM10526a = C2428aq.m10526a(new C2424am(C2428aq.m10527b(), "expiredCollectAll"));
        if (!zM10526a) {
            C4904y.m18639b("tcp_queue, TcpContext.expiredCollectAll() : queue offer fail.", f8619i);
        }
        return zM10526a;
    }

    /* renamed from: b */
    static synchronized int m10481b() {
        int i;
        int i2 = 0;
        Iterator<C2422ak> it = f8618a.values().iterator();
        while (true) {
            i = i2;
            if (it.hasNext()) {
                it.next().m10497h().m10472f();
                i2 = i + 1;
            }
        }
        return i;
    }

    public boolean equals(Object obj) {
        try {
            if (obj instanceof C2422ak) {
                return this.f8620b.equals(((C2422ak) obj).m10492c());
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    protected C2422ak(C2425an c2425an) throws NoSuchFieldException {
        this.f8620b = null;
        this.f8621c = null;
        this.f8622d = Integer.MIN_VALUE;
        this.f8623e = null;
        this.f8624f = -2147483648L;
        this.f8625g = null;
        this.f8626h = 0L;
        if (c2425an.f8629a == null) {
            throw new NoSuchFieldException("No Context ID");
        }
        this.f8620b = c2425an.f8629a;
        if (c2425an.f8630b == null) {
            throw new NoSuchFieldException("No Domain");
        }
        if (c2425an.f8630b.length() == 0) {
            throw new NoSuchFieldException("No Domain actually. Domain length is 0");
        }
        this.f8621c = c2425an.f8630b;
        if (c2425an.f8631c == Integer.MIN_VALUE) {
            throw new NoSuchFieldException("No Port");
        }
        this.f8622d = c2425an.f8631c;
        this.f8623e = c2425an.f8632d;
        this.f8624f = c2425an.f8633e;
        this.f8626h = Long.MAX_VALUE;
        this.f8627j = new HashMap();
        this.f8625g = m10478a(this);
    }

    /* renamed from: c */
    public String m10492c() {
        return this.f8620b;
    }

    /* renamed from: d */
    public String m10493d() {
        return this.f8621c;
    }

    /* renamed from: e */
    public int m10494e() {
        if (C2349a.m10301a("wifi_80_port") && C5034k.m19105j()) {
            int iIntValue = C4809aa.m18104a().m18120a(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(this.f8622d)).intValue();
            if (iIntValue == C4844bi.f17656a) {
                iIntValue = this.f8622d;
            } else if (iIntValue == C4844bi.f17657b) {
                iIntValue = C4844bi.m18324d();
                C4809aa.m18104a().m18126b(Config.PROVIDER_PATH_WIFI_PORT, Integer.valueOf(iIntValue));
                if (iIntValue == C4844bi.f17657b) {
                    iIntValue = C4809aa.m18104a().m18120a("primary_message_wifi_port", (Integer) 80).intValue();
                }
            }
            C4904y.m18639b("[WIFI 80] WiFi " + iIntValue, "TcpContext");
            return iIntValue;
        }
        C4904y.m18639b("[WIFI 80] dataNetwork getPort::" + this.f8622d, "TcpContext");
        return this.f8622d;
    }

    /* renamed from: f */
    public C4808a m10495f() {
        return this.f8623e;
    }

    /* renamed from: g */
    public long m10496g() {
        return this.f8624f;
    }

    /* renamed from: h */
    C2417af m10497h() {
        return this.f8625g;
    }

    /* renamed from: i */
    public long m10498i() {
        return this.f8626h;
    }

    /* renamed from: a */
    public synchronized void m10489a(String str, int i) {
        this.f8621c = str;
        this.f8622d = i;
    }

    /* renamed from: a */
    public void m10488a(long j) {
        C2422ak c2422akM10483b = m10483b(this);
        this.f8626h = j;
        c2422akM10483b.f8626h = j;
    }

    /* renamed from: a */
    public synchronized void m10490a(byte[] bArr, byte[] bArr2) {
        this.f8623e = new C4808a(bArr, bArr2);
    }

    /* renamed from: a */
    public void m10487a(int i, C2466q c2466q) {
        this.f8627j.put(Integer.valueOf(i), c2466q);
    }

    /* renamed from: c */
    public C2466q m10491c(int i) {
        return this.f8627j.get(Integer.valueOf(i));
    }

    /* renamed from: j */
    private void m10486j() {
        if (this.f8627j != null && !this.f8627j.isEmpty()) {
            this.f8627j.clear();
        }
    }
}
