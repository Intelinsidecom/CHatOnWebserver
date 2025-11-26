package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RecognitionAskMeta extends ProtoBufMetaBase {
    public RecognitionAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ID", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VoiceLanguage", 3, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RecognitionLanguage", 4, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RecognizedText", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsRecognitionStart", 6, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalFlag", 7, false, Integer.class));
    }
}
