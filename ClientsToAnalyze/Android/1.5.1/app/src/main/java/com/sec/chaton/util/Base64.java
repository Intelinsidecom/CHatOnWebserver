package com.sec.chaton.util;

/* loaded from: classes.dex */
public final class Base64 {

    /* renamed from: a */
    private static final byte[] f3609a = new byte[128];

    /* renamed from: b */
    private static final char[] f3610b = new char[64];

    static {
        for (int i = 0; i < 128; i++) {
            f3609a[i] = -1;
        }
        for (int i2 = 90; i2 >= 65; i2--) {
            f3609a[i2] = (byte) (i2 - 65);
        }
        for (int i3 = 122; i3 >= 97; i3--) {
            f3609a[i3] = (byte) ((i3 - 97) + 26);
        }
        for (int i4 = 57; i4 >= 48; i4--) {
            f3609a[i4] = (byte) ((i4 - 48) + 52);
        }
        f3609a[43] = 62;
        f3609a[47] = 63;
        for (int i5 = 0; i5 <= 25; i5++) {
            f3610b[i5] = (char) (i5 + 65);
        }
        int i6 = 26;
        int i7 = 0;
        while (i6 <= 51) {
            f3610b[i6] = (char) (i7 + 97);
            i6++;
            i7++;
        }
        int i8 = 52;
        int i9 = 0;
        while (i8 <= 61) {
            f3610b[i8] = (char) (i9 + 48);
            i8++;
            i9++;
        }
        f3610b[62] = '+';
        f3610b[63] = '/';
    }
}
