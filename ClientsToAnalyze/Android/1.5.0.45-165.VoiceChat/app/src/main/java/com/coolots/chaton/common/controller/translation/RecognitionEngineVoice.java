package com.coolots.chaton.common.controller.translation;

import com.coolots.chaton.SECConfig;
import com.coolots.chaton.common.controller.translation.util.TranslationUtil;
import com.csli.eztalky.VRecognitionListener;
import com.samsung.voiceservice.SVoiceVoIPASR;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.translation.engine.RecognitionEngine;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class RecognitionEngineVoice extends RecognitionEngine implements VRecognitionListener, SVoiceVoIPASR.OnAsrResultListener, DisposeInterface {
    private static final int IS_VOICE_DEFAULT = 235715468;
    private static final int IS_VOICE_MUTE = 0;
    private static final int IS_VOICE_VOICE = 1;
    private static SVoiceVoIPASR mSVoiceASR;
    private int mIsVoice = IS_VOICE_DEFAULT;
    private Object mLock = new Object();

    public void logE(String message) {
        Log.m2958e("[RecognitionEngineVoice]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[RecognitionEngineVoice]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void init() {
        super.init();
        if (mSVoiceASR == null) {
            mSVoiceASR = new SVoiceVoIPASR(MainApplication.mContext);
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public Set<Integer> getSupportedLanguage() {
        Set<Integer> language = new HashSet<>();
        language.add(20);
        language.add(10);
        language.add(40);
        logI("getSupportedLanguage(): " + language.toString());
        return language;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public boolean isSupportedLanguage(int voiceLanguage) {
        Set<Integer> language = getSupportedLanguage();
        return language.contains(Integer.valueOf(voiceLanguage));
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public int getVoiceLanguage() {
        return this.mVoiceLanguage;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void start() {
        super.start();
        logI("start() language: " + TranslationUtil.getParamLanguage(this.mVoiceLanguage));
        synchronized (this.mLock) {
            mSVoiceASR.SVoiceVoIPASRSetListener(this);
            SECConfig.jniSetTxPCMCaptureMode(1);
            this.mIsVoice = IS_VOICE_DEFAULT;
            mSVoiceASR.startRecognition(TranslationUtil.getParamLanguage(this.mVoiceLanguage));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void stop() {
        logI("stop()");
        synchronized (this.mLock) {
            SECConfig.jniSetTxPCMCaptureMode(0);
            mSVoiceASR.SVoiceVoIPASRSetListener(null);
            mSVoiceASR.stopRecognition();
        }
        super.stop();
    }

    public void setLanguage(int voiceLanguage, int translatedLanguage) {
        logI("setLanguage(" + voiceLanguage + ", " + translatedLanguage);
        super.setLangauge(voiceLanguage, translatedLanguage);
        synchronized (this.mLock) {
            SECConfig.jniSetTxPCMCaptureMode(0);
            mSVoiceASR.SVoiceVoIPASRSetListener(null);
            mSVoiceASR.stopRecognition();
            mSVoiceASR.SVoiceVoIPASRSetListener(this);
            SECConfig.jniSetTxPCMCaptureMode(1);
            this.mIsVoice = IS_VOICE_DEFAULT;
            mSVoiceASR.startRecognition(TranslationUtil.getParamLanguage(this.mVoiceLanguage));
        }
    }

    @Override // com.samsung.voiceservice.SVoiceVoIPASR.OnAsrResultListener
    public void onAsrResult(String recognized) {
        logI("onAsrResult(" + recognized + ")");
        notifyRecognitionEnd(toValidRecognizedString(recognized));
        if (isActive()) {
            start();
        }
    }

    @Override // com.samsung.voiceservice.SVoiceVoIPASR.OnAsrResultListener
    public void onAsrError(String errorMessage) {
        logI("onAsrError(" + errorMessage + ")");
        notifyRecognitionEnd(null);
    }

    @Override // com.samsung.voiceservice.SVoiceVoIPASR.OnAsrResultListener
    public void onAsrIsVoice(int isVoice) {
        logI("onAsrIsVoice(" + isVoice + ")");
        if (this.mIsVoice == 1 && isVoice == 0) {
            logI("++++++++++++++++++++++++++++++++++++");
            notifyRecognitionStart();
        }
        this.mIsVoice = isVoice;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.RecognitionEngine
    public void dispose() throws IOException {
        logI("dispose()");
        if (mSVoiceASR != null) {
            SECConfig.jniSetTxPCMCaptureMode(0);
            mSVoiceASR.SVoiceVoIPASRSetListener(null);
            mSVoiceASR.stopRecognition();
        }
        super.dispose();
    }

    @Override // com.csli.eztalky.CSListener
    public void onError(int arg0) {
        logI("onError " + arg0);
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onEndVR() {
        logI("onEndVR");
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onPreparedVR() {
        logI("onPreparedVR");
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void onStartVR() {
        logI("onStartVR");
    }

    @Override // com.csli.eztalky.VRecognitionListener
    public void recognitionCompleted(String arg0) {
        logI("recognitionCompleted(" + arg0 + ")");
    }
}
