package com.vlingo.sdk.internal.recognizer.reader;

import com.vlingo.sdk.internal.audio.RawInputStreamReader;
import com.vlingo.sdk.internal.audio.SpeexJNI;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.SRContext;
import com.vlingo.sdk.internal.recognizer.reader.DataReaderListener;
import com.vlingo.sdk.recognition.AudioSourceInfo;

/* loaded from: classes.dex */
public class SpeexDataReader extends DataReader {

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$recognition$AudioSourceInfo$SourceFormat */
    private static /* synthetic */ int[] f3254x9d704a0f = null;
    private static final int MAX_CODEC_OUTPUT_CHUNK = 1000;
    private static final float MIN_SPEECH_TIME = 0.5f;
    private static final int SPEEX_NB = 0;
    private static final int SPEEX_WB = 1;
    private static final int USE_SILENCE_DETECTION = 1;
    private Logger log;
    private boolean mAutoEndpointingEnabled;
    private float mAutoEndpointingTimeWithSpeech;
    private float mAutoEndpointingTimeWithoutSpeech;
    private RawInputStreamReader mRawInputStreamReader;
    private int mSampleRate;
    private boolean mSpeechDetected;
    private SpeexJNI mSpeex;
    private short[] mSpeexInputBuffer;
    private int mSpeexInputBufferSamples;
    private byte[] mSpeexOutputBuffer;
    private int mTotalMillisecProcessed;
    private int mTotalSamplesProcessed;

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$recognition$AudioSourceInfo$SourceFormat */
    static /* synthetic */ int[] m3096x9d704a0f() {
        int[] iArr = f3254x9d704a0f;
        if (iArr == null) {
            iArr = new int[AudioSourceInfo.SourceFormat.valuesCustom().length];
            try {
                iArr[AudioSourceInfo.SourceFormat.AMR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT_BE.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PCM_8KHZ_16BIT.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PCM_8KHZ_16BIT_BE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PCM_AUTO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[AudioSourceInfo.SourceFormat.PLAIN_TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            f3254x9d704a0f = iArr;
        }
        return iArr;
    }

    SpeexDataReader(SRContext srContext, DataReaderListener listener) {
        super(srContext, listener);
        this.log = Logger.getLogger(SpeexDataReader.class);
        this.mSpeexOutputBuffer = new byte[1000];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected boolean onInit() {
        this.log.debug("onInit()");
        try {
            SRContext srContext = getSRContext();
            AudioSourceInfo asi = srContext.getAudioSourceInfo();
            this.mAutoEndpointingEnabled = srContext.getAutoEndpointing();
            this.mAutoEndpointingTimeWithSpeech = srContext.getSpeechEndpointTimeout() / 1000.0f;
            this.mAutoEndpointingTimeWithoutSpeech = srContext.getNoSpeechEndpointTimeout() / 1000.0f;
            this.log.debug("EPD mAutoEndpointingTimeWithSpeech=" + this.mAutoEndpointingTimeWithSpeech + ", mAutoEndpointingTimeWithoutSpeech=" + this.mAutoEndpointingTimeWithoutSpeech + " for " + srContext.getFieldID());
            boolean isBigEndian = false;
            switch (m3096x9d704a0f()[asi.getFormat().ordinal()]) {
                case 2:
                    this.mSampleRate = 16000;
                    break;
                case 3:
                    this.mSampleRate = 8000;
                    break;
                case 4:
                    isBigEndian = true;
                    this.mSampleRate = 16000;
                    break;
                case 5:
                    isBigEndian = true;
                    this.mSampleRate = 8000;
                    break;
                default:
                    this.mSampleRate = 16000;
                    break;
            }
            this.mSpeex = new SpeexJNI();
            int speexMode = this.mSampleRate == 16000 ? 1 : 0;
            float silenceThreshold = srContext.getSilenceThreshold();
            float minVoiceDuration = srContext.getMinVoiceDuration();
            float voicePortion = srContext.getVoicePortion();
            float minVoiceLevel = srContext.getMinVoiceLevel();
            int speexQuality = srContext.getSpeexQuality();
            int speexComplexity = srContext.getSpeexComplexity();
            int speexVariableBitrate = srContext.getSpeexVariableBitrate();
            int speexVoiceActivityDetection = srContext.getSpeexVoiceActivityDetection();
            int speexChunkSize = this.mSpeex.initialize(speexMode, speexQuality, speexComplexity, speexVariableBitrate, speexVoiceActivityDetection, 1, silenceThreshold, minVoiceDuration, voicePortion, minVoiceLevel);
            this.log.debug("Speex Init - mode=" + speexMode + ", speexChunkSize=" + speexChunkSize + ", samplerate: " + this.mSampleRate);
            this.mSpeexInputBuffer = new short[speexChunkSize];
            this.mRawInputStreamReader = new RawInputStreamReader(getInputStream(), isBigEndian, speexChunkSize);
            return true;
        } catch (Exception e) {
            this.log.error("Error initializing: " + e.toString());
            return false;
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected void onDeinit() {
        this.mSpeex.encode(this.mSpeexInputBuffer, this.mSpeexOutputBuffer, 1000, 1);
        this.mSpeex = null;
        this.mRawInputStreamReader = null;
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected void onProcessData() {
        boolean isDone = false;
        int samplesToRead = this.mSpeexInputBuffer.length - this.mSpeexInputBufferSamples;
        try {
            int samplesRead = this.mRawInputStreamReader.read(this.mSpeexInputBuffer, this.mSpeexInputBufferSamples, samplesToRead);
            if (samplesRead == -1) {
                this.log.debug("isDone now true because samplesRead == -1, i.e. not more data ");
                isDone = true;
            }
            if (samplesRead > 0) {
                this.mSpeexInputBufferSamples += samplesRead;
                this.mTotalSamplesProcessed += samplesRead;
                this.mTotalMillisecProcessed = (this.mTotalSamplesProcessed * 1000) / this.mSampleRate;
                if (this.mTotalMillisecProcessed > getMaxDuration()) {
                    this.log.debug("isDone now true because mTotalMillisecProcessed > getMaxDuration(), " + this.mTotalMillisecProcessed + ">" + getMaxDuration());
                    isDone = true;
                }
            }
            if (isDone && this.mSpeexInputBufferSamples > 0 && this.mSpeexInputBufferSamples < this.mSpeexInputBuffer.length) {
                this.log.debug("padding last speex input chunk with zeros...");
                while (this.mSpeexInputBufferSamples < this.mSpeexInputBuffer.length) {
                    short[] sArr = this.mSpeexInputBuffer;
                    int i = this.mSpeexInputBufferSamples;
                    this.mSpeexInputBufferSamples = i + 1;
                    sArr[i] = 0;
                }
            }
            if (this.mSpeexInputBufferSamples >= this.mSpeexInputBuffer.length) {
                int outLen = this.mSpeex.encode(this.mSpeexInputBuffer, this.mSpeexOutputBuffer, 1000, 0);
                if (outLen > 0) {
                    int lastSpeechSample = -1;
                    int lastEnergy = -1;
                    if (outLen < 992) {
                        lastSpeechSample = convertBytesToInt(this.mSpeexOutputBuffer, outLen);
                        lastEnergy = convertBytesToInt(this.mSpeexOutputBuffer, outLen + 4);
                        if (lastSpeechSample > -1) {
                            this.mSpeechDetected = true;
                        }
                        this.log.debug("lastEnergy= " + lastEnergy + ", lastSpeechSample= " + lastSpeechSample + ", totalSamplesRecorded= " + this.mTotalSamplesProcessed);
                    }
                    if (!isDone && this.mAutoEndpointingEnabled) {
                        float timeSinceLastSpeechSample = (this.mTotalSamplesProcessed - lastSpeechSample) / this.mSampleRate;
                        float lastSpeechTime = lastSpeechSample / this.mSampleRate;
                        float timeThresholdToUse = lastSpeechTime > MIN_SPEECH_TIME ? this.mAutoEndpointingTimeWithSpeech : this.mAutoEndpointingTimeWithoutSpeech;
                        if (timeSinceLastSpeechSample > timeThresholdToUse) {
                            this.log.debug("EPD isDone now true because timeSinceLastSpeechSample > timeThresholdToUse, " + timeSinceLastSpeechSample + ">" + timeThresholdToUse);
                            isDone = true;
                        }
                    }
                    byte[] data = new byte[outLen];
                    System.arraycopy(this.mSpeexOutputBuffer, 0, data, 0, outLen);
                    onDataAvailable(data, lastEnergy, this.mTotalMillisecProcessed);
                } else {
                    this.log.debug("isDone now true because mSpeexInputBufferSamples >= mSpeexInputBuffer.length, " + this.mSpeexInputBufferSamples + ">=" + this.mSpeexInputBuffer.length);
                    isDone = true;
                }
                this.mSpeexInputBufferSamples = 0;
            }
            if (isDone) {
                stop();
            }
        } catch (Exception e) {
            this.log.error("Exception reading from stream: " + e.toString());
            onError(DataReaderListener.ErrorCode.READ_ERROR, e.toString());
        }
    }

    @Override // com.vlingo.sdk.internal.recognizer.reader.DataReader
    protected boolean isSpeechDetected() {
        return this.mSpeechDetected;
    }

    private int convertBytesToInt(byte[] input, int startIndex) {
        int shift = 0;
        int value = 0;
        for (int i = startIndex; i < startIndex + 4; i++) {
            value |= (input[i] & 255) << shift;
            shift += 8;
        }
        return value;
    }
}
