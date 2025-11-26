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
/* renamed from: com.sec.chaton.util.a */
/* loaded from: classes.dex */
public class C3158a {

    /* renamed from: a */
    static final byte[] f11467a = {AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_ERROR_OBJECT_IMAGE_NUM_FULL, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    protected Cipher f11468b;

    /* renamed from: c */
    protected Cipher f11469c;

    /* renamed from: a */
    public static String m10954a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & 255;
            int i3 = i + 1;
            bArr2[i] = f11467a[i2 >>> 4];
            i = i3 + 1;
            bArr2[i3] = f11467a[i2 & 15];
        }
        try {
            return new String(bArr2, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C3158a(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f11468b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f11469c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f11468b.init(1, secretKeySpec, ivParameterSpec);
            this.f11469c.init(2, secretKeySpec, ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            C3250y.m11451b(e);
        } catch (NoSuchPaddingException e2) {
            C3250y.m11451b(e2);
        }
    }

    /* renamed from: b */
    public byte[] m10960b(byte[] bArr) {
        try {
            return this.f11468b.doFinal(bArr);
        } catch (Exception e) {
            C3250y.m11451b(e);
            return null;
        }
    }

    /* renamed from: c */
    public byte[] m10961c(byte[] bArr) {
        try {
            return this.f11469c.doFinal(bArr);
        } catch (Exception e) {
            C3250y.m11451b(e);
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m10956a(String str) {
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
    public static byte[] m10955a() {
        byte[] bArrM10956a = m10956a(C3159aa.m10962a().m10979a("key", ""));
        if (bArrM10956a == null) {
            C3250y.m11442a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM10956a.length / 2];
        System.arraycopy(bArrM10956a, 0, bArr, 0, bArrM10956a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m10958b(String str) {
        byte[] bArrM10956a = m10956a(str);
        if (bArrM10956a == null) {
            C3250y.m11442a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM10956a.length / 2];
        System.arraycopy(bArrM10956a, 0, bArr, 0, bArrM10956a.length / 2);
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m10957b() {
        byte[] bArrM10956a = m10956a(C3159aa.m10962a().m10979a("key", ""));
        if (bArrM10956a == null) {
            C3250y.m11442a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM10956a.length / 2];
        System.arraycopy(bArrM10956a, 16, bArr, 0, bArrM10956a.length / 2);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m10959c(String str) {
        byte[] bArrM10956a = m10956a(str);
        if (bArrM10956a == null) {
            C3250y.m11442a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM10956a.length / 2];
        System.arraycopy(bArrM10956a, 16, bArr, 0, bArrM10956a.length / 2);
        return bArr;
    }
}
