package android.support.v4.p008c;

/* compiled from: SparseArrayCompat.java */
/* renamed from: android.support.v4.c.n */
/* loaded from: classes.dex */
public class C0088n<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f276a = new Object();

    /* renamed from: b */
    private boolean f277b;

    /* renamed from: c */
    private int[] f278c;

    /* renamed from: d */
    private Object[] f279d;

    /* renamed from: e */
    private int f280e;

    public C0088n() {
        this(10);
    }

    public C0088n(int i) {
        this.f277b = false;
        if (i == 0) {
            this.f278c = C0080c.f241a;
            this.f279d = C0080c.f243c;
        } else {
            int iM258a = C0080c.m258a(i);
            this.f278c = new int[iM258a];
            this.f279d = new Object[iM258a];
        }
        this.f280e = 0;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0088n<E> clone() {
        try {
            C0088n<E> c0088n = (C0088n) super.clone();
            try {
                c0088n.f278c = (int[]) this.f278c.clone();
                c0088n.f279d = (Object[]) this.f279d.clone();
                return c0088n;
            } catch (CloneNotSupportedException e) {
                return c0088n;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public E m295a(int i) {
        return m296a(i, null);
    }

    /* renamed from: a */
    public E m296a(int i, E e) {
        int iM259a = C0080c.m259a(this.f278c, this.f280e, i);
        return (iM259a < 0 || this.f279d[iM259a] == f276a) ? e : (E) this.f279d[iM259a];
    }

    /* renamed from: b */
    public void m298b(int i) {
        int iM259a = C0080c.m259a(this.f278c, this.f280e, i);
        if (iM259a >= 0 && this.f279d[iM259a] != f276a) {
            this.f279d[iM259a] = f276a;
            this.f277b = true;
        }
    }

    /* renamed from: c */
    public void m301c(int i) {
        m298b(i);
    }

    /* renamed from: d */
    public void m302d(int i) {
        if (this.f279d[i] != f276a) {
            this.f279d[i] = f276a;
            this.f277b = true;
        }
    }

    /* renamed from: d */
    private void m293d() {
        int i = this.f280e;
        int[] iArr = this.f278c;
        Object[] objArr = this.f279d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f276a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f277b = false;
        this.f280e = i2;
    }

    /* renamed from: b */
    public void m299b(int i, E e) {
        int iM259a = C0080c.m259a(this.f278c, this.f280e, i);
        if (iM259a >= 0) {
            this.f279d[iM259a] = e;
            return;
        }
        int iM259a2 = iM259a ^ (-1);
        if (iM259a2 < this.f280e && this.f279d[iM259a2] == f276a) {
            this.f278c[iM259a2] = i;
            this.f279d[iM259a2] = e;
            return;
        }
        if (this.f277b && this.f280e >= this.f278c.length) {
            m293d();
            iM259a2 = C0080c.m259a(this.f278c, this.f280e, i) ^ (-1);
        }
        if (this.f280e >= this.f278c.length) {
            int iM258a = C0080c.m258a(this.f280e + 1);
            int[] iArr = new int[iM258a];
            Object[] objArr = new Object[iM258a];
            System.arraycopy(this.f278c, 0, iArr, 0, this.f278c.length);
            System.arraycopy(this.f279d, 0, objArr, 0, this.f279d.length);
            this.f278c = iArr;
            this.f279d = objArr;
        }
        if (this.f280e - iM259a2 != 0) {
            System.arraycopy(this.f278c, iM259a2, this.f278c, iM259a2 + 1, this.f280e - iM259a2);
            System.arraycopy(this.f279d, iM259a2, this.f279d, iM259a2 + 1, this.f280e - iM259a2);
        }
        this.f278c[iM259a2] = i;
        this.f279d[iM259a2] = e;
        this.f280e++;
    }

    /* renamed from: b */
    public int m297b() {
        if (this.f277b) {
            m293d();
        }
        return this.f280e;
    }

    /* renamed from: e */
    public int m303e(int i) {
        if (this.f277b) {
            m293d();
        }
        return this.f278c[i];
    }

    /* renamed from: f */
    public E m304f(int i) {
        if (this.f277b) {
            m293d();
        }
        return (E) this.f279d[i];
    }

    /* renamed from: g */
    public int m305g(int i) {
        if (this.f277b) {
            m293d();
        }
        return C0080c.m259a(this.f278c, this.f280e, i);
    }

    /* renamed from: c */
    public void m300c() {
        int i = this.f280e;
        Object[] objArr = this.f279d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f280e = 0;
        this.f277b = false;
    }

    public String toString() {
        if (m297b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f280e * 28);
        sb.append('{');
        for (int i = 0; i < this.f280e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m303e(i));
            sb.append('=');
            E eM304f = m304f(i);
            if (eM304f != this) {
                sb.append(eM304f);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
