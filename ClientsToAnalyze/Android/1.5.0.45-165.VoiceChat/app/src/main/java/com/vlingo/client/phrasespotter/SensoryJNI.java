package com.vlingo.client.phrasespotter;

import android.util.Log;

/* loaded from: classes.dex */
public class SensoryJNI {
    public static int GRAMMAR_FORMALITY_DEFAULT = 0;

    public native boolean Initialize(String str, String str2, int i, float f, float f2, float f3, float f4, String str3, int i2);

    public native boolean MakeReady();

    public native int ProcessShortArray(short[] sArr, int i);

    public static void init() {
        try {
            Log.e("SensoryJNI", "Trying to load libWakeUpSensory.so");
            System.loadLibrary("WakeUpSensory");
            Log.e("SensoryJNI", "Loading libWakeUpSensory.so done");
        } catch (Exception e) {
            Log.e("SensoryJNI", "WARNING: Could not load libWakeUpSensory.so");
        }
    }
}
