package com.coolots.chaton.common.controller.translation;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.util.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class TTSController implements ITTSController {
    private static final boolean USE_ONLY_ANDROID_TTS = true;
    private TTSEngineSvox mEnglishPlayer;
    private TTSEnginePowerTTS mKoreanPlayer;
    private TTSEngineAndroid mOtherPlayer;

    public void logE(String message) {
        Log.m2958e("[TTSController]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[TTSController]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.ITTSController
    public void init() {
        logI("init");
        this.mOtherPlayer = new TTSEngineAndroid();
        this.mOtherPlayer.init();
    }

    public Set<Integer> getSupportedLanguage() {
        Set<Integer> language = new HashSet<>();
        language.addAll(this.mOtherPlayer.getSupportedLanguage());
        return null;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.ITTSController
    public void play(TranslationDisplayData data) {
        logI("play");
        logE("TTS(Other Language)");
        if (!this.mOtherPlayer.play(data)) {
            logE("TTS(Other Language) fail");
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.ITTSController
    public void stop() throws RuntimeException {
        dispose();
    }

    @Override // com.sds.coolots.common.controller.translation.engine.ITTSController
    public void dispose() throws RuntimeException {
        logI("dispose");
        if (this.mOtherPlayer != null) {
            this.mOtherPlayer.dispose();
        }
        if (this.mKoreanPlayer != null) {
            this.mKoreanPlayer.dispose();
        }
        if (this.mEnglishPlayer != null) {
            this.mEnglishPlayer.dispose();
        }
    }
}
