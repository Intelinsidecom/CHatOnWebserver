package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionDomainInfoMeta extends ProtoBufMetaBase {
    public RegionDomainInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Region", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("ImgDomain", 2, true, String.class));
    }
}
