package com.vlingo.sdk.recognition.speech;

import com.vlingo.sdk.VLComponent;

/* loaded from: classes.dex */
public interface VLSpeechDetector extends VLComponent {
    boolean processShortArray(short[] sArr, int i, int i2);

    boolean startSpeechDetector(VLSpeechDetectorContext vLSpeechDetectorContext);

    void stopSpeechDetector();
}
