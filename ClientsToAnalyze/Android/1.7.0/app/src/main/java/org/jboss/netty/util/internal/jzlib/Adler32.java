package org.jboss.netty.util.internal.jzlib;

/* loaded from: classes.dex */
final class Adler32 {
    private static final int BASE = 65521;
    private static final int NMAX = 5552;

    Adler32() {
    }

    static long adler32(long j, byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 1L;
        }
        long j2 = j & 65535;
        long j3 = 65535 & (j >> 16);
        int i3 = i2;
        int i4 = i;
        while (i3 > 0) {
            int i5 = i3 < NMAX ? i3 : NMAX;
            int i6 = i3 - i5;
            long j4 = j3;
            long j5 = j2;
            int i7 = i4;
            while (i5 >= 16) {
                long j6 = j5 + (bArr[i7] & 255);
                long j7 = j4 + j6;
                long j8 = j6 + (bArr[r6] & 255);
                long j9 = j7 + j8;
                long j10 = j8 + (bArr[r5] & 255);
                long j11 = j9 + j10;
                long j12 = j10 + (bArr[r6] & 255);
                long j13 = j11 + j12;
                long j14 = j12 + (bArr[r5] & 255);
                long j15 = j13 + j14;
                long j16 = j14 + (bArr[r6] & 255);
                long j17 = j15 + j16;
                long j18 = j16 + (bArr[r5] & 255);
                long j19 = j17 + j18;
                long j20 = j18 + (bArr[r6] & 255);
                long j21 = j19 + j20;
                long j22 = j20 + (bArr[r5] & 255);
                long j23 = j21 + j22;
                long j24 = j22 + (bArr[r6] & 255);
                long j25 = j23 + j24;
                long j26 = j24 + (bArr[r5] & 255);
                long j27 = j25 + j26;
                long j28 = j26 + (bArr[r6] & 255);
                long j29 = j27 + j28;
                long j30 = j28 + (bArr[r5] & 255);
                long j31 = j29 + j30;
                long j32 = j30 + (bArr[r6] & 255);
                long j33 = j31 + j32;
                long j34 = j32 + (bArr[r5] & 255);
                long j35 = j33 + j34;
                i7 = i7 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
                j5 = j34 + (bArr[r6] & 255);
                j4 = j35 + j5;
                i5 -= 16;
            }
            if (i5 != 0) {
                while (true) {
                    i4 = i7 + 1;
                    j5 += bArr[i7] & 255;
                    j4 += j5;
                    i5--;
                    if (i5 == 0) {
                        break;
                    }
                    i7 = i4;
                }
            } else {
                i4 = i7;
            }
            j2 = j5 % 65521;
            j3 = j4 % 65521;
            i3 = i6;
        }
        return (j3 << 16) | j2;
    }
}
