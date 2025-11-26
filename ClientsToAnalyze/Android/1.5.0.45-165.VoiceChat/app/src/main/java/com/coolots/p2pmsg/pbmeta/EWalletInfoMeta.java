package com.coolots.p2pmsg.pbmeta;

/* loaded from: classes.dex */
public class EWalletInfoMeta extends ProtoBufMetaBase {
    public EWalletInfoMeta() {
        addMetaFieldInfo(new ProtoBufFieldInfo("Type", 1, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Currency", 2, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Amount", 3, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("Country", 4, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("ServiceType", 5, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CurSymbol", 6, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CurLow", 7, false, String.class));
        addMetaFieldInfo(new ProtoBufFieldInfo("CurHigh", 8, false, String.class));
    }
}
