package com.sec.chaton.chat;

import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

/* compiled from: TypingStateManager.java */
/* renamed from: com.sec.chaton.chat.hy */
/* loaded from: classes.dex */
public class C1779hy {

    /* renamed from: c */
    private Timer f6677c;

    /* renamed from: d */
    private Timer f6678d;

    /* renamed from: e */
    private long f6679e;

    /* renamed from: f */
    private C2142w f6680f;

    /* renamed from: g */
    private InterfaceC1786ie f6681g;

    /* renamed from: a */
    private EnumC1787if f6675a = EnumC1787if.IDLE;

    /* renamed from: b */
    private EnumC1787if f6676b = EnumC1787if.IDLE;

    /* renamed from: h */
    private Map<String, C1778hx> f6682h = new HashMap();

    public C1779hy(C2142w c2142w, InterfaceC1786ie interfaceC1786ie) {
        this.f6680f = c2142w;
        this.f6681g = interfaceC1786ie;
    }

    /* renamed from: a */
    public void m8812a() {
        m8808e();
        m8810f();
        m8811g();
        if (this.f6675a == EnumC1787if.ACTIVE) {
            this.f6680f.m9641a(EnumC1787if.m8817a(EnumC1787if.IDLE), 65);
        }
        this.f6682h.clear();
        this.f6675a = EnumC1787if.IDLE;
        this.f6676b = EnumC1787if.IDLE;
        this.f6677c = null;
        this.f6678d = null;
    }

    /* renamed from: a */
    public void m8813a(String str, long j, long j2, EnumC1787if enumC1787if) {
        long j3 = j == 0 ? 120000L : j;
        if (C4904y.f17873c) {
            StringBuilder sb = new StringBuilder();
            sb.append("sender : ").append(str).append(", ").append("refreshTime : ").append(String.valueOf(j3)).append(", ").append("receivedTime : ").append(String.valueOf(j2)).append(", ").append("state : ").append(EnumC1787if.m8817a(enumC1787if));
            C4904y.m18641c(sb.toString(), "TypingStateManager");
        }
        if (this.f6682h.containsKey(str)) {
            if (enumC1787if == EnumC1787if.IDLE) {
                this.f6682h.remove(str).m8797d();
                if (this.f6682h.size() == 0) {
                    this.f6681g.mo8228a(EnumC1787if.IDLE);
                    return;
                }
                return;
            }
            C1778hx c1778hx = this.f6682h.get(str);
            c1778hx.m8795b(j2);
            c1778hx.m8797d();
            c1778hx.m8792a(j3);
            m8801a(c1778hx);
            return;
        }
        if (enumC1787if == EnumC1787if.ACTIVE) {
            C1778hx c1778hx2 = new C1778hx(str, j3, j2);
            this.f6682h.put(str, c1778hx2);
            m8801a(c1778hx2);
            if (this.f6682h.size() == 1) {
                this.f6681g.mo8228a(EnumC1787if.ACTIVE);
            }
        }
    }

    /* renamed from: b */
    public void m8814b() {
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 != iM10677a && -2 != iM10677a) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f6679e >= 1000) {
                this.f6679e = jCurrentTimeMillis;
                if (C4904y.f17873c) {
                    C4904y.m18641c("click keyboard - " + this.f6679e, "TypingStateManager");
                }
            }
            if (this.f6675a == EnumC1787if.IDLE) {
                this.f6675a = EnumC1787if.ACTIVE;
                m8806d();
                m8800a(10000L);
            }
        }
    }

    /* renamed from: c */
    public void m8815c() {
        this.f6675a = EnumC1787if.IDLE;
        m8808e();
        m8810f();
    }

    /* renamed from: d */
    private void m8806d() {
        if (this.f6677c == null) {
            this.f6677c = new Timer();
        }
        this.f6677c.schedule(new C1780hz(this), 100L, 60000L);
        if (C4904y.f17873c) {
            C4904y.m18641c("Start a timer for active", "TypingStateManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m8808e() {
        if (this.f6677c != null) {
            this.f6677c.cancel();
            this.f6677c = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("Stop a timer for active", "TypingStateManager");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8800a(long j) {
        if (this.f6678d == null) {
            this.f6678d = new Timer();
        }
        C1782ia c1782ia = new C1782ia(this, j);
        if (C4904y.f17873c) {
            C4904y.m18641c("Start a timer for idle - " + j, "TypingStateManager");
        }
        this.f6678d.schedule(c1782ia, j);
    }

    /* renamed from: f */
    private void m8810f() {
        if (this.f6678d != null) {
            this.f6678d.cancel();
            this.f6678d = null;
            if (C4904y.f17873c) {
                C4904y.m18641c("Stop a timer for idle", "TypingStateManager");
            }
        }
    }

    /* renamed from: a */
    private void m8801a(C1778hx c1778hx) {
        c1778hx.m8793a(new C1783ib(this, c1778hx.m8796c(), c1778hx.m8794b(), c1778hx.m8791a()), 100L);
    }

    /* renamed from: g */
    private void m8811g() {
        Iterator<Map.Entry<String, C1778hx>> it = this.f6682h.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().m8797d();
        }
        if (this.f6682h.size() > 0) {
            this.f6681g.mo8228a(EnumC1787if.IDLE);
        }
    }
}
