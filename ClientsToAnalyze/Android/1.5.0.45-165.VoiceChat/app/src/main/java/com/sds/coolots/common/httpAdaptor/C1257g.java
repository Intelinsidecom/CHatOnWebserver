package com.sds.coolots.common.httpAdaptor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* renamed from: com.sds.coolots.common.httpAdaptor.g */
/* loaded from: classes.dex */
public class C1257g implements LayeredSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f3052a = null;

    /* renamed from: a */
    private SSLSocketFactory m2945a() throws NoSuchAlgorithmException, IOException, KeyManagementException {
        if (this.f3052a == null) {
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, null);
                this.f3052a = sSLContext.getSocketFactory();
            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        return this.f3052a;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) {
        SSLSocket sSLSocket = socket == null ? (SSLSocket) createSocket() : (SSLSocket) socket;
        if (sSLSocket != null) {
            if (i2 < 0) {
                i2 = 0;
            }
            if (i2 >= 0 || inetAddress != null) {
                sSLSocket.bind(new InetSocketAddress(inetAddress, i2));
            }
            sSLSocket.connect(new InetSocketAddress(str, i), HttpConnectionParams.getConnectionTimeout(httpParams));
            sSLSocket.setSoTimeout(HttpConnectionParams.getSoTimeout(httpParams));
        }
        return sSLSocket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() {
        return m2945a().createSocket();
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m2945a().createSocket(socket, str, i, z);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) {
        return true;
    }
}
