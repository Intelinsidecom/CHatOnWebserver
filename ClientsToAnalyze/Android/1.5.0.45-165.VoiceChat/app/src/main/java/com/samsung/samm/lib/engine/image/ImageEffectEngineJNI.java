package com.samsung.samm.lib.engine.image;

/* loaded from: classes.dex */
public class ImageEffectEngineJNI {
    public static native void applyBluewash(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyBlur(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyBright(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyCartoonize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyClassic(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyColorSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyColorize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyDark(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyDownlight(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyFadedColor(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyFusain(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyGray(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyMagicPen(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyMosaic(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyNegative(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyNostalgia(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyOilpaint(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyOldPhoto(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPastelSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPenSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPencilColorSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPencilPastelSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPencilSketch(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPopArt(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyPosterize(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyRetro(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applySepia(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applySoftglow(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applySunshine(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyVignette(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyVintage(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyVivid(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void applyYellowglow(int[] iArr, int[] iArr2, int i, int i2, int i3);

    public static native void setCheckSupportingModel(char[] cArr, int i);

    static {
        System.loadLibrary("SPenSDKImageFilterLibs");
    }
}
