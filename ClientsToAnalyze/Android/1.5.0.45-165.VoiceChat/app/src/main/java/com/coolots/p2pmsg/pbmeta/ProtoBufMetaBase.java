package com.coolots.p2pmsg.pbmeta;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ProtoBufMetaBase {
    protected transient List<ProtoBufFieldInfo> mProtoBufFields;

    public ProtoBufMetaBase() {
        this.mProtoBufFields = new ArrayList();
        if (this.mProtoBufFields == null) {
            this.mProtoBufFields = new ArrayList();
        }
    }

    public List<ProtoBufFieldInfo> getProtoBufFields() {
        return this.mProtoBufFields;
    }

    protected void addMetaFieldInfo(ProtoBufFieldInfo info) {
        this.mProtoBufFields.add(info);
    }
}
