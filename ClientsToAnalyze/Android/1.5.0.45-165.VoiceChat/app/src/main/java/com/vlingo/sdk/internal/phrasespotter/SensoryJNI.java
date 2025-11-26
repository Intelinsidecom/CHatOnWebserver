package com.vlingo.sdk.internal.phrasespotter;

import android.content.Context;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.settings.Settings;
import java.io.File;

/* loaded from: classes.dex */
public class SensoryJNI {
    public static int GRAMMAR_FORMALITY_DEFAULT = 0;

    public native void Deinitialize();

    public native float GetLastScore();

    public native boolean Initialize(String str, String str2, int i, float f, float f2, float f3, float f4, String str3, int i2);

    public native boolean InitializePhrases(String str, String str2, String str3, String[] strArr, String[] strArr2, int i, float f, float f2, float f3, float f4, String str4, int i2);

    public native boolean MakeReady();

    public native String ProcessShortArray(short[] sArr, int i);

    public static void init() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        File dir = context.getDir(Settings.LIB_PATH, 0);
        System.load(String.valueOf(dir.getAbsolutePath()) + "/libsensory.so");
    }
}
