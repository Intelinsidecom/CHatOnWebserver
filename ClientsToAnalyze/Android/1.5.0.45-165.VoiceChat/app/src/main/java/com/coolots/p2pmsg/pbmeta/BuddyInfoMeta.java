package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.PhoneNoInfo;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class BuddyInfoMeta extends ProtoBufMetaBase {
    public BuddyInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Comment", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("EditedUserName", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNoList", 7, true, List.class, PhoneNoInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MainPhoneNo", 8, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("BuddyCode", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Favorite", 10, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Block", 11, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Hide", 12, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Delete", 13, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Status", 14, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Region", 15, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProfileImgUpdateDate", 16, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UpdateDate", 17, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ExcludeMe", 18, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SamsungAccountID", 19, true, String.class));
    }
}
