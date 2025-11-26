package com.nuance.nmsp.client.sdk.components.core;

import com.infraware.office.evengine.InterfaceC0507E;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolBuilder;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.common.protocols.XModeMsgHeader;
import com.nuance.nmsp.client.sdk.common.util.ByteConversion;
import com.nuance.nmsp.client.sdk.components.general.Parameter;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public class XMode implements MessageSystem.MessageHandler, NetworkSystem.CloseSocketCallback, NetworkSystem.OpenSocketCallback, NetworkSystem.ReadSocketCallback, NetworkSystem.WriteSocketCallback {
    public static final String NET_CONTEXT_SEND_BCP_BEGIN = "SEND_BCP_BEGIN";
    public static final String NET_CONTEXT_SEND_BCP_CANCEL = "SEND_BCP_CANCEL";
    public static final String NET_CONTEXT_SEND_BCP_DATA = "SEND_BCP_DATA";
    public static final String NET_CONTEXT_SEND_BCP_FREE_RESOURCE = "SEND_BCP_FREE_RESOURCE";
    public static final String NET_CONTEXT_SEND_BCP_FREE_RESOURCE_ID = "SEND_BCP_FREE_RESOURCE_ID";
    public static final String NET_CONTEXT_SEND_BCP_GENERATE_AUDIO = "SEND_BCP_GENERATE_AUDIO";
    public static final String NET_CONTEXT_SEND_BCP_GET_PARAMS = "SEND_BCP_GET_PARAMS";
    public static final String NET_CONTEXT_SEND_BCP_LOAD_GRAMMAR = "SEND_BCP_LOAD_GRAMMAR";
    public static final String NET_CONTEXT_SEND_BCP_LOAD_RESOURCE = "SEND_BCP_LOAD_RESOURCE";
    public static final String NET_CONTEXT_SEND_BCP_RECOGNIZE = "SEND_BCP_RECOGNIZE";
    public static final String NET_CONTEXT_SEND_BCP_SET_PARAMS = "SEND_BCP_SET_PARAMS";
    public static final byte STATE_CLOSED = 3;
    public static final byte STATE_CLOSING = 2;
    public static final byte STATE_CONNECTED = 1;
    public static final byte STATE_CONNECTING = 0;
    public static final short XMODE_SESSION_IDLE_FOR_TOO_LONG = 3;
    public static final short XMODE_SOCKET_CLOSED_COP_CONNECT_FAILED = 7;
    public static final short XMODE_SOCKET_CLOSED_COP_CONNECT_TIMEOUT = 5;
    public static final short XMODE_SOCKET_CLOSED_COP_DISCONNECT = 6;
    public static final short XMODE_SOCKET_CLOSED_DISCONNECT = 1;
    public static final short XMODE_SOCKET_CLOSED_NETWORK_ERROR = 8;
    public static final short XMODE_SOCKET_CLOSED_OPEN_SOCKET_FAILED = 4;
    public static final short XMODE_SOCKET_CLOSED_REMOTE_DISCONNECT = 0;

    /* renamed from: a */
    private static LogFactory.Log f72a = LogFactory.getLog(XMode.class);

    /* renamed from: b */
    private TimerSystem.TimerSystemTask f73b;

    /* renamed from: c */
    private int f74c;

    /* renamed from: d */
    private TimerSystem.TimerSystemTask f75d;

    /* renamed from: e */
    private int f76e;

    /* renamed from: f */
    private TimerSystem.TimerSystemTask f77f;

    /* renamed from: g */
    private Vector f78g;

    /* renamed from: h */
    private boolean f79h;

    /* renamed from: i */
    private Vector f80i;
    protected short inputCodec;

    /* renamed from: j */
    private MessageSystem f81j;

    /* renamed from: k */
    private Object f82k;

    /* renamed from: o */
    private String f86o;
    protected short outputCodec;

    /* renamed from: p */
    private String f87p;
    protected int pingRequestId;
    protected short port;

    /* renamed from: q */
    private byte[] f88q;
    protected String server;
    public byte[] sessionId;
    protected byte state;

    /* renamed from: t */
    private XModeListener f91t;

    /* renamed from: l */
    private XModeMsgHeader f83l = null;

    /* renamed from: m */
    private short f84m = 0;

    /* renamed from: n */
    private short f85n = 9;

    /* renamed from: r */
    private NetworkSystem f89r = null;

    /* renamed from: s */
    private String f90s = "";

    public interface XModeListener {
        void socketClosed(short s, short s2);

        void socketOpened();

        void xmodeMsgCallback(XModeMsgHeader xModeMsgHeader, byte[] bArr);

        void xmodeMsgNotSent(String str, Object obj);

        void xmodeMsgSent(String str, Object obj);
    }

    public XMode(String str, short s, String str2, byte[] bArr, String str3, XModeListener xModeListener, Vector vector, MessageSystem messageSystem) throws NumberFormatException {
        this.f74c = 30;
        this.f76e = 50;
        this.server = null;
        this.port = (short) 0;
        this.f79h = false;
        this.f80i = null;
        this.f81j = null;
        this.f86o = "Not specified";
        this.f87p = "Not specified";
        this.f88q = null;
        this.server = str;
        this.port = s;
        this.f86o = str2;
        this.f88q = bArr;
        this.f87p = str3;
        this.f91t = xModeListener;
        if (vector != null) {
            this.f78g = vector;
        } else {
            this.f78g = new Vector();
        }
        this.f81j = messageSystem;
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode() server: " + str + " port: " + ((int) s));
        }
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Parameter parameter = (Parameter) enumerationElements.nextElement();
            if (f72a.isDebugEnabled()) {
                f72a.debug("XMode() " + parameter.getType() + " : " + parameter.getName() + " = " + new String(parameter.getValue()));
            }
            if (parameter.getType() == Parameter.Type.SDK) {
                if (parameter.getName().equals(NMSPDefines.IdleSessionTimeout)) {
                    int i = Integer.parseInt(new String(parameter.getValue()));
                    if (i > 0) {
                        this.f76e = i;
                    }
                } else if (parameter.getName().equals(NMSPDefines.ConnectionTimeout)) {
                    this.f74c = Integer.parseInt(new String(parameter.getValue()));
                } else if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_SOCKET) || parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_CERT_SUMMARY) || parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_CERT_DATA) || parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_SELFSIGNED_CERT)) {
                    if (parameter.getName().equals(NMSPDefines.NMSP_DEFINES_SSL_SOCKET) && (new String(parameter.getValue()).equals("TRUE") || new String(parameter.getValue()).equals("true"))) {
                        this.f79h = true;
                    }
                    if (this.f80i == null) {
                        this.f80i = new Vector();
                    }
                    this.f80i.addElement(parameter);
                }
            }
        }
        this.state = (byte) 3;
    }

    /* renamed from: a */
    static /* synthetic */ short m15a(XMode xMode, short s) {
        xMode.f84m = (short) 3;
        return (short) 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16a(byte b, Object obj) {
        try {
            this.f81j.send(new MessageSystem.MessageData(b, obj), this, Thread.currentThread(), this.f81j.getVRAddr()[0]);
        } catch (Exception e) {
            if (f72a.isErrorEnabled()) {
                f72a.error("XMode.sendCmdMsg() " + e.getMessage());
            }
        }
    }

    /* renamed from: a */
    private void m17a(XModeMsgHeader xModeMsgHeader, byte[] bArr) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.parseXModeMsg() protocol: " + ((int) xModeMsgHeader.protocol) + " cmd: " + ((int) xModeMsgHeader.cmd));
        }
        switch (xModeMsgHeader.protocol) {
            case 1:
                if (this.f77f != null && this.f81j.cancelTask(this.f77f)) {
                    this.f77f = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.7
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                XMode.m15a(XMode.this, (short) 3);
                                if (XMode.f72a.isErrorEnabled()) {
                                    XMode.f72a.error("Session Idle for too long, longer than [" + XMode.this.f76e + "] (initiated from XMode.parseVap)");
                                }
                                XMode.this.state = (byte) 2;
                                XMode.this.m16a((byte) 4, (Object) null);
                            } catch (Exception e) {
                                if (XMode.f72a.isErrorEnabled()) {
                                    XMode.f72a.error("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                                }
                            }
                        }
                    };
                    this.f81j.scheduleTask(this.f77f, this.f76e * 1000);
                }
                this.f91t.xmodeMsgCallback(xModeMsgHeader, bArr);
                return;
            case 2:
                if (this.f77f != null && this.f81j.cancelTask(this.f77f)) {
                    this.f77f = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.6
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                XMode.m15a(XMode.this, (short) 3);
                                if (XMode.f72a.isErrorEnabled()) {
                                    XMode.f72a.error("Session Idle for too long, longer than [" + XMode.this.f76e + "] (initiated from XMode.parseBcp)");
                                }
                                XMode.this.state = (byte) 2;
                                XMode.this.m16a((byte) 4, (Object) null);
                            } catch (Exception e) {
                                if (XMode.f72a.isErrorEnabled()) {
                                    XMode.f72a.error("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                                }
                            }
                        }
                    };
                    this.f81j.scheduleTask(this.f77f, this.f76e * 1000);
                }
                this.f91t.xmodeMsgCallback(xModeMsgHeader, bArr);
                return;
            case 3:
                switch (xModeMsgHeader.cmd) {
                    case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_VIEW_MODE_EVENT /* 257 */:
                        this.f81j.cancelTask(this.f75d);
                        this.sessionId = new byte[16];
                        System.arraycopy(bArr, 0, this.sessionId, 0, 16);
                        this.f81j.setSessionId(this.sessionId);
                        this.f89r.setSessionId(this.f82k, this.sessionId);
                        this.f90s = LogFactory.Log.FormatUuid(this.sessionId);
                        f72a.setCurrentSession(this.f90s);
                        try {
                            if (f72a.isDebugEnabled()) {
                                f72a.debug("Received COP_Connected " + this.f90s);
                            }
                            m16a((byte) 10, (Object) null);
                            f72a.unsetCurrentSession();
                            this.f77f = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.5
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        XMode.m15a(XMode.this, (short) 3);
                                        if (XMode.f72a.isErrorEnabled()) {
                                            XMode.f72a.error("Session Idle for too long, longer than [" + XMode.this.f76e + "] (initiated from XMode.parseCopConnected)");
                                        }
                                        XMode.this.state = (byte) 2;
                                        XMode.this.m16a((byte) 4, (Object) null);
                                    } catch (Exception e) {
                                        if (XMode.f72a.isErrorEnabled()) {
                                            XMode.f72a.error("XMode.parseXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                                        }
                                    }
                                }
                            };
                            this.f81j.scheduleTask(this.f77f, this.f76e * 1000);
                            break;
                        } catch (Throwable th) {
                            f72a.unsetCurrentSession();
                            throw th;
                        }
                    case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_WEBLAYOUT_MODE_EVENT /* 258 */:
                        this.pingRequestId = ByteConversion.bytesToInt(bArr, 0);
                        m16a((byte) 8, (Object) null);
                        break;
                    case 512:
                        if (this.f77f != null) {
                            this.f81j.cancelTask(this.f77f);
                        }
                        this.f85n = ByteConversion.bytesToShort(bArr, 0);
                        this.state = (byte) 2;
                        this.f84m = (short) 6;
                        if (f72a.isWarnEnabled()) {
                            f72a.warn("XMode.parseXModeMsgCopDisconnect() Received COP DISCONNECT. ");
                        }
                        m16a((byte) 4, (Object) null);
                        break;
                    case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SHEET_COLOR_EVENT /* 768 */:
                        this.f84m = (short) 7;
                        this.state = (byte) 2;
                        if (f72a.isErrorEnabled()) {
                            f72a.error("XMode.parseXModeMsgCopConnectFailed() COP CONNECT failure. ");
                        }
                        m16a((byte) 4, (Object) null);
                        break;
                }
                this.f91t.xmodeMsgCallback(xModeMsgHeader, bArr);
                return;
            case 15:
                return;
            default:
                if (f72a.isErrorEnabled()) {
                    f72a.error("XMode.parseXModeMsg() unknown protocol: " + Integer.toHexString(xModeMsgHeader.protocol));
                    return;
                }
                return;
        }
    }

    public void clearPendingNetworkOps() {
        this.f89r.clearPendingOps(this.f82k);
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem.CloseSocketCallback
    public void closeSocketCallback(NetworkSystem.NetworkStatus networkStatus, Object obj, Object obj2) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.closeSocketCallback() " + this.f90s);
        }
        this.state = (byte) 3;
        if (this.f73b != null) {
            this.f81j.cancelTask(this.f73b);
            this.f73b = null;
        }
        if (this.f77f != null) {
            this.f81j.cancelTask(this.f77f);
            this.f77f = null;
        }
        if (this.f82k != null) {
            this.f91t.socketClosed(this.f84m, this.f85n);
        }
        this.f82k = null;
        this.f89r = null;
        this.sessionId = null;
        this.f90s = "";
    }

    public void connect(short s, short s2) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.connect() codec: " + ((int) s2));
        }
        if (this.state == 1 || this.state == 0) {
            return;
        }
        if (this.state != 2) {
            if (this.state == 3) {
                this.inputCodec = s;
                this.outputCodec = s2;
                this.state = (byte) 0;
                m16a((byte) 1, (Object) null);
                return;
            }
            return;
        }
        if (this.f73b != null) {
            this.f81j.cancelTask(this.f73b);
        }
        if (this.f77f != null) {
            this.f81j.cancelTask(this.f77f);
        }
        this.f82k = null;
        this.f89r = null;
        this.sessionId = null;
        this.f90s = "";
        this.inputCodec = s;
        this.outputCodec = s2;
        this.state = (byte) 0;
        m16a((byte) 1, (Object) null);
    }

    public void disconnect() {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.disconnect() state:" + ((int) this.state) + ", socket:" + this.f82k);
        }
        if (this.state == 3) {
            this.f84m = (short) 1;
            this.f91t.socketClosed(this.f84m, this.f85n);
            return;
        }
        if (this.state != 2) {
            if (this.state == 0) {
                this.f84m = (short) 1;
                this.state = (byte) 2;
                if (this.f82k != null) {
                    this.f89r.closeSocket(this.f82k);
                    return;
                }
                return;
            }
            if (this.state == 1) {
                this.state = (byte) 2;
                this.f84m = (short) 1;
                m16a((byte) 2, (Object) null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x0300 A[PHI: r1
  0x0300: PHI (r1v43 java.lang.String) = (r1v35 java.lang.String), (r1v53 java.lang.String) binds: [B:31:0x00db, B:33:0x011f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(java.lang.Object r12, java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.components.core.XMode.handleMessage(java.lang.Object, java.lang.Object):void");
    }

    public boolean isNetworkHealthy() {
        NetworkSystem networkSystem = this.f89r;
        if (networkSystem != null) {
            return networkSystem.isNetworkHealthy();
        }
        return false;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem.OpenSocketCallback
    public void openSocketCallback(NetworkSystem.NetworkStatus networkStatus, Object obj, Object obj2) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.openSocketCallback() ");
        }
        if (networkStatus == NetworkSystem.NetworkStatus.NETWORK_OK) {
            this.f82k = obj;
            if (this.state == 0) {
                m16a((byte) 7, (Object) null);
                return;
            } else {
                this.state = (byte) 2;
                this.f89r.closeSocket(this.f82k);
                return;
            }
        }
        if (networkStatus != NetworkSystem.NetworkStatus.NETWORK_ERROR) {
            if (networkStatus == NetworkSystem.NetworkStatus.NETWORK_MEMORY_ERROR) {
                this.f84m = (short) 4;
                if (f72a.isErrorEnabled()) {
                    f72a.error("XMode.openSocketCallback() NETWORK_MEMORY_ERROR");
                    return;
                }
                return;
            }
            return;
        }
        if (f72a.isErrorEnabled()) {
            f72a.error("XMode.openSocketCallback() NETWORK_ERROR");
        }
        this.state = (byte) 3;
        this.f84m = (short) 4;
        this.f91t.socketClosed(this.f84m, this.f85n);
        this.f82k = null;
        this.f89r = null;
        this.sessionId = null;
        this.f90s = "";
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem.ReadSocketCallback
    public void readSocketCallback(NetworkSystem.NetworkStatus networkStatus, Object obj, byte[] bArr, int i, int i2, int i3, Object obj2) {
        String str = (String) obj2;
        if (f72a.isDebugEnabled()) {
            f72a.debug("Read callback");
        }
        if (f72a.isTraceEnabled()) {
            f72a.traceBuffer(bArr);
        }
        if (networkStatus != NetworkSystem.NetworkStatus.NETWORK_OK) {
            if (networkStatus == NetworkSystem.NetworkStatus.NETWORK_ERROR) {
                if (this.f84m != 1 && this.f84m != 3 && this.f84m != 6) {
                    this.f84m = (short) 8;
                    if (f72a.isErrorEnabled()) {
                        f72a.error("XMode.readSocketCallback() NETWORK_ERROR");
                    }
                }
                m16a((byte) 4, (Object) null);
                return;
            }
            if (networkStatus != NetworkSystem.NetworkStatus.NETWORK_MEMORY_ERROR || this.f84m == 1 || this.f84m == 3) {
                return;
            }
            this.f84m = (short) 8;
            if (f72a.isErrorEnabled()) {
                f72a.error("XMode.readSocketCallback() NETWORK_MEMORY_ERROR");
                return;
            }
            return;
        }
        if (!str.equals("READ_XMODE_HEADER")) {
            if (str.equals("READ_XMODE_PAYLOAD")) {
                if (i3 == 0) {
                    if (f72a.isDebugEnabled()) {
                        f72a.debug(Integer.toHexString(this.f83l.cmd) + " payload not read bytesRead is 0");
                    }
                    this.f73b = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                XMode.this.m16a((byte) 6, (Object) null);
                            } catch (Exception e) {
                                if (XMode.f72a.isErrorEnabled()) {
                                    XMode.f72a.error("XMode.readSocketCallback() " + e.getClass().getName() + " " + e.getMessage());
                                }
                            }
                        }
                    };
                    this.f81j.scheduleTask(this.f73b, 20L);
                    return;
                }
                if (i3 == i2) {
                    if (this.f83l.len <= i2) {
                        m17a(this.f83l, bArr);
                    }
                    m16a((byte) 5, (Object) null);
                    return;
                } else {
                    if (f72a.isErrorEnabled()) {
                        f72a.error("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_PAYLOAD bytesRead:[" + i3 + "] bufferLen:[" + i2 + "]");
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (i3 == 0) {
            this.f73b = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.2
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        XMode.this.m16a((byte) 5, (Object) null);
                    } catch (Exception e) {
                        if (XMode.f72a.isErrorEnabled()) {
                            XMode.f72a.error("XMode.readSocketCallback() " + e.getClass().getName() + " " + e.getMessage());
                        }
                    }
                }
            };
            this.f81j.scheduleTask(this.f73b, 20L);
            return;
        }
        if (i3 != i2) {
            if (f72a.isErrorEnabled()) {
                f72a.error("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_HEADER bytesRead:[" + i3 + "] bufferLen:[" + i2 + "]");
                return;
            }
            return;
        }
        this.f83l = new XModeMsgHeader(bArr);
        if (this.f83l.len == 0) {
            m17a(this.f83l, (byte[]) null);
            m16a((byte) 5, (Object) null);
        } else if (this.f83l.len <= 512000 && this.f83l.len >= 0) {
            m16a((byte) 6, (Object) null);
        } else {
            this.f89r.clearPendingOps(obj);
            m16a((byte) 5, (Object) null);
        }
    }

    public void sendVapRecordEnd(int i) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.sendVapRecordEnd() audio id: " + i);
        }
        if (this.state != 1) {
            return;
        }
        byte[] bArr = new byte[4];
        ByteConversion.intToBytes(i, bArr, 0);
        sendXModeMsg(ProtocolBuilder.buildXModeBuf((byte) 1, ProtocolDefines.XMODE_VERSION_VAP, (short) 256, bArr), "SEND_VAP_RECORD_END");
    }

    public void sendVapRecordMsg(byte[] bArr, int i) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.sendVapRecordMsg() audio id: " + i);
        }
        if (this.state != 1) {
            return;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 8];
        ByteConversion.intToBytes(i, bArr2, 0);
        ByteConversion.intToBytes(length, bArr2, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        sendXModeMsg(ProtocolBuilder.buildXModeBuf((byte) 1, ProtocolDefines.XMODE_VERSION_VAP, ProtocolDefines.XMODE_VAP_COMMAND_RECORD, bArr2), "SEND_VAP_RECORD");
    }

    public void sendXModeMsg(byte[] bArr, Object obj) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.sendXModeMsg() " + obj);
        }
        if (this.f77f != null && this.f81j.cancelTask(this.f77f)) {
            this.f77f = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.core.XMode.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        XMode.m15a(XMode.this, (short) 3);
                        if (XMode.f72a.isErrorEnabled()) {
                            XMode.f72a.error("Session Idle for too long, longer than [" + XMode.this.f76e + "] ()");
                        }
                        XMode.this.state = (byte) 2;
                        XMode.this.m16a((byte) 4, (Object) null);
                    } catch (Exception e) {
                        if (XMode.f72a.isErrorEnabled()) {
                            XMode.f72a.error("XMode.sendXModeMsg() " + e.getClass().getName() + " " + e.getMessage());
                        }
                    }
                }
            };
            this.f81j.scheduleTask(this.f77f, this.f76e * 1000);
        }
        if (this.f89r == null || this.f82k == null) {
            return;
        }
        this.f89r.socketWrite(this.f82k, bArr, 0, bArr.length, this, obj);
    }

    public void startStreaming(int i) {
        if (f72a.isDebugEnabled()) {
            f72a.debug("XMode.startStreaming() audio id: " + i);
        }
        if (this.state != 1) {
            return;
        }
        byte[] bArr = new byte[6];
        ByteConversion.intToBytes(i, bArr, 0);
        ByteConversion.shortToBytes(this.inputCodec, bArr, 4);
        sendXModeMsg(ProtocolBuilder.buildXModeBuf((byte) 1, ProtocolDefines.XMODE_VERSION_VAP, (short) 257, bArr), "SEND_VAP_RECORD_BEGIN");
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.NetworkSystem.WriteSocketCallback
    public void writeSocketCallback(NetworkSystem.NetworkStatus networkStatus, Object obj, byte[] bArr, int i, int i2, int i3, Object obj2) {
        String str = (String) obj2;
        if (networkStatus == NetworkSystem.NetworkStatus.NETWORK_OK && i2 == i3) {
            if (str.equals("SEND_COP_CONNECT")) {
                m16a((byte) 5, (Object) null);
                return;
            } else {
                if (str.equals("SEND_COP_DISCONNECT")) {
                    this.f89r.closeSocket(obj);
                    return;
                }
                return;
            }
        }
        if (networkStatus == NetworkSystem.NetworkStatus.NETWORK_ERROR) {
            if (this.f84m == 1 || this.f84m == 3) {
                return;
            }
            this.f84m = (short) 8;
            if (f72a.isErrorEnabled()) {
                f72a.error("XMode.writeSocketCallback() NETWORK_ERROR");
                return;
            }
            return;
        }
        if (networkStatus != NetworkSystem.NetworkStatus.NETWORK_MEMORY_ERROR || this.f84m == 1 || this.f84m == 3) {
            return;
        }
        this.f84m = (short) 8;
        if (f72a.isErrorEnabled()) {
            f72a.error("XMode.writeSocketCallback() NETWORK_MEMORY_ERROR");
        }
    }
}
