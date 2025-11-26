package com.sec.google.android.p134a.p135a;

import com.sec.amsoma.AMSLibs;

/* compiled from: Base64.java */
/* renamed from: com.sec.google.android.a.a.b */
/* loaded from: classes.dex */
public class C5079b {

    /* renamed from: a */
    private static byte[] f18518a = new byte[255];

    static {
        for (int i = 0; i < 255; i++) {
            f18518a[i] = -1;
        }
        for (int i2 = 90; i2 >= 65; i2--) {
            f18518a[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 122; i3 >= 97; i3--) {
            f18518a[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 57; i4 >= 48; i4--) {
            f18518a[i4] = (byte) ((i4 - 48) + 52);
        }
        f18518a[43] = 62;
        f18518a[47] = 63;
    }

    /* renamed from: a */
    public static byte[] m19297a(byte[] bArr) {
        byte[] bArrM19298b = m19298b(bArr);
        if (bArrM19298b.length == 0) {
            return new byte[0];
        }
        int length = bArrM19298b.length / 4;
        int length2 = bArrM19298b.length;
        while (bArrM19298b[length2 - 1] == 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[length2 - length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 4;
            byte b2 = bArrM19298b[i3 + 2];
            byte b3 = bArrM19298b[i3 + 3];
            byte b4 = f18518a[bArrM19298b[i3]];
            byte b5 = f18518a[bArrM19298b[i3 + 1]];
            if (b2 != 61 && b3 != 61) {
                byte b6 = f18518a[b2];
                byte b7 = f18518a[b3];
                bArr2[i] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i + 1] = (byte) (((b5 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b6 >> 2) & 15));
                bArr2[i + 2] = (byte) ((b6 << 6) | b7);
            } else if (b2 == 61) {
                bArr2[i] = (byte) ((b5 >> 4) | (b4 << 2));
            } else if (b3 == 61) {
                byte b8 = f18518a[b2];
                bArr2[i] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i + 1] = (byte) (((b5 & AMSLibs.ENUM_VIP_AMS_ERROR_USERIMAGE_ID_FULL) << 4) | ((b8 >> 2) & 15));
            }
            i += 3;
        }
        return bArr2;
    }

    /* renamed from: a */
    private static boolean m19296a(byte b2) {
        return b2 == 61 || f18518a[b2] != -1;
    }

    /* renamed from: b */
    static byte[] m19298b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (m19296a(bArr[i2])) {
                bArr2[i] = bArr[i2];
                i++;
            }
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArr2, 0, bArr3, 0, i);
        return bArr3;
    }
}
