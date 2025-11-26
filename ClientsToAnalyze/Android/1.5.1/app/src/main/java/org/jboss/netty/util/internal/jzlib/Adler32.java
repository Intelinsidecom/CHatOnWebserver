package org.jboss.netty.util.internal.jzlib;

/* loaded from: classes.dex */
final class Adler32 {
    private static final int BASE = 65521;
    private static final int NMAX = 5552;

    Adler32() {
    }

    static long adler32(long j, byte[] bArr, int i, int i2) {
        long j2;
        long j3;
        int i3;
        if (bArr == null) {
            return 1L;
        }
        long j4 = 65535 & j;
        long j5 = (j >> 16) & 65535;
        int i4 = i2;
        int i5 = i;
        long j6 = j4;
        while (i4 > 0) {
            int i6 = i4 < NMAX ? i4 : NMAX;
            i4 -= i6;
            long j7 = j5;
            int i7 = i6;
            int i8 = i5;
            long j8 = j6;
            long j9 = j7;
            while (i7 >= 16) {
                long j10 = j8 + (bArr[i8] & 255);
                long j11 = j9 + j10;
                long j12 = j10 + (bArr[r3] & 255);
                long j13 = j11 + j12;
                long j14 = j12 + (bArr[r10] & 255);
                long j15 = j13 + j14;
                long j16 = j14 + (bArr[r3] & 255);
                long j17 = j15 + j16;
                long j18 = j16 + (bArr[r10] & 255);
                long j19 = j17 + j18;
                long j20 = j18 + (bArr[r3] & 255);
                long j21 = j19 + j20;
                long j22 = j20 + (bArr[r10] & 255);
                long j23 = j21 + j22;
                long j24 = j22 + (bArr[r3] & 255);
                long j25 = j23 + j24;
                long j26 = j24 + (bArr[r10] & 255);
                long j27 = j25 + j26;
                long j28 = j26 + (bArr[r3] & 255);
                long j29 = j27 + j28;
                long j30 = j28 + (bArr[r10] & 255);
                long j31 = j29 + j30;
                long j32 = j30 + (bArr[r3] & 255);
                long j33 = j31 + j32;
                long j34 = j32 + (bArr[r10] & 255);
                long j35 = j33 + j34;
                long j36 = j34 + (bArr[r3] & 255);
                long j37 = j35 + j36;
                long j38 = j36 + (bArr[r10] & 255);
                long j39 = j37 + j38;
                i8 = i8 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
                j8 = j38 + (bArr[r3] & 255);
                j9 = j39 + j8;
                i7 -= 16;
            }
            if (i7 != 0) {
                while (true) {
                    i3 = i8 + 1;
                    j8 += bArr[i8] & 255;
                    j9 += j8;
                    i7--;
                    if (i7 == 0) {
                        break;
                    }
                    i8 = i3;
                }
                j3 = j9;
                j2 = j8;
                i5 = i3;
            } else {
                long j40 = j9;
                j2 = j8;
                i5 = i8;
                j3 = j40;
            }
            j6 = j2 % 65521;
            j5 = j3 % 65521;
        }
        return (j5 << 16) | j6;
    }
}
