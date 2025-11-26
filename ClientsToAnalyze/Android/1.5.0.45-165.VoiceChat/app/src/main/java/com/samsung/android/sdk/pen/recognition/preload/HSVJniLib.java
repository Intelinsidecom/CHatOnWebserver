package com.samsung.android.sdk.pen.recognition.preload;

/* loaded from: classes.dex */
public class HSVJniLib {
    public native short jni_HSVAddSignatureModel(int[] iArr, int[] iArr2, char[] cArr, float[] fArr, short s, int i, int i2);

    public native short jni_HSVCheckSignature(int[] iArr, int[] iArr2, char[] cArr, float[] fArr, short s, int i, int i2, int i3);

    public native short jni_HSVClose();

    public native short jni_HSVDelUser(int i);

    public native short jni_HSVInit(String str);

    public native short jni_HSVLoadSignatureModel();

    public native short jni_HSVVerify(int[] iArr, int[] iArr2, char[] cArr, float[] fArr, short s, int i, int i2);
}
