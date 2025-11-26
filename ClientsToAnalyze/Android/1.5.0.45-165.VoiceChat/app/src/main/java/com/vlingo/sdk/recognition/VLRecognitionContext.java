package com.vlingo.sdk.recognition;

import com.vlingo.sdk.internal.util.StringUtils;

/* loaded from: classes.dex */
public class VLRecognitionContext {
    public static final boolean DEFAULT_AUTO_ENDPOINTING = true;
    public static final boolean DEFAULT_AUTO_PUNCTUATION = true;
    public static final String DEFAULT_FIELD_ID = "vp_car_main";
    public static final String DEFAULT_LANGUAGE = "en-US";
    public static final float DEFAULT_MIN_VOICE_DURATION = 0.08f;
    public static final float DEFAULT_MIN_VOICE_LEVEL = 57.0f;
    public static final int DEFAULT_NOSPEECH_ENDPOINT_TIMEOUT_MS = 5000;
    public static final boolean DEFAULT_PROFANITY_FILTER = true;
    public static final float DEFAULT_SILENCE_THRESHOLD = 11.0f;
    public static final int DEFAULT_SPEECH_ENDPOINT_TIMEOUT_MS = 1500;
    public static final int DEFAULT_SPEEX_COMPLEXITY = 0;
    public static final int DEFAULT_SPEEX_QUALITY = 7;
    public static final int DEFAULT_SPEEX_VARIABLE_BITRATE = 1;
    public static final int DEFAULT_SPEEX_VOICE_ACTIVITY_DETECTION = 0;
    public static final float DEFAULT_VOICE_PORTION = 0.02f;
    public static final int MAX_AUDIO_TIME = 55000;
    public static final int MAX_ENDPOINT_TIMEOUT_MS = 10000;
    public static final int MIN_ENDPOINT_TIMEOUT_MS = 200;
    private String appName;
    private AudioSourceInfo audioSourceInfo;
    private boolean autoEndpointing;
    private boolean autoPunctuation;
    private CapitalizationMode capitalizationMode;
    private String controlName;
    private String currentText;
    private int cursorPosition;
    private String fieldID;
    private String language;
    private int maxAudioTime;
    private float minVoiceDuration;
    private float minVoiceLevel;
    private int nospeechEndpointTimeout;
    private boolean profanityFilter;
    private String screenName;
    private float silenceThreshold;
    private int speechEndpointTimeout;
    private int speexComplexity;
    private int speexQuality;
    private int speexVariableBitrate;
    private int speexVoiceActivityDetection;
    private float voicePortion;

    public enum CapitalizationMode {
        OFF,
        DEFAULT,
        SENTENCES,
        PROPER_NOUN;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static CapitalizationMode[] valuesCustom() {
            CapitalizationMode[] capitalizationModeArrValuesCustom = values();
            int length = capitalizationModeArrValuesCustom.length;
            CapitalizationMode[] capitalizationModeArr = new CapitalizationMode[length];
            System.arraycopy(capitalizationModeArrValuesCustom, 0, capitalizationModeArr, 0, length);
            return capitalizationModeArr;
        }
    }

    public static class Builder {
        private AudioSourceInfo audioSourceInfo;
        private String language = "en-US";
        private int maxAudioTime = VLRecognitionContext.MAX_AUDIO_TIME;
        private boolean autoEndpointing = true;
        private int speechEndpointTimeout = VLRecognitionContext.DEFAULT_SPEECH_ENDPOINT_TIMEOUT_MS;
        private int nospeechEndpointTimeout = 5000;
        private float silenceThreshold = 11.0f;
        private float minVoiceDuration = 0.08f;
        private float voicePortion = 0.02f;
        private float minVoiceLevel = 57.0f;
        private int speexQuality = 7;
        private int speexVariableBitrate = 1;
        private int speexVoiceActivityDetection = 0;
        private int speexComplexity = 0;
        private String fieldID = VLRecognitionContext.DEFAULT_FIELD_ID;
        private String appName = null;
        private String screenName = null;
        private String controlName = null;
        private boolean autoPunctuation = true;
        private CapitalizationMode capitalizationMode = CapitalizationMode.DEFAULT;
        private String currentText = null;
        private int cursorPosition = 0;
        private boolean profanityFilter = true;

        protected Builder() {
        }

        public Builder(AudioSourceInfo info) {
            validateDefined(info);
            this.audioSourceInfo = info;
        }

        public Builder language(String language) {
            validateDefined(language);
            this.language = language;
            return this;
        }

        public Builder maxAudioTime(int time) {
            validateIntBoundary(time, VLRecognitionContext.MAX_AUDIO_TIME, 0);
            this.maxAudioTime = time;
            return this;
        }

        public Builder audioSourceInfo(AudioSourceInfo info) {
            validateDefined(info);
            this.audioSourceInfo = info;
            return this;
        }

        public Builder fieldID(String fieldID) {
            validateStringNotEmpty(fieldID);
            this.fieldID = fieldID;
            return this;
        }

        public Builder appInfo(String appName, String screenName, String controlName) {
            this.appName = appName;
            this.screenName = screenName;
            this.controlName = controlName;
            return this;
        }

        public Builder autoEndpointing(boolean enabled) {
            this.autoEndpointing = enabled;
            return this;
        }

        public Builder autoEndPointingTimeouts(int withSpeech, int withoutSpeech) {
            validateIntBoundary(withSpeech, 10000, 200);
            validateIntBoundary(withoutSpeech, 10000, 200);
            this.speechEndpointTimeout = withSpeech;
            this.nospeechEndpointTimeout = withoutSpeech;
            return this;
        }

        public Builder speechDetectorParams(float silenceThreshold, float minVoiceDuration, float voicePortion, float minVoiceLevel) {
            this.silenceThreshold = silenceThreshold;
            this.minVoiceDuration = minVoiceDuration;
            this.voicePortion = voicePortion;
            this.minVoiceLevel = minVoiceLevel;
            return this;
        }

        public Builder speexParams(int speexComplexity, int speexQuality, int speexVariableBitrate, int speexVoiceActivityDetection) {
            this.speexComplexity = speexComplexity;
            this.speexQuality = speexQuality;
            this.speexVariableBitrate = speexVariableBitrate;
            this.speexVoiceActivityDetection = speexVoiceActivityDetection;
            return this;
        }

        public Builder autoPunctuation(boolean autoPunc) {
            this.autoPunctuation = autoPunc;
            return this;
        }

        public Builder capitalizationMode(CapitalizationMode mode) {
            validateDefined(mode);
            this.capitalizationMode = mode;
            return this;
        }

        public Builder currentText(String text) {
            if (text != null) {
                this.currentText = text;
            }
            return this;
        }

        public Builder cursorPosition(int position) {
            if (position >= 0) {
                this.cursorPosition = position;
            }
            return this;
        }

        public Builder profanityFilter(boolean profFilter) {
            this.profanityFilter = profFilter;
            return this;
        }

        public VLRecognitionContext build() {
            return new VLRecognitionContext(this);
        }

        private void validateIntBoundary(int val, int max, int min) {
            if (val > max || val < min) {
                throw new IllegalArgumentException("Value must be between " + min + " and " + max);
            }
        }

        private void validateDefined(Object value) {
            if (value == null) {
                throw new IllegalArgumentException("Value cannot be null");
            }
        }

        private void validateStringNotEmpty(String string) {
            if (StringUtils.isNullOrWhiteSpace(string)) {
                throw new IllegalArgumentException("Value cannot be null or empty");
            }
        }
    }

    protected VLRecognitionContext(Builder builder) {
        this.language = builder.language;
        this.maxAudioTime = builder.maxAudioTime;
        this.autoEndpointing = builder.autoEndpointing;
        this.speechEndpointTimeout = builder.speechEndpointTimeout;
        this.nospeechEndpointTimeout = builder.nospeechEndpointTimeout;
        this.silenceThreshold = builder.silenceThreshold;
        this.minVoiceDuration = builder.minVoiceDuration;
        this.voicePortion = builder.voicePortion;
        this.minVoiceLevel = builder.minVoiceLevel;
        this.speexQuality = builder.speexQuality;
        this.speexVariableBitrate = builder.speexVariableBitrate;
        this.speexVoiceActivityDetection = builder.speexVoiceActivityDetection;
        this.speexComplexity = builder.speexComplexity;
        this.audioSourceInfo = builder.audioSourceInfo;
        this.autoPunctuation = builder.autoPunctuation;
        this.capitalizationMode = builder.capitalizationMode;
        this.fieldID = builder.fieldID;
        this.appName = builder.appName;
        this.screenName = builder.screenName;
        this.controlName = builder.controlName;
        this.currentText = builder.currentText;
        this.cursorPosition = builder.cursorPosition;
        this.profanityFilter = builder.profanityFilter;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getFieldID() {
        return this.fieldID;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getControlName() {
        return this.controlName;
    }

    public boolean getAutoPunctuation() {
        return this.autoPunctuation;
    }

    public CapitalizationMode getCapitalizationMode() {
        return this.capitalizationMode;
    }

    public String getCurrentText() {
        return this.currentText;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public int getMaxAudioTime() {
        return this.maxAudioTime;
    }

    public boolean autoEndpointingEnabled() {
        return this.autoEndpointing;
    }

    public int getSpeechEndpointTimeout() {
        return this.speechEndpointTimeout;
    }

    public int getNoSpeechEndPointTimeout() {
        return this.nospeechEndpointTimeout;
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

    public int getSpeexQuality() {
        return this.speexQuality;
    }

    public int getSpeexVariableBitrate() {
        return this.speexVariableBitrate;
    }

    public int getSpeexVoiceActivityDetection() {
        return this.speexVoiceActivityDetection;
    }

    public int getSpeexComplexity() {
        return this.speexComplexity;
    }

    public AudioSourceInfo getAudioSourceInfo() {
        return this.audioSourceInfo;
    }

    public boolean getProfanityFilter() {
        return this.profanityFilter;
    }
}
