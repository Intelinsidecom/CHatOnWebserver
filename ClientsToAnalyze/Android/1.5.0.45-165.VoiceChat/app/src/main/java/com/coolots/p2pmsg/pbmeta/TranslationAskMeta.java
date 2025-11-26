package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class TranslationAskMeta extends ProtoBufMetaBase {
    public TranslationAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ID", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VoiceLanguage", 3, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RecognitionLanguage", 4, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RecognizedText", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("TranslatedText", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IsTranslationStart", 7, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalFlag", 8, false, Integer.class));
    }
}
