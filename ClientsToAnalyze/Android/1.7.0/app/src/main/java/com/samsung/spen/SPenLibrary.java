package com.samsung.spen;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public class SPenLibrary {
    static final boolean REQUIRE_SUPPORTED_DEVICE = false;
    public static final SPenLibraryVersion VERSION = new SPenLibraryVersion(0, 5, 1);

    public static SPenEvent getEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            throw new IllegalArgumentException("Event can't be null.");
        }
        return new SPenEvent(motionEvent, false);
    }

    public static boolean isSupportedDevice() {
        return DeviceModel.IS_SUPPORTED_DEVICE;
    }

    public static String[] getSupportedModels() {
        return DeviceModel.SUPPORTED_MODELS;
    }
}
