package com.svox.classic;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class TTS {
    private static TTSBreakEvent mBreakListener;
    private static TTSLoadEvent mLoadListener;
    private static TTSPositionEvent mPosListener;
    private static TTSSpeechData mSpeechListener;
    private static TTSVisemeEvent mVisemeListener;
    private String mSystemPath;

    public enum TTSAge {
        Child,
        Teen,
        Adult,
        Senior,
        Undefined;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSAge[] valuesCustom() {
            TTSAge[] tTSAgeArrValuesCustom = values();
            int length = tTSAgeArrValuesCustom.length;
            TTSAge[] tTSAgeArr = new TTSAge[length];
            System.arraycopy(tTSAgeArrValuesCustom, 0, tTSAgeArr, 0, length);
            return tTSAgeArr;
        }
    }

    public interface TTSBreakEvent {
        void onBreak(TTSBreakType tTSBreakType, int i, int i2);
    }

    public enum TTSBreakType {
        Word,
        ExtData,
        Sentence;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSBreakType[] valuesCustom() {
            TTSBreakType[] tTSBreakTypeArrValuesCustom = values();
            int length = tTSBreakTypeArrValuesCustom.length;
            TTSBreakType[] tTSBreakTypeArr = new TTSBreakType[length];
            System.arraycopy(tTSBreakTypeArrValuesCustom, 0, tTSBreakTypeArr, 0, length);
            return tTSBreakTypeArr;
        }
    }

    public enum TTSGender {
        Female,
        Male,
        Undefined;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSGender[] valuesCustom() {
            TTSGender[] tTSGenderArrValuesCustom = values();
            int length = tTSGenderArrValuesCustom.length;
            TTSGender[] tTSGenderArr = new TTSGender[length];
            System.arraycopy(tTSGenderArrValuesCustom, 0, tTSGenderArr, 0, length);
            return tTSGenderArr;
        }
    }

    public interface TTSLoadEvent {
        void onLoadDone(long j);
    }

    public enum TTSMarkupMode {
        None,
        Default,
        NonCritical;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSMarkupMode[] valuesCustom() {
            TTSMarkupMode[] tTSMarkupModeArrValuesCustom = values();
            int length = tTSMarkupModeArrValuesCustom.length;
            TTSMarkupMode[] tTSMarkupModeArr = new TTSMarkupMode[length];
            System.arraycopy(tTSMarkupModeArrValuesCustom, 0, tTSMarkupModeArr, 0, length);
            return tTSMarkupModeArr;
        }
    }

    public enum TTSOutputType {
        Signal,
        SynthUnits;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSOutputType[] valuesCustom() {
            TTSOutputType[] tTSOutputTypeArrValuesCustom = values();
            int length = tTSOutputTypeArrValuesCustom.length;
            TTSOutputType[] tTSOutputTypeArr = new TTSOutputType[length];
            System.arraycopy(tTSOutputTypeArrValuesCustom, 0, tTSOutputTypeArr, 0, length);
            return tTSOutputTypeArr;
        }
    }

    public interface TTSPositionEvent {
        void onPositionMarker(String str);
    }

    public interface TTSSpeechData {
        void onSpeechData(short[] sArr);

        void onSpeechDone(int i);
    }

    public enum TTSSynthIntModifiers {
        Speed,
        Pitch,
        Volume,
        MarkupMode;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSSynthIntModifiers[] valuesCustom() {
            TTSSynthIntModifiers[] tTSSynthIntModifiersArrValuesCustom = values();
            int length = tTSSynthIntModifiersArrValuesCustom.length;
            TTSSynthIntModifiers[] tTSSynthIntModifiersArr = new TTSSynthIntModifiers[length];
            System.arraycopy(tTSSynthIntModifiersArrValuesCustom, 0, tTSSynthIntModifiersArr, 0, length);
            return tTSSynthIntModifiersArr;
        }
    }

    public enum TTSSynthStrModifiers {
        Voice,
        PreprocContext,
        ProsodyContext,
        Language;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static TTSSynthStrModifiers[] valuesCustom() {
            TTSSynthStrModifiers[] tTSSynthStrModifiersArrValuesCustom = values();
            int length = tTSSynthStrModifiersArrValuesCustom.length;
            TTSSynthStrModifiers[] tTSSynthStrModifiersArr = new TTSSynthStrModifiers[length];
            System.arraycopy(tTSSynthStrModifiersArrValuesCustom, 0, tTSSynthStrModifiersArr, 0, length);
            return tTSSynthStrModifiersArr;
        }
    }

    public interface TTSVisemeEvent {
        void onViseme(String str, int i, String str2, int i2, int i3);
    }

    private native void native_finalize();

    private final native int native_getOutputType(long j, long j2);

    private final native int native_getSynthModifInt(long j, long j2, int i);

    private final native String native_getSynthModifStr(long j, long j2, int i) throws RuntimeException;

    private final native int native_putSynthModifInt(long j, long j2, int i, int i2);

    private final native int native_putSynthModifStr(long j, long j2, int i, String str);

    private final native int native_setOutputType(long j, long j2, int i);

    private native int native_setup(Object obj, String str);

    private final native void setBreakListener(boolean z);

    private final native void setPosListener(boolean z);

    private final native void setVisemeListener(boolean z);

    public final native int abort(long j, long j2);

    public final native int checkConfiguration(String str);

    public final native int closeChannel(long j, long j2) throws RuntimeException;

    public final native int closeEngine(long j);

    public final native TTSDetectedLanguage[] detectLanguage(long j, String str);

    public final native String findConfigurationMainFile(String str) throws RuntimeException;

    public final native String findLingwareFile(String str, String str2) throws RuntimeException;

    public final native boolean getAbortionState(long j, long j2);

    public final native String[] getContextNames(long j, String str) throws RuntimeException;

    public final native String[] getDetectableLanguageInfo() throws RuntimeException;

    public final native String getEngineStatusMessage(long j) throws RuntimeException;

    public final native TTSWarning[] getEngineWarnings(long j) throws RuntimeException;

    public final native boolean getFastG2PMode(long j, long j2) throws RuntimeException;

    public final native TTSLingwareInfo getLingwareInfo(String str) throws RuntimeException;

    public final native TTSVoiceInfo[] getLingwareVoiceInfo(String str) throws RuntimeException;

    public final native String getOutputFile(long j, long j2) throws RuntimeException;

    public final native String[] getPhonAlphabetsInfo(int i) throws RuntimeException;

    public final native TTSSystemInfo getSystemInfo() throws RuntimeException;

    public final native String getSystemStatusMessage() throws RuntimeException;

    public final native TTSWarning[] getSystemWarnings() throws RuntimeException;

    public native TTSConfigurationInfo getVoiceConfigurationInfo(String str) throws RuntimeException;

    public native String[] getVoiceConfigurationNames() throws RuntimeException;

    public final native TTSVoiceInfo[] getVoicesInfo() throws RuntimeException;

    public final native long loadConfiguration(String str) throws RuntimeException;

    public native long loadLingware(String str, String str2) throws RuntimeException;

    public final native long newChannel(long j, String str) throws RuntimeException;

    public final native long newEngine(String str) throws RuntimeException;

    public final native int putPosMarker(long j, long j2, String str);

    public final native int resetAbort(long j, long j2);

    public final native int resetBreakCounts(long j, long j2);

    public final native int setFastG2PMode(long j, long j2, boolean z);

    public final native int setOutputFile(long j, long j2, String str);

    public final native int setVisemeAlphabet(long j, long j2, String str) throws RuntimeException;

    public final native int synthFinish(long j, long j2);

    public final native int synthItemFile(long j, long j2, String str);

    public final native int synthStr(long j, long j2, String str);

    public final native int synthString(long j, long j2, String str);

    public final native int synthTextFile(long j, long j2, String str);

    public final native int unloadConfiguration(long j);

    public final native int unloadLingware(long j);

    public class TTSWarning {
        private int mWarningCode;
        private String mWarningMessage;

        public TTSWarning(int code, String message) {
            this.mWarningCode = code;
            this.mWarningMessage = message;
        }

        public int code() {
            return this.mWarningCode;
        }

        public String message() {
            return this.mWarningMessage;
        }
    }

    public class TTSSystemInfo {
        private String mPlatform;
        private int mSystemID;
        private String mVersion;
        private int mVersionMajor;
        private int mVersionMinor;
        private int mVersionRevision;
        private String mVersionSubrevision;

        public TTSSystemInfo(String platform, int major, int minor, int revision, String subrevision, int systemID) {
            this.mPlatform = platform;
            this.mVersionMajor = major;
            this.mVersionMinor = minor;
            this.mVersionRevision = revision;
            this.mVersionSubrevision = subrevision;
            this.mSystemID = systemID;
            this.mVersion = String.valueOf(Integer.toString(this.mVersionMajor)) + "." + Integer.toString(this.mVersionMinor) + "." + Integer.toString(this.mVersionRevision) + "." + this.mVersionSubrevision;
        }

        public String platform() {
            return this.mPlatform;
        }

        public String version() {
            return this.mVersion;
        }

        public int system_id() {
            return this.mSystemID;
        }

        public int version_major() {
            return this.mVersionMajor;
        }

        public int version_minor() {
            return this.mVersionMinor;
        }

        public int version_revision() {
            return this.mVersionRevision;
        }

        public String version_subrevision() {
            return this.mVersionSubrevision;
        }
    }

    public class TTSLingwareInfo {
        private int mLingwareID;
        private int mNumVoices;
        private String mPlatform;
        private String mVersion;
        private int mVersionMajor;
        private int mVersionMinor;
        private int mVersionRevision;
        private String mVersionSubrevision;

        public TTSLingwareInfo(String platform, int major, int minor, int revision, String subrevision, int lingwareID, int numberOfVoices) {
            this.mPlatform = platform;
            this.mVersionMajor = major;
            this.mVersionMinor = minor;
            this.mVersionRevision = revision;
            this.mVersionSubrevision = subrevision;
            this.mLingwareID = lingwareID;
            this.mNumVoices = numberOfVoices;
            this.mVersion = String.valueOf(Integer.toString(this.mVersionMajor)) + "." + Integer.toString(this.mVersionMinor) + "." + Integer.toString(this.mVersionRevision) + "." + this.mVersionSubrevision;
        }

        public String platform() {
            return this.mPlatform;
        }

        public String version() {
            return this.mVersion;
        }

        public int lingware_id() {
            return this.mLingwareID;
        }

        public int numberOfVoices() {
            return this.mNumVoices;
        }

        public int version_major() {
            return this.mVersionMajor;
        }

        public int version_minor() {
            return this.mVersionMinor;
        }

        public int version_revision() {
            return this.mVersionRevision;
        }

        public String version_subrevision() {
            return this.mVersionSubrevision;
        }
    }

    public class TTSVoiceInfo {
        private TTSAge mAge;
        private TTSGender mGender;
        private String mLanguage;
        private boolean mLicensed;
        private String mName;
        private int mSampleRate;

        public TTSVoiceInfo(String name, String language, int gender, int age, int sampleRate, boolean isLicensed) {
            this.mName = name;
            this.mLanguage = language;
            this.mSampleRate = sampleRate;
            this.mGender = TTSGender.valuesCustom()[gender];
            this.mAge = TTSAge.valuesCustom()[age];
            this.mLicensed = isLicensed;
        }

        public String name() {
            return this.mName;
        }

        public String language() {
            return this.mLanguage;
        }

        public TTSGender gender() {
            return this.mGender;
        }

        public TTSAge age() {
            return this.mAge;
        }

        public int sampleRate() {
            return this.mSampleRate;
        }

        public boolean isLicensed() {
            return this.mLicensed;
        }
    }

    public class TTSConfigurationInfo {
        private TTSAge mAge;
        private int mCompression;
        private TTSGender mGender;
        private String mLanguage;
        private boolean mLicensed;
        private String mProduct;
        private int mSampleRate;

        public TTSConfigurationInfo(String language, int gender, int age, int sampleRate, boolean licensed, String productType, int compressionType) {
            this.mLanguage = language;
            this.mSampleRate = sampleRate;
            this.mLicensed = licensed;
            this.mGender = TTSGender.valuesCustom()[gender];
            this.mAge = TTSAge.valuesCustom()[age];
            this.mProduct = productType;
            this.mCompression = compressionType;
        }

        public String language() {
            return this.mLanguage;
        }

        public TTSGender gender() {
            return this.mGender;
        }

        public TTSAge age() {
            return this.mAge;
        }

        public int sampleRate() {
            return this.mSampleRate;
        }

        public boolean isLicensed() {
            return this.mLicensed;
        }

        public String productType() {
            return this.mProduct;
        }

        public int compressionType() {
            return this.mCompression;
        }
    }

    public class TTSDetectedLanguage {
        private String mLanguage;
        private int mProbability;

        public TTSDetectedLanguage(String language, int probability) {
            this.mLanguage = language;
            this.mProbability = probability;
        }

        public String language() {
            return this.mLanguage;
        }

        public int probability() {
            return this.mProbability;
        }
    }

    public TTS(String systemPath, TTSSpeechData speechListener) throws RuntimeException {
        if (systemPath.endsWith("/")) {
            this.mSystemPath = systemPath;
        } else {
            this.mSystemPath = String.valueOf(systemPath) + "/";
        }
        mSpeechListener = speechListener;
        mLoadListener = null;
        mPosListener = null;
        mVisemeListener = null;
        mBreakListener = null;
        int res = native_setup(new WeakReference(this), this.mSystemPath);
        if (res != 0) {
            throw new RuntimeException("Failed to initialize SVOX system. Error code: " + Integer.toString(res));
        }
    }

    public void setLoadEventListener(TTSLoadEvent loadListener) {
        mLoadListener = loadListener;
    }

    public void setPositionMarkerListener(TTSPositionEvent posListener) {
        mPosListener = posListener;
        if (mPosListener != null) {
            setPosListener(true);
        } else {
            setPosListener(false);
        }
    }

    public void setVisemeEventListener(TTSVisemeEvent visemeListener) {
        mVisemeListener = visemeListener;
        if (mVisemeListener != null) {
            setVisemeListener(true);
        } else {
            setPosListener(false);
        }
    }

    public void setBreakEventListener(TTSBreakEvent breakListener) {
        mBreakListener = breakListener;
        if (mBreakListener != null) {
            setBreakListener(true);
        } else {
            setBreakListener(false);
        }
    }

    private static void receiveSpeechData(short[] samples) {
        mSpeechListener.onSpeechData(samples);
    }

    private static void receivePosMarker(String name) {
        if (mPosListener != null) {
            mPosListener.onPositionMarker(name);
        }
    }

    private static void receiveViseme(String prevViseme, int prevLength, String nextViseme, int estinatedNextLength, int samplingRate) {
        if (mVisemeListener != null) {
            mVisemeListener.onViseme(prevViseme, prevLength, nextViseme, estinatedNextLength, samplingRate);
        }
    }

    private static void receiveBreak(int type, int breakCount, int textPosition) {
        if (mBreakListener != null) {
            mBreakListener.onBreak(TTSBreakType.valuesCustom()[type], breakCount, textPosition);
        }
    }

    public void loadLingwareAsync(final String lingwarePath, final String lingwareFileName) throws RuntimeException {
        new Thread(new Runnable() { // from class: com.svox.classic.TTS.1
            @Override // java.lang.Runnable
            public void run() throws RuntimeException {
                long handle = TTS.this.loadLingware(lingwarePath, lingwareFileName);
                if (TTS.mLoadListener != null) {
                    TTS.mLoadListener.onLoadDone(handle);
                }
            }
        }).start();
    }

    public void loadConfigurationAsync(final String configurationName) throws RuntimeException {
        new Thread(new Runnable() { // from class: com.svox.classic.TTS.2
            @Override // java.lang.Runnable
            public void run() throws RuntimeException {
                long handle = TTS.this.loadConfiguration(configurationName);
                if (TTS.mLoadListener != null) {
                    TTS.mLoadListener.onLoadDone(handle);
                }
            }
        }).start();
    }

    public void synthStringAsync(final long engineHandle, final long channelHandle, final String textToSpeak) {
        new Thread(new Runnable() { // from class: com.svox.classic.TTS.3
            @Override // java.lang.Runnable
            public void run() {
                int result = TTS.this.synthString(engineHandle, channelHandle, textToSpeak);
                if (TTS.mSpeechListener != null) {
                    TTS.mSpeechListener.onSpeechDone(result);
                }
            }
        }).start();
    }

    public int setOutputType(long engine, long channel, TTSOutputType outputType) {
        return native_setOutputType(engine, channel, outputType.ordinal());
    }

    public TTSOutputType getOutputType(long engine, long channel) throws RuntimeException {
        int type = native_getOutputType(engine, channel);
        if (type < 0) {
            throw new RuntimeException("Error in native getOutputType call : " + Integer.toString(type));
        }
        return TTSOutputType.valuesCustom()[type];
    }

    public int putSynthModifInt(long engine, long channel, TTSSynthIntModifiers modifId, int modifVal) {
        return native_putSynthModifInt(engine, channel, modifId.ordinal(), modifVal);
    }

    public int putSynthModifStr(long engine, long channel, TTSSynthStrModifiers modifId, String modifVal) {
        return native_putSynthModifStr(engine, channel, modifId.ordinal(), modifVal);
    }

    public int getSynthModifInt(long engine, long channel, TTSSynthIntModifiers modifId) throws RuntimeException {
        int value = native_getSynthModifInt(engine, channel, modifId.ordinal());
        if (value < 0) {
            throw new RuntimeException("Error in native call : " + Integer.toString(value));
        }
        return value;
    }

    public String getSynthModifStr(long engine, long channel, TTSSynthStrModifiers modifId) throws RuntimeException {
        return native_getSynthModifStr(engine, channel, modifId.ordinal());
    }

    protected void finalize() {
        native_finalize();
    }

    static {
        System.loadLibrary("svoxtts");
    }
}
