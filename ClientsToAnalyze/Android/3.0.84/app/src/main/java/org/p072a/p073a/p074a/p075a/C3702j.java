package org.p072a.p073a.p074a.p075a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TimerTask;
import java.util.TreeMap;
import org.p072a.p073a.p074a.AbstractC3693a;
import org.p072a.p073a.p074a.C3712g;
import org.p072a.p073a.p074a.InterfaceC3710e;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.j */
/* loaded from: classes.dex */
public class C3702j<K, V> extends AbstractC3693a<K, V> {

    /* renamed from: a */
    private int f13643a;

    /* renamed from: b */
    private volatile int f13644b;

    /* renamed from: c */
    private int f13645c;

    /* renamed from: d */
    private int f13646d;

    /* renamed from: e */
    private long f13647e;

    /* renamed from: f */
    private byte f13648f;

    /* renamed from: g */
    private volatile boolean f13649g;

    /* renamed from: h */
    private volatile boolean f13650h;

    /* renamed from: i */
    private boolean f13651i;

    /* renamed from: j */
    private long f13652j;

    /* renamed from: k */
    private int f13653k;

    /* renamed from: l */
    private long f13654l;

    /* renamed from: m */
    private Map<K, C3702j<K, V>.n> f13655m;

    /* renamed from: n */
    private int f13656n;

    /* renamed from: o */
    private int f13657o;

    /* renamed from: p */
    private int f13658p;

    /* renamed from: q */
    private InterfaceC3710e<K, V> f13659q;

    /* renamed from: r */
    private C3702j<K, V>.l f13660r;

    /* renamed from: s */
    private C3694a<K> f13661s;

    /* renamed from: t */
    private C3694a<C3705o<V>>.b f13662t;

    /* renamed from: u */
    private C3694a<K>.b f13663u;

    /* renamed from: v */
    private boolean f13664v;

    /* renamed from: w */
    private LinkedList<C3702j<K, V>.C3704m<K, V>> f13665w;

    /* renamed from: a */
    static /* synthetic */ int m13322a(C3702j c3702j) {
        int i = c3702j.f13656n;
        c3702j.f13656n = i + 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ int m13326b(C3702j c3702j) {
        int i = c3702j.f13656n;
        c3702j.f13656n = i - 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m13327c(C3702j c3702j) {
        int i = c3702j.f13658p;
        c3702j.f13658p = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m13329d(C3702j c3702j) {
        int i = c3702j.f13658p;
        c3702j.f13658p = i - 1;
        return i;
    }

    public C3702j() {
        this(null, 8, (byte) 1, -1L, 8, false, false, -1L, 3, 1800000L, false);
    }

    public C3702j(InterfaceC3710e<K, V> interfaceC3710e, int i, byte b, long j) {
        this(interfaceC3710e, i, b, j, 8, false, false, -1L, 3, 1800000L, false);
    }

    public C3702j(InterfaceC3710e<K, V> interfaceC3710e, int i, byte b, long j, int i2, boolean z, boolean z2, long j2, int i3, long j3, boolean z3) {
        this(interfaceC3710e, i, b, j, i2, -1, z, z2, j2, i3, j3, z3);
    }

    public C3702j(InterfaceC3710e<K, V> interfaceC3710e, int i, byte b, long j, int i2, int i3, boolean z, boolean z2, long j2, int i4, long j3, boolean z3) {
        this(interfaceC3710e, i, b, j, i2, i3, 0, z, z2, j2, i4, j3, z3);
    }

    public C3702j(InterfaceC3710e<K, V> interfaceC3710e, int i, byte b, long j, int i2, int i3, int i4, boolean z, boolean z2, long j2, int i5, long j3, boolean z3) {
        this(interfaceC3710e, i, b, j, i2, i3, i4, z, z2, j2, i5, j3, z3, true);
    }

    public C3702j(InterfaceC3710e<K, V> interfaceC3710e, int i, byte b, long j, int i2, int i3, int i4, boolean z, boolean z2, long j2, int i5, long j3, boolean z3, boolean z4) {
        this.f13643a = 8;
        this.f13644b = 0;
        this.f13645c = 8;
        this.f13646d = -1;
        this.f13647e = -1L;
        this.f13648f = (byte) 1;
        this.f13649g = false;
        this.f13650h = false;
        this.f13651i = false;
        this.f13652j = -1L;
        this.f13653k = 3;
        this.f13654l = 1800000L;
        this.f13655m = null;
        this.f13656n = 0;
        this.f13657o = 0;
        this.f13658p = 0;
        this.f13659q = null;
        this.f13660r = null;
        this.f13661s = null;
        this.f13662t = null;
        this.f13663u = null;
        this.f13664v = true;
        this.f13665w = new LinkedList<>();
        this.f13659q = interfaceC3710e;
        this.f13645c = i;
        this.f13664v = z4;
        switch (b) {
            case 0:
            case 1:
            case 2:
                this.f13648f = b;
                this.f13647e = j;
                this.f13643a = i2;
                this.f13646d = i3;
                this.f13644b = i4;
                this.f13649g = z;
                this.f13650h = z2;
                this.f13652j = j2;
                this.f13653k = i5;
                this.f13654l = j3;
                this.f13651i = z3;
                this.f13655m = new HashMap();
                this.f13661s = new C3694a<>();
                m13336a(this.f13652j);
                return;
            default:
                throw new IllegalArgumentException("whenExhaustedAction " + ((int) b) + " not recognized.");
        }
    }

    /* renamed from: g */
    public synchronized int m13339g() {
        return this.f13645c;
    }

    /* renamed from: h */
    public synchronized int m13340h() {
        return this.f13646d;
    }

    /* renamed from: i */
    public int m13341i() {
        return this.f13644b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public V m13338b(K k) {
        byte b;
        long j;
        boolean z;
        boolean z2 = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C3702j<K, V>.C3704m<K, V> c3704m = new C3704m<>(this, k);
        synchronized (this) {
            b = this.f13648f;
            j = this.f13647e;
            this.f13665w.add(c3704m);
        }
        m13332l();
        while (true) {
            synchronized (this) {
                m13291f();
            }
            if (c3704m.m13355c() == null && !c3704m.m13357d()) {
                switch (b) {
                    case 0:
                        synchronized (this) {
                            if (c3704m.m13355c() == null && !c3704m.m13357d()) {
                                this.f13665w.remove(c3704m);
                                throw new NoSuchElementException("Pool exhausted");
                            }
                            break;
                        }
                        break;
                    case 1:
                        try {
                            synchronized (c3704m) {
                                if (c3704m.m13355c() != null || c3704m.m13357d()) {
                                    break;
                                } else {
                                    if (j <= 0) {
                                        c3704m.wait();
                                    } else {
                                        long jCurrentTimeMillis2 = j - (System.currentTimeMillis() - jCurrentTimeMillis);
                                        if (jCurrentTimeMillis2 > 0) {
                                            c3704m.wait(jCurrentTimeMillis2);
                                        }
                                    }
                                    if (m13290e()) {
                                        throw new IllegalStateException("Pool closed");
                                    }
                                    if (j > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= j) {
                                        synchronized (this) {
                                            if (c3704m.m13355c() == null && !c3704m.m13357d()) {
                                                this.f13665w.remove(c3704m);
                                                throw new NoSuchElementException("Timeout waiting for idle object");
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (InterruptedException e) {
                            synchronized (this) {
                                if (c3704m.m13355c() == null && !c3704m.m13357d()) {
                                    this.f13665w.remove(c3704m);
                                } else if (c3704m.m13355c() != null || !c3704m.m13357d()) {
                                    c3704m.m13352b().m13366d();
                                    c3704m.m13352b().m13363a();
                                    m13337a((C3702j<K, V>) c3704m.m13344a(), c3704m.m13355c().m13368a());
                                } else {
                                    c3704m.m13352b().m13366d();
                                    z2 = true;
                                }
                                if (z2) {
                                    m13332l();
                                }
                                Thread.currentThread().interrupt();
                                throw e;
                            }
                        }
                        break;
                    case 2:
                        synchronized (this) {
                            if (c3704m.m13355c() == null && !c3704m.m13357d()) {
                                this.f13665w.remove(c3704m);
                                c3704m.m13352b().m13365c();
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("whenExhaustedAction " + ((int) b) + " not recognized.");
                }
            }
            if (c3704m.m13355c() == null) {
                try {
                    c3704m.m13350a(new C3705o(this.f13659q.mo5109a(k)));
                    z = true;
                } catch (Throwable th) {
                    synchronized (this) {
                        c3704m.m13352b().m13366d();
                        m13332l();
                        throw th;
                    }
                }
            } else {
                z = false;
            }
            try {
                this.f13659q.mo13373d(k, c3704m.m13355c().f13676a);
                if (this.f13649g && !this.f13659q.mo13372c(k, c3704m.m13355c().f13676a)) {
                    throw new Exception("ValidateObject failed");
                }
                synchronized (this) {
                    c3704m.m13352b().m13366d();
                    c3704m.m13352b().m13363a();
                }
                return (V) c3704m.m13355c().f13676a;
            } catch (Throwable th2) {
                C3712g.m13379a(th2);
                try {
                    this.f13659q.mo13371b(k, c3704m.m13355c().f13676a);
                } catch (Throwable th3) {
                    C3712g.m13379a(th3);
                }
                synchronized (this) {
                    c3704m.m13352b().m13366d();
                    if (!z) {
                        c3704m.m13358e();
                        this.f13665w.add(0, c3704m);
                    }
                    m13332l();
                    if (z) {
                        throw new NoSuchElementException("Could not create a validated object, cause: " + th2.getMessage());
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l */
    private void m13332l() {
        boolean z;
        n nVar;
        synchronized (this) {
            if (!m13290e()) {
                Iterator<C3702j<K, V>.C3704m<K, V>> it = this.f13665w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    C3704m next = it.next();
                    n nVar2 = this.f13655m.get(next.m13344a());
                    if (nVar2 == null) {
                        n nVar3 = new n();
                        this.f13655m.put(next.m13344a(), nVar3);
                        this.f13661s.add(next.m13344a());
                        nVar = nVar3;
                    } else {
                        nVar = nVar2;
                    }
                    next.m13349a(nVar);
                    if (!nVar.f13674c.isEmpty()) {
                        it.remove();
                        next.m13350a((C3705o) nVar.f13674c.mo13298b());
                        nVar.m13365c();
                        this.f13657o--;
                        synchronized (next) {
                            next.notify();
                        }
                    } else {
                        if (this.f13646d > 0 && this.f13656n + this.f13657o + this.f13658p >= this.f13646d) {
                            z = true;
                            break;
                        }
                        if ((this.f13645c < 0 || nVar.f13673b + nVar.f13675d < this.f13645c) && (this.f13646d < 0 || this.f13656n + this.f13657o + this.f13658p < this.f13646d)) {
                            it.remove();
                            next.m13351a(true);
                            nVar.m13365c();
                            synchronized (next) {
                                next.notify();
                            }
                        } else if (this.f13645c < 0) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    m13342j();
                }
            }
        }
    }

    @Override // org.p072a.p073a.p074a.AbstractC3693a
    /* renamed from: c */
    public void mo13288c() {
        Map<K, List<C3705o<V>>> map = new HashMap<>();
        synchronized (this) {
            Iterator<K> it = this.f13655m.keySet().iterator();
            while (it.hasNext()) {
                K next = it.next();
                n nVar = this.f13655m.get(next);
                List<C3705o<V>> arrayList = new ArrayList<>();
                arrayList.addAll(nVar.f13674c);
                map.put(next, arrayList);
                it.remove();
                this.f13661s.remove(next);
                this.f13657o -= nVar.f13674c.size();
                this.f13658p += nVar.f13674c.size();
                nVar.f13674c.clear();
            }
        }
        m13325a((Map) map, (InterfaceC3710e) this.f13659q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    public void m13342j() {
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        synchronized (this) {
            for (K k : this.f13655m.keySet()) {
                Iterator<E> it = this.f13655m.get(k).f13674c.iterator();
                while (it.hasNext()) {
                    treeMap.put(it.next(), k);
                }
            }
            Iterator it2 = treeMap.entrySet().iterator();
            for (int size = ((int) (treeMap.size() * 0.15d)) + 1; it2.hasNext() && size > 0; size--) {
                Map.Entry entry = (Map.Entry) it2.next();
                Object value = entry.getValue();
                C3705o c3705o = (C3705o) entry.getKey();
                n nVar = this.f13655m.get(value);
                nVar.f13674c.remove(c3705o);
                if (map.containsKey(value)) {
                    ((List) map.get(value)).add(c3705o);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c3705o);
                    map.put(value, arrayList);
                }
                nVar.m13365c();
                this.f13657o--;
            }
        }
        m13325a((Map) map, (InterfaceC3710e) this.f13659q);
    }

    /* renamed from: a */
    private void m13325a(Map<K, List<C3705o<V>>> map, InterfaceC3710e<K, V> interfaceC3710e) {
        for (Map.Entry<K, List<C3705o<V>>> entry : map.entrySet()) {
            K key = entry.getKey();
            Iterator<C3705o<V>> it = entry.getValue().iterator();
            while (it.hasNext()) {
                try {
                    interfaceC3710e.mo13371b(key, it.next().f13676a);
                    synchronized (this) {
                        n nVar = this.f13655m.get(key);
                        if (nVar != null) {
                            nVar.m13366d();
                            if (nVar.f13675d == 0 && nVar.f13673b == 0 && nVar.f13674c.isEmpty()) {
                                this.f13655m.remove(key);
                                this.f13661s.remove(key);
                            }
                        } else {
                            this.f13658p--;
                        }
                    }
                } catch (Exception e) {
                    synchronized (this) {
                        n nVar2 = this.f13655m.get(key);
                        if (nVar2 != null) {
                            nVar2.m13366d();
                            if (nVar2.f13675d == 0 && nVar2.f13673b == 0 && nVar2.f13674c.isEmpty()) {
                                this.f13655m.remove(key);
                                this.f13661s.remove(key);
                            }
                        } else {
                            this.f13658p--;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        n nVar3 = this.f13655m.get(key);
                        if (nVar3 != null) {
                            nVar3.m13366d();
                            if (nVar3.f13675d == 0 && nVar3.f13673b == 0 && nVar3.f13674c.isEmpty()) {
                                this.f13655m.remove(key);
                                this.f13661s.remove(key);
                            }
                        } else {
                            this.f13658p--;
                        }
                        m13332l();
                        throw th;
                    }
                }
                m13332l();
            }
        }
    }

    @Override // org.p072a.p073a.p074a.AbstractC3693a
    /* renamed from: b */
    public synchronized int mo13287b() {
        return this.f13656n;
    }

    @Override // org.p072a.p073a.p074a.AbstractC3693a
    /* renamed from: a */
    public synchronized int mo13285a() {
        return this.f13657o;
    }

    /* renamed from: a */
    public void m13337a(K k, V v) {
        try {
            m13324a(k, v, true);
        } catch (Exception e) {
            if (this.f13659q != null) {
                try {
                    this.f13659q.mo13371b(k, v);
                } catch (Exception e2) {
                }
                n nVar = this.f13655m.get(k);
                if (nVar != null) {
                    synchronized (this) {
                        nVar.m13364b();
                        if (nVar.f13674c.isEmpty() && nVar.f13673b == 0 && nVar.f13675d == 0) {
                            this.f13655m.remove(k);
                            this.f13661s.remove(k);
                        }
                        m13332l();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m13324a(K k, V v, boolean z) {
        boolean z2;
        C3702j<K, V>.n nVar;
        boolean z3 = false;
        boolean z4 = true;
        if (!this.f13650h || this.f13659q.mo13372c(k, v)) {
            this.f13659q.mo5111a(k, v);
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z5 = !z2;
        synchronized (this) {
            nVar = (n) this.f13655m.get(k);
            if (nVar == null) {
                nVar = new n();
                this.f13655m.put(k, nVar);
                this.f13661s.add(k);
            }
            if (!m13290e() && (this.f13643a < 0 || ((n) nVar).f13674c.size() < this.f13643a)) {
                if (z2) {
                    if (this.f13664v) {
                        ((n) nVar).f13674c.mo13297a((C3694a) new C3705o(v));
                    } else {
                        ((n) nVar).f13674c.mo13302b((C3694a) new C3705o(v));
                    }
                    this.f13657o++;
                    if (z) {
                        nVar.m13364b();
                    }
                    z3 = true;
                    z4 = z5;
                } else {
                    z4 = z5;
                }
            }
        }
        if (z3) {
            m13332l();
        }
        if (z4) {
            try {
                this.f13659q.mo13371b(k, v);
            } catch (Exception e) {
            }
            if (z) {
                synchronized (this) {
                    nVar.m13364b();
                    if (((n) nVar).f13674c.isEmpty() && ((n) nVar).f13673b == 0 && ((n) nVar).f13675d == 0) {
                        this.f13655m.remove(k);
                        this.f13661s.remove(k);
                    }
                }
                m13332l();
            }
        }
    }

    @Override // org.p072a.p073a.p074a.AbstractC3693a
    /* renamed from: a */
    public void mo13286a(K k) {
        m13291f();
        if (this.f13659q == null) {
            throw new IllegalStateException("Cannot add objects without a factory.");
        }
        V vMo5109a = this.f13659q.mo5109a(k);
        try {
            m13291f();
            m13324a(k, vMo5109a, false);
        } catch (IllegalStateException e) {
            try {
                this.f13659q.mo13371b(k, vMo5109a);
            } catch (Exception e2) {
            }
            throw e;
        }
    }

    @Override // org.p072a.p073a.p074a.AbstractC3693a
    /* renamed from: d */
    public void mo13289d() {
        super.mo13289d();
        synchronized (this) {
            mo13288c();
            if (this.f13662t != null) {
                this.f13662t.m13307b();
                this.f13662t = null;
            }
            if (this.f13663u != null) {
                this.f13663u.m13307b();
                this.f13663u = null;
            }
            m13336a(-1L);
            while (this.f13665w.size() > 0) {
                C3704m c3704mRemoveFirst = this.f13665w.removeFirst();
                synchronized (c3704mRemoveFirst) {
                    c3704mRemoveFirst.notify();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0167 A[Catch: all -> 0x005a, TRY_ENTER, TRY_LEAVE, TryCatch #4 {, blocks: (B:13:0x0023, B:15:0x0027, B:22:0x0037, B:24:0x003b, B:25:0x003f, B:27:0x0043, B:29:0x004b, B:37:0x005d, B:39:0x0064, B:41:0x006c, B:30:0x0054, B:32:0x0058, B:42:0x0076, B:44:0x007a, B:50:0x008e, B:52:0x0092, B:54:0x009a, B:55:0x00a4, B:57:0x00a8, B:63:0x00bc, B:59:0x00b0, B:61:0x00b4, B:71:0x00da, B:73:0x00de, B:74:0x00e7, B:75:0x00fd, B:104:0x0167, B:65:0x00c0, B:67:0x00c7, B:69:0x00cf, B:46:0x0082, B:48:0x0086, B:17:0x002f), top: B:131:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01a0 A[PHI: r0
  0x01a0: PHI (r0v24 boolean) = (r0v23 boolean), (r0v23 boolean), (r0v42 boolean) binds: [B:81:0x0111, B:82:0x0113, B:86:0x011e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8 A[Catch: all -> 0x005a, TryCatch #4 {, blocks: (B:13:0x0023, B:15:0x0027, B:22:0x0037, B:24:0x003b, B:25:0x003f, B:27:0x0043, B:29:0x004b, B:37:0x005d, B:39:0x0064, B:41:0x006c, B:30:0x0054, B:32:0x0058, B:42:0x0076, B:44:0x007a, B:50:0x008e, B:52:0x0092, B:54:0x009a, B:55:0x00a4, B:57:0x00a8, B:63:0x00bc, B:59:0x00b0, B:61:0x00b4, B:71:0x00da, B:73:0x00de, B:74:0x00e7, B:75:0x00fd, B:104:0x0167, B:65:0x00c0, B:67:0x00c7, B:69:0x00cf, B:46:0x0082, B:48:0x0086, B:17:0x002f), top: B:131:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b0 A[Catch: all -> 0x005a, TryCatch #4 {, blocks: (B:13:0x0023, B:15:0x0027, B:22:0x0037, B:24:0x003b, B:25:0x003f, B:27:0x0043, B:29:0x004b, B:37:0x005d, B:39:0x0064, B:41:0x006c, B:30:0x0054, B:32:0x0058, B:42:0x0076, B:44:0x007a, B:50:0x008e, B:52:0x0092, B:54:0x009a, B:55:0x00a4, B:57:0x00a8, B:63:0x00bc, B:59:0x00b0, B:61:0x00b4, B:71:0x00da, B:73:0x00de, B:74:0x00e7, B:75:0x00fd, B:104:0x0167, B:65:0x00c0, B:67:0x00c7, B:69:0x00cf, B:46:0x0082, B:48:0x0086, B:17:0x002f), top: B:131:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00de A[Catch: all -> 0x005a, TryCatch #4 {, blocks: (B:13:0x0023, B:15:0x0027, B:22:0x0037, B:24:0x003b, B:25:0x003f, B:27:0x0043, B:29:0x004b, B:37:0x005d, B:39:0x0064, B:41:0x006c, B:30:0x0054, B:32:0x0058, B:42:0x0076, B:44:0x007a, B:50:0x008e, B:52:0x0092, B:54:0x009a, B:55:0x00a4, B:57:0x00a8, B:63:0x00bc, B:59:0x00b0, B:61:0x00b4, B:71:0x00da, B:73:0x00de, B:74:0x00e7, B:75:0x00fd, B:104:0x0167, B:65:0x00c0, B:67:0x00c7, B:69:0x00cf, B:46:0x0082, B:48:0x0086, B:17:0x002f), top: B:131:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0113 A[ADDED_TO_REGION] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m13343k() {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p072a.p073a.p074a.p075a.C3702j.m13343k():void");
    }

    /* renamed from: m */
    private void m13333m() {
        if (this.f13663u != null) {
            this.f13663u.m13307b();
        }
        this.f13663u = this.f13661s.m13292a();
        if (this.f13662t != null) {
            this.f13662t.m13307b();
            this.f13662t = null;
        }
    }

    /* renamed from: c */
    private void m13328c(Object obj) {
        n nVar;
        if (this.f13662t != null) {
            this.f13662t.m13307b();
        }
        if (this.f13655m == null || (nVar = this.f13655m.get(obj)) == null) {
            return;
        }
        C3694a c3694a = nVar.f13674c;
        this.f13662t = c3694a.m13293a(this.f13664v ? c3694a.size() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n */
    public void m13334n() {
        Object[] array;
        if (this.f13644b > 0) {
            synchronized (this) {
                array = this.f13655m.keySet().toArray();
            }
            for (Object obj : array) {
                m13330d((C3702j<K, V>) obj);
            }
        }
    }

    /* renamed from: d */
    private void m13330d(K k) {
        n nVar;
        synchronized (this) {
            nVar = this.f13655m.get(k);
        }
        if (nVar != null) {
            int iM13323a = m13323a(nVar, false);
            for (int i = 0; i < iM13323a && m13323a(nVar, true) > 0; i++) {
                try {
                    mo13286a((C3702j<K, V>) k);
                    synchronized (this) {
                        nVar.m13366d();
                    }
                    m13332l();
                } catch (Throwable th) {
                    synchronized (this) {
                        nVar.m13366d();
                        m13332l();
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected synchronized void m13336a(long j) {
        if (this.f13660r != null) {
            C3698f.m13318a(this.f13660r);
            this.f13660r = null;
        }
        if (j > 0) {
            this.f13660r = new l();
            C3698f.m13319a(this.f13660r, j, j);
        }
    }

    /* renamed from: o */
    private synchronized int m13335o() {
        return this.f13653k >= 0 ? Math.min(this.f13653k, this.f13657o) : (int) Math.ceil(this.f13657o / Math.abs(this.f13653k));
    }

    /* renamed from: a */
    private synchronized int m13323a(C3702j<K, V>.n nVar, boolean z) {
        int iM13341i;
        iM13341i = m13341i() - ((n) nVar).f13674c.size();
        if (m13339g() > 0) {
            iM13341i = Math.min(iM13341i, Math.max(0, ((m13339g() - ((n) nVar).f13673b) - ((n) nVar).f13674c.size()) - ((n) nVar).f13675d));
        }
        if (m13340h() > 0) {
            iM13341i = Math.min(iM13341i, Math.max(0, ((m13340h() - mo13287b()) - mo13285a()) - this.f13658p));
        }
        if (z && iM13341i > 0) {
            nVar.m13365c();
        }
        return iM13341i;
    }

    /* compiled from: GenericKeyedObjectPool.java */
    /* renamed from: org.a.a.a.a.n */
    class n {

        /* renamed from: b */
        private int f13673b;

        /* renamed from: c */
        private final C3694a<C3705o<V>> f13674c;

        /* renamed from: d */
        private int f13675d;

        private n() {
            this.f13673b = 0;
            this.f13674c = new C3694a<>();
            this.f13675d = 0;
        }

        /* renamed from: a */
        void m13363a() {
            synchronized (C3702j.this) {
                C3702j.m13322a(C3702j.this);
            }
            this.f13673b++;
        }

        /* renamed from: b */
        void m13364b() {
            synchronized (C3702j.this) {
                C3702j.m13326b(C3702j.this);
            }
            if (this.f13673b > 0) {
                this.f13673b--;
            }
        }

        /* renamed from: c */
        void m13365c() {
            synchronized (C3702j.this) {
                C3702j.m13327c(C3702j.this);
            }
            this.f13675d++;
        }

        /* renamed from: d */
        void m13366d() {
            synchronized (C3702j.this) {
                C3702j.m13329d(C3702j.this);
            }
            this.f13675d--;
        }
    }

    /* compiled from: GenericKeyedObjectPool.java */
    /* renamed from: org.a.a.a.a.l */
    class l extends TimerTask {
        private l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                C3702j.this.m13343k();
            } catch (Exception e) {
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace(System.err);
            }
            try {
                C3702j.this.m13334n();
            } catch (Exception e3) {
            }
        }
    }
}
