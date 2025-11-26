package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.coolots.sso.util.ChatONVAPII;
import com.nuance.nmsp.client.sdk.common.defines.NMSPDefines;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.oem.api.TimerSystem;
import com.nuance.nmsp.client.sdk.common.protocols.ProtocolDefines;
import com.nuance.nmsp.client.sdk.common.util.Util;
import com.nuance.nmsp.client.sdk.components.core.XMode;
import com.nuance.nmsp.client.sdk.components.general.TransactionAlreadyFinishedException;
import com.nuance.nmsp.client.sdk.components.general.TransactionExpiredException;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ManagerImpl;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSession;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Command;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Sequence;
import com.nuance.nmsp.client.sdk.oem.BluetoothSystemOEM;
import java.util.Vector;

/* loaded from: classes.dex */
public class PDXTransactionImpl implements MessageSystem.MessageHandler, Command {
    public static final String INTERNAL_COMPLETION_CAUSE_CONN_FAILED = "CONN_FAILED";
    public static final String INTERNAL_COMPLETION_CAUSE_FINAL_RESULT = "FINAL_RESULT";
    public static final String INTERNAL_COMPLETION_CAUSE_INTERNAL_ERROR = "INTERNAL_ERROR";
    public static final String INTERNAL_COMPLETION_CAUSE_QUERY_ERROR = "QUERY_ERROR";
    public static final String INTERNAL_COMPLETION_CAUSE_QUERY_RETRY = "QUERY_RETRY";
    public static final String INTERNAL_COMPLETION_CAUSE_REMOTE_DISC = "REMOTE_DISC";
    public static final String INTERNAL_COMPLETION_CAUSE_TIMEOUT_CMD = "TIMEOUT_CMD";
    public static final String INTERNAL_COMPLETION_CAUSE_TIMEOUT_IDLE = "TIMEOUT_IDLE";
    public static final String INTERNAL_COMPLETION_CAUSE_UNKNOWN_ERROR = "UNKNOWN_ERROR";
    public static final short STATE_BEGUN = 0;
    public static final short STATE_ENDED = 1;
    public static final short STATE_EXPIRED = 2;
    public static final short STATE_IDLE = -1;

    /* renamed from: a */
    private static final LogFactory.Log f189a = LogFactory.getLog(PDXTransactionImpl.class);

    /* renamed from: b */
    private NMASResourceImpl f190b;

    /* renamed from: c */
    private NMASResourceListener f191c;

    /* renamed from: d */
    private PDXCommandListener f192d;

    /* renamed from: e */
    private NMSPSession f193e;

    /* renamed from: f */
    private short f194f;

    /* renamed from: g */
    private MessageSystem f195g;

    /* renamed from: h */
    private TimerSystem.TimerSystemTask f196h;

    /* renamed from: i */
    private long f197i;

    /* renamed from: j */
    private boolean f198j = false;

    /* renamed from: k */
    private TransactionLogEntry f199k;

    /* renamed from: l */
    private Object f200l;
    protected byte tranId;

    public static class TransactionLogEntry {

        /* renamed from: a */
        private int f202a;

        /* renamed from: b */
        private String f203b;

        /* renamed from: c */
        private String f204c;

        /* renamed from: d */
        private PDXTransactionImpl f205d;

        /* renamed from: e */
        private boolean f206e;

        protected TransactionLogEntry(int i, PDXTransactionImpl pDXTransactionImpl) {
            this.f202a = i;
            if (pDXTransactionImpl.f193e.getSessionId() != null) {
                this.f203b = NMSPSession.FormatUuid(pDXTransactionImpl.f193e.getSessionId());
            } else {
                this.f203b = "";
            }
            this.f204c = PDXTransactionImpl.INTERNAL_COMPLETION_CAUSE_INTERNAL_ERROR;
            this.f205d = pDXTransactionImpl;
            this.f206e = false;
        }

        /* renamed from: a */
        static /* synthetic */ void m48a(TransactionLogEntry transactionLogEntry, String str) {
            if (transactionLogEntry.f204c.equals(PDXTransactionImpl.INTERNAL_COMPLETION_CAUSE_INTERNAL_ERROR)) {
                transactionLogEntry.f204c = str;
            } else {
                transactionLogEntry.f204c += ChatONVAPII.USERID_DELEMETER + str;
            }
            PDXTransactionImpl.m43a(transactionLogEntry.f205d, transactionLogEntry);
        }

        protected String getCompCause() {
            return this.f204c;
        }

        protected String getSessionId() {
            return this.f203b;
        }

        protected int getTranId() {
            return this.f202a;
        }

        protected boolean isSent() {
            return this.f206e;
        }

        protected void setCompCause(Command.CompletionCause completionCause) {
            if (this.f204c.equals(PDXTransactionImpl.INTERNAL_COMPLETION_CAUSE_INTERNAL_ERROR)) {
                this.f204c = completionCause.toString();
            } else {
                this.f204c += ChatONVAPII.USERID_DELEMETER + completionCause.toString();
            }
            PDXTransactionImpl.m43a(this.f205d, this);
        }

        protected void setSent(boolean z) {
            this.f206e = z;
        }

        protected void setSessionId(String str) {
            this.f203b = str;
        }
    }

    protected PDXTransactionImpl(MessageSystem messageSystem, PDXCommandListener pDXCommandListener, String str, String str2, NMSPSession nMSPSession, String str3, String str4, String str5, String str6, String str7, String str8, NMSPDefines.Codec codec, String str9, short s, short s2, String str10, String str11, String str12, String str13, long j, Dictionary dictionary, NMASResourceImpl nMASResourceImpl, NMASResourceListener nMASResourceListener, byte b) {
        this.f192d = null;
        this.f193e = null;
        this.f194f = (short) -1;
        if (f189a.isDebugEnabled()) {
            f189a.debug("PDXTransactionImpl()");
        }
        this.f200l = new Object();
        this.f195g = messageSystem;
        this.f193e = nMSPSession;
        this.f192d = pDXCommandListener;
        this.f197i = j;
        this.f190b = nMASResourceImpl;
        this.f191c = nMASResourceListener;
        this.tranId = b;
        if (((ManagerImpl) nMASResourceImpl.getManager()).getResourceLogs() != null) {
            this.f199k = new TransactionLogEntry(this.tranId, this);
            m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_INTERNAL_ERROR);
        }
        synchronized (this.f200l) {
            this.f194f = (short) 0;
        }
        Object[] objArr = new Object[18];
        objArr[0] = str3;
        objArr[1] = str4;
        objArr[2] = str5;
        objArr[3] = str6;
        objArr[4] = str7;
        objArr[5] = str8;
        objArr[6] = codec;
        objArr[7] = str9;
        objArr[8] = new Short(s);
        objArr[9] = new Short(s2);
        objArr[10] = str10;
        objArr[11] = str11;
        objArr[12] = str12;
        objArr[13] = str13;
        objArr[14] = str2;
        objArr[15] = str;
        objArr[16] = dictionary;
        messageSystem.send(new MessageSystem.MessageData((byte) 1, objArr), this, Thread.currentThread(), messageSystem.getVRAddr()[0]);
    }

    /* renamed from: a */
    private static String m40a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            if (hexString.length() > 1) {
                stringBuffer.append(hexString.substring(hexString.length() - 2));
            } else {
                stringBuffer.append(hexString);
            }
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                stringBuffer.append('-');
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    static /* synthetic */ short m41a(PDXTransactionImpl pDXTransactionImpl, short s) {
        pDXTransactionImpl.f194f = (short) -1;
        return (short) -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m42a(TransactionLogEntry transactionLogEntry, String str) {
        if (transactionLogEntry != null) {
            TransactionLogEntry.m48a(transactionLogEntry, str);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m43a(PDXTransactionImpl pDXTransactionImpl, TransactionLogEntry transactionLogEntry) {
        Vector vector = (Vector) ((ManagerImpl) pDXTransactionImpl.f190b.getManager()).getResourceLogs();
        if (vector == null) {
            f189a.info("appendLogToResLogs: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled.");
        } else {
            if (vector.contains(transactionLogEntry)) {
                return;
            }
            vector.addElement(transactionLogEntry);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Command
    public void end() throws TransactionAlreadyFinishedException, TransactionExpiredException {
        if (f189a.isDebugEnabled()) {
            f189a.debug("PDXTransactionImpl.end()");
        }
        synchronized (this.f200l) {
            if (this.f194f == -1) {
                f189a.error("PDXTransactionImpl.end() transaction already finished!");
                throw new TransactionAlreadyFinishedException("transaction already finished!");
            }
            if (this.f194f == 0) {
                this.f194f = (short) 1;
                this.f195g.send(new MessageSystem.MessageData((byte) 4, null), this, Thread.currentThread(), this.f195g.getVRAddr()[0]);
            } else {
                if (this.f194f == 1) {
                    f189a.error("PDXTransactionImpl.end() transaction already finished!");
                    throw new TransactionAlreadyFinishedException("transaction already finished!");
                }
                if (this.f194f == 2) {
                    f189a.error("PDXTransactionImpl.end() transaction already expired!");
                    throw new TransactionExpiredException("transaction already expired!");
                }
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        MessageSystem.MessageData messageData = (MessageSystem.MessageData) obj;
        Object obj3 = messageData.data;
        switch (messageData.command) {
            case 1:
                Object[] objArr = (Object[]) obj3;
                String str = (String) objArr[0];
                String str2 = (String) objArr[1];
                String str3 = (String) objArr[2];
                String str4 = (String) objArr[3];
                String str5 = (String) objArr[4];
                String str6 = (String) objArr[5];
                NMSPDefines.Codec codecAdjustCodecForBluetooth = (NMSPDefines.Codec) objArr[6];
                String str7 = (String) objArr[7];
                short sShortValue = ((Short) objArr[8]).shortValue();
                short sShortValue2 = ((Short) objArr[9]).shortValue();
                String str8 = (String) objArr[10];
                String str9 = (String) objArr[11];
                String str10 = (String) objArr[12];
                String str11 = (String) objArr[13];
                byte[] sessionId = this.f193e.getSessionId();
                String str12 = (String) objArr[14];
                String str13 = (String) objArr[15];
                Dictionary dictionary = (Dictionary) objArr[16];
                if (new BluetoothSystemOEM(this.f190b.parameters).isBluetoothHeadsetConnected()) {
                    codecAdjustCodecForBluetooth = Util.adjustCodecForBluetooth(codecAdjustCodecForBluetooth);
                }
                long defaultRequestId = ResourceImpl.getDefaultRequestId();
                PDXQueryBegin pDXQueryBegin = new PDXQueryBegin(str, str2, str3, str4, str5, str6, codecAdjustCodecForBluetooth, str7, sShortValue, sShortValue2, str8, str9, str10, str11, sessionId, str12, str13, dictionary);
                Vector vector = (Vector) ((ManagerImpl) this.f190b.getManager()).getResourceLogs();
                if (vector == null) {
                    f189a.info("appendLogToQueryBegin: NMSPDefines.DEVICE_CMD_LOG_TO_SERVER_ENABLED is disabled");
                } else if (vector.size() == 0) {
                    f189a.info("appendLogToQueryBegin: nmasResLogsToServer is empty, nothing to log to server");
                } else {
                    int size = vector.size();
                    Dictionary pDXDictionary = new PDXDictionary();
                    Sequence pDXSequence = new PDXSequence();
                    for (int i = 0; i < size; i++) {
                        TransactionLogEntry transactionLogEntry = (TransactionLogEntry) vector.elementAt(i);
                        if (transactionLogEntry.getTranId() != this.tranId) {
                            PDXDictionary pDXDictionary2 = new PDXDictionary();
                            pDXDictionary2.put("id", transactionLogEntry.getSessionId() + ChatONVAPII.USERID_DELEMETER + transactionLogEntry.getTranId(), NMASResource.PDX_DATA_TYPE_UTF8);
                            pDXDictionary2.put("status", transactionLogEntry.getCompCause().toString(), NMASResource.PDX_DATA_TYPE_UTF8);
                            pDXSequence.addDictionary(pDXDictionary2);
                            transactionLogEntry.setSent(true);
                        }
                    }
                    pDXDictionary.addSequence("device_log", pDXSequence);
                    pDXQueryBegin.addDictionary("app_info", pDXDictionary);
                }
                this.f193e.postBcpMessage(ProtocolDefines.XMODE_BCP_COMMAND_BCP_BEGIN, XMode.NET_CONTEXT_SEND_BCP_BEGIN + ((int) this.tranId), pDXQueryBegin.getMessage(), null, this.tranId, defaultRequestId, this.f190b, false);
                if (sessionId != null) {
                    try {
                        if (!this.f198j) {
                            this.f198j = true;
                            f189a.debug("PDXCommandCreated() called from handleInit()" + m40a(sessionId) + ChatONVAPII.USERID_DELEMETER + ((int) this.tranId) + " (" + this + "," + this.f191c + ")");
                            this.f191c.PDXCommandCreated(m40a(sessionId) + ChatONVAPII.USERID_DELEMETER + ((int) this.tranId));
                            break;
                        }
                    } catch (Throwable th) {
                        f189a.error("got exp in PDXCommandListener.PDXCommandCreated() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                        return;
                    }
                }
                break;
            case 2:
                Object obj4 = (Parameter) obj3;
                if (((PDXParam) obj4).getType() == 127) {
                    this.f193e.addAudioSink(((PDXTTSParam) obj4).getAudioId(), ((PDXTTSParam) obj4).getAudioSink(), this.f190b);
                }
                this.f193e.postBcpMessage(ProtocolDefines.XMODE_BCP_COMMAND_BCP_DATA, XMode.NET_CONTEXT_SEND_BCP_DATA, new PDXQueryParameter((PDXParam) obj4).toByteArray(), null, this.tranId, ResourceImpl.getDefaultRequestId(), this.f190b, false);
                break;
            case 3:
                this.f193e.postBcpMessage(ProtocolDefines.XMODE_BCP_COMMAND_BCP_DATA, XMode.NET_CONTEXT_SEND_BCP_DATA, new PDXEnrollmentAudio((byte[]) obj3).toByteArray(), null, this.tranId, ResourceImpl.getDefaultRequestId(), this.f190b, false);
                break;
            case 4:
                this.f193e.postBcpMessage(ProtocolDefines.XMODE_BCP_COMMAND_BCP_DATA, XMode.NET_CONTEXT_SEND_BCP_DATA, new PDXQueryEnd().toByteArray(), null, this.tranId, ResourceImpl.getDefaultRequestId(), this.f190b, false);
                this.f196h = new TimerSystem.TimerSystemTask() { // from class: com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (PDXTransactionImpl.this.f200l) {
                                PDXTransactionImpl.m41a(PDXTransactionImpl.this, (short) -1);
                            }
                            if (PDXTransactionImpl.this.f192d != null) {
                                PDXTransactionImpl.f189a.debug("PDXTransactionImpl.end() timed out waiting for results. ");
                                try {
                                    PDXTransactionImpl pDXTransactionImpl = PDXTransactionImpl.this;
                                    PDXTransactionImpl.m42a(PDXTransactionImpl.this.f199k, PDXTransactionImpl.INTERNAL_COMPLETION_CAUSE_TIMEOUT_CMD);
                                    PDXTransactionImpl.this.f192d.PDXCommandEvent((short) 1);
                                } catch (Throwable th2) {
                                    PDXTransactionImpl.f189a.error("got exp in PDXCommandListener.PDXCommandEvent(TIMED_OUT_WAITING_FOR_RESULT) [" + th2.getClass().getName() + "] msg [" + th2.getMessage() + "]");
                                }
                            }
                        } catch (Exception e) {
                            PDXTransactionImpl.f189a.error("PDXTransactionImpl.run() " + e.getClass().getName() + " " + e.getMessage());
                        }
                    }
                };
                this.f195g.scheduleTask(this.f196h, this.f197i);
                break;
            case 5:
                this.f192d.PDXCommandEvent((short) 4);
                break;
            case 6:
                Command.CompletionCause completionCause = (Command.CompletionCause) obj3;
                TransactionLogEntry transactionLogEntry2 = this.f199k;
                if (transactionLogEntry2 != null) {
                    transactionLogEntry2.setCompCause(completionCause);
                    break;
                }
                break;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Command
    public boolean isNetworkHealthy() {
        return this.f193e.isNetworkHealthy();
    }

    public void onQueryError(PDXQueryError pDXQueryError, byte b) {
        f189a.debug("PDXTransactionImpl.onQueryError()");
        if (b != this.tranId) {
            return;
        }
        synchronized (this.f200l) {
            if (this.f194f == -1 || this.f194f == 2) {
                return;
            }
            this.f194f = (short) -1;
            if (this.f196h != null) {
                this.f195g.cancelTask(this.f196h);
            }
            if (this.f192d != null) {
                try {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_QUERY_ERROR);
                    this.f192d.PDXQueryErrorReturned(pDXQueryError);
                } catch (Throwable th) {
                    f189a.error("got exp in PDXCommandListener.PDXQueryErrorReturned() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    public void onQueryResults(PDXQueryResult pDXQueryResult, byte b) {
        if (f189a.isDebugEnabled()) {
            f189a.debug("PDXTransactionImpl.onQueryResults()");
        }
        if (b != this.tranId) {
            return;
        }
        synchronized (this.f200l) {
            if (this.f194f == -1 || this.f194f == 2) {
                return;
            }
            if (this.f196h != null && pDXQueryResult.isFinalResponse()) {
                this.f195g.cancelTask(this.f196h);
            }
            if (this.f192d != null) {
                try {
                    if (pDXQueryResult.isFinalResponse()) {
                        m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_FINAL_RESULT);
                    }
                    this.f192d.PDXQueryResultReturned(pDXQueryResult);
                } catch (Throwable th) {
                    f189a.error("got exp in PDXCommandListener.PDXQueryResultReturned() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    public void onQueryRetry(PDXQueryRetry pDXQueryRetry, byte b) {
        f189a.debug("PDXTransactionImpl.onQueryRetry()");
        if (b != this.tranId) {
            return;
        }
        synchronized (this.f200l) {
            if (this.f194f == -1 || this.f194f == 2) {
                return;
            }
            this.f194f = (short) -1;
            if (this.f196h != null) {
                this.f195g.cancelTask(this.f196h);
            }
            if (this.f192d != null) {
                try {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_QUERY_RETRY);
                    this.f192d.PDXQueryRetryReturned(pDXQueryRetry);
                } catch (Throwable th) {
                    f189a.error("got exp in PDXCommandListener.PDXQueryRetryReturned() [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[Catch: all -> 0x00bb, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x0013, B:9:0x0017, B:17:0x0087, B:11:0x001b, B:13:0x0023, B:14:0x0026, B:16:0x002a, B:20:0x008a), top: B:25:0x0013, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSessionConnected(byte[] r6) {
        /*
            r5 = this;
            r2 = 1
            com.nuance.nmsp.client.sdk.common.oem.api.LogFactory$Log r0 = com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.f189a
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L10
            com.nuance.nmsp.client.sdk.common.oem.api.LogFactory$Log r0 = com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.f189a
            java.lang.String r1 = "PDXTransactionImpl.onSessionConnected()"
            r0.debug(r1)
        L10:
            java.lang.Object r1 = r5.f200l
            monitor-enter(r1)
            short r0 = r5.f194f     // Catch: java.lang.Throwable -> Lbb
            if (r0 == 0) goto L1b
            short r0 = r5.f194f     // Catch: java.lang.Throwable -> Lbb
            if (r0 != r2) goto L87
        L1b:
            java.lang.String r0 = m40a(r6)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl$TransactionLogEntry r2 = r5.f199k     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            if (r2 == 0) goto L26
            r2.setSessionId(r0)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
        L26:
            boolean r2 = r5.f198j     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            if (r2 != 0) goto L87
            r2 = 1
            r5.f198j = r2     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            com.nuance.nmsp.client.sdk.common.oem.api.LogFactory$Log r2 = com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.f189a     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r4 = "PDXCommandCreated() called from onSessionConnected()"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = r3.append(r0)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r4 = ":"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            byte r4 = r5.tranId     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r4 = " ("
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r4 = ","
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener r4 = r5.f191c     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r4 = ")"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            r2.debug(r3)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener r2 = r5.f191c     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            r3.<init>()     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r3 = ":"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            byte r3 = r5.tranId     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
            r2.PDXCommandCreated(r0)     // Catch: java.lang.Throwable -> L89 java.lang.Throwable -> Lbb
        L87:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lbb
            return
        L89:
            r0 = move-exception
            com.nuance.nmsp.client.sdk.common.oem.api.LogFactory$Log r2 = com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.f189a     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r4 = "got exp in PDXCommandListener.PDXCommandCreated() ["
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.Class r4 = r0.getClass()     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r4 = "] msg ["
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lbb
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r3 = "]"
            java.lang.StringBuilder r0 = r0.append(r3)     // Catch: java.lang.Throwable -> Lbb
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lbb
            r2.error(r0)     // Catch: java.lang.Throwable -> Lbb
            goto L87
        Lbb:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl.onSessionConnected(byte[]):void");
    }

    public void onSessionDisconnected(short s) {
        if (f189a.isDebugEnabled()) {
            f189a.debug("PDXTransactionImpl.onSessionDisconnected() " + ((int) s));
        }
        synchronized (this.f200l) {
            if (this.f194f == 1 && this.f196h != null) {
                this.f195g.cancelTask(this.f196h);
            }
            if (this.f194f == 2) {
                return;
            }
            try {
            } catch (Throwable th) {
                f189a.error("got exp in PDXCommandListener.PDXCommandEvent() or PDXManagerListener.PDXManagerError() or PDXManagerListener.PDXManagerDisconnected() reasonCode [" + ((int) s) + "] [" + th.getClass().getName() + "] msg [" + th.getMessage() + "]");
            }
            if (s == 0) {
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_REMOTE_DISC);
                    this.f192d.PDXCommandEvent((short) 3);
                }
            } else if (s == 1) {
                if (this.f194f != -1) {
                    this.f192d.PDXCommandEvent((short) 4);
                }
            } else if (s == 3) {
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_TIMEOUT_IDLE);
                    this.f192d.PDXCommandEvent((short) 5);
                }
            } else if (s == 4) {
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_CONN_FAILED);
                    this.f191c.PDXCreateCommandFailed();
                }
            } else if (s == 5) {
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_CONN_FAILED);
                    this.f191c.PDXCreateCommandFailed();
                }
            } else if (s == 6) {
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_REMOTE_DISC);
                    this.f192d.PDXCommandEvent((short) 3);
                }
            } else {
                if (s != 7) {
                    if (s == 8) {
                        if (this.f194f != -1) {
                            m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_REMOTE_DISC);
                            this.f192d.PDXCommandEvent((short) 3);
                        }
                    }
                    this.f194f = (short) 2;
                }
                if (this.f194f != -1) {
                    m42a(this.f199k, INTERNAL_COMPLETION_CAUSE_CONN_FAILED);
                    this.f191c.PDXCreateCommandFailed();
                }
            }
            this.f194f = (short) 2;
        }
    }

    public void onVapPlayBeginReceived() {
        resetCommandTimeoutTask();
    }

    public void onVapPlayEndReceived() {
        resetCommandTimeoutTask();
    }

    public void onVapPlayReceived() {
        resetCommandTimeoutTask();
    }

    protected void resetCommandTimeoutTask() {
        if (this.f196h != null) {
            this.f195g.cancelTask(this.f196h);
            this.f195g.scheduleTask(this.f196h, this.f197i);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Command
    public void sendEnrollmentAudio(byte[] bArr) throws TransactionAlreadyFinishedException, TransactionExpiredException {
        f189a.debug("PDXTransactionImpl.sendEnrollmentAudio()");
        synchronized (this.f200l) {
            if (this.f194f == -1) {
                f189a.error("PDXTransactionImpl.sendEnrollmentAudio() transaction already finished!");
                throw new TransactionAlreadyFinishedException("transaction already finished!");
            }
            if (this.f194f == 0) {
                if (bArr == null) {
                    throw new NullPointerException("enrollment audio is null");
                }
                if (bArr.length == 0) {
                    throw new IllegalArgumentException("enrollment audio is empty");
                }
                byte[] bArr2 = new byte[bArr.length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                this.f195g.send(new MessageSystem.MessageData((byte) 3, bArr2), this, Thread.currentThread(), this.f195g.getVRAddr()[0]);
            } else {
                if (this.f194f == 1) {
                    f189a.error("PDXTransactionImpl.sendEnrollmentAudio() transaction already finished!");
                    throw new TransactionAlreadyFinishedException("transaction already finished!");
                }
                if (this.f194f == 2) {
                    f189a.error("PDXTransactionImpl.sendEnrollmentAudio() transaction already expired!");
                    throw new TransactionExpiredException("transaction already expired!");
                }
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Command
    public void sendParam(Parameter parameter) throws TransactionAlreadyFinishedException, TransactionExpiredException {
        if (f189a.isDebugEnabled()) {
            f189a.debug("PDXTransactionImpl.sendParam()");
        }
        if (parameter == null) {
            throw new NullPointerException("Parameter cannot be null");
        }
        synchronized (this.f200l) {
            if (this.f194f == -1) {
                f189a.error("PDXTransactionImpl.sendParam() transaction already finished!");
                throw new TransactionAlreadyFinishedException("transaction already finished!");
            }
            if (this.f194f == 0) {
                this.f195g.send(new MessageSystem.MessageData((byte) 2, parameter), this, Thread.currentThread(), this.f195g.getVRAddr()[0]);
            } else {
                if (this.f194f == 1) {
                    f189a.error("PDXTransactionImpl.sendParam() transaction already finished!");
                    throw new TransactionAlreadyFinishedException("transaction already finished!");
                }
                if (this.f194f == 2) {
                    f189a.error("PDXTransactionImpl.sendParam() transaction already expired!");
                    throw new TransactionExpiredException("transaction already expired!");
                }
            }
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.Command
    public void setLog(Command.CompletionCause completionCause) {
        this.f195g.send(new MessageSystem.MessageData((byte) 6, completionCause), this, Thread.currentThread(), this.f195g.getVRAddr()[0]);
    }

    public void transactionOver() {
        synchronized (this.f200l) {
            if (this.f194f == 1 && this.f196h != null) {
                this.f195g.cancelTask(this.f196h);
            }
            if (this.f194f == 2) {
                return;
            }
            if (this.f194f != -1) {
                this.f195g.send(new MessageSystem.MessageData((byte) 5, null), this, Thread.currentThread(), this.f195g.getVRAddr()[0]);
            }
            this.f194f = (short) 2;
        }
    }
}
