package com.coolots.p2pmsg.pbmeta;

import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.util.Date;

/* loaded from: classes.dex */
public class MemberDumpMeta extends ProtoBufMetaBase {
    public MemberDumpMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("UserNo", 1, true, Long.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserID", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Passwd", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CountryCode", 4, false, Integer.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo(TTSRequestParams.TYPE_EMAIL, 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("UserName", 7, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NickName", 8, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("NationalCode", 9, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SearchableYn", 10, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SvcStatus", 11, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ReasonCd", 12, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AutoChargeYn", 13, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("GroupCode", 14, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("AutoChargeProductId", 15, false, Integer.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("RefundYn", 16, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MailReceiveYn", 17, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("InsertDate", 18, true, Date.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CloseReason", 19, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Parent", 20, false, Long.class));
    }
}
