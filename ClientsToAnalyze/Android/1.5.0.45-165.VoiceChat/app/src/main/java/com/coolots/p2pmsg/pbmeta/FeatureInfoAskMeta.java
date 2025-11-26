package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class FeatureInfoAskMeta extends ProtoBufMetaBase {
    public FeatureInfoAskMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("appVersion", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("deviceModelName", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pVoiceCall", 3, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pVideoCall", 4, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pVoiceToVideoCallSwitching", 5, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pVideoToVoiceCallSwitching", 6, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pShareScreen", 7, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pShareCamera", 8, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pHandwritingInShareScreen", 9, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pHandwritingInDocView", 10, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pShareRemoteControl", 11, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pShareDocView", 12, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("p2pTranslation", 13, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confVoiceCall", 14, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confVideoCall", 15, false, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confVoiceToVideoCallSwitching", 16, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confVideoToVoiceCallSwitching", 17, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confShareScreen", 18, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confShareCamera", 19, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confHandwritingInShareScreen", 20, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confHandwritingInDocView", 21, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confShareRemoteControl", 22, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confShareDocView", 23, true, Boolean.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("confTranslation", 24, true, Boolean.class));
    }
}
