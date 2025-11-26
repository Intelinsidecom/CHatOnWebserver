package com.sds.coolots.call;

import android.os.PowerManager;

/* loaded from: classes.dex */
public interface ScreenLockManagerInterface extends SetModeInterface {
    void acquireLockForProximity();

    void acquireLockForShareScreenProximity();

    void acquirePartialWakeLock(String str);

    void acquireScreenBrightWakeLock(String str);

    void acquireTimeoutLockForConsentDialog(String str);

    PowerManager.WakeLock getWakeLockForConnectedState();

    boolean isProximitySensorActive();

    void releaseLockForEnd();

    void releaseLockForProximity(boolean z);

    void releaseLockForProximityOnlyVideoCall();

    void releasePartialWakeLock(String str);

    void releaseScreenBrightWakeLock(String str);

    void setEarPhoneScreenLock();

    void setEarPhoneScreenLockCallEnd();
}
