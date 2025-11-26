package com.sec.vip.imagefilter;

/* loaded from: classes.dex */
public class ImageEffectEngineJNI {
    public static native int applyBluewash(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyBright(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyClassic(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyFadedColor(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyFusain(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyGray(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyRetro(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applySepia(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applySoftglow(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVignette(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVintage(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVivid(int[] iArr, int[] iArr2, int i, int i2, int i3);

    static {
        System.loadLibrary("ChatOnAMSImageFilterLibs-1.0.2");
    }
}
