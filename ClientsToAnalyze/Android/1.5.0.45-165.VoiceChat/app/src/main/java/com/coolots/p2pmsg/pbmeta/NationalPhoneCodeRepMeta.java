package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.NationalPhoneCode;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.util.List;

/* loaded from: classes.dex */
public class NationalPhoneCodeRepMeta extends ProtoBufMetaBase {
    public NationalPhoneCodeRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.VERSION, 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalPhoneCodeSet", 2, true, List.class, NationalPhoneCode.class));
    }
}
