package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import android.os.Build;
import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.resource.common.ResourceException;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ManagerImpl;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl;
import com.nuance.nmsp.client.sdk.components.resource.internal.nmas.PDXTransactionImpl;
import com.nuance.nmsp.client.sdk.components.resource.nmas.AudioParam;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Command;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Dictionary;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource;
import com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResourceListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.PDXCommandListener;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Sequence;
import java.io.IOException;
import java.util.Vector;

/* loaded from: classes.dex */
public class NMASResourceImpl extends ResourceImpl implements NMASResource {
    public static final byte BCP_BEGIN = 4;
    public static final byte BCP_DATA = 5;

    /* renamed from: a */
    private static final LogFactory.Log f151a = LogFactory.getLog(NMASResourceImpl.class);

    /* renamed from: e */
    private static String f152e = Build.VERSION.RELEASE;

    /* renamed from: b */
    private MessageSystem f153b;

    /* renamed from: c */
    private NMASResourceListener f154c;

    /* renamed from: d */
    private PDXTransactionImpl f155d;

    public NMASResourceImpl(ManagerImpl managerImpl, NMASResourceListener nMASResourceListener, Vector vector, String str) {
        super(managerImpl, str, nMASResourceListener, vector, (byte) 5);
        this.f154c = nMASResourceListener;
        this.f153b = managerImpl.getMsgSys();
        this.session = managerImpl.getSession();
        this.session.setResource(this);
        this.f155d = null;
        this.f153b.send(new MessageSystem.MessageData((byte) 0, null), this, Thread.currentThread(), this.f153b.getVRAddr()[0]);
    }

    /* renamed from: a */
    private void m36a(byte b) {
        Vector vector;
        if (b != this.f155d.tranId || (vector = (Vector) ((ManagerImpl) getManager()).getResourceLogs()) == null || vector.size() <= 0) {
            return;
        }
        f151a.debug("clearResLogsToServer() before clean the log vector tranId[" + ((int) b) + "] log list size [" + vector.size() + "]");
        int i = 0;
        while (i < vector.size()) {
            PDXTransactionImpl.TransactionLogEntry transactionLogEntry = (PDXTransactionImpl.TransactionLogEntry) vector.elementAt(i);
            if (transactionLogEntry.isSent()) {
                vector.removeElement(transactionLogEntry);
            } else {
                i++;
            }
        }
        f151a.debug("clearResLogsToServer() after clean the log vector tranId[" + ((int) b) + "] log list size [" + vector.size() + "]");
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Command createCommand(PDXCommandListener pDXCommandListener, String str, String str2, String str3, String str4, String str5, Dictionary dictionary, long j) throws ResourceException {
        PDXTransactionImpl pDXTransactionImpl;
        String str6 = pDXCommandListener == null ? "commandListener is invalid; " : "";
        if (str == null || str.equals("")) {
            str6 = str6 + "cmd should be non-null; ";
        }
        if (str2 == null || str2.equals("")) {
            str6 = str6 + "scriptVersion should be non-null; ";
        }
        if (str3 == null || str3.equals("")) {
            str6 = str6 + "dictationLanguage should be non-null; ";
        }
        if (str5 == null || str5.equals("")) {
            str6 = str6 + "phoneModel should be non-null; ";
        }
        if (j <= 0) {
            str6 = str6 + "commandTimeout is invalid; ";
        }
        if (!str6.equals("")) {
            f151a.error("NMASResourceImpl.createCommand() " + str6);
            throw new IllegalArgumentException(str6);
        }
        synchronized (this.syncObject) {
            if (this.f155d != null) {
                this.f155d.transactionOver();
            }
            this.session.setDefaultReqId(0L);
            if (this.resourceState == 0) {
                this.f153b.send(new MessageSystem.MessageData((byte) 0, null), this, Thread.currentThread(), this.f153b.getVRAddr()[0]);
            }
            this.tranId = this.session.getTransactionId();
            this.f155d = new PDXTransactionImpl(this.f153b, pDXCommandListener, str, ((ManagerImpl) this.manager).applicationId, this.session, ((ManagerImpl) this.manager).getUid(), "1", f152e, str2, "enus", "ne", ((ManagerImpl) this.manager).getInputCodec(), str3, (short) 1, (short) 1, str4, str5, ((ManagerImpl) this.manager).getUid(), "", j, dictionary, this, this.f154c, this.tranId);
            pDXTransactionImpl = this.f155d;
        }
        return pDXTransactionImpl;
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public AudioParam createPDXAudioParam(String str) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        return new PDXAudioParam(str, this.session, this.f153b);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXChoiceParam(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (str2 == null) {
            throw new NullPointerException("choicename can not be null");
        }
        return new PDXChoiceParam(str, str2);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXDataParam(String str, byte[] bArr) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (bArr == null) {
            throw new NullPointerException("data can not be null");
        }
        return new PDXDataParam(str, bArr);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXDictParam(String str, Dictionary dictionary) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (dictionary == null) {
            throw new NullPointerException("dict can not be null");
        }
        return new PDXDictParam(str, (PDXDictionary) dictionary);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Dictionary createPDXDictionary() {
        return new PDXDictionary();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXSeqChunkParam(String str, Dictionary dictionary) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (dictionary == null) {
            throw new NullPointerException("dict can not be null");
        }
        return new PDXSeqParam(str, (PDXDictionary) dictionary, (byte) 2);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXSeqEndParam(String str, Dictionary dictionary) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (dictionary == null) {
            throw new NullPointerException("dict can not be null");
        }
        return new PDXSeqParam(str, (PDXDictionary) dictionary, (byte) 3);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXSeqStartParam(String str, Dictionary dictionary) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (dictionary == null) {
            throw new NullPointerException("dict can not be null");
        }
        return new PDXSeqParam(str, (PDXDictionary) dictionary, (byte) 1);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Sequence createPDXSequence() {
        return new PDXSequence();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXTTSParam(String str, Dictionary dictionary, NMSPAudioSink nMSPAudioSink) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (dictionary == null) {
            throw new NullPointerException("tts_dict can not be null");
        }
        if (nMSPAudioSink == null) {
            throw new NullPointerException("audioSink can not be null");
        }
        return new PDXTTSParam(str, this.session, (PDXDictionary) dictionary, nMSPAudioSink);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.nmas.NMASResource
    public Parameter createPDXTextParam(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name can not be null");
        }
        if (str2 == null) {
            throw new NullPointerException("text can not be null");
        }
        return new PDXTextParam(str, str2);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.common.Resource
    public void freeResource(int i) throws ResourceException {
        f151a.debug("freeResource() disconnectTimeout:" + i);
        if (this.f155d != null) {
            this.f155d.transactionOver();
        }
        synchronized (this.syncObject) {
            if (this.resourceState != 2) {
                throw new ResourceException("the resource was unloaded. ");
            }
            this.resourceState = 0;
            this.f153b.send(new MessageSystem.MessageData((byte) 3, new Integer(i)), this, Thread.currentThread(), this.f153b.getVRAddr()[0]);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl
    public long getRequestId() {
        return super.getRequestId();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) throws IOException {
        switch (((MessageSystem.MessageData) obj).command) {
            case 0:
                super.loadResource(this, null);
                break;
            case 1:
            case 2:
            default:
                super.handleMessage(obj, obj2);
                break;
            case 3:
                this.session.removeSessionListener(this);
                this.f154c.resourceUnloaded((short) 0);
                break;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onBcpData(byte b, long j, byte[] bArr) {
        PDXMessage pDXMessageCreateMessage = PDXMessageFactory.createMessage(bArr);
        switch (pDXMessageCreateMessage.getCommandCode()) {
            case 29185:
                m36a(b);
                if (this.f155d != null) {
                    this.f155d.onQueryResults((PDXQueryResult) pDXMessageCreateMessage, b);
                    break;
                }
                break;
            case 29186:
                if (this.f155d != null) {
                    this.f155d.onQueryError((PDXQueryError) pDXMessageCreateMessage, b);
                    break;
                }
                break;
            case 29187:
            case 29188:
            default:
                f151a.error("Session.parseXModeMsgBcpData() Unknown command: " + ((int) pDXMessageCreateMessage.getCommandCode()) + ". ");
                break;
            case 29189:
                m36a(b);
                if (this.f155d != null) {
                    this.f155d.onQueryRetry((PDXQueryRetry) pDXMessageCreateMessage, b);
                    break;
                }
                break;
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onBcpEvent(byte b, short s) {
        if (b != this.tranId) {
            return;
        }
        if (this.f155d != null) {
            this.f155d.transactionOver();
        }
        super.onBcpEvent(b, s);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onMsgNotSent(byte b, String str, Object obj) {
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onMsgSent(byte b, String str, Object obj) {
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onSessionConnected(byte[] bArr) {
        super.onSessionConnected(bArr);
        if (this.f155d != null) {
            this.f155d.onSessionConnected(bArr);
        }
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onSessionDisconnected(short s) {
        f151a.debug("onSessionDisconnected() reasonCode:" + ((int) s));
        if (this.f155d != null) {
            this.f155d.onSessionDisconnected(s);
        }
        super.onSessionDisconnected(s);
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onVapPlayBeginReceived() {
        this.f155d.onVapPlayBeginReceived();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onVapPlayEndReceived() {
        this.f155d.onVapPlayEndReceived();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onVapPlayReceived() {
        this.f155d.onVapPlayReceived();
    }

    @Override // com.nuance.nmsp.client.sdk.components.resource.internal.common.ResourceImpl, com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSessionListener
    public void onVapSending() {
        this.f155d.resetCommandTimeoutTask();
    }
}
