package com.csli.eztalky.p001sp;

/* loaded from: classes.dex */
public interface VRListener {
    public static final int CANNOT_START_RECORDING = 1;
    public static final int ERROR_BAD_NETWORK = 15;
    public static final int ERROR_CONNECT_SERVER = 9;
    public static final int ERROR_GETTING_VOICE_RECOGNITION = 5;
    public static final int ERROR_INIT_VOICE_RECOGNITION = 0;
    public static final int ERROR_NETBLOCK = 7;
    public static final int ERROR_NET_DISCONNECT = 8;
    public static final int ERROR_NO_SPEECH = 6;
    public static final int ERROR_NO_TOKEN = 14;
    public static final int ERROR_PCM_STREAM = 4;
    public static final int ERROR_PROCESSING_START_RECORDING = 2;
    public static final int ERROR_SERVER_BUSY = 16;
    public static final int ERROR_SERVER_UNKNOWN = 10;
    public static final int ERROR_TIME_OVER = 13;
    public static final int ERROR_TRANS_SERVER = 12;
    public static final int ERROR_UNKNOWN = 9999;
    public static final int ERROR_USER_CANCEL = 3;
    public static final int ERROR_VR_SERVER = 11;

    int onEndRecording(VRecognizer vRecognizer);

    void onError(VRecognizer vRecognizer, int i);

    void onPreparedRecording(VRecognizer vRecognizer);

    void onSent(VRecognizer vRecognizer);

    void onStartRecording(VRecognizer vRecognizer);
}
