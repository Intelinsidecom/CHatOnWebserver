package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;

/* loaded from: classes.dex */
public interface SRRequestListener {
    public static final int CONNECTING = 1;
    public static final int CONNECT_FAILURE = -1;
    public static final int RECEIVING = 3;
    public static final int RECORDER_ERROR = -2;
    public static final int SENDING = 2;
    public static final int TIMED_OUT = -3;

    void requestFailed(int i);

    void resultReceived(SRRecognitionResponse sRRecognitionResponse);

    void stateChanged(int i);
}
