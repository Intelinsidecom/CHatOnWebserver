package com.coolots.chaton.call.controller;

import android.provider.Settings;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class ChatONDrivingMode implements DrivingModeControllerInterface {
    private boolean isDrivingModeOn;

    public static void logI(String message) {
        Log.m2954d("[ChatONDrivingMode]" + message);
    }

    @Override // com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface
    public boolean isDrivingMode() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isOutGoingCall()) {
            logI("isDrivingMode()false outgoing call");
            return false;
        }
        int driving_mode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_on", 0);
        if (driving_mode == 0) {
            this.isDrivingModeOn = false;
        } else {
            this.isDrivingModeOn = true;
        }
        logI("isDrivingMode()??" + this.isDrivingModeOn);
        return this.isDrivingModeOn;
    }

    @Override // com.sds.coolots.common.controller.audiopath.DrivingModeControllerInterface
    public boolean isDrivingModeUI() {
        if (MainApplication.mPhoneManager.getPhoneStateMachine().isOutGoingCall()) {
            logI("isDrivingMode()false outgoing call");
            return false;
        }
        int driving_mode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_on", 0);
        int chatonV_ttsMode = Settings.System.getInt(MainApplication.mContext.getContentResolver(), "driving_mode_chaton_call_notification", 0);
        if (chatonV_ttsMode == 0 || driving_mode == 0) {
            this.isDrivingModeOn = false;
        } else {
            this.isDrivingModeOn = true;
        }
        logI("isDrivingMode()??" + this.isDrivingModeOn);
        return this.isDrivingModeOn;
    }
}
