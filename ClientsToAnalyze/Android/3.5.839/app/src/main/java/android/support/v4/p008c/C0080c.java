package android.support.v4.p008c;

/* compiled from: ContainerHelpers.java */
/* renamed from: android.support.v4.c.c */
/* loaded from: classes.dex */
class C0080c {

    /* renamed from: a */
    static final int[] f241a = new int[0];

    /* renamed from: b */
    static final long[] f242b = new long[0];

    /* renamed from: c */
    static final Object[] f243c = new Object[0];

    /* renamed from: a */
    public static int m258a(int i) {
        return m261b(i * 4) / 4;
    }

    /* renamed from: b */
    public static int m261b(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m260a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    static int m259a(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = i - 1;
        while (i3 <= i4) {
            int i5 = (i3 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i3 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return i3 ^ (-1);
    }
}
