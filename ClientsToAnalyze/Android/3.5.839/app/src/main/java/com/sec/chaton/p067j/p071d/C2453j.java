package com.sec.chaton.p067j.p071d;

import android.os.PowerManager;
import android.os.SystemClock;
import com.google.protobuf.GeneratedMessageLite;
import com.sec.chaton.p067j.C2422ak;
import com.sec.chaton.p067j.C2426ao;
import com.sec.chaton.p067j.C2427ap;
import com.sec.chaton.p067j.C2460k;
import com.sec.chaton.p067j.C2466q;
import com.sec.chaton.util.C4808a;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;

/* compiled from: TcpEnvelopeBicoder.java */
/* renamed from: com.sec.chaton.j.d.j */
/* loaded from: classes.dex */
public class C2453j extends AbstractC2446c {

    /* renamed from: a */
    protected C2422ak f8796a;

    /* renamed from: b */
    private PowerManager.WakeLock f8797b;

    /* renamed from: c */
    private Map<Long, C2426ao> f8798c = new Hashtable();

    /* renamed from: d */
    private C4808a f8799d;

    public C2453j(C2422ak c2422ak, PowerManager.WakeLock wakeLock) {
        this.f8799d = null;
        this.f8796a = c2422ak;
        this.f8797b = wakeLock;
        this.f8799d = this.f8796a.m10495f();
    }

    @Override // com.sec.chaton.p067j.p071d.AbstractC2446c
    /* renamed from: a */
    protected Object mo10615a(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        C2444a c2444a;
        PowerManager.WakeLock wakeLock;
        if (this.f8797b != null) {
            this.f8797b.acquire();
        }
        try {
            C2426ao c2426ao = (C2426ao) obj;
            if (C2460k.m10656a(c2426ao.m10512b())) {
                m10627a(c2426ao);
            }
            if (this.f8799d == null && this.f8796a != null) {
                this.f8799d = this.f8796a.m10495f();
            }
            if (this.f8799d == null) {
                c2444a = new C2444a(c2426ao.m10507a(), Integer.parseInt("10", 16), c2426ao.m10512b(), c2426ao.m10513c().toByteArray());
                if (this.f8797b != null) {
                    wakeLock = this.f8797b;
                    wakeLock.release();
                }
            } else {
                c2444a = new C2444a(c2426ao.m10507a(), Integer.parseInt("10", 16), c2426ao.m10512b(), this.f8799d.m18102b(c2426ao.m10513c().toByteArray()));
                if (this.f8797b != null) {
                    wakeLock = this.f8797b;
                    wakeLock.release();
                }
            }
            return c2444a;
        } catch (Throwable th) {
            if (this.f8797b != null) {
                this.f8797b.release();
            }
            throw th;
        }
    }

    @Override // com.sec.chaton.p067j.p071d.AbstractC2446c
    /* renamed from: b */
    protected Object mo10616b(ChannelHandlerContext channelHandlerContext, Channel channel, Object obj) {
        try {
            channel.getRemoteAddress();
            return m10623a((C2444a) obj);
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            return null;
        }
    }

    /* renamed from: a */
    private C2426ao m10623a(C2444a c2444a) {
        try {
            GeneratedMessageLite generatedMessageLiteM10655a = C2460k.m10655a(c2444a.m10613c(), this.f8799d.m18103c(c2444a.m10614d()));
            long jM10654a = C2460k.m10654a(c2444a.m10613c(), generatedMessageLiteM10655a);
            C2427ap c2427apM10519a = new C2427ap().m10521a(c2444a.m10611a()).m10517a(c2444a.m10613c()).m10519a(generatedMessageLiteM10655a);
            if (C2460k.m10658b(c2444a.m10613c())) {
                C4904y.m18639b("Received msgID is " + jM10654a, getClass().getSimpleName());
                if (jM10654a == -1) {
                    c2427apM10519a.m10520a(this.f8796a.m10491c(9999));
                    C2426ao c2426aoM10522b = c2427apM10519a.m10522b();
                    c2426aoM10522b.m10510a((Object) null, c2426aoM10522b);
                    return c2426aoM10522b;
                }
                C2426ao c2426aoM10624a = m10624a(jM10654a);
                if (c2426aoM10624a == null) {
                    return null;
                }
                c2427apM10519a.m10520a(c2426aoM10624a.m10515e());
                C2426ao c2426aoM10522b2 = c2427apM10519a.m10522b();
                c2426aoM10522b2.m10510a(c2426aoM10624a, c2426aoM10522b2);
                return c2426aoM10522b2;
            }
            try {
                if (this.f8796a != null) {
                    C2466q c2466qM10491c = this.f8796a.m10491c(c2444a.m10613c());
                    if (c2466qM10491c != null) {
                        c2427apM10519a.m10520a(c2466qM10491c);
                    } else {
                        C4904y.m18644d("Should not reach here.");
                    }
                }
            } catch (Exception e) {
                C4904y.m18635a(e, "TcpEnvelopeBicoder");
            }
            C2426ao c2426aoM10522b3 = c2427apM10519a.m10522b();
            c2426aoM10522b3.m10510a((Object) null, c2426aoM10522b3);
            return c2426aoM10522b3;
        } catch (Exception e2) {
            try {
                C4904y.m18635a(e2, getClass().getSimpleName());
                return null;
            } catch (Exception e3) {
                C4904y.m18635a(e3, getClass().getSimpleName());
                return null;
            }
        }
    }

    /* renamed from: a */
    public synchronized C2426ao m10624a(long j) {
        C2426ao c2426aoRemove;
        c2426aoRemove = this.f8798c.remove(Long.valueOf(j));
        if (c2426aoRemove == null) {
            C4904y.m18639b(getClass().getSimpleName() + ".extractReqFormHistory() -> already handled error callback", getClass().getSimpleName());
            c2426aoRemove = null;
        } else if (c2426aoRemove.m10514d() != j) {
            c2426aoRemove = null;
        } else if (c2426aoRemove.m10512b() == -1) {
            C4904y.m18644d("Should not reach here.");
            c2426aoRemove = null;
        }
        return c2426aoRemove;
    }

    /* renamed from: a */
    public synchronized void m10627a(C2426ao c2426ao) {
        this.f8798c.put(Long.valueOf(c2426ao.m10514d()), c2426ao);
    }

    /* renamed from: a */
    public synchronized void m10626a(int i) {
        for (C2426ao c2426ao : this.f8798c.values()) {
            C4904y.m18639b("TcpEnvelopeBicoder.kickHistory() -> try tcp error callback", getClass().getSimpleName());
            c2426ao.m10508a(i, c2426ao);
        }
        this.f8798c.clear();
    }

    /* renamed from: a */
    public synchronized void m10625a() {
        if (this.f8798c.size() > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Iterator it = new ArrayList(this.f8798c.values()).iterator();
            int i = 0;
            while (it.hasNext()) {
                C2426ao c2426ao = (C2426ao) it.next();
                if (c2426ao != null && c2426ao.m10511a(jElapsedRealtime)) {
                    i++;
                    this.f8798c.remove(Long.valueOf(c2426ao.m10514d()));
                    StringBuilder sb = new StringBuilder();
                    sb.append("[ExpiredCollector] TimeOut Error= ").append("MsgID : ").append(c2426ao.m10514d()).append(", ").append("API type : ").append(c2426ao.m10512b());
                    C4904y.m18647f(sb.toString(), getClass().getSimpleName());
                    c2426ao.m10508a(21, c2426ao);
                }
            }
        }
    }
}
