package com.vlingo.sdk.internal.audio;

import android.content.Context;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.settings.Settings;
import java.io.File;

/* loaded from: classes.dex */
public class VLSilJNI {
    public native boolean initialize(int i, float f, float f2, float f3, float f4);

    public native int processShortArray(short[] sArr, int i);

    public static void init() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        File dir = context.getDir(Settings.LIB_PATH, 0);
        System.load(String.valueOf(dir.getAbsolutePath()) + "/libVLSilJNI.so");
    }
}
