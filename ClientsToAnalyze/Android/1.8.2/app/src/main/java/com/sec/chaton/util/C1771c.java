package com.sec.chaton.util;

import com.sec.amsoma.AMSLibs;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AesCipher.java */
/* renamed from: com.sec.chaton.util.c */
/* loaded from: classes.dex */
public class C1771c {

    /* renamed from: a */
    static final byte[] f6428a = {AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, 51, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    protected Cipher f6429b;

    /* renamed from: c */
    protected Cipher f6430c;

    /* renamed from: a */
    public static String m6009a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            bArr2[i] = f6428a[i2 >>> 4];
            i = i3 + 1;
            bArr2[i3] = f6428a[i2 & 15];
        }
        try {
            return new String(bArr2, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1771c(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f6429b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f6430c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f6429b.init(1, secretKeySpec, ivParameterSpec);
            this.f6430c.init(2, secretKeySpec, ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            C1786r.m6055a((Throwable) e);
        } catch (NoSuchPaddingException e2) {
            C1786r.m6055a((Throwable) e2);
        }
    }

    /* renamed from: b */
    public byte[] m6015b(byte[] bArr) {
        try {
            return this.f6429b.doFinal(bArr);
        } catch (Exception e) {
            C1786r.m6055a((Throwable) e);
            return null;
        }
    }

    /* renamed from: c */
    public byte[] m6016c(byte[] bArr) {
        try {
            return this.f6430c.doFinal(bArr);
        } catch (Exception e) {
            C1786r.m6055a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m6011a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m6010a() {
        byte[] bArrM6011a = m6011a(C1789u.m6075a().getString("key", ""));
        if (bArrM6011a == null) {
            C1786r.m6054a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM6011a.length / 2];
        System.arraycopy(bArrM6011a, 0, bArr, 0, bArrM6011a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m6013b(String str) {
        byte[] bArrM6011a = m6011a(str);
        if (bArrM6011a == null) {
            C1786r.m6054a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM6011a.length / 2];
        System.arraycopy(bArrM6011a, 0, bArr, 0, bArrM6011a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m6012b() {
        byte[] bArrM6011a = m6011a(C1789u.m6075a().getString("key", ""));
        if (bArrM6011a == null) {
            C1786r.m6054a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM6011a.length / 2];
        System.arraycopy(bArrM6011a, 16, bArr, 0, bArrM6011a.length / 2);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m6014c(String str) {
        byte[] bArrM6011a = m6011a(str);
        if (bArrM6011a == null) {
            C1786r.m6054a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM6011a.length / 2];
        System.arraycopy(bArrM6011a, 16, bArr, 0, bArrM6011a.length / 2);
        return bArr;
    }
}
