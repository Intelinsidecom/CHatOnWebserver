package com.vlingo.sdk.internal.crypto;

/* loaded from: classes.dex */
public class CryptoUtils {
    public static final int HASH_TYPE_DEFAULT = 2;
    public static final int HASH_TYPE_MD5 = 1;
    public static final int HASH_TYPE_NONE = 0;
    public static final int HASH_TYPE_SHA256 = 2;

    public static String getMD5(String input) {
        return getHash(input, 1);
    }

    public static String getSHA256(String input) {
        return getHash(input, 2);
    }

    public static String getHash(String input, int hashType) {
        HashFunction func = null;
        if (hashType == 1) {
            func = new MD5();
        } else if (hashType == 2) {
            func = new SHA256();
        }
        return func == null ? input : func.hash(input);
    }
}
