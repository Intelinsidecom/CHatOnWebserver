package com.samsung.spen.engine.signature;

/* loaded from: classes.dex */
public class HSVJniLib {
    public native short jni_HSVAddSignatureModel(int[] iArr, int[] iArr2, char[] cArr, short s, int i, int i2);

    public native short jni_HSVCheckSignature(int[] iArr, int[] iArr2, char[] cArr, short s, int i, int i2, int i3);

    public native short jni_HSVClose();

    public native short jni_HSVDelUser(int i);

    public native short jni_HSVInit(String str);

    public native short jni_HSVLoadSignatureModel();

    public native short jni_HSVVerify(int[] iArr, int[] iArr2, char[] cArr, short s, int i, int i2);

    public HSVJniLib() throws Exception {
        System.loadLibrary("HSV");
    }
}
