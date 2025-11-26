package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.ChatOnACSLang;
import java.util.List;

/* loaded from: classes.dex */
public class ChatOnACSLangRepMeta extends ProtoBufMetaBase {
    public ChatOnACSLangRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ChatOnACSLangList", 1, true, List.class, ChatOnACSLang.class));
    }
}
