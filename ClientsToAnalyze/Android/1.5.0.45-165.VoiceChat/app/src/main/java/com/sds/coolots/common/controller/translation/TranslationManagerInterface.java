package com.sds.coolots.common.controller.translation;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.ITTSController;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.controller.translation.engine.TranslatorEngine;
import java.util.Set;

/* loaded from: classes.dex */
public interface TranslationManagerInterface {
    public static final int FAIL = 1;
    public static final int FAIL_INVALID_LANGUAGE = 2;
    public static final int FAIL_NO_RECOGNIZED_TEXT = 3;
    public static final int SUCCESS = 0;

    void dispose();

    Set getSupportedTranslationLanguage(int i);

    Set getSupportedVoiceLanguage();

    int getTranslationInLanguage();

    int getTranslationOutLanguage();

    int getVoiceLanguage();

    int init(RecognitionEngine recognitionEngine, TranslatorEngine translatorEngine, ITTSController iTTSController);

    boolean isActiveRecognition();

    void playTTS(TranslationDisplayData translationDisplayData);

    int setLanguage(int i, int i2);

    int setTranslatedLanguage(int i);

    int setVoiceLanguage(int i);

    int startRecognition();

    int startTranslation(TranslationDisplayData translationDisplayData);

    void stopRecognition();

    void stopTranslation();
}
