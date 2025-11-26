package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class RegionInfoIPRepMeta extends ProtoBufMetaBase {
    public RegionInfoIPRepMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Region", 1, true, Short.TYPE));
        addMetaFieldInfo(new ProtoBufFieldInfo("Domain", 2, true, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("IP", 3, true, String.class));
    }
}
