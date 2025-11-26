package com.vlingo.sdk.recognition.spotter;

import com.vlingo.sdk.VLComponent;

/* loaded from: classes.dex */
public interface VLSpotter extends VLComponent {
    float getLastScore();

    String[] getSupportedLanguageList();

    String processShortArray(short[] sArr, int i, int i2);

    boolean startSpotter(VLSpotterContext vLSpotterContext);

    void stopSpotter();
}
