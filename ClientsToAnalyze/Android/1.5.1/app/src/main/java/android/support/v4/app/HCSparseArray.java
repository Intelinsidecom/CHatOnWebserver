package android.support.v4.app;

/* loaded from: classes.dex */
public class HCSparseArray {

    /* renamed from: a */
    private static final Object f8a = new Object();

    /* renamed from: b */
    private boolean f9b;

    /* renamed from: c */
    private int[] f10c;

    /* renamed from: d */
    private Object[] f11d;

    /* renamed from: e */
    private int f12e;

    public HCSparseArray() {
        this(10);
    }

    public HCSparseArray(int i) {
        this.f9b = false;
        int iM20h = m20h(i);
        this.f10c = new int[iM20h];
        this.f11d = new Object[iM20h];
        this.f12e = 0;
    }

    /* renamed from: a */
    private static int m17a(int[] iArr, int i, int i2, int i3) {
        int i4 = i + i2;
        int i5 = i - 1;
        while (i4 - i5 > 1) {
            int i6 = (i4 + i5) / 2;
            if (iArr[i6] < i3) {
                i5 = i6;
            } else {
                i4 = i6;
            }
        }
        return i4 == i + i2 ? (i + i2) ^ (-1) : iArr[i4] == i3 ? i4 : i4 ^ (-1);
    }

    /* renamed from: c */
    private void m18c() {
        int i = this.f12e;
        int[] iArr = this.f10c;
        Object[] objArr = this.f11d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f8a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                }
                i2++;
            }
        }
        this.f9b = false;
        this.f12e = i2;
    }

    /* renamed from: g */
    static int m19g(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: h */
    static int m20h(int i) {
        return m19g(i * 4) / 4;
    }

    /* renamed from: a */
    public int m21a() {
        if (this.f9b) {
            m18c();
        }
        return this.f12e;
    }

    /* renamed from: a */
    public Object m22a(int i) {
        return m23a(i, null);
    }

    /* renamed from: a */
    public Object m23a(int i, Object obj) {
        int iM17a = m17a(this.f10c, 0, this.f12e, i);
        return (iM17a < 0 || this.f11d[iM17a] == f8a) ? obj : this.f11d[iM17a];
    }

    /* renamed from: b */
    public void m24b() {
        int i = this.f12e;
        Object[] objArr = this.f11d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f12e = 0;
        this.f9b = false;
    }

    /* renamed from: b */
    public void m25b(int i) {
        int iM17a = m17a(this.f10c, 0, this.f12e, i);
        if (iM17a < 0 || this.f11d[iM17a] == f8a) {
            return;
        }
        this.f11d[iM17a] = f8a;
        this.f9b = true;
    }

    /* renamed from: b */
    public void m26b(int i, Object obj) {
        int iM17a = m17a(this.f10c, 0, this.f12e, i);
        if (iM17a >= 0) {
            this.f11d[iM17a] = obj;
            return;
        }
        int iM17a2 = iM17a ^ (-1);
        if (iM17a2 < this.f12e && this.f11d[iM17a2] == f8a) {
            this.f10c[iM17a2] = i;
            this.f11d[iM17a2] = obj;
            return;
        }
        if (this.f9b && this.f12e >= this.f10c.length) {
            m18c();
            iM17a2 = m17a(this.f10c, 0, this.f12e, i) ^ (-1);
        }
        if (this.f12e >= this.f10c.length) {
            int iM20h = m20h(this.f12e + 1);
            int[] iArr = new int[iM20h];
            Object[] objArr = new Object[iM20h];
            System.arraycopy(this.f10c, 0, iArr, 0, this.f10c.length);
            System.arraycopy(this.f11d, 0, objArr, 0, this.f11d.length);
            this.f10c = iArr;
            this.f11d = objArr;
        }
        if (this.f12e - iM17a2 != 0) {
            System.arraycopy(this.f10c, iM17a2, this.f10c, iM17a2 + 1, this.f12e - iM17a2);
            System.arraycopy(this.f11d, iM17a2, this.f11d, iM17a2 + 1, this.f12e - iM17a2);
        }
        this.f10c[iM17a2] = i;
        this.f11d[iM17a2] = obj;
        this.f12e++;
    }

    /* renamed from: c */
    public void m27c(int i) {
        m25b(i);
    }

    /* renamed from: d */
    public void m28d(int i) {
        if (this.f11d[i] != f8a) {
            this.f11d[i] = f8a;
            this.f9b = true;
        }
    }

    /* renamed from: e */
    public int m29e(int i) {
        if (this.f9b) {
            m18c();
        }
        return this.f10c[i];
    }

    /* renamed from: f */
    public Object m30f(int i) {
        if (this.f9b) {
            m18c();
        }
        return this.f11d[i];
    }
}
