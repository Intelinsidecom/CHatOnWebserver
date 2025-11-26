package com.sec.chaton.util;

import com.sec.amsoma.AMSLibs;

/* compiled from: Base64.java */
/* renamed from: com.sec.chaton.util.e */
/* loaded from: classes.dex */
public final class C4882e {

    /* renamed from: a */
    private static final byte[] f17811a = new byte[128];

    /* renamed from: b */
    private static final char[] f17812b = new char[64];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            f17811a[i2] = -1;
        }
        for (int i3 = 90; i3 >= 65; i3--) {
            f17811a[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 122; i4 >= 97; i4--) {
            f17811a[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            f17811a[i5] = (byte) ((i5 - 48) + 52);
        }
        f17811a[43] = 62;
        f17811a[47] = 63;
        for (int i6 = 0; i6 <= 25; i6++) {
            f17812b[i6] = (char) (i6 + 65);
        }
        int i7 = 26;
        int i8 = 0;
        while (i7 <= 51) {
            f17812b[i7] = (char) (i8 + 97);
            i7++;
            i8++;
        }
        int i9 = 52;
        while (i9 <= 61) {
            f17812b[i9] = (char) (i + 48);
            i9++;
            i++;
        }
        f17812b[62] = '+';
        f17812b[63] = '/';
    }

    /* renamed from: a */
    protected static boolean m18533a(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    /* renamed from: b */
    protected static boolean m18535b(char c2) {
        return c2 == '=';
    }

    /* renamed from: c */
    protected static boolean m18536c(char c2) {
        return c2 < 128 && f17811a[c2] != -1;
    }

    /* renamed from: a */
    public static String m18532a(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i2 = length % 24;
        int i3 = length / 24;
        char[] cArr = new char[(i2 != 0 ? i3 + 1 : i3) * 4];
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i + 1;
            byte b2 = bArr[i];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            byte b5 = (byte) (b3 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL);
            byte b6 = (byte) (b2 & 3);
            byte b7 = (b2 & (-128)) == 0 ? (byte) (b2 >> 2) : (byte) ((b2 >> 2) ^ 192);
            byte b8 = (b3 & (-128)) == 0 ? (byte) (b3 >> 4) : (byte) ((b3 >> 4) ^ 240);
            int i9 = (b4 & (-128)) == 0 ? b4 >> 6 : (b4 >> 6) ^ 252;
            int i10 = i5 + 1;
            cArr[i5] = f17812b[b7];
            int i11 = i10 + 1;
            cArr[i10] = f17812b[b8 | (b6 << 4)];
            int i12 = i11 + 1;
            cArr[i11] = f17812b[((byte) i9) | (b5 << 2)];
            cArr[i12] = f17812b[b4 & 63];
            i4++;
            i5 = i12 + 1;
            i = i8;
        }
        if (i2 == 8) {
            byte b9 = bArr[i];
            byte b10 = (byte) (b9 & 3);
            int i13 = i5 + 1;
            cArr[i5] = f17812b[(b9 & (-128)) == 0 ? (byte) (b9 >> 2) : (byte) ((b9 >> 2) ^ 192)];
            int i14 = i13 + 1;
            cArr[i13] = f17812b[b10 << 4];
            int i15 = i14 + 1;
            cArr[i14] = '=';
            int i16 = i15 + 1;
            cArr[i15] = '=';
        } else if (i2 == 16) {
            byte b11 = bArr[i];
            byte b12 = bArr[i + 1];
            byte b13 = (byte) (b12 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL);
            byte b14 = (byte) (b11 & 3);
            byte b15 = (b11 & (-128)) == 0 ? (byte) (b11 >> 2) : (byte) ((b11 >> 2) ^ 192);
            byte b16 = (b12 & (-128)) == 0 ? (byte) (b12 >> 4) : (byte) ((b12 >> 4) ^ 240);
            int i17 = i5 + 1;
            cArr[i5] = f17812b[b15];
            int i18 = i17 + 1;
            cArr[i17] = f17812b[b16 | (b14 << 4)];
            int i19 = i18 + 1;
            cArr[i18] = f17812b[b13 << 2];
            int i20 = i19 + 1;
            cArr[i19] = '=';
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static byte[] m18534a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iM18531a = m18531a(charArray);
        if (iM18531a % 4 != 0) {
            return null;
        }
        int i = iM18531a / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i - 1) {
            int i5 = i2 + 1;
            char c2 = charArray[i2];
            if (!m18536c(c2)) {
                return null;
            }
            int i6 = i5 + 1;
            char c3 = charArray[i5];
            if (!m18536c(c3)) {
                return null;
            }
            int i7 = i6 + 1;
            char c4 = charArray[i6];
            if (!m18536c(c4)) {
                return null;
            }
            i2 = i7 + 1;
            char c5 = charArray[i7];
            if (!m18536c(c5)) {
                return null;
            }
            byte b2 = f17811a[c2];
            byte b3 = f17811a[c3];
            byte b4 = f17811a[c4];
            byte b5 = f17811a[c5];
            int i8 = i3 + 1;
            bArr[i3] = (byte) ((b2 << 2) | (b3 >> 4));
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((b3 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b4 >> 2) & 15));
            i3 = i9 + 1;
            bArr[i9] = (byte) ((b4 << 6) | b5);
            i4++;
        }
        int i10 = i2 + 1;
        char c6 = charArray[i2];
        if (!m18536c(c6)) {
            return null;
        }
        int i11 = i10 + 1;
        char c7 = charArray[i10];
        if (!m18536c(c7)) {
            return null;
        }
        byte b6 = f17811a[c6];
        byte b7 = f17811a[c7];
        int i12 = i11 + 1;
        char c8 = charArray[i11];
        int i13 = i12 + 1;
        char c9 = charArray[i12];
        if (!m18536c(c8) || !m18536c(c9)) {
            if (m18535b(c8) && m18535b(c9)) {
                if ((b7 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) != 0) {
                    return null;
                }
                byte[] bArr2 = new byte[(i4 * 3) + 1];
                System.arraycopy(bArr, 0, bArr2, 0, i4 * 3);
                bArr2[i3] = (byte) ((b6 << 2) | (b7 >> 4));
                return bArr2;
            }
            if (m18535b(c8) || !m18535b(c9)) {
                return null;
            }
            byte b8 = f17811a[c8];
            if ((b8 & 3) != 0) {
                return null;
            }
            byte[] bArr3 = new byte[(i4 * 3) + 2];
            System.arraycopy(bArr, 0, bArr3, 0, i4 * 3);
            bArr3[i3] = (byte) ((b6 << 2) | (b7 >> 4));
            bArr3[i3 + 1] = (byte) (((b7 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b8 >> 2) & 15));
            return bArr3;
        }
        byte b9 = f17811a[c8];
        byte b10 = f17811a[c9];
        int i14 = i3 + 1;
        bArr[i3] = (byte) ((b6 << 2) | (b7 >> 4));
        int i15 = i14 + 1;
        bArr[i14] = (byte) (((b7 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b9 >> 2) & 15));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((b9 << 6) | b10);
        return bArr;
    }

    /* renamed from: a */
    protected static int m18531a(char[] cArr) {
        int i;
        int i2 = 0;
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (m18533a(cArr[i3])) {
                    i = i2;
                } else {
                    i = i2 + 1;
                    cArr[i2] = cArr[i3];
                }
                i3++;
                i2 = i;
            }
        }
        return i2;
    }
}
