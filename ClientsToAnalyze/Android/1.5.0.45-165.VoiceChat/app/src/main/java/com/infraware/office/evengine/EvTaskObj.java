package com.infraware.office.evengine;

/* loaded from: classes.dex */
abstract class EvTaskObj {
    protected EvNative Native;

    abstract void doTask();

    EvTaskObj(EvNative a_Native) {
        this.Native = a_Native;
    }
}
