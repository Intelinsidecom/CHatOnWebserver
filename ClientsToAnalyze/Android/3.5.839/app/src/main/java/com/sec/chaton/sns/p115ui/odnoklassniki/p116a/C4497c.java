package com.sec.chaton.sns.p115ui.odnoklassniki.p116a;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: OkEncryptUtil.java */
/* renamed from: com.sec.chaton.sns.ui.odnoklassniki.a.c */
/* loaded from: classes.dex */
public class C4497c {
    /* renamed from: a */
    public static final String m17035a(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02X", Byte.valueOf(b2)));
            }
            return sb.toString().toLowerCase();
        } catch (Exception e) {
            return null;
        }
    }
}
