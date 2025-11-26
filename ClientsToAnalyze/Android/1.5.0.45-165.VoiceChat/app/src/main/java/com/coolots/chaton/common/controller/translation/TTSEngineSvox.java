package com.coolots.chaton.common.controller.translation;

import android.media.AudioTrack;
import com.google.protobuf.CodedOutputStream;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.controller.translation.engine.TTSEngine;
import com.sds.coolots.common.util.Log;
import com.svox.classic.TTS;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class TTSEngineSvox extends TTSEngine implements TTS.TTSSpeechData {
    private long mChannelHandle;
    private long mEngineHandle;
    private long mLingwareHandle;
    private TTS mSOfA = null;
    private AudioTrack mAudio = null;
    private Thread mThread = null;

    public void logE(String message) {
        Log.m2958e("[TTSEngineSvox]" + message);
    }

    public void logI(String message) {
        Log.m2954d("[TTSEngineSvox]" + message);
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void init() {
        super.init();
        try {
            if (this.mSOfA == null) {
                this.mSOfA = new TTS("/sdcard/demo/", this);
                this.mLingwareHandle = this.mSOfA.loadLingware("/sdcard/talkingandroid/", "svox-lh0lt2en-US22.pil");
                this.mEngineHandle = this.mSOfA.newEngine("/sdcard/demo/");
                this.mChannelHandle = this.mSOfA.newChannel(this.mEngineHandle, "");
            }
        } catch (RuntimeException ex) {
            logE(new StringBuilder().append(ex).toString());
        }
        try {
            this.mAudio = new AudioTrack(3, 22050, 4, 2, CodedOutputStream.DEFAULT_BUFFER_SIZE, 1);
        } catch (IllegalArgumentException argex) {
            logE(new StringBuilder().append(argex).toString());
        }
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public Set<Integer> getSupportedLanguage() {
        Set<Integer> language = new HashSet<>();
        language.add(20);
        return null;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public boolean play(final TranslationDisplayData data) {
        super.play(data);
        notifyStart();
        this.mThread = new Thread(new Runnable() { // from class: com.coolots.chaton.common.controller.translation.TTSEngineSvox.1
            @Override // java.lang.Runnable
            public void run() {
                TTSEngineSvox.this.logI("Svox TTS play start: " + data.getTranslatedText());
                TTSEngineSvox.this.mSOfA.synthString(TTSEngineSvox.this.mEngineHandle, TTSEngineSvox.this.mChannelHandle, data.getTranslatedText());
            }
        });
        this.mThread.start();
        return true;
    }

    @Override // com.sds.coolots.common.controller.translation.engine.TTSEngine
    public void dispose() throws RuntimeException {
        if (this.mSOfA != null) {
            this.mSOfA.closeChannel(this.mEngineHandle, this.mChannelHandle);
            this.mSOfA.closeEngine(this.mEngineHandle);
            this.mSOfA.unloadLingware(this.mLingwareHandle);
            this.mSOfA = null;
        }
        if (this.mThread != null) {
            this.mThread.interrupt();
            this.mThread = null;
        }
        super.dispose();
    }

    @Override // com.svox.classic.TTS.TTSSpeechData
    public void onSpeechData(short[] samples) throws IllegalStateException {
        logI("onSeechData()++");
        this.mAudio.play();
        this.mAudio.write(samples, 0, samples.length);
        this.mAudio.stop();
        logI("onSpeechData()--");
    }

    @Override // com.svox.classic.TTS.TTSSpeechData
    public void onSpeechDone(int arg0) {
        notifyEnd();
        if (this.mThread != null) {
            this.mThread.interrupt();
            this.mThread = null;
        }
    }
}
