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
/* renamed from: com.sec.chaton.util.br */
/* loaded from: classes.dex */
public class C1322br {

    /* renamed from: a */
    static final byte[] f4540a = {AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, 51, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    protected Cipher f4541b;

    /* renamed from: c */
    protected Cipher f4542c;

    /* renamed from: a */
    public static String m4567a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            bArr2[i] = f4540a[i2 >>> 4];
            i = i3 + 1;
            bArr2[i3] = f4540a[i2 & 15];
        }
        try {
            return new String(bArr2, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C1322br(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f4541b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f4542c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f4541b.init(1, secretKeySpec, ivParameterSpec);
            this.f4542c.init(2, secretKeySpec, ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            C1341p.m4652a((Throwable) e);
        } catch (NoSuchPaddingException e2) {
            C1341p.m4652a((Throwable) e2);
        }
    }

    /* renamed from: b */
    public byte[] m4573b(byte[] bArr) {
        try {
            return this.f4541b.doFinal(bArr);
        } catch (Exception e) {
            C1341p.m4652a((Throwable) e);
            return null;
        }
    }

    /* renamed from: c */
    public byte[] m4574c(byte[] bArr) {
        try {
            return this.f4542c.doFinal(bArr);
        } catch (Exception e) {
            C1341p.m4652a((Throwable) e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m4569a(String str) {
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
    public static byte[] m4568a() {
        byte[] bArrM4569a = m4569a(C1323bs.m4575a().getString("key", ""));
        if (bArrM4569a == null) {
            C1341p.m4651a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM4569a.length / 2];
        System.arraycopy(bArrM4569a, 0, bArr, 0, bArrM4569a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m4571b(String str) {
        byte[] bArrM4569a = m4569a(str);
        if (bArrM4569a == null) {
            C1341p.m4651a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM4569a.length / 2];
        System.arraycopy(bArrM4569a, 0, bArr, 0, bArrM4569a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m4570b() {
        byte[] bArrM4569a = m4569a(C1323bs.m4575a().getString("key", ""));
        if (bArrM4569a == null) {
            C1341p.m4651a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM4569a.length / 2];
        System.arraycopy(bArrM4569a, 16, bArr, 0, bArrM4569a.length / 2);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m4572c(String str) {
        byte[] bArrM4569a = m4569a(str);
        if (bArrM4569a == null) {
            C1341p.m4651a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM4569a.length / 2];
        System.arraycopy(bArrM4569a, 16, bArr, 0, bArrM4569a.length / 2);
        return bArr;
    }
}
