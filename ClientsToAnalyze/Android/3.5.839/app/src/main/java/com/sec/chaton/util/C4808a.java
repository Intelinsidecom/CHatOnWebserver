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
public class C4808a {

    /* renamed from: a */
    static final byte[] f17568a = {AMSLibs.ENUM_VIP_AMS_CB_ERROR_DRAW, AMSLibs.ENUM_VIP_AMS_CB_ERROR_INVALID_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_CB_ERROR_LIMITED_LIB_VERSION, AMSLibs.ENUM_VIP_AMS_ERROR_OBJECT_IMAGE_NUM_FULL, 52, 53, 54, AMSLibs.ENUM_VIP_AMS_WQVGA_DRAW_BASIC_STAMPSIZE, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    protected Cipher f17569b;

    /* renamed from: c */
    protected Cipher f17570c;

    /* renamed from: a */
    public static String m18098a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            bArr2[i] = f17568a[i2 >>> 4];
            i = i3 + 1;
            bArr2[i3] = f17568a[i2 & 15];
        }
        try {
            return new String(bArr2, "ASCII");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public C4808a(byte[] bArr, byte[] bArr2) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.f17569b = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f17570c = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f17569b.init(1, secretKeySpec, ivParameterSpec);
            this.f17570c.init(2, secretKeySpec, ivParameterSpec);
        } catch (NoSuchAlgorithmException e) {
            C4904y.m18635a(e, "AesCipher");
        } catch (NoSuchPaddingException e2) {
            C4904y.m18635a(e2, "AesCipher");
        }
    }

    /* renamed from: b */
    public byte[] m18102b(byte[] bArr) {
        try {
            return this.f17569b.doFinal(bArr);
        } catch (Exception e) {
            C4904y.m18635a(e, "AesCipher");
            return null;
        }
    }

    /* renamed from: c */
    public byte[] m18103c(byte[] bArr) {
        try {
            return this.f17570c.doFinal(bArr);
        } catch (Exception e) {
            C4904y.m18635a(e, "AesCipher");
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m18099a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            try {
                bArr[i] = (byte) Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
            } catch (NumberFormatException e) {
                C4904y.m18634a("hexToByteArray() input string param hex format not proper", "AesCipher");
                C4904y.m18635a(e, "AesCipher");
                return null;
            }
        }
        return bArr;
    }

    /* renamed from: b */
    public static byte[] m18100b(String str) {
        byte[] bArrM18099a = m18099a(str);
        if (bArrM18099a == null) {
            C4904y.m18634a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM18099a.length / 2];
        System.arraycopy(bArrM18099a, 0, bArr, 0, bArrM18099a.length / 2);
        return bArr;
    }

    /* renamed from: c */
    public static byte[] m18101c(String str) {
        byte[] bArrM18099a = m18099a(str);
        if (bArrM18099a == null) {
            C4904y.m18634a("keyFromServer value is null", "AesCipher");
            return "".getBytes();
        }
        byte[] bArr = new byte[bArrM18099a.length / 2];
        System.arraycopy(bArrM18099a, 16, bArr, 0, bArrM18099a.length / 2);
        return bArr;
    }
}
