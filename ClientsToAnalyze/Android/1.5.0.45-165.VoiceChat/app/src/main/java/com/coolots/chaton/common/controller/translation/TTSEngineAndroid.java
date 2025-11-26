package com.coolots.chaton.common.controller.translation;

import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.TTSEngine;
import com.sds.coolots.common.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public class TTSEngineAndroid extends TTSEngine implements TextToSpeech.OnInitListener {
    private String SMT_SENTENCE_FINISHED = "finished";
    private TextToSpeech mTTS = null;

    public void logE(String message) {
        Log.m2958e("[TTSEngineAndroid]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[TTSEngineAndroid]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void init() {
        super.init();
        setTTS(this.mTTS);
    }

    private void setTTS(TextToSpeech tts) {
        this.mTTS = new TextToSpeech(MainApplication.mContext, this, "com.samsung.SMT");
        this.mTTS.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: com.coolots.chaton.common.controller.translation.TTSEngineAndroid.1
            @Override // android.speech.tts.UtteranceProgressListener
            public void onDone(String arg0) {
                TTSEngineAndroid.this.logI("onDone :" + arg0);
                if (TTSEngineAndroid.this.SMT_SENTENCE_FINISHED.equals(arg0)) {
                    TTSEngineAndroid.this.notifyEnd();
                }
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onError(String arg0) {
                TTSEngineAndroid.this.logI("onError :" + arg0);
                if (TTSEngineAndroid.this.SMT_SENTENCE_FINISHED.equals(arg0)) {
                    TTSEngineAndroid.this.notifyEnd();
                }
            }

            @Override // android.speech.tts.UtteranceProgressListener
            public void onStart(String arg0) {
                TTSEngineAndroid.this.logI("onStart :" + arg0);
                if (TTSEngineAndroid.this.SMT_SENTENCE_FINISHED.equals(arg0)) {
                    TTSEngineAndroid.this.notifyStart();
                }
            }
        });
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public Set<Integer> getSupportedLanguage() {
        Set<Integer> language = new HashSet<>();
        language.add(10);
        language.add(21);
        language.add(20);
        language.add(30);
        language.add(31);
        language.add(40);
        return null;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public boolean play(TranslationDisplayData data) {
        super.play(data);
        logI("Android TTS play start: " + data.getTranslatedText());
        if (data.getOutLanguage() == 10) {
            return playTTS(Locale.KOREAN, data.getTranslatedText());
        }
        if (data.getOutLanguage() == 21 || data.getOutLanguage() == 20) {
            return playTTS(Locale.ENGLISH, data.getTranslatedText());
        }
        if (data.getOutLanguage() == 30 || data.getOutLanguage() == 31) {
            return playTTS(Locale.CHINESE, data.getTranslatedText());
        }
        if (data.getOutLanguage() == 40) {
            return playTTS(Locale.JAPANESE, data.getTranslatedText());
        }
        logE("not supported language");
        return false;
    }

    private boolean playTTS(Locale loc, String text) {
        if (this.mTTS.isSpeaking()) {
            this.mTTS.stop();
        }
        int result = this.mTTS.setLanguage(loc);
        if (result == -1 || result == -2) {
            logE("not supported language " + loc);
            return false;
        }
        HashMap<String, String> m_stHashMap = new HashMap<>();
        m_stHashMap.put("utteranceId", this.SMT_SENTENCE_FINISHED);
        this.mTTS.speak(text, 0, m_stHashMap);
        return true;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void dispose() {
        super.dispose();
        if (this.mTTS != null) {
            if (this.mTTS.isSpeaking()) {
                this.mTTS.stop();
            }
            this.mTTS.shutdown();
            this.mTTS = null;
        }
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int status) {
        if (status == 0) {
            logI("onInit: " + status);
        }
    }
}
