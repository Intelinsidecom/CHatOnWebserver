package com.sds.coolots.common.util;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class EncodingUtil {

    /* renamed from: a */
    private static final String f3062a = "UTF-8";

    /* renamed from: b */
    private static final byte[] f3063b = {25, 114, 5, 21, 100, 116, 118, 24, 117, 57, 102, 92, 108, 120, 106, 117};

    /* renamed from: c */
    private static final byte[] f3064c = {25, 114, 5, 21, 101, 116, 119, 24, 118, 57, 103, 92, 109, 120, 107, 118};

    /* renamed from: d */
    private static final String f3065d = "AES/CBC/PKCS5Padding";

    /* renamed from: e */
    private static final String f3066e = "RSA";

    /* renamed from: f */
    private static final String f3067f = "RSA/ECB/PKCS1Padding";

    /* renamed from: g */
    private static final int f3068g = 1024;

    /* renamed from: h */
    private static final int f3069h = 128;

    /* renamed from: i */
    private static final int f3070i = 117;

    private EncodingUtil() {
    }

    public static String decodeAES(String str) {
        return decodeAES(str, f3063b);
    }

    public static String decodeAES(String str, byte[] bArr) {
        return new String(decodeAESToByte(str, bArr), "UTF-8");
    }

    public static byte[] decodeAES(byte[] bArr) {
        return decodeAES(bArr, f3063b);
    }

    public static byte[] decodeAES(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f3064c);
        Cipher cipher = Cipher.getInstance(f3065d);
        cipher.init(2, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static byte[] decodeAESToByte(String str) {
        return decodeAESToByte(str, f3063b);
    }

    public static byte[] decodeAESToByte(String str, byte[] bArr) {
        return decodeAES(decodeBase64ToBytes(str), bArr);
    }

    public static String decodeBase64(String str) {
        return decodeBase64(str.getBytes("UTF-8"));
    }

    public static String decodeBase64(byte[] bArr) {
        return new String(Base64.decode(bArr, 2), "UTF-8");
    }

    public static byte[] decodeBase64ToBytes(String str) {
        return decodeBase64ToBytes(str.getBytes("UTF-8"));
    }

    public static byte[] decodeBase64ToBytes(byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    public static byte[] decodeRSA(byte[] bArr, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int length = bArr.length / 128;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length * f3070i);
        Cipher cipher = Cipher.getInstance(f3067f);
        cipher.init(2, privateKey);
        for (int i = 0; i < length; i++) {
            byteBufferAllocate.put(cipher.doFinal(bArr, i * 128, 128));
        }
        byte[] bArr2 = new byte[byteBufferAllocate.position()];
        byteBufferAllocate.position(0);
        byteBufferAllocate.get(bArr2);
        return bArr2;
    }

    public static String encodeAES(String str) {
        return encodeAES(str, f3063b);
    }

    public static String encodeAES(String str, byte[] bArr) {
        return encodeAES(str.getBytes("UTF-8"), bArr);
    }

    public static String encodeAES(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f3064c);
        Cipher cipher = Cipher.getInstance(f3065d);
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return encodeBase64(cipher.doFinal(bArr));
    }

    public static byte[] encodeAES2(byte[] bArr) {
        return encodeAES2(bArr, f3063b);
    }

    public static byte[] encodeAES2(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (bArr.length <= 0) {
            return new byte[0];
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f3064c);
        Cipher cipher = Cipher.getInstance(f3065d);
        cipher.init(1, secretKeySpec, ivParameterSpec);
        return cipher.doFinal(bArr);
    }

    public static String encodeBase64(String str) {
        return encodeBase64(str.getBytes("UTF-8"));
    }

    public static String encodeBase64(byte[] bArr) {
        return new String(Base64.encode(bArr, 2), "UTF-8");
    }

    public static byte[] encodeRSA(String str, PublicKey publicKey) {
        return encodeRSA(str.getBytes("UTF-8"), publicKey);
    }

    public static byte[] encodeRSA(byte[] bArr, PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        int length = bArr.length / f3070i;
        int length2 = bArr.length % f3070i;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((length2 > 0 ? length + 1 : length) * 128);
        Cipher cipher = Cipher.getInstance(f3067f);
        cipher.init(1, publicKey);
        for (int i = 0; i < length; i++) {
            byteBufferAllocate.put(cipher.doFinal(bArr, i * f3070i, f3070i));
        }
        if (length2 > 0) {
            byteBufferAllocate.put(cipher.doFinal(bArr, length * f3070i, length2));
        }
        return byteBufferAllocate.array();
    }

    public static byte[] getCipherKey(int i) {
        byte[] bArr = new byte[i];
        try {
            SecureRandom.getInstance("SHA1PRNG").nextBytes(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return bArr;
    }

    public static KeyPair getKeyPair(String str, int i) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str);
        keyPairGenerator.initialize(i);
        return keyPairGenerator.generateKeyPair();
    }

    public static String getMd5Hash(String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))) {
            int i = b & 255;
            if (i < 16) {
                stringBuffer.append('0').append(Integer.toHexString(i));
            } else {
                stringBuffer.append(Integer.toHexString(i));
            }
        }
        return stringBuffer.toString();
    }

    public static String getNonce() throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        if (secureRandom != null) {
            return new DecimalFormat("#0000000000").format((long) (secureRandom.nextDouble() * 1.0E10d));
        }
        return null;
    }

    public static KeyPair getRSAKeyPair() {
        return getKeyPair(f3066e, 1024);
    }

    public static String getSHAHash(String str) {
        try {
            return getSHAHash(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String getSHAHash(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (byte b : MessageDigest.getInstance("SHA-256").digest(bArr)) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append('0').append(Integer.toHexString(i));
                } else {
                    stringBuffer.append(Integer.toHexString(i));
                }
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static String unzipToBase64(String str) throws IOException {
        String string = null;
        try {
            byte[] bArrDecodeBase64ToBytes = decodeBase64ToBytes(str);
            Inflater inflater = new Inflater();
            inflater.setInput(bArrDecodeBase64ToBytes);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArrDecodeBase64ToBytes.length);
            byte[] bArr = new byte[1024];
            while (!inflater.finished()) {
                byteArrayOutputStream.write(bArr, 0, inflater.inflate(bArr));
            }
            string = byteArrayOutputStream.toString();
            byteArrayOutputStream.close();
            inflater.end();
            return string;
        } catch (IOException e) {
            Log.m2958e("decompressString() bos.close() io Error !!");
            return string;
        } catch (DataFormatException e2) {
            Log.m2958e("decompressString() decompresser.inflate Error !!");
            return string;
        }
    }

    public static String zipToBase64(String str) throws IOException {
        String strEncodeBase64 = null;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Deflater deflater = new Deflater();
            deflater.setLevel(9);
            deflater.setInput(bytes);
            deflater.finish();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bytes.length);
            byte[] bArr = new byte[1024];
            while (!deflater.finished()) {
                byteArrayOutputStream.write(bArr, 0, deflater.deflate(bArr));
            }
            strEncodeBase64 = encodeBase64(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            return strEncodeBase64;
        } catch (UnsupportedEncodingException e) {
            Log.m2958e("compressString() Encoding to UTF-8 Error !!");
            return strEncodeBase64;
        } catch (IOException e2) {
            Log.m2958e("compressString() ByteArrayOutputStream Close Error !!");
            return strEncodeBase64;
        }
    }

    public static String zipToBase64WithFile(String str) throws IOException {
        String strEncodeBase64 = null;
        try {
            byte[] bytes = str.getBytes("UTF-8");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            zipOutputStream.putNextEntry(new ZipEntry("logcat.log"));
            zipOutputStream.write(bytes);
            zipOutputStream.close();
            strEncodeBase64 = encodeBase64(byteArrayOutputStream.toByteArray());
            byteArrayOutputStream.close();
            return strEncodeBase64;
        } catch (UnsupportedEncodingException e) {
            Log.m2958e("compressString() Encoding to UTF-8 Error !!");
            return strEncodeBase64;
        } catch (IOException e2) {
            Log.m2958e("compressString() ByteArrayOutputStream Close Error !!");
            return strEncodeBase64;
        }
    }
}
