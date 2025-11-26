package com.sec.google.android.mobile1;

/* loaded from: classes.dex */
public class DrmRights {

    /* renamed from: a */
    private String f18601a = "";

    private native int nativeConsumeRights(int i);

    /* renamed from: a */
    public boolean m19506a(int i) {
        return -1 != nativeConsumeRights(i);
    }

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
}
