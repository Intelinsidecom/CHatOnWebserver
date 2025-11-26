package com.sec.chaton.access_token;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: AccessTokenPublic.java */
/* renamed from: com.sec.chaton.access_token.a */
/* loaded from: classes.dex */
public class C0231a {

    /* renamed from: a */
    static String f565a = "RSA";

    /* renamed from: b */
    static String f566b = "RSA/ECB/PKCS1Padding";

    /* renamed from: c */
    static final BigInteger f567c = new BigInteger("162917746082800006609396393156544595934994419448424010353861094264905557738119170390136000548400974135569320180057055487100797127253177821646338697630275127623045825478550509753987654639076726971137648987762241460900689074535221665974341410648078567303975859788861356221602989520211757639301528720568101878281");

    /* renamed from: d */
    private static final BigInteger f568d = new BigInteger("65537");

    /* renamed from: e */
    private static PublicKey f569e = m885a();

    /* renamed from: a */
    private static PublicKey m885a() {
        try {
            return KeyFactory.getInstance(f565a).generatePublic(new RSAPublicKeySpec(f567c, f568d));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static boolean m886a(Context context, int i) {
        if (i == Process.myUid() || i < 10000) {
            return true;
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null || "".equals(packagesForUid[0])) {
            return false;
        }
        for (int i2 = 0; i2 < packagesForUid.length; i2++) {
            if ("com.android.contacts".equals(packagesForUid[i2])) {
                return m887a(context, packagesForUid[i2]);
            }
        }
        return m887a(context, packagesForUid[0]);
    }

    /* renamed from: a */
    public static boolean m887a(Context context, String str) throws NoSuchPaddingException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 4160);
            byte[] bArrM889a = m889a(str, packageInfo.signatures[0].toByteArray());
            byte[] bArrM891a = m891a(packageInfo.requestedPermissions);
            if (bArrM889a == null || bArrM891a == null) {
                return false;
            }
            return Arrays.equals(bArrM889a, bArrM891a);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    static byte[] m889a(String str, byte[] bArr) {
        byte[] bArrM892b = m892b(bArr);
        byte[] bArr2 = new byte[str.length() + bArrM892b.length];
        for (int i = 0; i < str.length(); i++) {
            bArr2[i] = (byte) str.charAt(i);
        }
        int length = str.length();
        for (int i2 = 0; i2 < bArrM892b.length; i2++) {
            bArr2[length + i2] = bArrM892b[i2];
        }
        return bArr2;
    }

    /* renamed from: a */
    private static byte[] m891a(String[] strArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] bArrM890a = null;
        if (strArr != null) {
            for (String str : strArr) {
                if (str.startsWith("com.sec.chaton.TOKEN_")) {
                    bArrM890a = m890a(m888a(str.substring("com.sec.chaton.TOKEN_".length())));
                }
            }
        }
        return bArrM890a;
    }

    /* renamed from: a */
    private static byte[] m890a(byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance(f566b);
            cipher.init(2, f569e);
            return cipher.doFinal(bArr);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m892b(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m888a(String str) {
        int i = 0;
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            char cCharAt2 = str.charAt(i + 1);
            int i3 = i2 + 1;
            bArr[i2] = (byte) ((cCharAt2 >= 'a' ? (cCharAt2 - 'a') + 10 : cCharAt2 - '0') | ((cCharAt >= 'a' ? (cCharAt - 'a') + 10 : cCharAt - '0') << 4));
            i += 2;
            i2 = i3;
        }
        return bArr;
    }
}
