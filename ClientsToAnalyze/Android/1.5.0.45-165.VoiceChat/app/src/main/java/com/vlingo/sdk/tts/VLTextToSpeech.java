package com.vlingo.sdk.tts;

import com.vlingo.sdk.VLComponent;

/* loaded from: classes.dex */
public interface VLTextToSpeech extends VLComponent {
    void cancel();

    String[] getSupportedLanguageList();

    void synthesizeToFile(VLTextToSpeechRequest vLTextToSpeechRequest, String str, VLTextToSpeechListener vLTextToSpeechListener);
}
