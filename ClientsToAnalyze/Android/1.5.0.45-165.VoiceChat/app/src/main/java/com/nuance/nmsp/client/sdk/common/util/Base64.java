package com.nuance.nmsp.client.sdk.common.util;

/* loaded from: classes.dex */
public class Base64 {

    /* renamed from: b */
    private static String f68b = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    /* renamed from: a */
    private static byte[] f67a = new byte[64];

    static {
        for (int i = 0; i < 64; i++) {
            f67a[i] = (byte) f68b.charAt(i);
        }
    }

    public static String encode(String str) {
        return encode(str.getBytes());
    }

    public static String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static String encode(byte[] bArr, int i, int i2) {
        int i3;
        byte[] bArr2 = new byte[((i2 + 2) / 3) << 2];
        int i4 = i2 + i;
        byte b = 0;
        int i5 = 0;
        int i6 = 0;
        while (i < i4) {
            byte b2 = bArr[i];
            i5++;
            switch (i5) {
                case 1:
                    i3 = i6 + 1;
                    bArr2[i6] = f67a[(b2 >> 2) & 63];
                    break;
                case 2:
                    i3 = i6 + 1;
                    bArr2[i6] = f67a[((b << 4) & 48) | ((b2 >> 4) & 15)];
                    break;
                case 3:
                    int i7 = i6 + 1;
                    bArr2[i6] = f67a[((b << 2) & 60) | ((b2 >> 6) & 3)];
                    bArr2[i7] = f67a[b2 & 63];
                    i3 = i7 + 1;
                    i5 = 0;
                    break;
                default:
                    i3 = i6;
                    break;
            }
            i++;
            b = b2;
            i6 = i3;
        }
        switch (i5) {
            case 1:
                int i8 = i6 + 1;
                bArr2[i6] = f67a[(b << 4) & 48];
                bArr2[i8] = 61;
                bArr2[i8 + 1] = 61;
                break;
            case 2:
                bArr2[i6] = f67a[(b << 2) & 60];
                bArr2[i6 + 1] = 61;
                break;
        }
        return new String(bArr2);
    }
}
