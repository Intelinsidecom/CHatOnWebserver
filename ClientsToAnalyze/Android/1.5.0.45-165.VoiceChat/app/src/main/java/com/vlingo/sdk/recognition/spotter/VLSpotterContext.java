package com.vlingo.sdk.recognition.spotter;

import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class VLSpotterContext {
    public static final String DEFAULT_LANGUAGE = "en-US";
    public static final float DEFAULT_PHRASESPOT_ABSBEAM = 40.0f;
    public static final float DEFAULT_PHRASESPOT_AOFFSET = 0.0f;
    public static final float DEFAULT_PHRASESPOT_BEAM = 20.0f;
    public static final float DEFAULT_PHRASESPOT_DELAY = 100.0f;
    public static final int DEFAULT_PHRASESPOT_PARAMA = 0;
    public static final int DEFAULT_PHRASESPOT_PARAMB = 320;
    public static final int DEFAULT_PHRASESPOT_PARAMC = 500;
    float absbeam;
    float aoffset;
    private AudioSourceInfo audioSourceInfo;
    float beam;
    float delay;
    GrammarSource grammarSource;
    private String language;

    public static final class GrammarSource {
        private String cgFile;
        private String grammarSpec;
        private String[] pronunciationList;
        private String[] wordList;

        private GrammarSource() {
        }

        public static GrammarSource getCompiledFileSource(String cgFile) {
            if (StringUtils.isNullOrWhiteSpace(cgFile)) {
                throw new IllegalArgumentException("cgFile cannot be null or empty");
            }
            GrammarSource gs = new GrammarSource();
            gs.cgFile = cgFile;
            return gs;
        }

        public static GrammarSource getGrammarSpecSource(String grammarSpec, String[] wordList, String[] pronunciationList) {
            if (StringUtils.isNullOrWhiteSpace(grammarSpec)) {
                throw new IllegalArgumentException("grammarSpec cannot be null or empty");
            }
            if (wordList == null || wordList.length == 0) {
                throw new IllegalArgumentException("wordList cannot be null and must have at least 1 element");
            }
            if (pronunciationList != null && pronunciationList.length != wordList.length) {
                throw new IllegalArgumentException("when not null, pronunciationList must contain the same number of elements as wordList");
            }
            GrammarSource gs = new GrammarSource();
            gs.grammarSpec = grammarSpec;
            gs.wordList = wordList;
            gs.pronunciationList = pronunciationList;
            return gs;
        }

        public static GrammarSource getGrammarSpecSource(String[] phraseList) {
            if (phraseList == null || phraseList.length == 0) {
                throw new IllegalArgumentException("phraseList cannot be null and must have at least 1 element");
            }
            GrammarSource gs = new GrammarSource();
            gs.grammarSpec = getGrammarSpec(phraseList);
            gs.wordList = getWordList(phraseList);
            return gs;
        }

        public boolean isCompiledFileSource() {
            return this.cgFile != null;
        }

        public boolean isGrammarSpecSource() {
            return this.grammarSpec != null;
        }

        public String getCompiledFilepath() {
            return this.cgFile;
        }

        public String getGrammarSpec() {
            return this.grammarSpec;
        }

        public String[] getWordList() {
            return this.wordList;
        }

        public String[] getPronunciationList() {
            return this.pronunciationList;
        }

        private static String getGrammarSpec(String[] phraseList) {
            StringBuilder sb = new StringBuilder("g=(");
            for (String phrase : phraseList) {
                sb.append(phrase);
                sb.append("|");
            }
            sb.setLength(sb.length() - 1);
            sb.append(");\nparamA:$g 0;\nparamB:$g 320;\nparamC:$g 500;\n");
            return sb.toString();
        }

        private static String[] getWordList(String[] phraseList) {
            ArrayList<String> wordList = new ArrayList<>();
            for (String str : phraseList) {
                String phrase = str.trim();
                if (phrase.length() > 0) {
                    String[] phraseWords = StringUtils.split(phrase, ' ');
                    for (String phraseWord : phraseWords) {
                        if (!wordList.contains(phrase)) {
                            wordList.add(phraseWord);
                        }
                    }
                }
            }
            String[] words = new String[wordList.size()];
            wordList.toArray(words);
            return words;
        }
    }

    public static class Builder {
        private GrammarSource grammarSource;
        private AudioSourceInfo audioSourceInfo = AudioSourceInfo.getDataBufferSource(AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT);
        private String language = "en-US";
        private float beam = 20.0f;
        private float absbeam = 40.0f;
        private float aoffset = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        private float delay = 100.0f;

        public Builder(GrammarSource grammarSource) {
            validateDefined(grammarSource);
            this.grammarSource = grammarSource;
        }

        public Builder audioSourceInfo(AudioSourceInfo info) {
            validateDefined(info);
            AudioSourceInfo.SourceType type = info.getType();
            if (type != AudioSourceInfo.SourceType.BUFFER) {
                throw new IllegalArgumentException("Unsupported audio source, supported formats are: SourceType.BUFFER");
            }
            AudioSourceInfo.SourceFormat format = info.getFormat();
            if (format != AudioSourceInfo.SourceFormat.PCM_16KHZ_16BIT) {
                throw new IllegalArgumentException("Unsupported audio format format, supported formats are: SourceFormat.PCM_16KHZ_16BIT");
            }
            this.audioSourceInfo = info;
            return this;
        }

        public Builder language(String language) {
            validateStringNotEmpty(language);
            this.language = language;
            return this;
        }

        public Builder spotterParams(float beam, float absbeam, float aoffset, float delay) {
            this.beam = beam;
            this.absbeam = absbeam;
            this.aoffset = aoffset;
            this.delay = delay;
            return this;
        }

        public VLSpotterContext build() {
            return new VLSpotterContext(this, null);
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

    private VLSpotterContext(Builder builder) {
        this.audioSourceInfo = builder.audioSourceInfo;
        this.language = builder.language;
        this.grammarSource = builder.grammarSource;
        this.beam = builder.beam;
        this.absbeam = builder.absbeam;
        this.aoffset = builder.aoffset;
        this.delay = builder.delay;
    }

    /* synthetic */ VLSpotterContext(Builder builder, VLSpotterContext vLSpotterContext) {
        this(builder);
    }

    public AudioSourceInfo getAudioSourceInfo() {
        return this.audioSourceInfo;
    }

    public String getLanguage() {
        return this.language;
    }

    public GrammarSource getGrammarSource() {
        return this.grammarSource;
    }

    public float getBeam() {
        return this.beam;
    }

    public float getAbsBeam() {
        return this.absbeam;
    }

    public float getAoffset() {
        return this.aoffset;
    }

    public float getDelay() {
        return this.delay;
    }
}
