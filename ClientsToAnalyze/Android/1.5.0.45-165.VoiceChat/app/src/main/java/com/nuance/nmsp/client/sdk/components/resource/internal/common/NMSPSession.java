package com.nuance.nmsp.client.sdk.components.resource.internal.common;

import com.coolots.p2pmsg.model.ConfLimitPolicyInfo;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.coolots.p2pmsg.model.StoreNoteAsk;
import com.infraware.office.evengine.InterfaceC0507E;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolBuilder;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.common.protocols.XModeMsgHeader;
import com.nuance.nmsp.client.sdk.common.util.ByteConversion;
import com.nuance.nmsp.client.sdk.common.util.Util;
import com.nuance.nmsp.client.sdk.components.core.XMode;
import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.general.TransactionProcessingException;
import com.nuance.nmsp.client.sdk.components.resource.common.ManagerListener;
import com.nuance.nmsp.client.sdk.components.resource.common.Resource;
import java.io.ByteArrayOutputStream;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes.dex */
public class NMSPSession implements MessageSystem.MessageHandler, XMode.XModeListener {

    /* renamed from: a */
    private static final LogFactory.Log f122a = LogFactory.getLog(NMSPSession.class);

    /* renamed from: m */
    private static byte[] f123m = new byte[16];

    /* renamed from: p */
    private static int f124p = 1;

    /* renamed from: v */
    private static String[] f125v = {"0", "1", "2", "3", SimpleUserInfo.STATE_MOVETO_CONFERENCE, "5", "6", "7", "8", "9", "A", StoreNoteAsk.TYPE_SEND_SUCCESS, StoreNoteAsk.TYPE_ADD_MEMBER, StoreNoteAsk.TYPE_REMOVE_MEMBER, "E", ConfLimitPolicyInfo.PAID_TYPE_FREE};

    /* renamed from: e */
    private XMode f129e;

    /* renamed from: f */
    private String f130f;

    /* renamed from: g */
    private short f131g;

    /* renamed from: i */
    private MessageSystem f133i;

    /* renamed from: j */
    private ManagerListener f134j;

    /* renamed from: n */
    private NMSPDefines.Codec f137n;

    /* renamed from: o */
    private NMSPDefines.Codec f138o;

    /* renamed from: q */
    private long f139q;

    /* renamed from: l */
    private byte[] f136l = null;

    /* renamed from: r */
    private boolean f140r = false;

    /* renamed from: t */
    private long f142t = 1;

    /* renamed from: u */
    private byte f143u = 1;

    /* renamed from: s */
    private Resource f141s = null;

    /* renamed from: k */
    private Vector f135k = new Vector();

    /* renamed from: b */
    private Hashtable f126b = new Hashtable();

    /* renamed from: c */
    private Hashtable f127c = new Hashtable();

    /* renamed from: d */
    private Hashtable f128d = new Hashtable();

    /* renamed from: h */
    private Vector f132h = new Vector();

    public NMSPSession(String str, short s, String str2, byte[] bArr, String str3, Vector vector, MessageSystem messageSystem, ManagerListener managerListener) {
        this.f130f = str;
        this.f131g = s;
        this.f133i = messageSystem;
        this.f134j = managerListener;
        this.f129e = new XMode(this.f130f, this.f131g, str2, bArr, str3, this, vector, messageSystem);
    }

    public static String FormatUuid(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            byte b = bArr[i];
            stringBuffer.append(f125v[(byte) (((byte) (((byte) (b & 240)) >>> 4)) & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE)] + f125v[(byte) (b & ProtocolDefines.XMODE_PROTOCOL_BB_HANDSHAKE)]);
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append("-");
            }
        }
        return stringBuffer.toString().toLowerCase();
    }

    /* renamed from: a */
    private void m30a() {
        while (!this.f135k.isEmpty()) {
            MessageSystem.MessageData messageData = (MessageSystem.MessageData) this.f135k.firstElement();
            this.f135k.removeElementAt(0);
            switch (messageData.command) {
                case 1:
                    m31a((byte) 1, messageData.data);
                    break;
                case 2:
                    m31a((byte) 2, messageData.data);
                    break;
                case 4:
                    m31a((byte) 4, messageData.data);
                    break;
                case 5:
                    m31a((byte) 5, messageData.data);
                    break;
                case 6:
                    m31a((byte) 6, messageData.data);
                    break;
                case 7:
                    m31a((byte) 7, messageData.data);
                    break;
                case 8:
                    m31a((byte) 8, messageData.data);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m31a(byte b, Object obj) {
        this.f133i.send(new MessageSystem.MessageData(b, obj), this, Thread.currentThread(), this.f133i.getVRAddr()[0]);
    }

    /* renamed from: a */
    private void m32a(byte[] bArr) {
        byte b = bArr[16];
        short sBytesToShort = ByteConversion.bytesToShort(bArr, 17);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f132h.size()) {
                return;
            }
            ((NMSPSessionListener) this.f132h.elementAt(i2)).onBcpEvent(b, sBytesToShort);
            i = i2 + 1;
        }
    }

    /* renamed from: b */
    private void m33b(byte[] bArr) {
        int iBytesToInt = ByteConversion.bytesToInt(bArr, 0);
        if (this.f127c.size() == 0) {
            return;
        }
        NMSPAudioSink nMSPAudioSink = (NMSPAudioSink) this.f127c.get(new Integer(iBytesToInt));
        if (nMSPAudioSink == null) {
            f122a.error("Could not find the audio sink associated with AID: " + iBytesToInt);
            return;
        }
        int iBytesToInt2 = ByteConversion.bytesToInt(bArr, 4);
        int i = 8;
        if (Util.isSpeexCodec(this.f138o)) {
            while ((bArr[i] & 128) > 0) {
                i++;
                iBytesToInt2--;
            }
            i++;
            iBytesToInt2--;
        }
        if (iBytesToInt2 > 0 && iBytesToInt2 <= bArr.length - i) {
            try {
                nMSPAudioSink.addAudioBuf(bArr, i, iBytesToInt2, false);
            } catch (TransactionProcessingException e) {
                f122a.error(e.getMessage());
            }
        }
        if (this.f128d.size() != 0) {
            NMSPSessionListener nMSPSessionListener = (NMSPSessionListener) this.f128d.get(new Integer(iBytesToInt));
            if (nMSPSessionListener == null) {
                f122a.error("parseXModeMsgVapPlay:: Could not find the session listener associated with AID: " + iBytesToInt);
            } else {
                nMSPSessionListener.onVapPlayReceived();
            }
        }
    }

    public void addAudioSink(int i, NMSPAudioSink nMSPAudioSink, NMSPSessionListener nMSPSessionListener) {
        this.f127c.put(new Integer(i), nMSPAudioSink);
        this.f128d.put(new Integer(i), nMSPSessionListener);
    }

    public void connect(NMSPDefines.Codec codec, NMSPDefines.Codec codec2) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("connect()");
        }
        this.f137n = codec;
        this.f138o = codec2;
        m31a((byte) 1, null);
    }

    public void disconnect() {
        if (f122a.isDebugEnabled()) {
            f122a.debug("disconnect");
        }
        m31a((byte) 2, null);
    }

    public void disconnectAndShutdown() {
        f122a.debug("disconnectAndShutdown");
        m31a((byte) 3, null);
    }

    public void freeResource(byte b, int i, NMSPSessionListener nMSPSessionListener) {
        f122a.debug("freeResource, TID: " + ((int) b) + ", disconnect timeout: " + i);
        this.f132h.removeElement(nMSPSessionListener);
        Object[] objArr = {new Byte(b), new Integer(i)};
        if (this.f136l == null || !this.f135k.isEmpty()) {
            this.f135k.addElement(new MessageSystem.MessageData((byte) 4, objArr));
        } else {
            m31a((byte) 4, objArr);
        }
    }

    public NMSPDefines.Codec getInputCodec() {
        return this.f137n;
    }

    public Vector getMsgQueue() {
        return this.f135k;
    }

    public MessageSystem getMsgSystem() {
        return this.f133i;
    }

    public synchronized int getNewAudioId() {
        int i;
        i = f124p;
        f124p = i + 1;
        if (f124p == Integer.MIN_VALUE) {
            f124p = 1;
        }
        return i;
    }

    public long getResourceId() {
        long j = this.f142t;
        this.f142t = j + 1;
        if (this.f142t == Long.MIN_VALUE) {
            this.f142t = 1L;
        }
        return j;
    }

    public byte[] getSessionId() {
        return this.f136l;
    }

    public byte getTransactionId() {
        byte b = this.f143u;
        this.f143u = (byte) (b + 1);
        if (this.f143u == -128) {
            this.f143u = (byte) 1;
        }
        return b;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        MessageSystem.MessageData messageData = (MessageSystem.MessageData) obj;
        switch (messageData.command) {
            case 1:
                this.f129e.connect(this.f137n.getValue(), this.f138o.getValue());
                break;
            case 2:
                this.f129e.disconnect();
                break;
            case 3:
                this.f129e.disconnect();
                this.f140r = true;
                break;
            case 4:
                if (this.f136l != null) {
                    Object[] objArr = (Object[]) messageData.data;
                    byte bByteValue = ((Byte) objArr[0]).byteValue();
                    int iIntValue = ((Integer) objArr[1]).intValue();
                    byte[] bArr = new byte[5];
                    bArr[0] = bByteValue;
                    ByteConversion.intToBytes(iIntValue, bArr, 1);
                    this.f129e.sendXModeMsg(ProtocolBuilder.buildXModeBuf((byte) 2, ProtocolDefines.XMODE_VERSION_BCP, ProtocolDefines.XMODE_BCP_COMMAND_FREE_RESOURCE, ProtocolBuilder.appendBCPSessionUUID(bArr, this.f136l)), XMode.NET_CONTEXT_SEND_BCP_FREE_RESOURCE);
                    break;
                }
                break;
            case 5:
                if (this.f136l != null) {
                    this.f129e.startStreaming(((Integer) messageData.data).intValue());
                    break;
                }
                break;
            case 6:
                if (this.f136l != null) {
                    Object[] objArr2 = (Object[]) messageData.data;
                    byte[] bArr2 = (byte[]) objArr2[0];
                    int iIntValue2 = ((Integer) objArr2[1]).intValue();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.f132h.size()) {
                            this.f129e.sendVapRecordMsg(bArr2, iIntValue2);
                            break;
                        } else {
                            ((NMSPSessionListener) this.f132h.elementAt(i2)).onVapSending();
                            i = i2 + 1;
                        }
                    }
                }
                break;
            case 7:
                if (this.f136l != null) {
                    this.f129e.sendVapRecordEnd(((Integer) messageData.data).intValue());
                    break;
                }
                break;
            case 8:
                if (this.f136l != null) {
                    Object[] objArr3 = (Object[]) messageData.data;
                    short sShortValue = ((Short) objArr3[0]).shortValue();
                    String str = (String) objArr3[1];
                    byte[] bArr3 = (byte[]) objArr3[2];
                    byte[] bArr4 = (byte[]) objArr3[3];
                    byte bByteValue2 = ((Byte) objArr3[4]).byteValue();
                    long jLongValue = ((Long) objArr3[5]).longValue();
                    NMSPSessionListener nMSPSessionListener = (NMSPSessionListener) objArr3[6];
                    boolean zBooleanValue = ((Boolean) objArr3[7]).booleanValue();
                    this.f126b.put(new Long(jLongValue), nMSPSessionListener);
                    int length = bArr3.length + 5;
                    if (sShortValue == 2585) {
                        length += 4;
                    }
                    byte[] bArr5 = new byte[length];
                    bArr5[0] = bByteValue2;
                    int i3 = 1;
                    if (sShortValue == 2585) {
                        ByteConversion.intToBytes((int) jLongValue, bArr5, 1);
                        i3 = 5;
                    }
                    ByteConversion.intToBytes(bArr3.length, bArr5, i3);
                    System.arraycopy(bArr3, 0, bArr5, i3 + 4, bArr3.length);
                    byte[] bArrAppendBCPSessionUUID = ProtocolBuilder.appendBCPSessionUUID(bArr5, this.f136l != null ? this.f136l : f123m);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(bArrAppendBCPSessionUUID, 0, bArrAppendBCPSessionUUID.length);
                    if (bArr4 != null) {
                        byteArrayOutputStream.write(bArr4, 0, bArr4.length);
                    }
                    this.f129e.sendXModeMsg(ProtocolBuilder.buildXModeBuf((byte) 2, ProtocolDefines.XMODE_VERSION_BCP, sShortValue, byteArrayOutputStream.toByteArray()), str);
                    if (zBooleanValue) {
                        if (sShortValue != 2581) {
                            if (sShortValue == 2608 && nMSPSessionListener != null) {
                                this.f132h.removeElement(nMSPSessionListener);
                                nMSPSessionListener.onBcpFreeResourceId();
                                break;
                            }
                        } else if (nMSPSessionListener != null) {
                            nMSPSessionListener.onBcpSetParamsComplete(bByteValue2, jLongValue, (short) 200, null);
                            break;
                        }
                    }
                }
                break;
            default:
                f122a.error("Unknown command");
                break;
        }
    }

    public boolean isNetworkHealthy() {
        return this.f129e.isNetworkHealthy();
    }

    public void postBcpMessage(short s, String str, byte[] bArr, byte[] bArr2, byte b, long j, NMSPSessionListener nMSPSessionListener, boolean z) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("postBcpMessage, BCP: " + ((int) s) + ", TID: " + ((int) b) + ", RID: " + j);
        }
        Object[] objArr = {new Short(s), str, bArr, bArr2, new Byte(b), new Long(j), nMSPSessionListener, new Boolean(z)};
        if (this.f136l == null || !this.f135k.isEmpty()) {
            this.f135k.addElement(new MessageSystem.MessageData((byte) 8, objArr));
        } else {
            m31a((byte) 8, objArr);
        }
    }

    public void removeSessionListener(NMSPSessionListener nMSPSessionListener) {
        this.f132h.removeElement(nMSPSessionListener);
    }

    public void setDefaultReqId(long j) {
        this.f139q = j;
    }

    public void setResource(Resource resource) {
        this.f141s = resource;
    }

    public void setSessionListener(NMSPSessionListener nMSPSessionListener) {
        if (this.f132h.contains(nMSPSessionListener)) {
            return;
        }
        this.f132h.addElement(nMSPSessionListener);
    }

    @Override // com.nuance.nmsp.client.sdk.components.core.XMode.XModeListener
    public void socketClosed(short s, short s2) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("socketClosed, reason: " + ((int) s));
        }
        if (s == 1 && this.f140r) {
            this.f133i.stop();
        }
        if (f122a.isDebugEnabled()) {
            f122a.debug("socketClosed() sessionListeners.size():" + this.f132h.size());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f132h.size()) {
                break;
            }
            ((NMSPSessionListener) this.f132h.elementAt(i2)).onSessionDisconnected(s);
            i = i2 + 1;
        }
        if (!this.f135k.isEmpty()) {
            this.f135k.removeAllElements();
        }
        this.f132h.removeAllElements();
        if (s == 4 || s == 5 || s == 7) {
            this.f134j.connectionFailed(this.f141s);
        } else if (s == 8 && this.f136l == null) {
            this.f134j.connectionFailed(this.f141s);
        } else if (this.f136l != null) {
            this.f134j.disconnected(this.f141s, s2);
        }
        this.f136l = null;
    }

    @Override // com.nuance.nmsp.client.sdk.components.core.XMode.XModeListener
    public void socketOpened() {
    }

    public void vapRecord(byte[] bArr, int i) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("vapRecord, AID: " + i);
        }
        Object[] objArr = {bArr, new Integer(i)};
        if (this.f136l == null || !this.f135k.isEmpty()) {
            this.f135k.addElement(new MessageSystem.MessageData((byte) 6, objArr));
        } else {
            m31a((byte) 6, objArr);
        }
    }

    public void vapRecordBegin(int i) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("vapRecordBegin, AID: " + i);
        }
        Integer num = new Integer(i);
        if (this.f136l == null || !this.f135k.isEmpty()) {
            this.f135k.addElement(new MessageSystem.MessageData((byte) 5, num));
        } else {
            m31a((byte) 5, num);
        }
    }

    public void vapRecordEnd(int i) {
        if (f122a.isDebugEnabled()) {
            f122a.debug("vapRecordEnd, AID: " + i);
        }
        Integer num = new Integer(i);
        if (this.f136l == null || !this.f135k.isEmpty()) {
            this.f135k.addElement(new MessageSystem.MessageData((byte) 7, num));
        } else {
            m31a((byte) 7, num);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.core.XMode.XModeListener
    public void xmodeMsgCallback(XModeMsgHeader xModeMsgHeader, byte[] bArr) {
        int i = 0;
        if (f122a.isDebugEnabled()) {
            f122a.debug("xmodeMsgCallback, protocol: " + ((int) xModeMsgHeader.protocol) + ", command: " + ((int) xModeMsgHeader.cmd));
        }
        switch (xModeMsgHeader.protocol) {
            case 1:
                switch (xModeMsgHeader.cmd) {
                    case 512:
                        m33b(bArr);
                        break;
                    case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_BWP_CELL_SEPARATE_EVENT /* 528 */:
                        int iBytesToInt = ByteConversion.bytesToInt(bArr, 0);
                        if (this.f128d.size() != 0) {
                            NMSPSessionListener nMSPSessionListener = (NMSPSessionListener) this.f128d.get(new Integer(iBytesToInt));
                            if (nMSPSessionListener != null) {
                                nMSPSessionListener.onVapPlayBeginReceived();
                                break;
                            } else {
                                f122a.error("parseVapPlayBegin:: Could not find the session listener associated with AID: " + iBytesToInt);
                                break;
                            }
                        }
                        break;
                    case 1024:
                        int iBytesToInt2 = ByteConversion.bytesToInt(bArr, 0);
                        if (this.f127c.size() != 0) {
                            NMSPAudioSink nMSPAudioSink = (NMSPAudioSink) this.f127c.remove(new Integer(iBytesToInt2));
                            if (nMSPAudioSink != null) {
                                try {
                                    nMSPAudioSink.addAudioBuf(null, 0, 0, true);
                                } catch (TransactionProcessingException e) {
                                    f122a.error(e.getMessage());
                                }
                                NMSPSessionListener nMSPSessionListener2 = (NMSPSessionListener) this.f128d.remove(new Integer(iBytesToInt2));
                                if (nMSPSessionListener2 != null) {
                                    nMSPSessionListener2.onVapPlayEndReceived();
                                    break;
                                } else {
                                    f122a.error("parseXModeMsgVapPlayEnd:: Could not find the session listener associated with AID: " + iBytesToInt2);
                                    break;
                                }
                            } else {
                                f122a.error("Could not find the audio sink associated with AID: " + iBytesToInt2);
                                break;
                            }
                        }
                        break;
                }
            case 2:
                switch (xModeMsgHeader.cmd) {
                    case 2576:
                        byte b = bArr[16];
                        int iBytesToInt3 = ByteConversion.bytesToInt(bArr, 17);
                        short sBytesToShort = ByteConversion.bytesToShort(bArr, 21);
                        short sBytesToShort2 = ByteConversion.bytesToShort(bArr, 23);
                        short sBytesToShort3 = ByteConversion.bytesToShort(bArr, 25);
                        NMSPSessionListener nMSPSessionListener3 = (NMSPSessionListener) this.f126b.get(new Long(iBytesToInt3));
                        if (nMSPSessionListener3 != null) {
                            nMSPSessionListener3.onBcpResponse(b, iBytesToInt3, sBytesToShort, sBytesToShort2, sBytesToShort3);
                            if (sBytesToShort != 200) {
                                this.f126b.remove(new Long(iBytesToInt3));
                                break;
                            }
                        }
                        break;
                    case 2577:
                        byte b2 = bArr[16];
                        long jBytesToInt = ByteConversion.bytesToInt(bArr, 17);
                        long jBytesToInt2 = ByteConversion.bytesToInt(bArr, 21);
                        short sBytesToShort4 = ByteConversion.bytesToShort(bArr, 25);
                        NMSPSessionListener nMSPSessionListener4 = (NMSPSessionListener) this.f126b.remove(new Long(jBytesToInt));
                        if (nMSPSessionListener4 != null) {
                            nMSPSessionListener4.onBcpGenerateAudioComplete(b2, jBytesToInt, jBytesToInt2, sBytesToShort4);
                            break;
                        }
                        break;
                    case 2578:
                        break;
                    case 2579:
                        byte[] bArr2 = null;
                        byte b3 = bArr[16];
                        long jBytesToInt3 = ByteConversion.bytesToInt(bArr, 17);
                        short sBytesToShort5 = ByteConversion.bytesToShort(bArr, 21);
                        int iBytesToInt4 = ByteConversion.bytesToInt(bArr, 23);
                        if (iBytesToInt4 > 0 && iBytesToInt4 <= bArr.length - 27) {
                            bArr2 = new byte[iBytesToInt4];
                            System.arraycopy(bArr, 27, bArr2, 0, iBytesToInt4);
                        }
                        NMSPSessionListener nMSPSessionListener5 = (NMSPSessionListener) this.f126b.remove(new Long(jBytesToInt3));
                        if (nMSPSessionListener5 != null) {
                            nMSPSessionListener5.onBcpRecognitionComplete(b3, jBytesToInt3, sBytesToShort5, bArr2);
                            break;
                        }
                        break;
                    case 2580:
                        byte[] bArr3 = null;
                        byte b4 = bArr[16];
                        long jBytesToInt4 = ByteConversion.bytesToInt(bArr, 17);
                        short sBytesToShort6 = ByteConversion.bytesToShort(bArr, 21);
                        int iBytesToInt5 = ByteConversion.bytesToInt(bArr, 23);
                        if (iBytesToInt5 > 0 && iBytesToInt5 <= bArr.length - 27) {
                            bArr3 = new byte[iBytesToInt5];
                            System.arraycopy(bArr, 27, bArr3, 0, iBytesToInt5);
                        }
                        NMSPSessionListener nMSPSessionListener6 = (NMSPSessionListener) this.f126b.get(new Long(jBytesToInt4));
                        if (nMSPSessionListener6 != null) {
                            nMSPSessionListener6.onBcpRecognitionIntermediateResults(b4, jBytesToInt4, sBytesToShort6, bArr3);
                            break;
                        }
                        break;
                    case 2582:
                        byte[] bArr4 = null;
                        byte b5 = bArr[16];
                        int iBytesToInt6 = ByteConversion.bytesToInt(bArr, 17);
                        short sBytesToShort7 = ByteConversion.bytesToShort(bArr, 21);
                        int iBytesToInt7 = ByteConversion.bytesToInt(bArr, 23);
                        if (iBytesToInt7 > 0 && iBytesToInt7 <= bArr.length - 27) {
                            bArr4 = new byte[iBytesToInt7];
                            System.arraycopy(bArr, 27, bArr4, 0, iBytesToInt7);
                        }
                        NMSPSessionListener nMSPSessionListener7 = (NMSPSessionListener) this.f126b.remove(new Long(iBytesToInt6));
                        if (nMSPSessionListener7 != null) {
                            nMSPSessionListener7.onBcpSetParamsComplete(b5, iBytesToInt6, sBytesToShort7, bArr4);
                            break;
                        }
                        break;
                    case 2584:
                        byte[] bArr5 = null;
                        byte b6 = bArr[16];
                        int iBytesToInt8 = ByteConversion.bytesToInt(bArr, 17);
                        short sBytesToShort8 = ByteConversion.bytesToShort(bArr, 21);
                        int iBytesToInt9 = ByteConversion.bytesToInt(bArr, 23);
                        if (iBytesToInt9 > 0 && iBytesToInt9 <= bArr.length - 27) {
                            bArr5 = new byte[iBytesToInt9];
                            System.arraycopy(bArr, 27, bArr5, 0, iBytesToInt9);
                        }
                        NMSPSessionListener nMSPSessionListener8 = (NMSPSessionListener) this.f126b.remove(new Long(iBytesToInt8));
                        if (nMSPSessionListener8 != null) {
                            nMSPSessionListener8.onBcpGetParamsComplete(b6, iBytesToInt8, sBytesToShort8, bArr5);
                            break;
                        }
                        break;
                    case 2585:
                        byte b7 = bArr[16];
                        int iBytesToInt10 = ByteConversion.bytesToInt(bArr, 21);
                        if (iBytesToInt10 > 0 && iBytesToInt10 <= bArr.length - 25) {
                            byte[] bArr6 = new byte[iBytesToInt10];
                            System.arraycopy(bArr, 25, bArr6, 0, iBytesToInt10);
                            NMSPSessionListener nMSPSessionListener9 = (NMSPSessionListener) this.f126b.get(new Long(this.f139q));
                            if (nMSPSessionListener9 != null) {
                                nMSPSessionListener9.onBcpData(b7, this.f139q, bArr6);
                                break;
                            }
                        }
                        break;
                    case 2600:
                        m32a(bArr);
                        break;
                    default:
                        f122a.error("Unknown BCP command");
                        break;
                }
            case 3:
                switch (xModeMsgHeader.cmd) {
                    case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_VIEW_MODE_EVENT /* 257 */:
                        this.f136l = this.f129e.sessionId;
                        if (f122a.isDebugEnabled()) {
                            f122a.debug("connected(" + FormatUuid(this.f136l) + ") called on " + this.f134j);
                        }
                        this.f134j.connected(FormatUuid(this.f136l), this.f141s);
                        while (true) {
                            int i2 = i;
                            if (i2 >= this.f132h.size()) {
                                m30a();
                                break;
                            } else {
                                ((NMSPSessionListener) this.f132h.elementAt(i2)).onSessionConnected(this.f136l);
                                i = i2 + 1;
                            }
                        }
                }
                break;
            default:
                f122a.error("Unknown Xmode protocol");
                break;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.core.XMode.XModeListener
    public void xmodeMsgNotSent(String str, Object obj) {
    }

    @Override // com.nuance.nmsp.client.sdk.components.core.XMode.XModeListener
    public void xmodeMsgSent(String str, Object obj) {
    }
}
