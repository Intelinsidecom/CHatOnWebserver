package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.common.oem.api.LogFactory;
import com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem;
import com.nuance.nmsp.client.sdk.common.util.Util;
import com.nuance.nmsp.client.sdk.components.general.TransactionProcessingException;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSession;
import com.nuance.nmsp.client.sdk.components.resource.nmas.AudioParam;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class PDXAudioParam extends PDXParam implements MessageSystem.MessageHandler, AudioParam {

    /* renamed from: a */
    private static final LogFactory.Log f157a = LogFactory.getLog(PDXAudioParam.class);

    /* renamed from: b */
    private int f158b;

    /* renamed from: c */
    private NMSPSession f159c;

    /* renamed from: d */
    private boolean f160d;

    /* renamed from: e */
    private MessageSystem f161e;

    public PDXAudioParam(String str, NMSPSession nMSPSession, MessageSystem messageSystem) {
        super(str, (byte) 1);
        this.f160d = false;
        this.f159c = nMSPSession;
        this.f161e = messageSystem;
        this.f158b = nMSPSession.getNewAudioId();
        messageSystem.send(new MessageSystem.MessageData((byte) 1, null), this, Thread.currentThread(), messageSystem.getVRAddr()[0]);
    }

    @Override // com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink
    public void addAudioBuf(byte[] bArr, int i, int i2, boolean z) throws TransactionProcessingException {
        if (bArr == null && !z) {
            f157a.error("PDXAudioParam.addAudioBuf() in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
            throw new NullPointerException("in (NMSPAudioSink)PDXAudioParam.addAudioBuf(), the param \"buffer\" is null.");
        }
        if (bArr != null && i < 0) {
            f157a.error("PDXAudioParam.addAudioBuf() the offset of the \"buffer\" is less than 0");
            throw new IllegalArgumentException("the offset of the \"buffer\" is less than 0");
        }
        if (bArr != null && i2 <= 0) {
            f157a.error("PDXAudioParam.addAudioBuf() the indicated length of the \"buffer\" is less than 1 byte");
            throw new IllegalArgumentException("the indicated length of the \"buffer\" is less than 1 byte");
        }
        if (this.f160d) {
            f157a.error("PDXAudioParam.addAudioBuf() last audio buffer already added!");
            throw new TransactionProcessingException("last audio buffer already added!");
        }
        if (z) {
            this.f160d = true;
        }
        byte[] bArr2 = null;
        if (bArr != null) {
            bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
        }
        this.f161e.send(new MessageSystem.MessageData((byte) 2, new Object[]{bArr2, new Boolean(z)}), this, Thread.currentThread(), this.f161e.getVRAddr()[0]);
    }

    protected int getBufferId() {
        return this.f158b;
    }

    @Override // com.nuance.nmsp.client.sdk.common.oem.api.MessageSystem.MessageHandler
    public void handleMessage(Object obj, Object obj2) {
        MessageSystem.MessageData messageData = (MessageSystem.MessageData) obj;
        switch (messageData.command) {
            case 1:
                this.f159c.vapRecordBegin(this.f158b);
                break;
            case 2:
                Object[] objArr = (Object[]) messageData.data;
                byte[] bArr = (byte[]) objArr[0];
                boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
                if (bArr != null) {
                    if (Util.isSpeexCodec(this.f159c.getInputCodec())) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        if (bArr.length >= 128) {
                            if (bArr.length >= 16384) {
                                if (bArr.length >= 2097152) {
                                    if (bArr.length >= 268435456) {
                                        f157a.error("buffer size is too big!");
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(((bArr.length >> 21) & 127) | 128);
                                        byteArrayOutputStream.write(((bArr.length >> 14) & 127) | 128);
                                        byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                                        byteArrayOutputStream.write(bArr.length & 127);
                                    }
                                } else {
                                    byteArrayOutputStream.write(((bArr.length >> 14) & 127) | 128);
                                    byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                                    byteArrayOutputStream.write(bArr.length & 127);
                                }
                            } else {
                                byteArrayOutputStream.write(((bArr.length >> 7) & 127) | 128);
                                byteArrayOutputStream.write(bArr.length & 127);
                            }
                        } else {
                            byteArrayOutputStream.write(bArr.length & 127);
                        }
                        byteArrayOutputStream.write(bArr, 0, bArr.length);
                        this.f159c.vapRecord(byteArrayOutputStream.toByteArray(), this.f158b);
                    } else {
                        this.f159c.vapRecord(bArr, this.f158b);
                    }
                }
                if (zBooleanValue) {
                    this.f159c.vapRecordEnd(this.f158b);
                    break;
                }
                break;
        }
    }
}
