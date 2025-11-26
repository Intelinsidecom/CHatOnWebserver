package com.sds.coolots.call;

import android.content.Context;

/* loaded from: classes.dex */
public interface SoundManagerInterface extends SetModeInterface {
    boolean isSpeakerOn(Context context);

    void playRingBackTone();

    void restoreSpeakerFor3G();

    void setSpeakerPhone(boolean z);

    void setSpeakerPhoneModeSwitching();

    void simpleVibrate();

    void startPeriodicCallWaitingTone();

    void stopAllStream();

    void stopPeriodicCallWaitingTone();

    void stopRingBackTone();

    void stopRingStream();
}
