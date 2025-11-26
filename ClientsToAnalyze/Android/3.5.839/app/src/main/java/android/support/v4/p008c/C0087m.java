package android.support.v4.p008c;

import java.util.Map;

/* compiled from: SimpleArrayMap.java */
/* renamed from: android.support.v4.c.m */
/* loaded from: classes.dex */
public class C0087m<K, V> {

    /* renamed from: b */
    static Object[] f269b;

    /* renamed from: c */
    static int f270c;

    /* renamed from: d */
    static Object[] f271d;

    /* renamed from: e */
    static int f272e;

    /* renamed from: f */
    int[] f273f = C0080c.f241a;

    /* renamed from: g */
    Object[] f274g = C0080c.f243c;

    /* renamed from: h */
    int f275h = 0;

    /* renamed from: a */
    int m287a(Object obj, int i) {
        int i2 = this.f275h;
        if (i2 == 0) {
            return -1;
        }
        int iM259a = C0080c.m259a(this.f273f, i2, i);
        if (iM259a >= 0 && !obj.equals(this.f274g[iM259a << 1])) {
            int i3 = iM259a + 1;
            while (i3 < i2 && this.f273f[i3] == i) {
                if (obj.equals(this.f274g[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iM259a - 1; i4 >= 0 && this.f273f[i4] == i; i4--) {
                if (obj.equals(this.f274g[i4 << 1])) {
                    return i4;
                }
            }
            return i3 ^ (-1);
        }
        return iM259a;
    }

    /* renamed from: a */
    int m285a() {
        int i = this.f275h;
        if (i == 0) {
            return -1;
        }
        int iM259a = C0080c.m259a(this.f273f, i, 0);
        if (iM259a >= 0 && this.f274g[iM259a << 1] != null) {
            int i2 = iM259a + 1;
            while (i2 < i && this.f273f[i2] == 0) {
                if (this.f274g[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = iM259a - 1; i3 >= 0 && this.f273f[i3] == 0; i3--) {
                if (this.f274g[i3 << 1] == null) {
                    return i3;
                }
            }
            return i2 ^ (-1);
        }
        return iM259a;
    }

    /* renamed from: e */
    private void m284e(int i) {
        if (i == 8) {
            synchronized (C0078a.class) {
                if (f271d != null) {
                    Object[] objArr = f271d;
                    this.f274g = objArr;
                    f271d = (Object[]) objArr[0];
                    this.f273f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f272e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0078a.class) {
                if (f269b != null) {
                    Object[] objArr2 = f269b;
                    this.f274g = objArr2;
                    f269b = (Object[]) objArr2[0];
                    this.f273f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f270c--;
                    return;
                }
            }
        }
        this.f273f = new int[i];
        this.f274g = new Object[i << 1];
    }

    /* renamed from: a */
    private static void m283a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0078a.class) {
                if (f272e < 10) {
                    objArr[0] = f271d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f271d = objArr;
                    f272e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0078a.class) {
                if (f270c < 10) {
                    objArr[0] = f269b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f269b = objArr;
                    f270c++;
                }
            }
        }
    }

    public void clear() {
        if (this.f275h != 0) {
            m283a(this.f273f, this.f274g, this.f275h);
            this.f273f = C0080c.f241a;
            this.f274g = C0080c.f243c;
            this.f275h = 0;
        }
    }

    /* renamed from: a */
    public void m289a(int i) {
        if (this.f273f.length < i) {
            int[] iArr = this.f273f;
            Object[] objArr = this.f274g;
            m284e(i);
            if (this.f275h > 0) {
                System.arraycopy(iArr, 0, this.f273f, 0, this.f275h);
                System.arraycopy(objArr, 0, this.f274g, 0, this.f275h << 1);
            }
            m283a(iArr, objArr, this.f275h);
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m285a() >= 0 : m287a(obj, obj.hashCode()) >= 0;
    }

    /* renamed from: a */
    int m286a(Object obj) {
        int i = 1;
        int i2 = this.f275h * 2;
        Object[] objArr = this.f274g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] != null) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        } else {
            while (i < i2) {
                if (!obj.equals(objArr[i])) {
                    i += 2;
                } else {
                    return i >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m286a(obj) >= 0;
    }

    public V get(Object obj) {
        int iM285a = obj == null ? m285a() : m287a(obj, obj.hashCode());
        if (iM285a >= 0) {
            return (V) this.f274g[(iM285a << 1) + 1];
        }
        return null;
    }

    /* renamed from: b */
    public K m290b(int i) {
        return (K) this.f274g[i << 1];
    }

    /* renamed from: c */
    public V m291c(int i) {
        return (V) this.f274g[(i << 1) + 1];
    }

    /* renamed from: a */
    public V m288a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.f274g[i2];
        this.f274g[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.f275h <= 0;
    }

    public V put(K k, V v) {
        int iHashCode;
        int iM287a;
        int i = 8;
        if (k == null) {
            iM287a = m285a();
            iHashCode = 0;
        } else {
            iHashCode = k.hashCode();
            iM287a = m287a(k, iHashCode);
        }
        if (iM287a >= 0) {
            int i2 = (iM287a << 1) + 1;
            V v2 = (V) this.f274g[i2];
            this.f274g[i2] = v;
            return v2;
        }
        int i3 = iM287a ^ (-1);
        if (this.f275h >= this.f273f.length) {
            if (this.f275h >= 8) {
                i = this.f275h + (this.f275h >> 1);
            } else if (this.f275h < 4) {
                i = 4;
            }
            int[] iArr = this.f273f;
            Object[] objArr = this.f274g;
            m284e(i);
            if (this.f273f.length > 0) {
                System.arraycopy(iArr, 0, this.f273f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f274g, 0, objArr.length);
            }
            m283a(iArr, objArr, this.f275h);
        }
        if (i3 < this.f275h) {
            System.arraycopy(this.f273f, i3, this.f273f, i3 + 1, this.f275h - i3);
            System.arraycopy(this.f274g, i3 << 1, this.f274g, (i3 + 1) << 1, (this.f275h - i3) << 1);
        }
        this.f273f[i3] = iHashCode;
        this.f274g[i3 << 1] = k;
        this.f274g[(i3 << 1) + 1] = v;
        this.f275h++;
        return null;
    }

    public V remove(Object obj) {
        int iM285a = obj == null ? m285a() : m287a(obj, obj.hashCode());
        if (iM285a >= 0) {
            return m292d(iM285a);
        }
        return null;
    }

    /* renamed from: d */
    public V m292d(int i) {
        V v = (V) this.f274g[(i << 1) + 1];
        if (this.f275h <= 1) {
            m283a(this.f273f, this.f274g, this.f275h);
            this.f273f = C0080c.f241a;
            this.f274g = C0080c.f243c;
            this.f275h = 0;
        } else if (this.f273f.length > 8 && this.f275h < this.f273f.length / 3) {
            int i2 = this.f275h > 8 ? this.f275h + (this.f275h >> 1) : 8;
            int[] iArr = this.f273f;
            Object[] objArr = this.f274g;
            m284e(i2);
            this.f275h--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.f273f, 0, i);
                System.arraycopy(objArr, 0, this.f274g, 0, i << 1);
            }
            if (i < this.f275h) {
                System.arraycopy(iArr, i + 1, this.f273f, i, this.f275h - i);
                System.arraycopy(objArr, (i + 1) << 1, this.f274g, i << 1, (this.f275h - i) << 1);
            }
        } else {
            this.f275h--;
            if (i < this.f275h) {
                System.arraycopy(this.f273f, i + 1, this.f273f, i, this.f275h - i);
                System.arraycopy(this.f274g, (i + 1) << 1, this.f274g, i << 1, (this.f275h - i) << 1);
            }
            this.f274g[this.f275h << 1] = null;
            this.f274g[(this.f275h << 1) + 1] = null;
        }
        return v;
    }

    public int size() {
        return this.f275h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i = 0; i < this.f275h; i++) {
            try {
                K kM290b = m290b(i);
                V vM291c = m291c(i);
                Object obj2 = map.get(kM290b);
                if (vM291c == null) {
                    if (obj2 != null || !map.containsKey(kM290b)) {
                        return false;
                    }
                } else if (!vM291c.equals(obj2)) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f273f;
        Object[] objArr = this.f274g;
        int i = this.f275h;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f275h * 28);
        sb.append('{');
        for (int i = 0; i < this.f275h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kM290b = m290b(i);
            if (kM290b != this) {
                sb.append(kM290b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vM291c = m291c(i);
            if (vM291c != this) {
                sb.append(vM291c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
