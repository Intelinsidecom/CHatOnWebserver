package com.nuance.nmsp.client.sdk.components.resource.internal.common;

/* loaded from: classes.dex */
public interface NMSPSessionListener {
    void onBcpData(byte b, long j, byte[] bArr);

    void onBcpEvent(byte b, short s);

    void onBcpFreeResourceId();

    void onBcpGenerateAudioComplete(byte b, long j, long j2, short s);

    void onBcpGetParamsComplete(byte b, long j, short s, byte[] bArr);

    void onBcpRecognitionComplete(byte b, long j, short s, byte[] bArr);

    void onBcpRecognitionIntermediateResults(byte b, long j, short s, byte[] bArr);

    void onBcpResponse(byte b, long j, short s, short s2, short s3);

    void onBcpSetParamsComplete(byte b, long j, short s, byte[] bArr);

    void onMsgNotSent(byte b, String str, Object obj);

    void onMsgSent(byte b, String str, Object obj);

    void onSessionConnected(byte[] bArr);

    void onSessionDisconnected(short s);

    void onVapPlayBeginReceived();

    void onVapPlayEndReceived();

    void onVapPlayReceived();

    void onVapSending();
}
