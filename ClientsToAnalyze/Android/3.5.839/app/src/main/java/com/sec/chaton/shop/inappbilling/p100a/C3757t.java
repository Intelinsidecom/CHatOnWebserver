package com.sec.chaton.shop.inappbilling.p100a;

import android.text.TextUtils;
import android.util.Log;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: Security.java */
/* renamed from: com.sec.chaton.shop.inappbilling.a.t */
/* loaded from: classes.dex */
public class C3757t {
    /* renamed from: a */
    public static boolean m14144a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            Log.e("IABUtil/Security", "Purchase verification failed: missing data.");
            return false;
        }
        return m14145a(m14143a(str), str2, str3);
    }

    /* renamed from: a */
    public static PublicKey m14143a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(C3738a.m14097a(str)));
        } catch (C3739b e) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    /* renamed from: a */
    public static boolean m14145a(PublicKey publicKey, String str, String str2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        try {
            Signature signature = Signature.getInstance("SHA1withRSA");
            signature.initVerify(publicKey);
            signature.update(str.getBytes());
            if (!signature.verify(C3738a.m14097a(str2))) {
                Log.e("IABUtil/Security", "Signature verification failed.");
                return false;
            }
            return true;
        } catch (C3739b e) {
            Log.e("IABUtil/Security", "Base64 decoding failed.");
            return false;
        } catch (InvalidKeyException e2) {
            Log.e("IABUtil/Security", "Invalid key specification.");
            return false;
        } catch (NoSuchAlgorithmException e3) {
            Log.e("IABUtil/Security", "NoSuchAlgorithmException.");
            return false;
        } catch (SignatureException e4) {
            Log.e("IABUtil/Security", "Signature exception.");
            return false;
        }
    }
}
