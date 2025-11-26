package com.coolots.chaton.call.view.layout.voice;

import android.os.PowerManager;
import com.sds.coolots.MainApplication;

/* loaded from: classes.dex */
public class VoiceCallProximityEnd {
    private PowerManager mPowerManager;

    public VoiceCallProximityEnd() {
        this.mPowerManager = null;
        if (this.mPowerManager == null) {
            this.mPowerManager = (PowerManager) MainApplication.mContext.getSystemService("power");
        }
    }

    public void setProximityEndCall() {
        if (this.mPowerManager.isScreenOn()) {
            MainApplication.mPhoneManager.getHardwareManager().getScreenLockManager().releaseLockForProximity(false);
        }
    }
}
