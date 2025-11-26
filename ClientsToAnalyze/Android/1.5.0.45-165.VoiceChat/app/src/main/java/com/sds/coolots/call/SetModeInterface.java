package com.sds.coolots.call;

/* loaded from: classes.dex */
public interface SetModeInterface {
    void setModeBusy();

    void setModeCalling(boolean z, boolean z2);

    void setModeConnected(boolean z);

    void setModeConnectedFor3GIdleMode(boolean z);

    void setModeDisconnected(boolean z);

    void setModeError(boolean z);

    void setModeForMinuteMinder(boolean z);

    void setModeStartHold();

    void setModeStopHold(boolean z);
}
