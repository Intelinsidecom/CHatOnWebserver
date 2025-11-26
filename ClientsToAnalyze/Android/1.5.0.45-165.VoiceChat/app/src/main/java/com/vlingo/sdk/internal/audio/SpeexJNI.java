package com.vlingo.sdk.internal.audio;

import android.content.Context;
import com.vlingo.sdk.internal.core.ApplicationAdapter;
import com.vlingo.sdk.internal.settings.Settings;
import java.io.File;

/* loaded from: classes.dex */
public class SpeexJNI {
    private static long nextID;

    /* renamed from: ID */
    private long f3249ID;

    public native int Encode(long j, short[] sArr, byte[] bArr, int i, int i2);

    public native int Initialize(long j, int i, int i2, int i3, int i4, int i5, int i6, float f, float f2, float f3, float f4);

    public SpeexJNI() {
        long j = nextID + 1;
        nextID = j;
        this.f3249ID = j;
    }

    public int initialize(int wb, int quality, int complexity, int vbr, int vad, int useSilenceDetection, float silenceThreshold, float minVoiceDuration, float voicePortion, float minVoiceLevel) {
        return Initialize(this.f3249ID, wb, quality, complexity, vbr, vad, useSilenceDetection, silenceThreshold, minVoiceDuration, voicePortion, minVoiceLevel);
    }

    public int encode(short[] input, byte[] output, int maxOutputLen, int isEnd) {
        return Encode(this.f3249ID, input, output, maxOutputLen, isEnd);
    }

    public static void init() {
        Context context = ApplicationAdapter.getInstance().getApplicationContext();
        File dir = context.getDir(Settings.LIB_PATH, 0);
        String libDirPath = dir.getAbsolutePath();
        System.load(String.valueOf(libDirPath) + "/libogg.so");
        System.load(String.valueOf(libDirPath) + "/libspeex.so");
        System.load(String.valueOf(libDirPath) + "/libSpeexJNI.so");
    }
}
