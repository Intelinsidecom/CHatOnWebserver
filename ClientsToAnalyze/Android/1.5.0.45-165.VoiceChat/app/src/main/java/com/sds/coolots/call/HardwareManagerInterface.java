package com.sds.coolots.call;

/* loaded from: classes.dex */
public interface HardwareManagerInterface extends SetModeInterface {
    ScreenLockManagerInterface getScreenLockManager();

    SoundManagerInterface getSoundManager();

    void releaseAll(boolean z, boolean z2);
}
