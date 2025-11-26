package com.sec.vip.imagefilter;

/* loaded from: classes.dex */
public class ImageEffectEngineJNI {
    public static native int applyBluewash(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyBlur(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyBright(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyCartoonize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyClassic(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyColorSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyColorize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyDark(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyDownlight(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyFadedColor(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyFusain(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyGray(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyMagicPen(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyMosaic(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyNegative(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyNostalgia(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyOilpaint(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyOldPhoto(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPastelSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPenSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPencilColorSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPencilPastelSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPencilSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPopArt(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyPosterize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyRetro(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applySepia(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applySoftglow(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applySunshine(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVignette(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVintage(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyVivid(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native int applyYellowglow(int[] iArr, int[] iArr2, int i, int i2, int i3);

    static {
        System.loadLibrary("ChatOnAMSImageFilterLibs-1.0.2");
    }
}
