package com.vlingo.sdk.internal.recognizer;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.net.ConnectionManager;
import com.vlingo.sdk.recognition.AudioSourceInfo;
import com.vlingo.sdk.recognition.VLRecognitionContext;
import com.vlingo.sdk.recognition.dialog.VLDialogEvent;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class SRContext {

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$recognition$VLRecognitionContext$CapitalizationMode */
    private static /* synthetic */ int[] f3253x8765d6bd;
    private static final Logger log = Logger.getLogger(SRContext.class);
    protected volatile AudioSourceInfo audioSourceInfo;
    protected volatile boolean autoEndpointing;
    protected volatile boolean autoPunctuation;
    protected volatile VLRecognitionContext.CapitalizationMode capitalizationMode;
    protected volatile String curText;
    protected volatile int cursorPos;
    protected volatile String custom6;
    public volatile boolean customFlag;
    protected volatile String dialogGUID;
    protected volatile byte[] dialogState;
    protected volatile int dialogTurnNumber;
    protected volatile HashMap<String, String> dmHeaderKVPairs;
    protected volatile List<VLDialogEvent> eventList;
    protected volatile String fieldContext;
    protected volatile String fieldID;
    protected volatile String fieldType;
    protected volatile boolean isDMRequest;
    protected volatile int maxAudioTime;
    protected volatile float minVoiceDuration;
    protected volatile float minVoiceLevel;
    protected volatile int noSpeechEndpointTimeout;
    protected volatile boolean profanityFilter;
    protected volatile float silenceThreshold;
    protected volatile int speechEndpointTimeout;
    protected volatile int speexComplexity;
    protected volatile int speexQuality;
    protected volatile int speexVariableBitrate;
    protected volatile int speexVoiceActivityDetection;
    protected volatile String username;
    protected volatile float voicePortion;

    /* renamed from: $SWITCH_TABLE$com$vlingo$sdk$recognition$VLRecognitionContext$CapitalizationMode */
    static /* synthetic */ int[] m3095x8765d6bd() {
        int[] iArr = f3253x8765d6bd;
        if (iArr == null) {
            iArr = new int[VLRecognitionContext.CapitalizationMode.valuesCustom().length];
            try {
                iArr[VLRecognitionContext.CapitalizationMode.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VLRecognitionContext.CapitalizationMode.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VLRecognitionContext.CapitalizationMode.PROPER_NOUN.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VLRecognitionContext.CapitalizationMode.SENTENCES.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            f3253x8765d6bd = iArr;
        }
        return iArr;
    }

    public SRContext() {
        this.fieldID = null;
        this.fieldType = null;
        this.curText = null;
        this.fieldContext = null;
        this.cursorPos = 0;
        this.autoPunctuation = false;
        this.capitalizationMode = VLRecognitionContext.CapitalizationMode.DEFAULT;
        this.maxAudioTime = VLRecognitionContext.MAX_AUDIO_TIME;
        this.autoEndpointing = true;
        this.speechEndpointTimeout = VLRecognitionContext.DEFAULT_SPEECH_ENDPOINT_TIMEOUT_MS;
        this.noSpeechEndpointTimeout = 5000;
        this.silenceThreshold = 11.0f;
        this.minVoiceDuration = 0.08f;
        this.voicePortion = 0.02f;
        this.minVoiceLevel = 57.0f;
        this.speexComplexity = 0;
        this.speexQuality = 7;
        this.speexVariableBitrate = 1;
        this.speexVoiceActivityDetection = 0;
        this.profanityFilter = true;
        this.customFlag = false;
        this.custom6 = null;
        this.dialogState = null;
        this.eventList = null;
        this.isDMRequest = false;
        this.username = null;
        this.dialogGUID = null;
        this.dialogTurnNumber = -1;
    }

    public SRContext(String fieldID) {
        this.fieldID = null;
        this.fieldType = null;
        this.curText = null;
        this.fieldContext = null;
        this.cursorPos = 0;
        this.autoPunctuation = false;
        this.capitalizationMode = VLRecognitionContext.CapitalizationMode.DEFAULT;
        this.maxAudioTime = VLRecognitionContext.MAX_AUDIO_TIME;
        this.autoEndpointing = true;
        this.speechEndpointTimeout = VLRecognitionContext.DEFAULT_SPEECH_ENDPOINT_TIMEOUT_MS;
        this.noSpeechEndpointTimeout = 5000;
        this.silenceThreshold = 11.0f;
        this.minVoiceDuration = 0.08f;
        this.voicePortion = 0.02f;
        this.minVoiceLevel = 57.0f;
        this.speexComplexity = 0;
        this.speexQuality = 7;
        this.speexVariableBitrate = 1;
        this.speexVoiceActivityDetection = 0;
        this.profanityFilter = true;
        this.customFlag = false;
        this.custom6 = null;
        this.dialogState = null;
        this.eventList = null;
        this.isDMRequest = false;
        this.username = null;
        this.dialogGUID = null;
        this.dialogTurnNumber = -1;
        this.fieldID = fieldID;
    }

    public SRContext(String fieldID, String fieldType, String fieldContext, String curText, int cursorPos) {
        this.fieldID = null;
        this.fieldType = null;
        this.curText = null;
        this.fieldContext = null;
        this.cursorPos = 0;
        this.autoPunctuation = false;
        this.capitalizationMode = VLRecognitionContext.CapitalizationMode.DEFAULT;
        this.maxAudioTime = VLRecognitionContext.MAX_AUDIO_TIME;
        this.autoEndpointing = true;
        this.speechEndpointTimeout = VLRecognitionContext.DEFAULT_SPEECH_ENDPOINT_TIMEOUT_MS;
        this.noSpeechEndpointTimeout = 5000;
        this.silenceThreshold = 11.0f;
        this.minVoiceDuration = 0.08f;
        this.voicePortion = 0.02f;
        this.minVoiceLevel = 57.0f;
        this.speexComplexity = 0;
        this.speexQuality = 7;
        this.speexVariableBitrate = 1;
        this.speexVoiceActivityDetection = 0;
        this.profanityFilter = true;
        this.customFlag = false;
        this.custom6 = null;
        this.dialogState = null;
        this.eventList = null;
        this.isDMRequest = false;
        this.username = null;
        this.dialogGUID = null;
        this.dialogTurnNumber = -1;
        this.fieldID = fieldID;
        this.fieldType = fieldType;
        this.fieldContext = fieldContext;
        this.curText = curText;
        this.cursorPos = cursorPos;
    }

    public String getFieldID() {
        return this.fieldID;
    }

    public String getFieldType() {
        String fType;
        if (getProfanityFilter()) {
            fType = String.valueOf("<xml><taboofilter>") + "on";
        } else {
            fType = String.valueOf("<xml><taboofilter>") + "off";
        }
        return String.valueOf(fType) + "</taboofilter></xml>";
    }

    public String getFieldContext() {
        return this.fieldContext == null ? "" : this.fieldContext;
    }

    public String getCurrentText() {
        return this.curText == null ? "" : this.curText.trim();
    }

    public String getCursorPosition() {
        return this.curText == null ? "0" : new StringBuilder().append(this.cursorPos).toString();
    }

    public int getCursorPositionInt() {
        return this.cursorPos;
    }

    public boolean getAutoPunctuation() {
        return this.autoPunctuation;
    }

    public String getCapitalization() {
        switch (m3095x8765d6bd()[this.capitalizationMode.ordinal()]) {
            case 1:
                return "Off";
            case 2:
            default:
                return "Default";
            case 3:
                return "Sentences";
            case 4:
                return "ProperNoun";
        }
    }

    public int getMaxAudioTime() {
        return this.maxAudioTime;
    }

    public boolean getAutoEndpointing() {
        return this.autoEndpointing;
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

    public int getSpeexComplexity() {
        return this.speexComplexity;
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

    public int getSpeechEndpointTimeout() {
        return this.speechEndpointTimeout;
    }

    public int getNoSpeechEndpointTimeout() {
        return this.noSpeechEndpointTimeout;
    }

    public boolean getProfanityFilter() {
        return this.profanityFilter;
    }

    public void logNetworkInfo() {
        String result = "";
        ConnectionManager cm = ConnectionManager.getInstance();
        if (cm.getNetworkInfo() != null) {
            result = String.valueOf("") + "ConnType=" + cm.getNetworkInfo().getTypeName();
        }
        if (cm.getNetworkInfo() != null && cm.getNetworkInfo().getTypeName().equalsIgnoreCase("wifi")) {
            result = String.valueOf(result) + ",WifiLinkSpd=" + cm.getWifiLinkSpeed();
        }
        if (cm.getNetworkInfo() != null && cm.getNetworkInfo().getTypeName().equalsIgnoreCase("wifi")) {
            result = String.valueOf(result) + ",WifiSignalStrength=" + cm.getWifiSignalStrength();
        }
        if (cm.getNetworkInfo() != null && !cm.getNetworkInfo().getTypeName().equalsIgnoreCase("wifi")) {
            result = String.valueOf(String.valueOf(String.valueOf(String.valueOf(result) + ",NetworkType=" + cm.getNetworkTypeName()) + ",CdmaSigLev=" + cm.getCdmaSignal()) + ",EvdoSigLev=" + cm.getEvdoSignal()) + ",GsmSigLev=" + cm.getGsmSignal();
        }
        log.debug(result);
    }

    public String getCustomParam(String name) {
        String result = "";
        ConnectionManager cm = ConnectionManager.getInstance();
        if ("Custom1".equals(name) && cm.getNetworkInfo() != null) {
            result = "ConnType=" + cm.getNetworkInfo().getTypeName();
        }
        if ("Custom2".equals(name) && cm.getNetworkInfo() != null && cm.getNetworkInfo().getTypeName().equalsIgnoreCase("wifi")) {
            result = "WifiLinkSpd=" + cm.getWifiLinkSpeed();
        }
        if (cm.getNetworkInfo() != null && !cm.getNetworkInfo().getTypeName().equalsIgnoreCase("wifi")) {
            if ("Custom3".equals(name)) {
                result = "NetworkType=" + cm.getNetworkTypeName();
            }
            if ("Custom4".equals(name)) {
                result = "CdmaSigLev=" + cm.getCdmaSignal();
            }
            if ("Custom5".equals(name)) {
                result = "EvdoSigLev=" + cm.getEvdoSignal();
            }
            if ("Custom6".equals(name)) {
                return "GsmSigLev=" + cm.getGsmSignal();
            }
            return result;
        }
        return result;
    }

    public boolean isDMRequest() {
        return this.isDMRequest;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDialogGUID() {
        return this.dialogGUID;
    }

    public int getDialogTurnNumber() {
        return this.dialogTurnNumber;
    }

    public HashMap<String, String> getDMHeaderKVPairs() {
        return this.dmHeaderKVPairs;
    }

    public byte[] getDialogState() {
        return this.dialogState;
    }

    public List<VLDialogEvent> getEvents() {
        return this.eventList;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public void setCurText(String curText) {
        this.curText = curText;
    }

    public void setFieldContext(String fieldContext) {
        this.fieldContext = fieldContext;
    }

    public void setCursorPos(int cursorPos) {
        this.cursorPos = cursorPos;
    }

    public void setAutoPunctuation(boolean state) {
        this.autoPunctuation = state;
    }

    public void setCapitalizationMode(VLRecognitionContext.CapitalizationMode mode) {
        this.capitalizationMode = mode;
    }

    public void setMaxAudioTime(int time) {
        this.maxAudioTime = time;
    }

    public void setAutoEndpointing(boolean enabled) {
        this.autoEndpointing = enabled;
    }

    public void setSilenceDetectionParams(float silenceThreshold, float minVoiceDuration, float voicePortion, float minVoiceLevel) {
        this.silenceThreshold = silenceThreshold;
        this.minVoiceDuration = minVoiceDuration;
        this.voicePortion = voicePortion;
        this.minVoiceLevel = minVoiceLevel;
    }

    public void setSpeexParams(int speexComplexity, int speexQuality, int speexVariableBitrate, int speexVoiceActivityDetection) {
        this.speexComplexity = speexComplexity;
        this.speexQuality = speexQuality;
        this.speexVariableBitrate = speexVariableBitrate;
        this.speexVoiceActivityDetection = speexVoiceActivityDetection;
    }

    public void setSpeechEndpointTimeout(int ms) {
        this.speechEndpointTimeout = ms;
    }

    public void setNoSpeechEndpointTimeout(int ms) {
        this.noSpeechEndpointTimeout = ms;
    }

    public void setAudioSourceInfo(AudioSourceInfo info) {
        this.audioSourceInfo = info;
    }

    public void setProfanityFilter(boolean state) {
        this.profanityFilter = state;
    }

    public String getCustom6() {
        return this.custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public void setIsDMRequest(boolean state) {
        this.isDMRequest = state;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public void setDialogGUID(String guid) {
        this.dialogGUID = guid;
    }

    public void setDialogTurnNumber(int turn) {
        this.dialogTurnNumber = turn;
    }

    public void setDMHeaderKVPairs(HashMap<String, String> dmHeaderKVPairs) {
        this.dmHeaderKVPairs = dmHeaderKVPairs;
    }

    public void setDialogState(byte[] data) {
        this.dialogState = data;
    }

    public void setEvents(List<VLDialogEvent> eventList) {
        this.eventList = eventList;
    }
}
