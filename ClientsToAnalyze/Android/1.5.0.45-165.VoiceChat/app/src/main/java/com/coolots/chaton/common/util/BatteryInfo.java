package com.coolots.chaton.common.util;

import android.content.Intent;
import android.content.IntentFilter;
import com.sds.coolots.MainApplication;
import com.sds.coolots.common.util.Log;

/* loaded from: classes.dex */
public class BatteryInfo {
    private static final int BATTERY_LOW_LEVEL = 15;
    private static final String CLASSNAME = "[BatteryInfo]";

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private int getBatteryStatus() {
        double level;
        Intent batteryIntent = MainApplication.mContext.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int rawlevel = batteryIntent.getIntExtra("level", -1);
        double scale = batteryIntent.getIntExtra("scale", -1);
        if (rawlevel >= 0 && scale > 0.0d) {
            level = (rawlevel / scale) * 100.0d;
        } else {
            level = 0.0d;
        }
        logI("getBatteryStatus(): " + level);
        return (int) level;
    }

    private Intent getBatteryIntent() {
        IntentFilter ifilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        return MainApplication.mContext.registerReceiver(null, ifilter);
    }

    public boolean isACCharging() {
        Intent batteryStatus = getBatteryIntent();
        int chargePlug = batteryStatus.getIntExtra("plugged", -1);
        boolean charging = chargePlug == 1;
        logI("isACCharging(): " + charging);
        return charging;
    }

    public boolean isUSBCharging() {
        Intent batteryStatus = getBatteryIntent();
        int chargePlug = batteryStatus.getIntExtra("plugged", -1);
        boolean charging = chargePlug == 2;
        logI("isUSBCharging(): " + charging);
        return charging;
    }

    public boolean isCharging() {
        Intent batteryStatus = getBatteryIntent();
        int status = batteryStatus.getIntExtra("status", -1);
        boolean charging = status == 2 || status == 5;
        logI("isCharging(): " + charging);
        return charging;
    }

    public boolean isLowBattery() {
        boolean battery = getBatteryStatus() <= 15;
        logE("isLowBattery(): " + battery);
        return battery;
    }
}
