package android.support.v4.util;

import java.io.PrintWriter;

/* loaded from: classes.dex */
public class TimeUtils {

    /* renamed from: a */
    private static final Object f141a = new Object();

    /* renamed from: b */
    private static char[] f142b = new char[24];

    /* renamed from: a */
    private static int m172a(int i, int i2, boolean z, int i3) {
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
    private static int m173a(long j, int i) {
        long j2;
        char c;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (f142b.length < i) {
            f142b = new char[i];
        }
        char[] cArr = f142b;
        if (j == 0) {
            int i7 = i - 1;
            while (0 < i7) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 0 + 1;
        }
        if (j > 0) {
            j2 = j;
            c = '+';
        } else {
            j2 = -j;
            c = '-';
        }
        int i8 = (int) (j2 % 1000);
        int iFloor = (int) Math.floor(j2 / 1000);
        if (iFloor > 86400) {
            int i9 = iFloor / 86400;
            i2 = iFloor - (86400 * i9);
            i3 = i9;
        } else {
            i2 = iFloor;
            i3 = 0;
        }
        if (i2 > 3600) {
            int i10 = i2 / 3600;
            i2 -= i10 * 3600;
            i4 = i10;
        } else {
            i4 = 0;
        }
        if (i2 > 60) {
            int i11 = i2 / 60;
            i5 = i11;
            i6 = i2 - (i11 * 60);
        } else {
            i5 = 0;
            i6 = i2;
        }
        int i12 = 0;
        if (i != 0) {
            int iM172a = m172a(i3, 1, false, 0);
            int iM172a2 = iM172a + m172a(i4, 1, iM172a > 0, 2);
            int iM172a3 = iM172a2 + m172a(i5, 1, iM172a2 > 0, 2);
            int iM172a4 = iM172a3 + m172a(i6, 1, iM172a3 > 0, 2);
            int iM172a5 = iM172a4 + m172a(i8, 2, true, iM172a4 > 0 ? 3 : 0) + 1;
            int i13 = 0;
            for (int i14 = iM172a5; i14 < i; i14++) {
                cArr[i13] = ' ';
                i13++;
            }
            i12 = i13;
        }
        cArr[i12] = c;
        int i15 = i12 + 1;
        boolean z = i != 0;
        int iM174a = m174a(cArr, i3, 'd', i15, false, 0);
        int iM174a2 = m174a(cArr, i4, 'h', iM174a, iM174a != i15, z ? 2 : 0);
        int iM174a3 = m174a(cArr, i5, 'm', iM174a2, iM174a2 != i15, z ? 2 : 0);
        int iM174a4 = m174a(cArr, i6, 's', iM174a3, iM174a3 != i15, z ? 2 : 0);
        int iM174a5 = m174a(cArr, i8, 'm', iM174a4, true, (!z || iM174a4 == i15) ? 0 : 3);
        cArr[iM174a5] = 's';
        return iM174a5 + 1;
    }

    /* renamed from: a */
    private static int m174a(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        int i5;
        if (!z && i <= 0) {
            return i2;
        }
        if ((!z || i3 < 3) && i <= 99) {
            i4 = i2;
            i5 = i;
        } else {
            int i6 = i / 100;
            cArr[i2] = (char) (i6 + 48);
            i5 = i - (i6 * 100);
            i4 = i2 + 1;
        }
        if ((z && i3 >= 2) || i5 > 9 || i2 != i4) {
            int i7 = i5 / 10;
            cArr[i4] = (char) (i7 + 48);
            i4++;
            i5 -= i7 * 10;
        }
        cArr[i4] = (char) (i5 + 48);
        int i8 = i4 + 1;
        cArr[i8] = c;
        return i8 + 1;
    }

    /* renamed from: a */
    public static void m175a(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            m177a(j - j2, printWriter, 0);
        }
    }

    /* renamed from: a */
    public static void m176a(long j, PrintWriter printWriter) {
        m177a(j, printWriter, 0);
    }

    /* renamed from: a */
    public static void m177a(long j, PrintWriter printWriter, int i) {
        synchronized (f141a) {
            printWriter.print(new String(f142b, 0, m173a(j, i)));
        }
    }
}
