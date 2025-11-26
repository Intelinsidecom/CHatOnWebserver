package com.vlingo.sdk.tts;

/* loaded from: classes.dex */
public final class VLTextToSpeechRequest {
    public static final String DEFAULT_LANGUAGE = "en-US";
    public static final int DEFAULT_MAX_WORDS = 30;
    public static final boolean DEFAULT_READ_MSG_BODY = true;
    private String language;
    private int maxWords;
    private String msgFrom;
    private boolean msgReadBody;
    private String msgSubject;
    private SpeechRate speechRate;
    private String text;
    private Type type;
    private VoiceType voice;
    public static final VoiceType DEFAULT_VOICE = VoiceType.FEMALE;
    public static final SpeechRate DEFAULT_SPEECH_RATE = SpeechRate.NORMAL;
    public static final Type DEFAULT_TYPE = Type.PLAIN;

    public enum SpeechRate {
        VERY_SLOW,
        SLOW,
        NORMAL,
        FAST,
        VERY_FAST;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static SpeechRate[] valuesCustom() {
            SpeechRate[] speechRateArrValuesCustom = values();
            int length = speechRateArrValuesCustom.length;
            SpeechRate[] speechRateArr = new SpeechRate[length];
            System.arraycopy(speechRateArrValuesCustom, 0, speechRateArr, 0, length);
            return speechRateArr;
        }
    }

    public enum Type {
        PLAIN,
        EMAIL,
        SMS,
        MMS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Type[] valuesCustom() {
            Type[] typeArrValuesCustom = values();
            int length = typeArrValuesCustom.length;
            Type[] typeArr = new Type[length];
            System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
            return typeArr;
        }
    }

    public enum VoiceType {
        MALE,
        FEMALE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static VoiceType[] valuesCustom() {
            VoiceType[] voiceTypeArrValuesCustom = values();
            int length = voiceTypeArrValuesCustom.length;
            VoiceType[] voiceTypeArr = new VoiceType[length];
            System.arraycopy(voiceTypeArrValuesCustom, 0, voiceTypeArr, 0, length);
            return voiceTypeArr;
        }
    }

    public static class Builder {
        private String language = "en-US";
        private String text = "This is an example of vlingo TTS";
        private VoiceType voice = VLTextToSpeechRequest.DEFAULT_VOICE;
        private Type type = VLTextToSpeechRequest.DEFAULT_TYPE;
        private int maxWords = 30;
        private SpeechRate speechRate = VLTextToSpeechRequest.DEFAULT_SPEECH_RATE;
        private String msgFrom = null;
        private String msgSubject = null;
        private boolean msgReadBody = true;

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder voice(VoiceType voice) {
            this.voice = voice;
            return this;
        }

        public Builder type(Type type) {
            this.type = type;
            return this;
        }

        public Builder maxWords(int maxWords) {
            this.maxWords = maxWords;
            return this;
        }

        public Builder speechRate(SpeechRate rate) {
            this.speechRate = rate;
            return this;
        }

        public Builder msgSubject(String msgSubject) {
            this.msgSubject = msgSubject;
            return this;
        }

        public Builder msgReadyBody(boolean msgReadyBody) {
            this.msgReadBody = msgReadyBody;
            return this;
        }

        public VLTextToSpeechRequest build() {
            return new VLTextToSpeechRequest(this, null);
        }
    }

    private VLTextToSpeechRequest(Builder builder) {
        this.language = builder.language;
        this.text = builder.text;
        this.voice = builder.voice;
        this.type = builder.type;
        this.maxWords = builder.maxWords;
        this.speechRate = builder.speechRate;
        this.msgFrom = builder.msgFrom;
        this.msgSubject = builder.msgSubject;
        this.msgReadBody = builder.msgReadBody;
    }

    /* synthetic */ VLTextToSpeechRequest(Builder builder, VLTextToSpeechRequest vLTextToSpeechRequest) {
        this(builder);
    }

    public String getLanguage() {
        return this.language;
    }

    public String getText() {
        return this.text;
    }

    public VoiceType getVoice() {
        return this.voice;
    }

    public Type getType() {
        return this.type;
    }

    public int getMaxWords() {
        return this.maxWords;
    }

    public SpeechRate getSpeechRate() {
        return this.speechRate;
    }

    public String getMsgFrom() {
        return this.msgFrom;
    }

    public String getMsgSubject() {
        return this.msgSubject;
    }

    public boolean getMsgReadyBody() {
        return this.msgReadBody;
    }
}
