package com.samsung.spen;

import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
class DeviceModel {
    static final String DEVICE_MODEL = Build.PRODUCT;
    static final String[] SUPPORTED_MODELS = {"GT-I9220", "GT-I9221", "GT-N7000"};
    static final boolean IS_SUPPORTED_DEVICE = checkForSupportedDevice();

    DeviceModel() {
    }

    private static boolean checkForSupportedDevice() {
        Log.d("SPen", "Checking for supported device.");
        for (String str : SUPPORTED_MODELS) {
            if (str.equalsIgnoreCase(DEVICE_MODEL)) {
                Log.d("SPen", "Device '" + DEVICE_MODEL + "' is supported.");
                return true;
            }
        }
        Log.d("SPen", "Device '" + DEVICE_MODEL + "' is not supported.");
        return false;
    }
}
