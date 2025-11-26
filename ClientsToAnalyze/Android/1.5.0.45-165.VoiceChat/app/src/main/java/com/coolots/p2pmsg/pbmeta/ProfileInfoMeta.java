package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ProfileInfoMeta extends ProtoBufMetaBase {
    public ProfileInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Comment", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNoList", 6, true, List.class, PhoneNoInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Region", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProfileUpdateDate", 8, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProfileImgUpdateDate", 9, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoCallImgUpdateDate", 10, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ExcludeMe", 11, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddySuggestion", 12, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ShowCamOnRecv", 13, true, String.class));
    }
}
