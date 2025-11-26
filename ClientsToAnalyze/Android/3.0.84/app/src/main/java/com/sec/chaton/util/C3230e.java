package com.sec.chaton.util;

import com.sec.amsoma.AMSLibs;

/* compiled from: Base64.java */
/* renamed from: com.sec.chaton.util.e */
/* loaded from: classes.dex */
public final class C3230e {

    /* renamed from: a */
    private static final byte[] f11663a = new byte[128];

    /* renamed from: b */
    private static final char[] f11664b = new char[64];

    static {
        int i = 0;
        for (int i2 = 0; i2 < 128; i2++) {
            f11663a[i2] = -1;
        }
        for (int i3 = 90; i3 >= 65; i3--) {
            f11663a[i3] = (byte) (i3 - 65);
        }
        for (int i4 = 122; i4 >= 97; i4--) {
            f11663a[i4] = (byte) ((i4 - 97) + 26);
        }
        for (int i5 = 57; i5 >= 48; i5--) {
            f11663a[i5] = (byte) ((i5 - 48) + 52);
        }
        f11663a[43] = 62;
        f11663a[47] = 63;
        for (int i6 = 0; i6 <= 25; i6++) {
            f11664b[i6] = (char) (i6 + 65);
        }
        int i7 = 26;
        int i8 = 0;
        while (i7 <= 51) {
            f11664b[i7] = (char) (i8 + 97);
            i7++;
            i8++;
        }
        int i9 = 52;
        while (i9 <= 61) {
            f11664b[i9] = (char) (i + 48);
            i9++;
            i++;
        }
        f11664b[62] = '+';
        f11664b[63] = '/';
    }

    /* renamed from: a */
    protected static boolean m11352a(char c) {
        return c == ' ' || c == '\r' || c == '\n' || c == '\t';
    }

    /* renamed from: b */
    protected static boolean m11354b(char c) {
        return c == '=';
    }

    /* renamed from: c */
    protected static boolean m11355c(char c) {
        return c < 128 && f11663a[c] != -1;
    }

    /* renamed from: a */
    public static byte[] m11353a(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int iM11351a = m11351a(charArray);
        if (iM11351a % 4 != 0) {
            return null;
        }
        int i = iM11351a / 4;
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i - 1) {
            int i5 = i2 + 1;
            char c = charArray[i2];
            if (!m11355c(c)) {
                return null;
            }
            int i6 = i5 + 1;
            char c2 = charArray[i5];
            if (!m11355c(c2)) {
                return null;
            }
            int i7 = i6 + 1;
            char c3 = charArray[i6];
            if (!m11355c(c3)) {
                return null;
            }
            i2 = i7 + 1;
            char c4 = charArray[i7];
            if (!m11355c(c4)) {
                return null;
            }
            byte b = f11663a[c];
            byte b2 = f11663a[c2];
            byte b3 = f11663a[c3];
            byte b4 = f11663a[c4];
            int i8 = i3 + 1;
            bArr[i3] = (byte) ((b << 2) | (b2 >> 4));
            int i9 = i8 + 1;
            bArr[i8] = (byte) (((b2 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b3 >> 2) & 15));
            i3 = i9 + 1;
            bArr[i9] = (byte) ((b3 << 6) | b4);
            i4++;
        }
        int i10 = i2 + 1;
        char c5 = charArray[i2];
        if (!m11355c(c5)) {
            return null;
        }
        int i11 = i10 + 1;
        char c6 = charArray[i10];
        if (!m11355c(c6)) {
            return null;
        }
        byte b5 = f11663a[c5];
        byte b6 = f11663a[c6];
        int i12 = i11 + 1;
        char c7 = charArray[i11];
        int i13 = i12 + 1;
        char c8 = charArray[i12];
        if (!m11355c(c7) || !m11355c(c8)) {
            if (m11354b(c7) && m11354b(c8)) {
                if ((b6 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) != 0) {
                    return null;
                }
                byte[] bArr2 = new byte[(i4 * 3) + 1];
                System.arraycopy(bArr, 0, bArr2, 0, i4 * 3);
                bArr2[i3] = (byte) ((b5 << 2) | (b6 >> 4));
                return bArr2;
            }
            if (m11354b(c7) || !m11354b(c8)) {
                return null;
            }
            byte b7 = f11663a[c7];
            if ((b7 & 3) != 0) {
                return null;
            }
            byte[] bArr3 = new byte[(i4 * 3) + 2];
            System.arraycopy(bArr, 0, bArr3, 0, i4 * 3);
            bArr3[i3] = (byte) ((b5 << 2) | (b6 >> 4));
            bArr3[i3 + 1] = (byte) (((b6 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b7 >> 2) & 15));
            return bArr3;
        }
        byte b8 = f11663a[c7];
        byte b9 = f11663a[c8];
        int i14 = i3 + 1;
        bArr[i3] = (byte) ((b5 << 2) | (b6 >> 4));
        int i15 = i14 + 1;
        bArr[i14] = (byte) (((b6 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b8 >> 2) & 15));
        int i16 = i15 + 1;
        bArr[i15] = (byte) ((b8 << 6) | b9);
        return bArr;
    }

    /* renamed from: a */
    protected static int m11351a(char[] cArr) {
        int i;
        int i2 = 0;
        if (cArr != null) {
            int length = cArr.length;
            int i3 = 0;
            while (i3 < length) {
                if (m11352a(cArr[i3])) {
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
