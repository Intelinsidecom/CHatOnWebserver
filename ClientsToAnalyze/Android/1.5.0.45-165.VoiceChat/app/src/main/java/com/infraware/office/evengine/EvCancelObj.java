package com.infraware.office.evengine;

/* compiled from: EvTaskObj.java */
/* loaded from: classes.dex */
class EvCancelObj extends EvTaskObj {
    EvCancelObj(EvNative a_Native) {
        super(a_Native);
    }

    @Override // com.infraware.office.evengine.EvTaskObj
    void doTask() {
        this.Native.ICancel();
    }
}
