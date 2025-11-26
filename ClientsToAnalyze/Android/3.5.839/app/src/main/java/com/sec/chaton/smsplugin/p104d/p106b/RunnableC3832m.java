package com.sec.chaton.smsplugin.p104d.p106b;

import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import org.p146b.p147a.p148a.InterfaceC5236a;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5240e;
import org.p146b.p147a.p149b.InterfaceC5242b;
import org.p146b.p147a.p149b.InterfaceC5243c;
import org.p146b.p147a.p149b.InterfaceC5244d;
import org.p146b.p147a.p149b.InterfaceC5256p;
import org.p146b.p147a.p149b.InterfaceC5257q;
import org.w3c.dom.NodeList;

/* compiled from: SmilPlayer.java */
/* renamed from: com.sec.chaton.smsplugin.d.b.m */
/* loaded from: classes.dex */
public class RunnableC3832m implements Runnable {

    /* renamed from: a */
    private static final Comparator<C3836q> f13705a = new C3833n();

    /* renamed from: b */
    private long f13706b;

    /* renamed from: c */
    private int f13707c;

    /* renamed from: d */
    private int f13708d;

    /* renamed from: e */
    private ArrayList<C3836q> f13709e;

    /* renamed from: f */
    private InterfaceC5244d f13710f;

    /* renamed from: g */
    private Thread f13711g;

    /* renamed from: h */
    private EnumC3835p f13712h = EnumC3835p.INITIALIZED;

    /* renamed from: i */
    private EnumC3834o f13713i = EnumC3834o.NO_ACTIVE_ACTION;

    /* renamed from: j */
    private ArrayList<InterfaceC5244d> f13714j;

    /* renamed from: k */
    private InterfaceC5237b f13715k;

    /* renamed from: a */
    private static ArrayList<C3836q> m14552a(InterfaceC5242b interfaceC5242b, double d, double d2) {
        ArrayList<C3836q> arrayList = new ArrayList<>();
        double dMo14611c = interfaceC5242b.mo14518g().mo14614a(0).mo14611c() + d;
        if (dMo14611c > d2) {
            return arrayList;
        }
        arrayList.add(new C3836q(dMo14611c, interfaceC5242b, 0));
        double dMo14611c2 = interfaceC5242b.mo14519h().mo14614a(0).mo14611c() + d;
        if (dMo14611c2 <= d2) {
            d2 = dMo14611c2;
        }
        C3836q c3836q = new C3836q(d2, interfaceC5242b, 1);
        NodeList nodeListS_ = interfaceC5242b.mo14533s_();
        for (int i = 0; i < nodeListS_.getLength(); i++) {
            arrayList.addAll(m14554a((InterfaceC5244d) nodeListS_.item(i), d, d2));
        }
        Collections.sort(arrayList, f13705a);
        NodeList nodeListA = interfaceC5242b.mo14504a(((float) (d2 - d)) * 1000.0f);
        for (int i2 = 0; i2 < nodeListA.getLength(); i2++) {
            arrayList.add(new C3836q(d2, (InterfaceC5244d) nodeListA.item(i2), 1));
        }
        arrayList.add(c3836q);
        return arrayList;
    }

    /* renamed from: a */
    private static ArrayList<C3836q> m14553a(InterfaceC5243c interfaceC5243c, double d, double d2) {
        ArrayList<C3836q> arrayList = new ArrayList<>();
        double dMo14611c = interfaceC5243c.mo14518g().mo14614a(0).mo14611c() + d;
        if (dMo14611c > d2) {
            return arrayList;
        }
        arrayList.add(new C3836q(dMo14611c, interfaceC5243c, 0));
        double dMo14611c2 = interfaceC5243c.mo14519h().mo14614a(0).mo14611c() + d;
        if (dMo14611c2 <= d2) {
            d2 = dMo14611c2;
        }
        C3836q c3836q = new C3836q(d2, interfaceC5243c, 1);
        NodeList nodeListS_ = interfaceC5243c.mo14533s_();
        double dM14588a = d;
        for (int i = 0; i < nodeListS_.getLength(); i++) {
            ArrayList<C3836q> arrayListM14554a = m14554a((InterfaceC5244d) nodeListS_.item(i), dM14588a, d2);
            arrayList.addAll(arrayListM14554a);
            dM14588a = arrayListM14554a.get(arrayListM14554a.size() - 1).m14588a();
        }
        NodeList nodeListA = interfaceC5243c.mo14504a((float) (d2 - d));
        for (int i2 = 0; i2 < nodeListA.getLength(); i2++) {
            arrayList.add(new C3836q(d2, (InterfaceC5244d) nodeListA.item(i2), 1));
        }
        arrayList.add(c3836q);
        return arrayList;
    }

    /* renamed from: a */
    private static ArrayList<C3836q> m14554a(InterfaceC5244d interfaceC5244d, double d, double d2) {
        if (interfaceC5244d instanceof InterfaceC5242b) {
            return m14552a((InterfaceC5242b) interfaceC5244d, d, d2);
        }
        if (interfaceC5244d instanceof InterfaceC5243c) {
            return m14553a((InterfaceC5243c) interfaceC5244d, d, d2);
        }
        ArrayList<C3836q> arrayList = new ArrayList<>();
        InterfaceC5257q interfaceC5257qMo14518g = interfaceC5244d.mo14518g();
        for (int i = 0; i < interfaceC5257qMo14518g.mo14613a(); i++) {
            InterfaceC5256p interfaceC5256pMo14614a = interfaceC5257qMo14518g.mo14614a(i);
            if (interfaceC5256pMo14614a.mo14610b()) {
                double dMo14611c = interfaceC5256pMo14614a.mo14611c() + d;
                if (dMo14611c <= d2) {
                    arrayList.add(new C3836q(dMo14611c, interfaceC5244d, 0));
                }
            }
        }
        InterfaceC5257q interfaceC5257qMo14519h = interfaceC5244d.mo14519h();
        for (int i2 = 0; i2 < interfaceC5257qMo14519h.mo14613a(); i2++) {
            InterfaceC5256p interfaceC5256pMo14614a2 = interfaceC5257qMo14519h.mo14614a(i2);
            if (interfaceC5256pMo14614a2.mo14610b()) {
                double dMo14611c2 = interfaceC5256pMo14614a2.mo14611c() + d;
                if (dMo14611c2 <= d2) {
                    arrayList.add(new C3836q(dMo14611c2, interfaceC5244d, 1));
                }
            }
        }
        Collections.sort(arrayList, f13705a);
        return arrayList;
    }

    /* renamed from: a */
    public synchronized boolean m14572a() {
        return this.f13712h == EnumC3835p.PLAYING;
    }

    /* renamed from: b */
    public synchronized boolean m14573b() {
        return this.f13712h == EnumC3835p.PLAYED;
    }

    /* renamed from: c */
    public synchronized boolean m14574c() {
        return this.f13712h == EnumC3835p.PAUSED;
    }

    /* renamed from: d */
    public synchronized boolean m14575d() {
        return this.f13712h == EnumC3835p.STOPPED;
    }

    /* renamed from: o */
    private synchronized boolean m14559o() {
        return this.f13713i == EnumC3834o.PAUSE;
    }

    /* renamed from: p */
    private synchronized boolean m14560p() {
        return this.f13713i == EnumC3834o.START;
    }

    /* renamed from: q */
    private synchronized boolean m14561q() {
        return this.f13713i == EnumC3834o.STOP;
    }

    /* renamed from: r */
    private synchronized boolean m14562r() {
        return this.f13713i == EnumC3834o.RELOAD;
    }

    /* renamed from: s */
    private synchronized boolean m14563s() {
        return this.f13713i == EnumC3834o.NEXT;
    }

    /* renamed from: t */
    private synchronized boolean m14564t() {
        return this.f13713i == EnumC3834o.PREV;
    }

    /* renamed from: a */
    public synchronized void m14571a(InterfaceC5244d interfaceC5244d) {
        this.f13710f = interfaceC5244d;
        this.f13709e = m14554a(this.f13710f, 0.0d, 9.223372036854776E18d);
        this.f13715k = ((InterfaceC5236a) this.f13710f).mo14523a("Event");
        this.f13715k.mo14489a("mediaTimeUpdated", false, false);
        this.f13714j = new ArrayList<>();
    }

    /* renamed from: e */
    public synchronized void m14576e() {
        if (!m14572a()) {
            this.f13706b = 0L;
            this.f13707c = 0;
            this.f13708d = 0;
            this.f13711g = new Thread(this);
            this.f13712h = EnumC3835p.PLAYING;
            this.f13711g.start();
        } else {
            C3890m.m14997c("Mms/smil", "Error State: Playback is playing!");
        }
    }

    /* renamed from: f */
    public synchronized void m14577f() {
        if (m14572a()) {
            this.f13713i = EnumC3834o.PAUSE;
            notifyAll();
        } else {
            C3890m.m14997c("Mms/smil", "Error State: Playback is not playing!");
        }
    }

    /* renamed from: g */
    public synchronized void m14578g() {
        if (m14574c()) {
            m14570z();
            this.f13713i = EnumC3834o.START;
            notifyAll();
        } else if (m14573b()) {
            m14576e();
        } else {
            C3890m.m14997c("Mms/smil", "Error State: Playback can not be started!");
        }
    }

    /* renamed from: h */
    public synchronized void m14579h() {
        if (m14572a() || m14574c()) {
            this.f13713i = EnumC3834o.STOP;
            notifyAll();
        } else if (m14573b()) {
            m14550I();
        }
    }

    /* renamed from: i */
    public synchronized void m14580i() {
        m14568x();
    }

    /* renamed from: j */
    public synchronized void m14581j() {
        if (m14572a() || m14574c()) {
            this.f13713i = EnumC3834o.RELOAD;
            notifyAll();
        } else if (m14573b()) {
            m14551J();
        }
    }

    /* renamed from: k */
    public synchronized void m14582k() {
        if (m14572a() || m14574c()) {
            this.f13713i = EnumC3834o.NEXT;
            notifyAll();
        }
    }

    /* renamed from: l */
    public synchronized void m14583l() {
        if (m14572a() || m14574c()) {
            this.f13713i = EnumC3834o.PREV;
            notifyAll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean m14556a(com.sec.chaton.smsplugin.p104d.p106b.C3836q r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            int r0 = r2.m14590c()     // Catch: java.lang.Throwable -> L14
            if (r0 != 0) goto L12
            org.b.a.b.d r0 = r2.m14589b()     // Catch: java.lang.Throwable -> L14
            boolean r0 = r0 instanceof com.sec.chaton.smsplugin.p104d.p106b.C3830k     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L12
            r0 = 1
        L10:
            monitor-exit(r1)
            return r0
        L12:
            r0 = 0
            goto L10
        L14:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p104d.p106b.RunnableC3832m.m14556a(com.sec.chaton.smsplugin.d.b.q):boolean");
    }

    /* renamed from: u */
    private synchronized void m14565u() {
        this.f13714j.clear();
        m14566v();
        for (int i = this.f13708d; i < this.f13707c; i++) {
            m14558b(this.f13709e.get(i));
        }
        m14567w();
    }

    /* renamed from: v */
    private synchronized void m14566v() {
        m14558b(this.f13709e.get(0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        r0 = r0.m14588a() * 1000.0d;
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized double m14557b(org.p146b.p147a.p149b.InterfaceC5244d r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f13708d     // Catch: java.lang.Throwable -> L2d
            r1 = r0
        L4:
            int r0 = r4.f13707c     // Catch: java.lang.Throwable -> L2d
            if (r1 >= r0) goto L2a
            java.util.ArrayList<com.sec.chaton.smsplugin.d.b.q> r0 = r4.f13709e     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L2d
            com.sec.chaton.smsplugin.d.b.q r0 = (com.sec.chaton.smsplugin.p104d.p106b.C3836q) r0     // Catch: java.lang.Throwable -> L2d
            org.b.a.b.d r2 = r0.m14589b()     // Catch: java.lang.Throwable -> L2d
            boolean r2 = r5.equals(r2)     // Catch: java.lang.Throwable -> L2d
            if (r2 == 0) goto L26
            double r0 = r0.m14588a()     // Catch: java.lang.Throwable -> L2d
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r0 = r0 * r2
        L24:
            monitor-exit(r4)
            return r0
        L26:
            int r0 = r1 + 1
            r1 = r0
            goto L4
        L2a:
            r0 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            goto L24
        L2d:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p104d.p106b.RunnableC3832m.m14557b(org.b.a.b.d):double");
    }

    /* renamed from: w */
    private synchronized void m14567w() {
        for (int size = this.f13714j.size() - 1; size >= 0; size--) {
            InterfaceC5244d interfaceC5244d = this.f13714j.get(size);
            if (interfaceC5244d instanceof C3830k) {
                break;
            }
            double dM14557b = m14557b(interfaceC5244d);
            if (dM14557b >= 0.0d && dM14557b <= this.f13706b) {
                interfaceC5244d.mo14524c((float) (this.f13706b - dM14557b));
            }
        }
    }

    /* renamed from: a */
    private synchronized void m14555a(long j) {
        long j2;
        long jCurrentTimeMillis = 0;
        while (j > 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            long jMin = Math.min(j, 200L);
            if (jCurrentTimeMillis < jMin) {
                wait(jMin - jCurrentTimeMillis);
                this.f13706b += jMin;
                j2 = jMin;
            } else {
                this.f13706b += jCurrentTimeMillis;
                j2 = 0;
            }
            if (m14561q() || m14562r() || m14559o() || m14563s() || m14564t()) {
                break;
            }
            ((InterfaceC5240e) this.f13710f).mo14501a(this.f13715k);
            j -= 200;
            jCurrentTimeMillis = (System.currentTimeMillis() - jCurrentTimeMillis2) - j2;
        }
    }

    /* renamed from: m */
    public synchronized int m14584m() {
        return (this.f13709e == null || this.f13709e.isEmpty()) ? 0 : ((int) this.f13709e.get(this.f13709e.size() - 1).f13730a) * 1000;
    }

    /* renamed from: n */
    public synchronized int m14585n() {
        return (int) this.f13706b;
    }

    /* renamed from: x */
    private synchronized void m14568x() {
        for (int size = this.f13714j.size() - 1; size >= 0; size--) {
            this.f13714j.get(size).mo14526d();
        }
    }

    /* renamed from: y */
    private synchronized void m14569y() {
        for (int size = this.f13714j.size() - 1; size >= 0; size--) {
            this.f13714j.get(size).mo14531q_();
        }
    }

    /* renamed from: z */
    private synchronized void m14570z() {
        int size = this.f13714j.size();
        for (int i = 0; i < size; i++) {
            this.f13714j.get(i).mo14532r_();
        }
    }

    /* renamed from: A */
    private synchronized void m14542A() {
        while (!m14560p() && !m14561q() && !m14562r() && !m14563s() && !m14564t()) {
            try {
                wait(200L);
            } catch (InterruptedException e) {
                C3890m.m14995a("Mms/smil", "Unexpected InterruptedException.", e);
            }
        }
        if (m14560p()) {
            this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
            this.f13712h = EnumC3835p.PLAYING;
        }
    }

    /* renamed from: b */
    private synchronized void m14558b(C3836q c3836q) {
        switch (c3836q.m14590c()) {
            case 0:
                c3836q.m14589b().mo14525c();
                this.f13714j.add(c3836q.m14589b());
                break;
            case 1:
                c3836q.m14589b().mo14526d();
                this.f13714j.remove(c3836q.m14589b());
                break;
        }
    }

    /* renamed from: B */
    private synchronized C3836q m14543B() {
        return this.f13707c < this.f13709e.size() ? this.f13709e.get(this.f13707c) : null;
    }

    /* renamed from: C */
    private void m14544C() {
        HashSet hashSet = new HashSet();
        int size = this.f13709e.size();
        for (int i = this.f13707c; i < size; i++) {
            C3836q c3836q = this.f13709e.get(i);
            int iM14590c = c3836q.m14590c();
            if ((c3836q.m14589b() instanceof C3830k) && iM14590c == 1) {
                m14558b(c3836q);
                this.f13707c = i;
                return;
            }
            if (iM14590c == 1 && !hashSet.contains(c3836q)) {
                m14558b(c3836q);
            } else if (iM14590c == 0) {
                hashSet.add(c3836q);
            }
        }
    }

    /* renamed from: D */
    private C3836q m14545D() {
        int size = this.f13709e.size();
        for (int i = this.f13707c; i < size; i++) {
            C3836q c3836q = this.f13709e.get(i);
            if (m14556a(c3836q)) {
                this.f13707c = i;
                this.f13708d = i;
                this.f13706b = (long) (c3836q.m14588a() * 1000.0d);
                return c3836q;
            }
        }
        this.f13707c++;
        if (this.f13707c >= size) {
            return null;
        }
        C3836q c3836q2 = this.f13709e.get(this.f13707c);
        this.f13706b = (long) (c3836q2.m14588a() * 1000.0d);
        return c3836q2;
    }

    /* renamed from: E */
    private C3836q m14546E() {
        int i;
        int i2;
        int i3 = 1;
        int i4 = this.f13708d;
        int i5 = -1;
        while (i4 >= 0) {
            C3836q c3836q = this.f13709e.get(i4);
            if (m14556a(c3836q)) {
                i2 = i3 - 1;
                if (i3 == 0) {
                    this.f13707c = i4;
                    this.f13708d = i4;
                    this.f13706b = (long) (c3836q.m14588a() * 1000.0d);
                    return c3836q;
                }
                i = i4;
            } else {
                i = i5;
                i2 = i3;
            }
            i4--;
            i3 = i2;
            i5 = i;
        }
        if (i5 != -1) {
            this.f13707c = i5;
            this.f13708d = i5;
            return this.f13709e.get(this.f13707c);
        }
        return null;
    }

    /* renamed from: F */
    private synchronized C3836q m14547F() {
        m14544C();
        return m14545D();
    }

    /* renamed from: G */
    private synchronized C3836q m14548G() {
        m14544C();
        return m14546E();
    }

    /* renamed from: H */
    private synchronized void m14549H() {
        m14569y();
        this.f13712h = EnumC3835p.PAUSED;
        this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
    }

    /* renamed from: I */
    private synchronized void m14550I() {
        m14568x();
        this.f13706b = 0L;
        this.f13707c = 0;
        this.f13708d = 0;
        this.f13712h = EnumC3835p.STOPPED;
        this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
    }

    /* renamed from: J */
    private synchronized void m14551J() {
        m14565u();
        this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!m14575d()) {
            int size = this.f13709e.size();
            this.f13707c = 0;
            while (this.f13707c < size) {
                C3836q c3836q = this.f13709e.get(this.f13707c);
                if (m14556a(c3836q)) {
                    this.f13708d = this.f13707c;
                }
                C3836q c3836qM14543B = c3836q;
                long jM14588a = (long) (c3836q.m14588a() * 1000.0d);
                while (jM14588a > this.f13706b) {
                    try {
                        m14555a(jM14588a - this.f13706b);
                    } catch (InterruptedException e) {
                        C3890m.m14995a("Mms/smil", "Unexpected InterruptedException.", e);
                    }
                    while (true) {
                        if (m14559o() || m14561q() || m14562r() || m14563s() || m14564t()) {
                            if (m14559o()) {
                                m14549H();
                                m14542A();
                            }
                            if (m14561q()) {
                                m14550I();
                                return;
                            }
                            if (m14562r()) {
                                m14551J();
                                c3836qM14543B = m14543B();
                                if (c3836qM14543B != null) {
                                    if (m14574c()) {
                                        this.f13713i = EnumC3834o.PAUSE;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (m14563s()) {
                                C3836q c3836qM14547F = m14547F();
                                if (c3836qM14547F != null) {
                                    c3836qM14543B = c3836qM14547F;
                                }
                                if (this.f13712h == EnumC3835p.PAUSED) {
                                    this.f13713i = EnumC3834o.PAUSE;
                                    m14558b(c3836qM14543B);
                                } else {
                                    this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
                                }
                                jM14588a = this.f13706b;
                            }
                            if (m14564t()) {
                                C3836q c3836qM14548G = m14548G();
                                if (c3836qM14548G != null) {
                                    c3836qM14543B = c3836qM14548G;
                                }
                                if (this.f13712h == EnumC3835p.PAUSED) {
                                    this.f13713i = EnumC3834o.PAUSE;
                                    m14558b(c3836qM14543B);
                                } else {
                                    this.f13713i = EnumC3834o.NO_ACTIVE_ACTION;
                                }
                                jM14588a = this.f13706b;
                            }
                        }
                    }
                }
                this.f13706b = jM14588a;
                m14558b(c3836qM14543B);
                this.f13707c++;
            }
            this.f13712h = EnumC3835p.PLAYED;
        }
    }
}
