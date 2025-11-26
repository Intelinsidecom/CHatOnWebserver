package com.csli.eztalky;

/* loaded from: classes.dex */
public interface VRecognitionListener extends CSListener {
    public static final int ERROR_INIT_VR = 4;
    public static final int ERROR_NO_SPEECH = 7;
    public static final int ERROR_NO_TOKEN = 9;
    public static final int ERROR_PCM_STREAM = 12;
    public static final int ERROR_PROCESSING_VR = 5;
    public static final int ERROR_SERVER_BUSY = 11;
    public static final int ERROR_TIME_OVER = 10;
    public static final int ERROR_USER_CANCEL = 6;
    public static final int ERROR_VR_SERVER = 8;

    void onEndVR();

    void onPreparedVR();

    void onStartVR();

    void recognitionCompleted(String str);
}
