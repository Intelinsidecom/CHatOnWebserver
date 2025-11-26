package android.support.v4.p008c;

import java.io.PrintWriter;

/* compiled from: TimeUtils.java */
/* renamed from: android.support.v4.c.o */
/* loaded from: classes.dex */
public class C0089o {

    /* renamed from: a */
    private static final Object f281a = new Object();

    /* renamed from: b */
    private static char[] f282b = new char[24];

    /* renamed from: a */
    private static int m306a(int i, int i2, boolean z, int i3) {
        if (i > 99 || (z && i3 >= 3)) {
            return i2 + 3;
        }
        if (i > 9 || (z && i3 >= 2)) {
            return i2 + 2;
        }
        if (z || i > 0) {
            return i2 + 1;
        }
        return 0;
    }

    /* renamed from: a */
    private static int m308a(char[] cArr, int i, char c2, int i2, boolean z, int i3) {
        int i4;
        int i5;
        if (z || i > 0) {
            if ((!z || i3 < 3) && i <= 99) {
                i4 = i2;
                i5 = i;
            } else {
                int i6 = i / 100;
                cArr[i2] = (char) (i6 + 48);
                i4 = i2 + 1;
                i5 = i - (i6 * 100);
            }
            if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
                int i7 = i5 / 10;
                cArr[i4] = (char) (i7 + 48);
                i4++;
                i5 -= i7 * 10;
            }
            cArr[i4] = (char) (i5 + 48);
            int i8 = i4 + 1;
            cArr[i8] = c2;
            return i8 + 1;
        }
        return i2;
    }

    /* renamed from: a */
    private static int m307a(long j, int i) {
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (f282b.length < i) {
            f282b = new char[i];
        }
        char[] cArr = f282b;
        if (j == 0) {
            int i7 = i - 1;
            while (0 < i7) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j > 0) {
            c2 = '+';
        } else {
            j = -j;
            c2 = '-';
        }
        int i8 = (int) (j % 1000);
        int iFloor = (int) Math.floor(j / 1000);
        int i9 = 0;
        if (iFloor > 86400) {
            i9 = iFloor / 86400;
            iFloor -= 86400 * i9;
        }
        if (iFloor > 3600) {
            int i10 = iFloor / 3600;
            i2 = i10;
            i3 = iFloor - (i10 * 3600);
        } else {
            i2 = 0;
            i3 = iFloor;
        }
        if (i3 > 60) {
            int i11 = i3 / 60;
            i4 = i11;
            i5 = i3 - (i11 * 60);
        } else {
            i4 = 0;
            i5 = i3;
        }
        if (i == 0) {
            i6 = 0;
        } else {
            int iM306a = m306a(i9, 1, false, 0);
            int iM306a2 = iM306a + m306a(i2, 1, iM306a > 0, 2);
            int iM306a3 = iM306a2 + m306a(i4, 1, iM306a2 > 0, 2);
            int iM306a4 = iM306a3 + m306a(i5, 1, iM306a3 > 0, 2);
            i6 = 0;
            int iM306a5 = m306a(i8, 2, true, iM306a4 > 0 ? 3 : 0) + 1 + iM306a4;
            while (iM306a5 < i) {
                cArr[i6] = ' ';
                iM306a5++;
                i6++;
            }
        }
        cArr[i6] = c2;
        int i12 = i6 + 1;
        boolean z = i != 0;
        int iM308a = m308a(cArr, i9, 'd', i12, false, 0);
        int iM308a2 = m308a(cArr, i2, 'h', iM308a, iM308a != i12, z ? 2 : 0);
        int iM308a3 = m308a(cArr, i4, 'm', iM308a2, iM308a2 != i12, z ? 2 : 0);
        int iM308a4 = m308a(cArr, i5, 's', iM308a3, iM308a3 != i12, z ? 2 : 0);
        int iM308a5 = m308a(cArr, i8, 'm', iM308a4, true, (!z || iM308a4 == i12) ? 0 : 3);
        cArr[iM308a5] = 's';
        return iM308a5 + 1;
    }

    /* renamed from: a */
    public static void m311a(long j, PrintWriter printWriter, int i) {
        synchronized (f281a) {
            printWriter.print(new String(f282b, 0, m307a(j, i)));
        }
    }

    /* renamed from: a */
    public static void m310a(long j, PrintWriter printWriter) {
        m311a(j, printWriter, 0);
    }

    /* renamed from: a */
    public static void m309a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m311a(j - j2, printWriter, 0);
        }
    }
}
