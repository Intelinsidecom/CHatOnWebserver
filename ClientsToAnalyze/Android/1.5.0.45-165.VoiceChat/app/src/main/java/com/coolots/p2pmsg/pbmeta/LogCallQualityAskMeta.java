package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class LogCallQualityAskMeta extends ProtoBufMetaBase {
    public LogCallQualityAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("CDRID", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 2, false, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("DeviceID", 3, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MCC", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MNC", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("OSType", 6, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NetworkType", 7, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SendReceive", 8, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioVideo", 9, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioPacketLossMin", 10, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioPacketLossAvg", 11, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioPacketLossMax", 12, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioJitterMin", 13, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioJitterAvg", 14, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioJitterMax", 15, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioDelayMin", 16, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioDelayAvg", 17, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AudioDelayMax", 18, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoPacketLossMin", 19, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoPacketLossAvg", 20, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoPacketLossMax", 21, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoJitterMin", 22, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoJitterAvg", 23, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoJitterMax", 24, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoDelayMin", 25, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoDelayAvg", 26, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoDelayMax", 27, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ResolutionWidth", 28, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ResolutionHeight", 29, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FPSMin", 30, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FPSAvg", 31, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("FPSMax", 32, false, Byte.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BitRateMin", 33, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BitRateAvg", 34, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BitRateMax", 35, false, Short.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MOS", 36, false, Float.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UseRelay", 37, false, Integer.TYPE));
    }
}
