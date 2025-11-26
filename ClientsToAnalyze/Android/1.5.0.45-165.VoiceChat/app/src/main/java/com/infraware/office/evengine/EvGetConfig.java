package com.infraware.office.evengine;

import com.infraware.office.evengine.C0508EV;

/* compiled from: EvTaskObj.java */
/* loaded from: classes.dex */
class EvGetConfig extends EvTaskObj {
    private C0508EV.CONFIG_INFO m_ConfigInfo;

    EvGetConfig(EvNative a_Native, C0508EV.CONFIG_INFO a_ConfigInfo) {
        super(a_Native);
        this.m_ConfigInfo = a_ConfigInfo;
    }

    @Override // com.infraware.office.evengine.EvTaskObj
    void doTask() {
        this.Native.IGetConfig(this.m_ConfigInfo);
    }
}
