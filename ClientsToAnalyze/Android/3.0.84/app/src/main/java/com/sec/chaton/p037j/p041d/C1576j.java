package com.sec.chaton.p037j.p041d;

import android.os.PowerManager;
import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.p037j.C1544ac;
import com.sec.chaton.p037j.C1548ag;
import com.sec.chaton.p037j.C1549ah;
import com.sec.chaton.p037j.C1579g;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.util.C3158a;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* compiled from: TcpEnvelopeBicoder.java */
/* renamed from: com.sec.chaton.j.d.j */
/* loaded from: classes.dex */
public class C1576j extends AbstractC1569c {

    /* renamed from: a */
    protected C1544ac f5852a;

    /* renamed from: b */
    private PowerManager.WakeLock f5853b;

    /* renamed from: c */
    private Map<Long, C1548ag> f5854c = new Hashtable();

    /* renamed from: d */
    private C3158a f5855d;

    public C1576j(C1544ac c1544ac, PowerManager.WakeLock wakeLock) {
        this.f5855d = null;
        this.f5852a = c1544ac;
        this.f5853b = wakeLock;
        this.f5855d = this.f5852a.m6559f();
    }

    @Override // com.sec.chaton.p037j.p041d.AbstractC1569c
    /* renamed from: a */
    protected Object mo6671a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C1567a c1567a;
        PowerManager.WakeLock wakeLock;
        if (this.f5853b != null) {
            this.f5853b.acquire();
        }
        try {
            C1548ag c1548ag = (C1548ag) obj;
            if (C1579g.m6694a(c1548ag.m6574b())) {
                m6683a(c1548ag);
            }
            if (this.f5855d == null && this.f5852a != null) {
                this.f5855d = this.f5852a.m6559f();
            }
            if (this.f5855d == null) {
                c1567a = new C1567a(c1548ag.m6569a(), 1, c1548ag.m6574b(), c1548ag.m6575c().toByteArray());
                if (this.f5853b != null) {
                    wakeLock = this.f5853b;
                    wakeLock.release();
                }
            } else {
                c1567a = new C1567a(c1548ag.m6569a(), 0, c1548ag.m6574b(), this.f5855d.m10960b(c1548ag.m6575c().toByteArray()));
                if (this.f5853b != null) {
                    wakeLock = this.f5853b;
                    wakeLock.release();
                }
            }
            return c1567a;
        } catch (Throwable th) {
            if (this.f5853b != null) {
                this.f5853b.release();
            }
            throw th;
        }
    }

    @Override // com.sec.chaton.p037j.p041d.AbstractC1569c
    /* renamed from: b */
    protected Object mo6672b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        try {
            channel.getRemoteAddress();
            return m6679a((C1567a) obj);
        } catch (Exception e) {
            C3250y.m11451b(e);
            return null;
        }
    }

    /* renamed from: a */
    private C1548ag m6679a(C1567a c1567a) {
        GeneratedMessageLite generatedMessageLiteM6693a;
        try {
            if ((c1567a.m6668b() & 1) == 0) {
                try {
                    generatedMessageLiteM6693a = C1579g.m6693a(c1567a.m6669c(), this.f5855d.m10961c(c1567a.m6670d()));
                } catch (Exception e) {
                    C3250y.m11451b(e);
                    return null;
                }
            } else {
                generatedMessageLiteM6693a = C1579g.m6693a(c1567a.m6669c(), c1567a.m6670d());
            }
            long jM6692a = C1579g.m6692a(c1567a.m6669c(), generatedMessageLiteM6693a);
            C1549ah c1549ahM6581a = new C1549ah().m6583a(c1567a.m6667a()).m6579a(c1567a.m6669c()).m6581a(generatedMessageLiteM6693a);
            if (C1579g.m6696b(c1567a.m6669c())) {
                C3250y.m11450b("Received msgID is " + jM6692a, getClass().getSimpleName());
                if (jM6692a == -1) {
                    c1549ahM6581a.m6582a(this.f5852a.m6555c(9999));
                    C1548ag c1548agM6584b = c1549ahM6581a.m6584b();
                    c1548agM6584b.m6572a((Object) null, c1548agM6584b);
                    return c1548agM6584b;
                }
                C1548ag c1548agM6680a = m6680a(jM6692a);
                if (c1548agM6680a == null) {
                    return null;
                }
                c1549ahM6581a.m6582a(c1548agM6680a.m6577e());
                C1548ag c1548agM6584b2 = c1549ahM6581a.m6584b();
                c1548agM6584b2.m6572a(c1548agM6680a, c1548agM6584b2);
                return c1548agM6584b2;
            }
            try {
                if (this.f5852a != null) {
                    C1589q c1589qM6555c = this.f5852a.m6555c(c1567a.m6669c());
                    if (c1589qM6555c != null) {
                        c1549ahM6581a.m6582a(c1589qM6555c);
                    } else {
                        C3250y.m11454d("Should not reach here.");
                    }
                }
            } catch (Exception e2) {
                C3250y.m11443a(e2, "TcpEnvelopeBicoder");
            }
            C1548ag c1548agM6584b3 = c1549ahM6581a.m6584b();
            c1548agM6584b3.m6572a((Object) null, c1548agM6584b3);
            return c1548agM6584b3;
        } catch (Exception e3) {
            C3250y.m11451b(e3);
            return null;
        }
    }

    /* renamed from: a */
    public synchronized C1548ag m6680a(long j) {
        C1548ag c1548agRemove;
        c1548agRemove = this.f5854c.remove(Long.valueOf(j));
        if (c1548agRemove == null) {
            C3250y.m11450b(getClass().getSimpleName() + ".extractReqFormHistory() -> already handled error callback", getClass().getSimpleName());
            c1548agRemove = null;
        } else if (c1548agRemove.m6576d() != j) {
            c1548agRemove = null;
        } else if (c1548agRemove.m6574b() == -1) {
            C3250y.m11454d("Should not reach here.");
            c1548agRemove = null;
        }
        return c1548agRemove;
    }

    /* renamed from: a */
    public synchronized void m6683a(C1548ag c1548ag) {
        this.f5854c.put(Long.valueOf(c1548ag.m6576d()), c1548ag);
    }

    /* renamed from: a */
    public synchronized void m6682a(int i) {
        for (C1548ag c1548ag : this.f5854c.values()) {
            C3250y.m11450b("TcpEnvelopeBicoder.kickHistory() -> try tcp error callback", getClass().getSimpleName());
            c1548ag.m6570a(i, c1548ag);
        }
        this.f5854c.clear();
    }

    /* renamed from: a */
    public synchronized void m6681a() {
        if (this.f5854c.size() > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = new ArrayList(this.f5854c.values()).iterator();
            int i = 0;
            while (it.hasNext()) {
                C1548ag c1548ag = (C1548ag) it.next();
                if (c1548ag != null && c1548ag.m6573a(jElapsedRealtime)) {
                    i++;
                    this.f5854c.remove(Long.valueOf(c1548ag.m6576d()));
                    StringBuilder sb = new StringBuilder();
                    sb.append("[ExpiredCollector] TimeOut Error= ").append("MsgID : ").append(c1548ag.m6576d()).append(", ").append("API type : ").append(c1548ag.m6574b());
                    C3250y.m11457f(sb.toString(), getClass().getSimpleName());
                    c1548ag.m6570a(21, c1548ag);
                }
            }
        }
    }
}
