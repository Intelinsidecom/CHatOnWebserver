package com.sec.chaton.util;

import com.sec.amsoma.AMSLibs;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class AesCipher {

    /* renamed from: a */
    static final byte[] f3606a = {AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, 51, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    protected Cipher f3607b;

    /* renamed from: c */
    protected Cipher f3608c;

    public AesCipher(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f3607b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f3608c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f3607b.init(1, secretKeySpec, ivParameterSpec);
            this.f3608c.init(2, secretKeySpec, ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            ChatONLogWriter.m3500a((Throwable) e);
        } catch (NoSuchPaddingException e2) {
            ChatONLogWriter.m3500a((Throwable) e2);
        }
    }

    /* renamed from: a */
    public static String m3465a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            bArr2[i] = f3606a[i2 >>> 4];
            i = i3 + 1;
            bArr2[i3] = f3606a[i2 & 15];
        }
        try {
            return new String(bArr2, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m3466a() {
        byte[] bArrM3467a = m3467a(ChatONPref.m3519a().getString("key", ""));
        byte[] bArr = new byte[bArrM3467a.length / 2];
        System.arraycopy(bArrM3467a, 0, bArr, 0, bArrM3467a.length / 2);
        return bArr;
    }

    /* renamed from: a */
    public static byte[] m3467a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m3468b() {
        byte[] bArrM3467a = m3467a(ChatONPref.m3519a().getString("key", ""));
        byte[] bArr = new byte[bArrM3467a.length / 2];
        System.arraycopy(bArrM3467a, 16, bArr, 0, bArrM3467a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m3469b(String str) {
        byte[] bArrM3467a = m3467a(str);
        byte[] bArr = new byte[bArrM3467a.length / 2];
        System.arraycopy(bArrM3467a, 0, bArr, 0, bArrM3467a.length / 2);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m3470c(String str) {
        byte[] bArrM3467a = m3467a(str);
        byte[] bArr = new byte[bArrM3467a.length / 2];
        System.arraycopy(bArrM3467a, 16, bArr, 0, bArrM3467a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public byte[] m3471b(byte[] bArr) {
        try {
            return this.f3607b.doFinal(bArr);
        } catch (Exception e) {
            ChatONLogWriter.m3500a((Throwable) e);
            return null;
        }
    }

    /* renamed from: c */
    public byte[] m3472c(byte[] bArr) {
        try {
            return this.f3608c.doFinal(bArr);
        } catch (Exception e) {
            ChatONLogWriter.m3500a((Throwable) e);
            return null;
        }
    }
}
