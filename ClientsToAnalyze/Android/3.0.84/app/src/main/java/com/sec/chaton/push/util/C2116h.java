package com.sec.chaton.push.util;

import android.content.Context;
import com.sec.chaton.push.C2043a;
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
public class C2116h {
    /* renamed from: a */
    public static KeyManagerFactory m8365a(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
        keyManagerFactory.init(m8367c(context), "sppkeystore".toCharArray());
        return keyManagerFactory;
    }

    /* renamed from: b */
    public static TrustManagerFactory m8366b(Context context) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        trustManagerFactory.init(m8367c(context));
        return trustManagerFactory;
    }

    /* renamed from: c */
    private static KeyStore m8367c(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(context.getResources().openRawResource(C2043a.f7886a), "sppkeystore".toCharArray());
        return keyStore;
    }
}
