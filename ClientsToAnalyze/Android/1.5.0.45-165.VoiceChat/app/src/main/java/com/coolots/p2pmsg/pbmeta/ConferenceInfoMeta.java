package com.coolots.p2pmsg.pbmeta;

import com.coolots.p2pmsg.model.SipProxyInfo;
import java.util.List;

/* loaded from: classes.dex */
public class ConferenceInfoMeta extends ProtoBufMetaBase {
    public ConferenceInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceNo", 1, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("DomainAddr", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ProxyAddr", 3, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("MCUPhoneNo", 4, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("PhoneNo", 5, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Password", 6, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("VideoConference", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("SipProxyInfoList", 8, false, List.class, SipProxyInfo.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ConferenceType", 9, true, String.class));
    }
}
