package com.sec.google.android.mobile1;

import java.io.BufferedInputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class DrmRawContent {

    /* renamed from: a */
    private BufferedInputStream f18595a;

    /* renamed from: b */
    private int f18596b;

    /* renamed from: c */
    private int f18597c;

    /* renamed from: d */
    private String f18598d;

    /* renamed from: e */
    private String f18599e;

    /* renamed from: f */
    private int f18600f;

    private native int nativeConstructDrmContent(InputStream inputStream, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeGetContentLength();

    private native String nativeGetContentType();

    private native int nativeGetDeliveryMethod();

    private native String nativeGetRightsAddress();

    /* JADX INFO: Access modifiers changed from: private */
    public native int nativeReadContent(byte[] bArr, int i, int i2, int i3);

    protected native void finalize();

    public DrmRawContent(InputStream inputStream, int i, String str) throws C5112a {
        int i2;
        this.f18597c = -1;
        this.f18595a = new BufferedInputStream(inputStream, 1024);
        this.f18596b = i;
        if ("application/vnd.oma.drm.message".equals(str)) {
            i2 = 1;
        } else if ("application/vnd.oma.drm.content".equals(str)) {
            i2 = 2;
        } else {
            throw new IllegalArgumentException("mimeType must be DRM_MIMETYPE_MESSAGE or DRM_MIMETYPE_CONTENT");
        }
        if (i <= 0) {
            throw new IllegalArgumentException("len must be > 0");
        }
        this.f18597c = nativeConstructDrmContent(this.f18595a, this.f18596b, i2);
        if (-1 == this.f18597c) {
            throw new C5112a("nativeConstructDrmContent() returned JNI_DRM_FAILURE");
        }
        this.f18598d = nativeGetRightsAddress();
        this.f18600f = nativeGetDeliveryMethod();
        if (-1 == this.f18600f) {
            throw new C5112a("nativeGetDeliveryMethod() returned JNI_DRM_FAILURE");
        }
        this.f18599e = nativeGetContentType();
        if (this.f18599e == null) {
            throw new C5112a("nativeGetContentType() returned null");
        }
    }

    /* renamed from: a */
    public int m19503a() {
        return this.f18600f;
    }

    /* renamed from: a */
    public InputStream m19504a(DrmRights drmRights) {
        if (drmRights == null) {
            throw new NullPointerException();
        }
        return new C5113b(this, drmRights);
    }

    /* renamed from: b */
    public String m19505b() {
        return this.f18599e;
    }

    static {
        try {
            System.loadLibrary("drm1_jni");
        } catch (UnsatisfiedLinkError e) {
            System.err.println("WARNING: Could not load libdrm1_jni.so");
        }
    }
}
