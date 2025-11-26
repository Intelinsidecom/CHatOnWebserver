package com.infraware.office.evengine;

/* compiled from: EvTaskObj.java */
/* loaded from: classes.dex */
class EvCloseObj extends EvTaskObj {
    EvCloseObj(EvNative a_Native) {
        super(a_Native);
    }

    @Override // com.infraware.office.evengine.EvTaskObj
    void doTask() {
        this.Native.IClose();
    }
}
