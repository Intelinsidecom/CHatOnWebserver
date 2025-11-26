package com.sec.google.android.p134a.p135a;

import java.io.ByteArrayOutputStream;

/* compiled from: QuotedPrintable.java */
/* renamed from: com.sec.google.android.a.a.u */
/* loaded from: classes.dex */
public class C5098u {

    /* renamed from: a */
    private static byte f18583a = 61;

    /* renamed from: a */
    public static final byte[] m19452a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b2 = bArr[i];
            if (b2 == f18583a) {
                try {
                    if ('\r' == ((char) bArr[i + 1]) && '\n' == ((char) bArr[i + 2])) {
                        i += 2;
                    } else {
                        int i2 = i + 1;
                        int iDigit = Character.digit((char) bArr[i2], 16);
                        i = i2 + 1;
                        int iDigit2 = Character.digit((char) bArr[i], 16);
                        if (iDigit == -1 || iDigit2 == -1) {
                            return null;
                        }
                        byteArrayOutputStream.write((char) ((iDigit << 4) + iDigit2));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
            } else {
                byteArrayOutputStream.write(b2);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }
}
