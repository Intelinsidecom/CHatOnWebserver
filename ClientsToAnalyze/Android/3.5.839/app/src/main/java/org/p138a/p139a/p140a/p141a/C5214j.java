package org.p138a.p139a.p140a.p141a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TimerTask;
import java.util.TreeMap;
import org.p138a.p139a.p140a.AbstractC5205a;
import org.p138a.p139a.p140a.C5224g;
import org.p138a.p139a.p140a.InterfaceC5222e;

/* compiled from: GenericKeyedObjectPool.java */
/* renamed from: org.a.a.a.a.j */
/* loaded from: classes.dex */
public class C5214j<K, V> extends AbstractC5205a<K, V> {

    /* renamed from: a */
    private int f18998a;

    /* renamed from: b */
    private volatile int f18999b;

    /* renamed from: c */
    private int f19000c;

    /* renamed from: d */
    private int f19001d;

    /* renamed from: e */
    private long f19002e;

    /* renamed from: f */
    private byte f19003f;

    /* renamed from: g */
    private volatile boolean f19004g;

    /* renamed from: h */
    private volatile boolean f19005h;

    /* renamed from: i */
    private boolean f19006i;

    /* renamed from: j */
    private long f19007j;

    /* renamed from: k */
    private int f19008k;

    /* renamed from: l */
    private long f19009l;

    /* renamed from: m */
    private Map<K, C5214j<K, V>.n> f19010m;

    /* renamed from: n */
    private int f19011n;

    /* renamed from: o */
    private int f19012o;

    /* renamed from: p */
    private int f19013p;

    /* renamed from: q */
    private InterfaceC5222e<K, V> f19014q;

    /* renamed from: r */
    private C5214j<K, V>.l f19015r;

    /* renamed from: s */
    private C5206a<K> f19016s;

    /* renamed from: t */
    private C5206a<C5217o<V>>.b f19017t;

    /* renamed from: u */
    private C5206a<K>.b f19018u;

    /* renamed from: v */
    private boolean f19019v;

    /* renamed from: w */
    private LinkedList<C5214j<K, V>.C5216m<K, V>> f19020w;

    /* renamed from: a */
    static /* synthetic */ int m19850a(C5214j c5214j) {
        int i = c5214j.f19011n;
        c5214j.f19011n = i + 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ int m19854b(C5214j c5214j) {
        int i = c5214j.f19011n;
        c5214j.f19011n = i - 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m19855c(C5214j c5214j) {
        int i = c5214j.f19013p;
        c5214j.f19013p = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m19857d(C5214j c5214j) {
        int i = c5214j.f19013p;
        c5214j.f19013p = i - 1;
        return i;
    }

    public C5214j() {
        this(null, 8, (byte) 1, -1L, 8, false, false, -1L, 3, 1800000L, false);
    }

    public C5214j(InterfaceC5222e<K, V> interfaceC5222e, int i, byte b2, long j) {
        this(interfaceC5222e, i, b2, j, 8, false, false, -1L, 3, 1800000L, false);
    }

    public C5214j(InterfaceC5222e<K, V> interfaceC5222e, int i, byte b2, long j, int i2, boolean z, boolean z2, long j2, int i3, long j3, boolean z3) {
        this(interfaceC5222e, i, b2, j, i2, -1, z, z2, j2, i3, j3, z3);
    }

    public C5214j(InterfaceC5222e<K, V> interfaceC5222e, int i, byte b2, long j, int i2, int i3, boolean z, boolean z2, long j2, int i4, long j3, boolean z3) {
        this(interfaceC5222e, i, b2, j, i2, i3, 0, z, z2, j2, i4, j3, z3);
    }

    public C5214j(InterfaceC5222e<K, V> interfaceC5222e, int i, byte b2, long j, int i2, int i3, int i4, boolean z, boolean z2, long j2, int i5, long j3, boolean z3) {
        this(interfaceC5222e, i, b2, j, i2, i3, i4, z, z2, j2, i5, j3, z3, true);
    }

    public C5214j(InterfaceC5222e<K, V> interfaceC5222e, int i, byte b2, long j, int i2, int i3, int i4, boolean z, boolean z2, long j2, int i5, long j3, boolean z3, boolean z4) {
        this.f18998a = 8;
        this.f18999b = 0;
        this.f19000c = 8;
        this.f19001d = -1;
        this.f19002e = -1L;
        this.f19003f = (byte) 1;
        this.f19004g = false;
        this.f19005h = false;
        this.f19006i = false;
        this.f19007j = -1L;
        this.f19008k = 3;
        this.f19009l = 1800000L;
        this.f19010m = null;
        this.f19011n = 0;
        this.f19012o = 0;
        this.f19013p = 0;
        this.f19014q = null;
        this.f19015r = null;
        this.f19016s = null;
        this.f19017t = null;
        this.f19018u = null;
        this.f19019v = true;
        this.f19020w = new LinkedList<>();
        this.f19014q = interfaceC5222e;
        this.f19000c = i;
        this.f19019v = z4;
        switch (b2) {
            case 0:
            case 1:
            case 2:
                this.f19003f = b2;
                this.f19002e = j;
                this.f18998a = i2;
                this.f19001d = i3;
                this.f18999b = i4;
                this.f19004g = z;
                this.f19005h = z2;
                this.f19007j = j2;
                this.f19008k = i5;
                this.f19009l = j3;
                this.f19006i = z3;
                this.f19010m = new HashMap();
                this.f19016s = new C5206a<>();
                m19864a(this.f19007j);
                return;
            default:
                throw new IllegalArgumentException("whenExhaustedAction " + ((int) b2) + " not recognized.");
        }
    }

    /* renamed from: g */
    public synchronized int m19867g() {
        return this.f19000c;
    }

    /* renamed from: h */
    public synchronized int m19868h() {
        return this.f19001d;
    }

    /* renamed from: i */
    public int m19869i() {
        return this.f18999b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public V m19866b(K k) {
        byte b2;
        long j;
        boolean z;
        boolean z2 = false;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C5214j<K, V>.C5216m<K, V> c5216m = new C5216m<>(this, k);
        synchronized (this) {
            b2 = this.f19003f;
            j = this.f19002e;
            this.f19020w.add(c5216m);
        }
        m19860l();
        while (true) {
            synchronized (this) {
                m19819f();
            }
            if (c5216m.m19883c() == null && !c5216m.m19885d()) {
                switch (b2) {
                    case 0:
                        synchronized (this) {
                            if (c5216m.m19883c() == null && !c5216m.m19885d()) {
                                this.f19020w.remove(c5216m);
                                throw new NoSuchElementException("Pool exhausted");
                            }
                            break;
                        }
                        break;
                    case 1:
                        try {
                            synchronized (c5216m) {
                                if (c5216m.m19883c() != null || c5216m.m19885d()) {
                                    break;
                                } else {
                                    if (j <= 0) {
                                        c5216m.wait();
                                    } else {
                                        long jCurrentTimeMillis2 = j - (System.currentTimeMillis() - jCurrentTimeMillis);
                                        if (jCurrentTimeMillis2 > 0) {
                                            c5216m.wait(jCurrentTimeMillis2);
                                        }
                                    }
                                    if (m19818e()) {
                                        throw new IllegalStateException("Pool closed");
                                    }
                                    if (j > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= j) {
                                        synchronized (this) {
                                            if (c5216m.m19883c() == null && !c5216m.m19885d()) {
                                                this.f19020w.remove(c5216m);
                                                throw new NoSuchElementException("Timeout waiting for idle object");
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (InterruptedException e) {
                            synchronized (this) {
                                if (c5216m.m19883c() == null && !c5216m.m19885d()) {
                                    this.f19020w.remove(c5216m);
                                } else if (c5216m.m19883c() != null || !c5216m.m19885d()) {
                                    c5216m.m19880b().m19894d();
                                    c5216m.m19880b().m19891a();
                                    m19865a((C5214j<K, V>) c5216m.m19872a(), c5216m.m19883c().m19896a());
                                } else {
                                    c5216m.m19880b().m19894d();
                                    z2 = true;
                                }
                                if (z2) {
                                    m19860l();
                                }
                                Thread.currentThread().interrupt();
                                throw e;
                            }
                        }
                        break;
                    case 2:
                        synchronized (this) {
                            if (c5216m.m19883c() == null && !c5216m.m19885d()) {
                                this.f19020w.remove(c5216m);
                                c5216m.m19880b().m19893c();
                            }
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("whenExhaustedAction " + ((int) b2) + " not recognized.");
                }
            }
            if (c5216m.m19883c() == null) {
                try {
                    c5216m.m19878a(new C5217o(this.f19014q.mo8431a(k)));
                    z = true;
                } catch (Throwable th) {
                    synchronized (this) {
                        c5216m.m19880b().m19894d();
                        m19860l();
                        throw th;
                    }
                }
            } else {
                z = false;
            }
            try {
                this.f19014q.mo19901d(k, c5216m.m19883c().f19031a);
                if (this.f19004g && !this.f19014q.mo19900c(k, c5216m.m19883c().f19031a)) {
                    throw new Exception("ValidateObject failed");
                }
                synchronized (this) {
                    c5216m.m19880b().m19894d();
                    c5216m.m19880b().m19891a();
                }
                return (V) c5216m.m19883c().f19031a;
            } catch (Throwable th2) {
                C5224g.m19907a(th2);
                try {
                    this.f19014q.mo19899b(k, c5216m.m19883c().f19031a);
                } catch (Throwable th3) {
                    C5224g.m19907a(th3);
                }
                synchronized (this) {
                    c5216m.m19880b().m19894d();
                    if (!z) {
                        c5216m.m19886e();
                        this.f19020w.add(0, c5216m);
                    }
                    m19860l();
                    if (z) {
                        throw new NoSuchElementException("Could not create a validated object, cause: " + th2.getMessage());
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l */
    private void m19860l() {
        boolean z;
        n nVar;
        synchronized (this) {
            if (!m19818e()) {
                Iterator<C5214j<K, V>.C5216m<K, V>> it = this.f19020w.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    C5216m next = it.next();
                    n nVar2 = this.f19010m.get(next.m19872a());
                    if (nVar2 == null) {
                        n nVar3 = new n();
                        this.f19010m.put(next.m19872a(), nVar3);
                        this.f19016s.add(next.m19872a());
                        nVar = nVar3;
                    } else {
                        nVar = nVar2;
                    }
                    next.m19877a(nVar);
                    if (!nVar.f19029c.isEmpty()) {
                        it.remove();
                        next.m19878a((C5217o) nVar.f19029c.mo19826b());
                        nVar.m19893c();
                        this.f19012o--;
                        synchronized (next) {
                            next.notify();
                        }
                    } else {
                        if (this.f19001d > 0 && this.f19011n + this.f19012o + this.f19013p >= this.f19001d) {
                            z = true;
                            break;
                        }
                        if ((this.f19000c < 0 || nVar.f19028b + nVar.f19030d < this.f19000c) && (this.f19001d < 0 || this.f19011n + this.f19012o + this.f19013p < this.f19001d)) {
                            it.remove();
                            next.m19879a(true);
                            nVar.m19893c();
                            synchronized (next) {
                                next.notify();
                            }
                        } else if (this.f19000c < 0) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    m19870j();
                }
            }
        }
    }

    @Override // org.p138a.p139a.p140a.AbstractC5205a
    /* renamed from: c */
    public void mo19816c() {
        Map<K, List<C5217o<V>>> map = new HashMap<>();
        synchronized (this) {
            Iterator<K> it = this.f19010m.keySet().iterator();
            while (it.hasNext()) {
                K next = it.next();
                n nVar = this.f19010m.get(next);
                List<C5217o<V>> arrayList = new ArrayList<>();
                arrayList.addAll(nVar.f19029c);
                map.put(next, arrayList);
                it.remove();
                this.f19016s.remove(next);
                this.f19012o -= nVar.f19029c.size();
                this.f19013p += nVar.f19029c.size();
                nVar.f19029c.clear();
            }
        }
        m19853a((Map) map, (InterfaceC5222e) this.f19014q);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: j */
    public void m19870j() {
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        synchronized (this) {
            for (K k : this.f19010m.keySet()) {
                Iterator<E> it = this.f19010m.get(k).f19029c.iterator();
                while (it.hasNext()) {
                    treeMap.put(it.next(), k);
                }
            }
            Iterator it2 = treeMap.entrySet().iterator();
            for (int size = ((int) (treeMap.size() * 0.15d)) + 1; it2.hasNext() && size > 0; size--) {
                Map.Entry entry = (Map.Entry) it2.next();
                Object value = entry.getValue();
                C5217o c5217o = (C5217o) entry.getKey();
                n nVar = this.f19010m.get(value);
                nVar.f19029c.remove(c5217o);
                if (map.containsKey(value)) {
                    ((List) map.get(value)).add(c5217o);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c5217o);
                    map.put(value, arrayList);
                }
                nVar.m19893c();
                this.f19012o--;
            }
        }
        m19853a((Map) map, (InterfaceC5222e) this.f19014q);
    }

    /* renamed from: a */
    private void m19853a(Map<K, List<C5217o<V>>> map, InterfaceC5222e<K, V> interfaceC5222e) {
        for (Map.Entry<K, List<C5217o<V>>> entry : map.entrySet()) {
            K key = entry.getKey();
            Iterator<C5217o<V>> it = entry.getValue().iterator();
            while (it.hasNext()) {
                try {
                    interfaceC5222e.mo19899b(key, it.next().f19031a);
                    synchronized (this) {
                        n nVar = this.f19010m.get(key);
                        if (nVar != null) {
                            nVar.m19894d();
                            if (nVar.f19030d == 0 && nVar.f19028b == 0 && nVar.f19029c.isEmpty()) {
                                this.f19010m.remove(key);
                                this.f19016s.remove(key);
                            }
                        } else {
                            this.f19013p--;
                        }
                    }
                } catch (Exception e) {
                    synchronized (this) {
                        n nVar2 = this.f19010m.get(key);
                        if (nVar2 != null) {
                            nVar2.m19894d();
                            if (nVar2.f19030d == 0 && nVar2.f19028b == 0 && nVar2.f19029c.isEmpty()) {
                                this.f19010m.remove(key);
                                this.f19016s.remove(key);
                            }
                        } else {
                            this.f19013p--;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        n nVar3 = this.f19010m.get(key);
                        if (nVar3 != null) {
                            nVar3.m19894d();
                            if (nVar3.f19030d == 0 && nVar3.f19028b == 0 && nVar3.f19029c.isEmpty()) {
                                this.f19010m.remove(key);
                                this.f19016s.remove(key);
                            }
                        } else {
                            this.f19013p--;
                        }
                        m19860l();
                        throw th;
                    }
                }
                m19860l();
            }
        }
    }

    @Override // org.p138a.p139a.p140a.AbstractC5205a
    /* renamed from: b */
    public synchronized int mo19815b() {
        return this.f19011n;
    }

    @Override // org.p138a.p139a.p140a.AbstractC5205a
    /* renamed from: a */
    public synchronized int mo19813a() {
        return this.f19012o;
    }

    /* renamed from: a */
    public void m19865a(K k, V v) {
        try {
            m19852a(k, v, true);
        } catch (Exception e) {
            if (this.f19014q != null) {
                try {
                    this.f19014q.mo19899b(k, v);
                } catch (Exception e2) {
                }
                n nVar = this.f19010m.get(k);
                if (nVar != null) {
                    synchronized (this) {
                        nVar.m19892b();
                        if (nVar.f19029c.isEmpty() && nVar.f19028b == 0 && nVar.f19030d == 0) {
                            this.f19010m.remove(k);
                            this.f19016s.remove(k);
                        }
                        m19860l();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m19852a(K k, V v, boolean z) {
        boolean z2;
        C5214j<K, V>.n nVar;
        boolean z3 = false;
        boolean z4 = true;
        if (!this.f19005h || this.f19014q.mo19900c(k, v)) {
            this.f19014q.mo8433a(k, v);
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z5 = !z2;
        synchronized (this) {
            nVar = (n) this.f19010m.get(k);
            if (nVar == null) {
                nVar = new n();
                this.f19010m.put(k, nVar);
                this.f19016s.add(k);
            }
            if (!m19818e() && (this.f18998a < 0 || ((n) nVar).f19029c.size() < this.f18998a)) {
                if (z2) {
                    if (this.f19019v) {
                        ((n) nVar).f19029c.mo19825a((C5206a) new C5217o(v));
                    } else {
                        ((n) nVar).f19029c.mo19830b((C5206a) new C5217o(v));
                    }
                    this.f19012o++;
                    if (z) {
                        nVar.m19892b();
                    }
                    z3 = true;
                    z4 = z5;
                } else {
                    z4 = z5;
                }
            }
        }
        if (z3) {
            m19860l();
        }
        if (z4) {
            try {
                this.f19014q.mo19899b(k, v);
            } catch (Exception e) {
            }
            if (z) {
                synchronized (this) {
                    nVar.m19892b();
                    if (((n) nVar).f19029c.isEmpty() && ((n) nVar).f19028b == 0 && ((n) nVar).f19030d == 0) {
                        this.f19010m.remove(k);
                        this.f19016s.remove(k);
                    }
                }
                m19860l();
            }
        }
    }

    @Override // org.p138a.p139a.p140a.AbstractC5205a
    /* renamed from: a */
    public void mo19814a(K k) {
        m19819f();
        if (this.f19014q == null) {
            throw new IllegalStateException("Cannot add objects without a factory.");
        }
        V vMo8431a = this.f19014q.mo8431a(k);
        try {
            m19819f();
            m19852a(k, vMo8431a, false);
        } catch (IllegalStateException e) {
            try {
                this.f19014q.mo19899b(k, vMo8431a);
            } catch (Exception e2) {
            }
            throw e;
        }
    }

    @Override // org.p138a.p139a.p140a.AbstractC5205a
    /* renamed from: d */
    public void mo19817d() {
        super.mo19817d();
        synchronized (this) {
            mo19816c();
            if (this.f19017t != null) {
                this.f19017t.m19835b();
                this.f19017t = null;
            }
            if (this.f19018u != null) {
                this.f19018u.m19835b();
                this.f19018u = null;
            }
            m19864a(-1L);
            while (this.f19020w.size() > 0) {
                C5216m c5216mRemoveFirst = this.f19020w.removeFirst();
                synchronized (c5216mRemoveFirst) {
                    c5216mRemoveFirst.notify();
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
    public void m19871k() {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.p138a.p139a.p140a.p141a.C5214j.m19871k():void");
    }

    /* renamed from: m */
    private void m19861m() {
        if (this.f19018u != null) {
            this.f19018u.m19835b();
        }
        this.f19018u = this.f19016s.m19820a();
        if (this.f19017t != null) {
            this.f19017t.m19835b();
            this.f19017t = null;
        }
    }

    /* renamed from: c */
    private void m19856c(Object obj) {
        n nVar;
        if (this.f19017t != null) {
            this.f19017t.m19835b();
        }
        if (this.f19010m == null || (nVar = this.f19010m.get(obj)) == null) {
            return;
        }
        C5206a c5206a = nVar.f19029c;
        this.f19017t = c5206a.m19821a(this.f19019v ? c5206a.size() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: n */
    public void m19862n() {
        Object[] array;
        if (this.f18999b > 0) {
            synchronized (this) {
                array = this.f19010m.keySet().toArray();
            }
            for (Object obj : array) {
                m19858d((C5214j<K, V>) obj);
            }
        }
    }

    /* renamed from: d */
    private void m19858d(K k) {
        n nVar;
        synchronized (this) {
            nVar = this.f19010m.get(k);
        }
        if (nVar != null) {
            int iM19851a = m19851a(nVar, false);
            for (int i = 0; i < iM19851a && m19851a(nVar, true) > 0; i++) {
                try {
                    mo19814a((C5214j<K, V>) k);
                    synchronized (this) {
                        nVar.m19894d();
                    }
                    m19860l();
                } catch (Throwable th) {
                    synchronized (this) {
                        nVar.m19894d();
                        m19860l();
                        throw th;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    protected synchronized void m19864a(long j) {
        if (this.f19015r != null) {
            C5210f.m19846a(this.f19015r);
            this.f19015r = null;
        }
        if (j > 0) {
            this.f19015r = new l();
            C5210f.m19847a(this.f19015r, j, j);
        }
    }

    /* renamed from: o */
    private synchronized int m19863o() {
        return this.f19008k >= 0 ? Math.min(this.f19008k, this.f19012o) : (int) Math.ceil(this.f19012o / Math.abs(this.f19008k));
    }

    /* renamed from: a */
    private synchronized int m19851a(C5214j<K, V>.n nVar, boolean z) {
        int iM19869i;
        iM19869i = m19869i() - ((n) nVar).f19029c.size();
        if (m19867g() > 0) {
            iM19869i = Math.min(iM19869i, Math.max(0, ((m19867g() - ((n) nVar).f19028b) - ((n) nVar).f19029c.size()) - ((n) nVar).f19030d));
        }
        if (m19868h() > 0) {
            iM19869i = Math.min(iM19869i, Math.max(0, ((m19868h() - mo19815b()) - mo19813a()) - this.f19013p));
        }
        if (z && iM19869i > 0) {
            nVar.m19893c();
        }
        return iM19869i;
    }

    /* compiled from: GenericKeyedObjectPool.java */
    /* renamed from: org.a.a.a.a.n */
    class n {

        /* renamed from: b */
        private int f19028b;

        /* renamed from: c */
        private final C5206a<C5217o<V>> f19029c;

        /* renamed from: d */
        private int f19030d;

        private n() {
            this.f19028b = 0;
            this.f19029c = new C5206a<>();
            this.f19030d = 0;
        }

        /* renamed from: a */
        void m19891a() {
            synchronized (C5214j.this) {
                C5214j.m19850a(C5214j.this);
            }
            this.f19028b++;
        }

        /* renamed from: b */
        void m19892b() {
            synchronized (C5214j.this) {
                C5214j.m19854b(C5214j.this);
            }
            if (this.f19028b > 0) {
                this.f19028b--;
            }
        }

        /* renamed from: c */
        void m19893c() {
            synchronized (C5214j.this) {
                C5214j.m19855c(C5214j.this);
            }
            this.f19030d++;
        }

        /* renamed from: d */
        void m19894d() {
            synchronized (C5214j.this) {
                C5214j.m19857d(C5214j.this);
            }
            this.f19030d--;
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
                C5214j.this.m19871k();
            } catch (Exception e) {
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace(System.err);
            }
            try {
                C5214j.this.m19862n();
            } catch (Exception e3) {
            }
        }
    }
}
