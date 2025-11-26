package com.vlingo.sdk.internal.recognizer;

/* loaded from: classes.dex */
public interface SRRequest {
    public static final int DEFAULT_TIMEOUT = -1;

    void addListener(SRRequestListener sRRequestListener);

    void cancel(boolean z);

    void finish();

    long getTimeGotResult();

    long getTimeSendFinish();

    long getTimeSendStart();

    boolean isCancelled();

    boolean isResponseReceived();

    void removeListener(SRRequestListener sRRequestListener);

    void sendAudio(byte[] bArr, int i, int i2);
}
