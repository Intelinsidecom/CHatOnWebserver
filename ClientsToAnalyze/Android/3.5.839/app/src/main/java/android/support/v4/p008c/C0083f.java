package android.support.v4.p008c;

import java.util.LinkedHashMap;

/* compiled from: LruCache.java */
/* renamed from: android.support.v4.c.f */
/* loaded from: classes.dex */
public class C0083f<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f246a;

    /* renamed from: b */
    private int f247b;

    /* renamed from: c */
    private int f248c;

    /* renamed from: d */
    private int f249d;

    /* renamed from: e */
    private int f250e;

    /* renamed from: f */
    private int f251f;

    /* renamed from: g */
    private int f252g;

    /* renamed from: h */
    private int f253h;

    public C0083f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f248c = i;
        this.f246a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* renamed from: a */
    public final V m265a(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v2 = this.f246a.get(k);
            if (v2 != null) {
                this.f252g++;
                return v2;
            }
            this.f253h++;
            V vM271b = m271b(k);
            if (vM271b == null) {
                return null;
            }
            synchronized (this) {
                this.f250e++;
                v = (V) this.f246a.put(k, vM271b);
                if (v != null) {
                    this.f246a.put(k, v);
                } else {
                    this.f247b += m264c(k, vM271b);
                }
            }
            if (v != null) {
                m269a(false, k, vM271b, v);
                return v;
            }
            m268a(this.f248c);
            return vM271b;
        }
    }

    /* renamed from: a */
    public final V m266a(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f249d++;
            this.f247b += m264c(k, v);
            vPut = this.f246a.put(k, v);
            if (vPut != null) {
                this.f247b -= m264c(k, vPut);
            }
        }
        if (vPut != null) {
            m269a(false, k, vPut, v);
        }
        m268a(this.f248c);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m268a(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.f247b     // Catch: java.lang.Throwable -> L33
            if (r0 < 0) goto L11
            java.util.LinkedHashMap<K, V> r0 = r4.f246a     // Catch: java.lang.Throwable -> L33
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L36
            int r0 = r4.f247b     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L36
        L11:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L33
            r1.<init>()     // Catch: java.lang.Throwable -> L33
            java.lang.Class r2 = r4.getClass()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L33
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L33
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L33
            throw r0     // Catch: java.lang.Throwable -> L33
        L33:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L33
            throw r0
        L36:
            int r0 = r4.f247b     // Catch: java.lang.Throwable -> L33
            if (r0 <= r5) goto L42
            java.util.LinkedHashMap<K, V> r0 = r4.f246a     // Catch: java.lang.Throwable -> L33
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L44
        L42:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L33
            return
        L44:
            java.util.LinkedHashMap<K, V> r0 = r4.f246a     // Catch: java.lang.Throwable -> L33
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L33
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L33
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L33
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L33
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L33
            java.util.LinkedHashMap<K, V> r2 = r4.f246a     // Catch: java.lang.Throwable -> L33
            r2.remove(r1)     // Catch: java.lang.Throwable -> L33
            int r2 = r4.f247b     // Catch: java.lang.Throwable -> L33
            int r3 = r4.m264c(r1, r0)     // Catch: java.lang.Throwable -> L33
            int r2 = r2 - r3
            r4.f247b = r2     // Catch: java.lang.Throwable -> L33
            int r2 = r4.f251f     // Catch: java.lang.Throwable -> L33
            int r2 = r2 + 1
            r4.f251f = r2     // Catch: java.lang.Throwable -> L33
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L33
            r2 = 1
            r3 = 0
            r4.m269a(r2, r1, r0, r3)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.p008c.C0083f.m268a(int):void");
    }

    /* renamed from: a */
    protected void m269a(boolean z, K k, V v, V v2) {
    }

    /* renamed from: b */
    protected V m271b(K k) {
        return null;
    }

    /* renamed from: c */
    private int m264c(K k, V v) {
        int iM270b = m270b(k, v);
        if (iM270b < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return iM270b;
    }

    /* renamed from: b */
    protected int m270b(K k, V v) {
        return 1;
    }

    /* renamed from: a */
    public final void m267a() {
        m268a(-1);
    }

    public final synchronized String toString() {
        String str;
        synchronized (this) {
            int i = this.f252g + this.f253h;
            str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f248c), Integer.valueOf(this.f252g), Integer.valueOf(this.f253h), Integer.valueOf(i != 0 ? (this.f252g * 100) / i : 0));
        }
        return str;
    }
}
