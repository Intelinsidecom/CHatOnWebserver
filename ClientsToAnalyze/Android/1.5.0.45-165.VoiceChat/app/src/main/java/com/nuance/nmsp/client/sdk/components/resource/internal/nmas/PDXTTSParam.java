package com.nuance.nmsp.client.sdk.components.resource.internal.nmas;

import com.nuance.nmsp.client.sdk.components.general.NMSPAudioSink;
import com.nuance.nmsp.client.sdk.components.resource.internal.common.NMSPSession;
import com.nuance.nmsp.client.sdk.components.resource.nmas.Parameter;

/* loaded from: classes.dex */
public class PDXTTSParam extends PDXParam implements Parameter {

    /* renamed from: a */
    private PDXDictionary f185a;

    /* renamed from: b */
    private NMSPAudioSink f186b;

    /* renamed from: c */
    private int f187c;

    public PDXTTSParam(String str, NMSPSession nMSPSession, PDXDictionary pDXDictionary, NMSPAudioSink nMSPAudioSink) {
        super(str, (byte) 127);
        this.f185a = pDXDictionary;
        this.f186b = nMSPAudioSink;
        this.f187c = nMSPSession.getNewAudioId();
        pDXDictionary.addInteger("audio_id", this.f187c);
    }

    protected int getAudioId() {
        return this.f187c;
    }

    protected NMSPAudioSink getAudioSink() {
        return this.f186b;
    }

    protected byte[] getContent() {
        return this.f185a.getContent();
    }
}
