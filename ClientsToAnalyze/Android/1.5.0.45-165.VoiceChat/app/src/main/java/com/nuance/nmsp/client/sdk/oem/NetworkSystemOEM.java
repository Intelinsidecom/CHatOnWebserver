package com.nuance.nmsp.client.sdk.oem;

import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import com.nuance.nmsp.client.sdk.oem.socket.ssl.NmspSSLSocketFactory;
import com.nuance.nmsp.client.sdk.oem.socket.ssl.SSLSettings;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Vector;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public class NetworkSystemOEM implements MessageSystem.MessageHandler, NetworkSystem {

    /* renamed from: a */
    private static final LogFactory.Log f315a = LogFactory.getLog(NetworkSystemOEM.class);

    /* renamed from: c */
    private static final Integer f316c = new Integer(0);

    /* renamed from: d */
    private static final Integer f317d = new Integer(1);

    /* renamed from: e */
    private static final Integer f318e = new Integer(2);

    /* renamed from: f */
    private static final Integer f319f = new Integer(3);

    /* renamed from: b */
    private MessageSystem f320b;

    /* renamed from: g */
    private Object f321g = new Object();

    /* renamed from: com.nuance.nmsp.client.sdk.oem.NetworkSystemOEM$a */
    static class C0522a {

        /* renamed from: a */
        Socket f322a;

        /* renamed from: b */
        NetworkSystem.CloseSocketCallback f323b;

        /* renamed from: c */
        InputStream f324c;

        /* renamed from: d */
        OutputStream f325d;

        /* renamed from: e */
        Object f326e;

        /* renamed from: f */
        C0524c f327f;

        public C0522a(Socket socket, NetworkSystem.CloseSocketCallback closeSocketCallback, Object obj, InputStream inputStream, OutputStream outputStream, C0524c c0524c) {
            this.f324c = null;
            this.f325d = null;
            this.f326e = null;
            this.f327f = null;
            this.f322a = socket;
            this.f323b = closeSocketCallback;
            this.f326e = obj;
            this.f324c = inputStream;
            this.f325d = outputStream;
            this.f327f = c0524c;
        }
    }

    /* renamed from: com.nuance.nmsp.client.sdk.oem.NetworkSystemOEM$b */
    class C0523b {

        /* renamed from: a */
        byte[] f328a;

        /* renamed from: b */
        int f329b;

        /* renamed from: c */
        int f330c;

        /* renamed from: d */
        NetworkSystem.ReadSocketCallback f331d;

        /* renamed from: e */
        Object f332e;

        public C0523b(NetworkSystemOEM networkSystemOEM, NetworkSystem.NetworkReadMode networkReadMode, byte[] bArr, int i, int i2, NetworkSystem.ReadSocketCallback readSocketCallback, Object obj) {
            this.f328a = bArr;
            this.f329b = i;
            this.f330c = i2;
            this.f331d = readSocketCallback;
            this.f332e = obj;
        }
    }

    /* renamed from: com.nuance.nmsp.client.sdk.oem.NetworkSystemOEM$c */
    class C0524c extends Thread {

        /* renamed from: a */
        private String f333a;

        /* renamed from: b */
        private int f334b;

        /* renamed from: c */
        private NetworkSystem.OpenSocketCallback f335c;

        /* renamed from: d */
        private NetworkSystem.CloseSocketCallback f336d;

        /* renamed from: e */
        private Object f337e;

        /* renamed from: f */
        private NetworkSystem.NetworkStatus f338f;

        /* renamed from: g */
        private boolean f339g;

        /* renamed from: h */
        private Vector f340h;

        /* renamed from: i */
        private SSLSettings f341i;

        /* renamed from: j */
        private boolean f342j;

        public C0524c(String str, int i, NetworkSystem.OpenSocketCallback openSocketCallback, NetworkSystem.CloseSocketCallback closeSocketCallback, Object obj) {
            this.f333a = null;
            this.f335c = null;
            this.f336d = null;
            this.f337e = null;
            this.f338f = NetworkSystem.NetworkStatus.NETWORK_OK;
            this.f339g = false;
            this.f340h = null;
            this.f341i = null;
            this.f342j = false;
            this.f333a = str;
            this.f334b = i;
            this.f335c = openSocketCallback;
            this.f336d = closeSocketCallback;
            this.f337e = obj;
            this.f340h = new Vector();
        }

        public C0524c(String str, int i, SSLSettings sSLSettings, NetworkSystem.OpenSocketCallback openSocketCallback, NetworkSystem.CloseSocketCallback closeSocketCallback, Object obj) {
            this.f333a = null;
            this.f335c = null;
            this.f336d = null;
            this.f337e = null;
            this.f338f = NetworkSystem.NetworkStatus.NETWORK_OK;
            this.f339g = false;
            this.f340h = null;
            this.f341i = null;
            this.f342j = false;
            this.f333a = str;
            this.f334b = i;
            this.f335c = openSocketCallback;
            this.f336d = closeSocketCallback;
            this.f337e = obj;
            this.f340h = new Vector();
            this.f342j = true;
            this.f341i = sSLSettings;
        }

        /* renamed from: a */
        public final NetworkSystem.NetworkStatus m117a(C0523b c0523b) {
            NetworkSystem.NetworkStatus networkStatus;
            Object obj;
            if (this.f339g) {
                if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                    NetworkSystemOEM.f315a.error("SocketReadThread is already stopping!");
                }
                return NetworkSystem.NetworkStatus.NETWORK_ERROR;
            }
            NetworkSystem.NetworkStatus networkStatus2 = NetworkSystem.NetworkStatus.NETWORK_OK;
            synchronized (NetworkSystemOEM.this.f321g) {
                if (this.f340h == null) {
                    networkStatus = NetworkSystem.NetworkStatus.NETWORK_ERROR;
                    obj = "SocketReadThread: queue is null!!";
                } else {
                    this.f340h.addElement(c0523b);
                    networkStatus = networkStatus2;
                    obj = null;
                }
                NetworkSystemOEM.this.f321g.notify();
            }
            if (!NetworkSystemOEM.f315a.isErrorEnabled() || obj == null) {
                return networkStatus;
            }
            NetworkSystemOEM.f315a.error(obj);
            return networkStatus;
        }

        /* renamed from: a */
        public final void m118a() {
            synchronized (NetworkSystemOEM.this.f321g) {
                this.f339g = true;
                this.f340h.removeAllElements();
                this.f340h = null;
                NetworkSystemOEM.this.f321g.notify();
            }
        }

        /* renamed from: b */
        public final void m119b() {
            String str = null;
            synchronized (NetworkSystemOEM.this.f321g) {
                if (this.f340h == null) {
                    str = "SocketReadThread.cleanPendingJobs(): queue is null!!";
                } else {
                    this.f340h.removeAllElements();
                }
            }
            if (!NetworkSystemOEM.f315a.isErrorEnabled() || str == null) {
                return;
            }
            NetworkSystemOEM.f315a.error(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() throws IOException {
            C0523b c0523b;
            if (NetworkSystemOEM.f315a.isDebugEnabled()) {
                NetworkSystemOEM.f315a.debug("Open Socket connection on host:- [" + this.f333a + "] and port[" + this.f334b + "]");
            }
            try {
                Socket socketCreateSocket = this.f342j ? NmspSSLSocketFactory.createSocket(this.f333a, this.f334b, this.f341i) : new Socket(this.f333a, this.f334b);
                if (!socketCreateSocket.isConnected()) {
                    if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                        NetworkSystemOEM.f315a.error("SocketReadThread NETWORK_ERROR. !sock.isConnected()");
                    }
                    NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
                    return;
                }
                try {
                    if (this.f342j) {
                        ((SSLSocket) socketCreateSocket).setUseClientMode(true);
                    }
                    socketCreateSocket.setTcpNoDelay(true);
                    socketCreateSocket.setKeepAlive(true);
                    socketCreateSocket.setSoLinger(true, 40);
                } catch (Exception e) {
                    if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                        NetworkSystemOEM.f315a.error("Set Socket Option Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
                    }
                }
                try {
                    InputStream inputStream = socketCreateSocket.getInputStream();
                    C0522a c0522a = new C0522a(socketCreateSocket, this.f336d, this.f337e, inputStream, socketCreateSocket.getOutputStream(), this);
                    NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_OK, c0522a, this.f337e});
                    while (!this.f339g) {
                        try {
                            synchronized (NetworkSystemOEM.this.f321g) {
                                while (!this.f339g && this.f340h != null && this.f340h.isEmpty()) {
                                    try {
                                        NetworkSystemOEM.this.f321g.wait();
                                    } catch (Exception e2) {
                                        if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                                            NetworkSystemOEM.f315a.error("InterruptedException ie:" + e2);
                                        }
                                    }
                                }
                                if (this.f339g || this.f340h == null) {
                                    return;
                                }
                                c0523b = (C0523b) this.f340h.elementAt(0);
                                this.f340h.removeElementAt(0);
                            }
                            int i = 0;
                            while (true) {
                                try {
                                    if (i >= c0523b.f330c) {
                                        break;
                                    }
                                    int i2 = inputStream.read(c0523b.f328a, c0523b.f329b + i, c0523b.f330c - i);
                                    if (i2 >= 0) {
                                        i += i2;
                                    } else if (!this.f339g) {
                                        this.f338f = NetworkSystem.NetworkStatus.NETWORK_ERROR;
                                    }
                                } catch (IOException e3) {
                                    if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                                        NetworkSystemOEM.f315a.error("Socket Read/Available Expception - [" + e3.getClass().getName() + "] Message - [" + e3.getMessage() + "]");
                                    }
                                    this.f338f = NetworkSystem.NetworkStatus.NETWORK_ERROR;
                                }
                            }
                            if (this.f338f == NetworkSystem.NetworkStatus.NETWORK_OK) {
                                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f318e, c0523b.f331d, NetworkSystem.NetworkStatus.NETWORK_OK, c0522a, c0523b.f328a, new Integer(c0523b.f329b), new Integer(c0523b.f330c), new Integer(c0523b.f330c), c0523b.f332e});
                            } else {
                                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f318e, c0523b.f331d, NetworkSystem.NetworkStatus.NETWORK_ERROR, c0522a, c0523b.f328a, new Integer(c0523b.f329b), new Integer(c0523b.f330c), new Integer(0), c0523b.f332e});
                                NetworkSystemOEM.this.closeSocket(c0522a);
                            }
                        } catch (Exception e4) {
                            if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                                NetworkSystemOEM.f315a.error("NetworkSystemJ2me.run() " + e4.getClass().getName() + " " + e4.getMessage());
                                return;
                            }
                            return;
                        }
                    }
                } catch (IOException e5) {
                    try {
                        socketCreateSocket.close();
                    } catch (IOException e6) {
                    }
                    if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                        NetworkSystemOEM.f315a.error("Set Socket Option Exception - [" + e5.getClass().getName() + "] Message - [" + e5.getMessage() + "]");
                    }
                    NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
                }
            } catch (IOException e7) {
                if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                    NetworkSystemOEM.f315a.error("Open Streams Exception - [" + e7.getClass().getName() + "] Message - [" + e7.getMessage() + "]");
                }
                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
            } catch (SecurityException e8) {
                if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                    NetworkSystemOEM.f315a.error("Open Streams Exception - [" + e8.getClass().getName() + "] Message - [" + e8.getMessage() + "]");
                }
                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
            } catch (UnknownHostException e9) {
                if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                    NetworkSystemOEM.f315a.error("Open Streams Exception - [" + e9.getClass().getName() + "] Message - [" + e9.getMessage() + "]");
                }
                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
            } catch (Throwable th) {
                if (NetworkSystemOEM.f315a.isErrorEnabled()) {
                    NetworkSystemOEM.f315a.error("Open Streams Exception - [" + th.getClass().getName() + "] Message - [" + th.getMessage() + "]");
                }
                NetworkSystemOEM.this.m113a(new Object[]{NetworkSystemOEM.f316c, this.f335c, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, this.f337e});
            }
        }
    }

    public NetworkSystemOEM(MessageSystem messageSystem) {
        this.f320b = null;
        this.f320b = messageSystem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m113a(Object[] objArr) {
        this.f320b.send(objArr, this, this.f320b.getMyAddr(), this.f320b.getVRAddr()[0]);
    }

    public static void terminate() {
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public void clearPendingOps(Object obj) {
        C0522a c0522a = (C0522a) obj;
        if (c0522a.f327f != null) {
            c0522a.f327f.m119b();
            return;
        }
        if (f315a.isDebugEnabled()) {
            f315a.debug("SOCKET WRITE ERROR: socket read thread is null");
        }
        closeSocket(obj);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public void closeSocket(Object obj) {
        boolean z;
        C0522a c0522a = (C0522a) obj;
        if (c0522a == null) {
            return;
        }
        synchronized (this.f321g) {
            if (c0522a.f327f == null) {
                return;
            }
            if (c0522a.f327f.f339g) {
                z = false;
            } else {
                c0522a.f327f.m118a();
                c0522a.f327f = null;
                z = true;
            }
            if (c0522a.f322a == null || !z) {
                return;
            }
            try {
                c0522a.f324c.close();
                c0522a.f324c = null;
                c0522a.f322a.close();
                c0522a.f322a = null;
                m113a(new Object[]{f317d, c0522a.f323b, NetworkSystem.NetworkStatus.NETWORK_OK, obj, c0522a.f326e});
            } catch (Throwable th) {
                if (f315a.isErrorEnabled()) {
                    f315a.error("Socket Close Expception - [" + th.getClass().getName() + "] Message - [" + th.getMessage() + "]");
                }
                m113a(new Object[]{f317d, c0522a.f323b, NetworkSystem.NetworkStatus.NETWORK_ERROR, obj, c0522a.f326e});
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        if (objArr[0] == f316c) {
            ((NetworkSystem.OpenSocketCallback) objArr[1]).openSocketCallback((NetworkSystem.NetworkStatus) objArr[2], objArr[3], objArr[4]);
            return;
        }
        if (objArr[0] == f317d) {
            ((NetworkSystem.CloseSocketCallback) objArr[1]).closeSocketCallback((NetworkSystem.NetworkStatus) objArr[2], objArr[3], objArr[4]);
        } else if (objArr[0] == f318e) {
            ((NetworkSystem.ReadSocketCallback) objArr[1]).readSocketCallback((NetworkSystem.NetworkStatus) objArr[2], objArr[3], (byte[]) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), objArr[8]);
        } else if (objArr[0] == f319f) {
            ((NetworkSystem.WriteSocketCallback) objArr[1]).writeSocketCallback((NetworkSystem.NetworkStatus) objArr[2], objArr[3], (byte[]) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), objArr[8]);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public boolean isNetworkHealthy() {
        return true;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public void openSSLSocket(String str, int i, Vector vector, NetworkSystem.OpenSocketCallback openSocketCallback, NetworkSystem.CloseSocketCallback closeSocketCallback, Object obj) {
        SSLSettings sSLSettings = new SSLSettings();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Parameter parameter = (Parameter) enumerationElements.nextElement();
            if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_SELFSIGNED_CERT) && (new String(parameter.getValue()).equals("TRUE") || new String(parameter.getValue()).equals("true"))) {
                sSLSettings.enableSelfSignedCert = true;
            }
            if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_CERT_SUMMARY)) {
                sSLSettings.certSummary = new String(parameter.getValue());
            }
            if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_CERT_DATA)) {
                sSLSettings.certData = new String(parameter.getValue());
            }
        }
        try {
            new C0524c(str, i, sSLSettings, openSocketCallback, closeSocketCallback, obj).start();
        } catch (Exception e) {
            if (f315a.isErrorEnabled()) {
                f315a.error("Open Socket Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m113a(new Object[]{f316c, openSocketCallback, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, obj});
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public void openSocket(String str, int i, NetworkSystem.OpenSocketCallback openSocketCallback, NetworkSystem.CloseSocketCallback closeSocketCallback, Object obj) {
        try {
            new C0524c(str, i, openSocketCallback, closeSocketCallback, obj).start();
        } catch (Exception e) {
            if (f315a.isErrorEnabled()) {
                f315a.error("Open Socket Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m113a(new Object[]{f316c, openSocketCallback, NetworkSystem.NetworkStatus.NETWORK_ERROR, null, obj});
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public void setSessionId(Object obj, byte[] bArr) {
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public NetworkSystem.NetworkStatus socketRead(Object obj, NetworkSystem.NetworkReadMode networkReadMode, byte[] bArr, int i, int i2, NetworkSystem.ReadSocketCallback readSocketCallback, Object obj2) {
        if (networkReadMode != NetworkSystem.NetworkReadMode.NETWORK_READ_FULL) {
            if (f315a.isErrorEnabled()) {
                f315a.error("Blackberry NetworkSystem only supports NETWORK_READ_FULL");
            }
            return NetworkSystem.NetworkStatus.NETWORK_ERROR;
        }
        C0522a c0522a = (C0522a) obj;
        if (c0522a.f327f == null) {
            if (f315a.isDebugEnabled()) {
                f315a.debug("SOCKET READ ERROR: socket read thread is null");
            }
            return NetworkSystem.NetworkStatus.NETWORK_ERROR;
        }
        if (!c0522a.f327f.f339g) {
            return c0522a.f327f.m117a(new C0523b(this, networkReadMode, bArr, i, i2, readSocketCallback, obj2));
        }
        if (f315a.isErrorEnabled()) {
            f315a.error("socket read thread is stopping");
        }
        return NetworkSystem.NetworkStatus.NETWORK_ERROR;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem
    public NetworkSystem.NetworkStatus socketWrite(Object obj, byte[] bArr, int i, int i2, NetworkSystem.WriteSocketCallback writeSocketCallback, Object obj2) throws IOException {
        C0522a c0522a = (C0522a) obj;
        if (c0522a.f322a == null || c0522a.f325d == null) {
            return NetworkSystem.NetworkStatus.NETWORK_ERROR;
        }
        OutputStream outputStream = c0522a.f325d;
        try {
            outputStream.write(bArr, i, i2);
            outputStream.flush();
            m113a(new Object[]{f319f, writeSocketCallback, NetworkSystem.NetworkStatus.NETWORK_OK, obj, bArr, new Integer(i), new Integer(i2), new Integer(i2), obj2});
            return NetworkSystem.NetworkStatus.NETWORK_OK;
        } catch (Exception e) {
            if (f315a.isErrorEnabled()) {
                f315a.error("Socket Write Exception - [" + e.getClass().getName() + "] Message - [" + e.getMessage() + "]");
            }
            m113a(new Object[]{f319f, writeSocketCallback, NetworkSystem.NetworkStatus.NETWORK_ERROR, obj, bArr, new Integer(i), new Integer(i2), new Integer(0), obj2});
            closeSocket(obj);
            return NetworkSystem.NetworkStatus.NETWORK_ERROR;
        }
    }
}
