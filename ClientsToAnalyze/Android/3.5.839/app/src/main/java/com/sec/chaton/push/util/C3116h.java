package com.sec.chaton.push.util;

import android.content.Context;
import com.sec.chaton.push.C3043a;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: SecurityUtil.java */
/* renamed from: com.sec.chaton.push.util.h */
/* loaded from: classes.dex */
public class C3116h {
    /* renamed from: a */
    public static KeyManagerFactory m12707a(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
        keyManagerFactory.init(m12709c(context), "sppkeystore".toCharArray());
        return keyManagerFactory;
    }

    /* renamed from: b */
    public static TrustManagerFactory m12708b(Context context) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        trustManagerFactory.init(m12709c(context));
        return trustManagerFactory;
    }

    /* renamed from: c */
    private static KeyStore m12709c(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(context.getResources().openRawResource(C3043a.f11296a), "sppkeystore".toCharArray());
        return keyStore;
    }
}
