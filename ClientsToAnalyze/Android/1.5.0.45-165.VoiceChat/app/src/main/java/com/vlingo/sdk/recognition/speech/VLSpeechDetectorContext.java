package com.vlingo.sdk.recognition.speech;

import com.vlingo.sdk.recognition.AudioSourceInfo;

/* loaded from: classes.dex */
public final class VLSpeechDetectorContext {
    public static final float DEFAULT_MIN_VOICE_DURATION = 0.08f;
    public static final float DEFAULT_MIN_VOICE_LEVEL = 57.0f;
    public static final float DEFAULT_SILENCE_THRESHOLD = 11.0f;
    public static final float DEFAULT_VOICE_PORTION = 0.02f;
    private AudioSourceInfo audioSourceInfo;
    private float minVoiceDuration;
    private float minVoiceLevel;
    private float silenceThreshold;
    private float voicePortion;

    public static class Builder {
        private AudioSourceInfo audioSourceInfo = AudioSourceInfo.getDataBufferSource(AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT);
        private float silenceThreshold = 11.0f;
        private float minVoiceDuration = 0.08f;
        private float voicePortion = 0.02f;
        private float minVoiceLevel = 57.0f;

        public Builder audioSourceInfo(AudioSourceInfo info) {
            validateDefined(info);
            AudioSourceInfo.SourceType type = info.getType();
            if (type != AudioSourceInfo.SourceType.BUFFER) {
                throw new IllegalArgumentException("Unsupported audio source, supported formats are: SourceType.BUFFER");
            }
            AudioSourceInfo.SourceFormat format = info.getFormat();
            if (format != AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT && format != AudioSourceInfo.SourceFormat.PCM_8KHZ_16BIT) {
                throw new IllegalArgumentException("Unsupported audio format format, supported formats are: SourceFormat.PCM_16KHZ_16BIT, SourceFormat.PCM_8KHZ_16BIT");
            }
            this.audioSourceInfo = info;
            return this;
        }

        public Builder speechDetectorParams(float silenceThreshold, float minVoiceDuration, float voicePortion, float minVoiceLevel) {
            this.silenceThreshold = silenceThreshold;
            this.minVoiceDuration = minVoiceDuration;
            this.voicePortion = voicePortion;
            this.minVoiceLevel = minVoiceLevel;
            return this;
        }

        public VLSpeechDetectorContext build() {
            return new VLSpeechDetectorContext(this, null);
        }

        private void validateDefined(Object value) {
            if (value == null) {
                throw new IllegalArgumentException("Value cannot be null");
            }
        }
    }

    private VLSpeechDetectorContext(Builder builder) {
        this.audioSourceInfo = builder.audioSourceInfo;
        this.silenceThreshold = builder.silenceThreshold;
        this.minVoiceDuration = builder.minVoiceDuration;
        this.voicePortion = builder.voicePortion;
        this.minVoiceLevel = builder.minVoiceLevel;
    }

    /* synthetic */ VLSpeechDetectorContext(Builder builder, VLSpeechDetectorContext vLSpeechDetectorContext) {
        this(builder);
    }

    public AudioSourceInfo getAudioSourceInfo() {
        return this.audioSourceInfo;
    }

    public float getSilenceThreshold() {
        return this.silenceThreshold;
    }

    public float getMinVoiceDuration() {
        return this.minVoiceDuration;
    }

    public float getVoicePortion() {
        return this.voicePortion;
    }

    public float getMinVoiceLevel() {
        return this.minVoiceLevel;
    }
}
