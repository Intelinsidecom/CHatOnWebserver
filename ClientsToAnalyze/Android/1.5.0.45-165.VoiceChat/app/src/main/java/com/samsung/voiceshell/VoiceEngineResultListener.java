package com.samsung.voiceshell;

/* loaded from: classes.dex */
public interface VoiceEngineResultListener {
    void OnEnrollResult(int i, int i2, int i3);

    void OnRmsForWave(int i);

    void OnVerifyResult(int i, short s);
}
