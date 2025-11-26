package com.samsung.samm.common;

/* loaded from: classes.dex */
public class SOptionSCanvas {
    public SOptionPlay mPlayOption;
    public SOptionSAMM mSAMMOption;

    public SOptionSCanvas() {
        this.mPlayOption = null;
        this.mSAMMOption = null;
        this.mPlayOption = new SOptionPlay();
        this.mSAMMOption = new SOptionSAMM();
    }
}
