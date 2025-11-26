package com.vlingo.sdk.internal.core;

import android.os.Build;

/* loaded from: classes.dex */
public class DeviceWorkarounds {
    public static boolean useVoiceRecognitionAudioPath() {
        return Build.VERSION.SDK_INT >= 7 && !isDeviceHTCIncredible2();
    }

    public static boolean isDeviceHTCIncredible2() {
        return Build.MODEL.equals("ADR6350");
    }
}
