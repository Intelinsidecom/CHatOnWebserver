package com.sec.chaton.push.util;

import android.content.Context;
import com.sec.chaton.R;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;

/* compiled from: SecurityUtil.java */
/* renamed from: com.sec.chaton.push.util.b */
/* loaded from: classes.dex */
public class C0916b {
    /* renamed from: a */
    public static KeyManagerFactory m3612a(Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
        keyManagerFactory.init(m3614c(context), "sppkeystore".toCharArray());
        return keyManagerFactory;
    }

    /* renamed from: b */
    public static TrustManagerFactory m3613b(Context context) throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
        trustManagerFactory.init(m3614c(context));
        return trustManagerFactory;
    }

    /* renamed from: c */
    private static KeyStore m3614c(Context context) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(context.getResources().openRawResource(R.raw.spp916), "sppkeystore".toCharArray());
        return keyStore;
    }
}
