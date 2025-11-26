package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class CallMediaSettingRepMeta extends ProtoBufMetaBase {
    public CallMediaSettingRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("VoiceCodec", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PlaceCallCam", 2, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReceiveCallCam", 3, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("FrontFrameSize", 4, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("BackFrameSize", 5, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("FrameRate", 6, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("BandWidth", 7, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Qfactor", 8, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NoiseSuppression", 9, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("AecMode", 10, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Vad", 11, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Fec", 12, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioRecordBuf", 13, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioTrackBuf", 14, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioSampleRate", 15, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioDelay", 16, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SpeakerModeMicGain", 17, true, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SpeakerModeAgc", 18, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SpeakerModeMicGainAfterAec", 19, true, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SpeakerModeMicVolume", 20, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("SpeakerModeAudioVolume", 21, true, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NormalModeMicGain", 22, true, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NormalModeAgc", 23, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NormalModeMicGainAfterAec", 24, true, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NormalModeMicVolume", 25, true, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("NormalModeAudioVolume", 26, true, Float.TYPE));
    }
}
