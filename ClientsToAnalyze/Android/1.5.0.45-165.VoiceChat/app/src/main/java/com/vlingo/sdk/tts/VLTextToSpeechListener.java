package com.vlingo.sdk.tts;

/* loaded from: classes.dex */
public interface VLTextToSpeechListener {
    void onError(VLTextToSpeechErrors vLTextToSpeechErrors, String str);

    void onSuccess();
}
