package com.nuance.nmsp.client.sdk.oem.socket.ssl;

import com.nuance.nmsp.client.sdk.common.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class NmspX509TrustManager implements X509TrustManager {

    /* renamed from: b */
    private static X509TrustManager f388b;

    /* renamed from: a */
    private SSLSettings f389a;

    public NmspX509TrustManager(SSLSettings sSLSettings) throws GeneralSecurityException {
        this.f389a = sSLSettings;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        f388b = (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            f388b.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e) {
            if (!this.f389a.enableSelfSignedCert) {
                throw e;
            }
        }
        if (this.f389a.certSummary != null) {
            boolean z = false;
            for (X509Certificate x509Certificate : x509CertificateArr) {
                String name = x509Certificate.getSubjectDN().getName();
                int iIndexOf = name.indexOf("CN=") + 3;
                if (this.f389a.certSummary.equals(name.substring(iIndexOf, name.indexOf(44, iIndexOf)))) {
                    z = true;
                }
            }
            if (!z) {
                throw new CertificateException("certificate summary is not identical");
            }
        }
        if (this.f389a.certData != null) {
            boolean z2 = false;
            for (X509Certificate x509Certificate2 : x509CertificateArr) {
                if (this.f389a.certData.equals(Base64.encode(x509Certificate2.getEncoded()))) {
                    z2 = true;
                }
            }
            if (!z2) {
                throw new CertificateException("certificate data is not identical");
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return f388b.getAcceptedIssuers();
    }
}
