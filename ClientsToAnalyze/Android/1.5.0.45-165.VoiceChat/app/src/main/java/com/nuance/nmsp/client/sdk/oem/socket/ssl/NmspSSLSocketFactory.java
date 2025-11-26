package com.nuance.nmsp.client.sdk.oem.socket.ssl;

import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class NmspSSLSocketFactory {

    /* renamed from: a */
    private static SSLSocketFactory f385a;

    /* renamed from: b */
    private static SSLContext f386b;

    /* renamed from: c */
    private static NmspX509TrustManager[] f387c = new NmspX509TrustManager[1];

    public static Socket createSocket(String str, int i, SSLSettings sSLSettings) throws NoSuchAlgorithmException, IOException, SecurityException, KeyManagementException {
        try {
            f387c[0] = new NmspX509TrustManager(sSLSettings);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            f386b = sSLContext;
            sSLContext.init(null, f387c, null);
            f385a = f386b.getSocketFactory();
            return f385a.createSocket(str, i);
        } catch (KeyManagementException e) {
            throw new SecurityException("Failed to initialize the client-side SSLContext " + e);
        } catch (NoSuchAlgorithmException e2) {
            throw new SecurityException("No such algorithm exception " + e2);
        } catch (GeneralSecurityException e3) {
            throw new SecurityException("General security exception " + e3);
        }
    }
}
