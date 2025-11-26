package com.vlingo.sdk.internal;

import android.os.Handler;
import com.vlingo.sdk.internal.audio.VLSilJNI;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import com.vlingo.sdk.recognition.speech.VLSpeechDetector;
import com.vlingo.sdk.recognition.speech.VLSpeechDetectorContext;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class VLSpeechDetectorImpl extends VLComponentImpl implements VLSpeechDetector {
    private static Logger log = Logger.getLogger(VLSpeechDetectorImpl.class);
    private boolean mIsStarted;
    private int mPrevLastSpeechSample;
    private VLSilJNI mVLSilJNI;

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ void destroy() {
        super.destroy();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl, com.vlingo.sdk.VLComponent
    public /* bridge */ /* synthetic */ boolean isValid() {
        return super.isValid();
    }

    public VLSpeechDetectorImpl(VLComponentManager manager, Handler handler) {
        super(manager, handler);
        log.debug("VLSpotterImpl()");
        VLSilJNI.init();
        this.mVLSilJNI = new VLSilJNI();
    }

    @Override // com.vlingo.sdk.internal.VLComponentImpl
    void onDestroy() {
        log.debug("onDestroy()");
        this.mVLSilJNI = null;
    }

    @Override // com.vlingo.sdk.recognition.speech.VLSpeechDetector
    public synchronized boolean startSpeechDetector(VLSpeechDetectorContext context) {
        log.debug("startSpeechDetector()");
        validateInstance();
        if (context == null) {
            throw new IllegalArgumentException("context must be specified");
        }
        if (this.mIsStarted) {
            throw new IllegalStateException("SpeechDetector already started");
        }
        int sampleRate = context.getAudioSourceInfo().getFormat() == AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT ? 16000 : 8000;
        this.mVLSilJNI.initialize(sampleRate, context.getSilenceThreshold(), context.getMinVoiceDuration(), context.getVoicePortion(), context.getMinVoiceLevel());
        this.mPrevLastSpeechSample = -1;
        this.mIsStarted = true;
        return true;
    }

    @Override // com.vlingo.sdk.recognition.speech.VLSpeechDetector
    public synchronized void stopSpeechDetector() {
        log.debug("stopSpeechDetector()");
        validateInstance();
        if (this.mIsStarted) {
            this.mIsStarted = false;
        }
    }

    @Override // com.vlingo.sdk.recognition.speech.VLSpeechDetector
    public synchronized boolean processShortArray(short[] audioData, int offsetInShorts, int sizeInShorts) {
        boolean speechDetected;
        log.debug("processShortArray(), offsetInShort=" + offsetInShorts + ", sizeInShorts=" + sizeInShorts);
        validateInstance();
        if (!this.mIsStarted) {
            throw new IllegalStateException("Cannot call processShortArray when SpeechDetector is not started.");
        }
        if (offsetInShorts > 0) {
            audioData = Arrays.copyOfRange(audioData, offsetInShorts, offsetInShorts + sizeInShorts);
        }
        speechDetected = false;
        int lastSpeechSample = this.mVLSilJNI.processShortArray(audioData, sizeInShorts);
        if (lastSpeechSample > this.mPrevLastSpeechSample) {
            speechDetected = true;
        }
        this.mPrevLastSpeechSample = lastSpeechSample;
        return speechDetected;
    }
}
